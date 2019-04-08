package com.projet.dao;

import java.sql.SQLException;
import java.util.List;

import com.projet.entites.Utilisateur;

public interface IUtilisateurDAO extends IGeneriqueDAO<Utilisateur> {

	List<Utilisateur> findByEmail(String email);
}
