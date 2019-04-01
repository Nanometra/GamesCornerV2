package com.projet.managedBean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Client;
import com.projet.entites.Utilisateur;
import com.projet.utils.DAOUtils;

@ManagedBean
@SessionScoped
public class InscriptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Utilisateur utilisateur;
	private IUtilisateurDAO utilisateurDAO;
	
	public InscriptionBean() {
		utilisateur = new Client();
		utilisateurDAO = DAOUtils.getUtilisateurDAO();
	}
	
	@PostConstruct
	public void init() {
		utilisateur = new Client();
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public String inscrire() {
		initialiserDateInscription();
		utilisateurDAO.add(utilisateur);
		return "succes";
	}
	
	private void initialiserDateInscription() {
		Date dateInscription = new Date(System.currentTimeMillis());
		utilisateur.setDateInscription(dateInscription);
	}
	
}
