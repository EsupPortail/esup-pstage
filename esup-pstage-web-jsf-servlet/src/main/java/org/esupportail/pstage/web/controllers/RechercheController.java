/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.paginators.RechercheStructurePaginator;
import org.esupportail.pstagedata.domain.dto.*;
import org.primefaces.event.SelectEvent;
import org.springframework.util.StringUtils;


/**
 * RechercheController pour etablissement
 */
public class RechercheController extends AbstractContextAwareController {

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
	private final transient Logger logger = Logger.getLogger(this.getClass());
	/**
	 * Numéro de l'onglet courant
	 */
	private int ongletCourant=2;
	/**
	 * Vrai si le bouton pour ajouter un établissement doit être affiché
	 */
	private boolean afficherBoutonAjoutEtab=false;
	/**
	 * Résultats d'une recherche (si plusieurs)
	 */
	private List<StructureDTO> listeResultatsRechercheStructure;
	/**
	 * Résultat d'une recherche (si unique)
	 */
	private StructureDTO resultatRechercheStructure=null;
	/**
	 * RechercheStructurePaginator
	 */
	private RechercheStructurePaginator rechercheStructurePaginator;
	/* *********************************************
	 * Variables des onglets communs
	 **********************************************/
	/* ** 
	 * Champs communs
	 */
	/**
	 * Département
	 */
	private String rechDepartement;
	/**
	 * Pays
	 */
	private PaysDTO rechPays;
	/* ** 
	 * Champs onglet 1 : Siren/Siret
	 */
	/**
	 * Numéro Siren
	 */
	private String rechNumeroSiren;
	/**
	 * Numéro Siret
	 */
	private String rechNumeroSiret;
	/* ** 
	 * Champs onglet 2 : Raison Sociale (+dep)
	 */
	/**
	 * Raison Sociale
	 */
	private String rechRaisonSociale;
	/* ** 
	 * Champs onglet 3 : Activité (+dep)
	 */
	/**
	 * Type d'établissement
	 */
	private TypeStructureDTO rechTypeEtablissement;
	/**
	 * Secteur d'activité / Naf N1
	 */
	private NafN1DTO rechNafN1;
	/* ** 
	 * Champs onglet 4 : Tél./Fax
	 */
	/**
	 * Téléphone
	 */
	private String rechTelephone;
	/**
	 * Fax
	 */
	private String rechFax;
	/* ** 
	 * Champs onglet 7 : Adresse
	 */
	/**
	 * Criteres de recherche par adresse
	 */
	//private CritereRechercheStructureAdresseDTO critereRechercheStructureAdresse=new CritereRechercheStructureAdresseDTO();

	private CritereRechercheStructureAdresseDTO critereRechercheStructureAdresse=initCritereRechercheStructureAdresse();

	private boolean france=false;

	//	///////// modification pour grenoble
	//	private String mailLoginCreation="";	
	//	private String mailLoginModif="";
	//	/////////

	/* *********************************************
	 * FIN Variables des onglets communs
	 **********************************************/

	/* ** 
	 * Champs onglet 5 : Service (+dep)
	 * pour administrateurs
	 */
	/**
	 * Nom du service
	 */
	private String rechNomService;
	/* ** 
	 * Champs onglet 6 : Accord (+raison Sociale)
	 * pour Espace Entreprise
	 */
	/**
	 * Choix :
	 * 0 : recherche des structures dont l'accord est à valider
	 * 1 : recherche des structures dont l'accord est validé
	 * 2 : recherche des structures sans accord
	 */
	private int rechTypeAccord=0;
	/**
	 * Liste des types d'accord
	 * 0 : recherche des structures dont l'accord est à valider
	 * 1 : recherche des structures dont l'accord est validé
	 * 2 : recherche des structures sans accord
	 */
	private List<SelectItem> listTypeAccord;
	/**
	 * Date de début pour l'intervalle de recherche
	 */
	private Date dateDebut;
	/**
	 * Date de fin pour l'intervalle de recherche
	 */
	private Date dateFin;
	/**
	 * Nombre d'accord à valider (pour affichage menu) : voir getter
	 */
	private int accordAValider=0;
	/**
	 * Date pattern
	 */
	private static String datePattern=Utils.DATE_PATTERN;

