package org.esupportail.pstage.web.paginators;

import java.util.ArrayList;
import java.util.List;

import org.esupportail.commons.web.beans.ListPaginator;
import org.esupportail.pstagedata.domain.dto.ConventionDTO;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 */
public class RechercheConventionPaginator extends ListPaginator<ConventionDTO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Liste
	 */
	private List<ConventionDTO> liste=null;
	
	/**
	 * Constructeur
	 */
	public RechercheConventionPaginator(){
		super();
	}
	
	/**
	 * Constructeur
	 * @param l
	 */
	public RechercheConventionPaginator(final List<ConventionDTO> l){
		super();
	}

	/**
	 * @see org.esupportail.commons.web.beans.ListPaginator#getData()
	 */
	@Override
	protected ArrayList<ConventionDTO> getData() {
		if(this.liste!=null && !this.liste.isEmpty()){
			return (ArrayList<ConventionDTO>) this.liste;
		}
		return null;
	}

	/**
	 * @return the liste
	 */
	public List<ConventionDTO> getListe() {
		return liste;
	}

	/**
	 * @param liste the liste to set
	 */
	public void setListe(List<ConventionDTO> liste) {
		this.liste = liste;
	}
}
