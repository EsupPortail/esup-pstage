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
import org.esupportail.pstagedata.domain.dto.NiveauCentreDTO;
import org.springframework.util.StringUtils;

/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */
public class NiveauCentreConverter implements Serializable, Converter {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService NomenclatureDomainService;
	/**
	 * Bean constructor.
	 */
	public NiveauCentreConverter() {
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
		if (!(value instanceof NiveauCentreDTO)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a NiveauCentreDTO.");
		}
		NiveauCentreDTO n = (NiveauCentreDTO) value;
		return Integer.toString(n.getId());
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
		if (value == null || !StringUtils.hasText(value)
				|| !Utils.isNumber(value)) {
			return null;
		}
		return getNomenclatureDomainService().getNiveauCentreFromId(Utils.convertStringToInt(value));
	}
	/**
	 * @return the NomenclatureDomainService
	 */
	public NomenclatureDomainService getNomenclatureDomainService() {
		return NomenclatureDomainService;
	}
	/**
	 * @param NomenclatureDomainService the NomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(NomenclatureDomainService NomenclatureDomainService) {
		this.NomenclatureDomainService = NomenclatureDomainService;
	}
}
