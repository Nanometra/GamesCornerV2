package com.projet.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;

import com.projet.dao.DAOConfigurationException;
import com.projet.dao.DAOFactory;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;
import com.projet.utils.DAOUtils;
import com.projet.utils.JPAUtils;

public class UtilisateurDAOImpl implements IUtilisateurDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
//	private ServletContext ctx;
	
	public UtilisateurDAOImpl() {
		super();
		try {
			this.emf = JPAUtils.getEntityManagerFactory();
		} catch (DAOConfigurationException | IOException e) {
			e.printStackTrace();
		}
		this.em = DAOUtils.getEntityManager(emf);
	}

	@Override
	public Utilisateur find(Integer id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.close();
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAll() {
		
		em.close();
		return null;
	}

	@Override
	public void add(Utilisateur utilisateur) {
		em.persist(utilisateur);
		em.close();
	}

	@Override
	public void delete(Integer id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.remove(utilisateur);
		em.close();
	}

	@Override
	public void update(Utilisateur entity) {
		
	}

}
