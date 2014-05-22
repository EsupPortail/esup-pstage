package org.esupportail.pstage.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.esupportail.pstage.utils.BlowfishUtils;
import org.springframework.util.StringUtils;


/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class PasswordConverter implements Converter{

	/**
	 * BlowfishUtils
	 */
	private BlowfishUtils blowfishUtils;

	/**
	 * @return the blowfishUtils
	 */
	public BlowfishUtils getBlowfishUtils() {
		return blowfishUtils;
	}

	/**
	 * @param blowfishUtils the blowfishUtils to set
	 */
	public void setBlowfishUtils(BlowfishUtils blowfishUtils) {
		this.blowfishUtils = blowfishUtils;
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context,UIComponent componentToConvert,Object value){
		return "";
	}

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context,UIComponent componentToConvert,String value)
			throws ConverterException {
		if (!StringUtils.hasText(value)) {
			return null;
		}
		return this.blowfishUtils.encode(value);
	}



}
