package com.projet.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.entites.Article;

@ManagedBean
@SessionScoped
public class AjoutArticleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Article article;
	
	
	
}
