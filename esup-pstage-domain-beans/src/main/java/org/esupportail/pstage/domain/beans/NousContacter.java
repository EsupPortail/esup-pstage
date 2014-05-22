package org.esupportail.pstage.domain.beans;

import java.io.Serializable;

import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;


/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class NousContacter implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * sujet
	 */
	private String sujet="";
	/**
	 * message
	 */
	private String message="";
	/**
	 * contact
	 */
	private ContactDTO contact=new ContactDTO();
	/**
	 * codePostal
	 */
	private String codePostal="";
	/**
	 * pays
	 */
	private PaysDTO pays=new PaysDTO();
	
	/**
	 * Constructeur
	 */
	public NousContacter(){
		this.sujet="";
		this.message="";
		this.contact=new ContactDTO();
		this.pays=new PaysDTO();
		this.codePostal="";
	}
	
	/**
	 * Retour vrai si une des donnÃ¯Â¿Â½e est null
	 * @return boolean
	 */
	public boolean isNull(){
		return this.contact==null||this.contact.getMail()==null||
		this.contact.getPrenom()==null||this.contact.getNom()==null||this.sujet==null||
		this.message==null|this.codePostal==null||this.pays==null;
	}
	
	/**
	 * @return the sujet
	 */
	public String getSujet() {
		return sujet;
	}
	/**
	 * @param sujet the sujet to set
	 */
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the contact
	 */
	public ContactDTO getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the pays
	 */
	public PaysDTO getPays() {
		return pays;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(PaysDTO pays) {
		this.pays = pays;
	}
}
