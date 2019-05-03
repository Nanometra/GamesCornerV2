package com.projet.listener;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.projet.commons.JPAUtils;
import com.projet.dao.DAOConfigurationException;

// Classe Listener qui se charge lorsque le serveur est allumé
@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {

	private static EntityManagerFactory emf;
	private EntityManagerFactory test;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		
		try {
			this.emf = JPAUtils.getEntityManagerFactory();
			ctx.setAttribute("emf", emf);
//			test = (EntityManagerFactory) ctx.getAttribute("emf");
//			// Récupération de la connexion depuis la DataSource
		} catch (DAOConfigurationException | IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		emf.close();
		ctx.removeAttribute("emf");
	}

	public static EntityManager createEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Le contexte n'est pas encore initialisé.");
		} 
		return emf.createEntityManager();
	}
	
}
