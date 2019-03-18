package com.projet.entites;

import java.util.Date;
import java.util.Map;

public class Vendeur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dateDebutVendeur;

	/* % de commission prélevé par le site au vendeur. */
	private Float commission;

	// Liste des articles du vendeur
	private Map<Integer, Article> listeArticles;

	public Vendeur() {
		super();
	}

	public Date getDateDebutVendeur() {
		return dateDebutVendeur;
	}

	public void setDateDebutVendeur(Date dateDebutVendeur) {
		this.dateDebutVendeur = dateDebutVendeur;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Map<Integer, Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(Map<Integer, Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	@Override
	public String toString() {
		return "Vendeur [dateDebutVendeur=" + dateDebutVendeur + ", commission=" + commission + "]";
	}

}
