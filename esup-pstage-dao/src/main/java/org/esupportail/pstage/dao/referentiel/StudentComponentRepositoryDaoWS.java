package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.client.utils.WSUtils;
import gouv.education.apogee.commun.client.ws.offreformationmetier.OffreFormationMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.client.ws.referentielmetier.ReferentielMetierServiceInterface;
import gouv.education.apogee.commun.client.ws.referentielmetier.ReferentielMetierSoapBindingStub;
import gouv.education.apogee.commun.transverse.dto.WSReferentiel.recupererInformationEtabRef.VariableAppliWSEtabRefDTO;
import gouv.education.apogee.commun.transverse.dto.WSReferentiel.recupererSignataire.SignataireWSSignataireDTO;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.DiplomeDTO3;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.EtapeDTO3;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.SECritereDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.VersionDiplomeDTO3;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.VersionEtapeDTO3;
import gouv.education.apogee.commun.transverse.dto.pedagogique.ComposanteDTO3;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.esupportail.pstage.utils.DonneesStatic;
//import org.esupportail.apogee.services.remote.ReadEnseignement;



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
	final transient Logger logger = Logger.getLogger(StudentComponentRepositoryDaoWS.class);

	/**
	 * Can read the education Apogee.
	 */
	//	private ReadEnseignement remoteCriApogeeEns;

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
			ReferentielMetierServiceInterface referentielMetierService = (ReferentielMetierSoapBindingStub) WSUtils.getService(
					WSUtils.REFERENTIEL_SERVICE_NAME);
			// recuperer le nom de l'etablissement
			VariableAppliWSEtabRefDTO[] variableAppli = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_LIB);
			if (variableAppli != null) {
				for (int i = 0; i < variableAppli.length; i++) {
					if (variableAppli[i].getParVap() != null) {
						nomEtabRef = variableAppli[i].getParVap();
					}
				}
			}
			// recuperer adresse 2
			VariableAppliWSEtabRefDTO[] variableAppliAd2 = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_AD2);
			if (variableAppliAd2 != null) {
				for (int i = 0; i < variableAppliAd2.length; i++) {
					if (variableAppliAd2[i].getParVap() != null) {
						ad2 = variableAppliAd2[i].getParVap();
					}
				}
			}
			// recuperer adresse 3
			VariableAppliWSEtabRefDTO[] variableAppliAd3 = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_AD3);
			if (variableAppliAd3 != null) {
				for (int i = 0; i < variableAppliAd3.length; i++) {
					if (variableAppliAd3[i].getParVap() != null) {
						ad3 = variableAppliAd3[i].getParVap();
					}
				}
			}
			// recuperer code postal
			VariableAppliWSEtabRefDTO[] variableAppliCpo = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_CPO);
			if (variableAppliCpo != null) {
				for (int i = 0; i < variableAppliCpo.length; i++) {
					if (variableAppliCpo[i].getParVap() != null) {
						cpo = variableAppliCpo[i].getParVap();
					}
				}
			}
			// recuperer commune
			VariableAppliWSEtabRefDTO[] variableAppliCom = referentielMetierService.recupererInformationEtabRef(DonneesStatic.COD_VAP_ETB_COM);
			if (variableAppliCom != null) {
				for (int i = 0; i < variableAppliCom.length; i++) {
					if (variableAppliCom[i].getParVap() != null) {
						com = variableAppliCom[i].getParVap();
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
			logger.debug("getEtapesRef - universityCode = "+universityCode);
		}
		LinkedHashMap<String,String> lSI = new LinkedHashMap<String, String>();

		OffreFormationMetierServiceInterfaceProxy offreFormationMetierService = new OffreFormationMetierServiceInterfaceProxy();
		
		Object idl = new Object();
		String lib = "";
		try {
			SECritereDTO2 param = new SECritereDTO2();
			
			// Retrait du filtre sur l'annee pour permettre de rattacher les codes etape des annees autres que celle en cours
			param.setTemOuvertRecrutement("O");
			param.setCodEtp("tous");
			param.setCodVrsVet("tous");
			param.setCodDip("aucun");
			param.setCodVrsVdi("aucun");
			param.setCodElp("aucun");
			DiplomeDTO3[] diplomeDTO3 = offreFormationMetierService.recupererSE_v3(param);
			
			for(DiplomeDTO3 ld : diplomeDTO3){
				VersionDiplomeDTO3[] versionDiplomeDTO3 =ld.getListVersionDiplome();
				for(VersionDiplomeDTO3 lvd : versionDiplomeDTO3){
					EtapeDTO3[] etapeDTO3 = lvd.getOffreFormation().getListEtape();
					for(EtapeDTO3 le : etapeDTO3){
						VersionEtapeDTO3[] versionEtapeDTO3=le.getListVersionEtape();
						for(VersionEtapeDTO3 ve : versionEtapeDTO3){
							idl = le.getCodEtp();
							lib = ve.getLibWebVet();
							lSI.put(idl+";"+ve.getCodVrsVet(), lib);
						}
					}
				}
			}
			
			return lSI;
			
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}


	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDao#getSigCompoRef(java.lang.String, java.lang.String)
	 */
	public SignataireRef getSigCompoRef(String universityCode, String composante) {
		SignataireRef sigRef = new SignataireRef();

		try {
			ReferentielMetierServiceInterface referentielMetierService = 
					(ReferentielMetierSoapBindingStub) WSUtils.getService(
							WSUtils.REFERENTIEL_SERVICE_NAME);
			// recuperer le code signataire de la composante
			ComposanteDTO3[] lcomposante = referentielMetierService.recupererComposante_v2(composante, null);
			if (lcomposante != null) {
				for (int i = 0; i < lcomposante.length; i++) {
					if (lcomposante[i].getCodCmp().equals(composante)) {
						// recherche du signataire de la composante
						if (lcomposante[i].getCodSig() != null) {
							SignataireWSSignataireDTO[] signataire = 
									referentielMetierService.recupererSignataire(lcomposante[i].getCodSig(), DonneesStatic.TEM_EN_SVE_O);
							if (signataire != null) {
								for (int j = 0; j < signataire.length; j++) {
									sigRef.setNomSignataireComposante(signataire[j].getNomSig());
									sigRef.setQualiteSignataire(signataire[j].getQuaSig());
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
			ReferentielMetierServiceInterface referentielMetierService = 
					(ReferentielMetierSoapBindingStub) WSUtils.getService(WSUtils.REFERENTIEL_SERVICE_NAME);

			// recuperer la liste des composantes
			ComposanteDTO3[] composante = referentielMetierService.recupererComposante_v2(null, null);

			if (composante != null) {

				if (logger.isDebugEnabled()) {
					logger.debug("StudentComponentRepositoryDaoWS:: getComposantesPrincipalesRef. composante  = " + composante.length);
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

	public void recupComposantes(ComposanteDTO3[] composante){
		for (int i = 0; i < composante.length; i++) {
			Object idl = composante[i].getCodCmp();
			String lib = composante[i].getLibCmp();
			if (composante[i].getTemEnSveCmp().equals("O")) {
				mapComp.put(idl + "", lib);
			}
			// Si la composante en cours de recuperation contient une liste de composantes filles
			// On la parcours egalement
			if (composante[i].getListeComposanteFils() != null && composante[i].getListeComposanteFils().length > 0){
				recupComposantes(composante[i].getListeComposanteFils());
			}
		}
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



}