	/**
	 * Taille de la liste de résultats de la recherche d'établissement
	 */
	@SuppressWarnings("unused")
	private int resultatRechercheSize;

	/**
	 * Indique si la liste de resultats d'établissement est celle de la page de verification
	 */
	private boolean toVerificationStructures = false;

	/**
	 * Indique si la liste de resultats d'établissement est celle de la page des etab supprimés (temoin a false)
	 */
	private boolean toStructuresTemFalse = false;

	/**
	 * Indique si l'on a lancée la recherche d'etablissement ou pas (affichage de la recherche ou des resultats)
	 */
	private boolean rechercheEtabOk = false;

	/**
	 * Bean constructor.
	 */
	public RechercheController() {
		super();
	}
	


	/* ***************************************************************
	 * Actions
	 ****************************************************************/
	/**
	 * @return int
	 */
	public int getResultatRechercheSize(){
		return this.listeResultatsRechercheStructure.size();
	}


	/**
	 * @return A String
	 */
	public String goToRechercheEtablissement(){
		this.toVerificationStructures = false;
		this.toStructuresTemFalse=false;
		this.rechRaisonSociale = "";
		if(this.critereRechercheStructureAdresse==null){
			this.critereRechercheStructureAdresse=initCritereRechercheStructureAdresse();//new CritereRechercheStructureAdresseDTO();
		}
		this.listeResultatsRechercheStructure = new ArrayList<StructureDTO>();
		reloadRechercheStructurePaginator();
		return "rechercheEtablissement";
	}

	/**
	 * @return A String
	 */
	public String goToRechercheEtablissementStage(){
		this.afficherBoutonAjoutEtab=false;
		this.toVerificationStructures = false;
		this.toStructuresTemFalse=false;
		this.rechRaisonSociale = "";
		if(this.critereRechercheStructureAdresse==null){
			this.critereRechercheStructureAdresse=initCritereRechercheStructureAdresse();//new CritereRechercheStructureAdresseDTO();
		}
		this.listeResultatsRechercheStructure = new ArrayList<StructureDTO>();
		reloadRechercheStructurePaginator();
		return "rechercheEtablissementStage";
	}

	/**
	 * @return A String
	 */
	public String goToEtablissementsAVerifier(){

		this.afficherBoutonAjoutEtab=false;
		this.toVerificationStructures=true;
		this.toStructuresTemFalse=false;

		if(this.critereRechercheStructureAdresse==null){
			this.critereRechercheStructureAdresse=initCritereRechercheStructureAdresse();//new CritereRechercheStructureAdresseDTO();
		}
		resetResultats();
		reloadRechercheStructurePaginator();

		this.listeResultatsRechercheStructure=new ArrayList<StructureDTO>();

		this.listeResultatsRechercheStructure = getStructureDomainService().getStructuresFromVerification(0);

		checkListeResultats();

		return "etablissementsAValider";
	}

	/**
	 * Recherche par temoin en service a false
	 * @return String
	 */
	public String rechercheTemoinFalse(){

		this.afficherBoutonAjoutEtab=false;
		this.toVerificationStructures=false;
		this.toStructuresTemFalse=true;

		if(this.critereRechercheStructureAdresse==null){
			this.critereRechercheStructureAdresse=initCritereRechercheStructureAdresse();//new CritereRechercheStructureAdresseDTO();
		}
		resetResultats();
		reloadRechercheStructurePaginator();

		this.listeResultatsRechercheStructure=new ArrayList<StructureDTO>();

		this.listeResultatsRechercheStructure = getStructureDomainService().getStructuresTemEnServFalse();

		checkListeResultats();

		return "etablissementsTemFalse";
	}

