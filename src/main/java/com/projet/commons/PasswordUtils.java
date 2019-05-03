package com.projet.commons;

import java.util.Arrays;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordUtils.class);   
	// Defini la charge de travail de BCrypt à utiliser lors de la génération des hashs de mots de passe. 
	// 10-31 (tranche de valeurs possibles).
	private static final int workload = 12; 
	
	// Générateur de mot de passe random
	public static String generateRandomPassword() {
		// Liste de règles qui vont s'appliquer aux mots de passe.
		List regles = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1), new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1), new CharacterRule(EnglishCharacterData.Special, 1));
		
		PasswordGenerator generateur = new PasswordGenerator();		
		String password = generateur.generatePassword(8, regles);
		
		return password;
	}
	
	// Hashage du mot de passe
	public static String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(workload));
	}
	
	// Vérifier les mots de passe 
	public static void checkPassword(String plainPassword, String hashedPassword) {
		if (null == hashedPassword || !hashedPassword.startsWith("$2a$")) {
			throw new IllegalArgumentException("Le hash produit est invalide.");
		}
		
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			LOGGER.info("Le mot de passe est valide.");
		} else {
			LOGGER.error("Le mot de passe n'est pas valide.");
		}
	}
		
}
