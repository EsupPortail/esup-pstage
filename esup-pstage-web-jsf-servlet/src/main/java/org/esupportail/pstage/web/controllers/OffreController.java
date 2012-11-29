/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.ExportException;
import org.esupportail.pstage.services.export.CastorService;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.comparator.ComparatorSelectItem;
import org.esupportail.pstage.web.paginators.RechercheOffrePaginator;
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ContratOffreDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheOffreDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.DureeDiffusionDTO;
import org.esupportail.pstagedata.domain.dto.FapN3DTO;
import org.esupportail.pstagedata.domain.dto.FapQualificationSimplifieeDTO;
import org.esupportail.pstagedata.domain.dto.FichierDTO;
import org.esupportail.pstagedata.domain.dto.ModeCandidatureDTO;
import org.esupportail.pstagedata.domain.dto.OffreDTO;
import org.esupportail.pstagedata.domain.dto.OffreDiffusionDTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;
import org.esupportail.pstagedata.domain.dto.TypeOffreDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.springframework.util.StringUtils;


/**
 * AccordController
 */
public class OffreController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propriétés
	 ****************************************************************/

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3430944955282121430L;
	/**
	 * Logger
	 */
	private final Logger logger = Logger.getLogger(this.getClass());
	/**
	 * Page de retour après une modification ou suppression d'offre
	 */
	private String retour=null;
	/**
	 * Action pour renvoyer sur le récap de l'offre en cours
	 */
	private String recap=null;
	/**
	 * Offre actuellement gérée
	 */
	private OffreDTO currentOffre;
	/**
	 * Objet offre utilisé pour l'ajout/modification
	 */
	private OffreDTO formOffre;
	/**
	 * Liste des contrats mise à jour en fonction du type d'offre
	 */
	private List<SelectItem> contratsListening;
	/**
	 * Liste FapN3 mise à jour en fonction de la QualificationSimplifiee
	 */
	private List<SelectItem> fapN3Listening;
	/**
	 * Liste des communes mise à jour en fonction du code postal
	 */
	private List<SelectItem> formOffreCommunesListening=new ArrayList<SelectItem>();
	/**
	 * Vrai si offre avec un fichier ou un lien
	 */
	private boolean avecFichierOuLien;
	/**
	 * 1 si fichier, 2 si lien
	 */
	private int fichierOuLien=0;
	/**
	 * 1 si ajout/modif offre uniquement
	 * 2 si ajout/modif sélection étab + ajout offre
	 * 3 si ajout/modif sélection centre + sélection étab + ajout offre
	 * 4 pour modif depuis moteur de recherche côté entreprise : affichage etab sélectionné (+ modif etab, sélection d'un autre etablissement impossible) + offre
	 * 5 pour modif côté stage : sélection centre + affichage etab sélectionné (+ modif etab, sélection d'un autre etablissement impossible) + offre
	 */
	private int typeAjoutModifOffre=3;

	/**
	 * Liste des offres de l'entreprise actuellement gérée
	 */
	private List<OffreDTO> listeOffres;
	/**
	 * Liste des centres de gestion de la personne actuellement connectée sous de SelectItem
	 */
	private List<SelectItem> listeItemsCurrentCentresGestion;

	//Recherche

	/**
	 * CritereRechercheOffreDTO
	 */
	private CritereRechercheOffreDTO critereRechercheOffre=initCritereRechercheOffre();
	/**
	 * Liste des types d'offres et contrats pour la recherche
	 */
	private List<SelectItem> rechTypesContratsOffre;
	/**
	 * Type ou contrat sélectionné pour la recherche
	 */
	private String rechTypeOuContrat;
	/**
	 * Resultats de la recherche d'offre
	 */
	private List<OffreDTO> resultatsRechercheOffre;
	/**
	 * Vrai si recherche avancée, faux si recherche simple
	 */
	private boolean rechercheAvancee=false;
	/**
	 * RechercheOffrePaginator
	 */
	private RechercheOffrePaginator rechercheOffrePaginator;

	//Diffusion à d'autres centres
	/**
	 * Nombre d'éléments dans la liste offresDiffusion de currentOffre
	 */
	private int currentOffreSizeOffresDiffusion;
	/**
	 * Liste des centres établissement
	 */
	private List<SelectItem> listesCentresGestionEtablissement=new ArrayList<SelectItem>();
	/**
	 * Liste des centres établissement
	 */
	private List<CentreGestionDTO> listesCGEtab=null;
	/**
	 * Liste des centres de l'université après sélection du centre établissement
	 */
	private List<SelectItem> listesCentresGestionUniversite=new ArrayList<SelectItem>();
	/**
	 * Liste des centres à diffuser
	 */
	private List<SelectItem> listesCentreGestionUniversiteADiffuser=new ArrayList<SelectItem>();
	/**
	 * Id du centre établissement sélectionné
	 */
	private int idCentreEtablissementSelect;
	/**
	 * Ids des centres de gestion sélectionnés
	 */
	private List<Integer> idsCentreGestionUniversiteSelect;
	/**
	 * Ids des centres de gestion à diffuser sélectionné
	 */
	private List<Integer> idsCentreGestionUniversiteADiffuser;
	/**
	 * Centre de gestion utilisé pour le dépot anonyme
	 */
	private CentreGestionDTO centreGestionDepotAnonyme;

	/**
	 * EtablissementController
	 */
	private EtablissementController etablissementController;
	
	/**
	 * Service to generate Xml.
	 */
	private CastorService castorService;

	/**
	 * Liste des durees de diffusion disponibles
	 */
	private List<SelectItem> dureesDiffusion;
	
	/**
	 * Duree de diffusion choisie
	 */
	private int dureeDiffusion;

	/**
	 * on diffuse l'offre après ajout/modif si vrai
	 */
	private boolean diffusionDirecte = false;

	/**
	 * Nombre d'offres à diffuser (pour affichage _menu.jsp partie entreprise)
	 */
	private int offreADiffuser=0;
	
	/**
	 * Bean constructor.
	 */
	public OffreController() {
		super();
	}

	/* ***************************************************************
	 * Actions
	 ****************************************************************/

	/**
	 * Gestion des offres (entreprise)
	 * @return String
	 */
	public String goToGestionOffres(){
		String ret="gestionOffres";
		return ret;
	}

	/**
	 * Gestion des offres (stage)
	 * @return String
	 */
	public String goToOffresEtablissement(){
		String ret="offresEtablissement";
		loadOffres();
		return ret;
	}

	/**
	 * Chargement des offres
	 */
	public void loadOffres(){
		if(getSessionController().getCurrentManageStructure()!=null){
			this.listeOffres=getOffreDomainService().
			getOffresFromIdStructureAndIdsCentreGestion(
					getSessionController().getCurrentManageStructure().getIdStructure(), 
					getSessionController().getCurrentIdsCentresGestion(),getSessionController().getCurrentAuthEtudiant()!=null);
			if(this.listeOffres!=null && !this.listeOffres.isEmpty()){
				for(OffreDTO o : this.listeOffres){
					o.setStructure(getSessionController().getCurrentManageStructure());
				}
			}
			sortListesOffres();
		}
	}

	/**
	 * Tri
	 */
	public void sortListesOffres(){
		if(this.listeOffres!=null && !this.listeOffres.isEmpty()){
			Collections.sort(this.listeOffres, new Comparator<OffreDTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(OffreDTO o1, OffreDTO o2) {
					return o1.getIntitule().compareToIgnoreCase(o2.getIntitule());
				}
			});
		}
	}

	/* ***************************************************************
	 * Ajout d'une offre
	 ****************************************************************/

	/**
	 * @return String
	 */
	public String goToEntrepriseCreationOffre(){
		this.formOffre=new OffreDTO();
		this.formOffre.setStructure(getSessionController().getCurrentManageStructure());
		this.formOffre.setIdStructure(this.formOffre.getStructure().getIdStructure());
		this.centreGestionDepotAnonyme=null;
		this.formOffre.setIdCentreGestion(getCentreGestionDomainService().getCentreEntreprise().getIdCentreGestion());
		//Indemnités à vrai par défaut
		this.formOffre.setRemuneration(true);
		this.avecFichierOuLien=false;
		this.fichierOuLien=0;
		this.contratsListening=null;
		this.fapN3Listening=null;
		return "creationOffre";
	}

	/**
	 * Etape 01 : Sélection du centre de gestion
	 * @return String
	 */
	public String goToCreationOffreSelectionCentre(){
		String ret="creationCentreEtabOffre";
		if(this.typeAjoutModifOffre==3)this.formOffre=new OffreDTO();
		this.centreGestionDepotAnonyme=null;
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToCreationOffreRechEtab(){
		return "_creationOffreEtape02Etab";
	}

	/**
	 * Etape 02 : Sélection établissement
	 * @return String
	 */
	public String goToCreationOffreSelectionEtab(){
		String ret="creationEtabOffre";
		if(this.typeAjoutModifOffre==2)this.formOffre=new OffreDTO();
		this.centreGestionDepotAnonyme=null;
		return ret;
	}

	/**
	 * Etape 03 : Création établissement
	 * @return a String
	 */
	public String goToCreationOffreCreaEtab(){
		this.etablissementController.goToCreationEtablissement();
		return "_creationOffreEtape03CreaEtab";
	}

	/**
	 * Bouton d'ajout d'une offre à l'étape 03
	 * @return String
	 */
	public String ajouterEtablissement(){
		String ret=null;
		ret=this.etablissementController.ajouterEtablissement();
		if(ret!=null && this.etablissementController.getFormStructure()!=null){
			this.etablissementController.getRechercheController().setResultatRechercheStructure(this.etablissementController.getFormStructure());
			this.etablissementController.setFormStructure(null);
			ret="_creationOffreEtape04DetailsEtab";
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToCreationOffreModifEtab(){
		String ret=null;
		ret=this.etablissementController.goToModificationEtablissement();
		ret="_creationOffreEtape05ModifEtab";
		return ret;
	}

	/**
	 * @return String
	 */
	public String modifierEtablissement(){
		String ret=null;
		ret=this.etablissementController.modifierEtablissement();
		FacesContext fc = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ifm = fc.getMessages("formModifEtab");
		while(ifm.hasNext()){
			FacesMessage fm = ifm.next();
			fc.addMessage("formCreationOffre:include:formModifEtab", new FacesMessage(FacesMessage.SEVERITY_ERROR,fm.getSummary(),fm.getDetail()));
			ifm.remove();
		}
		ifm = fc.getMessages("formAffEtab");
		while(ifm.hasNext()){
			FacesMessage fm = ifm.next();
			fc.addMessage("formCreationOffre:include:formAffEtab", new FacesMessage(fm.getSummary(),fm.getDetail()));
			ifm.remove();
		}
		if(StringUtils.hasText(ret)){
			ret="_creationOffreEtape04DetailsEtab";
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToCreationOffreDetailsEtab(){
		String ret="_creationOffreEtape04DetailsEtab";		
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToCreationOffreEtape1(){
		if(this.typeAjoutModifOffre==1)this.formOffre=new OffreDTO();
		this.formOffre.setIdStructure(this.formOffre.getStructure().getIdStructure());
		getSessionController().setCurrentManageStructure(this.formOffre.getStructure());
		getSessionController().setMenuGestionEtab(false);
		//Chargement contacts uniquement pour le centre sélectionné
		ArrayList<CentreGestionDTO> curCentresTmp = (ArrayList<CentreGestionDTO>) getSessionController().getCurrentCentresGestion();
		ArrayList<CentreGestionDTO> centreContacts = new ArrayList<CentreGestionDTO>();
		CentreGestionDTO cgTmp = new CentreGestionDTO();
		cgTmp.setIdCentreGestion(this.formOffre.getIdCentreGestion());
		cgTmp.setNomCentre("");
		if(curCentresTmp!=null && !curCentresTmp.isEmpty() && curCentresTmp.indexOf(cgTmp)>0)centreContacts.add(curCentresTmp.get(curCentresTmp.indexOf(cgTmp)));
		if(centreGestionDepotAnonyme!=null && centreGestionDepotAnonyme.getIdCentreGestion()>0){
			centreContacts=new ArrayList<CentreGestionDTO>();
			centreContacts.add(centreGestionDepotAnonyme);
		}
		getSessionController().setCurrentCentresGestion(centreContacts);		
		this.etablissementController.loadContactsServices();
		getSessionController().setCurrentCentresGestion(curCentresTmp);
		//Indemnités à vrai par défaut
		this.formOffre.setRemuneration(true);
		this.avecFichierOuLien=false;
		this.fichierOuLien=0;
		this.contratsListening=null;
		this.fapN3Listening=null;
		return "_creationOffreEtape1";
	}

	/**
	 * Envoi vers l'Etape 2 : Saisie de l'offre
	 * @return String
	 */
	public String goToCreationOffreEtape2(){
		String ret=null;
		ret="_creationOffreEtape2";
		this.formOffre.setLieuPays(this.formOffre.getStructure().getPays());
		this.formOffre.setLieuCodePostal(this.formOffre.getStructure().getCodePostal());
		this.formOffre.setLieuCommune(this.formOffre.getStructure().getCommune());
		this.formOffre.setCodeCommune(this.formOffre.getStructure().getCodeCommune());
		if(getSessionController().isRecupererCommunesDepuisApogee() &&
				getBeanUtils().isFrance(this.formOffre.getLieuPays())){
			List<SelectItem> lTmp = majCommunes(""+this.formOffre.getLieuCodePostal());
			if(lTmp!=null && !lTmp.isEmpty()){
				this.formOffreCommunesListening=lTmp;
			}else{
				this.formOffreCommunesListening=new ArrayList<SelectItem>();
			}
		}
		if(this.avecFichierOuLien){
			switch (this.fichierOuLien) {
			case 1:
				this.formOffre.setAvecFichier(true);
				this.formOffre.setAvecLien(false);
				this.formOffre.setLienAttache("");
				try {
					FichierDTO o = new FichierDTO();
					o.setNomFichier("");
					int idFichier = getOffreDomainService().addFichier(o);
					o.setIdFichier(idFichier);
					this.formOffre.setFichier(o);
					getSessionController().getOffreFileUploadBean().setPrefix(idFichier);
				} catch (DataAddException e) {
					logger.error(e.fillInStackTrace());
				} catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
				}
				break;
			case 2:
				this.formOffre.setAvecFichier(false);
				this.formOffre.setAvecLien(true);
				this.formOffre.setLienAttache("http://");
				break;
			default:
				ret=null;
			break;
			}
		}
		this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		//Màj liste des contrats
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(this.formOffre.getIdTypeOffre());
		if(l!=null && !l.isEmpty()){
			this.contratsListening=new ArrayList<SelectItem>();
			for(ContratOffreDTO c : l){
				this.contratsListening.add(new SelectItem(c,c.getLibelle()));
			}
		}else{
			this.contratsListening=null;
		}
		//Reset de la durée de diffusion
		this.dureeDiffusion = 1;
		
		return ret;
	}

	/**
	 * Envoi vers l'étape 3
	 * Saisie des contacts ou Sélection fichier/saisie lien
	 * @return String
	 */
	public String goToCreationOffreEtape3(){
		String ret=null;
		if(getBeanUtils().isFrance(this.formOffre.getLieuPays()) && getSessionController().isRecupererCommunesDepuisApogee()){
			if(this.formOffre.getCodeCommune()>0){
				//Récupération de la commune pour en avoir le libellé
				CommuneDTO c = getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.formOffre.getLieuCodePostal(), ""+this.formOffre.getCodeCommune());
				if(c!=null){
					this.formOffre.setLieuCommune(c.getLibCommune());					
				}
			}
		}
		if(this.avecFichierOuLien){
			ret="_creationOffreEtape3";
		}else{
			ret="_creationOffreEtape3Contacts";
		}
		return ret;
	}

	/**
	 * Ajout de l'offre en base
	 * @return String
	 */
	public String ajoutOffre(){
		String ret=_ajoutOffre();
		if(this.formOffre.getIdOffre()>0){
			if(getSessionController().getCurrentManageStructure()!=null &&
					getSessionController().getCurrentManageStructure().getIdStructure()==this.formOffre.getIdStructure()){
				if(this.listeOffres==null) this.listeOffres=new ArrayList<OffreDTO>();
				this.listeOffres.add(this.formOffre);
				this.currentOffre = this.formOffre;
				this.formOffre=new OffreDTO();
			}
		}
		return ret;
	}

	/**
	 * Méthode d'ajout d'une offre subdivisée pour gérer l'ajout d'offre d'une entreprise et l'ajout d'offre d'un centre (ne nécessite pas la maj de la liste des offres)
	 * @return String
	 */
	public String _ajoutOffre(){
		String ret=null;
		if(this.centreGestionDepotAnonyme!=null){
			this.formOffre.setLoginCreation("depotAnonyme");
		}else{
			this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
		}
		if(this.formOffre.getLieuPays()!=null)this.formOffre.setIdLieuPays(this.formOffre.getLieuPays().getId());
		if(this.formOffre.getFapQualificationSimplifiee()!=null)this.formOffre.setIdQualificationSimplifiee(this.formOffre.getFapQualificationSimplifiee().getId());
		//if(this.formOffre.getFapN3()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN3().getCode());
		if(this.formOffre.getFapN1()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN1().getCode());
		if(this.formOffre.getTypeOffre()!=null)this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		else this.formOffre.setIdTypeOffre(0);
		if(this.formOffre.getContratOffre()!=null)this.formOffre.setIdContratOffre(this.formOffre.getContratOffre().getId());
		else this.formOffre.setIdContratOffre(0);
		if(this.formOffre.getNiveauFormation()!=null)this.formOffre.setIdNiveauFormation(this.formOffre.getNiveauFormation().getId());
		else this.formOffre.setIdNiveauFormation(0);
		this.formOffre.setAnneeUniversitaire(getBeanUtils().getAnneeUniversitaireCourante(new Date()));
		this.formOffre.setCentreGestion(getCentreGestionDomainService().getCentreGestion(this.formOffre.getIdCentreGestion()));
		int idOffreAjoutee=0;
		if(this.avecFichierOuLien){
			this.formOffre.setIdTempsTravail(0);
			this.formOffre.setIdUniteDuree(0);
			this.formOffre.setModesCandidature(null);
			this.formOffre.setIdsModeCandidature(null);

			this.formOffre.setContactCand(null);
			this.formOffre.setContactInfo(null);
			this.formOffre.setIdContactCand(0);
			this.formOffre.setIdContactInfo(0);
			switch (this.fichierOuLien) {
			case 1:
				if(this.formOffre.getIdFichier()>0){
					try{
						this.formOffre.setAvecFichier(true);
						this.formOffre.setAvecLien(false);
						this.formOffre.setLienAttache("");
						idOffreAjoutee = getOffreDomainService().addOffre(this.formOffre);
						this.formOffre.setIdOffre(idOffreAjoutee);
						this.formOffre.setDateCreation(new Date());
						this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
						ret="_creationOffreEtape4Confirmation";
						addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION", this.formOffre.getIdOffre());
						mailAjout();
					}catch (DataAddException e) {
						logger.error(e.fillInStackTrace());
					}catch (WebServiceDataBaseException e) {
						logger.error(e.fillInStackTrace());
					}
				}else{
					addErrorMessage("formCreationOffre:include:opUploadFile:uploadFile", "OFFRE.SELECTIONFICHIER.OBLIGATOIRE");
				}
				break;
			case 2:
				try{
					this.formOffre.setFichier(null);
					this.formOffre.setIdFichier(0);
					this.formOffre.setAvecFichier(false);				
					this.formOffre.setAvecLien(true);
					idOffreAjoutee = getOffreDomainService().addOffre(this.formOffre);
					this.formOffre.setIdOffre(idOffreAjoutee);
					this.formOffre.setDateCreation(new Date());
					this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
					ret="_creationOffreEtape4Confirmation";
					addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION", this.formOffre.getIdOffre());
					mailAjout();
				}catch (DataAddException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.CREATION.ERREURAJOUT");
				}catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.CREATION.ERREURAJOUT");
				}
				break;
			}
		}else{
			//Suppression de l'ancien fichier/lien
			this.formOffre.setFichier(null);
			this.formOffre.setIdFichier(0);
			this.formOffre.setLienAttache(null);
			this.formOffre.setAvecFichier(false);
			this.formOffre.setAvecLien(false);
			if(this.formOffre.getIdFichier()>0){
				try{
					if(this.formOffre.getFichier()!=null
							&& StringUtils.hasText(this.formOffre.getFichier().getNomFichier())){
						getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
								this.formOffre.getIdFichier(), this.formOffre.getFichier().getNomFichier());
					}
					getOffreDomainService().deleteFichier(this.formOffre.getIdFichier());
				}catch (DataDeleteException e) {
					logger.error(e.fillInStackTrace());
				}catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
				}
			}

			if(this.formOffre.getTempsTravail()!=null)this.formOffre.setIdTempsTravail(this.formOffre.getTempsTravail().getId());
			else this.formOffre.setIdTempsTravail(0);
			if(this.formOffre.getUniteDuree()!=null)this.formOffre.setIdUniteDuree(this.formOffre.getUniteDuree().getId());
			else this.formOffre.setIdUniteDuree(0);
			if(this.formOffre.getModesCandidature()!=null){
				ArrayList<Integer> l = new ArrayList<Integer>();
				for(ModeCandidatureDTO m : this.formOffre.getModesCandidature()){
					l.add(m.getId());
				}
				if(!l.isEmpty())this.formOffre.setIdsModeCandidature(l);
				else this.formOffre.setIdsModeCandidature(null);
			}
			if(this.formOffre.getContactCand()!=null){
				try{
					this.formOffre.setIdContactCand(this.formOffre.getContactCand().getId());
					if(this.formOffre.getContactInfo()!=null)this.formOffre.setIdContactInfo(this.formOffre.getContactInfo().getId());
					this.formOffre.setFichier(null);
					this.formOffre.setIdFichier(0);
					idOffreAjoutee = getOffreDomainService().addOffre(this.formOffre);
					this.formOffre.setIdOffre(idOffreAjoutee);
					this.formOffre.setDateCreation(new Date());
					this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
					ret="_creationOffreEtape4Confirmation";
					addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION", this.formOffre.getIdOffre());
					mailAjout();
				}catch (DataAddException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.CREATION.ERREURAJOUT");
				}catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.CREATION.ERREURAJOUT");
				}
			}else{
				addErrorMessage("formCreationOffre:include:contactCand", "OFFRE.SELECTIONCONTACTCAND.OBLIGATOIRE");
			}
		}
		if(this.diffusionDirecte){
			this.currentOffre = this.formOffre;
			this.diffuserOffre();
		} else if (!this.formOffre.isEstDiffusee()){
			addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION.DIFFUSION", this.formOffre.getIdOffre());
		}
		this.diffusionDirecte = false;
		return ret;
	}
	
	/**
	 * 
	 */
	public void mailAjout(){
		//Envoi mail sur la mailing list entreprise
		String infoPersonne="";
		if(getSessionController().isAdminPageAuthorized() && getSessionController().getCurrentAuthAdminStructure()!=null){
			infoPersonne+=getSessionController().getCurrentAuthAdminStructure().getNom()+" "+getSessionController().getCurrentAuthAdminStructure().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
		}else if(getSessionController().isPageAuthorized() && getSessionController().getCurrentAuthContact()!=null){
			infoPersonne+=getSessionController().getCurrentAuthContact().getNom()+" "+getSessionController().getCurrentAuthContact().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
		}else{
			infoPersonne+=getSessionController().getCurrentLogin();
		}
		if(centreGestionDepotAnonyme!=null && centreGestionDepotAnonyme.getIdCentreGestion()>0){
			if(StringUtils.hasText(centreGestionDepotAnonyme.getMail())){
				InternetAddress ia = null;
				try {
					ia = new InternetAddress(centreGestionDepotAnonyme.getMail());
					infoPersonne="depot anonyme";
					getSmtpService().send(
							ia, 
							getString("MAIL.ADMIN.OFFRE.SUJETAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getStructure().printAdresse(), infoPersonne),
							getString("MAIL.ADMIN.OFFRE.MESSAGEAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(),this.formOffre.getStructure().printAdresse(), infoPersonne),
							""
					);
				} catch (AddressException e) {
					//
				}
			}
		}else if(getSessionController().isMailingListEntrMailAvertissementAjoutOffre() && StringUtils.hasText(getSessionController().getMailingListEntr())
				&& (getSessionController().isAdminPageAuthorized() || getSessionController().isPageAuthorized())){
			getSmtpService().send(
					getSessionController().getMailingListEntrIA(), 
					getString("MAIL.ADMIN.OFFRE.SUJETAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getStructure().printAdresse(), infoPersonne),
					getString("MAIL.ADMIN.OFFRE.MESSAGEAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(),getSessionController().getCurrentManageStructure().printAdresse(), infoPersonne),
					""
			);
		}
	}

	/* ***************************************************************
	 * Modification d'une offre
	 ****************************************************************/
	
	/**
	 * @return String
	 */
	public String goToEntrepriseModificationOffre(){
		String ret=null;
		ret=_goToEntrepriseModificationOffre("modificationOffre");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToEntrepriseModificationOffre3(){
		String ret=null;
		ret=_goToEntrepriseModificationOffre("modificationOffre3");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToEntrepriseModificationOffre3C(){
		String ret=null;
		ret=_goToEntrepriseModificationOffre("modificationOffre3C");
		return ret;
	}

	/**
	 * @param retr 
	 * @return String
	 */
	public String _goToEntrepriseModificationOffre(String retr){
		String ret=null;
		this.formOffre=(OffreDTO) this.currentOffre.clone();
		if(this.formOffre!=null){
			if(this.formOffre.isAvecFichier() || this.formOffre.isAvecLien()){
				this.avecFichierOuLien=true;
				if(this.formOffre.isAvecFichier()){
					this.fichierOuLien=1;
					if(this.currentOffre.getFichier()!=null){
						this.formOffre.setFichier((FichierDTO)this.currentOffre.getFichier().clone());
					}
				}
				else if(this.formOffre.isAvecLien())this.fichierOuLien=2;
			}else{
				this.avecFichierOuLien=false;
				this.fichierOuLien=0;
			}
			ret=retr;
		}
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtab(){
		String ret=null;
		ret=_goToModificationOffreEtab("modificationEtabOffre");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtab1(){
		String ret=null;
		ret=_goToModificationOffreEtab("modificationOffre");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtab3(){
		String ret=null;
		ret=_goToModificationOffreEtab("modificationOffre3");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtab3C(){
		String ret=null;
		ret=_goToModificationOffreEtab("modificationOffre3C");
		return ret;
	}

	/**
	 * @param retr 
	 * @return String
	 */
	public String _goToModificationOffreEtab(String retr){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			if(this.typeAjoutModifOffre==2)this.formOffre=(OffreDTO) this.currentOffre.clone();
			if(this.formOffre!=null){
				if(this.formOffre.isAvecFichier() || this.formOffre.isAvecLien()){
					this.avecFichierOuLien=true;
					if(this.formOffre.isAvecFichier()){
						this.fichierOuLien=1;
						if(this.currentOffre.getFichier()!=null){
							this.formOffre.setFichier((FichierDTO)this.currentOffre.getFichier().clone());
						}
					}
					else if(this.formOffre.isAvecLien())this.fichierOuLien=2;
				}else{
					this.avecFichierOuLien=false;
					this.fichierOuLien=0;
				}
				ret=retr;
			}
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToModificationOffreEtabCentre(){
		String ret=null;
		ret=_goToModificationOffreEtabCentre("modificationCentreEtabOffre");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtabCentre04(){
		String ret=null;
		ret=_goToModificationOffreEtabCentre("modificationCentreEtabOffre04");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtabCentre1(){
		String ret=null;
		ret=_goToModificationOffreEtabCentre("modificationCentreEtabOffre1");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtabCentre3(){
		String ret=null;
		ret=_goToModificationOffreEtabCentre("modificationCentreEtabOffre3");
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToModificationOffreEtabCentre3C(){
		String ret=null;
		ret=_goToModificationOffreEtabCentre("modificationCentreEtabOffre3C");
		return ret;
	}
	
	/**
	 * @param retr
	 * @return String
	 */
	public String _goToModificationOffreEtabCentre(String retr){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			if(!isListeCurrentIdsCentresGestionContainsIdCGCurrentOffre()){
				CentreGestionDTO c = getCentreGestionDomainService().getCentreGestion(this.currentOffre.getIdCentreGestion());
				if(c!=null)this.currentOffre.setCentreGestion(c);
				else return ret;
			}else{
				if(getSessionController().getCurrentIdsCentresGestion()!=null &&
						!getSessionController().getCurrentIdsCentresGestion().isEmpty()){
					for(CentreGestionDTO c : getSessionController().getCurrentCentresGestion()){
						if(c.getIdCentreGestion()==this.currentOffre.getIdCentreGestion()){
							this.currentOffre.setCentreGestion(c);
							break;
						}
					}
				}
			}
			if(this.typeAjoutModifOffre==3)this.formOffre=(OffreDTO) this.currentOffre.clone();
			if(this.formOffre!=null){
				if(this.formOffre.isAvecFichier() || this.formOffre.isAvecLien()){
					this.avecFichierOuLien=true;
					if(this.formOffre.isAvecFichier()){
						this.fichierOuLien=1;
						if(this.currentOffre.getFichier()!=null){
							this.formOffre.setFichier((FichierDTO)this.currentOffre.getFichier().clone());
						}
					}
					else if(this.formOffre.isAvecLien())this.fichierOuLien=2;
				}else{
					this.avecFichierOuLien=false;
					this.fichierOuLien=0;
				}
				ret=retr;
			}
		}
		return ret;
	}

	/**
	 * Vrai si currentIdsCentresGestion contains l'id du centre de gestion de l'offre courante : currentOffre
	 * Auquel cas modification possible du centre de gestion pour une offre
	 * @return boolean
	 */
	public boolean isListeCurrentIdsCentresGestionContainsIdCGCurrentOffre(){
		boolean ret=false;
		if(getSessionController().getCurrentIdsCentresGestion()!=null &&
				!getSessionController().getCurrentIdsCentresGestion().isEmpty() &&
				((ArrayList<Integer>)getSessionController().getCurrentIdsCentresGestion()).
				contains(this.currentOffre.getIdCentreGestion())){
			ret=true;
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToModificationOffreModifEtab(){
		String ret=null;
		ret=this.etablissementController.goToModificationEtablissement();
		ret="_modificationOffreEtape05ModifEtab";
		return ret;
	}

	/**
	 * @return String
	 */
	public String modifierOffreModifierEtablissement(){
		String ret=null;
		ret=this.etablissementController.modifierEtablissement();
		this.currentOffre.setStructure(this.etablissementController.getFormStructure());
		FacesContext fc = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ifm = fc.getMessages("formModifEtab");
		while(ifm.hasNext()){
			FacesMessage fm = ifm.next();
			fc.addMessage("formModificationOffre:include:formModifEtab", new FacesMessage(FacesMessage.SEVERITY_ERROR,fm.getSummary(),fm.getDetail()));
			ifm.remove();
		}
		ifm = fc.getMessages("formAffEtab");
		while(ifm.hasNext()){
			FacesMessage fm = ifm.next();
			fc.addMessage("formModificationOffre:include:formAffEtab", new FacesMessage(fm.getSummary(),fm.getDetail()));
			ifm.remove();
		}
		if(StringUtils.hasText(ret)){
			ret="_modificationOffreEtape04DetailsEtab";
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToModificationOffreDetailsEtab(){
		String ret="_modificationOffreEtape04DetailsEtab";		
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToModificationOffreEtape1(){
		if(this.typeAjoutModifOffre==1)this.formOffre=(OffreDTO) this.currentOffre.clone();
		if(this.currentOffre.getFichier()!=null){
			this.formOffre.setFichier((FichierDTO)this.currentOffre.getFichier().clone());
		}
		getSessionController().setCurrentManageStructure(this.formOffre.getStructure());
		getSessionController().setMenuGestionEtab(false);
		this.etablissementController.loadContactsServices();
		return "_modificationOffreEtape1";
	}

	/**
	 * Envoi vers l'Etape 2 : Saisie de l'offre
	 * @return String
	 */
	public String goToModificationOffreEtape2(){
		String ret=null;
		ret="_modificationOffreEtape2";
		if(this.formOffre.getIdLieuPays()<=0){
			this.formOffre.setLieuPays(this.formOffre.getStructure().getPays());
			if(getSessionController().isRecupererCommunesDepuisApogee() &&
					getBeanUtils().isFrance(this.formOffre.getLieuPays())){
				List<SelectItem> lTmp = majCommunes(""+this.formOffre.getLieuCodePostal());
				if(lTmp!=null && !lTmp.isEmpty()){
					this.formOffreCommunesListening=lTmp;
				}else{
					this.formOffreCommunesListening=new ArrayList<SelectItem>();
				}
			}
		}
		if(this.avecFichierOuLien){
			switch (this.fichierOuLien) {
			case 1:
				//Si l'offre modifiée était déjà avec un fichier, on ne fait rien
				if(!this.currentOffre.isAvecFichier()){
					this.formOffre.setAvecFichier(true);
					this.formOffre.setAvecLien(false);
					this.formOffre.setLienAttache("");
					try {
						FichierDTO o = new FichierDTO();
						o.setNomFichier("");
						int idFichier = getOffreDomainService().addFichier(o);
						o.setIdFichier(idFichier);
						this.formOffre.setFichier(o);
						getSessionController().getOffreFileUploadBean().setPrefix(idFichier);
					} catch (DataAddException e) {
						logger.error(e.fillInStackTrace());
					} catch (WebServiceDataBaseException e) {
						logger.error(e.fillInStackTrace());
					}
				}
				break;
			case 2:
				//Si l'offre modifiée était déjà avec un lien, on ne fait rien
				if(!this.currentOffre.isAvecLien()){						
					this.formOffre.setAvecFichier(false);
					this.formOffre.setAvecLien(true);
					this.formOffre.setLienAttache("http://");
				}
				break;
			default:
				ret=null;
			break;
			}
		}
		this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		//Màj liste des contrats
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(this.formOffre.getIdTypeOffre());
		if(l!=null && !l.isEmpty()){
			this.contratsListening=new ArrayList<SelectItem>();
			for(ContratOffreDTO c : l){
				this.contratsListening.add(new SelectItem(c,c.getLibelle()));
			}
		}else{
			this.contratsListening=null;
		}
		this.fapN3Listening=getFapN3FromNumQualif(this.formOffre.getIdQualificationSimplifiee());
		if(getSessionController().isRecupererCommunesDepuisApogee() &&
				getBeanUtils().isFrance(this.formOffre.getLieuPays())){
			List<SelectItem> lTmp = majCommunes(""+this.formOffre.getLieuCodePostal());
			if(lTmp!=null && !lTmp.isEmpty()){
				this.formOffreCommunesListening=lTmp;
			}else{
				this.formOffreCommunesListening=new ArrayList<SelectItem>();
			}
		}
		return ret;
	}

	/**
	 * Envoi vers l'étape 3
	 * Saisie des contacts ou Sélection fichier/saisie lien
	 * @return String
	 */
	public String goToModificationOffreEtape3(){
		String ret=null;
		if(getBeanUtils().isFrance(this.formOffre.getLieuPays()) && getSessionController().isRecupererCommunesDepuisApogee()){
			if(this.formOffre.getCodeCommune()>0){
				//Récupération de la commune pour en avoir le libellé
				CommuneDTO c = getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.formOffre.getLieuCodePostal(), ""+this.formOffre.getCodeCommune());
				if(c!=null){
					this.formOffre.setLieuCommune(c.getLibCommune());					
				}
			}
		}
		if(this.avecFichierOuLien){
			ret="_modificationOffreEtape3";
		}else{
			ret="_modificationOffreEtape3Contacts";
		}
		
		return ret;
	}

	/**
	 * Modification de l'offre 
	 * @return String
	 */
	public String modificationOffre(){
		String ret=_modificationOffre();
		if(StringUtils.hasText(ret)){
			this.currentOffre=(OffreDTO) this.formOffre.clone();
			if(this.formOffre.getFichier()!=null) this.currentOffre.setFichier((FichierDTO)(this.formOffre.getFichier().clone()));
			this.formOffre=null;
			if(this.listeOffres!=null && this.listeOffres.contains(this.currentOffre)){
				int id = this.listeOffres.indexOf(this.currentOffre);
				if(id>0){
					this.listeOffres.set(id,this.currentOffre);
				}
			}
			if(this.resultatsRechercheOffre!=null && this.resultatsRechercheOffre.contains(this.currentOffre)){
				//rechercherOffre();
				int id = this.resultatsRechercheOffre.indexOf(this.currentOffre);
				if(id>0){
					this.resultatsRechercheOffre.set(id,this.currentOffre);
					reloadRechercheOffrePaginator();
				}
			}
		}
		return ret;
	}

	/**
	 * Modification d'une offre depuis le moteur de recherche
	 * @return String
	 */
	//	public String modificationOffreRecherche(){
	//		String ret=_modificationOffre();
	//		if(StringUtils.hasText(ret)){
	//			rechercherOffre();
	//		}
	//		return ret;
	//	}

	/**
	 * Méthode modification de l'offre subDivisée en 2 pour gérer la modification par une entreprise et par un centre
	 * @return String
	 */
	public String _modificationOffre(){
		String ret=null;
		this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
		if(this.formOffre.getLieuPays()!=null)this.formOffre.setIdLieuPays(this.formOffre.getLieuPays().getId());
		if(this.formOffre.getFapQualificationSimplifiee()!=null)this.formOffre.setIdQualificationSimplifiee(this.formOffre.getFapQualificationSimplifiee().getId());
		//if(this.formOffre.getFapN3()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN3().getCode());
		if(this.formOffre.getFapN1()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN1().getCode());
		if(this.formOffre.getTypeOffre()!=null)this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		else this.formOffre.setIdContratOffre(0);
		if(this.formOffre.getContratOffre()!=null)this.formOffre.setIdContratOffre(this.formOffre.getContratOffre().getId());
		else this.formOffre.setIdContratOffre(0);
		if(this.formOffre.getNiveauFormation()!=null)this.formOffre.setIdNiveauFormation(this.formOffre.getNiveauFormation().getId());
		else this.formOffre.setIdNiveauFormation(0);
		this.formOffre.setAnneeUniversitaire(getBeanUtils().getAnneeUniversitaireCourante(new Date()));
		if(this.avecFichierOuLien){
			this.formOffre.setTempsTravail(null);
			this.formOffre.setIdTempsTravail(0);
			this.formOffre.setUniteDuree(null);
			this.formOffre.setIdUniteDuree(0);
			this.formOffre.setModesCandidature(null);
			this.formOffre.setIdsModeCandidature(null);

			this.formOffre.setContactCand(null);
			this.formOffre.setContactInfo(null);
			this.formOffre.setIdContactCand(0);
			this.formOffre.setIdContactInfo(0);
			switch (this.fichierOuLien) {
			case 1:
				if(this.formOffre.getIdFichier()>0){
					try{
						this.formOffre.setAvecFichier(true);
						this.formOffre.setAvecLien(false);
						this.formOffre.setLienAttache(null);
						getOffreDomainService().updateOffre(this.formOffre);
						this.formOffre.setDateModif(new Date());
						this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
						//Maj listes
						if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.formOffre)){
							this.listeOffres.set(this.listeOffres.indexOf(this.formOffre), this.formOffre);
						}
						if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.formOffre)){
							this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.formOffre), this.formOffre);
							checkListeResultats();						
						}						
						ret="_modificationOffreEtape4Confirmation";
						addInfoMessage(null, "OFFRE.MODIFICATION.CONFIRMATION", this.formOffre.getIdOffre());
						mailModif();
					}catch (DataAddException e) {
						logger.error(e.fillInStackTrace());
					}catch (WebServiceDataBaseException e) {
						logger.error(e.fillInStackTrace());
					}
				}else{
					addErrorMessage("formModificationOffre:include:opUploadFile:uploadFile", "OFFRE.SELECTIONFICHIER.OBLIGATOIRE");
				}
				break;
			case 2:
				try{
					this.formOffre.setFichier(null);
					this.formOffre.setIdFichier(0);
					this.formOffre.setAvecFichier(false);				
					this.formOffre.setAvecLien(true);
					getOffreDomainService().updateOffre(this.formOffre);
					this.formOffre.setDateModif(new Date());
					this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
					//Maj listes
					if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.formOffre)){
						this.listeOffres.set(this.listeOffres.indexOf(this.formOffre), this.formOffre);
					}
					if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.formOffre)){
						this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.formOffre), this.formOffre);
						checkListeResultats();						
					}						
					//Suppression de l'ancien fichier
					if(this.currentOffre.isAvecFichier() && 
							this.currentOffre.getIdFichier()>0){
						try{
							if(this.currentOffre.getFichier()!=null
									&& StringUtils.hasText(this.currentOffre.getFichier().getNomFichier())){
								getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
										this.currentOffre.getIdFichier(), this.currentOffre.getFichier().getNomFichier());
							}
							getOffreDomainService().deleteFichier(this.currentOffre.getIdFichier());
						}catch (DataDeleteException e) {
							logger.warn(e.fillInStackTrace());
						}catch (WebServiceDataBaseException e) {
							logger.warn(e.fillInStackTrace());
						}
					}
					mailModif();
					ret="_modificationOffreEtape4Confirmation";
					addInfoMessage(null, "OFFRE.MODIFICATION.CONFIRMATION", this.formOffre.getIdOffre());
				}catch (DataAddException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.MODIFICATION.ERREURAJOUT");
				}catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.MODIFICATION.ERREURAJOUT");
				}
				break;
			}
		}else{
			this.formOffre.setFichier(null);
			this.formOffre.setIdFichier(0);
			this.formOffre.setLienAttache(null);
			this.formOffre.setAvecFichier(false);
			this.formOffre.setAvecLien(false);

			if(this.formOffre.getTempsTravail()!=null)this.formOffre.setIdTempsTravail(this.formOffre.getTempsTravail().getId());
			else this.formOffre.setIdTempsTravail(0);
			if(this.formOffre.getUniteDuree()!=null)this.formOffre.setIdUniteDuree(this.formOffre.getUniteDuree().getId());
			else this.formOffre.setIdUniteDuree(0);
			if(this.formOffre.getModesCandidature()!=null){
				ArrayList<Integer> l = new ArrayList<Integer>();
				for(ModeCandidatureDTO m : this.formOffre.getModesCandidature()){
					l.add(m.getId());
				}
				if(!l.isEmpty())this.formOffre.setIdsModeCandidature(l);
				else this.formOffre.setIdsModeCandidature(null);
			}
			if(this.formOffre.getContactCand()!=null){
				try{
					this.formOffre.setIdContactCand(this.formOffre.getContactCand().getId());
					if(this.formOffre.getContactInfo()!=null)this.formOffre.setIdContactInfo(this.formOffre.getContactInfo().getId());
					this.formOffre.setFichier(null);
					this.formOffre.setIdFichier(0);
					if(getOffreDomainService().updateOffre(this.formOffre)){
						this.formOffre.setDateModif(new Date());
						this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
						//Maj listes
						if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.formOffre)){
							this.listeOffres.set(this.listeOffres.indexOf(this.formOffre), this.formOffre);
						}
						if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.formOffre)){
							this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.formOffre), this.formOffre);
							checkListeResultats();						
						}						
						//Suppression de l'ancien fichier
						if(this.currentOffre.isAvecFichier() && 
								this.currentOffre.getIdFichier()>0){
							try{
								if(this.currentOffre.getFichier()!=null
										&& StringUtils.hasText(this.currentOffre.getFichier().getNomFichier())){
									getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
											this.currentOffre.getIdFichier(), this.currentOffre.getFichier().getNomFichier());
								}
								getOffreDomainService().deleteFichier(this.currentOffre.getIdFichier());
							}catch (DataDeleteException e) {
								logger.warn(e.fillInStackTrace());
							}catch (WebServiceDataBaseException e) {
								logger.warn(e.fillInStackTrace());
							}
						}
					}
					ret="_modificationOffreEtape4Confirmation";
					addInfoMessage(null, "OFFRE.MODIFICATION.CONFIRMATION", this.formOffre.getIdOffre());
					mailModif();
				}catch (DataUpdateException e) {
					ret="_modificationOffreEtape4Confirmation";
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.MODIFICATION.ERREURMODIF");
				}catch (WebServiceDataBaseException e) {
					ret="_modificationOffreEtape4Confirmation";
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.MODIFICATION.ERREURMODIF");
				}
			}else{
				addErrorMessage("formModificationOffre:include:contactCand", "OFFRE.SELECTIONCONTACTCAND.OBLIGATOIRE");
			}
		}
		
		if(this.diffusionDirecte){
			this.currentOffre = this.formOffre;
			this.diffuserOffre();
		} else if (!this.formOffre.isEstDiffusee()){
			addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION.DIFFUSION", this.formOffre.getIdOffre());
		}
		this.diffusionDirecte = false;
		
		return ret;
	}
	
	/**
	 * 
	 */
	public void mailModif(){
		if(getSessionController().isMailingListEntrMailAvertissementModifOffre() && StringUtils.hasText(getSessionController().getMailingListEntr())
				&& (getSessionController().isAdminPageAuthorized() || getSessionController().isPageAuthorized())){
			//Envoi mail sur la mailing list entreprise
			String infoPersonne="";
			if(getSessionController().isAdminPageAuthorized() && getSessionController().getCurrentAuthAdminStructure()!=null){
				infoPersonne+=getSessionController().getCurrentAuthAdminStructure().getNom()+" "+getSessionController().getCurrentAuthAdminStructure().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else if(getSessionController().isPageAuthorized() && getSessionController().getCurrentAuthContact()!=null){
				infoPersonne+=getSessionController().getCurrentAuthContact().getNom()+" "+getSessionController().getCurrentAuthContact().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else{
				infoPersonne+=getSessionController().getCurrentLogin();
			}
			getSmtpService().send(
					getSessionController().getMailingListEntrIA(), 
					getString("MAIL.ADMIN.OFFRE.SUJETMODIF", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(), infoPersonne),
					getString("MAIL.ADMIN.OFFRE.MESSAGEMODIF", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(),this.formOffre.getStructure().printAdresse(), infoPersonne),
					""
			);
		}
	}

	/**
	 * Suppression d'une offre
	 * @return String
	 */
	public String supprimerOffre(){
		String ret=null;
		try{
			ret="_supprOffreEtape2Confirmation";
			if(getOffreDomainService().deleteOffreLogique(this.currentOffre.getIdOffre())){
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.remove(this.listeOffres.indexOf(this.currentOffre));
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.remove(this.resultatsRechercheOffre.indexOf(this.currentOffre));
					checkListeResultats();						
				}	
				mailSuppr();
				this.currentOffre=null;
			}
			addInfoMessage(null, "OFFRE.SUPPR.CONFIRMATION");
		}catch (DataUpdateException e) {
			logger.error(e.fillInStackTrace());
			addErrorMessage(null, "OFFRE.SUPPR.ERREUR");
		}catch (WebServiceDataBaseException e) {
			logger.error(e.fillInStackTrace());
			addErrorMessage(null, "OFFRE.SUPPR.ERREUR");
		}
		return ret;
	}
	
	/**
	 * 
	 */
	public void mailSuppr(){
		if(getSessionController().isMailingListEntrMailAvertissementSupprOffre() && StringUtils.hasText(getSessionController().getMailingListEntr())
				&& (getSessionController().isAdminPageAuthorized() || getSessionController().isPageAuthorized())){
			//Envoi mail sur la mailing list entreprise
			String infoPersonne="";
			if(getSessionController().isAdminPageAuthorized() && getSessionController().getCurrentAuthAdminStructure()!=null){
				infoPersonne+=getSessionController().getCurrentAuthAdminStructure().getNom()+" "+getSessionController().getCurrentAuthAdminStructure().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else if(getSessionController().isPageAuthorized() && getSessionController().getCurrentAuthContact()!=null){
				infoPersonne+=getSessionController().getCurrentAuthContact().getNom()+" "+getSessionController().getCurrentAuthContact().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else{
				infoPersonne+=getSessionController().getCurrentLogin();
			}
			getSmtpService().send(
					getSessionController().getMailingListEntrIA(), 
					getString("MAIL.ADMIN.OFFRE.SUJETSUPPR", getSessionController().getApplicationNameEntreprise(),this.currentOffre.getIdOffre() +", "+this.currentOffre.getIntitule(), infoPersonne),
					getString("MAIL.ADMIN.OFFRE.MESSAGESUPPR", getSessionController().getApplicationNameEntreprise(),this.currentOffre.getIdOffre() +", "+this.currentOffre.getIntitule(),getSessionController().getCurrentManageStructure().printAdresse(), infoPersonne),
					""
			);
		}
	}

	/**
	 * @return String
	 */
	public String diffuserOffre(){
		String ret=null;
		ret="_diffusionOffreEtape2Confirmation";
		if(this.currentOffre!=null && this.currentOffre.getIdOffre()>0){
			try{
				int x = (this.dureeDiffusion - 1);
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
				int annee = Integer.parseInt(dateFormat.format(new Date()).split("/")[2]);
				int mois = Integer.parseInt(dateFormat.format(new Date()).split("/")[1]);
				int jour = Integer.parseInt(dateFormat.format(new Date()).split("/")[0]);
				
				// date du jour + x mois selon la DureeDiffusion choisie
				if ((mois+x) < 12){
					mois = mois + x;
				} else if((mois+x) > 12 && (mois+x) < 24){
					mois = mois + x - 12;
					annee = annee + 1;
				} else {
					mois = mois + x - 24;
					annee = annee + 2;
				}
				
				gc.set(annee,mois,jour);
				getOffreDomainService().updateDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin(),gc.getTime());

				//Validation - TODO à adapter pour la validation des offres
				getOffreDomainService().updateValidationOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				addInfoMessage(null, "OFFRE.GESTION.DIFFUSION.CONFIRMATION");
				getOffreDomainService().updateOffrePourvue(this.currentOffre.getIdOffre(), false);
				//Màj de l'objet courant
				this.currentOffre.setEstPourvue(false);
				this.currentOffre.setEstDiffusee(true);
				this.currentOffre.setDateDiffusion(new Date());
				this.currentOffre.setDateFinDiffusion(gc.getTime());
				this.currentOffre.setEstValidee(true);
				this.currentOffre.setEtatValidation(1);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();						
				}
			}catch (DataUpdateException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}
		}
		return ret;
	}
	
	/**
	 * Ancienne Diffusion de l'offre actuellement sélectionnée pour 3 mois
	 * @return String
	 */
	public String diffuserOffreOld(){
		String ret=null;
		ret="_diffusionOffreEtape2Confirmation";
		if(this.currentOffre!=null){
			try{
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				GregorianCalendar gcThreeMonth = (GregorianCalendar) Calendar.getInstance();
				int annee = Integer.parseInt(dateFormat.format(new Date()).split("/")[2]);
				int mois = Integer.parseInt(dateFormat.format(new Date()).split("/")[1]);
				int jour = Integer.parseInt(dateFormat.format(new Date()).split("/")[0]);
				// date du jour + 3 mois
				if(mois+2>12){
					mois=mois+2-12;
					annee=annee+1;
				}else{
					mois=mois+2;
				}
				gcThreeMonth.set(annee,mois,jour);
				getOffreDomainService().updateDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin(),gcThreeMonth.getTime());
				//Validation - TODO à adapter pour la validation des offres
				getOffreDomainService().updateValidationOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				addInfoMessage(null, "OFFRE.GESTION.DIFFUSION.CONFIRMATION");
				getOffreDomainService().updateOffrePourvue(this.currentOffre.getIdOffre(), false);
				//Màj de l'objet courant
				this.currentOffre.setEstPourvue(false);
				this.currentOffre.setEstDiffusee(true);
				this.currentOffre.setDateDiffusion(new Date());
				this.currentOffre.setDateFinDiffusion(gcThreeMonth.getTime());
				this.currentOffre.setEstValidee(true);
				this.currentOffre.setEtatValidation(1);
				this.currentOffre.setLoginDiffusion(getSessionController().getCurrentLogin());
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();						
				}
			}catch (DataUpdateException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}
		}
		return ret;
	}

	/**
	 * Ancienne Diffusion de l'offre actuellement sélectionnée pour 1 An
	 * @return String
	 */
	public String diffuserOffre1AnOld(){
		String ret=null;
		ret="_diffusionOffreEtape2Confirmation";
		if(this.currentOffre!=null){
			try{
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				GregorianCalendar gcOneYear = (GregorianCalendar) Calendar.getInstance();
				int annee = Integer.parseInt(dateFormat.format(new Date()).split("/")[2]);
				int mois = Integer.parseInt(dateFormat.format(new Date()).split("/")[1]);
				int jour = Integer.parseInt(dateFormat.format(new Date()).split("/")[0]);
				// date du jour + 1 an
				annee=annee+1;
				mois=mois-1;
				gcOneYear.set(annee, mois, jour);
				getOffreDomainService().updateDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin(),gcOneYear.getTime());
				//Validation - TODO à adapter pour la validation des offres
				getOffreDomainService().updateValidationOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				addInfoMessage(null, "OFFRE.GESTION.DIFFUSION.CONFIRMATION1AN");
				getOffreDomainService().updateOffrePourvue(this.currentOffre.getIdOffre(), false);
				//Màj de l'objet courant
				this.currentOffre.setEstPourvue(false);
				this.currentOffre.setEstDiffusee(true);
				this.currentOffre.setDateDiffusion(new Date());
				this.currentOffre.setDateFinDiffusion(gcOneYear.getTime());
				this.currentOffre.setEstValidee(true);
				this.currentOffre.setEtatValidation(1);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();						
				}
			}catch (DataUpdateException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}
		}
		return ret;
	}

	/**
	 * Arrêt de la diffusion de l'offre actuellement sélectionnée
	 * @return String
	 */
	public String stopDiffusionOffre(){
		String ret=null;
		ret="_stopDiffusionOffreEtape2Confirmation";
		if(this.currentOffre!=null){
			try{
				getOffreDomainService().updateStopDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				//Dévalidation - TODO à adapter pour la validation des offres
				getOffreDomainService().updateStopValidationOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				addInfoMessage(null, "OFFRE.GESTION.STOPDIFFUSION.CONFIRMATION");
				//Màj de l'objet courant
				this.currentOffre.setDateDiffusion(null);
				this.currentOffre.setDateFinDiffusion(null);
				this.currentOffre.setEstDiffusee(false);
				this.currentOffre.setEstValidee(false);
				this.currentOffre.setEtatValidation(0);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();						
				}
			}catch (DataUpdateException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.STOPDIFFUSION.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.STOPDIFFUSION.ERREUR");
			}
		}
		return ret;
	}

	/**
	 * Indiquer l'offre comme pourvue
	 * @return String
	 */
	public String offrePourvue(){
		String ret=null;
		ret="_offrePourvueEtape2Confirmation";
		if(this.currentOffre!=null){
			try{
				getOffreDomainService().updateOffrePourvue(this.currentOffre.getIdOffre(), !this.currentOffre.isEstPourvue());
				getOffreDomainService().updateStopDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());

				//Màj de l'objet courant
				this.currentOffre.setEstPourvue(!this.currentOffre.isEstPourvue());
				this.currentOffre.setDateDiffusion(null);
				this.currentOffre.setDateFinDiffusion(null);
				this.currentOffre.setEstDiffusee(false);
				this.currentOffre.setEstValidee(false);
				this.currentOffre.setEtatValidation(0);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();						
				}
				if(this.currentOffre.isEstPourvue())addInfoMessage(null, "OFFRE.GESTION.POURVOIROFFRE.CONFIRMATION");
				if(!this.currentOffre.isEstPourvue())addInfoMessage(null, "OFFRE.GESTION.POURVOIROFFRE.CONFIRMATIONNON");
			}catch (DataUpdateException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.POURVOIROFFRE.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.POURVOIROFFRE.ERREUR");
			}
		}
		return ret;
	}

	/**
	 * @return int : nombre d'éléments dans la liste offresDiffusion du currentOffre
	 */
	public int getCurrentOffreSizeOffresDiffusion(){
		currentOffreSizeOffresDiffusion = 0;
		if(this.currentOffre!=null && this.currentOffre.getOffresDiffusion()!=null){
			currentOffreSizeOffresDiffusion=this.currentOffre.getOffresDiffusion().size();
		}
		return currentOffreSizeOffresDiffusion;
	}

	/**
	 * @param event
	 */
	public void valueCentreEtablissementChanged(ValueChangeEvent event){
		if(event.getNewValue() instanceof Integer){
			if(this.listesCentresGestionEtablissement!=null && this.listesCGEtab!=null
					&& !this.listesCentresGestionEtablissement.isEmpty()
					&& !this.listesCGEtab.isEmpty()){
				int idCTmp = (Integer) event.getNewValue();
				if(idCTmp>0){
					CentreGestionDTO cTmp = new CentreGestionDTO();
					cTmp.setIdCentreGestion(idCTmp);
					CentreGestionDTO c = this.listesCGEtab.get(
							this.listesCGEtab.indexOf(cTmp));
					List<CentreGestionDTO> l = getCentreGestionDomainService().getCentreGestionList(c.getCodeUniversite());
					if(l!=null && !l.isEmpty()){
						this.listesCentresGestionUniversite=new ArrayList<SelectItem>();
						for(CentreGestionDTO cg : l){
							if(!cg.equals(cTmp)){
								this.listesCentresGestionUniversite.add(new SelectItem(cg.getIdCentreGestion(), cg.getNomCentre()));
							}
						}
					}else{
						this.listesCentresGestionUniversite=new ArrayList<SelectItem>();
					}
				}else{
					this.listesCentresGestionUniversite=new ArrayList<SelectItem>();
				}
			}
		}else{
			this.listesCentresGestionUniversite=new ArrayList<SelectItem>();
		}
	}

	/**
	 * Ajout de toutes les centres dans la lites des centres à diffuser
	 */
	public void addAllCentresGestionToListeADiffuser(){
		if(this.listesCentresGestionUniversite!=null && !this.listesCentresGestionUniversite.isEmpty()){
			if(this.listesCentreGestionUniversiteADiffuser==null)this.listesCentreGestionUniversiteADiffuser=new ArrayList<SelectItem>();
			for(SelectItem si : this.listesCentresGestionUniversite){
				if(containsSelectItem(this.listesCentreGestionUniversiteADiffuser,((Integer)si.getValue()))==null){
					this.listesCentreGestionUniversiteADiffuser.add(si);
				}
			}
			Collections.sort(this.listesCentreGestionUniversiteADiffuser, new ComparatorSelectItem());
		}
	}

	/**
	 * @param l
	 * @param id
	 * @return SelectItem
	 */
	public SelectItem containsSelectItem(List<SelectItem> l, int id){
		if(l!=null && !l.isEmpty()){
			for(SelectItem si : l){
				if(si.getValue() instanceof Integer){
					if((Integer)(si.getValue())==id){
						return si;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Ajout des centres sélectionnés dans la lites des centres à diffuser
	 */
	public void addCentresGestionToListeADiffuser(){
		if(this.idsCentreGestionUniversiteSelect!=null && !this.idsCentreGestionUniversiteSelect.isEmpty()){
			if(this.listesCentreGestionUniversiteADiffuser==null)this.listesCentreGestionUniversiteADiffuser=new ArrayList<SelectItem>();
			for(int idCg : this.idsCentreGestionUniversiteSelect){
				if(containsSelectItem(listesCentreGestionUniversiteADiffuser,idCg)==null){
					if(idCg>0){
						SelectItem si = containsSelectItem(this.listesCentresGestionUniversite,idCg);
						if(si!=null){
							this.listesCentreGestionUniversiteADiffuser.add(si);
						}
					}
				}
			}		
			Collections.sort(this.listesCentreGestionUniversiteADiffuser, new ComparatorSelectItem());
		}
	}

	/**
	 * Suppression des centres sélectionnés de la listes des centres à diffuser
	 */
	public void deleteCentresGestionFromListeADiffuser(){
		if(this.idsCentreGestionUniversiteADiffuser!=null && !this.idsCentreGestionUniversiteADiffuser.isEmpty()){
			if(this.listesCentreGestionUniversiteADiffuser!=null && !this.listesCentreGestionUniversiteADiffuser.isEmpty()){
				for(int idCg : this.idsCentreGestionUniversiteADiffuser){
					if(idCg>0){
						SelectItem si = containsSelectItem(this.listesCentreGestionUniversiteADiffuser,idCg);
						if(si!=null){
							this.listesCentreGestionUniversiteADiffuser.remove(si);
						}
					}
				}
			}
		}
	}

	/**
	 * Suppression de tous les centres de la listes des centres à diffuser
	 */
	public void deleteAllCentresGestionFromListeADiffuser(){
		this.listesCentreGestionUniversiteADiffuser=new ArrayList<SelectItem>();
	}

	/**
	 * Maj des listes pour le panel de diffusion
	 */
	public void majListesCentresDiffusion(){
		if(this.currentOffre!=null){
			if(this.currentOffre.getOffresDiffusion()!=null && !this.currentOffre.getOffresDiffusion().isEmpty()){
				this.listesCentreGestionUniversiteADiffuser=new ArrayList<SelectItem>();
				for(OffreDiffusionDTO od : this.currentOffre.getOffresDiffusion()){
					this.listesCentreGestionUniversiteADiffuser.add(new SelectItem(od.getIdCentreGestion(),""+od.getNomCentre()));
				}
			}else{
				this.listesCentreGestionUniversiteADiffuser=new ArrayList<SelectItem>();
			}
			this.idsCentreGestionUniversiteADiffuser=new ArrayList<Integer>();
			this.idsCentreGestionUniversiteSelect=new ArrayList<Integer>();
			if(this.listesCentresGestionEtablissement==null
					|| this.listesCentresGestionEtablissement.isEmpty()){
				getListesCentresGestionEtablissement();
			}
			if(this.listesCentresGestionEtablissement.size()>0){
				int id =(Integer) this.listesCentresGestionEtablissement.get(0).getValue();
				this.idCentreEtablissementSelect=id;
				if(this.listesCentresGestionEtablissement.size()>1){
					id=(Integer) this.listesCentresGestionEtablissement.get(1).getValue();
					if(id>0){
						this.idCentreEtablissementSelect=id;
					}
				}
				if(id>0){
					List<CentreGestionDTO> l = getCentreGestionDomainService().getCentreGestionList(
							getSessionController().getCodeUniversite());
					if(l!=null && !l.isEmpty()){
						this.listesCentresGestionUniversite=new ArrayList<SelectItem>();
						for(CentreGestionDTO cg : l){
							if(cg.getIdCentreGestion()!=id){
								this.listesCentresGestionUniversite.add(new SelectItem(cg.getIdCentreGestion(), ""+cg.getNomCentre()));
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Action de diffusion de l'offre aux centres sélectionnés
	 * @return String
	 */
	public String diffusionCentreOffre(){
		String ret="_diffusionCentreOffreEtape2Confirmation";
		if(this.currentOffre!=null){
			if(this.idCentreEtablissementSelect==0 || this.listesCentreGestionUniversiteADiffuser==null 
					|| this.listesCentreGestionUniversiteADiffuser.isEmpty()){
				try{
					if(getOffreDomainService().deleteOffreDiffusionFromId(this.currentOffre.getIdOffre())){
						this.currentOffre.setOffresDiffusion(null);
						addInfoMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.CONFIRMATION");
					}
				}catch (DataDeleteException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}catch (DataAddException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}
			}else if(this.listesCentreGestionUniversiteADiffuser!=null 
					&& !this.listesCentreGestionUniversiteADiffuser.isEmpty()){
				List<OffreDiffusionDTO> l = new ArrayList<OffreDiffusionDTO>();
				for(SelectItem si : this.listesCentreGestionUniversiteADiffuser){
					OffreDiffusionDTO od = new OffreDiffusionDTO();
					od.setIdCentreGestion((Integer)(si.getValue()));
					od.setIdOffre(this.currentOffre.getIdOffre());
					od.setNomCentre(si.getLabel());
					l.add(od);
				}
				this.currentOffre.setOffresDiffusion(l);
				try{
					getOffreDomainService().addOffreDiffusion(l);
					addInfoMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.CONFIRMATION");
				}catch (DataDeleteException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}catch (WebServiceDataBaseException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}catch (DataAddException e) {
					logger.error(e.fillInStackTrace());
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}
			}
		}
		return ret;
	}
	
	/**
	 * Transfére d'une offre au centre entreprise avec contacts
	 * @return String
	 */
	public String transfererOffre(){
		String ret = "_transfertOffreEtape2Confirmation";
		if(this.currentOffre!=null){
			try{
				CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
				if(cgEntr!=null){
					this.currentOffre.setIdCentreGestion(cgEntr.getIdCentreGestion());
					this.currentOffre.setCentreGestion(cgEntr);
					getOffreDomainService().updateOffre(this.currentOffre);
					if(this.currentOffre.getIdContactCand()>0){
						if(this.currentOffre.getContactCand()!=null){
							this.currentOffre.getContactCand().setIdCentreGestion(cgEntr.getIdCentreGestion());
							getStructureDomainService().updateContact(this.currentOffre.getContactCand());
						}
					}
					if(this.currentOffre.getIdContactInfo()>0){
						if(this.currentOffre.getContactInfo()!=null){
							this.currentOffre.getContactInfo().setIdCentreGestion(cgEntr.getIdCentreGestion());
							getStructureDomainService().updateContact(this.currentOffre.getContactInfo());
						}
					}
				}
				addInfoMessage(null, "OFFRE.GESTION.TRANSFERT.CONFIRMATION");
			}catch (DataUpdateException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.TRANSFERT.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.TRANSFERT.ERREUR");
			}catch (Exception e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage(null, "OFFRE.GESTION.TRANSFERT.ERREUR");
			}
		}
		return ret;
	}

	/**
	 * Page de retour lors de la modif ou suppression
	 * @return String
	 */
	public String retourTo(){
		return getRetour();
	}

	/**
	 * Vers moteur de recherche offre (entreprise)
	 * @return String
	 */
	public String goToRechercheOffre(){
		String ret="rechercheOffre";
		if(this.critereRechercheOffre==null) this.critereRechercheOffre=initCritereRechercheOffre();
		return ret;
	}

	/**
	 * Vers moteur de recherche offre public (entreprise)
	 * @return String
	 */
	public String goToRechercheOffrePublic(){
		String ret="rechercheOffrePublic";
		if(this.critereRechercheOffre==null)this.critereRechercheOffre=initCritereRechercheOffre();
		return ret;
	}
	
	/**
	 * initCritereRechercheOffre
	 * @return CritereRechercheOffreDTO
	 */
	public CritereRechercheOffreDTO initCritereRechercheOffre(){
		CritereRechercheOffreDTO c = null;
		if(getBeanUtils()!=null){
			c=new CritereRechercheOffreDTO();
			c.setLieuPays(getBeanUtils().getFrance());
		}else{
			c=new CritereRechercheOffreDTO();
			PaysDTO p = new PaysDTO();
			p.setLibelle("FRANCE");
			p.setCog(DonneesStatic.FRANCE_COG);
			p.setCrpay(DonneesStatic.FRANCE_TERRITOIRE_CRPAY);
			c.setLieuPays(p);
		}
		return c;
	}

	/**
	 * @return String
	 */
	public String rechercherOffrePublic(){
		String ret=null;
		if(this.critereRechercheOffre==null) this.critereRechercheOffre=initCritereRechercheOffre();
		if(getSessionController().getCurrentCentresGestion()==null 
				|| getSessionController().getCurrentCentresGestion().isEmpty()){
			CentreGestionDTO cgEntr=getCentreGestionDomainService().getCentreEntreprise();
			ArrayList<CentreGestionDTO> lcg = new ArrayList<CentreGestionDTO>();
			lcg.add(cgEntr);
			getSessionController().setCurrentCentresGestion(lcg);
		}
		ret=rechercherOffre();
		return ret;
	}

	/**
	 * Vers moteur de recherche offre (stage)
	 * @return String
	 */
	public String goToRechercheOffreStage(){
		String ret="rechercheOffreStage";
		if(this.critereRechercheOffre==null)this.critereRechercheOffre=initCritereRechercheOffre();
		//resetRechercheOffre();
		return ret;
	}

	/**
	 * Recherche des offres
	 * @return String
	 */
	public String rechercherOffre(){
		String ret="resultatsRechercheOffre";
		List<Integer> idCG = getSessionController().getCurrentIdsCentresGestion();
		boolean trouveCGEtab = false;
		if(getSessionController().getCurrentAuthEtudiant()!=null){
			CentreGestionDTO cgEtab = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
			if(cgEtab!=null && cgEtab.getIdCentreGestion()>0){
				if (idCG != null) {
					for (Integer intCG : idCG) {
						if (intCG.equals(cgEtab.getIdCentreGestion())) {
							trouveCGEtab = true;
						}				
					}
					if (!trouveCGEtab) {
						idCG.add(cgEtab.getIdCentreGestion());
					}
				}	
			}
		}
		this.critereRechercheOffre.setIdsCentreGestion(idCG);
		if(StringUtils.hasText(this.rechTypeOuContrat)){
			if(this.rechTypeOuContrat.contains("t")){
				if(Utils.isNumber(this.rechTypeOuContrat.substring(1))){
					this.critereRechercheOffre.setTypeOffre(getNomenclatureDomainService().getTypeOffreFromId(
							Utils.convertStringToInt(this.rechTypeOuContrat.substring(1))));
					this.critereRechercheOffre.setContratOffre(null);
				}
			}
			if(this.rechTypeOuContrat.contains("c")){
				if(Utils.isNumber(this.rechTypeOuContrat.substring(1))){
					this.critereRechercheOffre.setContratOffre(getNomenclatureDomainService().getContratOffreFromId(
							Utils.convertStringToInt(this.rechTypeOuContrat.substring(1))));
					if(this.critereRechercheOffre.getContratOffre()!=null && 
							this.critereRechercheOffre.getContratOffre().getIdParent()>0){
						this.critereRechercheOffre.setTypeOffre(getNomenclatureDomainService().getTypeOffreFromId(
								this.critereRechercheOffre.getContratOffre().getIdParent()));
					}
				}
			}
		}else{
			this.critereRechercheOffre.setTypeOffre(null);
			this.critereRechercheOffre.setContratOffre(null);
		}
		if(this.critereRechercheOffre.isEstPrioERQTH()){
			this.critereRechercheOffre.setEstAccessERQTH(false);
		}
		if(getSessionController().isPageAuthorized() || getSessionController().isAdminPageAuthorized()){
			this.critereRechercheOffre.setInclureOffresEntreprise(true);
		}
		this.critereRechercheOffre.setEstFrance(false);
		if(this.critereRechercheOffre.getLieuPays()!=null
				&& this.critereRechercheOffre.getLieuPays().getId()!=0
				&& getBeanUtils()!=null
				&& getBeanUtils().isFranceRecherche(this.critereRechercheOffre.getLieuPays())){
			this.critereRechercheOffre.setLieuPays(getBeanUtils().getFrance());
			if (getBeanUtils().isFranceRecherche(this.critereRechercheOffre.getLieuPays())) {
				this.critereRechercheOffre.setEstFrance(true); 
			}		
		}
		this.resultatsRechercheOffre = getOffreDomainService().getOffresFromCriteres(this.critereRechercheOffre);
		if(!checkListeResultats()){
			ret=null;
		}
		return ret;
	}
	/**
	 * Passage du moteur simple à avancé et vice-versa
	 */
	public void rechercheSimpleAvancee(){
		if(this.rechercheAvancee)this.rechercheAvancee=false;
		else this.rechercheAvancee=true;
		resetRechercheOffre();
	}

	/**
	 * Reset des criteres de recherche d'offres
	 */
	public void resetRechercheOffre(){
		this.critereRechercheOffre=initCritereRechercheOffre();
		this.rechTypeOuContrat=null;
	}

	/**
	 * Re-chargement du paginator 
	 */
	public void reloadRechercheOffrePaginator(){
		this.rechercheOffrePaginator.reset();
		this.rechercheOffrePaginator.setListe(this.resultatsRechercheOffre);
		this.rechercheOffrePaginator.forceReload();
	}

	/**
	 * Contrôle la liste des résultats
	 * @return boolean : vrai si resultats
	 */
	private boolean checkListeResultats(){
		boolean ret=true;
		if(this.resultatsRechercheOffre==null || this.resultatsRechercheOffre.isEmpty()){
			this.resultatsRechercheOffre=null;
			ret=false;
			addInfoMessage("formRechOffre", "RECHERCHEOFFRE.AUCUNRESULTAT");
		}else if(this.resultatsRechercheOffre!=null && !this.resultatsRechercheOffre.isEmpty()){
			reloadRechercheOffrePaginator();
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToRecapitulatifOffre(){
		String ret=null;
		if(this.currentOffre!=null){
			ret="recapitulatifOffre";
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToRecapitulatifOffreFromOffreLight(){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
			ret="recapitulatifOffreEtab";
		}
		return ret;
	}
	/**
	 * @return String
	 */
	public String goToRecapitulatifOffreFromOffreLightAvecCentre(){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			getSessionController().setCurrentManageStructure(this.currentOffre.getStructure());
			this.etablissementController.loadContactsServices();
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
			if(!isListeCurrentIdsCentresGestionContainsIdCGCurrentOffre()){
				CentreGestionDTO c = getCentreGestionDomainService().getCentreGestion(this.currentOffre.getIdCentreGestion());
				if(c!=null)this.currentOffre.setCentreGestion(c);
				else return ret;
			}else{
				if(getSessionController().getCurrentIdsCentresGestion()!=null &&
						!getSessionController().getCurrentIdsCentresGestion().isEmpty()){
					for(CentreGestionDTO c : getSessionController().getCurrentCentresGestion()){
						if(c.getIdCentreGestion()==this.currentOffre.getIdCentreGestion()){
							this.currentOffre.setCentreGestion(c);
							break;
						}
					}
				}
			}
			ret="recapitulatifOffreEtabCentre";
		}
		return ret;
	}

	/**
	 * @param idOffre
	 * @return String
	 */
	public String goToOffreEtudiant(Integer idOffre){
		String ret="recapitulatifOffreEtab";
		this.currentOffre=null;
		OffreDTO oTmp=getOffreDomainService().getOffreFromId(idOffre);
		if(oTmp!=null){
			CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
			if(getSessionController().getCurrentIdsCentresGestion()==null){
				getSessionController().setCurrentCentresGestion(new ArrayList<CentreGestionDTO>());
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}else if(!getSessionController().getCurrentIdsCentresGestion().contains(cgEntr)){
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}
			if(getSessionController().getCurrentIdsCentresGestion()!=null
					&& getSessionController().getCurrentIdsCentresGestion().contains(oTmp.getIdCentreGestion())){
				this.currentOffre=oTmp;
				goToRecapitulatifOffreFromOffreLight();
			}
		}
		return ret;
	}

	/**
	 * @param idOffreC
	 * @return String
	 */
	public String goToOffreEtudiantAvecCentre(Integer idOffreC){
		String ret="recapitulatifOffreEtabCentre";
		this.currentOffre=null;
		OffreDTO oTmp=getOffreDomainService().getOffreFromId(idOffreC);
		if(oTmp!=null){
			CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
			if(getSessionController().getCurrentIdsCentresGestion()==null){
				getSessionController().setCurrentCentresGestion(new ArrayList<CentreGestionDTO>());
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}else if(!getSessionController().getCurrentIdsCentresGestion().contains(cgEntr)){
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}
			if(getSessionController().getCurrentIdsCentresGestion()!=null
					&& getSessionController().getCurrentIdsCentresGestion().contains(oTmp.getIdCentreGestion())){
				this.currentOffre=getOffreDomainService().getOffreFromId(idOffreC);
				goToRecapitulatifOffreFromOffreLightAvecCentre();
			}
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToDetailsOffre(){
		String ret=null;
		ret="detailsOffre";
		return ret;
	}

	/* ***************************************************************
	 * 
	 ****************************************************************/

	/**
	 * Action appellée après l'upload d'un fichier
	 */
	public void insertUploadedFile(){
		String nomFichier = getSessionController().getOffreFileUploadBean().getNameUploadedFile();
		String nomReel = getSessionController().getOffreFileUploadBean().getRealNameFile();
		//Si nom de fichier non vide (cas des fichiers volumineux)
		if(StringUtils.hasText(nomFichier)){
			this.formOffre.getFichier().setNomFichier(nomFichier);
			if(StringUtils.hasText(nomReel)){
				this.formOffre.getFichier().setNomReel(nomReel);
			}
			try {
				getOffreDomainService().updateFichier(this.formOffre.getFichier());	
			} catch (DataAddException e) {
				logger.error(e.fillInStackTrace());
			} catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
			}
			this.formOffre.setIdFichier(this.formOffre.getFichier().getIdFichier());
		}
	}

	/**
	 * Suppression du fichier actuellement uploadé
	 */
	public void deleteUploadedFile(){
		try{
			//getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
			//		this.formOffre.getFichier().getIdFichier(), this.formOffre.getFichier().getNomFichier());
			this.formOffre.getFichier().setNomFichier(null);
			this.formOffre.getFichier().setNomReel(null);
			//getOffreDomainService().updateFichier(this.formOffre.getFichier());
			this.formOffre.setIdFichier(0);		
			getSessionController().getOffreFileUploadBean().setPrefix(this.formOffre.getFichier().getIdFichier());
		}catch (DataDeleteException e) {
			logger.warn(e.fillInStackTrace());
		}catch (WebServiceDataBaseException e) {
			logger.warn(e.fillInStackTrace());
		}
	}

	/**
	 * Mise à jour de la FapN3 en fonction de la QualificationSimplifiee selectionnée
	 * @param event
	 */
	public void valueFapQualificationSimplifieeChanged(ValueChangeEvent event){
		if(event.getNewValue() instanceof FapQualificationSimplifieeDTO){
			FapQualificationSimplifieeDTO f = (FapQualificationSimplifieeDTO)event.getNewValue();
			this.fapN3Listening=getFapN3FromNumQualif(f.getId());
		}else{
			this.fapN3Listening=null;
		}
	}
	/**
	 * @param num 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN3FromNumQualif(int num){
		List<SelectItem> ls = null;
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3FromNumQualifSimplifiee(num);
		if(l!=null && !l.isEmpty()){
			ls = new ArrayList<SelectItem>();
			for(FapN3DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/** Formulaire offre
	 * @param event
	 */
	public void formOffreValueCodePostalChanged(ValueChangeEvent event){
		String s = (String)event.getNewValue();
		if(getSessionController().isRecupererCommunesDepuisApogee()){
			List<SelectItem> lTmp = majCommunes(s);
			if(lTmp!=null && !lTmp.isEmpty()){
				this.formOffreCommunesListening=lTmp;
			}else{
				this.formOffreCommunesListening=new ArrayList<SelectItem>();
				addErrorMessage("formCreationOffre:include:dynaCodePostal", "STRUCTURE.CODE_POSTAL.VALIDATION");
			}
		}
	}

	/**
	 * @param codePostal
	 * @return List<SelectItem>
	 */
	public List<SelectItem> majCommunes(String codePostal){
		List<SelectItem> l = null;
		if(codePostal.length()==5){
			List<CommuneDTO> ls = getGeographieRepositoryDomain().getCommuneFromDepartement(codePostal);
			if(ls!=null){
				l = new ArrayList<SelectItem>();
				for(CommuneDTO c : ls){
					l.add(new SelectItem(c.getCodeCommune(),c.getLibCommune()));
				}
			}
		}
		return l;
	}

	/**
	 * Utilisé en etape 3 d'une offre 
	 * @return boolean
	 */
	public boolean isFormOffreContainModeCourrier(){
		return isOffreContainMode(getBeanUtils().getModeCourrier(), this.formOffre);
	}

	/**
	 * Utilisé en etape 3 d'une offre 
	 * @return boolean
	 */
	public boolean isFormOffreContainModeTelephone(){
		return isOffreContainMode(getBeanUtils().getModeTelephone(), this.formOffre);
	}

	/**
	 * Utilisé en etape 3 d'une offre 
	 * @return boolean
	 */
	public boolean isFormOffreContainModeMail(){
		return isOffreContainMode(getBeanUtils().getModeMail(), this.formOffre);
	}

	/**
	 * Utilisé dans le recap d'une offre  
	 * @return boolean
	 */
	public boolean isCurrentOffreContainModeCourrier(){
		return isOffreContainMode(getBeanUtils().getModeCourrier(), this.currentOffre);
	}

	/**
	 * Utilisé dans le recap d'une offre 
	 * @return boolean
	 */
	public boolean isCurrentOffreContainModeTelephone(){
		return isOffreContainMode(getBeanUtils().getModeTelephone(), this.currentOffre);
	}

	/**
	 * Utilisé dans le recap d'une offre 
	 * @return boolean
	 */
	public boolean isCurrentOffreContainModeMail(){
		return isOffreContainMode(getBeanUtils().getModeMail(), this.currentOffre);
	}

	/**
	 * @param mc
	 * @param o 
	 * @return boolean
	 */
	public boolean isOffreContainMode(ModeCandidatureDTO mc, OffreDTO o){
		boolean ret=false;
		if(o!=null){
			if(o.getModesCandidature()!=null && 
					!o.getModesCandidature().isEmpty()){
				for(ModeCandidatureDTO m : o.getModesCandidature()){
					if(m.equals(mc)){
						ret=true;
						break;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#reset()
	 */
	@Override
	public void reset() {
		super.reset();
	}


	/* ****************************************************************************
	 * DEPOT ANONYME
	 *****************************************************************************/

	/**
	 * Envoi vers le depot anonyme du centre concerné 
	 * si celui-ci à autorisé le depot anonyme 
	 * @param depot 
	 * @param id 
	 * @return String
	 */
	public String goToDepotAnonyme(String depot,String id){
		String ret="depotAnonyme";
		this.centreGestionDepotAnonyme=null;
		if(Utils.isNumber(id)){
			int idCG = Utils.convertStringToInt(id);
			if(idCG>0){
				String depotMD5 = Utils.encodageIdCgMd5(idCG);
				if(depot.equals(depotMD5)){	
					CentreGestionDTO cgTmp = getCentreGestionDomainService().getCentreGestion(idCG);
					if(cgTmp!=null && cgTmp.isDepotAnonyme()){
						this.centreGestionDepotAnonyme=cgTmp;
						this.formOffre=new OffreDTO();
						this.formOffre.setIdCentreGestion(this.centreGestionDepotAnonyme.getIdCentreGestion());
						this.typeAjoutModifOffre=2;
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String editPdfOffre() {
		String ret = null;
		try	{
			/**
			 **  Methodes de creation des documents PDF selon l'edition demandee
			 **/
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			OffreDTO offreEdit = this.currentOffre;
			String description = "";
			String competences = "";
			String observations = "";
			String commentaires = "";
			if (offreEdit != null) {
				if (offreEdit.getDescription() !=null) {
					if (StringUtils.hasText(offreEdit.getDescription())) {
						description = Utils.replaceHTML(offreEdit.getDescription());
						offreEdit.setDescription(description);
					}
				}
				if (offreEdit.getCompetences() != null) {
					if (StringUtils.hasText(offreEdit.getCompetences())) {
						competences = Utils.replaceHTML(offreEdit.getCompetences());
						offreEdit.setCompetences(competences);
					}
					
				}
				if (offreEdit.getCommentaireTempsTravail() != null) {
					if (StringUtils.hasText(offreEdit.getCommentaireTempsTravail())) {
						commentaires = Utils.replaceHTML(offreEdit.getCommentaireTempsTravail());
						offreEdit.setCommentaireTempsTravail(commentaires);
					}
					
				}
				if (offreEdit.getObservations() != null) {
					if (StringUtils.hasText(offreEdit.getObservations())) {
						observations = Utils.replaceHTML(offreEdit.getObservations());
						offreEdit.setObservations(observations);
					}
					
				}

				String idOffre = Integer.toString(offreEdit.getIdOffre());
				nomDocxsl = "offre" + ".xsl";
				fileNameXml = "offre_" + idOffre;
				// appel castor pour fichier xml a partir de objet java convention
				castorService.objectToFileXml(offreEdit, fileNameXml + fileNameXmlfin);
				//fusion du xsl et xml en pdf
				String fileNamePdf = fileNameXml + ".pdf";
				PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(), 
						castorService.getXslXmlPath(),
						fileNamePdf, nomDocxsl);
				addInfoMessage(null, "CONVENTION.IMPRESSION.RECAP.CONFIRMATION");
			}
		
		} catch (ExportException e) {
			logger.error("editPdfRecap ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.RECAP.ERREUR", e.getMessage());
		}
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToOffreADiffuser(){
		if(this.critereRechercheOffre==null) this.critereRechercheOffre=initCritereRechercheOffre();
		this.critereRechercheOffre.setEstDiffusee(false);
		return this.rechercherOffre();
	}
	
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @return the formOffre
	 */
	public OffreDTO getFormOffre() {
		return formOffre;
	}

	/**
	 * @param formOffre the formOffre to set
	 */
	public void setFormOffre(OffreDTO formOffre) {
		this.formOffre = formOffre;
	}

	/**
	 * @return the contratsListening
	 */
	public List<SelectItem> getContratsListening() {
		return contratsListening;
	}

	/**
	 * @param contratsListening the contratsListening to set
	 */
	public void setContratsListening(List<SelectItem> contratsListening) {
		this.contratsListening = contratsListening;
	}

	/**
	 * @return the fapN3Listening
	 */
	public List<SelectItem> getFapN3Listening() {
		return fapN3Listening;
	}

	/**
	 * @param fapN3Listening the fapN3Listening to set
	 */
	public void setFapN3Listening(List<SelectItem> fapN3Listening) {
		this.fapN3Listening = fapN3Listening;
	}

	/**
	 * @return the formOffreCommunesListening
	 */
	public List<SelectItem> getFormOffreCommunesListening() {
		return formOffreCommunesListening;
	}

	/**
	 * @param formOffreCommunesListening the formOffreCommunesListening to set
	 */
	public void setFormOffreCommunesListening(
			List<SelectItem> formOffreCommunesListening) {
		this.formOffreCommunesListening = formOffreCommunesListening;
	}

	/**
	 * @return the avecFichierOuLien
	 */
	public boolean isAvecFichierOuLien() {
		return avecFichierOuLien;
	}

	/**
	 * @param avecFichierOuLien the avecFichierOuLien to set
	 */
	public void setAvecFichierOuLien(boolean avecFichierOuLien) {
		this.avecFichierOuLien = avecFichierOuLien;
	}

	/**
	 * @return the fichierOuLien
	 */
	public int getFichierOuLien() {
		return fichierOuLien;
	}

	/**
	 * @param fichierOuLien the fichierOuLien to set
	 */
	public void setFichierOuLien(int fichierOuLien) {
		this.fichierOuLien = fichierOuLien;
	}

	/**
	 * @return the typeAjoutModifOffre
	 */
	public int getTypeAjoutModifOffre() {
		return typeAjoutModifOffre;
	}

	/**
	 * @param typeAjoutModifOffre the typeAjoutModifOffre to set
	 */
	public void setTypeAjoutModifOffre(int typeAjoutModifOffre) {
		this.typeAjoutModifOffre = typeAjoutModifOffre;
	}

	/**
	 * @return the listeOffres
	 */
	public List<OffreDTO> getListeOffres() {
		return listeOffres;
	}

	/**
	 * @param listeOffres the listeOffres to set
	 */
	public void setListeOffres(List<OffreDTO> listeOffres) {
		this.listeOffres = listeOffres;
	}

	/**
	 * @return the retour
	 */
	public String getRetour() {
		if(!StringUtils.hasText(this.retour)) this.retour="defaut";
		return retour;
	}

	/**
	 * @param retour the retour to set
	 */
	public void setRetour(String retour) {
		this.retour = retour;
	}

	/**
	 * @return the recap
	 */
	public String getRecap() {
		String ret = recap;
		recap=null;
		return ret;
	}

	/**
	 * @param recap the recap to set
	 */
	public void setRecap(String recap) {
		this.recap = recap;
	}

	/**
	 * @return the currentOffre
	 */
	public OffreDTO getCurrentOffre() {
		return currentOffre;
	}

	/**
	 * @param currentOffre the currentOffre to set
	 */
	public void setCurrentOffre(OffreDTO currentOffre) {
		this.currentOffre = currentOffre;
	}

	/**
	 * @return the etablissementController
	 */
	public EtablissementController getEtablissementController() {
		return etablissementController;
	}

	/**
	 * @param etablissementController the etablissementController to set
	 */
	public void setEtablissementController(
			EtablissementController etablissementController) {
		this.etablissementController = etablissementController;
	}

	/**
	 * @return the listeItemsCurrentCentresGestion
	 */
	public List<SelectItem> getListeItemsCurrentCentresGestion() {
		listeItemsCurrentCentresGestion=null;
		if(getSessionController().getCurrentCentresGestion()!=null
				&& !getSessionController().getCurrentCentresGestion().isEmpty()){
			listeItemsCurrentCentresGestion=new ArrayList<SelectItem>();
			for(CentreGestionDTO cg : getSessionController().getCurrentCentresGestion()){
				listeItemsCurrentCentresGestion.add(new SelectItem(cg.getIdCentreGestion(), cg.getNomCentre()));
			}
		}
		return listeItemsCurrentCentresGestion;
	}

	/**
	 * @return the critereRechercheOffre
	 */
	public CritereRechercheOffreDTO getCritereRechercheOffre() {
		return critereRechercheOffre;
	}

	/**
	 * @param critereRechercheOffre the critereRechercheOffre to set
	 */
	public void setCritereRechercheOffre(
			CritereRechercheOffreDTO critereRechercheOffre) {
		this.critereRechercheOffre = critereRechercheOffre;
	}

	/**
	 * @return the rechTypesContratsOffre
	 */
	public List<SelectItem> getRechTypesContratsOffre() {
		rechTypesContratsOffre = new ArrayList<SelectItem>();
		List<TypeOffreDTO> lt = getNomenclatureDomainService().getTypesOffre();
		for(TypeOffreDTO t : lt){
			rechTypesContratsOffre.add(new SelectItem("t"+t.getId(),t.getLibelle()));
			List<ContratOffreDTO> lc = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(t.getId());
			if(lc!=null && !lc.isEmpty()){
				for(ContratOffreDTO c: lc){
					rechTypesContratsOffre.add(new SelectItem("c"+c.getId(), "--- "+c.getLibelle()));
				}
			}
		}
		return rechTypesContratsOffre;
	}

	/**
	 * @return the rechTypeOuContrat
	 */
	public String getRechTypeOuContrat() {
		return rechTypeOuContrat;
	}

	/**
	 * @param rechTypeOuContrat the rechTypeOuContrat to set
	 */
	public void setRechTypeOuContrat(String rechTypeOuContrat) {
		this.rechTypeOuContrat = rechTypeOuContrat;
	}

	/**
	 * @return the resultatsRechercheOffre
	 */
	public List<OffreDTO> getResultatsRechercheOffre() {
		return resultatsRechercheOffre;
	}

	/**
	 * @param resultatsRechercheOffre the resultatsRechercheOffre to set
	 */
	public void setResultatsRechercheOffre(List<OffreDTO> resultatsRechercheOffre) {
		this.resultatsRechercheOffre = resultatsRechercheOffre;
	}

	/**
	 * @return the rechercheAvancee
	 */
	public boolean isRechercheAvancee() {
		return rechercheAvancee;
	}

	/**
	 * @param rechercheAvancee the rechercheAvancee to set
	 */
	public void setRechercheAvancee(boolean rechercheAvancee) {
		this.rechercheAvancee = rechercheAvancee;
	}

	/**
	 * @return the rechercheOffrePaginator
	 */
	public RechercheOffrePaginator getRechercheOffrePaginator() {
		return rechercheOffrePaginator;
	}

	/**
	 * @param rechercheOffrePaginator the rechercheOffrePaginator to set
	 */
	public void setRechercheOffrePaginator(
			RechercheOffrePaginator rechercheOffrePaginator) {
		this.rechercheOffrePaginator = rechercheOffrePaginator;
	}

	/**
	 * @return the listesCentresGestionEtablissement
	 */
	public List<SelectItem> getListesCentresGestionEtablissement() {
		this.listesCentresGestionEtablissement = new ArrayList<SelectItem>();
		CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
		if(cgEntr!=null && getSessionController().getCurrentCentresGestion()!=null
				&& !getSessionController().getCurrentCentresGestion().isEmpty()){
			if(getSessionController().getCurrentCentresGestion().contains(cgEntr)){
				this.listesCentresGestionEtablissement.add(new SelectItem(0,getFacesInfoMessage("OFFRE.GESTION.DIFFUSIONCENTRE.DIFFUSERTLM").getDetail()));
				List<CentreGestionDTO> l = getCentreGestionDomainService().getCentresEtablissement(getSessionController().getCodeUniversite());
				this.listesCGEtab=l;
				if(l!=null && !l.isEmpty()){
					for(CentreGestionDTO cg : l){
						this.listesCentresGestionEtablissement.add(new SelectItem(cg.getIdCentreGestion(), cg.getNomCentre()));
					}
				}
			}else{
				this.listesCentresGestionEtablissement=new ArrayList<SelectItem>();
				CentreGestionDTO cgEtab = getCentreGestionDomainService().getCentreEtablissement(
						getSessionController().getCodeUniversite());
				this.listesCentresGestionEtablissement.add(new SelectItem(cgEtab.getIdCentreGestion(),""+cgEtab.getNomCentre()));
			}
		}
		return this.listesCentresGestionEtablissement;
	}

	/**
	 * @param listesCentresGestionEtablissement the listesCentresGestionEtablissement to set
	 */
	public void setListesCentresGestionEtablissement(
			List<SelectItem> listesCentresGestionEtablissement) {
		this.listesCentresGestionEtablissement = listesCentresGestionEtablissement;
	}

	/**
	 * @return the listesCentresGestionUniversite
	 */
	public List<SelectItem> getListesCentresGestionUniversite() {
		return listesCentresGestionUniversite;
	}

	/**
	 * @param listesCentresGestionUniversite the listesCentresGestionUniversite to set
	 */
	public void setListesCentresGestionUniversite(
			List<SelectItem> listesCentresGestionUniversite) {
		this.listesCentresGestionUniversite = listesCentresGestionUniversite;
	}

	/**
	 * @return the listesCentreGestionUniversiteADiffuser
	 */
	public List<SelectItem> getListesCentreGestionUniversiteADiffuser() {
		return listesCentreGestionUniversiteADiffuser;
	}

	/**
	 * @param listesCentreGestionUniversiteADiffuser the listesCentreGestionUniversiteADiffuser to set
	 */
	public void setListesCentreGestionUniversiteADiffuser(
			List<SelectItem> listesCentreGestionUniversiteADiffuser) {
		this.listesCentreGestionUniversiteADiffuser = listesCentreGestionUniversiteADiffuser;
	}

	/**
	 * @return the idCentreEtablissementSelect
	 */
	public int getIdCentreEtablissementSelect() {
		return idCentreEtablissementSelect;
	}

	/**
	 * @param idCentreEtablissementSelect the idCentreEtablissementSelect to set
	 */
	public void setIdCentreEtablissementSelect(int idCentreEtablissementSelect) {
		this.idCentreEtablissementSelect = idCentreEtablissementSelect;
	}

	/**
	 * @return the idsCentreGestionUniversiteSelect
	 */
	public List<Integer> getIdsCentreGestionUniversiteSelect() {
		return idsCentreGestionUniversiteSelect;
	}

	/**
	 * @param idsCentreGestionUniversiteSelect the idsCentreGestionUniversiteSelect to set
	 */
	public void setIdsCentreGestionUniversiteSelect(
			List<Integer> idsCentreGestionUniversiteSelect) {
		this.idsCentreGestionUniversiteSelect = idsCentreGestionUniversiteSelect;
	}

	/**
	 * @return the idsCentreGestionUniversiteADiffuser
	 */
	public List<Integer> getIdsCentreGestionUniversiteADiffuser() {
		return idsCentreGestionUniversiteADiffuser;
	}

	/**
	 * @param idsCentreGestionUniversiteADiffuser the idsCentreGestionUniversiteADiffuser to set
	 */
	public void setIdsCentreGestionUniversiteADiffuser(
			List<Integer> idsCentreGestionUniversiteADiffuser) {
		this.idsCentreGestionUniversiteADiffuser = idsCentreGestionUniversiteADiffuser;
	}

	/**
	 * @return the centreGestionDepotAnonyme
	 */
	public CentreGestionDTO getCentreGestionDepotAnonyme() {
		return centreGestionDepotAnonyme;
	}

	/**
	 * @param centreGestionDepotAnonyme the centreGestionDepotAnonyme to set
	 */
	public void setCentreGestionDepotAnonyme(
			CentreGestionDTO centreGestionDepotAnonyme) {
		this.centreGestionDepotAnonyme = centreGestionDepotAnonyme;
	}

	/**
	 * @return the castorService
	 */
	public CastorService getCastorService() {
		return castorService;
	}

	/**
	 * @param castorService the castorService to set
	 */
	public void setCastorService(CastorService castorService) {
		this.castorService = castorService;
	}

	/**
	 * @return the dureesDiffusion
	 */
	public List<SelectItem> getDureesDiffusion() {
		this.dureesDiffusion = new ArrayList<SelectItem>();
		boolean isAdmin;
		if (this.currentOffre == null) this.currentOffre = this.formOffre;
		
		Map<Integer,DroitAdministrationDTO> droitAcces = getSessionController().getDroitsAccesMap();
		if (droitAcces.get(this.currentOffre.getIdCentreGestion()) == getBeanUtils().getDroitAdmin()
			|| getSessionController().isAdminPageAuthorized()
			|| getSessionController().isSuperAdminPageAuthorized()){
			isAdmin = true;
		} else {
			isAdmin = false;
		}

		for(DureeDiffusionDTO dd : getOffreDomainService().getDureeDiffusion()){
			if (dd.isAdminSeulement()) {
				if (isAdmin) this.dureesDiffusion.add(new SelectItem(dd.getId(), dd.getLibelle()));
			} else{
				this.dureesDiffusion.add(new SelectItem(dd.getId(), dd.getLibelle()));
			}
		}
		return dureesDiffusion;
	}

	/**
	 * @param dureesDiffusion the dureesDiffusion to set
	 */
	public void setDureesDiffusion(List<SelectItem> dureesDiffusion) {
		this.dureesDiffusion = dureesDiffusion;
	}

	/**
	 * @return the dureeDiffusion
	 */
	public int getDureeDiffusion() {
		return dureeDiffusion;
	}

	/**
	 * @param dureeDiffusion the dureeDiffusion to set
	 */
	public void setDureeDiffusion(int dureeDiffusion) {
		this.dureeDiffusion = dureeDiffusion;
	}

	/**
	 * @return the diffusionDirecte
	 */
	public boolean isDiffusionDirecte() {
		return diffusionDirecte;
	}

	/**
	 * @param diffusionDirecte the diffusionDirecte to set
	 */
	public void setDiffusionDirecte(boolean diffusionDirecte) {
		this.diffusionDirecte = diffusionDirecte;
	}

	/**
	 * @param offreADiffuser the offreADiffuser to set
	 */
	public void setOffreADiffuser(int offreADiffuser) {
		this.offreADiffuser= offreADiffuser;
	}
	/**
	 * @return the offreADiffuser
	 */
	public int getOffreADiffuser() {
		this.offreADiffuser=getOffreDomainService().countOffreADiffuser();
		return this.offreADiffuser;
	}
}
