package org.esupportail.pstage.domain.referentiel;

import java.util.Map;

import org.esupportail.commons.annotations.cache.SessionCache;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;


/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

public class StudentComponentRepositoryDomainCustom implements
	StudentComponentRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public EtabRef getEtabRef(String universityCode) {
		return null;
	}

	@SessionCache
	public Map<String, String> getEtapesRef(String universityCode) {
		return null;
	}

	@Override
	public SignataireRef getSigCompoRef(String universityCode, String Composante) {
		return null;
	}

	@Override
	public Map<String, String> getComposantesPrincipalesRef(String universityCode,
			Map<String, String> lesComposantes) {
		return null;
	}





}