	/**
	 * @return A String
	 */
	public String goToAffichageRechercheEtablissement(){

		if(this.critereRechercheStructureAdresse==null){
			this.critereRechercheStructureAdresse=new CritereRechercheStructureAdresseDTO();
		}
		// obtention mail du LoginCreation si LoginCreation est un etudiant
		if (this.resultatRechercheStructure != null){
			EtudiantDTO etudiant = this.getEtudiantDomainService().getEtudiantFromUid(this.resultatRechercheStructure.getLoginCreation(), getSessionController().getCodeUniversite());
			if (etudiant!=null){
				// si la structure a ete creee par un etudiant, on ajoute son mail au login creation affiche
				String loginCreationAndMail = this.resultatRechercheStructure.getLoginCreation();
				loginCreationAndMail+=("<i>("+etudiant.getMail()+")</i>");
				this.resultatRechercheStructure.setLoginCreation(loginCreationAndMail);
			}
		}
		return "affichageRechercheEtablissement";
	}

	/* *********************************************
		 * Changement d'onglets
		 **********************************************/
	public List<SelectItem> getOnglets() {
		List<SelectItem> ls = new ArrayList<SelectItem>();
		ls.add(new SelectItem(2,getString("RECHERCHEETABLISSEMENT.ONGLET2")));
		ls.add(new SelectItem(1,getString("RECHERCHEETABLISSEMENT.ONGLET1")));
		ls.add(new SelectItem(3,getString("RECHERCHEETABLISSEMENT.ONGLET3")));
		ls.add(new SelectItem(4,getString("RECHERCHEETABLISSEMENT.ONGLET4")));
		ls.add(new SelectItem(7,getString("RECHERCHEETABLISSEMENT.ONGLET7")));
		ls.add(new SelectItem(5,getString("RECHERCHEETABLISSEMENT.ONGLET5")));
		// Seulement si l'on est dans la partie entreprise :
		if (getSessionController().isPageAuthorized() || getSessionController().isAdminPageAuthorized()) {
			ls.add(new SelectItem(6, getString("RECHERCHEETABLISSEMENT.ONGLET6")));
		}
		return ls;
	}

	public void changeOnglet(){
		afficherBoutonAjoutEtab=false;
		resetResultats();
	}

	/* *********************************************
	 * Recherches pour l'onglet 1
	 **********************************************/
	/**
	 * Recherche des établissements par SIRET pour l'onglet 1
	 * @return String
	 */
	public void rechercheEtabSiret(){
		afficherBoutonAjoutEtab=true;

		String currentForm;
		if (FacesContext.getCurrentInstance().getViewRoot().findComponent("formResultatsRechEtab") == null){
			currentForm = "formConvention";
		} else {
			currentForm = "formResultatsRechEtab";
		}

		if(StringUtils.hasText(this.rechNumeroSiret)){
			if (Utils.validateNumSiret(this.rechNumeroSiret)) {
				this.rechNumeroSiren = null;
				this.resultatRechercheStructure = null;
				this.listeResultatsRechercheStructure = new ArrayList<StructureDTO>();

				StructureDTO result = getStructureDomainService().getStructureFromNumSiret(this.rechNumeroSiret);

				if (result != null) {
					this.listeResultatsRechercheStructure.add(result);
				} else {
					this.listeResultatsRechercheStructure = null;
				}

				checkListeResultats();
			} else {
				addErrorMessage(currentForm+":rechNumeroSiret","STRUCTURE.NUM_SIRET.VALIDATION");
			}
		}else{
			resetResultats();
			addErrorMessage(currentForm+":rechNumeroSiret","FORM.CHAMP_OBLIGATOIRE");
		}
	}

	/**
	 * Recherche des établissements par SIREN pour l'onglet 1
	 * @return String
	 */
	public void rechercheEtabSiren(){

		afficherBoutonAjoutEtab = true;

		String currentForm;
		if (FacesContext.getCurrentInstance().getViewRoot().findComponent("formResultatsRechEtab") == null){
			currentForm = "formConvention";
		} else {
			currentForm = "formResultatsRechEtab";
		}

		if(StringUtils.hasText(this.rechNumeroSiren)){
			if (Utils.validateNumSiren(this.rechNumeroSiren)) {
				this.rechNumeroSiret = null;
				this.resultatRechercheStructure = null;
				this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromNumSiren(this.rechNumeroSiren);
				checkListeResultats();
			} else {
				addErrorMessage(currentForm+":rechNumeroSiret","STRUCTURE.NUM_SIRET.VALIDATION");
			}
		}else{
			resetResultats();
			addErrorMessage(currentForm+":rechNumeroSiren","FORM.CHAMP_OBLIGATOIRE");
		}
	}

