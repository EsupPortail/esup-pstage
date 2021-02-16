package org.esupportail.pstage.dao.referentiel;

import fr.wsclient.apogee.OffreFormationMetier.OffreFormationMetierServiceInterface;
import fr.wsclient.apogee.ReferentielMetier.ReferentielMetierServiceInterface;
import fr.wsclient.apogee.ReferentielMetier.VariableAppliWSEtabRefDTO;
import fr.wsclient.apogee.ReferentielMetier.SignataireWSSignataireDTO;
import fr.wsclient.apogee.OffreFormationMetier.DiplomeDTO3;
import fr.wsclient.apogee.OffreFormationMetier.EtapeDTO3;
import fr.wsclient.apogee.OffreFormationMetier.SECritereDTO2;
import fr.wsclient.apogee.OffreFormationMetier.VersionDiplomeDTO3;
import fr.wsclient.apogee.OffreFormationMetier.VersionEtapeDTO32;
import fr.wsclient.apogee.ReferentielMetier.ComposanteDTO3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.esupportail.pstage.utils.DonneesStatic;



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
			ReferentielMetierServiceInterface referentielMetierService = WsUtils.initReferentielMetierService();
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
		} catch (fr.wsclient.apogee.ReferentielMetier.WebBaseException_Exception e) {
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

		OffreFormationMetierServiceInterface offreFormationMetierService = WsUtils.initOffreFormationMetierService(); 

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
			List<DiplomeDTO3> diplomeDTO3 = offreFormationMetierService.recupererSEV3(param);
			
			for(DiplomeDTO3 ld : diplomeDTO3){
				List<VersionDiplomeDTO3> versionDiplomeDTO3 =ld.getListVersionDiplome().getItem();
				for(VersionDiplomeDTO3 lvd : versionDiplomeDTO3){
					List<EtapeDTO3> etapeDTO3 = lvd.getOffreFormation().getListEtape().getItem();
					for(EtapeDTO3 le : etapeDTO3){
						List<VersionEtapeDTO32> versionEtapeDTO3=le.getListVersionEtape().getItem();
						for(VersionEtapeDTO32 ve : versionEtapeDTO3){
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
			ReferentielMetierServiceInterface referentielMetierService = WsUtils.initReferentielMetierService();
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
		} catch (fr.wsclient.apogee.ReferentielMetier.WebBaseException_Exception e) {
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
			ReferentielMetierServiceInterface referentielMetierService = WsUtils.initReferentielMetierService();
			
			// recuperer la liste des composantes
			List<ComposanteDTO3> composante = referentielMetierService.recupererComposanteV2(null, null);

			if (composante != null) {

				if (logger.isDebugEnabled()) {
					logger.debug("StudentComponentRepositoryDaoWS:: getComposantesPrincipalesRef. composante  = " + composante.size());
				}

				recupComposantes(composante);

			}

			return mapComp;

		} catch (fr.wsclient.apogee.ReferentielMetier.WebBaseException_Exception e) {
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
			if (composante.get(i).getListeComposanteFils() != null && composante.get(i).getListeComposanteFils().getComposante().size() > 0){
				recupComposantes(composante.get(i).getListeComposanteFils().getComposante());
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
