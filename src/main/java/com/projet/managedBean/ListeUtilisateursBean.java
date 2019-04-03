package com.projet.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;
import com.projet.utils.DAOUtils;

@ManagedBean
@ViewScoped
public class ListeUtilisateursBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Utilisateur> listeUtilisateurs;
	private IUtilisateurDAO utilisateurDAO;
	
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
	
	public String supprimerUtilisateur(Utilisateur utilisateur) {
		utilisateurDAO.delete(utilisateur.getId());
		return "listeUtilisateurs";
	}
	
	
}
