/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.springframework.util.StringUtils;

/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */
public class AssuranceConverter implements Serializable, Converter {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	/**
	 * Bean constructor.
	 */
	public AssuranceConverter() {
		super();
	}
	/**
	 * @see javax.faces.convert.Converter#getAsString(
	 * javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(
			@SuppressWarnings("unused") final FacesContext context, 
			@SuppressWarnings("unused") final UIComponent component, 
			final Object value) {
		if (value == null || !StringUtils.hasText(value.toString())) {
			return "";
		}
		if (!(value instanceof AssuranceDTO)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a AssuranceDTO.");
		}
		AssuranceDTO e = (AssuranceDTO) value;
		return ""+e.getId();
	}
	
	/**
	 * @see javax.faces.convert.Converter#getAsObject(
	 * javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(
			@SuppressWarnings("unused") final FacesContext context, 
			@SuppressWarnings("unused") final UIComponent component, 
			final String value) {
		if (!StringUtils.hasText(value) 
				|| !Utils.isNumber(value)) {
			return null;
		}
		return getNomenclatureDomainService().getAssuranceDTOFromId(Utils.convertStringToInt(value));
	}
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
	
}
