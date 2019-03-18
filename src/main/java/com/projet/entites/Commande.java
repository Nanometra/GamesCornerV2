package com.projet.entites;

import java.io.Serializable;
import java.util.List;

public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Float prixTotal;
	private Client client;
	private String moyenPaiement;
	private List<Selection> listeSelection;
	private Panier panier;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getMoyenPaiement() {
		return moyenPaiement;
	}

	public void setMoyenPaiement(String moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}

	public List<Selection> getListeSelection() {
		return listeSelection;
	}

	public void setListeSelection(List<Selection> listeSelection) {
		this.listeSelection = listeSelection;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", prixTotal=" + prixTotal + ", client=" + client + ", moyenPaiement="
				+ moyenPaiement + ", listeSelection=" + listeSelection + ", panier=" + panier + "]";
	}

}
