package org.esupportail.pstage.services.stats;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.esupportail.pstage.exceptions.PstageXLSException;

public interface JxlsWriter {
	public void writeXls (final HttpServletRequest req) throws  PstageXLSException;
	public File findDestFile() throws PstageXLSException;
}
