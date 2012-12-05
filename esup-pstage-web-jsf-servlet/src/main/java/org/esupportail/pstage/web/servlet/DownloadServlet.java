package org.esupportail.pstage.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.esupportail.commons.exceptions.DownloadException;
import org.esupportail.commons.services.exceptionHandling.ExceptionUtils;
import org.esupportail.commons.utils.BeanUtils;
import org.esupportail.commons.utils.ContextUtils;
import org.esupportail.commons.utils.DownloadUtils;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * The servlet to download files.
 */
public class DownloadServlet extends HttpServlet {

	/**
	 * The attribute to retrieve the data from.
	 */
	public static final String ID_ATTRIBUTE = "downloadId"; 

	/**
	 * The attribute to retrieve the data from.
	 */
	public static final String DATA_ATTRIBUTE = "downloadData-"; 

	/**
	 * The attribute to retrieve the content-type from.
	 */
	public static final String CONTENT_TYPE_ATTRIBUTE = "downloadContentType-"; 

	/**
	 * The attribute to retrieve the filename from.
	 */
	public static final String FILENAME_ATTRIBUTE = "downloadFilename-"; 

	/**
	 * The id for serialization.
	 */
	private static final long serialVersionUID = -7231367075834134378L;
	
	/**
	 * Constructor.
	 */
	public DownloadServlet() {
		super();
	}
	
	/**
	 * @throws ServletException 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(
			final ServletRequest servletRequest, 
			final ServletResponse servletResponse) 
	throws ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String id = request.getParameter(ID_ATTRIBUTE);
		if (id == null) {
			throw new DownloadException(
					"attribute " + ID_ATTRIBUTE + " not found, can not download");
		}
    	ServletRequestAttributes previousRequestAttributes = null;
        try {
        	previousRequestAttributes = ContextUtils.bindRequestAndContext(
        			request, getServletContext());
			BeanUtils.initBeanFactory(getServletContext());
			String contentType = (String) DownloadUtils.getDownloadAttribute(
					CONTENT_TYPE_ATTRIBUTE + id);
			if (contentType != null) {
				response.setContentType(contentType);
			}
			String filename = (String) DownloadUtils.getDownloadAttribute(
					FILENAME_ATTRIBUTE + id);
			if (filename != null) {
				response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"");
			}
			byte [] data = (byte []) DownloadUtils.getDownloadAttribute(
					DATA_ATTRIBUTE + id);
			if (data == null) {
				// cas des url avec download rejoue http://serveur/context/download?downloadId=
				String returnUrl = request.getRequestURL().toString();
				returnUrl=returnUrl.replaceAll("download", "stylesheets/_exception/downloadIdException.faces");
				response.sendRedirect(returnUrl);
//				throw new DownloadException("data is null, can not download");
			}else {
				response.setContentLength(data.length);
				ServletOutputStream out = response.getOutputStream();
				out.write(data);
			}
			
		} catch (Throwable t) {
			Exception de = new DownloadException(t);
			ExceptionUtils.catchException(de);
			ContextUtils.unbindRequest(previousRequestAttributes);
			throw new ServletException(de);
		}
	}

}
