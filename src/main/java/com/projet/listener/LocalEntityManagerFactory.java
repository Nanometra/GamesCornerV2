package com.projet.listener;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.projet.dao.DAOConfigurationException;
import com.projet.utils.JPAUtils;

// Classe Listener qui se charge lorsque le serveur est allumé
@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {

	private static EntityManagerFactory emf;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
//		emf = Persistence.createEntityManagerFactory("GamesCornerV2_PU");
		try {
			emf = JPAUtils.getEntityManagerFactory();
		} catch (DAOConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		emf.close();
	}

	public static EntityManager createEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Le contexte n'est pas encore initialisé.");
		} 
		return emf.createEntityManager();
	}
	
}
