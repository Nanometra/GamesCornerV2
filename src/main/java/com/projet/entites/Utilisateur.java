package com.projet.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant", discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@NotNull
	protected String nom;
	protected String prenom;

	@NotNull
	protected String motDePasse;
	
	@NotNull
	protected String email;
	protected String pseudo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(unique = true, nullable = true)
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

	/*
	 * Indique si l'utilisateur est également vendeur sur la partie vente
	 * particulier à particulier
	 */
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
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse
				+ ", email=" + email + ", pseudo=" + pseudo + ", dateInscription=" + dateInscription + ", imageProfil="
				+ imageProfil + ", description=" + description + ", actif=" + actif + ", vendeur=" + vendeur
				+ ", admin=" + admin + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

}
