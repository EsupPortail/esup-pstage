package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.client.utils.WSUtils;
import gouv.education.apogee.commun.client.ws.geographiemetier.GeographieMetierServiceInterface;
import gouv.education.apogee.commun.client.ws.geographiemetier.GeographieMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.client.ws.geographiemetier.GeographieMetierSoapBindingStub;
import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;

import java.rmi.RemoteException;
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
//			GeographieMetierServiceInterfaceProxy geographieMetierServiceInterface = new GeographieMetierServiceInterfaceProxy();
			GeographieMetierServiceInterface geographieMetierServiceInterface = (GeographieMetierSoapBindingStub) WSUtils.getService(WSUtils.GEOGRAPHIE_SERVICE_NAME,null,null);

			CommuneDTO[] cTab = geographieMetierServiceInterface.recupererCommune(departement, "O", "T");
			if(cTab!=null && cTab.length>0){
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
		}catch (WebBaseException e) {
			logger.error(e);
		} catch (RemoteException re){
			logger.error(re);
		}
		return l;
	}


}
