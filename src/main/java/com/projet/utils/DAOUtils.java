package com.projet.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import com.projet.dao.IArticleDAO;
import com.projet.dao.IUtilisateurDAO;
import com.projet.dao.impl.ArticleDAOImpl;
import com.projet.dao.impl.UtilisateurDAOImpl;

public class DAOUtils {

	private static DataSource ds;
	private static ServletContext ctx;
	

	// Créer un entity manager à partir d'un entitymanagerFactory
	public static EntityManager getEntityManager(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		return em;
	}

//	public static Connection getConnexion() throws SQLException {
//		// Récupération de la Connection depuis la DataSrouce 
//		return ds.getConnection();
//	}
	
	// Récupère les implémentations des différentes DAO.

	public static IArticleDAO getArticleDAO() {
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getAttribute("emf");
		return new ArticleDAOImpl(emf, getEntityManager(emf));
	}
	
	public static IUtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
