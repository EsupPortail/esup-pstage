/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstagedata.domain.dto.ConfidentialiteDTO;
import org.springframework.util.StringUtils;

/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 */
public class ConfidentialiteConverter implements Converter {

	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	
	/**
	 * Bean constructor.
	 */
	public ConfidentialiteConverter() {
		super();
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(
	 * javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(
			final FacesContext context, 
			final UIComponent component, 
			final Object value) {
		if (value == null || !StringUtils.hasText(value.toString())) {
			return "";
		}
		if (!(value instanceof ConfidentialiteDTO)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a ConfidentialiteDTO.");
		}
		ConfidentialiteDTO c = (ConfidentialiteDTO) value;
		return ""+c.getCode();
	}

	/**
	 * @see javax.faces.convert.Converter#getAsObject(
	 * javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(
			final FacesContext context, 
			final UIComponent component, 
			final String value) {
		if (!StringUtils.hasText(value)) {
			return null;
		}

		return this.nomenclatureDomainService.getConfidentialiteFromCode(value);
	}

	/**
	 * @param nomenclatureDomainService the nomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(
			NomenclatureDomainService nomenclatureDomainService) {
		this.nomenclatureDomainService = nomenclatureDomainService;
	}

}
