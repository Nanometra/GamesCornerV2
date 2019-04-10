package com.projet.managedBean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;

import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Client;
import com.projet.entites.Utilisateur;
import com.projet.utils.DAOUtils;

@ManagedBean(name = "inscriptionBean")
@RequestScoped
public class InscriptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur utilisateur;
	private IUtilisateurDAO utilisateurDAO;
	private FacesMessage message;
	private FacesContext fc;
	
	public InscriptionBean() {
		utilisateur = new Client();
		utilisateurDAO = DAOUtils.getUtilisateurDAO();
		fc = FacesContext.getCurrentInstance();
	}

//	@PostConstruct
//	public void init() {
//		utilisateur = new Client();
//	}

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
		FacesMessage message = new FacesMessage("Succès de l'inscription");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "succes";
	}

	private void initialiserDateInscription() {
		Date dateInscription = new Date(System.currentTimeMillis());
		utilisateur.setDateInscription(dateInscription);
	}

	public void validateNom(ComponentSystemEvent event) {
		String nom = (String) findComponent(event, "nom");		
		
		if (nom == null || nom.isEmpty()) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir votre nom.", null); 
			fc.addMessage((String) findComponentId(event, "nom"), message);
			fc.renderResponse();
		}
	}
	
	
	/*
	 *  ================================= Méthodes utilitaires pour la classe seulement =============================
	 */

	// Permet de récupérer un composant dans le formulaire
	private static Object findComponent(ComponentSystemEvent event, String component) {
		UIInput uiInputComponent = findUIInput(event, component);
		Object composant = uiInputComponent.getLocalValue();

		return composant;
	}
	
	// Permet de récupérer l'ID d'un composant dans le formulaire
	private static Object findComponentId(ComponentSystemEvent event, String component) {
		UIInput uiInputComponent = findUIInput(event, component);
		Object composant = uiInputComponent.getClientId();

		return composant;
	}
	
	private static UIInput findUIInput(ComponentSystemEvent event, String component) {
		UIComponent components = event.getComponent();
		UIInput uiInputComponent = (UIInput) components.findComponent(component);
		
		return uiInputComponent;
	}
}