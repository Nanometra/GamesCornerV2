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

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String password = (String) value;
		
		// Confirmation du mot de passe
		UIInput uiInputConfirmationPassword = (UIInput) component.getAttributes().get("confirmationPassword");
		String confirmationPassword = (String) uiInputConfirmationPassword.getSubmittedValue();		
		
		if (password == null || password.isEmpty()) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir un mot de passe.", null);
			throw new ValidatorException(message);
		}
		
		if (confirmationPassword == null || confirmationPassword.isEmpty()) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez confirmer votre mot de passe.", null);
			throw new ValidatorException(message);
		}
		
		if (!password.equals(confirmationPassword)) {
			uiInputConfirmationPassword.setValid(false);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Les 2 mots de passe doivent être identiques.", null);
			throw new ValidatorException(message);
		}
	}

}
