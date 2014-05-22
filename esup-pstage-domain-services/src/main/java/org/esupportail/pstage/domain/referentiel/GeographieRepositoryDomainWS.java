package org.esupportail.pstage.domain.referentiel;

import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;

import java.util.List;

import org.apache.log4j.Logger;
import org.esupportail.pstage.dao.referentiel.GeographieRepositoryDao;
import org.springframework.util.StringUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class GeographieRepositoryDomainWS implements GeographieRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2551254377936997954L;
	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(GeographieRepositoryDomainWS.class);
	/**
	 * GeographieRepositoryDao
	 */
	private GeographieRepositoryDao geographieRepositoryDao;
	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.GeographieRepositoryDomain#getCommuneFromDepartement(java.lang.String)
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement){
		if(StringUtils.hasText(departement)){
			return geographieRepositoryDao.getCommuneFromDepartement(departement);
		}
		return null;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.GeographieRepositoryDomain#getCommuneFromDepartementEtCodeCommune(java.lang.String, java.lang.String)
	 */
	public CommuneDTO getCommuneFromDepartementEtCodeCommune(String departement, String codeCommune){
		CommuneDTO c = null;
		if(StringUtils.hasText(departement) && StringUtils.hasText(codeCommune)){
			List<CommuneDTO> l = getCommuneFromDepartement(departement);
			if(l!=null && !l.isEmpty()){
				for(CommuneDTO cl : l){
					if(cl.getCodeCommune().equals(codeCommune)){
						c=cl;
						break;
					}
				}
			}
		}
		return c;
	}

	/**
	 * @return the geographieRepositoryDao
	 */
	public GeographieRepositoryDao getGeographieRepositoryDao() {
		return geographieRepositoryDao;
	}

	/**
	 * @param geographieRepositoryDao the geographieRepositoryDao to set
	 */
	public void setGeographieRepositoryDao(
			GeographieRepositoryDao geographieRepositoryDao) {
		this.geographieRepositoryDao = geographieRepositoryDao;
	}


}
