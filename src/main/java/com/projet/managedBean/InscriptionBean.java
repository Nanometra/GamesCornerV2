package com.projet.managedBean;

import static com.projet.commons.PasswordUtils.hashPassword;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projet.commons.DAOUtils;
import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Client;
import com.projet.entites.Utilisateur;
import com.projet.utils.FileUtils;

@ManagedBean(name = "inscriptionBean")
@RequestScoped
public class InscriptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(InscriptionBean.class);

	private Utilisateur utilisateur;
	private IUtilisateurDAO utilisateurDAO;
	private FacesMessage message;
	private FacesContext fc;
	private UploadedFile file;
	private ComponentSystemEvent event;

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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String inscrire() {
		initialiserDateInscription();

		// On hashe le mot de passe qu'on enregistre ensuite en base.
		ExternalContext ec = fc.getExternalContext();
		String password = (String) ec.getRequestParameterMap().get("inscription:password");
		String computePassword = hashPassword(password);
		utilisateur.setMotDePasse(computePassword);

		utilisateurDAO.add(utilisateur);

		LOGGER.info("L'utilisateur a été enregistré en base.");
		FacesMessage message = new FacesMessage("Succès de l'inscription");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "succes";
	}

	private void initialiserDateInscription() {
		Date dateInscription = new Date(System.currentTimeMillis());
		utilisateur.setDateInscription(dateInscription);
	}

	public void upload(FileUploadEvent event, UploadedFile file) throws Exception {
		// Récupère le fichier depuis FileUploadEvent.
		file = event.getFile();
		byte[] image = FileUtils.upload(file);
		System.out.println(
				"Uploaded File Name Is :: " + file.getFileName() + " :: Uploaded File Size :: " + file.getSize());
		utilisateur.setImageProfil(image);
	}

	/*
	 * ================================= Méthodes utilitaires pour la classe
	 * seulement =============================
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