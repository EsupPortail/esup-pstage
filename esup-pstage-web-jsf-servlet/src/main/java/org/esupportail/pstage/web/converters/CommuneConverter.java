/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import gouv.education.apogee.commun.client.ws.GeographieMetier.CommuneDTO;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.esupportail.pstage.domain.referentiel.GeographieRepositoryDomain;
import org.springframework.util.StringUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class CommuneConverter implements Serializable, Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String codeCommune;
	/**
	 * 
	 */
	private GeographieRepositoryDomain geographieRepositoryDomain;
	/**
	 * Bean constructor.
	 */
	public CommuneConverter() {
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
		if (!(value instanceof CommuneDTO)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a CommuneDTO.");
		}
		CommuneDTO c = (CommuneDTO) value;
		this.codeCommune=c.getCodeCommune();
		return ""+c.getCodePostal();
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
		CommuneDTO c = null;
		List<CommuneDTO> l = this.geographieRepositoryDomain.getCommuneFromDepartement(value);
		for(CommuneDTO cl : l){
			if(cl.getCodeCommune().equals(this.codeCommune)){
				c=cl;
			}
		}
		return c;
	}
	/**
	 * @return the geographieRepositoryDomain
	 */
	public GeographieRepositoryDomain getGeographieRepositoryDomain() {
		return geographieRepositoryDomain;
	}
	/**
	 * @param geographieRepositoryDomain the geographieRepositoryDomain to set
	 */
	public void setGeographieRepositoryDomain(
			GeographieRepositoryDomain geographieRepositoryDomain) {
		this.geographieRepositoryDomain = geographieRepositoryDomain;
	}
	
	
}
