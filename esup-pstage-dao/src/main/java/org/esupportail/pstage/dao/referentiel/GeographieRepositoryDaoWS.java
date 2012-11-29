package org.esupportail.pstage.dao.referentiel;

import geographiemetier_06062007_impl.servicesmetiers.commun.apogee.education.gouv.GeographieMetierServiceInterface;
import geographiemetier_06062007_impl.servicesmetiers.commun.apogee.education.gouv.WebBaseException;
import gouv.education.apogee.commun.transverse.dto.geographie.communedto.CommuneDTO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class GeographieRepositoryDaoWS implements GeographieRepositoryDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2551254377936997954L;
	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(GeographieRepositoryDaoWS.class);

	private GeographieMetierServiceInterface geographieMetierServiceInterface;
	
	/**
	 * @see org.esupportail.pstage.dao.referentiel.GeographieRepositoryDao#getCommuneFromDepartement(java.lang.String)
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement){
		List<CommuneDTO> l = null;
		try{
			l = this.geographieMetierServiceInterface.recupererCommune(departement, "O", "T");
			Collections.sort(l, new Comparator<CommuneDTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(CommuneDTO o1, CommuneDTO o2) {
					return o1.getLibCommune().compareTo(o2.getLibCommune());
				}
			});
		}catch (WebBaseException e) {
			if(!e.equals("technical.parameter.noncoherentinput.codePostal") &&
					!e.equals("technical.data.nullretrieve.commune") &&
					!e.equals("technical.parameter.noncoherentinput.temoinenservicecommune ") &&
					!e.equals("technical.parameter.noncoherentinput.temoinenservicebd")){
				logger.error(e.getMessage(), e);
			}
		}
		return l;
	}

	public void setGeographieMetierServiceInterface(
			GeographieMetierServiceInterface geographieMetierServiceInterface) {
		this.geographieMetierServiceInterface = geographieMetierServiceInterface;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.geographieMetierServiceInterface, "La propriété geographieMetierServiceInterface ne peut etre null.");
	}

}
