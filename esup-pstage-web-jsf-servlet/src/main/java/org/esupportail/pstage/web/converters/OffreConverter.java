/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.domain.OffreDomainService;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.OffreDTO;
import org.esupportail.pstagedata.domain.dto.OrigineStageDTO;
import org.springframework.util.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

public class OffreConverter implements Serializable, Converter {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * NomenclatureDomainService
	 */
	private OffreDomainService offreDomainService;
	/**
	 * Bean constructor.
	 */
	public OffreConverter() {
		super();
	}
	/**
	 * @see Converter#getAsString(
	 * FacesContext, UIComponent, Object)
	 */
	@Override
	public String getAsString(
			final FacesContext context,
			final UIComponent component,
			final Object value) {
		if (value == null || !StringUtils.hasText(value.toString())) {
			return "";
		}
		if (!(value instanceof OffreDTO)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a OffreDTO.");
		}
		OffreDTO e = (OffreDTO) value;
		return ""+e.getIdOffre();
	}

	/**
	 * @see Converter#getAsObject(
	 * FacesContext, UIComponent, String)
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
		return this.offreDomainService.getOffreFromId(Utils.convertStringToInt(value));
	}


	public OffreDomainService getOffreDomainService() {
		return offreDomainService;
	}

	public void setOffreDomainService(OffreDomainService offreDomainService) {
		this.offreDomainService = offreDomainService;
	}
}
