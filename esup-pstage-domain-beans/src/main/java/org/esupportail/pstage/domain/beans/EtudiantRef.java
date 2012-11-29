package org.esupportail.pstage.domain.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.esupportail.pstagedata.remote.AssuranceDTO;
import org.esupportail.pstagedata.remote.CaisseRegimeDTO;
import org.esupportail.pstagedata.remote.EtudiantDTO;



/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */
public class EtudiantRef extends EtudiantDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/* ***************************************************************
	 * PropriÃ¯Â¿Â½tÃ¯Â¿Â½s
	 ****************************************************************/
	/**
	 * theUfr
	 */
	private String theUfr = "";
	/**
	 * thecodeUFR
	 */
	private String thecodeUFR = "";
	/**
	 * theEtape
	 */
	private String theEtape = "";
	/**
	 * theCodeEtape
	 */
	private String theCodeEtape = "";
	
	/**
	 * Map element pedagogique
	 */
	private Map <String,ElementPedagogique> elementPedagogiques =new HashMap<String,ElementPedagogique>();
	
	/**
	 * liste des Elps.
	 */
	public List<ElementPedagogique> listeELPs = new ArrayList<ElementPedagogique>();
	
	/**
	 * le code Elp 
	 */
	private String theCodeElp="";
	/**
	 * le libelle de Elp
	 */
	private String theLibElp="";
	/**
	 * le nombre de Credit ECTS
	 */
	private BigDecimal theCreditECTS = new BigDecimal(0);
	
	/**
	 * libelle CPAM
	 */
	private String libelleCPAM;
	
	/**
	 * steps (etape etude)
	 */
	private Map<String,String> steps = new HashMap<String,String>();
	/**
	 * studys (ufr)
	 */
	private Map <String,String> studys=new HashMap<String,String>();
	
	/**
	 * adresse permanente etudiant 
	 */

	private String mainAddress = "";
	
	/**
	 * code postal etudiant
	 */

	private String postalCode = "";

	/**
	 * commune etudiant 
	 */
	private String town = "";
	
	/**
	 * pays etudiant 
	 */
	private String country = "";
	
	
	/**
	 * telephone portable etudiant
	 */

	private String portablePhone = "";
	
	/**
	 * courrier personnel etudiant 
	 */

	private String mailPerso = "";
	
	/**
	 * liste etape - version etape inscriptions
	 */
	public List<EtapeInscription> listeEtapeInscriptions;
	
	/**
	 * Affiliation Ã¯Â¿Â½ la sÃ¯Â¿Â½curitÃ¯Â¿Â½ sociale
	 */
	private AssuranceDTO  theAssurance;
	
	/**
	 * Caisse d'assurance maladie
	 */
	private CaisseRegimeDTO theCaisseRegime;
	
	/**
	 * administrationApogee
	 */
	private AdministrationApogee administrationApogee;		
	
	/* **
	 * Objets
	 */
	


	
	/**
	 * Constructeur
	 */
	public EtudiantRef(){
		super();
	}
	
	
	/* ***************************************************************
	 * Methodes
	 ****************************************************************/	

	
	/**
	 * @return List<String>
	 */
	public List<String> getStepsKey() {
		List<String> listeStepsKey = new ArrayList<String>();
		if(this.steps!=null && (!this.steps.isEmpty())){
			String clef = null;
			Iterator i = this.steps.keySet().iterator();
			while (i.hasNext())
			{
				clef = (String)i.next();
				if (clef != null) {
					listeStepsKey.add(clef);
					
				}
				
			}
		}

		return listeStepsKey;
	}
	
	/**
	 * @return List<String>
	 */
	public List<String> getStudysKey() {
		List<String> listeStudysKey = new ArrayList<String>();
		if(this.studys!=null && (!this.studys.isEmpty())){
			String clef = null;
			Iterator i = this.studys.keySet().iterator();
			while (i.hasNext())
			{
				clef = (String)i.next();
				if (clef != null) {
					listeStudysKey.add(clef);
					
				}
			}
		}
		return listeStudysKey;
	}
	
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/	

	/**
	 * @return the elementPedagogiques
	 */
	public Map<String, ElementPedagogique> getElementPedagogiques() {
		return elementPedagogiques;
	}


	/**
	 * @param elementPedagogiques the elementPedagogiques to set
	 */
	public void setElementPedagogiques(
			Map<String, ElementPedagogique> elementPedagogiques) {
		this.elementPedagogiques = elementPedagogiques;
	}


	/**
	 * @return the listeELPs
	 */
	public List<ElementPedagogique> getListeELPs() {
		return listeELPs;
	}


	/**
	 * @param listeELPs the listeELPs to set
	 */
	public void setListeELPs(List<ElementPedagogique> listeELPs) {
		this.listeELPs = listeELPs;
	}


	/**
	 * @return the theCodeElp
	 */
	public String getTheCodeElp() {
		return theCodeElp;
	}


	/**
	 * @param theCodeElp the theCodeElp to set
	 */
	public void setTheCodeElp(String theCodeElp) {
		this.theCodeElp = theCodeElp;
	}


	/**
	 * @return the theLibElp
	 */
	public String getTheLibElp() {
		return theLibElp;
	}


	/**
	 * @param theLibElp the theLibElp to set
	 */
	public void setTheLibElp(String theLibElp) {
		this.theLibElp = theLibElp;
	}


	/**
	 * @return the theCreditECTS
	 */
	public BigDecimal getTheCreditECTS() {
		return theCreditECTS;
	}


	/**
	 * @param theCreditECTS the theCreditECTS to set
	 */
	public void setTheCreditECTS(BigDecimal theCreditECTS) {
		this.theCreditECTS = theCreditECTS;
	}


	/**
	 * @return the libelleCPAM
	 */
	public String getLibelleCPAM() {
		return libelleCPAM;
	}


	/**
	 * @param libelleCPAM the libelleCPAM to set
	 */
	public void setLibelleCPAM(String libelleCPAM) {
		this.libelleCPAM = libelleCPAM;
	}


	/**
	 * @return the steps
	 */
	public Map<String, String> getSteps() {
		return steps;
	}


	/**
	 * @param steps the steps to set
	 */
	public void setSteps(Map<String, String> steps) {
		this.steps = steps;
	}


	/**
	 * @return the studys
	 */
	public Map<String, String> getStudys() {
		return studys;
	}


	/**
	 * @param studys the studys to set
	 */
	public void setStudys(Map<String, String> studys) {
		this.studys = studys;
	}


	/**
	 * @return the mainAddress
	 */
	public String getMainAddress() {
		return mainAddress;
	}


	/**
	 * @param mainAddress the mainAddress to set
	 */
	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}


	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}


	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}


	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @return the portablePhone
	 */
	public String getPortablePhone() {
		return portablePhone;
	}


	/**
	 * @param portablePhone the portablePhone to set
	 */
	public void setPortablePhone(String portablePhone) {
		this.portablePhone = portablePhone;
	}


	/**
	 * @return the mailPerso
	 */
	public String getMailPerso() {
		return mailPerso;
	}


	/**
	 * @param mailPerso the mailPerso to set
	 */
	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}


	/**
	 * @return the theUfr
	 */
	public String getTheUfr() {
		return theUfr;
	}


	/**
	 * @param theUfr the theUfr to set
	 */
	public void setTheUfr(String theUfr) {
		this.theUfr = theUfr;
	}


	/**
	 * @return the thecodeUFR
	 */
	public String getThecodeUFR() {
		return thecodeUFR;
	}


	/**
	 * @param thecodeUFR the thecodeUFR to set
	 */
	public void setThecodeUFR(String thecodeUFR) {
		this.thecodeUFR = thecodeUFR;
	}


	/**
	 * @return the theEtape
	 */
	public String getTheEtape() {
		return theEtape;
	}


	/**
	 * @param theEtape the theEtape to set
	 */
	public void setTheEtape(String theEtape) {
		this.theEtape = theEtape;
	}


	/**
	 * @return the theCodeEtape
	 */
	public String getTheCodeEtape() {
		return theCodeEtape;
	}


	/**
	 * @param theCodeEtape the theCodeEtape to set
	 */
	public void setTheCodeEtape(String theCodeEtape) {
		this.theCodeEtape = theCodeEtape;
	}


	/**
	 * @return the listeEtapeInscriptions
	 */
	public List<EtapeInscription> getListeEtapeInscriptions() {
		return listeEtapeInscriptions;
	}


	/**
	 * @param listeEtapeInscriptions the listeEtapeInscriptions to set
	 */
	public void setListeEtapeInscriptions(
			List<EtapeInscription> listeEtapeInscriptions) {
		this.listeEtapeInscriptions = listeEtapeInscriptions;
	}


	/**
	 * @return the theAssurance
	 */
	public AssuranceDTO getTheAssurance() {
		return theAssurance;
	}


	/**
	 * @param theAssurance the theAssurance to set
	 */
	public void setTheAssurance(AssuranceDTO theAssurance) {
		this.theAssurance = theAssurance;
	}


	/**
	 * @return the theCaisseRegime
	 */
	public CaisseRegimeDTO getTheCaisseRegime() {
		return theCaisseRegime;
	}


	/**
	 * @param theCaisseRegime the theCaisseRegime to set
	 */
	public void setTheCaisseRegime(CaisseRegimeDTO theCaisseRegime) {
		this.theCaisseRegime = theCaisseRegime;
	}


	/**
	 * @return the administrationApogee
	 */
	public AdministrationApogee getAdministrationApogee() {
		return administrationApogee;
	}


	/**
	 * @param administrationApogee the administrationApogee to set
	 */
	public void setAdministrationApogee(AdministrationApogee administrationApogee) {
		this.administrationApogee = administrationApogee;
	}


	
	

}
