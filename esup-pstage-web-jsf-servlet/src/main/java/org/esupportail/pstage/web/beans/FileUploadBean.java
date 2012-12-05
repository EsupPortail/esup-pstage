package org.esupportail.pstage.web.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.esupportail.pstage.utils.Utils;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 * 
 */
public class FileUploadBean {

	/**
	 * Rï¿½pertoire de rï¿½ception des fichiers
	 */
	private String directory;
	/**
	 * Nom du fichier uploadï¿½
	 */
	private String nameUploadedFile;
	/**
	 * Nom rï¿½el du fichier
	 */
	private String realNameFile;
	/**
	 * Prefix pour le nom de fichier (numï¿½ro offre)
	 */
	private int prefix;

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
	public void fileUploadListener(UploadEvent event){
		if(event == null){
			// logger.warn("Invalid upload event");
		}else{
			// on recupere l'item envoye
			UploadItem uploadItem = event.getUploadItem();
			if(uploadItem.getFile().isFile()) { // si c'est bien un fichier
				String fileName = uploadItem.getFileName();
				String extension="";
				if(fileName.lastIndexOf(".")>0){
					extension = fileName.substring(fileName.lastIndexOf("."));
				}
				this.realNameFile=fileName;
				//encodage du nom en md5 pour s'affranchir des accents et caractï¿½res spï¿½ciaux
				fileName = Utils.encodeMD5(this.prefix+"")+extension;
				this.nameUploadedFile=fileName;
				if(this.prefix>=0) fileName = this.prefix+"_"+fileName;
				File fileToWrite = new File(this.directory + File.separator
						+ fileName);
				// on construit un Fichier avec le path/nomdufichierrecu
				File uploadedFile = uploadItem.getFile();
				FileChannel in = null; // on va utiliser deux files channel pour
				// faire la recopie
				FileChannel out = null;
				try{
					in = new FileInputStream(uploadedFile).getChannel();
					out = new FileOutputStream(fileToWrite).getChannel();
					in.transferTo(0, in.size(), out);
				}catch(IOException e){
					e.printStackTrace();
					// recuperations des exceptions possibles
					// logger.error("Error while copying the file.");
				}catch(Exception e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{ // fermeture des filechannel
					if(in != null){
						try{
							in.close();
						}catch(IOException e){
							e.printStackTrace();
							//logger.error("Can't close input file channel");
						}
						if(out != null){
							try{
								out.close();
							}catch (IOException e){
								e.printStackTrace();
								// logger.error("Can't close ouput file channel");
							}
						}
					}
				}
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