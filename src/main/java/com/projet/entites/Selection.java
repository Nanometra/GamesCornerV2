package com.projet.entites;

import java.io.Serializable;

/** 
 * Classe qui représente le panier du client qui sera persisté en base. 
 * 
 * @author Noemi
 *
 */
public class Selection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Article article;
	private int quantite;
	private Client client;
	private transient Panier panier;
	
	public Selection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "Selection [id=" + id + ", article=" + article + ", quantite=" + quantite + ", client=" + client
				+ ", panier=" + panier + "]";
	}
	
}
