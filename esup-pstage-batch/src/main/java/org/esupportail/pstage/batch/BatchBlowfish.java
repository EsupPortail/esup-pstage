/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.batch; 

import java.math.BigInteger;

import org.esupportail.commons.services.exceptionHandling.ExceptionUtils;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.pstage.utils.BlowfishUtils;

/**
 * A class with a main method called by ant targets.
 */
public class BatchBlowfish {

	/**
	 * A logger.
	 */
	private static final Logger LOG = new LoggerImpl(BatchBlowfish.class);

	/**
	 * Bean constructor.
	 */
	private BatchBlowfish() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Print the syntax and exit.
	 */
	private static void syntax() {
		throw new IllegalArgumentException(
				"syntax: " + BatchBlowfish.class.getSimpleName() + " <params>"
				+ "\nwhere params are :"
				+ "\n -g : for generation"
				+ "\n -e KEY PlainTextToEncrypt : for encryption"
				+ "\n -d KEY EncryptTextToDecrypt : for decryption."
				+ "\n- _generateBlowfishKey : generate and test Blowfish Keys");
	}

	/**
	 * Dispatch dependaing on the arguments.
	 * @param args
	 */
	protected static void dispatch(final String[] args) {
		switch (args.length) {
		case 0:
			syntax();
			break;
		case 1:
			if("-g".equals(args[0])){
				//Génération de la clé
				byte[] secretKey = BlowfishUtils.getSecretKeyInBytes(BlowfishUtils.generateKey());
				LOG.info("\n\n\n\nVotre clé : "+new BigInteger(secretKey));
				LOG.info("A copier dans la propriété blowfishKey du fichier config.properties.\n\n\n\n ");
			}else{
				syntax();
			}
			break;
		case 3:
			if("-e".equals(args[0])){
				String key = args[1];
				String plaintext = args[2];
				//Cryptage de la chaine de caract�re
				BigInteger bi = new BigInteger(key);
				LOG.info("Encrypting ...");
				byte[] ciphertext = BlowfishUtils.crypt(BlowfishUtils.getSecretKeyFromBytes(bi.toByteArray()), plaintext);   
				LOG.info("Encryption of "+plaintext+" = " + new BigInteger(ciphertext));
			}else if("-d".equals(args[0])){
				String key = args[1];
				String eText = args[2];
				byte[] encrypText = new BigInteger(args[1]).toByteArray();
				BigInteger bi = new BigInteger(key);
				LOG.info("Decrypting ...");
				String plainText = BlowfishUtils.decryptInString(BlowfishUtils.getSecretKeyFromBytes(bi.toByteArray()), encrypText);
				LOG.info("decrypt : (encrypText) "+eText+" = " + plainText);	
			}else{
				syntax();
			}
			break;
		default:
			syntax();
		break;
		}
	}

	/**
	 * The main method, called by ant.
	 * @param args
	 */
	public static void main(final String[] args) {
		try {
			dispatch(args);
		} catch (Throwable t) {
			ExceptionUtils.catchException(t);
		}
	}

}
