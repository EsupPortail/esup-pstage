/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.util.StringUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class ListeCodePostalConverter implements Serializable, Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Bean constructor.
	 */
	public ListeCodePostalConverter() {
		super();
	}
	/**
	 * @see javax.faces.convert.Converter#getAsString(
	 * javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(
			final FacesContext context, 
			final UIComponent component, 
			final Object value) {
		if (value == null || !StringUtils.hasText(value.toString())) {
			return "";
		}
		if (!(value instanceof List)) {
			throw new UnsupportedOperationException(
					"object " + value + " is not a List.");
		}
		StringBuilder rs = new StringBuilder("");

		List<String> l = (List<String>) value;
		if(!l.isEmpty()){
			for(String s : l){
				if(StringUtils.hasText(s)){
					rs.append(s+";");
				}
			}
		}
		
		return rs.toString();
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
		List<String> lm=new ArrayList<String>();
		if(StringUtils.hasText(value)){
			StringTokenizer st = new StringTokenizer(value,";");
			while(st.hasMoreElements()){
				String s = st.nextToken();
				if(StringUtils.hasText(s))lm.add(s);
			}
		}
		if(lm.isEmpty())lm=null;
		return lm;
	}
}
