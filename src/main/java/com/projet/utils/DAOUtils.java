package com.projet.utils;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import com.projet.dao.IArticleDAO;
import com.projet.dao.IUtilisateurDAO;
import com.projet.dao.impl.ArticleDAOImpl;
import com.projet.dao.impl.UtilisateurDAOImpl;

public class DAOUtils {

	private static final String ATT_EMF = "emf";
	private static DataSource ds;	
	

	// Créer un entity manager à partir d'un entitymanagerFactory
	public static EntityManager getEntityManager(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		return em;
	}

//	public static Connection getConnexion() throws SQLException {
//		// Récupération de la Connection depuis la DataSrouce 
//		return ds.getConnection();
//	}
	
	// Récupère l'attribut EMF passé dans le listener
	public static EntityManagerFactory getEMFAttribut() {
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
//		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
//		EntityManagerFactory emf = (EntityManagerFactory) requestMap.get("emf");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getAttribute(ATT_EMF);
		
		return emf;
	}
	
	// Récupère les implémentations des différentes DAO.
	
	public static IArticleDAO getArticleDAO() {
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getAttribute("emf");
		return new ArticleDAOImpl(emf, getEntityManager(emf));
	}
	
	public static IUtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
