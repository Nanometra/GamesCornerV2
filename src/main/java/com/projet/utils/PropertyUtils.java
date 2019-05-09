package com.projet.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	private static Properties load(String filename) throws IOException, FileNotFoundException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(filename);
		
		try {
			properties.load(fis);
			return properties;
		} finally {
			fis.close();
		}
	}
	
}
