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
		List cles = new ArrayList();

		try {
			// Chargement du fichier contenant le nom des propriétés.
			props.load(fichierBase);
			keys = getListeValeur(props, keys, cles);

			props.clear();

			concat = mergeFichiers(props, cles, inputStreams);

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
	private static Map<Integer, String> getListeValeur(Properties props, Map<Integer, String> value, List cles) {

		List keys = trierMap(props, cles);

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
	private static List trierMap(Properties props, List cles) {
		// Range les clés dans leur ordre de hashage
		if (cles.isEmpty()) {
			cles = new ArrayList(props.keySet());
			Collections.sort(cles);
		} else {
			for (int i = 0 ; i < cles.size() ; i++) {
				cles.add(cles.get(i));
			}
			Collections.sort(cles);
		}
		
		return cles;
	}

	// Méthode qui permet de merger les données de plusieurs fichiers de propriétés
	// et de les trier selon leur ordre de hashage.
	private static Map<Integer, String> mergeFichiers(Properties props, List cles,
			InputStream... inputStream) throws IOException {

		Map<Integer, String> value = new HashMap<Integer, String>();

		for (int i = 0 ; i < inputStream.length ; i++) {
			props.load(inputStream[i]);
		}
		
		value = getListeValeur(props, value, cles);
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

}
