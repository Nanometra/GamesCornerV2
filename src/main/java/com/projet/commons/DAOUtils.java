package com.projet.commons;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;

import com.projet.dao.IArticleDAO;
import com.projet.dao.IUtilisateurDAO;
import com.projet.dao.impl.ArticleDAOImpl;
import com.projet.dao.impl.UtilisateurDAOImpl;

public class DAOUtils {
	
	private DAOUtils() {
		super();
	}

	private static final String ATT_EMF = "emf";	

	// Créer un entity manager à partir d'un entitymanagerFactory
	public static EntityManager getEntityManager(EntityManagerFactory emf) {
		return emf.createEntityManager();
	}
	
	// Récupère l'attribut EMF passé dans le listener
	public static EntityManagerFactory getEMFAttribut() {
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
		return (EntityManagerFactory) ctx.getAttribute(ATT_EMF);
	}
	
	// Récupère les implémentations des différentes DAO.
	
	public static IArticleDAO getArticleDAO() {
		return new ArticleDAOImpl();
	}
	
	public static IUtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
