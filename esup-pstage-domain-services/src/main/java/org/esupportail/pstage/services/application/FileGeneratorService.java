package org.esupportail.pstage.services.application;

import java.util.List;

import org.esupportail.pstagedata.remote.ConventionDTO;

/**
 * @author dhouillo
 *
 */
public interface FileGeneratorService {
	
	/**
	 * generate a content to download corresponding to the content of the SpreadsheetObject.
	 * @param typeExport
	 * @param filename
	 * @param sso
	 */
	void generate(final SpreadsheetObject sso, final String typeExport, final String filename);

	
	/**
	 * @param conventions
	 * @param typeExport
	 * @param filename
	 * @param colonnesChoisies 
	 */
	void conventionFile(final List<ConventionDTO> conventions, 
			 final String typeExport, final String filename, final List<String> colonnesChoisies);
	

}
