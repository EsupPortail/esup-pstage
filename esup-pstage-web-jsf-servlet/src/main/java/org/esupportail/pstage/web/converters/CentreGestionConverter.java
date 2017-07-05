/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.esupportail.pstage.domain.CentreGestionDomainService;
import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.springframework.util.StringUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class CentreGestionConverter implements Serializable, Converter {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CentreGestionDomainService getCentreGestionDomainService() {
		return centreGestionDomainService;
	}

	public void setCentreGestionDomainService(CentreGestionDomainService centreGestionDomainService) {
		this.centreGestionDomainService = centreGestionDomainService;
	}

	/**
	 * centreGestionDomainService
	 */
	private CentreGestionDomainService centreGestionDomainService;
	/**
	 * Bean constructor.
	 */
	public CentreGestionConverter() {
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
		if (!(value instanceof CentreGestionDTO)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a CentreGestionDTO.");
		}
		CentreGestionDTO c = (CentreGestionDTO) value;
		return Integer.toString(c.getIdCentreGestion());
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
		if (!StringUtils.hasText(value)
				|| !Utils.isNumber(value)) {
			return null;
		}
		return this.centreGestionDomainService.getCentreGestion(Utils.convertStringToInt(value));
	}

}
