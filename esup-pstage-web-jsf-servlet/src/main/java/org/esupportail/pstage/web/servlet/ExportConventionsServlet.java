package org.esupportail.pstage.web.servlet;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class ExportConventionsServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private final transient Logger logger = Logger.getLogger(this.getClass());

	/** 
	 * 
	 */
	public ExportConventionsServlet(){
		super();
	}

	public String doGet(ByteArrayOutputStream baosXLS, String XlsFileName) throws javax.servlet.ServletException, java.io.IOException {

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse resp = (HttpServletResponse) externalContext.getResponse();

		try {

			resp.setHeader("Cache-Control", "max-age=30");

			resp.setContentType("application/vnd.ms-excel");

//			resp.setHeader("Content-disposition","attachment; filename=extraction_pstage.xls");
			resp.setHeader("Content-disposition","attachment; filename="+XlsFileName);

			resp.setContentLength(baosXLS.size());

			// envoi du flux de donnees sur une sortie reliee a la "response" de la servlet
			ServletOutputStream out;
			out = resp.getOutputStream();		
			baosXLS.writeTo(out);			
			out.flush();

			//fermeture des flux de donnees et de sortie		
			out.close();
			baosXLS.close();

		} catch (Exception e){
			logger.info(e);
			resp.setContentType("text/html");
			try {
				PrintWriter writer = resp.getWriter();
				writer.println(this.getClass().getName()
						+ " caught an exception: "
						+ e.getClass().getName()
						+ "<br>");
			} catch (IOException ioe){
				logger.error(ioe);
			}
		} finally {
			if (baosXLS != null){
				baosXLS.reset();
			}
		}

		FacesContext.getCurrentInstance().responseComplete();

		return null;
	}

}