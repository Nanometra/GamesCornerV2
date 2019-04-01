package com.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.projet.utils.DAOUtils;

public abstract class AbstractDAO {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public AbstractDAO() {
		super();
		this.emf = DAOUtils.getEMFAttribut();
	}

	protected void initOperation() {
		this.em = DAOUtils.getEntityManager(emf);
		em.getTransaction().begin();
	}
	
}
