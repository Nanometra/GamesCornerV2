package com.projet.entites;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Client extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Le panier n'est pas persisté en base
	private transient Panier panier;
	
	@NotNull(message="Veuillez saisir une adresse de livraison.")
	private String adresseLivraison;
	
	@NotNull(message="Veuillez saisir un code postal.")
	@Pattern(regexp="\\d{5}", message="Le code postal doit être composé de 5 chiffres.")
	private String codePostal;
	
	@NotNull(message="Veuillez saisir un numéro de téléphone.")
	@Pattern(regexp="[0-9]{10}", message="Le numéro de téléphone doit contenir 10 chiffres.")
	private String telephone;
	
	// Historique des articles achetés (spécifique au client, il est le seul qui peut passer commande)
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL, orphanRemoval=true)
	private Map<Integer, Commande> historique;

	public Client() {
		super();
		this.adresseLivraison = "";
		this.codePostal = "";
		this.telephone = "";
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Map<Integer, Commande> getHistorique() {
		return historique;
	}

	public void setHistorique(Map<Integer, Commande> historique) {
		this.historique = historique;
	}

	@Override
	public String toString() {
		return "Client [adresseLivraison=" + adresseLivraison + ", codePostal=" + codePostal + ", telephone="
				+ telephone + ", historique=" + historique + "]";
	}
	
}

