package com.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.projet.commons.DAOUtils;

public abstract class AbstractDAO {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	
	public AbstractDAO() {
		super();
		this.emf = DAOUtils.getEMFAttribut();
	}

	protected void initOperation() {
		em = DAOUtils.getEntityManager(emf);
		tx = em.getTransaction();
		tx.begin();
	}
	
}
