package com.projet.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class DAOUtils {

	private static DataSource ds;

	// Créer un entity manager à partir d'un entitymanagerFactory
	public static EntityManager getEntityManager(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public static Connection getConnexion() throws SQLException {
		// Récupération de la Connection depuis la DataSrouce 
		return ds.getConnection();
	}

}
