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
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class GetFileServlet extends HttpServlet{
	/**
	 * Logger
	 */
	private final transient Logger logger = Logger.getLogger(this.getClass());
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init(){
		// Simple init a override
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		ServletContext sc = getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		OffreDomainService offreDomainService = null;
		try {
			offreDomainService = (OffreDomainService) ac.getBean("offreDomainService");
		} catch(BeansException be){
			logger.error(be);
			return;
		}

		String fileId = req.getParameter("fileId");
		if(Utils.isNumber(fileId)){
			FichierDTO of = offreDomainService.getFichierFromIdFichier(Utils.convertStringToInt(fileId));
			if(of!=null){
				String fileName=fileId+"_"+of.getNomFichier();
				String filePath = getServletConfig().getInitParameter("uploadFilesPath")+File.separator+fileName;
				String realName= of.getNomReel();
				if(!StringUtils.hasText(realName)){
					realName=fileName;
				}
				File file = new File(filePath);

				if(!file.exists()){
					if(logger.isDebugEnabled()){
						logger.debug("Trying to get file - id : "+fileId+", but not found");
					}
				}else{
					String mimeType = sc.getMimeType(filePath);

					try(FileInputStream fis = new FileInputStream(file)){
						BufferedInputStream bis = new BufferedInputStream(fis);

						byte[] bytes = new byte[bis.available()];
						res.setContentType(mimeType);
						res.setHeader("Pragma", "public");
						res.setHeader("Expires", "0");
						res.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
						res.setHeader("Cache-Control", "private");
						res.setHeader("Content-Disposition", "attachment;filename=\"" + realName + "\"");
						res.setHeader("Content-type", "application/octet-stream");
						OutputStream os = res.getOutputStream();

						while (bis.read(bytes) > 0) {
							os.write(bytes);
						}

						bis.close();
					}catch(IOException e){
						logger.error(e);
					}
				}
			}
		}
	}
}