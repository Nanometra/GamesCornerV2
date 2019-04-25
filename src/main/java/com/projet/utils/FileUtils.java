package com.projet.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	private static UploadedFile file;

	public static void upload(FileUploadEvent event) {
		// Récupère le fichier depuis FileUploadEvent.
		file = event.getFile();
		if (file != null) {
			LOGGER.info("Le fichier " + file.getFileName() + " a bien été uploadé.");
			FacesMessage message = new FacesMessage("Le fichier a bien été uploadé");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}
