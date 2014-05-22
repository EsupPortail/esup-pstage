package org.esupportail.pstage.domain.referentiel;

import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.pstage.dao.referentiel.PersonalComponentRepositoryDaoWS;



/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

public class PersonalComponentRepositoryDomainWS implements
		PersonalComponentRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(PersonalComponentRepositoryDomainWS.class);

	/**
	 * 
	 */
	private PersonalComponentRepositoryDaoWS personalComponentRepositoryDaoWS; 
	
	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.PersonalComponentRepositoryDomain#getComposantesRef(java.lang.String)
	 */
	public Map<String, String> getComposantesRef(String universityCode) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de PersonalComponentRepositoryWS.getComposantes(String universityCode) : " + universityCode);
		}
		
    	Map<String,String> compos = personalComponentRepositoryDaoWS.getComposantesRef(universityCode);
		if(logger.isDebugEnabled()){
			logger.debug(" PersonalComponentRepositoryWS liste des composantes  ==> " + compos.size());
		}
		return compos;
	}


	/**
	 * @return the personalComponentRepositoryDaoWS
	 */
	public PersonalComponentRepositoryDaoWS getPersonalComponentRepositoryDaoWS() {
		return personalComponentRepositoryDaoWS;
	}


	/**
	 * @param personalComponentRepositoryDaoWS the personalComponentRepositoryDaoWS to set
	 */
	public void setPersonalComponentRepositoryDaoWS(
			PersonalComponentRepositoryDaoWS personalComponentRepositoryDaoWS) {
		this.personalComponentRepositoryDaoWS = personalComponentRepositoryDaoWS;
	}

	
	
	
}
