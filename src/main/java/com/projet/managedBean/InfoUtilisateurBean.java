package com.projet.managedBean;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
		
	private Utilisateur utilisateur;
	private transient IUtilisateurDAO utilisateurDAO;
	
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
	
	public Utilisateur afficherUtilisateur() throws IOException {
		String information = getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		int utilisateurId = Integer.parseInt(information);
		
		getCurrentInstance().getExternalContext().redirect("infoUtilisateur.xhtml?id=" + utilisateurId);
		
		return utilisateurDAO.find(utilisateurId);
	}

}
