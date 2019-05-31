package com.projet.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.projet.commons.DAOUtils;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;

@ManagedBean
@ViewScoped
public class ListeUtilisateursBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Utilisateur> listeUtilisateurs;
	private transient IUtilisateurDAO utilisateurDAO;
	private FacesContext fc;
	
	public ListeUtilisateursBean() {
		super();
		this.utilisateurDAO = DAOUtils.getUtilisateurDAO();
	}
	
	@PostConstruct
	public void init() {
		listeUtilisateurs = utilisateurDAO.findAll();
	}

	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}

	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	
	public Utilisateur afficherUtilisateur() {
		String information = fc.getExternalContext().getRequestParameterMap().get("listeUtilisateur:param.id");
		int utilisateurId = Integer.parseInt(information);
				
		return utilisateurDAO.find(utilisateurId);
	}
	
	public String supprimerUtilisateur(Utilisateur utilisateur) {
		utilisateurDAO.delete(utilisateur.getId());
		return "listeUtilisateurs";
	}
	
	public void modifierUtilisateur(Utilisateur utilisateur) {
		// TODO Pas encore implémenté
	}
	
}
