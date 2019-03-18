package com.projet.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public abstract class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String description;
	protected Float prix;
	protected String etat;
	protected String image;
	protected Float rating;
	protected Date dateSortie;

	protected Vendeur vendeur;

	protected Map<Integer, Selection> listeSelection;

	public Article() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public Map<Integer, Selection> getListeSelection() {
		return listeSelection;
	}

	public void setListeSelection(Map<Integer, Selection> listeSelection) {
		this.listeSelection = listeSelection;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", prix=" + prix + ", etat=" + etat + ", image="
				+ image + ", rating=" + rating + ", dateSortie=" + dateSortie + ", vendeur=" + vendeur
				+ ", listeSelection=" + listeSelection + "]";
	}

}
