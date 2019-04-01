package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;

import com.projet.dao.AbstractDAO;
import com.projet.dao.DAOFactory;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;
import com.projet.utils.DAOUtils;

public class UtilisateurDAOImpl extends AbstractDAO implements IUtilisateurDAO {
	
	public UtilisateurDAOImpl() {
		super();
	}

	@Override
	public Utilisateur find(Integer id) {
		super.initOperation();
		Utilisateur utilisateur = super.em.find(Utilisateur.class, id);
		super.em.close();
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAll() {
		super.initOperation();
		super.em.close();
		return null;
	}

	@Override
	public void add(Utilisateur utilisateur) {
		super.initOperation();
		super.em.persist(utilisateur);
		super.em.getTransaction().commit();
		super.em.close();
	}

	@Override
	public void delete(Integer id) {
		super.initOperation();
		Utilisateur utilisateur = super.em.find(Utilisateur.class, id);
		super.em.remove(utilisateur);
		super.em.getTransaction().commit();
		super.em.close();
	}

	@Override
	public void update(Utilisateur entity) {
		super.initOperation();
		super.em.getTransaction().commit();
		super.em.close();
	}
	
}
