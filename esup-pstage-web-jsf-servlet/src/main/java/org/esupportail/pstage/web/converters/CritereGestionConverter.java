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
import org.esupportail.pstagedata.remote.CritereGestionDTO;
import org.springframework.util.StringUtils;

/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */
public class CritereGestionConverter implements Serializable, Converter {

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
	public CritereGestionConverter() {
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
		CritereGestionDTO c;
		if (value == null || !StringUtils.hasText(value.toString())) {
			return "";
		}

		if (!(value instanceof CritereGestionDTO)) {
			if (Utils.isNumber((String)value)){
				c = this.nomenclatureDomainService.getCritereGestionFromCode((String)value);

				return c.getCode();
			} else {
			throw new UnsupportedOperationException(
					"object " + value + " is not a CritereGestionDTO.");
			}
		}
		c = (CritereGestionDTO) value;
		return c.getCode();
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

		return getNomenclatureDomainService().getCritereGestionFromCode(value);
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
