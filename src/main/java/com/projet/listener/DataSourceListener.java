package com.projet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
public class DataSourceListener implements ServletContextListener {

//	private static final String PATH = "java:comp/env/ds/GamesCornerV2";
//	private DataSource ds;
//	
//	@Override
	public void contextInitialized(ServletContextEvent event) {
//		try {	
//		// Récupération de la datasource
//			Context initCtx = new InitialContext();
//			ds = (DataSource) initCtx.lookup(PATH);
//		} catch (Exception e) {
//			e.printStackTrace(); 
//		}
//		
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Pas besoin de remplir cette méthode
	}

}
