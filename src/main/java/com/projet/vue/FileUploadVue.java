package com.projet.vue;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="fileUploadVue")
public class FileUploadVue {
	
	private UploadedFile file;

	public FileUploadVue() {
		super();
	}

	public FileUploadVue(UploadedFile file) {
		super();
		this.file = file;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succes", file.getFileName() + "est uploadé.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succes", event.getFile().getFileName() + " est uploadé.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
