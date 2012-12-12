package org.esupportail.pstage.web.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.PstageXLSException;
import org.esupportail.pstage.services.stats.JxlsWriter;

public class EditJxlsServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;

	private JxlsWriter jxlsStatistiquesWriter;
	private static Logger logger = Logger.getLogger(EditJxlsServlet.class);

	/** 
	 * 
	 */
	public EditJxlsServlet()
	{
		super();
	}

	/**
	 *  
	 * 
	 * we implement doGet so that this servlet will process all 
	 * HTTP GET requests
	 * 
	 * @param req HTTP request object 
	 * request positionnee dans ConventionController en APPLICATION-SCOPE
	 * @param resp HTTP response object
	 * 
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {

		String edition =(String)req.getSession().getAttribute("nameEdition");	


		StringBuffer sbFilename = new StringBuffer();

		if (edition.equalsIgnoreCase("statistiques")){

			try {
				jxlsStatistiquesWriter.writeXls(req);
				customDoGet(req, resp,jxlsStatistiquesWriter);
			} catch (PstageXLSException e) {
				logger.error(e.getMessage());
			}



			//Recup des attributs stockes dans la requete en APPLICATION_SCOPE
			sbFilename.append("statistiques");
			String statType=req.getParameter("statType");
			sbFilename.append("_"+statType);

			String critere1=req.getParameter("critere1");
			String critere2=req.getParameter("critere2");


			if (critere1!=null && !critere1.equals("")){

				sbFilename.append("_"+critere1);
			}
			if (critere2!=null && !critere2.equals("")){
				sbFilename.append("_"+critere2);
			}
		}
	}






	private void customDoGet(HttpServletRequest request, HttpServletResponse response, JxlsWriter jxlsWriter)throws javax.servlet.ServletException, IOException {		

		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		try{
			stream = response.getOutputStream();
			// File pdf = new File(pdfDir + "/" + fileName);

			File xlsfile = null;
			try {
				xlsfile = jxlsWriter.findDestFile();
			} catch (PstageXLSException e) {
				logger.error(" fichier non trouve " +e.getMessage());

			} catch (Exception npe) {
				logger.error(" npe, innatendue " + npe.getMessage());
			}


			//set response headers

			////////////////////////////////////////////////////////
			// Note: 
			//
			// It is important to set the HTTP response headers 
			// before writing data to the servlet's OutputStream 
			//
			// Read the HTTP 1.1 specification for full details
			// about the Cache-Control header
			//////////////////////////////////////////////////////
			response.setHeader("Cache-Control", "max-age=30");
			response.setContentType("application/vnd.ms-excel");

			// The Content-disposition header is explained
			// in RFC 2183   http://www.ietf.org/rfc/rfc2183.txt
			//
			// The Content-disposition value will be in one of 
			// two forms:
			//   1)  inline; filename=foobar.pdf
			//   2)  attachment; filename=foobar.pdf
			//
			// In this servlet, we use "attachment" to display the file outside the 
			// browser's main window

			//	response.addHeader("Content-Disposition","attachment; filename="+xlsfile.getName());

			StringBuilder headerToAdd = new StringBuilder();
			headerToAdd.append("attachment");
			headerToAdd.append("; filename=");
			response.setHeader("Content-disposition",headerToAdd.toString());

			response.setContentLength( (int) xlsfile.length());
			FileInputStream input = new FileInputStream(xlsfile);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			//read from the file; write to the ServletOutputStream
			while((readBytes = buf.read( )) != -1)
				stream.write(readBytes);
		} catch (IOException ioe){
			logger.error(ioe.getMessage());
			throw new ServletException(ioe.getMessage( ));
		} finally {
			//close the input/output streams
			if (stream != null)
				stream.close( );
			if (buf != null)
				buf.close( );
		}

	}

}
