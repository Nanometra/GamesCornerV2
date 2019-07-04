package com.projet.entites;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vendeur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebutVendeur;

	/* % de commission prélevé par le site au vendeur. */
	private Float commission;

	// Liste des articles du vendeur
	@OneToMany(mappedBy="vendeur")
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
