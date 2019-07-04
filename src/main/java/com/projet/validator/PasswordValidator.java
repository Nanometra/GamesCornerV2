package com.projet.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
@FacesValidator
public class PasswordValidator implements Validator {

	private static final String MOTDEPASSE_REGEX_VALIDATION = "^\\w{8,}\\S";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		
		FacesMessage message;
		String password = (String) value;
		
		// Confirmation du mot de passe
		UIInput uiInputConfirmationPassword = (UIInput) component.getAttributes().get("confirmationPassword");
		String confirmationPassword = (String) uiInputConfirmationPassword.getSubmittedValue();		
		
		if (password == null || password.isEmpty()) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir un mot de passe.", null);
			throw new ValidatorException(message);
		}
		
		if (!password.matches(MOTDEPASSE_REGEX_VALIDATION)) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le mot de passe doit contenir au moins 8 caractère avec une minuscule, une majuscule et un chiffre.", null);
			throw new ValidatorException(message);
		}
		
		if (confirmationPassword == null || confirmationPassword.isEmpty()) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez confirmer votre mot de passe.", null);
			throw new ValidatorException(message);
		}
		
		if (!password.equals(confirmationPassword)) {
			uiInputConfirmationPassword.setValid(false);
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Les 2 mots de passe doivent être identiques.", null);
			throw new ValidatorException(message);
		}
	}

}
