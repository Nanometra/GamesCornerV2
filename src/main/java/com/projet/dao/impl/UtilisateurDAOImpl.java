package com.projet.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.projet.dao.AbstractDAO;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;

public class UtilisateurDAOImpl extends AbstractDAO implements IUtilisateurDAO {

	public UtilisateurDAOImpl() {
		super();
	}

	@Override
	public Utilisateur find(Integer id) {
		super.initOperation();
		Utilisateur utilisateur = super.em.find(Utilisateur.class, id);
		em.close();
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		
		try {
			super.initOperation();
//			CriteriaBuilder builder = em.getCriteriaBuilder();
//			CriteriaQuery<Utilisateur> query = builder.createQuery(Utilisateur.class);
//			Root<Utilisateur> listeUtilisateurs = query.from(Utilisateur.class);
//			query.select(listeUtilisateurs);
			
			Query query = em.createQuery("SELECT u FROM Utilisateur u");
			
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Integer id) {
		super.initOperation();
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.remove(utilisateur);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Utilisateur entity) {
		super.initOperation();
		em.getTransaction().commit();
		em.close();
	}

}
