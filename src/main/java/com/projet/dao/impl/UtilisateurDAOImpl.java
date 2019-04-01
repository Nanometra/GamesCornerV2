package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;

import com.projet.dao.DAOFactory;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;
import com.projet.utils.DAOUtils;

public class UtilisateurDAOImpl implements IUtilisateurDAO {
	
//	@PersistenceUnit(unitName="GamesCornerV2_PU")
	private EntityManagerFactory emf;
//	@PersistenceContext(unitName="GamesCornerV2_PU")
	private EntityManager em;
	private ServletContext ctx;
	
	public UtilisateurDAOImpl() {
		super();
//		emf = DAOFactory.getEMF(PU);
		emf = DAOUtils.getEMFAttribut();
	}
	
	private void initEntityManager(EntityManagerFactory emf) {
		em = DAOUtils.getEntityManager(emf);
//		em = Persistence.createEntityManagerFactory(PU).createEntityManager();
	}

	@Override
	public Utilisateur find(Integer id) {
		initEntityManager(emf);
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.close();
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAll() {
		initEntityManager(emf);
		em.close();
		return null;
	}

	@Override
	public void add(Utilisateur utilisateur) {
		initEntityManager(emf);
		em.getTransaction().begin();
		em.persist(utilisateur);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Integer id) {
		initEntityManager(emf);
		em.getTransaction().begin();
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.remove(utilisateur);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Utilisateur entity) {
		
	}
	
	

}
