package org.esupportail.pstage.web.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.esupportail.pstage.domain.CentreGestionDomainService;
import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ConfidentialiteDTO;
import org.esupportail.pstagedata.domain.dto.ContratOffreDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.ModeCandidatureDTO;
import org.esupportail.pstagedata.domain.dto.NiveauCentreDTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.domain.dto.TempsTravailDTO;
import org.esupportail.pstagedata.domain.dto.TypeOffreDTO;


/**
 * BeanUtils Class.
 *
 */
/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class BeanUtils extends AbstractDomainAwareBean {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	/**
	 * CentreGestionDomainService
	 */
	private CentreGestionDomainService centreGestionDomainService;
	/**
	 * Jour de début d'année universitaire
	 */
	private String startYearDay;
	/**
	 * Mois de début d'année universitaire
	 */
	private String startYearMonth;
	
	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractContextAwareController#afterPropertiesSetInternal()
	 */
	@Override
	public void afterPropertiesSetInternal() {
		//
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
	
	/* ***************************************************************
	 * PAYS
	 ****************************************************************/
	
	/**
	 * Déclaration du pays France pour accés dans les JSPs
	 */
	private PaysDTO france;
	/**
	 * Retourne l'objet correpondant é la France (defaut id=82)
	 * @return PaysDTO
	 */
	public PaysDTO getFrance(){
		france = null;
		List<PaysDTO> l = getNomenclatureDomainService().getPays();
		if (l != null){
			for(PaysDTO p : l){
				if(p.getIso2()!= null){
					if (p.getIso2().equalsIgnoreCase(DonneesStatic.FRANCE_ISO2)){
						france=p;
						break;
					}
				}
			}
		}
		return france;
	}
	
	/**
	 * Retourne vrai si le pays en paramétre correspond à la France ou un de ses territoires
	 * @param p 
	 * @return boolean
	 */
	public boolean isFrance(PaysDTO p){
		boolean ret = false;
		if(p!=null)ret = getFrance()==p || p.getCog()==DonneesStatic.FRANCE_COG;
		return ret;
	}
	
	/**
	 * Retourne vrai si le pays en paramétre correspond à la France 
	 * @param p 
	 * @return boolean
	 */
	public boolean isFranceRecherche(PaysDTO p){
		boolean ret = false;
		if (p!=null) {
			if(p.getIso2()!= null){
				if (p.getIso2().equalsIgnoreCase(DonneesStatic.FRANCE_ISO2)){
					ret = true;
				}
			}
		}
		return ret;
	}
	
	/**
	 * COG des territoires français
	 */
	private String cogFrance;

	/**
	 * @return the cogFrance
	 */
	public String getCogFrance() {
		this.cogFrance=Integer.toString(getFrance().getCog());
		return this.cogFrance;
	}

	/* ***************************************************************
	 * TYPES D'OFFRE
	 ****************************************************************/
	
	/**
	 * Déclaration du type d'offre stage
	 */
	private TypeOffreDTO stage;
	
	/**
	 * Retourne l'objet correpondant au type stage
	 * @return TypeOffreDTO
	 */
	public TypeOffreDTO getStage(){
		stage = null;
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		for(TypeOffreDTO t : l){
			if(t.getCodeCtrl().equalsIgnoreCase(DonneesStatic.TYPE_OFFRE_CODE_CTRL_STAGE)){
				stage=t;
				break;
			}
		}
		return stage;
	}
	
	/**
	 * Retourne vrai si le type d'offre en paramétre correspond à un stage
	 * @param t
	 * @return boolean
	 */
	public boolean isStage(TypeOffreDTO t){
		return getStage()==t;
	}
	
	/**
	 * Déclaration du type d'offre emploi
	 */
	private TypeOffreDTO emploi;
	
	/**
	 * Retourne l'objet correpondant au type stage
	 * @return TypeOffreDTO
	 */
	public TypeOffreDTO getEmploi(){
		emploi = null;
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		for(TypeOffreDTO t : l){
			if(t.getCodeCtrl().equalsIgnoreCase(DonneesStatic.TYPE_OFFRE_CODE_CTRL_EMPLOI)){
				emploi=t;
				break;
			}
		}
		return emploi;
	}
	
	/**
	 * Retourne vrai si le type d'offre en paramètre correspond é un stage
	 * @param t
	 * @return boolean
	 */
	public boolean isEmploi(TypeOffreDTO t){
		return getEmploi()==t;
	}
	
	/**
	 * Déclaration du type d'offre en alternance
	 */
	private TypeOffreDTO alternance;
	
	/**
	 * Retourne l'objet correpondant au type alternance
	 * @return TypeOffreDTO
	 */
	public TypeOffreDTO getAlternance(){
		alternance = null;
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		for(TypeOffreDTO t : l){
			if(t.getCodeCtrl().equalsIgnoreCase(DonneesStatic.TYPE_OFFRE_CODE_CTRL_ALTERNANCE)){
				alternance=t;
				break;
			}
		}
		return alternance;
	}
	
	/**
	 * Retourne vrai si le type d'offre en paramétre correspond é l'alternance
	 * @param t
	 * @return boolean
	 */
	public boolean isAlternance(TypeOffreDTO t){
		return getAlternance()==t;
	}
	
	/**
	 * Déclaration du type d'offre en VIE/VIA
	 */
	private TypeOffreDTO vieVia;
	
	/**
	 * Retourne l'objet correpondant au type vie/vae
	 * @return TypeOffreDTO
	 */
	public TypeOffreDTO getVieVia(){
		vieVia = null;
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		for(TypeOffreDTO t : l){
			if(t.getCodeCtrl().equalsIgnoreCase(DonneesStatic.TYPE_OFFRE_CODE_CTRL_VIEVIA)){
				vieVia=t;
				break;
			}
		}
		return vieVia;
	}
	
	/**
	 * Retourne vrai si le type d'offre en paramétre correspond au vie/via
	 * @param t
	 * @return boolean
	 */
	public boolean isVieVia(TypeOffreDTO t){
		return getVieVia()==t;
	}
	
	/* ***************************************************************
	 * TYPES DE CONTRAT
	 ****************************************************************/
	
	/**
	 * Déclaration du type de contrat cdd
	 */
	private ContratOffreDTO cdd;
	
	/**
	 * Retourne l'objet correpondant au type stage
	 * @return TypeOffreDTO
	 */
	public ContratOffreDTO getCdd(){
		cdd = null;
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContrats();
		for(ContratOffreDTO c : l){
			if(c.getCodeCtrl().equalsIgnoreCase(DonneesStatic.CONTRAT_OFFRE_CODE_CTRL_CDD)){
				cdd=c;
				break;
			}
		}
		return cdd;
	}
	
	/**
	 * Retourne vrai si le type d'offre en paramétre correspond é un stage
	 * @param c
	 * @return boolean
	 */
	public boolean isCDD(ContratOffreDTO c){
		return getCdd()==c;
	}
	
	/**
	 * Déclaration du type de contrat cdi
	 */
	private ContratOffreDTO cdi;
	
	/**
	 * Retourne l'objet correpondant au type de contrat cdi
	 * @return TypeOffreDTO
	 */
	public ContratOffreDTO getCdi(){
		cdi = null;
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContrats();
		for(ContratOffreDTO c : l){
			if(c.getCodeCtrl().equalsIgnoreCase(DonneesStatic.CONTRAT_OFFRE_CODE_CTRL_CDI)){
				cdi=c;
				break;
			}
		}
		return cdi;
	}
	
	/**
	 * Retourne vrai si le type de contrat en paramétre correspond é un cdi
	 * @param c
	 * @return boolean
	 */
	public boolean isCDI(ContratOffreDTO c){
		return getCdi()==c;
	}
	
	/**
	 * Déclaration du type de contrat interim
	 */
	private ContratOffreDTO interim;
	
	/**
	 * Retourne l'objet correpondant au type de contrat interim
	 * @return TypeOffreDTO
	 */
	public ContratOffreDTO getInterim(){
		interim = null;
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContrats();
		for(ContratOffreDTO c : l){
			if(c.getCodeCtrl().equalsIgnoreCase(DonneesStatic.CONTRAT_OFFRE_CODE_CTRL_INTERIM)){
				interim=c;
				break;
			}
		}
		return interim;
	}
	
	/**
	 * Retourne vrai si le type de contrat en paramétre correspond é un interim
	 * @param c
	 * @return boolean
	 */
	public boolean isInterim(ContratOffreDTO c){
		return getInterim()==c;
	}
	
	/* ***************************************************************
	 * MODE CANDIDATURE
	 ****************************************************************/
	
	/**
	 * ModeCandidature par courrier
	 */
	private ModeCandidatureDTO modeCourrier;

	/**
	 * @return the modeCourrier
	 */
	public ModeCandidatureDTO getModeCourrier() {
		modeCourrier = null;
		List<ModeCandidatureDTO> l = getNomenclatureDomainService().getModesCandidature();
		for(ModeCandidatureDTO m : l){
			if(m.getCodeCtrl().equalsIgnoreCase(DonneesStatic.MODE_CANDIDATURE_CODE_CTRL_COUR)){
				modeCourrier=m;
				break;
			}
		}
		return modeCourrier;
	}
	
	/**
	 * ModeCandidature par tel
	 */
	private ModeCandidatureDTO modeTelephone;

	/**
	 * @return the modeTelephone
	 */
	public ModeCandidatureDTO getModeTelephone() {
		modeTelephone = null;
		List<ModeCandidatureDTO> l = getNomenclatureDomainService().getModesCandidature();
		for(ModeCandidatureDTO m : l){
			if(m.getCodeCtrl().equalsIgnoreCase(DonneesStatic.MODE_CANDIDATURE_CODE_CTRL_TEL)){
				modeTelephone=m;
				break;
			}
		}
		return modeTelephone;
	}
	
	/**
	 * ModeCandidature par mail
	 */
	private ModeCandidatureDTO modeMail;

	/**
	 * @return the modeMail
	 */
	public ModeCandidatureDTO getModeMail() {
		modeMail = null;
		List<ModeCandidatureDTO> l = getNomenclatureDomainService().getModesCandidature();
		for(ModeCandidatureDTO m : l){
			if(m.getCodeCtrl().equalsIgnoreCase(DonneesStatic.MODE_CANDIDATURE_CODE_CTRL_MAIL)){
				modeMail=m;
				break;
			}
		}
		return modeMail;
	}
	
	/* ***************************************************************
	 * TEMPS DE TRAVAIL
	 ****************************************************************/

	/**
	 * Objet TempsPlein
	 */
	private TempsTravailDTO tempsPlein;
	/**
	 * @return TempsTravailDTO TempsPlein
	 */
	public TempsTravailDTO getTempsPlein(){
		tempsPlein = null;
		List<TempsTravailDTO> l = getNomenclatureDomainService().getTempsTravail();
		for(TempsTravailDTO c : l){
			if(c.getCodeCtrl().equalsIgnoreCase(DonneesStatic.TEMPS_TRAVAIL_CODE_CTRL_COMPLET)){
				tempsPlein=c;
				break;
			}
		}
		return tempsPlein;
	}
	/**
	 * Objet TempsPartiel
	 */
	private TempsTravailDTO tempsPartiel;
	/**
	 * @return TempsTravailDTO TempsPartiel
	 */
	public TempsTravailDTO getTempsPartiel(){
		tempsPartiel = null;
		List<TempsTravailDTO> l = getNomenclatureDomainService().getTempsTravail();
		for(TempsTravailDTO c : l){
			if(c.getCodeCtrl().equalsIgnoreCase(DonneesStatic.TEMPS_TRAVAIL_CODE_CTRL_PARTIEL)){
				tempsPartiel=c;
				break;
			}
		}
		return tempsPartiel;
	}
	/* ***************************************************************
	 * NIVEAUX DE CENTRE
	 ****************************************************************/
	/**
	 * Libelle des centre gestion de type Etablissement
	 */
	private String libelleEtablissement = "ETABLISSEMENT";	
	/**
	 * Getter pour récupérer la valeur "ETABLISSEMENT" dans les menus jsp pour definir la visibilité des liens via l'attribut 'rendered'
	 * @return the libelleEtablissement
	 */
	public String getLibelleEtablissement() {
		return libelleEtablissement;
	}
	
	/**
	 * Libelle des centre gestion de type Entreprise
	 */
	private String libelleEntreprise = "ENTREPRISE";
	/**
	 * Getter pour récupérer la valeur "ENTREPRISE" dans les menus jsp pour definir la visibilité des liens via l'attribut 'rendered'
	 * @return the libelleEntreprise
	 */
	public String getLibelleEntreprise() {
		return libelleEntreprise;
	}
	
	/**
	 * Retourne l'objet correspondant au niveau de centre Entreprise
	 * @return NiveauCentreDTO
	 */
	public NiveauCentreDTO getEntreprise(){
		return getNomenclatureDomainService().getNiveauCentreFromLibelle(DonneesStatic.CG_ENTREPRISE);
	}
	/**
	 * Retourne l'objet correspondant au niveau de centre Etablissement
	 * @return NiveauCentreDTO
	 */
	public NiveauCentreDTO getEtablissement(){
		return getNomenclatureDomainService().getNiveauCentreFromLibelle(DonneesStatic.CG_ETAB);
	}

	/**
	 * Retourne vrai si le centre en paramétre correspond au centre etablissement
	 * @param cg
	 * @return boolean
	 */
	public boolean isEtablissement(CentreGestionDTO cg){
		return ((cg.getNiveauCentre()) == getEtablissement());
	}
	/**
	 * Retourne l'objet correspondant au niveau de centre Etape
	 * @return NiveauCentreDTO
	 */
	public NiveauCentreDTO getEtape(){
		return getNomenclatureDomainService().getNiveauCentreFromLibelle(DonneesStatic.CG_ETAPE);
	}
	/**
	 * Retourne l'objet correspondant au niveau de centre UFR
	 * @return NiveauCentreDTO
	 */
	public NiveauCentreDTO getUfr(){
		return getNomenclatureDomainService().getNiveauCentreFromLibelle(DonneesStatic.CG_UFR);
	}
	
	/* ***************************************************************
	 * NIVEAUX DE CONFIDENTIALITE
	 ****************************************************************/
	
	/**
	 * Objet ConfidentialiteNulle
	 */
	private ConfidentialiteDTO confidentialiteNulle;
	/**
	 * @return ConfidentialiteDTO
	 */
	public ConfidentialiteDTO getConfidentialiteNulle(){
		confidentialiteNulle = null;
		List<ConfidentialiteDTO> l = getNomenclatureDomainService().getConfidentialites();
		for(ConfidentialiteDTO c : l){
			if (c.getCode().equalsIgnoreCase(DonneesStatic.CODE_CONFIDENTIALITE_NULLE)){
				confidentialiteNulle = c;
			}
		}
		return confidentialiteNulle;
	}

	/**
	 * Objet ConfidentialiteLibre
	 */
	private ConfidentialiteDTO confidentialiteTotale;
	/**
	 * @return ConfidentialiteDTO
	 */
	public ConfidentialiteDTO getConfidentialiteTotale(){
		confidentialiteTotale = null;
		List<ConfidentialiteDTO> l = getNomenclatureDomainService().getConfidentialites();
		for(ConfidentialiteDTO c : l){
			if (c.getCode().equalsIgnoreCase(DonneesStatic.CODE_CONFIDENTIALITE_TOTALE)){
				confidentialiteTotale = c;
			}
		}
		return confidentialiteTotale;
	}
	
	/**
	 * Objet ConfidentialiteLibre
	 */
	private ConfidentialiteDTO confidentialiteLibre;
	/**
	 * @return ConfidentialiteDTO
	 */
	public ConfidentialiteDTO getConfidentialiteLibre(){
		confidentialiteLibre = null;
		List<ConfidentialiteDTO> l = getNomenclatureDomainService().getConfidentialites();
		for(ConfidentialiteDTO c : l){
			if (c.getCode().equalsIgnoreCase(DonneesStatic.CODE_CONFIDENTIALITE_LIBRE)){
				confidentialiteLibre = c;
			}
		}
		return confidentialiteLibre;
	}
	
	/* ***************************************************************
	 * DROITS D'ADMINISTRATION
	 ****************************************************************/
	/**
	 * String
	 */
	private String libelleDroitAdmin = "ADMIN";

	/**
	 * @return the libelleDroitAdmin
	 */
	public String getLibelleDroitAdmin() {
		return libelleDroitAdmin;
	}
	/**
	 * Objet DroitAdmin
	 */
	private DroitAdministrationDTO droitAdmin;
	/**
	 * @return DroitAdministrationDTO
	 */
	public DroitAdministrationDTO getDroitAdmin(){
		droitAdmin = null;
		List<DroitAdministrationDTO> l = getNomenclatureDomainService().getDroitsAdmin();
		for(DroitAdministrationDTO c : l){
			if (c.getLibelle().equalsIgnoreCase(this.libelleDroitAdmin)){
				droitAdmin = c;
			}
		}
		return droitAdmin;
	}
	
	/**
	 * String
	 */
	private String libelleDroitEcriture = "ECRITURE";
	/**
	 * @return the libelleDroitAdmin
	 */
	public String getLibelleDroitEcriture() {
		return libelleDroitEcriture;
	}
	/**
	 * Objet DroitEcriture
	 */
	private DroitAdministrationDTO droitEcriture;
	/**
	 * @return DroitAdministrationDTO
	 */
	public DroitAdministrationDTO getDroitEcriture(){
		droitEcriture = null;
		List<DroitAdministrationDTO> l = getNomenclatureDomainService().getDroitsAdmin();
		for(DroitAdministrationDTO c : l){
			if (c.getLibelle().equalsIgnoreCase(DonneesStatic.LIBELLE_DROIT_ECRITURE)){
				droitEcriture = c;
			}
		}
		return droitEcriture;
	}
	
	/**
	 * Objet DroitLecture
	 */
	private DroitAdministrationDTO droitLecture;
	/**
	 * @return DroitAdministrationDTO
	 */
	public DroitAdministrationDTO getDroitLecture(){
		droitLecture = null;
		List<DroitAdministrationDTO> l = getNomenclatureDomainService().getDroitsAdmin();
		for(DroitAdministrationDTO c : l){
			if (c.getLibelle().equalsIgnoreCase(DonneesStatic.LIBELLE_DROIT_LECTURE)){
				droitLecture = c;
			}
		}
		return droitLecture;
	}

	/**
	 * String
	 */
	private String libelleDroitEcritureAvantValP = "ECRITURE_AVANT_VALP";

	/**
	 * @return the libelleDroitAdmin
	 */
	public String getLibelleDroitEcritureAvantValP() {
		return libelleDroitEcritureAvantValP;
	}

	/**
	 * Objet DroitEcriture
	 */
	private DroitAdministrationDTO droitEcritureAvantValP;
	/**
	 * @return DroitAdministrationDTO
	 */
	public DroitAdministrationDTO getDroitEcritureAvantValP() {
		droitEcritureAvantValP = null;

		List<DroitAdministrationDTO> l = getNomenclatureDomainService().getDroitsAdmin();

		for (DroitAdministrationDTO c : l) {
			if (c.getLibelle().equalsIgnoreCase(DonneesStatic.LIBELLE_DROIT_ECRITURE_AVANT_VALP)) {
				droitEcritureAvantValP = c;
			}
		}

		return droitEcritureAvantValP;
	}

	
	/* ***************************************************************
	 * Méme Adresse
	 ****************************************************************/ 
	
	/**
	 * Récupere l'adresse de la structure st pour la copier au service se
	 * @param st : structure dont l'adresse est à copier
	 * @param se : service dont l'adresse est à remplir 
	 * @return ServiceDTO
	 */
	public static ServiceDTO copieAdresseStructureVersService(StructureDTO st, ServiceDTO se){
		se.setBatimentResidence(st.getBatimentResidence());
		se.setVoie(st.getVoie());
		se.setCommune(st.getCommune());
		se.setCodeCommune(st.getCodeCommune());
		se.setCodePostal(st.getCodePostal());
		se.setLibCedex(st.getLibCedex());
		se.setIdPays(st.getIdPays());
		return se;
	}
	
	
	/**
	 * 
	 */
	/* ***************************************************************
	 * imdemnisationOui
	 ****************************************************************/ 
	/**
	 * indemnisationOui
	 */
	
	private String indemnisationOui;
	
	
	/**
	 * @return the indemnisationOui
	 */
	public String getIndemnisationOui() {
		indemnisationOui = DonneesStatic.OUI;
		return indemnisationOui;
	}

	/* ***************************************************************
	 * Année Universitaire
	 ****************************************************************/ 
	
	/**
	 * Calcul la date universitaire courante de la date en paramétre 
	 * par rapport à la configuration
	 * @param date
	 * @return String xxxx/xxxx
	 */
	public String getAnneeUniversitaireCourante(Date date){
		String anneeUniversitaire;
		Calendar debutStage = Calendar.getInstance();
		debutStage.setTime(date);
		int year = debutStage.get(Calendar.YEAR);
		Calendar debutAnnee = Calendar.getInstance();
		debutAnnee.set(year, Integer.parseInt(startYearMonth) - 1, Integer.parseInt(startYearDay), 0, 0, 0);
		// pas de millisecond (sinon c sera toujours avant debut annee, meme
		// s'il s'agit du meme jour)
		debutAnnee.clear(Calendar.MILLISECOND);
		//si debut stage dans le mois precedent la date de dubut d'annee et si choice.year=true dans le fichier de config
		Calendar debutAnneeMinusAMonth = (Calendar) debutAnnee.clone();
		debutAnneeMinusAMonth.add(Calendar.MONTH, -1);
		// mois suivant la date de debut d'annee 
		Calendar debutAnneePlusAMonth = (Calendar) debutAnnee.clone();
		debutAnneePlusAMonth.add(Calendar.MONTH, 1);
		//la date de debut de stage peut etre calculee automatiquement
		if (debutStage.before(debutAnnee)){
			anneeUniversitaire = ((year - 1) + "/" + year);
		}else{
			anneeUniversitaire =(year + "/" + (year + 1));
		}
		return anneeUniversitaire;
	}


	/* ***************************************************************
	 * GETTERS/SETTERS
	 ****************************************************************/

	
	/**
	 * @return the nomenclatureDomainService
	 */
	public NomenclatureDomainService getNomenclatureDomainService() {
		return nomenclatureDomainService;
	}

	/**
	 * @param nomenclatureDomainService the nomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(
			NomenclatureDomainService nomenclatureDomainService) {
		this.nomenclatureDomainService = nomenclatureDomainService;
	}

	/**
	 * @return the centreGestionDomainService
	 */
	public CentreGestionDomainService getCentreGestionDomainService() {
		return centreGestionDomainService;
	}

	/**
	 * @param centreGestionDomainService the centreGestionDomainService to set
	 */
	public void setCentreGestionDomainService(
			CentreGestionDomainService centreGestionDomainService) {
		this.centreGestionDomainService = centreGestionDomainService;
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
	public void setStartYearDay(String startYearDay) {
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
	public void setStartYearMonth(String startYearMonth) {
		this.startYearMonth = startYearMonth;
	}

	/**
	 * Retourne le code correspondant à donneesStatic.TYPE_CONVENTION_CODE_CTRL_FC
	 */
	public String getCodeCtrlFC(){
		return DonneesStatic.TYPE_CONVENTION_CODE_CTRL_FC;
	}
	/**
	 * Retourne le code correspondant à donneesStatic.TYPE_CONVENTION_CODE_CTRL_FI
	 */
	public String getCodeCtrlFI(){
		return DonneesStatic.TYPE_CONVENTION_CODE_CTRL_FI;
	}
}