	/* *********************************************
	 * Recherches pour l'onglet 2
	 **********************************************/

	/**
	 * Recherche des établissements par Raison sociale,
	 * département optionnel
	 * @return String
	 */
	public String rechercheRaisonSociale(){

		afficherBoutonAjoutEtab=true;

		if(!StringUtils.hasText(this.rechRaisonSociale)){
			this.rechRaisonSociale = "";
		}
		this.resultatRechercheStructure=null;

		if(this.getRechPays()!=null && this.getRechPays().getId()>0){
			if(StringUtils.hasText(this.rechDepartement)){
				this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromRaisonSocialeEtDepartementFr("%"+this.rechRaisonSociale, this.rechDepartement);
			}
			else{
				this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromRaisonSocialeEtPays("%"+this.rechRaisonSociale, this.getRechPays().getCog());
			}
		}
		else {
			this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromRaisonSociale("%"+this.rechRaisonSociale);
		}

		checkListeResultats();

		return null;
	}

	/* *********************************************
	 * Recherches pour l'onglet 3
	 **********************************************/

	/**
	 * Recherche par activité
	 * @return String
	 */
	public void rechercheActivite(){
		afficherBoutonAjoutEtab=true;

		if(this.rechTypeEtablissement!=null || this.rechNafN1!=null){
			this.resultatRechercheStructure = null;
			this.listeResultatsRechercheStructure = getStructureDomainService().getStructuresFromTypeStructureNafN1EtDepartement(
					this.rechTypeEtablissement != null ? this.rechTypeEtablissement.getId() : 0,
					this.rechNafN1 != null ? this.rechNafN1.getCode() : null,
					this.rechDepartement);
			checkListeResultats();
		}else{
			resetResultats();
		}
	}

	/* *********************************************
	 * Recherches pour l'onglet 4
	 **********************************************/

	/**
	 * Recherche par téléphone
	 * @return String
	 */
	public void rechercheTel(){
		afficherBoutonAjoutEtab=true;
		if(StringUtils.hasText(this.rechTelephone)){
			this.resultatRechercheStructure=null;
			this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromTelephone(this.rechTelephone);
			checkListeResultats();
		}else{
			resetResultats();
			String currentForm;
			if (FacesContext.getCurrentInstance().getViewRoot().findComponent("formResultatsRechEtab") == null){
				currentForm = "formConvention";
			} else {
				currentForm = "formResultatsRechEtab";
			}
			addErrorMessage(currentForm+":rechTelephone","FORM.CHAMP_OBLIGATOIRE");
		}
	}
	/**
	 * Recherche par fax
	 * @return String
	 */
	public void rechercheFax(){
		afficherBoutonAjoutEtab=true;
		if(StringUtils.hasText(this.rechFax)){
			this.resultatRechercheStructure=null;
			this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromFax(this.rechFax);
			checkListeResultats();
		}else{
			resetResultats();
			String currentForm;
			if (FacesContext.getCurrentInstance().getViewRoot().findComponent("formResultatsRechEtab") == null){
				currentForm = "formConvention";
			} else {
				currentForm = "formResultatsRechEtab";
			}
			addErrorMessage(currentForm+":rechFax","FORM.CHAMP_OBLIGATOIRE");
		}
	}

	/* *********************************************
	 * Recherches pour l'onglet 7
	 **********************************************/

