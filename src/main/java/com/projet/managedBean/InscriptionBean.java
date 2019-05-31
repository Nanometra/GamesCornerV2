package com.projet.managedBean;

import static com.projet.commons.PasswordUtils.hashPassword;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

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
	private transient IUtilisateurDAO utilisateurDAO;
	private FacesMessage message;
	private FacesContext fc;
	private UploadedFile file;
	private ComponentSystemEvent event;

	public InscriptionBean() {
		utilisateur = new Client();
		utilisateurDAO = DAOUtils.getUtilisateurDAO();
		fc = FacesContext.getCurrentInstance();
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String inscrire() throws Exception {
		initialiserDateInscription();

		// On hashe le mot de passe qu'on enregistre ensuite en base.
		String password = fc.getExternalContext().getRequestParameterMap().get("inscription:password");
		String computePassword = hashPassword(password);
		utilisateur.setMotDePasse(computePassword);

		// Fichier uploadé
		upload();

		// Le client nouvellement crée n'est pas un vendeur ni un admin
		utilisateur.setVendeur(false);
		utilisateur.setAdmin(false);

		utilisateurDAO.add(utilisateur);

		LOGGER.info("L'utilisateur a été enregistré en base.");
		message = new FacesMessage("Succès de l'inscription");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "succes";
	}

	private void initialiserDateInscription() {
		Date dateInscription = new Date(System.currentTimeMillis());
		utilisateur.setDateInscription(dateInscription);
	}

	public void upload() throws Exception {
		// Récupère le fichier depuis FileUploadEvent.
		if (file != null) {
			byte[] image = FileUtils.transformFileToByte(file);
			utilisateur.setImageProfil(image);
		} else {
			LOGGER.error("Le chargement du fichier a échoué.");
		}
	}

}