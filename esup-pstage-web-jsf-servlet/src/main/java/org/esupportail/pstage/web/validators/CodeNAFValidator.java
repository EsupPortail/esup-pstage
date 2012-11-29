package org.esupportail.pstage.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.utils.Utils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 */
public class CodeNAFValidator implements Validator {
	
	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	
	/**
	 * @return the nomenclatureDomainService
	 */
	public NomenclatureDomainService getNomenclatureDomainService() {
		return nomenclatureDomainService;
	}

	/**
	 * @param nomenclatureDomainService the nomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(
			NomenclatureDomainService nomenclatureDomainService) {
		this.nomenclatureDomainService = nomenclatureDomainService;
	}


	/**
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(@SuppressWarnings("unused") FacesContext fc, @SuppressWarnings("unused") UIComponent uic, Object o)
	throws ValidatorException {
		String value = (String) o;
		value=value.trim();
		if(!value.matches(Utils.REGEX_CODE_NAF))
			throw new ValidatorException(new FacesMessage());
		value=value.toUpperCase();
		if(this.nomenclatureDomainService.getNafN5FromCode(value)==null)
			throw new ValidatorException(new FacesMessage());
	}

}
