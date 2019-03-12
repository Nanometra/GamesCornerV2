package com.projet.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="helloWorld", eager=true)
@RequestScoped
public class HelloWorld {

	// Injection de dépendances par JSF
	@ManagedProperty(value="#{message}")
	private Message messageBean;
	private String message;
	
	public HelloWorld() {
		System.out.println("HelloWorld started");
	}
	
	public String getMessage() {
		if (messageBean != null) {
			message = messageBean.getMessage();
		}
		
		return message;
	}

	public void setMessageBean(Message messageBean) {
		this.messageBean = messageBean;
	}
	
}
