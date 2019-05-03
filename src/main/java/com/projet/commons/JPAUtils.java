package com.projet.commons;

import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static com.projet.dao.DAOFactory.*;

import com.projet.dao.DAOConfigurationException;

public class JPAUtils {

	private static EntityManagerFactory emf;
	private static final String PU = "GamesCornerV2_PU";
	private static final String FICHIER_JDBC = "com/projet/properties/db.properties";
	private static final String FICHIER_HIBERNATE = "/com/projet/properties/hibernate.properties";
	private static final String FICHIER_JPA = "/com/projet/properties/jpa.properties";
	
	
	public static EntityManagerFactory getEntityManagerFactory() throws DAOConfigurationException, IOException {
		
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream fichierJdbc = cl.getResourceAsStream(FICHIER_JDBC);
		InputStream fichierHibernate = cl.getResourceAsStream(FICHIER_HIBERNATE);
		InputStream fichierJpa = cl.getResourceAsStream(FICHIER_JPA);
		
		if (fichierJdbc == null) {
			throw new DAOConfigurationException("Le fichier " + FICHIER_JDBC + " est introuvable.");
		}

		if (fichierHibernate == null) {
			throw new DAOConfigurationException("Le fichier " + FICHIER_HIBERNATE + " est introuvable.");
		}
		if (fichierJpa == null) {
			throw new DAOConfigurationException("Le fichier " + FICHIER_JPA + " est introuvable.");
		}
		
		return emf = getEMF(PU, fichierJpa, fichierJdbc, fichierHibernate);
	}
	
	public static EntityManagerFactory getEntityManagerFactorySansFiles() {
		return emf = getEMF(PU);
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager(); 
	}
	
	public static void close() {
		emf.close();
	}
}
