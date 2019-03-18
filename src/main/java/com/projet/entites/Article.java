package com.projet.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public abstract class Article implements Serializable {

	protected int id;
	protected String description;
	protected Float prix;
	protected String etat;
	protected String image;
	protected Float rating;
	protected Date dateSortie;
	
	protected Vendeur vendeur;
	
	protected Map<Integer, Selection> listeSelection;
	
}
