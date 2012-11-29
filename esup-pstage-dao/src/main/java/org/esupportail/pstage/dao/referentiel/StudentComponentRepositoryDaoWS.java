package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.transverse.dto.pedagogique.composantedto3.ComposanteDTO3;
import gouv.education.apogee.commun.transverse.dto.wsreferentiel.recupererinformationetabref.variableappliwsetabrefdto.VariableAppliWSEtabRefDTO;
import gouv.education.apogee.commun.transverse.dto.wsreferentiel.recuperersignataire.signatairewssignatairedto.SignataireWSSignataireDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.wssi.services.remote.ReadEnseignement;
import org.esupportail.wssi.services.remote.VersionEtapeDTO;
import org.springframework.util.Assert;

import referentielmetier_18062010_impl.servicesmetiers.commun.apogee.education.gouv.ReferentielMetierServiceInterface;
import referentielmetier_18062010_impl.servicesmetiers.commun.apogee.education.gouv.WebBaseException;



/**
 * 
 * Acces au composantes du personnel personnalise.
 *
 */

@SuppressWarnings("serial")
public class StudentComponentRepositoryDaoWS implements
	StudentComponentRepositoryDao {
	
	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(StudentComponentRepositoryDaoWS.class);


	/**
	 * Can read the education Apogee.
	 */
	private ReadEnseignement remoteCriApogeeEns;
	
	/**
	 * startYearDay.
	 */
	protected String startYearDay;
	/**
	 * startYearMonth.
	 */
	protected String startYearMonth;

	/**
	 * mapComp.
	 */
	LinkedHashMap<String,String> mapComp = new LinkedHashMap<String,String>();
	
	private ReferentielMetierServiceInterface referentielMetierService;

	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDao#getEtabRef(java.lang.String)
	 */
	public EtabRef getEtabRef(String universityCode) {
		String nomEtabRef = "";
		String  adresseEtabRef = "";
		String  ad2 = "";
		String  ad3 = "";
		String  cpo = "";
		String  com = "";
		EtabRef etabRef = new EtabRef();
		try {
			// recuperer le nom de l'etablissement
			List<VariableAppliWSEtabRefDTO> variableAppli = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_LIB);
			if (variableAppli != null) {
				for (int i = 0; i < variableAppli.size(); i++) {
					if (variableAppli.get(i).getParVap() != null) {
						nomEtabRef = variableAppli.get(i).getParVap();
					}
				}
			}
			// recuperer adresse 2
			List<VariableAppliWSEtabRefDTO> variableAppliAd2 = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_AD2);
			if (variableAppliAd2 != null) {
				for (int i = 0; i < variableAppliAd2.size(); i++) {
					if (variableAppliAd2.get(i).getParVap() != null) {
						ad2 = variableAppliAd2.get(i).getParVap();
					}
				}
			}
			// recuperer adresse 3
			List<VariableAppliWSEtabRefDTO> variableAppliAd3 = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_AD3);
			if (variableAppliAd3 != null) {
				for (int i = 0; i < variableAppliAd3.size(); i++) {
					if (variableAppliAd3.get(i).getParVap() != null) {
						ad3 = variableAppliAd3.get(i).getParVap();
					}
				}
			}
			// recuperer code postal
			List<VariableAppliWSEtabRefDTO> variableAppliCpo = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_CPO);
			if (variableAppliCpo != null) {
				for (int i = 0; i < variableAppliCpo.size(); i++) {
					if (variableAppliCpo.get(i).getParVap() != null) {
						cpo = variableAppliCpo.get(i).getParVap();
					}
				}
			}
			// recuperer commune
			List<VariableAppliWSEtabRefDTO> variableAppliCom = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_COM);
			if (variableAppliCom != null) {
				for (int i = 0; i < variableAppliCom.size(); i++) {
					if (variableAppliCom.get(i).getParVap() != null) {
						com = variableAppliCom.get(i).getParVap();
					}
				}
			}
			adresseEtabRef = ad2 + " " + ad3 + " "  + cpo + " " + com;
			etabRef.setNomEtabRef(nomEtabRef);
			etabRef.setAdresseEtabRef(adresseEtabRef);
			return etabRef;
		} catch (WebBaseException e) {
			logger.error("WebBaseException getEtabRef = " + e );
			throw new CommunicationApogeeException(e);
		
		} catch (Exception e) {
			throw new CommunicationApogeeException(e);
		}
	}

	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDao#getEtapesRef(java.lang.String)
	 */
	public LinkedHashMap<String, String> getEtapesRef(String universityCode) {
		// Recuperation des etapes depuis Apogee, cod et lib
		if (logger.isDebugEnabled()) {
			logger.debug("StudentComponentRepositoryDaoWS:: getEtapesRef . universityCode  = "+universityCode);
		}
		LinkedHashMap<String,String> lSI = new LinkedHashMap<String, String>();
		
		try {
			String t = null;
			List<VersionEtapeDTO> letape = remoteCriApogeeEns.getVersionEtapes1(t, null, null, getYear());
			if (letape != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("getEtapesRef. letape  = " + letape.size());
				}
				for (Iterator<VersionEtapeDTO> ite = letape.iterator(); ite.hasNext();) {
					VersionEtapeDTO versionEtapeDTO = (VersionEtapeDTO) ite.next();
					Object idl = versionEtapeDTO.getCodEtp();
					String lib = versionEtapeDTO.getLibWebVet();
					lSI.put(idl + "", lib);
				}
				if (logger.isDebugEnabled()) {
					logger.debug("getEtapesRef. lSI  = " + lSI.size());
				}
			}

		} catch (Exception e) {
			logger.error("StudentComponentRepositoryDaoWS:: getEtapesRef . universityCode  Exception= "+e.getMessage());
			throw new CommunicationApogeeException(e);
		}
	
		return lSI;
	}


	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDao#getSigCompoRef(java.lang.String, java.lang.String)
	 */
	public SignataireRef getSigCompoRef(String universityCode, String composante) {
		SignataireRef sigRef = new SignataireRef();
		
		try {
			// recuperer le code signataire de la composante
			List<ComposanteDTO3> lcomposante = referentielMetierService.recupererComposanteV2(composante, null);
			if (lcomposante != null) {
				for (int i = 0; i < lcomposante.size(); i++) {
					if (lcomposante.get(i).getCodCmp().equals(composante)) {
						// recherche du signataire de la composante
						if (lcomposante.get(i).getCodSig() != null) {
							List<SignataireWSSignataireDTO> signataire = 
							referentielMetierService.recupererSignataire(lcomposante.get(i).getCodSig(), DonneesStatic.TEM_EN_SVE_O);
							if (signataire != null) {
								for (int j = 0; j < signataire.size(); j++) {
									sigRef.setNomSignataireComposante(signataire.get(j).getNomSig());
									sigRef.setQualiteSignataire(signataire.get(j).getQuaSig());
								}
							}
						}
					}
				}
			}
			return sigRef;
		} catch (WebBaseException e) {
			logger.error("WebBaseException getSigCompoRef = " + e );
			throw new CommunicationApogeeException(e);
		
		} catch (Exception e) {
			throw new CommunicationApogeeException(e);
		}
	}



	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDao#getComposantesPrincipalesRef(java.lang.String, java.util.Map)
	 */
	public Map<String, String> getComposantesPrincipalesRef(String universityCode,
		Map<String, String> lesComposantes) {

		if (logger.isDebugEnabled()) {
			logger.debug("StudentComponentRepositoryDaoWS:: getComposantesPrincipalesRef . universityCode  = "+universityCode);
		}
		mapComp = new LinkedHashMap<String,String>();
		
		try {
			// recuperer la liste des composantes
			List<ComposanteDTO3> composante = referentielMetierService.recupererComposanteV2(null, null);
			
			if (composante != null) {
				
				if (logger.isDebugEnabled()) {
					logger.debug("StudentComponentRepositoryDaoWS:: getComposantesPrincipalesRef. composante  = " + composante.size());
				}
				
				recupComposantes(composante);
				
			}
			
			return mapComp;
			
		} catch (WebBaseException e) {
			logger.error("WebBaseException getComposantesRef = " + e );
			throw new CommunicationApogeeException(e);

		} catch (Exception e) {
			throw new CommunicationApogeeException(e);
		}

	}

	public void recupComposantes(List<ComposanteDTO3> composante){
		for (int i = 0; i < composante.size(); i++) {
			Object idl = composante.get(i).getCodCmp();
			String lib = composante.get(i).getLibCmp();
			if (composante.get(i).getTemEnSveCmp().equals("O")) {
				mapComp.put(idl + "", lib);
			}
			// Si la composante en cours de recuperation contient une liste de composantes filles
			// On la parcours egalement
			if (composante.get(i).getListeComposanteFils() != null && composante.get(i).getListeComposanteFils().getItem().size() > 0){
				recupComposantes(composante.get(i).getListeComposanteFils().getItem());
			}
		}
	}

	
	/**
	 * @return String Year
	 */
	public String getYear() {
		String year = "";
		Date d = new Date();
		DateFormat formatY = new SimpleDateFormat("yyyy");
		DateFormat formatM = new SimpleDateFormat("MM");
		DateFormat formatD = new SimpleDateFormat("dd");
		int month = Integer.parseInt(formatM.format(d));
		int day = Integer.parseInt(formatD.format(d));
		try {
			int sYM = Integer.parseInt(this.startYearMonth);
			int sYD = Integer.parseInt(this.startYearDay);
			if (sYM <= month && sYD <= day) {
				year = formatY.format(d);
			} else {
				year = Integer.parseInt(formatY.format(d)) - 1 + "";
			}
		} catch (NumberFormatException e) {
			logger.error("Les valeurs de start.year.day et de start.year.month doivent etre des entiers", e);
			return null; 
		}
		return year.trim();
	}

	/**
	 * @return the remoteCriApogeeEns
	 */
	public ReadEnseignement getRemoteCriApogeeEns() {
		return remoteCriApogeeEns;
	}


	/**
	 * @param remoteCriApogeeEns the remoteCriApogeeEns to set
	 */
	public void setRemoteCriApogeeEns(final ReadEnseignement remoteCriApogeeEns) {
		this.remoteCriApogeeEns = remoteCriApogeeEns;
	}


	/**
	 * @return the startYearDay
	 */
	public String getStartYearDay() {
		return startYearDay;
	}


	/**
	 * @param startYearDay the startYearDay to set
	 */
	public void setStartYearDay(final String startYearDay) {
		this.startYearDay = startYearDay;
	}


	/**
	 * @return the startYearMonth
	 */
	public String getStartYearMonth() {
		return startYearMonth;
	}


	/**
	 * @param startYearMonth the startYearMonth to set
	 */
	public void setStartYearMonth(final String startYearMonth) {
		this.startYearMonth = startYearMonth;
	}
	

	public void setReferentielMetierService(
			ReferentielMetierServiceInterface referentielMetierService) {
		this.referentielMetierService = referentielMetierService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(referentielMetierService,"La propriété referentielMetierService ne doit pas etre null.");
	}
	
	
}
