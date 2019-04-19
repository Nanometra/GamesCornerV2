package com.projet.validator;

import static com.projet.utils.DAOUtils.getUtilisateurDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.projet.dao.IUtilisateurDAO;
import com.projet.entites.Utilisateur;

@ManagedBean
@RequestScoped
@FacesValidator
public class EmailValidator implements Validator {

	public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
//	public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\\\\\\\.[a-zA-Z0-9]+", Pattern.CASE_INSENSITIVE);

	private String email;
	private IUtilisateurDAO utilisateurDAO;

	public EmailValidator() {
		super();
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		utilisateurDAO = getUtilisateurDAO();

		if (value == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir une adresse mail.", null);
			throw new ValidatorException(message);
		}

		email = (String) value;
		boolean matches = VALID_EMAIL_REGEX.matcher(email).matches();

		if (!matches) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"L'email que vous avez entré est incorrect", null);
			throw new ValidatorException(message);
		} else {
			List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			listeUtilisateur = utilisateurDAO.findByEmail(email);

			if (listeUtilisateur.size() >= 1) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"L'email entré a déjà été utilisé.", null);
				throw new ValidatorException(message);
			}
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
