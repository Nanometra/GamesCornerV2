package com.projet.managedBean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloWorldBean")
//@RequestScoped
@SessionScoped
public class HelloWorldBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Injection de dépendances par JSF
	private String name;

	public String hello() {
		System.out.println("Call index.xhtml");

		return "success";
	}

	public String getCurrentTime() {

		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy:HH:mm:SS"));
//		return new SimpleDateFormat("dd MM yyyy:HH:mm:SS").format(new Date().getTime());
	}

	// Getters et Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
