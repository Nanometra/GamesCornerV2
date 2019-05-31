package com.projet.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projet.dao.AbstractDAO;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;

public class UtilisateurDAOImpl extends AbstractDAO implements IUtilisateurDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurDAOImpl.class);	
	
	public UtilisateurDAOImpl() {
		super();
	}

	@Override
	public Utilisateur find(Integer id) {
		super.initOperation();
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.close();
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();

		try {
			super.initOperation();

			Query query = em.createQuery("SELECT u FROM Utilisateur u");
			listeUtilisateurs = query.getResultList();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return listeUtilisateurs;
	}

	@Override
	public void add(Utilisateur utilisateur) {
		try {
			super.initOperation();
			em.persist(utilisateur);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			super.initOperation();
			Utilisateur utilisateur = em.find(Utilisateur.class, id);
			em.remove(utilisateur);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void update(Utilisateur entity) {
		super.initOperation();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Utilisateur> findByEmail(String email) {
		super.initOperation();
		
		Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.email =:email");
		query.setParameter("email", email);
		List<Utilisateur> listeUtilisateur = (List<Utilisateur>) query.getResultList();
		
		em.close();
		return listeUtilisateur;
	}

}
