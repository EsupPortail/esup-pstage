/**
 * 
 */
package org.esupportail.pstage.web.comparator;

import java.io.Serializable;
import java.util.Comparator;

import javax.faces.model.SelectItem;

/**
 * @author cleprous
 *
 */
public class ComparatorSelectItem implements Comparator<SelectItem>, Serializable {

	/**
	 * The serialization id. 
	 */
	private static final long serialVersionUID = 1545052575014067760L;

	/**
	 * Constructor.
	 */
	public ComparatorSelectItem() {
		super();
	}

	/**
	 * @param arg0 SelectItem
	 * @param arg1 SelectItem
	 * @return int
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(final SelectItem arg0,
							final SelectItem arg1) {
		String nom1 =  arg0.getLabel().toUpperCase();
	    String nom2 = 	arg1.getLabel().toUpperCase();
	    
	    if (!(nom1.equals(nom2))) {
	        return nom1.compareTo(nom2);
	    }
	    
		return 0;
	}

}
