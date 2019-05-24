package com.projet.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.projet.commons.DAOUtils;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;

@ManagedBean
@RequestScoped
public class InfoUtilisateurBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FacesContext fc;
	
	private Utilisateur utilisateur;
	private IUtilisateurDAO utilisateurDAO;
	
	public InfoUtilisateurBean() {
		super();
		this.utilisateurDAO = DAOUtils.getUtilisateurDAO(); 
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
	
//	@PostConstruct
//	public String afficherUtilisateur(Utilisateur utilisateur) {
//		String information = (String) fc.getExternalContext().getRequestParameterMap().get("listeUtilisateur:param.utilisateur_id");
//		int id = Integer.parseInt(information);
//		
//		utilisateur = utilisateurDAO.find(id);
//		
//		
//		return "Succes";
//	}

}
