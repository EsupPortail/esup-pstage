package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.client.ws.GeographieMetier.GeographieMetierServiceInterface;

import gouv.education.apogee.commun.client.ws.GeographieMetier.CommuneDTO;
import gouv.education.apogee.commun.client.ws.GeographieMetier.WebBaseException_Exception;

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
	final transient Logger logger = Logger.getLogger(GeographieRepositoryDaoWS.class);
	
	/**
	 * @see org.esupportail.pstage.dao.referentiel.GeographieRepositoryDao#getCommuneFromDepartement(java.lang.String)
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement){
		List<CommuneDTO> l = null;
		try{

			GeographieMetierServiceInterface geographieMetierServiceInterface = WsUtils.initGeographieMetierService();
			
			List <CommuneDTO> cTab = geographieMetierServiceInterface.recupererCommune(departement, "O", "T");
			if(cTab!=null && cTab.size()>0){
				l = new ArrayList<>();
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
			
		}catch (WebBaseException_Exception e) {
			logger.error(e);
		} /*catch (RemoteException re){
			logger.error(re);
		}*/
		return l;
	}


}
