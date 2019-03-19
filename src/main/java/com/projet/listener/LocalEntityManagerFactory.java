package com.projet.listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {

	private static EntityManagerFactory emf;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		emf = Persistence.createEntityManagerFactory("GamesCornerV2_PU");
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
