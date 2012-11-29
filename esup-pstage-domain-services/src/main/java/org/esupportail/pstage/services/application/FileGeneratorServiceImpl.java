package org.esupportail.pstage.services.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.esupportail.commons.services.i18n.I18nService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.BeanUtils;
import org.esupportail.pstagedata.remote.ConventionDTO;
import org.springframework.beans.factory.InitializingBean;

import com.ibm.icu.text.SimpleDateFormat;


/**
 * @author dhouillo
 *
 */
public class FileGeneratorServiceImpl implements Serializable, InitializingBean, FileGeneratorService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(getClass());


	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
	}


	/**
	 * @see org.esupportail.pstage.services.application.FileGeneratorService#conventionFile(java.util.List, java.lang.String, java.lang.String, java.util.List)
	 */
	public void conventionFile(final List<ConventionDTO> conventions,
			final String typeExport, final String filename, final List<String> colonnesChoisies) {
		List<SpreadsheetColumn> colonnes = new ArrayList<SpreadsheetColumn>();
		// colonnes partie convention
		for (ConventionColonneEnum s : ConventionColonneEnum.values()) {
			// definition des valeurs
			Map<Integer, String> vConvention = new HashMap<Integer, String>();
			int cpt = 1;
			for (ConventionDTO convention : conventions) {
				String endResult = "";
				try {
					// methode reflectHelper, prend objet, recupere le getter de la propertie
					// pour un Boolean , ajouter une methode get
					Object result = ReflectHelper.resultExpression(s.getNameProperty(), convention);
					
					if (result != null) {
						if (s.getNameProperty().contains("date")){
							result = new SimpleDateFormat("dd/MM/yyyy").format(result);
						}
						if (s.getNameProperty().equalsIgnoreCase("validationConventionExport")){
							if (result.toString().contains("true")){
								result = "Oui";
							} else {
								result = "Non";
							}
						}
						endResult = result.toString();
					} 
				} catch (NullPointerException e) {
					logger.warn("La colonne " + s.getKeyLabel() 
					+ "pour la propriete " + s.getNameProperty() + "est vide (property null)");
				}
				vConvention.put(cpt, endResult);

				cpt++;
			}
			// definition de toutes les colonnes
			I18nService service = (I18nService) BeanUtils.getBean("i18nService");
			SpreadsheetColumn cConvention = new SpreadsheetColumn(
					service.getString(s.getKeyLabel()), vConvention);
			colonnes.add(cConvention);
		}
		// colonnes partie convention/entreprise
		for (ConventionEntrepriseColonneEnum s : ConventionEntrepriseColonneEnum.values()) {
			// definition des valeurs
			Map<Integer, String> vConventionEntreprise = new HashMap<Integer, String>();
			int cpt = 1;
			for (ConventionDTO convention : conventions) {
				String endResult = "";
				try {
					// methode reflectHelper, prend objet, recupere le getter de la propertie
					// pour un Boolean , ajouter une methode get
					Object result = ReflectHelper.resultExpression(s.getNameProperty(), convention);
					
					if (result != null) {
						endResult = result.toString();
					} 
				} catch (NullPointerException e) {
					logger.warn("la colonne " + s.getKeyLabel() 
					+ "pour la propriete " + s.getNameProperty() + "est vide (property null)");
				}
				vConventionEntreprise.put(cpt, endResult);

				cpt++;
			}
			// definition de toutes les colonnes
			I18nService service = (I18nService) BeanUtils.getBean("i18nService");
			SpreadsheetColumn cConventionEntreprise = new SpreadsheetColumn(
					service.getString(s.getKeyLabel()), vConventionEntreprise);
			colonnes.add(cConventionEntreprise);
		}
		
		SpreadsheetObject sso = new SpreadsheetObject(colonnes);
		if (colonnesChoisies != null && !colonnesChoisies.isEmpty()) {
			 sso = new SpreadsheetObject(colonnes, colonnesChoisies);
		} 

		// generation du fichier
		generate(sso, typeExport, filename);
	}

	/**
	 * @see org.esupportail.pstage.services.application.FileGeneratorService#generate(fr.univ.rennes1.cri.services.export.SpreadsheetObject, java.lang.String, java.lang.String)
	 */
	public void generate(final SpreadsheetObject sso, final String typeExport,
			final String filename) {
		if (logger.isDebugEnabled()) {
			logger.debug("enter generate() method");
		}
		if (typeExport != null) {
			String type = typeExport.toUpperCase();
			if (logger.isDebugEnabled()) {
				logger.debug("type = " + type);
			}
			SpreadsheetService service = 
				(SpreadsheetService) BeanUtils.getBean("export" + type + "Service");
			if (logger.isDebugEnabled()) {
				logger.debug("service = " + service.getClass().getCanonicalName());
			}
			byte[] data = service.datasToBytes(sso);
			PDFUtils.setDownLoadAndSend(data, FacesContext.getCurrentInstance(),
					"application/vnd.ms-excel",	filename);	
		}
	}
}
