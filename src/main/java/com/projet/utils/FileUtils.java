package com.projet.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	private static UploadedFile file;
	private static byte[] fichier;

	private String destination = "/tmp";

	public static void handleUpload(FileUploadEvent event) throws Exception {
		fichier = IOUtils.toByteArray(event.getFile().getInputstream());
	}

	public static void upload(FileUploadEvent event) {
		// Récupère le fichier depuis FileUploadEvent.
		file = event.getFile();
		if (file != null) {
			LOGGER.info("Le fichier " + file.getFileName() + " a bien été uploadé.");
			FacesMessage message = new FacesMessage("Le fichier a bien été uploadé");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void copyFile(String inputName, InputStream in) {
		try {
			// Ecrit l'inputStream dans un outputStream (file)
			OutputStream out = new FileOutputStream(new File(destination + inputName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("Fichier créée");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
