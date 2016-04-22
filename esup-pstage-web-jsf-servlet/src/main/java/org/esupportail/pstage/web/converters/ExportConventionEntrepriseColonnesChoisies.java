/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


public class ExportConventionEntrepriseColonnesChoisies implements Converter {

    private static final Logger logger = new LoggerImpl(ExportConventionEntrepriseColonnesChoisies.class);

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }


    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

}
