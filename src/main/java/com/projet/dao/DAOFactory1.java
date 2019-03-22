package com.projet.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {

	private static final String FICHIER_JDBC = "../resources/com/projet/properties/db.properties";
	private static final String FICHIER_HIBERNATE = "../resources/com/projet/properties/hibernate.properties";
	private static final String PROPERTY_URL = "javax.persistence.jdbc.url";	
	private static final String PROPERTY_JDBC_URL = "jdbc.url";
	private static final String PROPERTY_DRIVER = "javax.persistence.jdbc.driver";	
	private static final String PROPERTY_UTILISATEUR = "javax.persistence.jdbc.user";	
	private static final String PROPERTY_MOT_DE_PASSE = "javax.persistence.jdbc.password";	
	private static final String PROPERTY_HIBERNATE_DIALECT = "hibernate.dialect";	
	private static final String PROPERTY_HIBERNATE_SQL = "hibernate.show_sql";	
//	private static final String PROPERTY_HIBERNATE_HBM2DDL = "javax.persistence.schema-generation.database.action";	
	
	
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
		
		Map<String, String> properties = new HashMap<String, String>();
		
		try {
		props.load(fichierJdbc);
		properties.put(PROPERTY_URL, props.getProperty(PROPERTY_URL));
		
		
		
//		properties
		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger les fichiers de propriétés", e);
		}
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamesCornerV2_PU", properties);
		
		
	}
	
}
