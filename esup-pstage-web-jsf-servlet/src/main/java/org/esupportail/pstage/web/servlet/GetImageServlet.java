package org.esupportail.pstage.web.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.OffreDomainService;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.FichierDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class GetImageServlet extends HttpServlet{
	/**
	 * Logger
	 */
	private final Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String uploadLogoEntreprisePath;
	/**
	 * 
	 */
	private String uploadLogoCentrePath;
	/**
	 * OffreDomainService
	 */
	private OffreDomainService offreDomainService;

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init(){
		uploadLogoCentrePath = getServletConfig().getInitParameter("uploadLogoCentrePath"); 
	}
	
	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		ServletContext sc = getServletContext(); 
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		offreDomainService = (OffreDomainService)ac.getBean("offreDomainService");

		String imageId = req.getParameter("imageId");      
		
		if (Utils.isNumber(imageId)){
			FichierDTO logo = offreDomainService.getFichierFromIdFichier(Utils.convertStringToInt(imageId));
			if(logo != null){
				String imageName = imageId+"_"+logo.getNomFichier();
				String imagePath = this.uploadLogoCentrePath+File.separator+imageName;
				File file = new File (imagePath);
				if (!file.exists()){
					logger.info("Trying to get image - id : "+imagePath+", but not found");
				} else {
					String mimeType = sc.getMimeType(imagePath);
					// Lecture et affichage de l'image
					try{
						FileInputStream fis = new FileInputStream(file);
						BufferedInputStream bis = new BufferedInputStream(fis);
						byte[] bytes = new byte[bis.available()];
						res.setContentType(mimeType);
						OutputStream os = res.getOutputStream();
						bis.read(bytes);
						os.write(bytes);
						bis.close();
					}catch(IOException e){
						System.out.println(e);
					}
				}
			}
		}
	}
	/**
	 * @param offreDomainService the offreDomainService to set
	 */
	public void setOffreDomainService(OffreDomainService offreDomainService) {
		this.offreDomainService = offreDomainService;
	}
	/**
	 * @return the offreDomainService
	 */
	public OffreDomainService getOffreDomainService() {
		return offreDomainService;
	}
	/**
	 * @param uploadLogoEntreprisePath the uploadLogoEntreprisePath to set
	 */
	public void setUploadLogoEntreprisePath(String uploadLogoEntreprisePath) {
		this.uploadLogoEntreprisePath = uploadLogoEntreprisePath;
	}
	/**
	 * @return the uploadLogoEntreprisePath
	 */
	public String getUploadLogoEntreprisePath() {
		return uploadLogoEntreprisePath;
	}
	/**
	 * @param uploadLogoCentrePath the uploadLogoCentrePath to set
	 */
	public void setUploadLogoCentrePath(String uploadLogoCentrePath) {
		this.uploadLogoCentrePath = uploadLogoCentrePath;
	}
	/**
	 * @return the uploadLogoCentrePath
	 */
	public String getUploadLogoCentrePath() {
		return uploadLogoCentrePath;
	}
}