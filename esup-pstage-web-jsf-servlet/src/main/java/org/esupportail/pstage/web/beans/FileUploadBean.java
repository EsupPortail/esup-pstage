package org.esupportail.pstage.web.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.pstage.utils.Utils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class FileUploadBean {

	/**
	 * Répertoire de réception des fichiers
	 */
	private String directory;
	/**
	 * Nom du fichier uploadé
	 */
	private String nameUploadedFile;
	/**
	 * Nom réel du fichier
	 */
	private String realNameFile;
	/**
	 * Prefix pour le nom de fichier (numéro offre)
	 */
	private int prefix;

	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(this.getClass());

	/**
	 * Constructeur
	 * @param directory
	 */
	public FileUploadBean(String directory) {
		this.directory=directory;
	}

	/**
	 * file upload listener 
	 * @param event the upload event
	 */
	public void fileUploadListener(FileUploadEvent event){
		if(event == null){
			logger.warn("Invalid upload event");
		}else{
			// on recupere l'item envoye
			UploadedFile uploadItem = event.getFile();

			String fileName = uploadItem.getFileName();
			String extension="";
			if(fileName.lastIndexOf('.')>0){
				extension = fileName.substring(fileName.lastIndexOf('.'));
			}
			this.realNameFile=fileName;
			//encodage du nom en md5 pour s'affranchir des accents et caractéres spéciaux
			fileName = Utils.encodeMD5(Integer.toString(this.prefix))+extension;
			this.nameUploadedFile=fileName;
			if(this.prefix>=0) fileName = this.prefix+"_"+fileName;
			File fileToWrite = new File(this.directory + File.separator + fileName);
			try(FileChannel in = ((FileInputStream)uploadItem.getInputstream()).getChannel()){
				try (FileChannel out = new FileOutputStream(fileToWrite).getChannel()){
					in.transferTo(0, in.size(), out);
				}
			} catch(IOException e){
				logger.error(e);
			} catch(Exception e){
				logger.error(e);
			}

		}
	}

	/**
	 * Suppression d'un fichier 
	 * @param id
	 * @param name
	 * @return boolean
	 */
	public boolean deleteFileFromDirectory(int id, String name){
		String fileName=name;
		if(id>=0) fileName = id+"_"+fileName;
		File f = new File(this.directory + File.separator + fileName);
		return f.delete();
	}

	/**
	 * @return String
	 */
	public String clearUploadData() {
		return null;
	}

	/**
	 * @return long
	 */
	public long getTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * @return the directory
	 */
	public String getDirectory() {
		return directory;
	}

	/**
	 * @param directory
	 *            the directory to set
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}

	/**
	 * @return the nameUploadedFile
	 */
	public String getNameUploadedFile() {
		String name = nameUploadedFile;
		nameUploadedFile=null;
		return name;
	}

	/**
	 * @param nameUploadedFile the nameUploadedFile to set
	 */
	public void setNameUploadedFile(String nameUploadedFile) {
		this.nameUploadedFile = nameUploadedFile;
	}

	/**
	 * @return the realNameFile
	 */
	public String getRealNameFile() {
		String name = realNameFile;
		realNameFile=null;
		return name;
	}

	/**
	 * @param realNameFile the realNameFile to set
	 */
	public void setRealNameFile(String realNameFile) {
		this.realNameFile = realNameFile;
	}

	/**
	 * @return the prefix
	 */
	public int getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

}