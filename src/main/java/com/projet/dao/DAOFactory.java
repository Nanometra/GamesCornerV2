package com.projet.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
//	private static final String FICHIER_JDBC = "../resources/com/projet/properties/db.properties";
//	private static final String FICHIER_HIBERNATE = "../resources/com/projet/properties/hibernate.properties";
//	private static final String PROPERTY_URL = "javax.persistence.jdbc.url";
//	private static final String PROPERTY_JDBC_URL = "jdbc.url";
//	private static final String PROPERTY_DRIVER = "javax.persistence.jdbc.driver";
//	private static final String PROPERTY_JDBC_DRIVER = "jdbc.driver";
//	private static final String PROPERTY_UTILISATEUR = "javax.persistence.jdbc.user";
//	private static final String PROPERTY_JDBC_UTILISATEUR = "jdbc.username";
//	private static final String PROPERTY_MOT_DE_PASSE = "javax.persistence.jdbc.password";
//	private static final String PROPERTY_JDBC_MOT_DE_PASSE = "jdbc.password";
//	private static final String PROPERTY_DIALECT = "hibernate.dialect";
//	private static final String PROPERTY_HIBERNATE_SQL = "hibernate.show_sql";
//	private static final String PROPERTY_HIBERNATE_HBM2DDL = "javax.persistence.schema-generation.database.action";	
//	private static final String PROPERTY_HBM2DDL = "hbm2ddl.auto";	

	public static EntityManagerFactory getEMF(String PU, InputStream fichierBase, InputStream... inputStreams)
			throws DAOConfigurationException {
		Properties props = new Properties();

		Map<String, String> properties = new HashMap<String, String>();
		Map<Integer, String> keys = new HashMap<Integer, String>();
		Map<Integer, String> value = new HashMap<Integer, String>();
		Map<Integer, String> concat = new HashMap<Integer, String>();

		try {
			// Chargement du fichier contenant le nom des propriétés.
			props.load(fichierBase);
			keys = getListeValeur(props, keys);
			
			props = new Properties();
			
			for (int i = 0; i < inputStreams.length; i++) {
				props.load(inputStreams[i]);

				value = getListeValeur(props, value);
				props = new Properties();
			}

			properties = getProperties(keys, value, properties);

//			properties.put(PROPERTY_DRIVER, props.getProperty(PROPERTY_JDBC_DRIVER));
//			properties.put(PROPERTY_URL, props.getProperty(PROPERTY_JDBC_URL));
//			properties.put(PROPERTY_UTILISATEUR, props.getProperty(PROPERTY_JDBC_UTILISATEUR));
//			properties.put(PROPERTY_MOT_DE_PASSE, props.getProperty(PROPERTY_JDBC_MOT_DE_PASSE));

			// Fichier hibernate.properties
//			props.load(inputStreams[1]);
//
//			keys = getListeCle(props);
//			value = getListeValeur(props);
//			
//			properties = getProperties(keys, value, properties);

//			properties.put(PROPERTY_DIALECT, props.getProperty(PROPERTY_DIALECT));
//			properties.put(PROPERTY_HIBERNATE_SQL, props.getProperty(PROPERTY_HIBERNATE_SQL));
//		properties.put(PROPERTY_HIBERNATE_HBM2DDL, props.getProperty(PROPERTY_HBM2DDL));

		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger les fichiers de propriétés", e);
		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU, properties);

		return emf;
	}

	// Méthode utilisée au sein de la classe permettant de récupérer les noms de
	// chaques propriétés
//	private static Map<Integer, String> getListeCle(Properties props) {
//		// Récupération des clés du fichier properties correspondant
//		Set<Object> clefs = props.keySet();
//		Iterator it = clefs.iterator();
//		// Map qui va récupérer toutes les clés
//		Map<Integer, String> keys = new HashMap<Integer, String>();
//		Object elem;
//		int i = 0;
//		while (it.hasNext()) {
//			elem = it.next();
//			keys.put(i, (String) elem);
//			i++;
//		}
//
//		return keys;
//	}

	// Méthode au sein de la classe qui permet de récupérer les valeurs de chaques
	// propriétés
	private static Map<Integer, String> getListeValeur(Properties props, Map<Integer, String> value) {
		int taille = props.size();
		Enumeration<Object> valeurs = props.elements();
		int i = 0;
		if (value.size() == 0) {
			i = 0;
		} else {
			i = value.size();
		}

		while (valeurs.hasMoreElements()) {
			value.put(i, (String) valeurs.nextElement());
			i++;
		}

		return value;
	}

	private static Map<String, String> getProperties(Map<Integer, String> keys, Map<Integer, String> value,
			Map<String, String> properties) {

		if (keys.size() == value.size()) {
			if (keys.size() == value.size()) {
				for (int i = properties.size(); i < keys.size(); i++) {
					properties.put(keys.get(i), value.get(i));
				}
			} else {
				throw new DAOConfigurationException("La taille des 2 Map n'est pas la même.");
			}
		}

		return properties;
	}

}
