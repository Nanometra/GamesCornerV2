package com.projet.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {

	public static EntityManagerFactory getEMF(String PU, InputStream fichierBase, InputStream... inputStreams)
			throws DAOConfigurationException, IOException {
		Properties props = new Properties();

		Map<String, String> properties = new HashMap<String, String>();
		Map<Integer, String> keys = new HashMap<Integer, String>();
		Map<Integer, String> concat = new HashMap<Integer, String>();

		try {
			// Chargement du fichier contenant le nom des propriétés.
			props.load(fichierBase);
			keys = getListeValeur(props, keys);

			props.clear();

			concat = mergeFichiers(props, inputStreams);

			properties = getProperties(keys, concat, properties);

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
	
	/*
	 *  ================================== Méthodes utilisées uniquement dans la classe ==================================
	 */
	
	// Méthode au sein de la classe qui permet de récupérer les valeurs de chaques
	// propriétés
	private static Map<Integer, String> getListeValeur(Properties props, Map<Integer, String> value) {

		List keys = trierMap(props);

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

	// Permet de trier les propriétés selon leur hashage
	private static List trierMap(Properties props) {
		// Range les clés dans leur ordre de hashage
		List cles = new ArrayList(props.keySet());
		Collections.sort(cles);

		return cles;
	}

	// Méthode qui permet de merger les données de plusieurs fichiers de propriétés
	// et de les trier selon leur ordre de hashage.
	private static Map<Integer, String> mergeFichiers(Properties props, InputStream... inputStream)
			throws IOException {

		Map<Integer, String> value = new HashMap<Integer, String>();

		for (int i = 0; i < inputStream.length; i++) {
			props.load(inputStream[i]);
		}

		value = getListeValeur(props, value);
		props.clear();

		return value;
	}

	private static Map<String, String> getProperties(Map<Integer, String> keys, Map<Integer, String> concat,
			Map<String, String> properties) {

		if (keys.size() == concat.size()) {
			if (keys.size() == concat.size()) {
				for (int i = properties.size(); i < keys.size(); i++) {
					properties.put(keys.get(i), concat.get(i));
				}
			} else {
				throw new DAOConfigurationException("La taille des 2 Map n'est pas la même.");
			}
		}

		return properties;
	}
	
	/*
	 * ==================================================================================================================
	 */

	
	
}
