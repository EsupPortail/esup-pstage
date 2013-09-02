<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes = "java">
	
	
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fo/extensions">
			<fo:layout-master-set>
				
				<fo:simple-page-master master-name="all"
					border="" page-height="29.699cm" page-width="20.999cm"
					margin-right="1cm" margin-left="1.3cm" margin-bottom="1.09cm"
					margin-top="0.794cm">
					<fo:region-body margin-bottom="0cm" />
					<fo:region-after display-align="after" 
						space-before="0cm" extent="0.55cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			
			<fo:page-sequence master-reference="all">
				<fo:static-content flow-name="xsl-region-after">
					<fo:block line-height="110%" hyphenate="false" language="fr"
						country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
						text-align="end">
						<fo:inline font-size="11.5pt">
							<fo:page-number />
				/
				<fo:page-number-citation ref-id="theEnd" />
						</fo:inline>
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="xsl-footnote-separator">
					<fo:block>
						<fo:leader rule-thickness="0.5pt" rule-style="solid"
							leader-length="100%" leader-pattern="rule" />
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:apply-templates select="convention-dTO" />
					</fo:block>

				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>

	<!-- definition du noeud convention -->
	<xsl:template match="convention-dTO">
		<fo:block>
			<!-- appel mise en page -->
			<xsl:call-template name="miseEnPage" />
		</fo:block>
	</xsl:template>
	
	<!-- structure du document -->
	<xsl:template name="miseEnPage">
		<fo:block>
			<xsl:call-template name="entete" />
		</fo:block>
		<fo:block >
			<xsl:call-template name="preambule" />
		</fo:block>
		<fo:block >
			<xsl:call-template name="infosEtuStage" />
		</fo:block>
		<fo:block >
			<xsl:call-template name="CPAM" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage2" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage3" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage4" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block >
			<xsl:call-template name="Charte" />
		</fo:block>
		<fo:block >
			<xsl:choose>
				<xsl:when test="document('config.xml')/config/triptik">
					<xsl:call-template name="triptik" />
				</xsl:when>
			</xsl:choose>
		</fo:block>
		
	</xsl:template>
	<xsl:include href="triptik.xsl"/>
	
	
	<!-- entete logo/ annee universitaire -->
	<xsl:template name="entete">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm"
			font-weight="bold">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell >
							<fo:block>
								<fo:external-graphic width="3cm"  height="1cm">
									<xsl:attribute name="src" >
										<xsl:value-of select="document('config.xml')/config/logoUniversite"/>
									</xsl:attribute>
								</fo:external-graphic>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block>
								<xsl:choose>
									<xsl:when test="centre-gestion/fichier/nom-fichier">
										<xsl:variable name="cheminLogo" select="document('config.xml')/config/uploadFiles.logosCentre.path" />
										<xsl:variable name="logo" select="centre-gestion/fichier/nom-fichier" />
											<fo:external-graphic height="1cm">
											<xsl:attribute name="src" >
												<xsl:value-of select="$cheminLogo"/><xsl:value-of select="centre-gestion/fichier/@id-fichier"/>_<xsl:value-of select="$logo"/>
											</xsl:attribute>
											</fo:external-graphic>
									</xsl:when>
									<xsl:otherwise>
									
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell width="3cm">
							<fo:block  width="3.493cm"
								line-height="110%" language="fr" country="FR" font-size="12pt">
								Ann�e universitaire
								<xsl:value-of select="annee" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
	
	<!-- partie preambule -->
	<xsl:template name="preambule">
		<fo:block line-height="110%" 
				hyphenate="false" language="fr" country="FR" font-size="12pt"
				font-family="Times New Roman,serif" text-align="justify">
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell >
						<fo:block line-height="110%" padding-top="5pt"
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">Convention de stage 
							<xsl:value-of select="type-convention/libelle" />
							<xsl:text> </xsl:text> n� <xsl:text> </xsl:text> <xsl:value-of select="id-convention" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
						</fo:block>
						<!--
						<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="8pt"
							font-family="Times New Roman,serif" text-align="justify">
							<fo:inline font-size="8pt" font-style="italic"
								font-weight="bold">
								<fo:inline text-decoration="underline">Pr�ambule : stages hors administrations et �tablissement publics de l'Etat�ne pr�sentant pas un caract�re industriel et commercial�: </fo:inline>
								Les signataires de la pr�sente convention de stage reconnaissent avoir pris connaissance de l'article 9 de la loi n�2006-396 
								pour l'�galit� des chances modifi�e, de ses d�crets d'application, de la loi n� 2009-1437 du 24 novembre 2009 relative � l'orientation et � la formation professionnelle tout au long de la vie ainsi que de la charte des stages (annexe 1). Ils en acceptent les principes.
								<fo:inline text-decoration="underline">stages en administrations et �tablissement publics de l'Etat�ne pr�sentant pas un caract�re industriel et commercial : </fo:inline>
								Les signataires de la pr�sente convention de stage reconnaissent avoir pris connaissance du d�cret 2009-885 du 21 juillet 2009 relatif aux modalit�s d'accueil des �tudiants de l'enseignement sup�rieur en stage dans les administrations et �tablissements publics de l'Etat 
								ne pr�sentant pas un caract�re industriel et commercial.
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
						</fo:block>
						-->
						<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">ENTRE</fo:inline>
						</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
		</fo:table>
	</xsl:template>
		<!-- partie Infos Etudiant - Stage -->
	<xsl:template name="infosEtuStage">
	
		<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(0.5)" />
				<fo:table-column column-width="proportional-column-width(0.5)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
					<fo:table-row margin-top="20px" text-align="left">
						<!-- partie Etablissement Superieur - Stage -->
							<fo:table-cell number-columns-spanned="3" padding-top="3pt" padding-bottom="3pt" padding-left="5pt" padding-right="5pt">
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									<fo:inline font-weight="bold">
										L'�tablissement d'enseignement sup�rieur :
									</fo:inline>
								</fo:block>
								
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Nom de l'�tablissement (universit�) : 
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when test="nom-etab-ref">
											<xsl:value-of select="nom-etab-ref" />
										</xsl:when>
										<xsl:otherwise>
											<xsl:value-of select="document('config.xml')/config/nomUniversite"/>
										</xsl:otherwise>
									</xsl:choose>
								</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Adresse : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="adresse-etab-ref">
												<xsl:value-of select="adresse-etab-ref" />
											</xsl:when>
											<xsl:otherwise>
												<xsl:value-of select="document('config.xml')/config/adresseUniversite"/> 
											</xsl:otherwise>
										</xsl:choose>
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Repr�sent� par : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="nom-signataire-composante">
												<xsl:value-of select="nom-signataire-composante" />
											</xsl:when>
											<xsl:otherwise>
												 
											</xsl:otherwise>
										</xsl:choose>
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Qualit� du repr�sentant : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="qualite-signataire">
												<xsl:value-of select="qualite-signataire" />
											</xsl:when>
											<xsl:otherwise>
												 .....................................
											</xsl:otherwise>
										</xsl:choose>
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Composante /UFR/ <xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										<xsl:value-of select="centre-gestion/nom-centre" />
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" >
								Adresse : (si diff�rente de celle de l'universit�) 
									<fo:inline font-weight="bold">
										<xsl:value-of select="centre-gestion/batiment-residence" /> 
										<xsl:text> </xsl:text> 
										<xsl:value-of select="centre-gestion/voie" /> 
										<xsl:text> </xsl:text> 
										<xsl:value-of select="centre-gestion/code-postal" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="centre-gestion/commune" />
									</fo:inline>
								</fo:block>
							</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" >
							T�l :
							<xsl:value-of select="centre-gestion/telephone" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm"  >
							fax : 
							<xsl:value-of select="centre-gestion/fax" /> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" >
							m�l : 
							<xsl:value-of select="centre-gestion/mail" />  
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<!-- partie Entreprise ou organisme accueil -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										<fo:inline font-weight="bold">
											L'organisme d'accueil� : 
										</fo:inline>
									</fo:block>
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Nom : 
									<fo:inline font-weight="bold">
										<xsl:value-of select="structure/raison-sociale" /> 
									</fo:inline>
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Adresse : 
										<fo:inline font-weight="bold">  
										<xsl:value-of select="structure/batiment-residence" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/voie" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/code-postal" />  
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/commune" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/pays/libelle" /> 
										</fo:inline> 
									</fo:block>
								
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							T�l :
							<xsl:value-of select="structure/telephone" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							fax : 
							<xsl:value-of select="structure/fax" /> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							m�l : 
							<xsl:value-of select="structure/mail" />  
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-left="5pt" padding-right="5pt">
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Repr�sent� par : (nom du signataire de la convention) : 
									<fo:inline font-weight="bold"> 
										<xsl:value-of select="signataire/civilite/libelle" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ��������������������������������������������������������������')" /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
										<xsl:variable name="prenom2" 
											select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Qualit� du repr�sentant : 
									<fo:inline font-weight="bold"> 
									 	<xsl:value-of select="signataire/fonction" />
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Nom du service dans lequel le stage sera effectu�  :
										<fo:inline font-weight="bold">
											<xsl:value-of select="service/nom" />
										</fo:inline>
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Lieu du stage : (si diff�rent de l'adresse de l'organisme d'accueil)  
										
										<xsl:if test="service/voie != structure/voie"> 
							 				<fo:inline font-weight="bold">
											<xsl:value-of select="service/batiment-residence" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/voie" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/code-postal" />  
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/commune" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/pays/libelle" /> 
											</fo:inline>
							 			</xsl:if>
							 			
									</fo:block>
							</fo:table-cell>
					</fo:table-row>
					<!-- partie Etudiant -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										<fo:inline font-weight="bold">
											Et l'�tudiant stagiaire :
										</fo:inline>
									</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell   padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Nom : 
							<fo:inline font-weight="bold">
								<xsl:value-of select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Pr�nom : 
							<fo:inline font-weight="bold">
								<xsl:variable name="prenom1" 
									select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
								<xsl:variable name="prenom2" 
									select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" > 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Sexe :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold"><xsl:value-of select="etudiant/code-sexe" /></fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							n�(e)le :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold"> 
							<xsl:value-of select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))"/> 
							</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row margin-top="20px" text-align="left">
						<fo:table-cell number-columns-spanned="3"  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Adresse : 
							<fo:inline font-weight="bold">
											<xsl:value-of select="adresse-etudiant" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="code-postal-etudiant" />  
											<xsl:text> </xsl:text>
											<xsl:value-of select="ville-etudiant" /> 
											<xsl:text> </xsl:text>
											<xsl:value-of select="pays-etudiant" /> 
							</fo:inline> 
							</fo:block>
							
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							T�l :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-etudiant" />
							</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							portable : 
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-portable-etudiant" />
							</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							m�l :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="etudiant/mail" />							
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
					<fo:table-row margin-top="20px" text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Intitul� de la formation ou cursus suivi dans l'�tablissement sup�rieur : 
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold"> 
								<xsl:value-of select="etape/libelle" /> 
							</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
			</fo:table-body>
		</fo:table>
		<fo:table table-layout="fixed" width="100%" border="0.018cm solid #000000">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
				
					<!-- partie sujet stage -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							SUJET DE STAGE : 
							<fo:inline font-size="11.5pt" font-weight="bold">
									<xsl:if test="tem-conf-sujet-teme != 'O'"> 
											<xsl:value-of select="sujet-stage" />
									 </xsl:if> 
									 <xsl:if test="tem-conf-sujet-teme = 'O'"> 
								 		Confidentiel
									 </xsl:if> 
								 </fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
								<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									DATES DE STAGE Du : 
									<fo:inline font-weight="bold">
										
										<xsl:value-of select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))"/> 
									</fo:inline>
									<xsl:text> </xsl:text> Au <xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										<xsl:value-of select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))"/> 
									</fo:inline>
									<xsl:if test="@interruption-stage = 'true'"> 
								 		<xsl:text> </xsl:text>
								 		avec interruption du : 
								 		<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))"/> 
										</fo:inline>
										<xsl:text> </xsl:text> au <xsl:text> </xsl:text>
										<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))"/> 
										</fo:inline>
									 </xsl:if>
								</fo:block>
							</fo:table-cell>
						
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="3pt" padding-bottom="3pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							DUREE DU STAGE : 
								<xsl:choose>
										<xsl:when test="duree-exceptionnelle">
											<xsl:if test="duree-exceptionnelle != ''"> 
		 										<fo:inline font-weight="bold">
													<xsl:value-of select="duree-exceptionnelle" /> <xsl:text> </xsl:text>   <xsl:value-of select="unite-duree/libelle" />
												</fo:inline>
											</xsl:if>
											<xsl:if test="duree-exceptionnelle = ''"> 
		 										<fo:inline font-weight="bold">
													<xsl:value-of select="duree-stage" /> 
												</fo:inline> 
											<xsl:text> </xsl:text> semaines 
											</xsl:if>
	       							    </xsl:when>
										<xsl:otherwise>
											<fo:inline font-weight="bold">
													<xsl:value-of select="duree-stage" /> 
											</fo:inline> 
											<xsl:text> </xsl:text> semaines 
										</xsl:otherwise>
									</xsl:choose>
  						   </fo:block>
						</fo:table-cell>
					</fo:table-row>
					
				</fo:table-body>
		</fo:table>
		<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
				
					<!-- partie Encadrement -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										<fo:inline font-weight="bold">
											Encadrement du stagiaire assur� par : 
										</fo:inline>
									</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							L'�tablissement d'enseignement sup�rieur en la personne de :  
							</fo:block>
							
							
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							L'organisme d'accueil en la personne de :     
							</fo:block>

						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Nom :  
							<fo:inline font-weight="bold"> 
									<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Nom :  
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							pr�nom :  
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Pr�nom :  
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Fonction :  
								<fo:inline font-weight="bold"> 
								<xsl:if test="enseignant/type-personne = 'ENS'"> 
							 		enseignant
							 	</xsl:if>
							 	<xsl:if test="enseignant/type-personne  != 'ENS'"> 
							 		personnel
							 	</xsl:if>
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Fonction :  
								<fo:inline font-weight="bold"> 
									 <xsl:value-of select="contact/fonction" />
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							T�l :  
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="enseignant/tel" />
							 	</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							T�l :  
								<fo:inline font-weight="bold">
								<xsl:value-of select="contact/tel" /> 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							M�l :  
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="enseignant/mail" />
							 	</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							M�l :  
								<fo:inline font-weight="bold">
								<xsl:value-of select="contact/mail" /> 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

					
				</fo:table-body>
		</fo:table>
		</xsl:template>
		<xsl:template name="CPAM">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(1)" />
							
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-top="2pt" padding-bottom="2pt">
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								Caisse primaire d'assurances maladie � contacter en cas 
								d'accident (lieu de domicile de l'�tudiant sauf exception) :
								<fo:inline font-weight="bold">
									<xsl:choose>
											<xsl:when test="libelle-cPAM">
												<xsl:value-of select="libelle-cPAM" />
											</xsl:when>
											<xsl:otherwise>
												 
											</xsl:otherwise>
									</xsl:choose> 
								</fo:inline> 
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								_____________________________________________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" >
									<fo:inline  font-size="5pt" vertical-align="super">1</fo:inline>
									<fo:inline font-size="8pt"> Article L612-9 du code de l'�ducation : " La dur�e du ou des stages effectu�s par un m�me stagiaire dans une m�me entreprise ne peut exc�der six mois par ann�e d'enseignement"
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" font-weight="bold" font-style="italic">
									<fo:inline  font-size="5pt" vertical-align="super">2</fo:inline>
									<fo:inline font-size="8pt"> Note de lecture : les caract�res gras et italiques s'appliquent aux 
									stages en administration et �tablissements publics de l'Etat.
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" padding-top="5pt">
								convention imprim�e le : <xsl:value-of select = "java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())"/>
								Exemplaire destin� � : organisme d'accueil / �tablissement d'origine / �tudiant. 
							</fo:block>

						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
		
	</xsl:template>
	<xsl:template name="ArticlesPage2">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Article 1 : Objet de la convention
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								La pr�sente convention r�gle les rapports de l'organisme d'accueil 
								entreprise, organisme public, association...) avec l'�tablissement d'enseignement sup�rieur et le stagiaire.
							</fo:block>
							
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Article 2 : Objectif du stage</fo:block>
								
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Le stage correspond � une p�riode temporaire 
								de mise en situation en milieu professionnel au cour de laquelle l'�tudiant acquiert des comp�tences professionnelles 
								qui mettent en oeuvre les acquis de sa formation en vue de l'obtention d'un dipl�me ou d'une certification. 
								Le stagiaire se voit confier une ou des missions conformes au projet p�dagogique d�fini par son �tablissement d'enseignement 
								et approuv�es par l'organisme d'accueil.</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Le programme
								du stage est �tabli par l'Etablissement et l'Organisme
								d'accueil en fonction du programme g�n�ral de la formation
								dispens�e.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">Activit�s confi�es :
								<fo:inline font-weight="bold">
									<xsl:value-of select="fonctions-et-taches" />
								</fo:inline>  
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-weight="bold">Article 3</fo:inline>
								<fo:inline font-weight="bold">: Modalit� du stage
								</fo:inline>
							</fo:block>
							
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								La dur�e hebdomadaire maximale de pr�sence du (de la) stagiaire dans
								l'entreprise sera de <fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" /> 
								</fo:inline> heures. Le stage est � 
								<fo:inline font-weight="bold">
									<xsl:value-of select="temps-travail/libelle" />
								</fo:inline>
								 (pr�ciser la quotit� :  
								<fo:inline font-weight="bold">
											<xsl:value-of select="quotite-travail" /> %)
								</fo:inline>
								 
								<xsl:choose>
										<xsl:when test="commentaire-duree-travail">
											<xsl:if test="commentaire-duree-travail != ''"> 
		 										(commentaire sur le temps de travail :  
												<fo:inline font-weight="bold">
													<xsl:value-of select="commentaire-duree-travail" /> )
												</fo:inline>
											</xsl:if>											
	       							    </xsl:when>		
								</xsl:choose>								
							</fo:block>
							
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Si le
								stagiaire doit �tre pr�sent dans l'Organisme d'accueil la nuit, le
								dimanche ou un jour f�ri�, l'Organisme doit indiquer
								ci-dessous les cas particuliers :<fo:inline font-weight="bold">
									<xsl:value-of select="travail-nuit-ferie" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Article 4 : Statut du stagiaire - Accueil
								et encadrement
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								L'�tudiant(e),pendant la dur�e de son stage dans l'Organisme d'accueil,
								conserve son statut ant�rieur; il (elle) est suivi(e) r�guli�rement 
								par l'Etablissement. L'Organisme nomme un
								<fo:inline font-style="italic">tuteur
									Organisme d'accueil
								</fo:inline>
								 charg� d'assurer le suivi
									et d'optimiser les conditions de r�alisation du
									stage. L'�tudiant(e) pourra revenir � l'Etablissement
									pendant la dur�e du stage, pour y suivre certains cours
									demand�s explicitement par le programme, participer � des
									r�unions, les dates �tant port�es � la connaissance de
									l'Organisme par l'Etablissementet �tre autoris�, le cas �ch�ant, � se d�placer.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Modalit�s
								d'encadrement :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-encadre-suivi" /> 
								</fo:inline>
							</fo:block>
							
							
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" keep-with-next="always"
								text-align="justify" font-weight="bold">Article 5 :
								Gratification - Avantages en nature Remboursement de frais
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Lorsque la dur�e du stage est sup�rieure � deux mois cons�cutifs ou non, 
								celui-ci fait obligatoirement l'objet d'une gratification, sur le territoire fran�ais, 
								sauf r�gles particuli�res applicables dans certaines collectivit�s d'outre-mer ou relevant 
								de l'article L4381-1 du code de la sant� publique.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								La gratification est fix�e par convention de branche ou accord professionnel, 
								� d�faut � 12,5 % du plafond horaire de la s�curit� sociale d�fini en application 
								de l'article L 241-3 du code de la s�curit� sociale. 
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Il est entendu que pour les stages en administration ou �tablissement 
								public administratif de l'Etat, la gratification est obligatoirement 
								�gale au plafond ci-dessus.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Lorsque la dur�e du stage est inf�rieure ou �gale � deux mois l'�tudiant(e) 
								peut percevoir une gratification, en entreprise priv�e ou publique, 
								en association, sur le territoire fran�ais. 
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Montant de la gratification (si diff�rent du montant l�gal ) :
								<xsl:variable name="nb-montant-gratification" select="montant-gratification" />
								<xsl:choose>
									<xsl:when test='$nb-montant-gratification=""'>
 
       							    </xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
												<xsl:value-of select="montant-gratification" /> 
											</fo:inline> euros <xsl:text> </xsl:text> <xsl:value-of select="unite-gratification/libelle" /> par mois
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Modalit�s de versement de la gratification :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-vers-gratification/libelle" /> 
								</fo:inline>
							</fo:block>					
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Si le(la) stagiaire b�n�ficie d'avantages en nature (gratuit� des repas par exemple), 
								le montant repr�sentant la valeur de ces avantages sera ajout� au montant de la gratification 
								mensuelle avant comparaison aux 12,5% du plafond horaire de la s�curit� sociale pour une dur�e 
								l�gale de travail hebdomadaire de 35 heures.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les frais de d�placement et d'h�bergement engag�s par l'�tudiant(e) � la demande de l'organisme, 
								ainsi que les frais de formation �ventuellement n�cessit�s par le stage, seront int�gralement 
								pris en charge par celui-ci selon les modalit�s en vigueur dans l'organisme.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Liste des avantages offerts : <fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les stagiaires acc�dent aux activit�s sociales et culturelles mentionn�es � l'article L2323-83 du code du travail dans les m�mes conditions que les salari�s
							</fo:block>							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
										font-weight="bold">
								Lorsqu'il se d�roule en administration ou �tablissement public administratif de l'Etat, 
								l'�tudiant(e) verra ses frais de missions pris en charge conform�ment au d�cret 2006-781, 
								avec comme r�sidence administrative le lieu de stage. 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
										font-weight="bold">
								Pour les stages en administration ou �tablissement public administratif de l'�tat : 
								prise en charge des trajets domicile - lieu de stage, selon les conditions des d�crets 82-887 et
								2006-1663 : ...................(indiquer oui ou non)
							</fo:block>
							
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">Article 6 : Protection sociale
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Pendant la dur�e du stage, l'�tudiant(e) reste affili�(e) � son syst�me de s�curit� sociale ant�rieur : 
								il(elle) conserve son statut �tudiant. Les stages effectu�s � l'�tranger doivent avoir �t� signal�s pr�alablement 
								au d�part de l'�tudiant(e) et avoir re�u l'agr�ment de la S�curit� Sociale.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les dispositions suivantes sont applicables sous r�serve de conformit� 
								avec la l�gislation du pays d'accueil et de celle r�gissant le type d'organisme d'accueil :
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.1 Gratification inf�rieure ou �gale</fo:inline>
									au produit de 12,5% du plafond horaire de la s�curit� sociale par le nombre d'heures 
									de stage effectu�es au cours du mois consid�r� :
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Dans ce cas, conform�ment � la l�gislation en vigueur, la gratification de stage n'est pas 
								soumise � cotisation sociale.
								L'�tudiant(e) continue � b�n�ficier de la l�gislation sur les accidents de travail au titre de 
								l'article L 412-8-2 du code de la S�curit� Sociale, r�gime �tudiant
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								En cas d'accident survenant � l'�tudiant(e), soit au cours des travaux dans l'organisme, 
								soit au cours du trajet, soit sur les lieux rendus utiles pour les besoins de son stage
								<fo:inline font-size="10pt" font-style="italic">
								et pour les �tudiant(e)s en m�decine, en chirurgie dentaire ou en pharmacie qui n'ont pas un statut hospitalier, 
								du stage hospitalier effectu� dans les conditions pr�vues au b du 2o de l'article L. 412-8,
								</fo:inline>
								<fo:inline font-size="10pt" font-weight="bold">
								l'organisme d'accueil envoie la d�claration � la 
								</fo:inline> 
								Caisse Primaire d'Assurance Maladie (voir adresse en premi�re page) en mentionnant l'�tablissement comme employeur,
								<fo:inline font-size="10pt" font-weight="bold">
								avec copie � l'�tablissement. 
								</fo:inline> 
							</fo:block>
							
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.2 Gratification sup�rieure </fo:inline>
									au produit de 12,5% du plafond horaire de la s�curit� sociale par le nombre d'heures 
									de stage effectu�es au cours du mois consid�r� :
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les cotisations sociales sont calcul�es sur le diff�rentiel entre le montant de la gratification 
								et 12.5% du plafond horaire de la S�curit� Sociale pour une dur�e l�gale de travail hebdomadaire de 35 heures.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'�tudiant(e) b�n�ficie de la couverture l�gale en application des dispositions des articles L 411-1 
								et suivants du code de la S�curit� Sociale. En cas d'accident survenant � l'�tudiant(e), soit au cours 
							</fo:block>
							
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
	<!-- troisieme page -->
	
	<xsl:template name="ArticlesPage3">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-right="10pt">
								
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									des travaux dans l'organisme, soit au cours du trajet, soit sur des lieux rendus utiles 
									pour les besoins de son stage, l'organisme d'accueil effectue toutes les d�marches n�cessaires 
									aupr�s de la Caisse Primaire d'Assurance Maladie et informe l'�tablissement dans les meilleurs d�lais.
								</fo:block>
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.3 Protection Maladie du stagiaire � l'�tranger :</fo:inline>
							</fo:block>
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									1) Protection issue du r�gime �tudiant(e) fran�ais :
							</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Pour les stages au sein de l'Espace Economique Europ�en (EEE)
									effectu�s par les �tudiant(e)s de nationalit� d'un pays membre 
									de l'Union Europ�enne, il faut demander la Carte Europ�enne d'Assurance Maladie <fo:inline font-size="10pt" text-decoration="underline">(CEAM).</fo:inline>
								</fo:block>
								
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Pour les stages effectu�s au Qu�bec par les �tudiant(e)s de
									nationalit� fran�aise, il faut demander le formulaire <fo:inline font-size="10pt" text-decoration="underline">SE401Q</fo:inline> (104 
									pour les stages en entreprise, 106 pour les stages en universit�).
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:inline font-size="10pt" text-decoration="underline">- Dans tous les autres cas de figure :</fo:inline>
									Les �tudiant(e)s qui engagent des frais de sant� � l'�tranger 
									peuvent �tre rembours�(e)s aupr�s de la mutuelle qui leur tient lieu 
									de Caisse de S�curit� Sociale �tudiante, au retour, et sur 
									pr�sentation des justificatifs : le remboursement s'effectue alors sur 
									la base des tarifs de soins fran�ais, des �carts importants peuvent exister.

								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								� Il est donc fortement recommand� � l'�tudiant(e) de souscrire une 
								assurance Maladie compl�mentaire sp�cifique, valable pour le pays
								et la dur�e du stage, aupr�s de l'Organisme de son choix (mutuelle 
								�tudiante, mutuelle des parents, compagnie priv�e ad hoc...).
							</fo:block>
							
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								
								<fo:inline font-size="10pt" text-decoration="underline">� Exception </fo:inline> : si l'Organisme fournit � l'�tudiant(e) une couverture 
								Maladie en vertu des dispositions du droit local (voir 2 ci-dessous),
								alors l'�tudiant(e) peut choisir de b�n�ficier de cette protection 
								Maladie locale. Avant d'effectuer un tel choix, il v�rifiera l'�tendue 
								des garanties propos�es.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-style="italic">2) Protection issue de l'Organisme :</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-style="italic">En cochant la case appropri�e, 
									l'Organisme indique ci-apr�s s'il 
									fournit une protection Maladie au stagiaire, en vertu du droit 
									local :
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" /> <fo:inline font-size="10pt" font-weight="bold">OUI</fo:inline> (celle-ci s'ajoute au maintien, � l'�tranger, des droits issus 
								du r�gime fran�ais �tudiant(e))
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" /> <fo:inline font-size="10pt" font-weight="bold">NON</fo:inline> (la protection d�coule alors exclusivement du maintien, � 
								l'�tranger, des droits issus du r�gime fran�ais �tudiant(e))
								Si aucune case n'est coch�e, le 6.3 1/ s'applique.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.4 Protection Accident du Travail du stagiaire � l'�tranger :</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									1)	Pour pouvoir b�n�ficier de la l�gislation fran�aise sur la 
									couverture accident de travail, le pr�sent stage doit :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Etre d'une dur�e au plus �gale � 12 mois, prolongations incluses.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Ne donner lieu � aucune r�mun�ration susceptible 
									d'ouvrir des droits � une protection accident de travail 
									dans le pays �tranger (une indemnit� ou gratification est 
									admise � hauteur de 12,5% du plafond horaire de la 
									s�curit� sociale pour une dur�e l�gale hebdomadaire de 
									35 heures sous r�serve de l'accord de la Caisse Primaire 
									d'Assurance Maladie).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Se d�rouler exclusivement dans l'entreprise partie � la pr�sente convention.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Se d�rouler exclusivement dans le pays �tranger cit�.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Lorsque les conditions ne sont pas remplies, l'Organisme d'accueil s'engage
									� cotiser pour la protection du stagiaire et � faire les d�clarations 
									n�cessaires en cas d'accident de travail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									2)  La d�claration des accidents de travail incombe � 
									l'Etablissement qui doit �tre inform� par l'Organisme 
									par �crit dans un d�lai de 48 heures.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									3)	La couverture concerne les accidents survenus :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Dans l'enceinte du lieu du stage et aux heures de stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Sur le trajet aller retour habituel entre la r�sidence du 
									stagiaire sur le territoire �tranger et le lieu du stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Sur le trajet aller retour (d�but et fin de stage) du 
									domicile du stagiaire situ� sur le territoire fran�ais et le 
									lieu de r�sidence � l'�tranger.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Dans le cadre d'une mission confi�e par l'Organisme et obligatoirement sur ordre de mission.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									4)	Pour le cas o� l'une seule des conditions pr�vues au point 
									6.4 1/ n'est pas remplie, l'Organisme s'engage par la 
									pr�sente convention � couvrir le stagiaire contre le risque 
									d'accident de travail, de trajet et les maladies 
									professionnelles et � en assurer toutes les d�clarations n�cessaires.
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								5)	dans tous les cas,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								-	Si l'�tudiant(e) est victime d'un accident du travail 
								durant le stage, l'Organisme d'accueil doit 
								imp�rativement signaler <fo:inline font-size="10pt" text-decoration="underline">imm�diatement</fo:inline> cet accident � 
								l'Etablissement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								-	Si l'�tudiant(e) remplit des missions limit�es en-dehors 
								de l'Organisme d'accueil ou en en-dehors du pays du 
								stage, l'Organisme doit prendre toutes les dispositions 
								n�cessaires pour lui fournir les assurances appropri�es.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" 
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 7 : Responsabilit� civile et assurances
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								L'Organisme d'accueil et l'�tudiant(e) d�clarent �tre garantis au 
								titre de la responsabilit� civile.
								Quelle que soit la nature du stage et le pays de destination, le 
								stagiaire s'engage � se couvrir par un contrat d'assistance (
								rapatriement sanitaire, assistance juridique etc.) et par un contrat 
								d'assurance individuel accident.
								Lorsque l'Organisme met un v�hicule � la disposition du stagiaire, 
								il lui incombe de v�rifier pr�alablement que la police d'assurance 
								du v�hicule couvre son utilisation par un �tudiant(e).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Lorsque dans le cadre de son stage, l'�tudiant(e) utilise son propre 
								v�hicule ou un v�hicule, pr�t� par un tiers, il d�clare express�ment 
								� l'assureur dudit v�hicule cette utilisation qu'il est amen� � faire 
								et le cas �ch�ant s'acquitte de la prime y aff�rente.
								</fo:inline>
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 8 : Discipline
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Durant son stage, l'�tudiant(e) est soumis � la discipline et au 
								r�glement int�rieur (qui doit �tre port� � la connaissance de 
								l'�tudiant-e) de l'organisme, notamment en ce qui concerne les 
								horaires, et les r�gles d'hygi�ne et de s�curit� en vigueur dans 
								l'organisme d'accueil.
								Toute sanction disciplinaire ne peut �tre d�cid�e que par 
								l'Etablissement. Dans ce cas, l'Organisme informe l'Etablissement 
								des manquements et lui fournit �ventuellement les �l�ments 
								constitutifs.
								En cas de manquement particuli�rement grave � la discipline, 
								l'Organisme se r�serve le droit de mettre fin au stage de 
								l'�tudiant(e) tout en respectant les dispositions fix�es � l'article 9 
								de la pr�sente convention.

							</fo:block>
											
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
		<!-- quatrieme page -->
	
	<xsl:template name="ArticlesPage4">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-right="10pt">
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 9 : Absence et Interruption du stage
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Toute difficult� survenue dans le d�roulement du stage devra �tre port�e 
								� la connaissance de tous les int�ress�s afin d'�tre r�solue au plus vite.

							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interruption temporaire :
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Au cours du stage, le stagiaire pourra b�n�ficier de cong�s 
								sous r�serve d'accord de l'organisme d'accueil et que la dur�e du stage 
								soit respect�e.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Pour toute autre interruption temporaire du stage (maladie, maternit�, 
								absence injustifi�e...) l'organisme d'accueil avertira le responsable de l'�tablissement par courrier.
							</fo:block>
											
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interruption d�finitive :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								<fo:inline font-size="10pt" font-weight="bold">
								En cas de volont� d'une des trois parties (Organisme, 
								Etablissement, �tudiant(e)) d'interrompre d�finitivement le 
								stage, 
								</fo:inline>, celle-ci devra imm�diatement en informer les deux autres 
								parties par �crit. Les raisons invoqu�es seront examin�es en �troite 
								concertation. La d�cision d�finitive d'interruption du stage ne sera 
								prise qu'� l'issue de cette phase de concertation.
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 10 : Devoir de r�serve et confidentialit�
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Le devoir de r�serve est de rigueur absolue. Les �tudiant(e)s 
								stagiaires prennent donc l'engagement de n'utiliser en aucun cas 
								les informations recueillies ou obtenues par eux pour en faire 
								l'objet de publication, communication � des tiers sans accord 
								pr�alable de l'Organisme, y compris le rapport de stage. Cet 
								engagement vaudra non seulement pour la dur�e du stage mais 
								�galement apr�s son expiration. L'�tudiant(e) s'engage � ne 
								conserver, emporter, ou prendre copie d'aucun document ou 
								logiciel, de quelque nature que ce soit, appartenant � l'Organisme, 
								sauf accord de ce dernier.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Nota : Dans le cadre de la confidentialit� des informations contenues dans 
								le rapport, l'Organisme peut demander une restriction de la diffusion du 
								rapport, voire le retrait de certains �l�ments tr�s confidentiels.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Les personnes amen�es � en conna�tre sont contraintes par le secret 
								professionnel � n'utiliser ni ne divulguer les informations du rapport. 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 11 : Propri�t� intellectuelle
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Conform�ment au code de la propri�t� intellectuelle, si le travail du 
									stagiaire donne lieu � la cr�ation d'une oeuvre prot�g�e par le droit 
									d'auteur ou la propri�t� industrielle (y compris un logiciel), si 
									l'organisme d'accueil souhaite l'utiliser et que le stagiaire est 
									d'accord, un contrat devra �tre sign� entre le stagiaire (auteur) et l'organisme d'accueil.
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Devront notamment �tre pr�cis�s l'�tendue des droits c�d�s, 
									l'�ventuelle exclusivit�, la destination, les supports utilis�s et la dur�e 
									de la cession, ainsi que, le cas �ch�ant, le montant 
									de la r�mun�ration due � l'�tudiant au titre de la cession.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">
								Cette clause s'applique �galement dans le cas des stages dans les Organismes publics.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>		
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 12 : Recrutement
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									S'il advenait qu'un contrat de travail prenant effet avant la date de fin 
									du stage soit sign� avec l'organisme d'accueil la pr�sente convention 
									deviendrait caduque ; l' � �tudiant(e) � ne rel�verait plus de la 
									responsabilit� de l'�tablissement d'enseignement. Ce dernier devrait imp�rativement 
									en �tre averti avant la signature du contrat.
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 13 : Fin de stage - Rapport - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									A l'issue du stage, l'organisme d'accueil d�livre au stagiaire une 
									attestation de stage et remplit une fiche d'�valuation  de l'activit� du 
									stagiaire (annexe) qu'il retourne � l'�tablissement d'enseignement 
									sup�rieur.
							</fo:block>		
						</fo:table-cell>
						<fo:table-cell >														
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								A l'issue de son stage l'�tudiant devra : (pr�ciser la nature de travail � fournir, en joignant �ventuellement une annexe)
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Pr�ciser le cas �ch�ant les modalit�s de validation du stage accompli par l'�tudiant : 
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								Nombre de cr�dits ECTS : 
								<xsl:choose>
									<xsl:when test='$nb-credit=0.00'>
 
       							    </xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
											<xsl:value-of select="credit-eCTS" /> 
										</fo:inline>
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Evaluation de la qualit� du stage : A l'issue du stage, les trois parties 
								int�ress�es sont invit�es � formuler une appr�ciation sur la qualit� 
								du stage.
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Le tuteur organisme d'accueil ou tout autre membre de l'organisme 
								d'accueil appel� � se rendre � l'�tablissement dans le cadre de la 
								pr�paration, du d�roulement et de la validation du stage ne peut 
								pr�tendre � une quelconque prise en charge ou indemnisation de la 
								part de l'�tablissement.
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Un avenant � la convention pourra �ventuellement �tre �tabli en cas 
								de prolongation de stage faite � la demande de l'organisme et de 
								l'�tudiant(e). En aucun cas la date de fin de stage ne pourra �tre 
								post�rieure au 30/09 de l'ann�e en cours.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								L'accueil successif de stagiaires, au titre de conventions de stage diff�rentes, 
								pour effectuer des stages dans un m�me poste n'est possible qu'� l'expiration d'un d�lai de carence 
								�gal au tiers de la dur�e du stage pr�c�dent. Cette disposition n'est pas applicable lorsque ce stage 
								pr�c�dent a �t� interrompu avant son terme � l'initiative du stagiaire.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 14 : Droit applicable - Tribunaux comp�tents
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La pr�sente convention est r�gie exclusivement par le droit fran�ais. 
								Tout litige non r�solu par voie amiable sera soumis � la comp�tence 
								de la juridiction fran�aise comp�tente.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								A ....................................... le .......................................
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Pour l'�tablissement d'enseignement sup�rieur 
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="nom-signataire-composante">											
									</xsl:when>
									<xsl:otherwise>											
											(Nom et signature du repr�sentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								
								<xsl:choose>
									<xsl:when test="centre-gestion/nom-viseur">
									Par d�l�gation,
										<fo:inline font-weight="bold">			
											<xsl:variable name="prenom1" 
												select="translate(substring(./centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
											<xsl:variable name="prenom2" 
											select="translate(centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
											<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>											
											<xsl:text> </xsl:text> 
											<xsl:value-of select="translate(centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 											
										</fo:inline> 
									</xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
											<xsl:value-of select="nom-signataire-composante" />
										</fo:inline>
									</xsl:otherwise>
								</xsl:choose> 																		
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Pour l'organisme d'accueil :
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="signataire/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Nom et signature du repr�sentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Pour l'�tudiant
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="etudiant/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Nom et signature )
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />  
								</fo:inline> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								<fo:inline text-decoration="underline">VISAS DES TUTEURS : </fo:inline>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Tuteur Organisme d'accueil
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="contact/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Nom et signature du repr�sentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Tuteur Etablissement d'enseignement sup�rieur
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="enseignant/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Nom et signature du repr�sentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
		<xsl:template name="Charte">
		<fo:block line-height="110%" 
				hyphenate="false" language="fr" country="FR" font-size="10pt"
				font-family="Times New Roman,serif" text-align="justify">
		
			<fo:table table-layout="fixed" width="100%">
					<fo:table-column column-width="proportional-column-width(1)" />
					
					<fo:table-body>
						<fo:table-row >
							<fo:table-cell >
								<fo:block line-height="110%" padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="center">
								<fo:inline font-weight="bold">CHARTE DES STAGES ETUDIANTS EN ENTREPRISE 
								</fo:inline>  
								</fo:block>
								<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader/>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre de l'Emploi, de la Coh�sion sociale et du Logement
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre de l'Education nationale, de l'Enseignement sup�rieur et de la Recherche
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre d�l�gu� � l'Emploi, au Travail et � l'Insertion professionnelle des jeunes
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre d�l�gu� � l'Enseignement sup�rieur et � la Recherche
								</fo:block>
	
								<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader/>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
			</fo:table>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif"
				margin-left="0cm" margin-right="0cm" text-indent="0cm">
				<fo:table table-layout="fixed" width="100%">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row >
							<fo:table-cell padding-right="10pt">
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">I - INTRODUCTION
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Le d�veloppement des stages est aujourd'hui fondamental en 
									mati�re d'orientation et d'insertion professionnelle des jeunes.
									En effet, le stage permet la mise en oeuvre de connaissances 
									th�oriques dans un cadre professionnel et donne � l'�tudiant une 
									exp�rience du monde de l'entreprise et de ses m�tiers. Dans cette 
									perspective, il est fondamental de rappeler que les stages ont une 
									finalit� p�dagogique, ce qui signifie qu'il ne peut y avoir de stage 
									hors parcours p�dagogique. En aucun cas un stage ne peut �tre 
									consid�r� comme un emploi. La pr�sente charte, qui a �t� r�dig�e 
									par les services de l'Etat, les repr�sentants des entreprises, les 
									repr�sentants des �tablissements d'enseignement sup�rieur, et les 
									repr�sentants des �tudiants, a d�s lors pour objectif de s�curiser la 
									pratique des stages, tout en favorisant leur d�veloppement 
									b�n�fique � la fois pour les jeunes et pour les entreprises.
								</fo:block>
								<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader/>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">II - CHAMPS, DEFINITION
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">1 - Le champ de la charte
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Le champ de la charte concerne tous les stages d'�tudiants en 
									entreprise, sans pr�judice des r�gles particuli�res applicables aux
									professions r�glement�es.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - Le stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									La finalit� du stage s'inscrit dans un projet p�dagogique et n'a de 
									sens que par rapport � ce projet. D�s lors le stage :
									- permet la mise en pratique des connaissances en milieu 
									professionnel ;
									- facilite le passage du monde de l'enseignement sup�rieur � celui 
									de l'entreprise.
									Le stage ne peut en aucun cas �tre assimil� � un emploi.
								</fo:block>
								<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader/>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">III - ENCADREMENT DU STAGE
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">1 - La formalisation du projet de stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Le projet de stage fait l'objet d'une concertation entre un
									enseignant de l'�tablissement, un membre de l'entreprise et
									l'�tudiant. Ce projet de stage est formalis� dans la convention
									sign�e par l'�tablissement d'enseignement, l'entreprise et le
									stagiaire.    
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - La convention
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									La convention pr�cise les engagements et les responsabilit�s de 
									l'�tablissement d'enseignement, de l'entreprise et de l'�tudiant. Les 
									rubriques obligatoires sont mentionn�es en annexe � la charte.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">3 - Dur�e du stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									La dur�e du stage est pr�cis�e d�s les premiers contacts entre  
									l'�tablissement d'enseignement et l'entreprise. L'�tudiant en est 
									tenu inform�. La dur�e du stage figure explicitement dans la 
									convention de stage.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">4 - Les responsables de l'encadrement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Tout stage fait l'objet d'un double encadrement par :  
									- un enseignant de l'�tablissement ;
									- un membre de l'entreprise.
									L'enseignant et le membre de l'entreprise travaillent en 
									collaboration, sont inform�s et s'informent de l'�tat d'avancement 
									du stage et des difficult�s �ventuelles. Le responsable du stage au 
									sein de l'�tablissement d'enseignement est le garant de
									l'articulation entre les finalit�s du cursus de formation et celles du 
									stage, selon les principes de la pr�sente charte. Leurs institutions 
									respectives reconnaissent la n�cessit� de leur investissement, 
									notamment en temps, consacr� � l'encadrement. 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">5 - Evaluation
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify" font-style="italic"
									font-weight="bold">a - Evaluation du stagiaire
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'activit� du stagiaire fait l'objet d'une �valuation qui r�sulte de la 
									double appr�ciation des responsables de l'encadrement du stage.
									Chaque �tablissement d'enseignement d�cide de la valeur qu'il
									accorde aux stages pr�vus dans le cursus p�dagogique.  
								</fo:block>
							</fo:table-cell>
							<fo:table-cell >
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									 Les modalit�s concr�tes d'�valuation sont mentionn�es dans la
									convention. L'�valuation est port�e dans une "fiche d'�valuation" 
									qui, avec la convention, constitue le "dossier de stage". Ce
									dossier de stage est conserv� par l'�tablissement d'enseignement. 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify" font-style="italic"
									font-weight="bold">b - Evaluation du stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Les signataires de la convention sont invit�s � formuler une 
									appr�ciation de la qualit� du stage.
								</fo:block>
								<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader/>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">IV - ENGAGEMENT DES PARTIES
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">1 - L'�tudiant vis-�-vis de l'entreprise
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'�tudiant s'engage � :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- r�aliser sa mission et �tre disponible pour les t�ches qui lui sont 
									confi�es ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- respecter les r�gles de l'entreprise ainsi que ses codes et sa
									culture ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- respecter les exigences de confidentialit� fix�es par l'entreprise ; 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- r�diger, lorsqu'il est exig�, le rapport ou le m�moire dans les
									d�lais pr�vus ; ce document devra �tre pr�sent� aux responsables 
									de l'entreprise avant d'�tre soutenu <fo:inline font-style="italic">
									(si le contenu le n�cessite, le 
									m�moire poura, � la demande de l'entreprise, rester confidentiel).
									</fo:inline> 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - L'entreprise vis-�-vis de l'�tudiant
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'entreprise s'engage � : 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- proposer un stage s'inscrivant dans le projet p�dagogique d�fini 
									par l'�tablissement d'enseignement ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- accueillir l'�tudiant et lui donner les moyens de r�ussir sa mission 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- d�signer un responsable de stage ou une �quipe tutorale dont la 
									t�che sera de :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* guider et conseiller l'�tudiant 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* l'informer sur les r�gles, les codes et la culture de l'entreprise
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* favoriser son int�gration au sein de l'entreprise et l'acc�s aux 
									informations n�cessaires 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* l'aider dans l'acquisition des comp�tences n�cessaires 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* assurer un suivi r�gulier de ses travaux  
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									*  �valuer la qualit� du travail effectu� 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									*  le conseiller sur son projet professionnel 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- r�diger une attestation de stage d�crivant les missions effectu�es
									qui pourra accompagner les futurs <fo:inline font-style="italic">
									curriculum vitae </fo:inline>  de l'�tudiant. 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">3 - L'�tablissement d'enseignement sup�rieur vis-�-vis de l'�tudiant
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'�tablissement d'enseignement s'engage � :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- d�finir les objectifs du stage et s'assurer que le stage propos� y r�pond ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- accompagner l'�tudiant dans la recherche de stage ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- pr�parer l'�tudiant au stage ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- assurer le suivi de l'�tudiant pendant la dur�e de son stage, en lui 
									affectant un enseignant qui veillera au bon d�roulement du stage ; 
									mettre � la disposition de ce dernier les outils n�cessaires � 
									l'appr�ciation de la qualit� du stage par l'�tudiant ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- pour les formations sup�rieures qui l'exigent, le guider et le 
									conseiller dans la r�alisation de son rapport de stage ou de son 
									m�moire et organiser la soutenance en permettant � un 
									repr�sentant de l'entreprise d'y participer.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">4 - L'entreprise et l'�tablissement d'enseignement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'entreprise et l'�tablissement d'enseignement sup�rieur veillent � 
									�changer les informations n�cessaires avant, pendant et apr�s le 
									stage. Ils respectent par ailleurs leurs r�gles respectives de 
									confidentialit� et de d�ontologie.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">5 - L'�tudiant vis � vis des �tablissements d'enseignement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'�tudiant s'engage � fournir l'appr�ciation de la qualit� de son 
									stage � son �tablissement d'enseignement.
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
	
			</fo:block>
		</fo:block>
		<xsl:choose>
				<xsl:when test="document('config.xml')/config/triptik">
					
				</xsl:when>
				<xsl:otherwise>
					<fo:block id="theEnd" />
				</xsl:otherwise>
		</xsl:choose>	
	</xsl:template>
	
</xsl:stylesheet>