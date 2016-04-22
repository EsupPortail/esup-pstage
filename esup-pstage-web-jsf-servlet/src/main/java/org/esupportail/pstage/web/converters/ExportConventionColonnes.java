/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.pstage.web.converters;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.springframework.util.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;


public class ExportConventionColonnes implements Converter {

    private static final Logger logger = new LoggerImpl(ExportConventionColonnes.class);

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }


    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

}
