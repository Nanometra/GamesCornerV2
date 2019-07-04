package com.projet.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe qui représente le panier du client qui sera persisté en base.
 * 
 * @author Noemi
 *
 */
@Entity
public class Selection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="article_id")
	private Article article;
	
	private int quantite;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	private Utilisateur utilisateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="commande_id")
	private Commande commande;
	
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Selection [id=" + id + ", article=" + article + ", quantite=" + quantite + ", utilisateur="
				+ utilisateur + ", commande=" + commande + "]";
	}

}
