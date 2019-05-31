package com.projet.listener;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projet.commons.JPAUtils;
import com.projet.dao.DAOConfigurationException;

// Classe Listener qui se charge lorsque le serveur est allumé
@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {

	private static EntityManagerFactory emf;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalEntityManagerFactory.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		
		try {
			emf = JPAUtils.getEntityManagerFactory();
			ctx.setAttribute("emf", emf);
		} catch (DAOConfigurationException | IOException e) {
			LOGGER.error(e.getMessage());
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
