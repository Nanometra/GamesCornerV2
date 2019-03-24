package com.projet.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {

	public static EntityManagerFactory getEMF(String PU, InputStream fichierBase, InputStream... inputStreams)
			throws DAOConfigurationException, IOException {
		Properties props = new Properties();

		Map<String, String> properties = new HashMap<String, String>();
		Map<Integer, String> keys = new HashMap<Integer, String>();
		Map<Integer, String> value = new HashMap<Integer, String>();

		try {
			// Chargement du fichier contenant le nom des propriétés.
			props.load(fichierBase);
			keys = getListeValeur(props, keys);

			props.clear();

			for (int i = 0; i < inputStreams.length; i++) {
				props.load(inputStreams[i]);

				value = getListeValeur(props, value);
				props.clear();
			}

			properties = getProperties(keys, value, properties);

		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger les fichiers de propriétés", e);
		} finally {
			fichierBase.close();
			for (int i = 0; i < inputStreams.length; i++) {
				inputStreams[i].close();
			}
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
//		Set<Entry<Object, Object>> valeurs = props.entrySet();
//		Enumeration<Object> valeurs = props.elements();
		List keys = new ArrayList(props.keySet());
		Collections.sort(keys);

		int i = 0;
		if (value.size() == 0) {
			i = 0;
		} else {
			i = value.size();
		}

		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			value.put(i, (String) props.getProperty(key));
			i++;
		}

		return value;
	}

//	private static Map<Integer, String> mergeFichiers(Properties props,
//			InputStream... inputStream) throws IOException {
//
//		Map<Integer, String> concat = new HashMap<Integer, String>();
//		Map<Integer, String> value = new HashMap<Integer, String>();
//		
//		for (int i = 0; i < inputStream.length; i++) {
//			props.load(inputStream[i]);
//			value = props.e
//			for (int j = concat.size(); j < value.length; i++) {
//				
//			}
//			props.clear();
//		}
//		return null;
//	}

	private static Map<String, String> getProperties(Map<Integer, String> keys, Map<Integer, String> value,
			Map<String, String> properties) {

		if (keys.size() == value.size()) {
			if (keys.size() == value.size()) {
				for (int i = properties.size() ; i < keys.size(); i++) {
					properties.put(keys.get(i), value.get(i));
				}
			} else {
				throw new DAOConfigurationException("La taille des 2 Map n'est pas la même.");
			}
		}

		return properties;
	}

}
