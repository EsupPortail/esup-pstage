package org.esupportail.pstage.web.servlet;


import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;


/** 
* 
*  a servlet that will generate a PDF document
*  and send the document to the client via the 
*  ServletOutputStream
* 
*  @author Sean C. Sullivan
* 
*/
public class EditXlsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private EditStatisticsXls editStatisticsXls;
	Logger log = Logger.getLogger(EditXlsServlet.class);
	
	 
	/** 
	* 
	*/
	public EditXlsServlet()
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
	public String doGet(String statType, String critere1, String critere2, Map<String, List<StatisticItemDTO>> map)
		throws javax.servlet.ServletException, java.io.IOException 
	{
		
		ByteArrayOutputStream baosXLS = null;
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse resp = (HttpServletResponse) externalContext.getResponse();
        
		try
		{
			StringBuffer sbFilename = new StringBuffer();
			/**
			**  Methodes de creation des documents XLS selon l'edition demandee
			**/
			
							
							//Recup des attributs stockes dans la requete en APPLICATION_SCOPE
							editStatisticsXls=	new EditStatisticsXls();
							baosXLS = editStatisticsXls.writeStatisticsXls(statType, critere1, critere2, map);				
							sbFilename.append("statistiques");
							sbFilename.append("_"+statType);
							
							
							if (critere1!=null && !critere1.equals("")){
								
								sbFilename.append("_"+critere1);
							}
							if (critere2!=null && !critere2.equals("")){
								sbFilename.append("_"+critere2);
							}
							
							sbFilename.append(".xls");

						////////////////////////////////////////////////////////
						// Note: 
						//
						// It is important to set the HTTP response headers 
						// before writing data to the servlet's OutputStream 
						//
						// Read the HTTP 1.1 specification for full details
						// about the Cache-Control header
						//////////////////////////////////////////////////////
							
							
							resp.setHeader("Cache-Control", "max-age=30");
						
							resp.setContentType("application/vnd.ms-excel");
						

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

							StringBuffer sbContentDispValue = new StringBuffer();
							sbContentDispValue.append("attachment");
							sbContentDispValue.append("; filename=");
							sbContentDispValue.append(sbFilename);
										
							resp.setHeader("Content-disposition",	sbContentDispValue.toString());

							resp.setContentLength(baosXLS.size());

							// envoi du flux de donnees sur une sortie reliee a la "response" de la servlet
							ServletOutputStream out;
							out = resp.getOutputStream();		
							baosXLS.writeTo(out);			
							out.flush();
						
							//fermeture des flux de donnees et de sortie		
							out.close();
							baosXLS.close();
						
							if (log.isDebugEnabled()){
								log.debug("EditXlsServlet :: doGet = "+sbFilename.toString());
					    	
							}
												
						
		}//fin du "try"
		
		catch (Exception dex)
		{
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println(
					this.getClass().getName() 
					+ " caught an exception: " 
					+ dex.getClass().getName()
					+ "<br>");
			writer.println("<pre>");
			dex.printStackTrace(writer);
			writer.println("</pre>");
		}

		//

		
		
		finally
		{
			if (baosXLS != null)
			{
				baosXLS.reset();
			}
		}

		FacesContext.getCurrentInstance().responseComplete();
		 
        return null;
	
}

	
}
		
	
	
	
	
	
	 