	/**
	 * Recherche par Adresse
	 * @return String
	 */
	public void rechercheAdresse(){

		afficherBoutonAjoutEtab=true;

		if(this.critereRechercheStructureAdresse!=null &&
				(StringUtils.hasText(this.critereRechercheStructureAdresse.getRechVoie())
						|| StringUtils.hasText(this.critereRechercheStructureAdresse.getRechBatimentResidence())
						|| StringUtils.hasText(this.critereRechercheStructureAdresse.getRechVille())
						|| StringUtils.hasText(this.critereRechercheStructureAdresse.getCodePostal())
						|| (this.critereRechercheStructureAdresse.getRechPays() != null && this.critereRechercheStructureAdresse.getRechPays().getId() > 0))){
			this.resultatRechercheStructure = null;
			this.listeResultatsRechercheStructure = getStructureDomainService().getStructuresFromAdresse(this.critereRechercheStructureAdresse);
			checkListeResultats();
		}else{
			resetResultats();
			if (FacesContext.getCurrentInstance().getViewRoot().findComponent("formResultatsRechEtab") == null){
				addErrorMessage("formConvention", "RECHERCHEETU.OBLIGATOIRE.RESPECTER");
			} else {
				addErrorMessage("formResultatsRechEtab", "RECHERCHEETU.OBLIGATOIRE.RESPECTER");
			}
		}
	}

	/* *********************************************
	 * Recherches pour l'onglet 5
	 **********************************************/

	/**
	 * Recherche par Service
	 * @return String
	 */
	public void rechercheService(){
		afficherBoutonAjoutEtab=true;
		if(StringUtils.hasText(this.rechNomService)){
			this.resultatRechercheStructure=null;
			this.listeResultatsRechercheStructure=getStructureDomainService().getStructuresFromNomServiceEtDepartement(this.rechNomService,this.rechDepartement);
			checkListeResultats();
		}else{
			resetResultats();
		}
	}

	/* *********************************************
	 * Recherches pour l'onglet 6
	 **********************************************/

	/**
	 * Recherche par accord
	 * @return String
	 */
	public String rechercheAccord(){
		afficherBoutonAjoutEtab=true;
		this.listeResultatsRechercheStructure=null;
		this.resultatRechercheStructure=null;
		if(this.dateDebut!=null && this.dateFin!=null){
			if(this.dateDebut.after(this.dateFin)){
				addErrorMessage("formRechEtab", "RECHERCHEETABLISSEMENT.ONGLET6.ERREURDATE");
				return null;
			}
		}
		// On conserve le rechRaisonSociale dans une variable pour ne pas impacter la saisie
		// (=% qui se retrouve dans l'input quand on fait un retour en arriere)
		String tmpRaisonSociale = this.rechRaisonSociale;
		if (tmpRaisonSociale == null){
			tmpRaisonSociale = "%";
		}

		switch (this.rechTypeAccord) {
			//Structures avec accord à valider
			case 0:
				this.listeResultatsRechercheStructure=getStructureDomainService()
						.getStructuresAvecAccordAValiderFromRaisonSociale(tmpRaisonSociale, this.dateDebut, this.dateFin);
				checkListeResultats();
				break;
			//Structures avec accord validé
			case 1:
				this.listeResultatsRechercheStructure=getStructureDomainService()
						.getStructuresAvecAccordValidesFromRaisonSociale(tmpRaisonSociale, this.dateDebut, this.dateFin);
				checkListeResultats();
				break;
			//Structures sans accord
			case 2:
				if(StringUtils.hasText(this.rechRaisonSociale)){
					this.listeResultatsRechercheStructure=getStructureDomainService()
							.getStructuresSansAccordFromRaisonSociale(tmpRaisonSociale);
					checkListeResultats();
				}
				break;
			default:
				break;
		}
		return null;
	}


	/**
	 * Re-chargement du paginator 
	 */
	public void reloadRechercheStructurePaginator(){
		this.rechercheStructurePaginator.reset();
		this.rechercheStructurePaginator.setListe(this.listeResultatsRechercheStructure);
		this.setRechercheEtabOk(true);
		this.rechercheStructurePaginator.forceReload();
	}

