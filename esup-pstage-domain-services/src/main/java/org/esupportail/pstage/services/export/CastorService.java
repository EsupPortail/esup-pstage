/**
 * 
 */
package org.esupportail.pstage.services.export;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.rmi.MarshalException;
import java.rmi.server.ExportException;



/**
 * @author cleprous
 *
 */
public class CastorService implements Serializable {

	/*
	 ******************* PROPERTIES ******************* */
	
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -6766275085431294370L;
	
	/**
	 * Object to Xml.
	 */
	private Marshaller castorMarshaller;
	
	/**
	 * Xml to Object.
	 */
	private Unmarshaller castorUnMarshaller;	

	/**
	 * the path of xml and xsl file. 
	 */
	private String xslXmlPath;


	/*
	 ******************* INIT ************************* */
	
	/**
	 * Constructors.
	 */
	public CastorService() {
		super();
	}

	
	


	
	/*
	 ******************* METHODS ********************** */

	/**
	 * Generate the xml in the file.
	 * @param object 
	 * @param fileName 
	 */
	public void objectToFileXml(final Object object, 
			final String fileName ) {
		
		Writer writer = new StringWriter();
		OutputStreamWriter out = null;
		
		try {
			out = new OutputStreamWriter(new FileOutputStream(xslXmlPath + fileName), "UTF-8");
			
			castorMarshaller.setWriter(writer);		
			castorMarshaller.marshal(object);
			String xmlContent = writer.toString();
			
			out.write(xmlContent);
			out.close();
			writer.close();
			
			
		} catch (MarshalException e) {
			throw new ExportException("problem marhsalling MarshalException ", e);
		} catch (ValidationException e) {
			throw new ExportException("problem marhsalling ValidationException ", e);
		} catch (IOException e) {
			throw new ExportException("problem marhsalling IOException ", e);
		}
	}
	
	
	/*
	 ******************* ACCESSORS ******************** */
	
	/**
	 * @param castorMarshaller the castorMarshaller to set
	 */
	public void setCastorMarshaller(final Marshaller castorMarshaller) {
		this.castorMarshaller = castorMarshaller;
	}

	/**
	 * @param castorUnMarshaller the castorUnMarshaller to set
	 */
	public void setCastorUnMarshaller(final Unmarshaller castorUnMarshaller) {
		this.castorUnMarshaller = castorUnMarshaller;
	}

	/**
	 * @return the xslXmlPath
	 */
	public String getXslXmlPath() {
		return xslXmlPath;
	}
	/**
	 * @param xslXmlPath the xslXmlPath to set
	 */
	public void setXslXmlPath(final String xslXmlPath) {
		this.xslXmlPath = xslXmlPath;
	}

}
