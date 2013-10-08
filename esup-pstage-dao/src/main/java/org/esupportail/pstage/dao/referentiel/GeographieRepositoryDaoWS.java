package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.client.ws.geographiemetier.GeographieMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.servicesmetiers.GeographieMetierServiceInterface;
import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

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
	
	/**
	 * @see org.esupportail.pstage.dao.referentiel.GeographieRepositoryDao#getCommuneFromDepartement(java.lang.String)
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement){
		List<CommuneDTO> l = null;
		try{
			GeographieMetierServiceInterface geographieMetierServiceInterface = new GeographieMetierServiceInterfaceProxy();
			CommuneDTO[] cTab = geographieMetierServiceInterface.recupererCommune(departement, "O", "T");
			if(cTab!=null && cTab.length>0){
				l = new ArrayList<CommuneDTO>();
				for(CommuneDTO c : cTab){
					l.add(c);
				}
				Collections.sort(l, new Comparator<CommuneDTO>(){
					/**
					 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
					 */
					@Override
					public int compare(CommuneDTO o1, CommuneDTO o2) {
						return o1.getLibCommune().compareTo(o2.getLibCommune());
					}
				});
			}
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


}