	/**
	 * Contrôle la liste des résultats
	 * Si un seul résultat, transfert du résultat vers "this.resultatRechercheStructure" 
	 * pour un affichage du détail de la structure
	 */
	private void checkListeResultats(){
		if(this.listeResultatsRechercheStructure==null && this.resultatRechercheStructure==null){
			if (FacesContext.getCurrentInstance().getViewRoot().findComponent("formResultatsRechEtab") == null){
				addInfoMessage("formConvention", "RECHERCHEETABLISSEMENT.AUCUNRESULTAT");
			} else {
				addInfoMessage("formResultatsRechEtab", "RECHERCHEETABLISSEMENT.AUCUNRESULTAT");
			}
		} else if (this.listeResultatsRechercheStructure!=null){
			reloadRechercheStructurePaginator();
		}
	}

	/**
	 *
	 */
	private void resetResultats(){
		if(this.critereRechercheStructureAdresse==null){
			this.critereRechercheStructureAdresse=initCritereRechercheStructureAdresse();//new CritereRechercheStructureAdresseDTO();
		}
		this.listeResultatsRechercheStructure=null;
		this.resultatRechercheStructure=null;
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

	/**
	 * @return String
	 */
	public String goToAccordAValider(){
		String ret="rechercheEtablissement";

		afficherBoutonAjoutEtab=false;
		resetResultats();
		this.ongletCourant=6;
		this.rechTypeAccord=0;
		this.rechRaisonSociale="%";
		this.listeResultatsRechercheStructure=getStructureDomainService()
				.getStructuresAvecAccordAValiderFromRaisonSociale(this.rechRaisonSociale, null, null);
		checkListeResultats();
		return ret;
	}

	/**
	 * @return String
	 */
	public void onEtablissementStageSelect(SelectEvent event) {

		String retour = this.goToAffichageRechercheEtablissement();

		try {
			if (retour != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(getSessionController().getBaseUrl()+"/stylesheets/stage/affichageRechercheEtablissement.xhtml");
			}
		} catch (IOException ioe){
			logger.error(ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/**
	 * @return String
	 */
	public void onEtablissementDepotSelect(SelectEvent event) {

		// On est coté depot, on recupere donc l'eventuel accord avec l'entreprise
		if (this.resultatRechercheStructure != null) {
			this.resultatRechercheStructure = getStructureDomainService()
					.getStructureAvecAccordFromId(this.resultatRechercheStructure.getIdStructure());
		}

		String retour = this.goToAffichageRechercheEtablissement();

		try {
			if (retour != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(getSessionController().getBaseUrl()+"/stylesheets/depot/affichageRechercheEtablissement.xhtml");
			}
		} catch (IOException ioe) {
			logger.error(ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @return the ongletCourant
	 */
	public int getOngletCourant() {
		return ongletCourant;
	}

	/**
	 * @param ongletCourant the ongletCourant to set
	 */
	public void setOngletCourant(int ongletCourant) {
		this.ongletCourant = ongletCourant;
	}

	/**
	 * @return the afficherBoutonAjoutEtab
	 */
	public boolean isAfficherBoutonAjoutEtab() {
		return afficherBoutonAjoutEtab;
	}

	/**
	 * @param afficherBoutonAjoutEtab the afficherBoutonAjoutEtab to set
	 */
	public void setAfficherBoutonAjoutEtab(boolean afficherBoutonAjoutEtab) {
		this.afficherBoutonAjoutEtab = afficherBoutonAjoutEtab;
	}

	/**
	 * @return the listeResultatsRechercheStructure
	 */
	public List<StructureDTO> getListeResultatsRechercheStructure() {
		return listeResultatsRechercheStructure;
	}

	/**
	 * @param listeResultatsRechercheStructure the listeResultatsRechercheStructure to set
	 */
	public void setListeResultatsRechercheStructure(
			List<StructureDTO> listeResultatsRechercheStructure) {
		this.listeResultatsRechercheStructure = listeResultatsRechercheStructure;
	}

	/**
	 * @return the resultatRechercheStructure
	 */
	public StructureDTO getResultatRechercheStructure() {
		return resultatRechercheStructure;
	}

	/**
	 * @param resultatRechercheStructure the resultatRechercheStructure to set
	 */
	public void setResultatRechercheStructure(
			StructureDTO resultatRechercheStructure) {
		this.resultatRechercheStructure = resultatRechercheStructure;
	}

	/**
	 * @return the rechercheStructurePaginator
	 */
	public RechercheStructurePaginator getRechercheStructurePaginator() {
		return rechercheStructurePaginator;
	}

	/**
	 * @param rechercheStructurePaginator the rechercheStructurePaginator to set
	 */
	public void setRechercheStructurePaginator(
			RechercheStructurePaginator rechercheStructurePaginator) {
		this.rechercheStructurePaginator = rechercheStructurePaginator;
	}

	/**
	 * @return the rechDepartement
	 */
	public String getRechDepartement() {
		return rechDepartement;
	}

	/**
	 * @param rechDepartement the rechDepartement to set
	 */
	public void setRechDepartement(String rechDepartement) {
		this.rechDepartement = rechDepartement;
	}

	/**
	 * @return the rechNumeroSiren
	 */
	public String getRechNumeroSiren() {
		return rechNumeroSiren;
	}

	/**
	 * @param rechNumeroSiren the rechNumeroSiren to set
	 */
	public void setRechNumeroSiren(String rechNumeroSiren) {
		this.rechNumeroSiren = rechNumeroSiren;
	}

	/**
	 * @return the rechNumeroSiret
	 */
	public String getRechNumeroSiret() {
		return rechNumeroSiret;
	}

	/**
	 * @param rechNumeroSiret the rechNumeroSiret to set
	 */
	public void setRechNumeroSiret(String rechNumeroSiret) {
		this.rechNumeroSiret = rechNumeroSiret;
	}

	/**
	 * @return the rechRaisonSociale
	 */
	public String getRechRaisonSociale() {
		return rechRaisonSociale;
	}

	/**
	 * @param rechRaisonSociale the rechRaisonSociale to set
	 */
	public void setRechRaisonSociale(String rechRaisonSociale) {
		this.rechRaisonSociale = rechRaisonSociale;
	}

	/**
	 * @return the rechTypeEtablissement
	 */
	public TypeStructureDTO getRechTypeEtablissement() {
		return rechTypeEtablissement;
	}

	/**
	 * @param rechTypeEtablissement the rechTypeEtablissement to set
	 */
	public void setRechTypeEtablissement(TypeStructureDTO rechTypeEtablissement) {
		this.rechTypeEtablissement = rechTypeEtablissement;
	}

	/**
	 * @return the rechNafN1
	 */
	public NafN1DTO getRechNafN1() {
		return rechNafN1;
	}

	/**
	 * @param rechNafN1 the rechNafN1 to set
	 */
	public void setRechNafN1(NafN1DTO rechNafN1) {
		this.rechNafN1 = rechNafN1;
	}

	/**
	 * @return the rechTelephone
	 */
	public String getRechTelephone() {
		return rechTelephone;
	}

	/**
	 * @param rechTelephone the rechTelephone to set
	 */
	public void setRechTelephone(String rechTelephone) {
		this.rechTelephone = rechTelephone;
	}

	/**
	 * @return the rechFax
	 */
	public String getRechFax() {
		return rechFax;
	}

	/**
	 * @param rechFax the rechFax to set
	 */
	public void setRechFax(String rechFax) {
		this.rechFax = rechFax;
	}

	/**
	 * @return the critereRechercheStructureAdresse
	 */
	public CritereRechercheStructureAdresseDTO getCritereRechercheStructureAdresse() {
		return critereRechercheStructureAdresse;
	}

	/**
	 * @param critereRechercheStructureAdresse the critereRechercheStructureAdresse to set
	 */
	public void setCritereRechercheStructureAdresse(
			CritereRechercheStructureAdresseDTO critereRechercheStructureAdresse) {
		this.critereRechercheStructureAdresse = critereRechercheStructureAdresse;
	}

	/**
	 * @return the rechNomService
	 */
	public String getRechNomService() {
		return rechNomService;
	}

	/**
	 * @param rechNomService the rechNomService to set
	 */
	public void setRechNomService(String rechNomService) {
		this.rechNomService = rechNomService;
	}

	/**
	 * @return the rechTypeAccord
	 */
	public int getRechTypeAccord() {
		return rechTypeAccord;
	}

	/**
	 * @param rechTypeAccord the rechTypeAccord to set
	 */
	public void setRechTypeAccord(int rechTypeAccord) {
		this.rechTypeAccord = rechTypeAccord;
	}

	/**
	 * @return the listTypeAccord
	 */
	public List<SelectItem> getListTypeAccord() {
		listTypeAccord=new ArrayList<SelectItem>();
		listTypeAccord.add(new SelectItem(0,getFacesInfoMessage("RECHERCHEETABLISSEMENT.ONGLET6.ACCORDAVALIDER").getSummary()));
		listTypeAccord.add(new SelectItem(1,getFacesInfoMessage("RECHERCHEETABLISSEMENT.ONGLET6.ACCORDVALIDE").getSummary()));
		listTypeAccord.add(new SelectItem(2,getFacesInfoMessage("RECHERCHEETABLISSEMENT.ONGLET6.SANSACCORD").getSummary()));
		return listTypeAccord;
	}

	/**
	 * @param listTypeAccord the listTypeAccord to set
	 */
	public void setListTypeAccord(List<SelectItem> listTypeAccord) {
		this.listTypeAccord = listTypeAccord;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the accordAValider
	 */
	public int getAccordAValider() {
		this.accordAValider=getStructureDomainService().countAccordAValider();
		return accordAValider;
	}

	/**
	 * @param accordAValider the accordAValider to set
	 */
	public void setAccordAValider(int accordAValider) {
		this.accordAValider = accordAValider;
	}

	/**
	 * @return the datePattern
	 */
	public String getDatePattern() {
		return datePattern;
	}

	/**
	 * @return the toVerificationStructures
	 */
	public boolean isToVerificationStructures() {
		return toVerificationStructures;
	}

	/**
	 * @param toVerificationStructures the toVerificationStructures to set
	 */
	public void setToVerificationStructures(boolean toVerificationStructures) {
		this.toVerificationStructures = toVerificationStructures;
	}

	public List<String> getRaisonsSociales(String raisonSociale){
		List<String> listStructures = (List<String>) getStructureDomainService().getRaisonsSociales(raisonSociale);
		if (listStructures != null && !listStructures.isEmpty()){
			return (List<String>) listStructures;
		} else {
			return new ArrayList<String>();
		}
	}

	public PaysDTO getRechPays() {
		return rechPays;
	}

	public void setRechPays(PaysDTO rechPays) {
		this.rechPays = rechPays;
	}

	public CritereRechercheStructureAdresseDTO initCritereRechercheStructureAdresse(){
		CritereRechercheStructureAdresseDTO c;

		if(getBeanUtils()!=null){
			c=new CritereRechercheStructureAdresseDTO();
			c.setRechPays(getBeanUtils().getFrance());
		}else{
			c=new CritereRechercheStructureAdresseDTO();
			PaysDTO p = new PaysDTO();
			p.setLibelle("FRANCE");
			p.setCog(DonneesStatic.FRANCE_COG);
			p.setCrpay(DonneesStatic.FRANCE_TERRITOIRE_CRPAY);
			c.setRechPays(p);
		}
		return c;
	}

	/**
	 * Mise à jour de la valeur du Pays en fonction du Pays sélectionné
	 * @param event
	 */
	public void valuePaysChanged(ValueChangeEvent event){
		this.setRechPays((PaysDTO) event.getNewValue());
		if (this.getRechPays()!=null && this.getRechPays().getId()==82)
			this.setFrance(true);
		else
			this.setFrance(false);
	}

	public boolean isFrance() {
		return france;
	}

	public void setFrance(boolean france) {
		this.france = france;
	}

	public boolean isToStructuresTemFalse() {
		return toStructuresTemFalse;
	}

	public void setToStructuresTemFalse(boolean toStructuresTemFalse) {
		this.toStructuresTemFalse = toStructuresTemFalse;
	}

	public boolean isRechercheEtabOk() {
		return rechercheEtabOk;
	}

	public void setRechercheEtabOk(boolean rechercheEtabOk) {
		this.rechercheEtabOk = rechercheEtabOk;
	}

}
