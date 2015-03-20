package org.esupportail.pstage.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.springframework.util.StringUtils;

/**
 * Utils Class.
 *
 */
public class Utils {
	/* ***************************************************************
	 * REGEX
	 ****************************************************************/

	/**
	 * Regex du code naf
	 */
	public static final String REGEX_CODE_NAF = "^([0-9]{2}\\.?[0-9]{2}[a-zA-Z]{1})$";

	/**
	 * Regex d'une adresse mail
	 */
	public static final String REGEX_MAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";

	/**
	 * Regex d'un site internet
	 */
	public static final String REGEX_SITE_WEB = "^([h]{1}[t]{1}[t]{1}[p]{1}[s]?[:]{1}[/]{2}(\\w([\\w\\-]{0,61}\\w)?\\.)+[a-zA-Z]{2,6}([/]{1}.*)?)$";

	/**
	 * Regex d'un code postal français
	 */
	public static final String REGEX_CODE_POSTAL = "^((0[1-9]|[1-9][0-9])[0-9]{3})$";

	/**
	 * Regex pour la validation d'un numero INSEE
	 */
	public static final String REGEX_INSEE="[0-9]{6}[0-9AB][0-9]{8}$";

	/**
	 * Regex pour la validation d'un montant d'indemnites de stage 3chiffres + . + 2 chiffres
	 */
	public static final String REGEX_MT_GRATIFICATION="^[0-9]++[ \\.]?[0-9]{2}?$";
	
	/**
	 * Regex d'un entier supérieur à 0
	 */
	public static final String REGEX_ENTIER_SUPERIEURA0 = "^([0-9]*)$";	

	/* ***************************************************************
	 * DATE
	 ****************************************************************/

