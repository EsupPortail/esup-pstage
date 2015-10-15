package org.esupportail.pstage.dao.referentiel;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstage.domain.beans.EtudiantRef;

/**
 * @author dhouillo
 *
 */
public interface StudentDataRepositoryDao extends Serializable{
	/**
 * @param universityCode
 * @param id
 * @return EtudiantRef
 */
public EtudiantRef getEtudiantRef(String universityCode, String id);
/**
 * @param universityCode
 * @param id
 * @return EtudiantRef
 */
public EtudiantRef getEtudiantRefByNum(String universityCode, String id, String annee);
/**
 * @param universityCode
 * @param name
 * @param firstName
 * @return List<EtudiantRef>
 */
public List<EtudiantRef> getEtudiantsRefByName(String universityCode, String name, String firstName);


}
