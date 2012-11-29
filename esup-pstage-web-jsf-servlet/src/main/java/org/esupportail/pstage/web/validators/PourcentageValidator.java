package org.esupportail.pstage.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.esupportail.pstage.utils.Utils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 */
public class PourcentageValidator implements Validator {

	/**
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(@SuppressWarnings("unused") FacesContext fc, @SuppressWarnings("unused") UIComponent uic, Object o)
	throws ValidatorException {
		String value = o+"";
		if(Utils.isNumber(value)){
			int i = Utils.convertStringToInt(value);
			if(i<=0 || i>100){
				throw new ValidatorException(new FacesMessage());
			}
		}else{
			throw new ValidatorException(new FacesMessage());
		}
	}

}
