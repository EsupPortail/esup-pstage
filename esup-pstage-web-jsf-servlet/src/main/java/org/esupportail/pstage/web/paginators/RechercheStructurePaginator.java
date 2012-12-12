package org.esupportail.pstage.web.paginators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.esupportail.commons.services.paginator.ListPaginator;
import org.esupportail.pstagedata.remote.StructureDTO;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 */
public class RechercheStructurePaginator extends ListPaginator<StructureDTO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Liste
	 */
	private List<StructureDTO> liste=null;
	
	/**
	 * Constructeur
	 */
	public RechercheStructurePaginator(){
		super();
	}
	
	/**
	 * Constructeur
	 * @param l
	 */
	public RechercheStructurePaginator(final List<StructureDTO> l){
		super();
	}

	/**
	 * @see org.esupportail.commons.web.beans.ListPaginator#getData()
	 */
	@Override
	protected ArrayList<StructureDTO> getData() {
		if(this.liste!=null && !this.liste.isEmpty()){
			Collections.sort(this.liste, new Comparator<StructureDTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(StructureDTO s1, StructureDTO s2) {
					return s1.getRaisonSociale().compareTo(s2.getRaisonSociale());
				}
			});
		}
		return (ArrayList<StructureDTO>) this.liste;
	}

	/**
	 * @return the liste
	 */
	public List<StructureDTO> getListe() {
		return liste;
	}

	/**
	 * @param liste the liste to set
	 */
	public void setListe(List<StructureDTO> liste) {
		this.liste = liste;
	}
}