	/**
	 * 
	 */
	public static String TIMESTAMP_PATTERN = "dd/MM/yyyy hh:mm:ss";	
	/**
	 * 
	 */
	public static String TIMESTAMP_PATTERN_SQL = "yyyy-MM-dd hh:mm:ss";	
	/**
	 * 
	 */
	public static String DATE_PATTERN = "dd/MM/yyyy";
	/**
	 * 
	 */
	public static String DATE_PATTERN_SQL = "yyyy-MM-dd";
	/**
	 * 
	 */
	public static String MONTH_PATTERN = "MM";
	/**
	 * 
	 */
	public static String DAY_PATTERN = "dd";
	/**
	 * 
	 */
	public static String YEAR_PATTERN = "yyyy";
	/**
	 * 
	 */
	public static String DATE_YEAR2000= "2000-01-01";	
	/**
	 * The current year for university is :
	 * July to December = year = n + 1.
	 * January to June = year = n.
	 * @param period id true return current year - current year + 1 (Ex.: 2009 - 2010)
	 * @return String
	 */
	public static String getCurrentYear(final Boolean period) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		if (month <= Calendar.JULY) {
			year -= 1;
		}
		if (period) {
			return String.valueOf(year) + "/" + String.valueOf(year + 1);
		}
		return String.valueOf(year);
	}

	/**
	 * convert the type date to string.
	 * @param d
	 * @param format
	 * @return String
	 */
	public static String convertDateToString(final Date d, final String format) {
		SimpleDateFormat s = new SimpleDateFormat(format);
		return s.format(d);
	}

	/**
	 * @param strDate
	 * @param format 
	 * @return Date
	 */
	public static Date convertStringToDate(final String strDate, final String format) {
		Date date = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			ParsePosition pos = new ParsePosition(0);
			date = formatter.parse(strDate, pos);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}

		return date; 
	}

	/**
	 * @param str
	 * @return Timestamp
	 * @throws ParseException
	 */
	public static Timestamp parseTimestamp(final String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_PATTERN);
		return new Timestamp(sdf.parse(str).getTime());
	}

	/**
	 * @param str
	 * @return Timestamp
	 * @throws ParseException
	 */
	public static Timestamp parseTimestampSql(final String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_PATTERN_SQL);
		return new Timestamp(sdf.parse(str).getTime());
	}

	/**
	 * @param calendar
	 * @return String
	 */
	public static String getMonth(final Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(MONTH_PATTERN);
		return sdf.format(calendar.getTime());
	}

	/**
	 * @param calendar
	 * @return String
	 */
	public static String getDay(final Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_PATTERN);
		return sdf.format(calendar.getTime());
	}

	/**
	 * @param calendar
	 * @return String
	 */
	public static String getYear(final Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(YEAR_PATTERN);
		return sdf.format(calendar.getTime());
	}

	/**
	 * Renvoie la date du jour au format java.sql.Date
	 * @return GregorianCalendar
	 */
	public static GregorianCalendar getToday() {
		GregorianCalendar result = new GregorianCalendar();
		result.setFirstDayOfWeek(Calendar.MONDAY);		
		return result;
	}

	/* ***************************************************************
	 * CONTROLES
	 ****************************************************************/

	/**
	 * Retourne vrai si le numéro siret est valide
	 * @param numSiret
	 * @return boolean
	 */
	public static boolean validateNumSiret(String numSiret){
		if(numSiret.length()!=14 || !isNumber(numSiret)) return false;

		int total = 0;
		int nb = 0;
		
        /** Cas de la Poste, nouvel algo en 2012 car plus de 10000 établissement, nombre limite de l'algo de Luhn **/
        if (numSiret.substring(0, 9).equals("356000000")) {
            for (int i = 0; i<numSiret.length(); i++) {
                /** somme simple des chiffres du SIRET */
                nb = convertStringToInt(String.valueOf(numSiret.charAt(i)));
                total += nb;
            }
            boolean ret=true;
            if(isNumber(numSiret) && Long.parseLong(numSiret)==0)ret=false;
            /** Si la somme est un multiple de 5 alors le SIRET de la Poste est valide */
            return (total % 5 == 0) ? ret : false;
        }
        /** Cas classique **/
		for (int i = 0; i<numSiret.length(); i++) {
			/** Recherche les positions impaires : 1er, 3e, 5e, etc... que l'on multiplie par 2*/
			if ((i % 2) == 0) {
				nb = convertStringToInt(String.valueOf(numSiret.charAt(i))) * 2;
				/** si le résultat est >9 alors il est composé de deux chiffres et ne pouvant être >19 le calcule devient : 1 + (nb -10) ou : nb - 9 */
				if (nb > 9) nb -= 9;
			}else{
				nb = convertStringToInt(String.valueOf(numSiret.charAt(i)));
			}
			total += nb;
		}
		boolean ret=true;
		if(isNumber(numSiret) && Long.parseLong(numSiret)==0)ret=false;
		/** Si la somme est un multiple de 10 alors le SIRET est valide */
		return (total % 10 == 0) ? ret : false; 
	}

	/**
	 * Retourne vrai si le numéro siren est valide
	 * @param numSiren
	 * @return boolean
	 */
	public static boolean validateNumSiren(String numSiren){
		if(numSiren.length()!=9 || !isNumber(numSiren)) return false;

		int total = 0;
		int nb = 0;		
		for (int i = 0; i<numSiren.length(); i++) {
			/** Recherche les positions impaires : 1er, 3e, 5e, etc... que l'on multiplie par 2*/
			if ((i % 2) != 0) {
				nb = convertStringToInt(String.valueOf(numSiren.charAt(i))) * 2;
				/** si le résultat est >9 alors il est composé de deux chiffres et ne pouvant être >19 le calcule devient : 1 + (nb -10) ou : nb - 9 */
				if (nb > 9) nb -= 9;
			}else{
				nb = convertStringToInt(String.valueOf(numSiren.charAt(i)));
			}
			total += nb;
		}
		boolean ret=true;
		if(isNumber(numSiren) && Long.parseLong(numSiren)==0)ret=false;
		/** Si la somme est un multiple de 10 alors le SIRET est valide */
		return (total % 10 == 0) ? ret : false; 
	}


	/**
	 * @param numSS
	 * @return boolean inseeOK
	 */
	public static boolean validateInsee(String numSS){
		boolean inseeOK = true;
		if (StringUtils.hasText(numSS)) {
			if (!numSS.matches(Utils.REGEX_INSEE)) {
				inseeOK = false;
			}else {
				//on regarde si la cle est correcte
				String nirSansCle = numSS.substring(0, 13);
				int cleSaisie = Integer.valueOf(numSS.substring(13));


				long nirAjuste ;

				if (nirSansCle.contains("A")){
					nirSansCle=nirSansCle.replace("A", "0");

					nirAjuste=Long.parseLong(nirSansCle)-1000000;
				}
				else{
					if (nirSansCle.contains("B")){
						nirSansCle=nirSansCle.replace("B", "0");
						nirAjuste=Long.parseLong(nirSansCle)-2000000;
					}
					else{
						nirAjuste=Long.parseLong(nirSansCle);
					}
				}
				int cleCalculee=97-((int)(nirAjuste % 97));

				if (cleCalculee!=cleSaisie){
					inseeOK = false;
				}
			}
		}
		return inseeOK;
	}

	/**
	 * @param montantGratification
	 * @return boolean mtGratOK
	 */
	public static boolean validateMtGratification(String montantGratification){
		boolean mtGratOK = true;
		if (StringUtils.hasText(montantGratification)) {
			if (!montantGratification.matches(Utils.REGEX_MT_GRATIFICATION)) {
				mtGratOK = false;
			}
		}
		return mtGratOK;
	}

	/* ***************************************************************
	 * STRING
	 ****************************************************************/

	/**
	 * Retourne vrai si la chaine en paramètre est un nombre
	 * @param nb
	 * @return boolean
	 */
	public static boolean isNumber(String nb){
		try{
			Long.parseLong(nb);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}

	/**
	 * Converti une chaine de caractère String en entier Int
	 * dans la mesure du possible
	 * @param s
	 * @return int
	 */
	public static int convertStringToInt(String s){
		int r = 0;
		try{
			r = Integer.parseInt(s);
		}catch (NumberFormatException e) {
			//nothing
		}
		return r;
	}


	/** Index du 1er caractere accentué **/
	private static final int MIN = 192;
	/** Index du dernier caractere accentué **/
	private static final int MAX = 255;
	/** Vecteur de correspondance entre accent / sans accent **/
	private static final Vector<String> map = initMap();

	/** Initialisation du tableau de correspondance entre les caractéres accentués et leur homologues non accentués 
	 * @return result
	 **/
	private static Vector<String> initMap(){  
		Vector<String> Result         = new Vector<String>();
		String car  = null;
		car = new java.lang.String("A");
		Result.add( car );            /* '\u00C0'   À   alt-0192  */  
		Result.add( car );            /* '\u00C1'   Á   alt-0193  */
		Result.add( car );            /* '\u00C2'   Â   alt-0194  */
		Result.add( car );            /* '\u00C3'   Ã   alt-0195  */
		Result.add( car );            /* '\u00C4'   Ä   alt-0196  */
		Result.add( car );            /* '\u00C5'   Å   alt-0197  */
		car = new java.lang.String("AE");
		Result.add( car );            /* '\u00C6'   Æ   alt-0198  */
		car = new java.lang.String("C");
		Result.add( car );            /* '\u00C7'   Ç   alt-0199  */
		car = new java.lang.String("E");
		Result.add( car );            /* '\u00C8'   È   alt-0200  */
		Result.add( car );            /* '\u00C9'   É   alt-0201  */
		Result.add( car );            /* '\u00CA'   Ê   alt-0202  */
		Result.add( car );            /* '\u00CB'   Ë   alt-0203  */
		car = new java.lang.String("I");
		Result.add( car );            /* '\u00CC'   Ì   alt-0204  */
		Result.add( car );            /* '\u00CD'   Í   alt-0205  */
		Result.add( car );            /* '\u00CE'   Î   alt-0206  */
		Result.add( car );            /* '\u00CF'   Ï   alt-0207  */
		car = new java.lang.String("D");
		Result.add( car );            /* '\u00D0'   Ð   alt-0208  */
		car = new java.lang.String("N");
		Result.add( car );            /* '\u00D1'   Ñ   alt-0209  */
		car = new java.lang.String("O");
		Result.add( car );            /* '\u00D2'   Ò   alt-0210  */
		Result.add( car );            /* '\u00D3'   Ó   alt-0211  */
		Result.add( car );            /* '\u00D4'   Ô   alt-0212  */
		Result.add( car );            /* '\u00D5'   Õ   alt-0213  */
		Result.add( car );            /* '\u00D6'   Ö   alt-0214  */
		car = new java.lang.String("*");
		Result.add( car );            /* '\u00D7'   ×   alt-0215  */
		car = new java.lang.String("0");
		Result.add( car );            /* '\u00D8'   Ø   alt-0216  */
		car = new java.lang.String("U");
		Result.add( car );            /* '\u00D9'   Ù   alt-0217  */
		Result.add( car );            /* '\u00DA'   Ú   alt-0218  */
		Result.add( car );            /* '\u00DB'   Û   alt-0219  */
		Result.add( car );            /* '\u00DC'   Ü   alt-0220  */
		car = new java.lang.String("Y");
		Result.add( car );            /* '\u00DD'   Ý   alt-0221  */
		car = new java.lang.String("Þ");
		Result.add( car );            /* '\u00DE'   Þ   alt-0222  */
		car = new java.lang.String("B");
		Result.add( car );            /* '\u00DF'   ß   alt-0223  */
		car = new java.lang.String("a");
		Result.add( car );            /* '\u00E0'   à   alt-0224  */
		Result.add( car );            /* '\u00E1'   á   alt-0225  */
		Result.add( car );            /* '\u00E2'   â   alt-0226  */
		Result.add( car );            /* '\u00E3'   ã   alt-0227  */
		Result.add( car );            /* '\u00E4'   ä   alt-0228  */
		Result.add( car );            /* '\u00E5'   å   alt-0229  */
		car = new java.lang.String("ae");
		Result.add( car );            /* '\u00E6'   æ   alt-0230  */
		car = new java.lang.String("c");
		Result.add( car );            /* '\u00E7'   ç   alt-0231  */
		car = new java.lang.String("e");
		Result.add( car );            /* '\u00E8'   è   alt-0232  */
		Result.add( car );            /* '\u00E9'   é   alt-0233  */
		Result.add( car );            /* '\u00EA'   ê   alt-0234  */
		Result.add( car );            /* '\u00EB'   ë   alt-0235  */
		car = new java.lang.String("i");
		Result.add( car );            /* '\u00EC'   ì   alt-0236  */
		Result.add( car );            /* '\u00ED'   í   alt-0237  */
		Result.add( car );            /* '\u00EE'   î   alt-0238  */
		Result.add( car );            /* '\u00EF'   ï   alt-0239  */
		car = new java.lang.String("d");
		Result.add( car );            /* '\u00F0'   ð   alt-0240  */
		car = new java.lang.String("n");
		Result.add( car );            /* '\u00F1'   ñ   alt-0241  */
		car = new java.lang.String("o");
		Result.add( car );            /* '\u00F2'   ò   alt-0242  */
		Result.add( car );            /* '\u00F3'   ó   alt-0243  */
		Result.add( car );            /* '\u00F4'   ô   alt-0244  */
		Result.add( car );            /* '\u00F5'   õ   alt-0245  */
		Result.add( car );            /* '\u00F6'   ö   alt-0246  */
		car = new java.lang.String("/");
		Result.add( car );            /* '\u00F7'   ÷   alt-0247  */
		car = new java.lang.String("0");
		Result.add( car );            /* '\u00F8'   ø   alt-0248  */
		car = new java.lang.String("u");
		Result.add( car );            /* '\u00F9'   ù   alt-0249  */
		Result.add( car );            /* '\u00FA'   ú   alt-0250  */
		Result.add( car );            /* '\u00FB'   û   alt-0251  */
		Result.add( car );            /* '\u00FC'   ü   alt-0252  */
		car = new java.lang.String("y");
		Result.add( car );            /* '\u00FD'   ý   alt-0253  */
		car = new java.lang.String("þ");
		Result.add( car );            /* '\u00FE'   þ   alt-0254  */
		car = new java.lang.String("y");
		Result.add( car );            /* '\u00FF'   ÿ   alt-0255  */
		Result.add( car );            /* '\u00FF'       alt-0255  */
		return Result;
	}

	/** Transforme une chaine pouvant contenir des accents dans une version sans accent 
	 *  @param chaine Chaine a convertir sans accent
	 *  @return chaine sans accent
	 **/
	public static String sansAccent(String chaine){  
		if(chaine==null) return null;
		StringBuffer Result  = new StringBuffer(chaine);
		for(int bcl = 0 ; bcl < Result.length() ; bcl++){  
			int carVal = chaine.charAt(bcl);
			if( carVal >= MIN && carVal <= MAX ){ 
				// Remplacement
				String newVal = map.get( carVal - MIN );
				Result.replace(bcl, bcl+1,newVal);
			}   
		}
		return Result.toString();       
	}

	/**
	 * @param chaine
	 * @return chaine sans accent en majuscules
	 */
	public static String sansAccentEnMAJ(String chaine){
		if(chaine==null) return null;
		return sansAccent(chaine).toUpperCase();
	}

	/**
	 * @param chaine
	 * @return chaine avec la première lettre en majuscules
	 */
	public static String premiereLettreMAJ(String chaine){
		if(chaine==null) return null;
		String s = chaine.toLowerCase();
		String preL = s.charAt(0)+"";
		StringBuffer sb  = new StringBuffer(s);
		sb.replace(0, 1, preL.toUpperCase());
		return sb.toString();
	}    

	/* ***************************************************************
	 * MD5
	 ****************************************************************/   

	/**
	 * Encode une chaine avec l'algo MD5    
	 * @param chaine
	 * @return chaine cryptée md5
	 */
	public static String encodeMD5(String chaine) {
		byte[] uniqueKey = chaine.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		}catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			}else{
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}
	/**
	 * @param id
	 * @return String
	 */
	public static String encodageIdCgMd5(int id){
		String ret="";
		if(id>0){
			ret=Utils.encodeMD5(((((id+id)*(id+id))*1000)+7*id)+"pstage"+((id*id)+id)+"depotanonyme");
		}
		return ret;
	}
	/**
	 * Génération d'un login
	 * @param sn
	 * @param num
	 * @return un login généré à partir de sn et num (ex. : login0023)
	 */
	public static String loginGeneration(String sn,String num){
		String tmp = sn;
		String tmpTab[]= new String[2];
		String login = "";
		String[] result = tmp.split("\\s");
		int j=0;
		for (int i=0; i<result.length && i<2; i++){
			if(result[i].length()>1){
				tmpTab[j] = result[i];
			}
			j++;
		}
		if(tmpTab[0] != null && tmpTab[0]!=""){
			if(tmpTab[1]!=null && tmpTab[1]!=""){
				login = login + ((tmpTab[0].length()>3) ? tmpTab[0].substring(0, 3) : tmpTab[0]);
				login = login + ((tmpTab[1].length()>3) ? tmpTab[1].substring(0, 3) : tmpTab[1]);
			}else{
				login = login + ((tmpTab[0].length()>6) ? tmpTab[0].substring(0, 6) : tmpTab[0]);
			}
		}		
		login=sansAccent(login);
		login=sansCaractSpe(login);
		login=login.toLowerCase();
		login=login.toLowerCase();
		if(num != null && num != "" && isNumber(num)){
			String n="000"+num;
			login = login + ((n.length()>4) ? n.substring(n.length()-4, n.length()): n); 
		}
		return login;
	}

	/**
	 * @param src
	 * @return la chaine src sans caractères spéciaux ni accents
	 */
	public static String sansCaractSpe(String src){
		StringBuffer result = new StringBuffer();
		if(src!=null && src.length()!=0){
			char c = (char)0;
			String chars= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			String replace= "";
			for(int i=0; i<src.length(); i++){
				c = src.charAt(i);
				if( (chars.indexOf(c))==-1 )
					result.append(replace);
				else
					result.append(c);
			}
		}
		return result.toString();
	}
	/** 
	 * Pour le confort.
	 * @param propriete la proprieté à  verifier
	 * @param nomClasse nom de la classe 
	 * @return une chaine formatÃ©e
	 */
	public static String verifierPropriete(Object propriete, String nomClasse) {

		StringBuilder builder = new StringBuilder(" La propriete "); //$NON-NLS-1$
		builder.append(propriete);
		builder.append(" de la classe "); //$NON-NLS-1$
		builder.append(nomClasse);
		builder.append(Configuration.getString("Utils.value.notnull")); //$NON-NLS-1$

		return builder.toString();
	}
	
	/**
	 * @param dateDebStage
	 * @param dateFinStage
	 * @param dateDebInterr
	 * @param dateFinInterr
	 * @return duree en semaine
	 */
	public static int CalculDureeSemaine(Date dateDebStage, Date dateFinStage, Date dateDebInterr, Date dateFinInterr) {

		// Convertir les dates en miliseconde
		long dateDebStageLong = (dateDebStage != null) ? dateDebStage.getTime()/(1000*60*60*24*7) : 0;
		long dateFinStageLong = (dateFinStage != null) ? dateFinStage.getTime()/(1000*60*60*24*7) : 0;
		long dateDebInterrLong = (dateDebInterr != null) ? dateDebInterr.getTime()/(1000*60*60*24*7) : 0;
		long dateFinInterrLong = (dateFinInterr != null) ? dateFinInterr.getTime()/(1000*60*60*24*7) : 0;

		int dureeEnSemaine = 0;
		
		//On calcule seulement si la date de fin est supérieur a la date de début
		if (dateFinStageLong >= dateDebStageLong) {
			long dureeLong = dateFinStageLong - dateDebStageLong;
			long dureeInterrLong = 0;

			// On enlève les dates d'interruption si ces dates sont dans l'intervalle de date début et date de fin
			if (dateFinInterrLong > dateDebInterrLong 
			&& dateDebInterrLong >= dateDebStageLong 
			&& dateFinInterrLong <= dateFinStageLong){
				dureeInterrLong = dateFinInterrLong - dateDebInterrLong;
			}

			dureeEnSemaine = Math.round((float)(dureeLong - dureeInterrLong));

			if(dureeEnSemaine==0)dureeEnSemaine++;
		}

		return dureeEnSemaine;
	}

	/* ***************************************************************
	 * HTML
	 ****************************************************************/  
	
	/**
	 * Remplacement des caractères HTML
	 * @param chaineAchanger
	 * @return chaineRemplacer
	 */
	public static String replaceHTML(String chaineAchanger){
		String chaineRemplacer = "";
		if (StringUtils.hasText(chaineAchanger)) {
			chaineRemplacer = chaineAchanger.replaceAll("<style(?s)(.*)style>", "");
			chaineRemplacer = chaineRemplacer.replaceAll("<!--(?s)(.*)-->", "");
			chaineRemplacer = chaineRemplacer.replaceAll("<[^>]*>", "");
			chaineRemplacer = chaineRemplacer.replaceAll("&iexcl;", "¡");
			chaineRemplacer = chaineRemplacer.replaceAll("&cent;", "¢");
			chaineRemplacer = chaineRemplacer.replaceAll("&pound;", "£");
			chaineRemplacer = chaineRemplacer.replaceAll("&curren;", "¤");
			chaineRemplacer = chaineRemplacer.replaceAll("&yen;", "¥");
			chaineRemplacer = chaineRemplacer.replaceAll("&brvbar;", "¦");
			chaineRemplacer = chaineRemplacer.replaceAll("&sect;", "§");
			chaineRemplacer = chaineRemplacer.replaceAll("&uml;", "¨");
			chaineRemplacer = chaineRemplacer.replaceAll("&copy;", "©");
			chaineRemplacer = chaineRemplacer.replaceAll("&ordf;", "ª");
			chaineRemplacer = chaineRemplacer.replaceAll("&laquo;", "«");
			chaineRemplacer = chaineRemplacer.replaceAll("&not;", "¬");
			chaineRemplacer = chaineRemplacer.replaceAll("&shy;", "­");
			chaineRemplacer = chaineRemplacer.replaceAll("&reg;", "®");
			chaineRemplacer = chaineRemplacer.replaceAll("&macr;", "¯");
			chaineRemplacer = chaineRemplacer.replaceAll("&deg;", "°");
			chaineRemplacer = chaineRemplacer.replaceAll("&plusmn;", "±");
			chaineRemplacer = chaineRemplacer.replaceAll("&sup2;", "²");
			chaineRemplacer = chaineRemplacer.replaceAll("&sup3;", "³");
			chaineRemplacer = chaineRemplacer.replaceAll("&acute;", "´");
			chaineRemplacer = chaineRemplacer.replaceAll("&micro;", "µ");
			chaineRemplacer = chaineRemplacer.replaceAll("&para;", "¶");
			chaineRemplacer = chaineRemplacer.replaceAll("&middot;", "·");
			chaineRemplacer = chaineRemplacer.replaceAll("&cedil;", "¸");
			chaineRemplacer = chaineRemplacer.replaceAll("&sup1;", "¹");
			chaineRemplacer = chaineRemplacer.replaceAll("&ordm;", "º");
			chaineRemplacer = chaineRemplacer.replaceAll("&raquo;", "»");
			chaineRemplacer = chaineRemplacer.replaceAll("&frac14;", "¼");
			chaineRemplacer = chaineRemplacer.replaceAll("&frac12;", "½");
			chaineRemplacer = chaineRemplacer.replaceAll("&frac34;", "¾");
			chaineRemplacer = chaineRemplacer.replaceAll("&iquest;", "¿");
			chaineRemplacer = chaineRemplacer.replaceAll("&Agrave;", "À");
			chaineRemplacer = chaineRemplacer.replaceAll("&Aacute;", "Á");
			chaineRemplacer = chaineRemplacer.replaceAll("&Acirc;", "Â");
			chaineRemplacer = chaineRemplacer.replaceAll("&Atilde;", "Ã");
			chaineRemplacer = chaineRemplacer.replaceAll("&Auml;", "Ä");
			chaineRemplacer = chaineRemplacer.replaceAll("&Aring;", "Å");
			chaineRemplacer = chaineRemplacer.replaceAll("&AElig;", "Æ");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ccedil;", "Ç");
			chaineRemplacer = chaineRemplacer.replaceAll("&Egrave;", "È");
			chaineRemplacer = chaineRemplacer.replaceAll("&Eacute;", "É");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ecirc;", "Ê");
			chaineRemplacer = chaineRemplacer.replaceAll("&Euml;", "Ë");
			chaineRemplacer = chaineRemplacer.replaceAll("&Igrave;", "Ì");
			chaineRemplacer = chaineRemplacer.replaceAll("&Iacute;", "Í");
			chaineRemplacer = chaineRemplacer.replaceAll("&Icirc;", "Î");
			chaineRemplacer = chaineRemplacer.replaceAll("&Iuml;", "Ï");
			chaineRemplacer = chaineRemplacer.replaceAll("&ETH;", "Ð");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ntilde;", "Ñ");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ograve;", "Ò");
			chaineRemplacer = chaineRemplacer.replaceAll("&Oacute;", "Ó");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ocirc;", "Ô");
			chaineRemplacer = chaineRemplacer.replaceAll("&Otilde;", "Õ");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ouml;", "Ö");
			chaineRemplacer = chaineRemplacer.replaceAll("&times;", "×");
			chaineRemplacer = chaineRemplacer.replaceAll("&Oslash;", "Ø");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ugrave;", "Ù");
			chaineRemplacer = chaineRemplacer.replaceAll("&Uacute;", "Ú");
			chaineRemplacer = chaineRemplacer.replaceAll("&Ucirc;", "Û");
			chaineRemplacer = chaineRemplacer.replaceAll("&Uuml;", "Ü");
			chaineRemplacer = chaineRemplacer.replaceAll("&Yacute;", "Ý");
			chaineRemplacer = chaineRemplacer.replaceAll("&THORN;", "Þ");
			chaineRemplacer = chaineRemplacer.replaceAll("&szlig;", "ß");
			chaineRemplacer = chaineRemplacer.replaceAll("&agrave;", "à");
			chaineRemplacer = chaineRemplacer.replaceAll("&aacute;", "á");
			chaineRemplacer = chaineRemplacer.replaceAll("&acirc;", "â");
			chaineRemplacer = chaineRemplacer.replaceAll("&atilde;", "ã");
			chaineRemplacer = chaineRemplacer.replaceAll("&auml;", "ä");
			chaineRemplacer = chaineRemplacer.replaceAll("&aring;", "å");
			chaineRemplacer = chaineRemplacer.replaceAll("&aelig;", "æ");
			chaineRemplacer = chaineRemplacer.replaceAll("&ccedil;", "ç");
			chaineRemplacer = chaineRemplacer.replaceAll("&egrave;", "è");
			chaineRemplacer = chaineRemplacer.replaceAll("&eacute;", "é");
			chaineRemplacer = chaineRemplacer.replaceAll("&ecirc;", "ê");
			chaineRemplacer = chaineRemplacer.replaceAll("&euml;", "ë");
			chaineRemplacer = chaineRemplacer.replaceAll("&igrave;", "ì");
			chaineRemplacer = chaineRemplacer.replaceAll("&iacute;", "í");
			chaineRemplacer = chaineRemplacer.replaceAll("&icirc;", "î");
			chaineRemplacer = chaineRemplacer.replaceAll("&iuml;", "ï");
			chaineRemplacer = chaineRemplacer.replaceAll("&eth;", "ð");
			chaineRemplacer = chaineRemplacer.replaceAll("&ntilde;", "ñ");
			chaineRemplacer = chaineRemplacer.replaceAll("&ograve;", "ò");
			chaineRemplacer = chaineRemplacer.replaceAll("&oacute;", "ó");
			chaineRemplacer = chaineRemplacer.replaceAll("&ocirc;", "ô");
			chaineRemplacer = chaineRemplacer.replaceAll("&otilde;", "õ");
			chaineRemplacer = chaineRemplacer.replaceAll("&ouml;", "ö");
			chaineRemplacer = chaineRemplacer.replaceAll("&divide;", "÷");
			chaineRemplacer = chaineRemplacer.replaceAll("&oslash;", "ø");
			chaineRemplacer = chaineRemplacer.replaceAll("&ugrave;", "ù");
			chaineRemplacer = chaineRemplacer.replaceAll("&uacute;", "ú");
			chaineRemplacer = chaineRemplacer.replaceAll("&ucirc;", "û");
			chaineRemplacer = chaineRemplacer.replaceAll("&uuml;", "ü");
			chaineRemplacer = chaineRemplacer.replaceAll("&yacute;", "ý");
			chaineRemplacer = chaineRemplacer.replaceAll("&thorn;", "þ");
			chaineRemplacer = chaineRemplacer.replaceAll("&yuml;", "ÿ");
			chaineRemplacer = chaineRemplacer.replaceAll("&quot;", "\"");
			chaineRemplacer = chaineRemplacer.replaceAll("&amp;", "&");
			chaineRemplacer = chaineRemplacer.replaceAll("&lt;", "<");
			chaineRemplacer = chaineRemplacer.replaceAll("&gt;", ">");
			chaineRemplacer = chaineRemplacer.replaceAll("&Alpha;", "?");
			chaineRemplacer = chaineRemplacer.replaceAll("&alpha;", "a");
			chaineRemplacer = chaineRemplacer.replaceAll("&beta;", "ß");
			chaineRemplacer = chaineRemplacer.replaceAll("&Gamma;", "G");
			chaineRemplacer = chaineRemplacer.replaceAll("&delta;", "d");
			chaineRemplacer = chaineRemplacer.replaceAll("&epsilon;", "e");
			chaineRemplacer = chaineRemplacer.replaceAll("&Theta;", "T");
			chaineRemplacer = chaineRemplacer.replaceAll("&mu;", "µ");
			chaineRemplacer = chaineRemplacer.replaceAll("&pi;", "p");
			chaineRemplacer = chaineRemplacer.replaceAll("&Sigma;", "S");
			chaineRemplacer = chaineRemplacer.replaceAll("&sigma;", "s");
			chaineRemplacer = chaineRemplacer.replaceAll("&tau;", "t");
			chaineRemplacer = chaineRemplacer.replaceAll("&Phi;", "F");
			chaineRemplacer = chaineRemplacer.replaceAll("&phi;", "f");
			chaineRemplacer = chaineRemplacer.replaceAll("&Omega;", "O");
			chaineRemplacer = chaineRemplacer.replaceAll("&empty;", "Ø");
			chaineRemplacer = chaineRemplacer.replaceAll("&minus;", "-");
			chaineRemplacer = chaineRemplacer.replaceAll("&lowast;", "*");
			chaineRemplacer = chaineRemplacer.replaceAll("&radic;", "v");
			chaineRemplacer = chaineRemplacer.replaceAll("&infin;", "8");
			chaineRemplacer = chaineRemplacer.replaceAll("&cap;", "n");
			chaineRemplacer = chaineRemplacer.replaceAll("&sim;", "~");
			chaineRemplacer = chaineRemplacer.replaceAll("&asymp;", "˜");
			chaineRemplacer = chaineRemplacer.replaceAll("&equiv;", "=");
			chaineRemplacer = chaineRemplacer.replaceAll("&le;", "=");
			chaineRemplacer = chaineRemplacer.replaceAll("&ge;", "=");
			chaineRemplacer = chaineRemplacer.replaceAll("&sdot;", "·");
			chaineRemplacer = chaineRemplacer.replaceAll("&bull;", "•");
			chaineRemplacer = chaineRemplacer.replaceAll("&hellip;", "…");
			chaineRemplacer = chaineRemplacer.replaceAll("&prime;", "'");
			chaineRemplacer = chaineRemplacer.replaceAll("&oline;", "?");
			chaineRemplacer = chaineRemplacer.replaceAll("&frasl;", "/");
			chaineRemplacer = chaineRemplacer.replaceAll("&weierp;", "P");
			chaineRemplacer = chaineRemplacer.replaceAll("&image;", "I");
			chaineRemplacer = chaineRemplacer.replaceAll("&real;", "R");
			chaineRemplacer = chaineRemplacer.replaceAll("&trade;", "™");
			chaineRemplacer = chaineRemplacer.replaceAll("&euro;", "€");
			chaineRemplacer = chaineRemplacer.replaceAll("&mdash;", "—");
			chaineRemplacer = chaineRemplacer.replaceAll("&ndash;", "–");
			chaineRemplacer = chaineRemplacer.replaceAll("&lsquo;", "‘");
			chaineRemplacer = chaineRemplacer.replaceAll("&rsquo;", "’");
			chaineRemplacer = chaineRemplacer.replaceAll("&sbquo;", "‚");
			chaineRemplacer = chaineRemplacer.replaceAll("&ldquo;", "“");
			chaineRemplacer = chaineRemplacer.replaceAll("&rdquo;", "”");
			chaineRemplacer = chaineRemplacer.replaceAll("&bdquo;", "„");
			chaineRemplacer = chaineRemplacer.replaceAll("&dagger;", "†");
			chaineRemplacer = chaineRemplacer.replaceAll("&Dagger;", "‡");
			chaineRemplacer = chaineRemplacer.replaceAll("&permil;", "‰");
			chaineRemplacer = chaineRemplacer.replaceAll("&lsaquo;", "‹");
			chaineRemplacer = chaineRemplacer.replaceAll("&rsaquo;", "›");
			chaineRemplacer = chaineRemplacer.replaceAll("&nbsp;", " ");
		}
		return chaineRemplacer;
	}

}
