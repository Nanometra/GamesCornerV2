package com.projet.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {

	private static final String FICHIER_JDBC = "../resources/com/projet/properties/db.properties";
	private static final String FICHIER_HIBERNATE = "../resources/com/projet/properties/hibernate.properties";
	private static final String PROPERTY_URL = "hibernate.connection.url";	
	private static final String PROPERTY_DRIVER = "hibernate.connection.driver_class";	
	private static final String PROPERTY_UTILISATEUR = "hibernate.connection.url";	
	
	
	public static DAOFactory getInstance() throws DAOConfigurationException {
		Properties props = new Properties();
		
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream fichierJdbc = cl.getResourceAsStream(FICHIER_JDBC);
		InputStream fichierHibernate = cl.getResourceAsStream(FICHIER_HIBERNATE);
		
		if (fichierJdbc == null) {
			throw new DAOConfigurationException("Le fichier " + FICHIER_JDBC + " est introuvable."); 
		}
		
		if (fichierHibernate == null) {
			throw new DAOConfigurationException("Le fichier " + FICHIER_HIBERNATE + " est introuvable."); 
		}
		
		props.load();
		
		Map<String, String> properties = new HashMap<String, String>();
//		properties
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamesCornerV2_PU", properties);

	}
	
}
