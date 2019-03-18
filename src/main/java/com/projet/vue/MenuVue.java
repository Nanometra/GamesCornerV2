package com.projet.vue;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name="menuVue")
public class MenuVue {

	private MenuModel model;
	
	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		
		// Premier sous-menu
		DefaultSubMenu firstSubMenu = new DefaultSubMenu("Sous-menu Dynamique");
		
		DefaultMenuItem item = new DefaultMenuItem("Externe");
		item.setUrl("http://www.primefaces.org");
		item.setIcon("pi pi-home");
		firstSubMenu.addElement(item);
		
		model.addElement(firstSubMenu);
		
		// Second sous-menu
		DefaultSubMenu secondSubMenu = new DefaultSubMenu("Actions Dynamique");
		
/*
*  ====================== Sauvegarde dans le sous menu Actions ======================
*/
		
		item = new DefaultMenuItem("Sauvegarder");
		item.setIcon("pi pi-save");
		item.setCommand("#{menuVue.save}");
		item.setUpdate("messages");
		secondSubMenu.addElement(item);

/*
*  ====================== Suppression dans le sous menu Actions ======================
*/

		item = new DefaultMenuItem("Supprimer");
		item.setIcon("pi pi-times");
		item.setCommand("#{menuVue.delete}");
		item.setAjax(false);
		secondSubMenu.addElement(item);
		
/*
*  ====================== Mise à jour dans le sous menu Actions ======================
*/
		
		item = new DefaultMenuItem("Redirection");
		item.setIcon("pi pi-search");
		item.setCommand("#{menuVue.redirect}");
		secondSubMenu.addElement(item);
		
		model.addElement(secondSubMenu);
	}
	
	public void save() {
		addMessage("Succes", "Infos sauvegardées");
	}
	
	public void update() {
		addMessage("Succes", "Infos mises à jour");
	}
	
	public void delete() {
		addMessage("Succes", "Infos supprimées");
	}
	
	public void addMessage(String resume, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, resume, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
