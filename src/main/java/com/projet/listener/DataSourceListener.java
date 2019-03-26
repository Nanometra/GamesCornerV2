package com.projet.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class DataSourceListener implements ServletContextListener {

	private static final String PATH = "java:comp/env/ds/GamesCornerV2";
	private DataSource ds;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {	
		// Récupération de la datasource
			Context initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup(PATH);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
