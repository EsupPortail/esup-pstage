package org.esupportail.pstage.domain.referentiel;

import java.util.Map;

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
	private static final long serialVersionUID = 7195879756216296735L;

	@Override
	public EtabRef getEtabRef(String universityCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getEtapesRef(String universityCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignataireRef getSigCompoRef(String universityCode, String Composante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getComposantesPrincipalesRef(String universityCode,
			Map<String, String> lesComposantes) {
		// TODO Auto-generated method stub
		return null;
	}

}
