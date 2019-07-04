package com.projet.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projet.utils.FileUtils;

@ManagedBean
@RequestScoped
@FacesValidator
public class FileValidator implements Validator {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileValidator.class);
	
	private UploadedFile file;
	private byte[] image;

	public FileValidator() {
		super();
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			file = (UploadedFile) value;
			String type = "";
			try {
				image = FileUtils.transformFileToByte(file);
				type = FileUtils.getMimeType(image);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			if (!type.startsWith("image/")) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le fichier chargé n'est pas une image.", null);
				throw new ValidatorException(message);
			}
			
		}

	}

}
