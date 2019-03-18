package com.projet.entites;

import java.io.Serializable;
import java.util.Date;

public abstract class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int id;	
	protected String nom;
	protected String prenom;
	protected String motDePasse;
	protected String confirmationMotDePasse;
	protected String email;
	protected Date dateInscription;

	/* Chemin vers l'image de profil de l'utilisateur */
	protected String imageProfil;

	/* Description facultative de l'utilisateur */
	protected String description;

	/*
	 * L'utilisateur devient actif après avoir validé son compte (validation envoyée
	 * par mail directement)
	 */
	protected Boolean actif;

	/* Indique si l'utilisateur est également vendeur sur la partie vente particulier à particulier */
	protected Boolean vendeur;
	
	/* Indique si l'utilisateur est également un admin sur la partie */
	protected Boolean admin;

	public Utilisateur() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getImageProfil() {
		return imageProfil;
	}

	public void setImageProfil(String imageProfil) {
		this.imageProfil = imageProfil;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public Boolean getVendeur() {
		return vendeur;
	}

	public void setVendeur(Boolean vendeur) {
		this.vendeur = vendeur;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse
				+ ", confirmationMotDePasse=" + confirmationMotDePasse + ", email=" + email + ", dateInscription="
				+ dateInscription + ", imageProfil=" + imageProfil + ", description=" + description + ", actif=" + actif
				+ ", vendeur=" + vendeur + ", admin=" + admin + "]";
	}

}
