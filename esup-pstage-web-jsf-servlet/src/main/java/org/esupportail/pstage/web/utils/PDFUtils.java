/**
 * 
 */

package org.esupportail.pstage.web.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.fop.apps.Driver;
import org.apache.fop.messaging.MessageHandler;
import org.esupportail.commons.exceptions.DownloadException;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.DownloadUtils;
import org.esupportail.commons.web.servlet.DownloadServlet;
import org.esupportail.pstage.utils.DonneesStatic;

/**
 * @author cleprous
 *
 */
public final class PDFUtils {


	/*
	 ******************* PROPERTIES ******************* */
	
	/**
	 * 
	 */
	private static final Logger LOGGER = new LoggerImpl(PDFUtils.class);	
	
	/*
	 ******************* INIT ************************* */


	/**
	 * Private constructor.
	 */
	private PDFUtils() {
		throw new UnsupportedOperationException();
	}


	/*
	 ******************* METHODS ********************** */
	
	/**
	 * Export PDF after delete xml file.
	 * @param fileNameXml 
	 * @param facesContext
	 * @param directory
	 * @param fileNamePdf
	 * @param fileNameXsl 
	 */
	public static void exportPDF(final String fileNameXml,
			final FacesContext facesContext, 
			final String directory, 
			final String fileNamePdf, 
			final String fileNameXsl) {
		try {
			File f1 = new File(directory + fileNameXml);
			byte[] arrayPDF = transformXMLPDF(
					f1,
					new File(directory + fileNameXsl),
					directory);
			
			// TODO pour test ne pas supprimer le fichier, a decommenter pour prod
			f1.delete();
			
			setDownLoadAndSend(arrayPDF, facesContext,
					DonneesStatic.HTTP_TYPE_PDF, fileNamePdf);
			
			
			
		} catch (TransformerException e) {
			LOGGER.error("probleme de transformation pdf = " + fileNamePdf + "exception : " + e);
		}
	}
	
	
	
	/**
	 * @param fileNameXml
	 * @param zipStream
	 * @param directory
	 * @param fileNamePdf
	 * @param fileNameXsl
	 * @return ZipOutputStream
	 */
	public static ZipOutputStream preparePDFinZip(final String fileNameXml,
			final ZipOutputStream zipStream, 
			final String directory, 
			final String fileNamePdf, 
			final String fileNameXsl) {
		File f1 = new File(directory + fileNameXml);
		byte[] arrayPDF;
		try {
			arrayPDF = PDFUtils.transformXMLPDF(
					f1,
					new File(directory + fileNameXsl),
					directory);


			ZipEntry zipEntry = new ZipEntry(fileNamePdf);
			zipStream.putNextEntry(zipEntry);

			zipStream.write(arrayPDF);
			zipStream.closeEntry();
			f1.delete();
		} catch (TransformerException e) {
			LOGGER.error("probleme de preparation du zip contenant le pdf = "
								+ fileNamePdf + "exception : " + e);
		} catch (IOException e) {
			LOGGER.error("probleme de preparation du zip contenant le pdf = " 
								+ fileNamePdf + "exception : " + e);
		}     				    
		
		return zipStream;
		
	}
	
	/**
	 * @param data
	 * @param facesContext
	 * @param contentType
	 * @param fileName
	 */
	public static void setDownLoadAndSend(final byte[] data,
			final FacesContext facesContext, 
			final String contentType, 
			final String fileName) {
		
		try {
			Long id = DownloadUtils.setDownload(data, fileName, contentType);
			String url = getDownloadUrl(id);
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.redirect(url);
			facesContext.responseComplete();
		} catch (IOException e) {
			LOGGER.error("probleme lors de l envoie d un ficher = " + fileName + "exception : " + e);
		}
	}
 
	/**
	 * Transform to pdf the file xml and the file xsl. 
	 * @param xml
	 * @param xsl
	 * @return byte[]
	 * @throws TransformerException
	 */
	private static byte[] transformXMLPDF(final File xml,
			final File xsl,
			final String directoryXsl) throws TransformerException {
		ByteArrayOutputStream content = new ByteArrayOutputStream();
		
		//creation du resultat (pdf)
		Driver driver = new Driver();
		
		// Setup logger
		org.apache.avalon.framework.logger.Logger logger = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);
		driver.setLogger(logger);
		MessageHandler.setScreenLogger(logger);
		
		//definis le chemin oe se situe les images
		org.apache.fop.configuration.Configuration.put("baseDir", directoryXsl + "images/");
		
		driver.setRenderer(Driver.RENDER_PDF);
		driver.setOutputStream(content);
		//driver.setOutputStream(new java.io.FileOutputStream(filename));
		Result resultat = new SAXResult(driver.getContentHandler());
		
		// recuperation de la source xml
		Source source = new StreamSource(xml);
		
		// creation du transformer en fonction du xsl
		Source style = new StreamSource(xsl);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(style);
		
		// transformation
		transformer.transform(source, resultat);
		byte[] contentPdf = content.toByteArray();
		
		return contentPdf;
	}

	
	/**
	 * @param id 
	 * @return the download URL (to redirect to).
	 * @throws DownloadException 
	 */
	private static String getDownloadUrl(
			final long id) throws DownloadException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		String downloadUrl;
		downloadUrl = externalContext.getRequestContextPath() + "/download"; 
		downloadUrl += "?" + DownloadServlet.ID_ATTRIBUTE + "=" + id;
		return downloadUrl;
	}
	
	
	/*
	 ******************* ACCESSORS ******************** */

}
