package com.projet.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "resultatBean")
@RequestScoped
public class ResultatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String resultat() {
		System.out.println("Dans le bean ResultatBean");
		return "success";
	}

}
