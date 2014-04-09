package org.esupportail.pstage.web.beans;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.esupportail.pstage.utils.Utils;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class ImageUploadBean{

	/**
	 * Répertoire de réception
	 */
	private String directory;

	/**
	 * Nom du fichier uploadé
	 */
	private String nameUploadedImage;
	/**
	 * Nom réel de l'image
	 */
	private String realNameImage;
	/**
	 * Prefix pour le nom de fichier (numéro offre)
	 */
	private int prefix;
	/**
	 * L'extension de l'image
	 */
	private String extension;

	/**
	 * Constructeur
	 * @param directory 
	 */
	public ImageUploadBean(String directory) {
		this.directory=directory;
	}

	/**
	 * file upload listener.
	 * @param event the upload event
	 */
	public void imageUploadListener(FileUploadEvent event) {
		if (event == null) {
			//			logger.warn("Invalid upload event");
		} else {
			// on recupere l'item envoye
			UploadedFile uploadItem = event.getUploadedFile();
			String imageName = uploadItem.getName();

			int i=imageName.lastIndexOf(".");
			this.extension="";
			if(i>0){
				this.extension=imageName.substring(i+1);
			}
			this.realNameImage=imageName;
			imageName=Utils.encodeMD5(imageName)+"."+this.extension;
			this.nameUploadedImage=imageName;
			if (this.prefix >=0)
				imageName = this.prefix+"_"+imageName;

			//code ici on recupere le path vers le repertoire ou stocker le fichier
			File fileToWrite = new File(this.directory + File.separator + imageName);
			ByteArrayInputStream is = null;
			FileOutputStream fos = null;
			try {
//				test = scaleImage(uploadItem.getInputStream(), 300, 300, this.extension);
//				in = ((FileInputStream)test).getChannel();
//				out = new FileOutputStream(fileToWrite).getChannel();
//				in.transferTo(0, in.size(), out);
				is = (ByteArrayInputStream) scaleImage(new BufferedInputStream((FileInputStream)uploadItem.getInputStream()), 300, 300,this.extension);
				fos = new FileOutputStream(fileToWrite);
				int data;
				while((data=is.read())!=-1){
					char ch = (char)data;
					fos.write(ch);
				}
				fos.flush();
			}catch (IOException ex1){ 
				ex1.printStackTrace();
				//
			}catch (Exception e){
				e.printStackTrace();
			}finally{ // fermeture des filechannel
				if(is != null){
					try{
						is.close();
					}catch(IOException e){
						e.printStackTrace();
						//logger.error("Can't close input file channel");
					}
					if(fos != null){
						try{
							fos.close();
						}catch (IOException e){
							e.printStackTrace();
							// logger.error("Can't close ouput file channel");
						}
					}
				}
			}
		}
	}

	/**
	 * Redimenssionnement d'une image
	 * @param p_image
	 * @param p_width
	 * @param p_height
	 * @param extension 
	 * @return ByteArrayOutputStream
	 * @throws Exception
	 */
	public static InputStream scaleImage(InputStream p_image, int p_width, int p_height, String extension) throws Exception {

		InputStream imageStream = new BufferedInputStream(p_image);
		Image image = ImageIO.read(imageStream);
		int imageWidth = image.getWidth(null);
		int imageHeight = image.getHeight(null);
		int thumbWidth;
		int thumbHeight;

		if (imageWidth > 300 || imageHeight > 300){
			thumbWidth = p_width;
			thumbHeight = p_height;        
		} else {
			thumbWidth = imageWidth;
			thumbHeight =imageHeight;
		}
		// Make sure the aspect ratio is maintained, so the image is not skewed
		double thumbRatio = (double)thumbWidth / (double)thumbHeight;

		double imageRatio = (double)imageWidth / (double)imageHeight;
		if (thumbRatio < imageRatio) {
			thumbHeight = (int)(thumbWidth / imageRatio);
		} else {
			thumbWidth = (int)(thumbHeight * imageRatio);
		}

		BufferedImage thumbImage = null;
		Graphics2D graphics2D = null;
		thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
		graphics2D = thumbImage.createGraphics();
		// Gestion image transparence
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, thumbWidth, thumbHeight);
		graphics2D.setComposite(AlphaComposite.SrcOver);
		// Draw the scaled image
		graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

		// Write the scaled image to the outputstream
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(thumbImage, extension, out);

		// Read the outputstream into the inputstream for the return value
		ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());        

		return bis;
	}

	/**
	 * Suppression d'une image
	 * @param id 
	 * @param name 
	 * @return boolean
	 */
	public boolean deleteImageFromDirectory(int id, String name){
		String imageName=name;
		if(id>=0) 
			imageName = id+"_"+imageName;
		File f = new File(this.directory + File.separator + imageName);
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
	public long getTimeStamp(){
		return System.currentTimeMillis();
	}

	/**
	 * @return the directory
	 */
	public String getDirectory() {
		return directory;
	}

	/**
	 * @param directory the directory to set
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}

	/**
	 * @param nameUploadedImage the nameUploadedImage to set
	 */
	public void setNameUploadedImage(String nameUploadedImage) {
		this.nameUploadedImage = nameUploadedImage;
	}

	/**
	 * @return the realNameImage
	 */
	public String getRealNameImage() {
		return realNameImage;
	}

	/**
	 * @param realNameImage the realNameImage to set
	 */
	public void setRealNameImage(String realNameImage) {
		this.realNameImage = realNameImage;
	}

	/**
	 * @return the nameUploadedImage
	 */
	public String getNameUploadedImage() {
		return nameUploadedImage;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the prefix
	 */
	public int getPrefix() {
		return prefix;
	}

}