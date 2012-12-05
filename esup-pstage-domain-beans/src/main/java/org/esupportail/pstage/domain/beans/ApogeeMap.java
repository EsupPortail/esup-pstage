package org.esupportail.pstage.domain.beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.esupportail.pstage.domain.beans.ElementPedagogique;
import org.esupportail.pstage.domain.beans.EtapeInscription;




/**
 * @author danielle Martineau 
 *
 */
public class ApogeeMap {
	
	/**
	 * liste des Etapes etudiant
	 */
	private LinkedHashMap<String,String> StudentSteps;
	/**
	 * liste des etapes et version etapes etudiant
	 */
	private LinkedHashMap<String, String> StudentsEtapesVets;
	
	/**
	 * liste des etapes et version etapes etudiant Pedagogique
	 */
	private LinkedHashMap<String, String> StudentsEtapesVetsPedago;
	
	/**
	 * map des elements pedagogiques.
	 */
	private LinkedHashMap <String,ElementPedagogique> elementPedagogiques;	
	
	/**
	 * liste des elements pedagogiques.
	 */
	public List<ElementPedagogique> listeELPs;
	
	
	/**
	 * liste des Etapes inscriptions 
	 */
	public List<EtapeInscription> listeEtapeInscriptions;
	
	
	/**
	 * 
	 */
	public ApogeeMap() {
		super();
		StudentSteps = new LinkedHashMap<String, String>();
		StudentsEtapesVets = new LinkedHashMap<String, String>();
		StudentsEtapesVetsPedago = new LinkedHashMap<String, String>();
		elementPedagogiques = new LinkedHashMap<String, ElementPedagogique>();
		listeELPs = new ArrayList<ElementPedagogique>();
		listeEtapeInscriptions = new ArrayList<EtapeInscription>();
	}
	/**
	 * @return the studentSteps
	 */
	public LinkedHashMap<String, String> getStudentSteps() {
		return StudentSteps;
	}
	/**
	 * @param studentSteps the studentSteps to set
	 */
	public void setStudentSteps(LinkedHashMap<String, String> studentSteps) {
		StudentSteps = studentSteps;
	}
	/**
	 * @return the studentsEtapesVets
	 */
	public LinkedHashMap<String, String> getStudentsEtapesVets() {
		return StudentsEtapesVets;
	}
	/**
	 * @param studentsEtapesVets the studentsEtapesVets to set
	 */
	public void setStudentsEtapesVets(
			LinkedHashMap<String, String> studentsEtapesVets) {
		StudentsEtapesVets = studentsEtapesVets;
	}
	/**
	 * @return the studentsEtapesVetsPedago
	 */
	public LinkedHashMap<String, String> getStudentsEtapesVetsPedago() {
		return StudentsEtapesVetsPedago;
	}
	/**
	 * @param studentsEtapesVetsPedago the studentsEtapesVetsPedago to set
	 */
	public void setStudentsEtapesVetsPedago(
			LinkedHashMap<String, String> studentsEtapesVetsPedago) {
		StudentsEtapesVetsPedago = studentsEtapesVetsPedago;
	}
	/**
	 * @return the elementPedagogiques
	 */
	public LinkedHashMap<String, ElementPedagogique> getElementPedagogiques() {
		return elementPedagogiques;
	}
	/**
	 * @param elementPedagogiques the elementPedagogiques to set
	 */
	public void setElementPedagogiques(
			LinkedHashMap<String, ElementPedagogique> elementPedagogiques) {
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
	
	
}
