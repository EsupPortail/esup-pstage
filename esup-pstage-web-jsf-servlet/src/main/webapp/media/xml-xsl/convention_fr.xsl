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
								Année universitaire
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
							<xsl:text> </xsl:text> n° <xsl:text> </xsl:text> <xsl:value-of select="id-convention" />
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
								<fo:inline text-decoration="underline">Préambule : stages hors administrations et établissement publics de l'Etat ne présentant pas un caractère industriel et commercial : </fo:inline>
								Les signataires de la présente convention de stage reconnaissent avoir pris connaissance de l'article 9 de la loi n°2006-396 
								pour l'égalité des chances modifiée, de ses décrets d'application, de la loi n° 2009-1437 du 24 novembre 2009 relative à l'orientation et à la formation professionnelle tout au long de la vie ainsi que de la charte des stages (annexe 1). Ils en acceptent les principes.
								<fo:inline text-decoration="underline">stages en administrations et établissement publics de l'Etat ne présentant pas un caractère industriel et commercial : </fo:inline>
								Les signataires de la présente convention de stage reconnaissent avoir pris connaissance du décret 2009-885 du 21 juillet 2009 relatif aux modalités d'accueil des étudiants de l'enseignement supérieur en stage dans les administrations et établissements publics de l'Etat 
								ne présentant pas un caractère industriel et commercial.
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
										L'établissement d'enseignement supérieur :
									</fo:inline>
								</fo:block>
								
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Nom de l'établissement (université) : 
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
								Représenté par : 
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
								Qualité du représentant : 
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
								Adresse : (si différente de celle de l'université) 
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
							Tél :
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
							mél : 
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
											L'organisme d'accueil  : 
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
							Tél :
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
							mél : 
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
									Représenté par : (nom du signataire de la convention) : 
									<fo:inline font-weight="bold"> 
										<xsl:value-of select="signataire/civilite/libelle" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Qualité du représentant : 
									<fo:inline font-weight="bold"> 
									 	<xsl:value-of select="signataire/fonction" />
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Nom du service dans lequel le stage sera effectué  :
										<fo:inline font-weight="bold">
											<xsl:value-of select="service/nom" />
										</fo:inline>
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Lieu du stage : (si différent de l'adresse de l'organisme d'accueil)  
										
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
											Et l'étudiant stagiaire :
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
								<xsl:value-of select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Prénom : 
							<fo:inline font-weight="bold">
								<xsl:variable name="prenom1" 
									select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								<xsl:variable name="prenom2" 
									select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
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
							né(e)le :  
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
							Tél :  
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
							mél :  
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
							Intitulé de la formation ou cursus suivi dans l'établissement supérieur : 
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
											Encadrement du stagiaire assuré par : 
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
							L'établissement d'enseignement supérieur en la personne de :  
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
									<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
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
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
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
							prénom :  
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Prénom :  
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
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
							Tél :  
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
							Tél :  
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
							Mél :  
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
							Mél :  
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
								Caisse primaire d'assurances maladie à contacter en cas 
								d'accident (lieu de domicile de l'étudiant sauf exception) :
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
									<fo:inline font-size="8pt"> Article L612-9 du code de l'éducation : " La durée du ou des stages effectués par un même stagiaire dans une même entreprise ne peut excéder six mois par année d'enseignement"
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" font-weight="bold" font-style="italic">
									<fo:inline  font-size="5pt" vertical-align="super">2</fo:inline>
									<fo:inline font-size="8pt"> Note de lecture : les caractères gras et italiques s'appliquent aux 
									stages en administration et établissements publics de l'Etat.
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" padding-top="5pt">
								convention imprimée le : <xsl:value-of select = "java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())"/>
								Exemplaire destiné à : organisme d'accueil / établissement d'origine / étudiant. 
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
								La présente convention règle les rapports de l'organisme d'accueil 
								entreprise, organisme public, association...) avec l'établissement d'enseignement supérieur et le stagiaire.
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
								font-family="Times New Roman,serif" text-align="justify">Le stage correspond à une période temporaire 
								de mise en situation en milieu professionnel au cour de laquelle l'étudiant acquiert des compétences professionnelles 
								qui mettent en oeuvre les acquis de sa formation en vue de l'obtention d'un diplôme ou d'une certification. 
								Le stagiaire se voit confier une ou des missions conformes au projet pédagogique défini par son établissement d'enseignement 
								et approuvées par l'organisme d'accueil.</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Le programme
								du stage est établi par l'Etablissement et l'Organisme
								d'accueil en fonction du programme général de la formation
								dispensée.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">Activités confiées :
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
								<fo:inline font-weight="bold">: Modalité du stage
								</fo:inline>
							</fo:block>
							
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								La durée hebdomadaire maximale de présence du (de la) stagiaire dans
								l'entreprise sera de <fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" /> 
								</fo:inline> heures. Le stage est à 
								<fo:inline font-weight="bold">
									<xsl:value-of select="temps-travail/libelle" />
								</fo:inline>
								 (préciser la quotité :  
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
								stagiaire doit être présent dans l'Organisme d'accueil la nuit, le
								dimanche ou un jour férié, l'Organisme doit indiquer
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
								L'étudiant(e),pendant la durée de son stage dans l'Organisme d'accueil,
								conserve son statut antérieur; il (elle) est suivi(e) régulièrement 
								par l'Etablissement. L'Organisme nomme un
								<fo:inline font-style="italic">tuteur
									Organisme d'accueil
								</fo:inline>
								 chargé d'assurer le suivi
									et d'optimiser les conditions de réalisation du
									stage. L'étudiant(e) pourra revenir à l'Etablissement
									pendant la durée du stage, pour y suivre certains cours
									demandés explicitement par le programme, participer à des
									réunions, les dates étant portées à la connaissance de
									l'Organisme par l'Etablissementet être autorisé, le cas échéant, à se déplacer.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Modalités
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
								Lorsque la durée du stage est supérieure à deux mois consécutifs ou non, 
								celui-ci fait obligatoirement l'objet d'une gratification, sur le territoire français, 
								sauf règles particulières applicables dans certaines collectivités d'outre-mer ou relevant 
								de l'article L4381-1 du code de la santé publique.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								La gratification est fixée par convention de branche ou accord professionnel, 
								à défaut à 12,5 % du plafond horaire de la sécurité sociale défini en application 
								de l'article L 241-3 du code de la sécurité sociale. 
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Il est entendu que pour les stages en administration ou établissement 
								public administratif de l'Etat, la gratification est obligatoirement 
								égale au plafond ci-dessus.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Lorsque la durée du stage est inférieure ou égale à deux mois l'étudiant(e) 
								peut percevoir une gratification, en entreprise privée ou publique, 
								en association, sur le territoire français. 
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Montant de la gratification (si différent du montant légal ) :
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
								Modalités de versement de la gratification :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-vers-gratification/libelle" /> 
								</fo:inline>
							</fo:block>					
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Si le(la) stagiaire bénéficie d'avantages en nature (gratuité des repas par exemple), 
								le montant représentant la valeur de ces avantages sera ajouté au montant de la gratification 
								mensuelle avant comparaison aux 12,5% du plafond horaire de la sécurité sociale pour une durée 
								légale de travail hebdomadaire de 35 heures.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les frais de déplacement et d'hébergement engagés par l'étudiant(e) à la demande de l'organisme, 
								ainsi que les frais de formation éventuellement nécessités par le stage, seront intégralement 
								pris en charge par celui-ci selon les modalités en vigueur dans l'organisme.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Liste des avantages offerts : <fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les stagiaires accèdent aux activités sociales et culturelles mentionnées à l'article L2323-83 du code du travail dans les mêmes conditions que les salariés
							</fo:block>							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
										font-weight="bold">
								Lorsqu'il se déroule en administration ou établissement public administratif de l'Etat, 
								l'étudiant(e) verra ses frais de missions pris en charge conformément au décret 2006-781, 
								avec comme résidence administrative le lieu de stage. 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
										font-weight="bold">
								Pour les stages en administration ou établissement public administratif de l'État : 
								prise en charge des trajets domicile - lieu de stage, selon les conditions des décrets 82-887 et
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
								Pendant la durée du stage, l'étudiant(e) reste affilié(e) à son système de sécurité sociale antérieur : 
								il(elle) conserve son statut étudiant. Les stages effectués à l'étranger doivent avoir été signalés préalablement 
								au départ de l'étudiant(e) et avoir reçu l'agrément de la Sécurité Sociale.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les dispositions suivantes sont applicables sous réserve de conformité 
								avec la législation du pays d'accueil et de celle régissant le type d'organisme d'accueil :
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.1 Gratification inférieure ou égale</fo:inline>
									au produit de 12,5% du plafond horaire de la sécurité sociale par le nombre d'heures 
									de stage effectuées au cours du mois considéré :
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Dans ce cas, conformément à la législation en vigueur, la gratification de stage n'est pas 
								soumise à cotisation sociale.
								L'étudiant(e) continue à bénéficier de la législation sur les accidents de travail au titre de 
								l'article L 412-8-2 du code de la Sécurité Sociale, régime étudiant
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								En cas d'accident survenant à l'étudiant(e), soit au cours des travaux dans l'organisme, 
								soit au cours du trajet, soit sur les lieux rendus utiles pour les besoins de son stage
								<fo:inline font-size="10pt" font-style="italic">
								et pour les étudiant(e)s en médecine, en chirurgie dentaire ou en pharmacie qui n'ont pas un statut hospitalier, 
								du stage hospitalier effectué dans les conditions prévues au b du 2o de l'article L. 412-8,
								</fo:inline>
								<fo:inline font-size="10pt" font-weight="bold">
								l'organisme d'accueil envoie la déclaration à la 
								</fo:inline> 
								Caisse Primaire d'Assurance Maladie (voir adresse en première page) en mentionnant l'établissement comme employeur,
								<fo:inline font-size="10pt" font-weight="bold">
								avec copie à l'établissement. 
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
									<fo:inline font-size="10pt" font-weight="bold">6.2 Gratification supérieure </fo:inline>
									au produit de 12,5% du plafond horaire de la sécurité sociale par le nombre d'heures 
									de stage effectuées au cours du mois considéré :
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les cotisations sociales sont calculées sur le différentiel entre le montant de la gratification 
								et 12.5% du plafond horaire de la Sécurité Sociale pour une durée légale de travail hebdomadaire de 35 heures.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'étudiant(e) bénéficie de la couverture légale en application des dispositions des articles L 411-1 
								et suivants du code de la Sécurité Sociale. En cas d'accident survenant à l'étudiant(e), soit au cours 
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
									pour les besoins de son stage, l'organisme d'accueil effectue toutes les démarches nécessaires 
									auprès de la Caisse Primaire d'Assurance Maladie et informe l'établissement dans les meilleurs délais.
								</fo:block>
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.3 Protection Maladie du stagiaire à l'étranger :</fo:inline>
							</fo:block>
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									1) Protection issue du régime étudiant(e) français :
							</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Pour les stages au sein de l'Espace Economique Européen (EEE)
									effectués par les étudiant(e)s de nationalité d'un pays membre 
									de l'Union Européenne, il faut demander la Carte Européenne d'Assurance Maladie <fo:inline font-size="10pt" text-decoration="underline">(CEAM).</fo:inline>
								</fo:block>
								
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Pour les stages effectués au Québec par les étudiant(e)s de
									nationalité française, il faut demander le formulaire <fo:inline font-size="10pt" text-decoration="underline">SE401Q</fo:inline> (104 
									pour les stages en entreprise, 106 pour les stages en université).
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:inline font-size="10pt" text-decoration="underline">- Dans tous les autres cas de figure :</fo:inline>
									Les étudiant(e)s qui engagent des frais de santé à l'étranger 
									peuvent être remboursé(e)s auprès de la mutuelle qui leur tient lieu 
									de Caisse de Sécurité Sociale étudiante, au retour, et sur 
									présentation des justificatifs : le remboursement s'effectue alors sur 
									la base des tarifs de soins français, des écarts importants peuvent exister.

								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								° Il est donc fortement recommandé à l'étudiant(e) de souscrire une 
								assurance Maladie complémentaire spécifique, valable pour le pays
								et la durée du stage, auprès de l'Organisme de son choix (mutuelle 
								étudiante, mutuelle des parents, compagnie privée ad hoc...).
							</fo:block>
							
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								
								<fo:inline font-size="10pt" text-decoration="underline">° Exception </fo:inline> : si l'Organisme fournit à l'étudiant(e) une couverture 
								Maladie en vertu des dispositions du droit local (voir 2 ci-dessous),
								alors l'étudiant(e) peut choisir de bénéficier de cette protection 
								Maladie locale. Avant d'effectuer un tel choix, il vérifiera l'étendue 
								des garanties proposées.
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
									<fo:inline font-size="10pt" font-style="italic">En cochant la case appropriée, 
									l'Organisme indique ci-après s'il 
									fournit une protection Maladie au stagiaire, en vertu du droit 
									local :
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" /> <fo:inline font-size="10pt" font-weight="bold">OUI</fo:inline> (celle-ci s'ajoute au maintien, à l'étranger, des droits issus 
								du régime français étudiant(e))
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" /> <fo:inline font-size="10pt" font-weight="bold">NON</fo:inline> (la protection découle alors exclusivement du maintien, à 
								l'étranger, des droits issus du régime français étudiant(e))
								Si aucune case n'est cochée, le 6.3 1/ s'applique.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.4 Protection Accident du Travail du stagiaire à l'étranger :</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									1)	Pour pouvoir bénéficier de la législation française sur la 
									couverture accident de travail, le présent stage doit :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Etre d'une durée au plus égale à 12 mois, prolongations incluses.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Ne donner lieu à aucune rémunération susceptible 
									d'ouvrir des droits à une protection accident de travail 
									dans le pays étranger (une indemnité ou gratification est 
									admise à hauteur de 12,5% du plafond horaire de la 
									sécurité sociale pour une durée légale hebdomadaire de 
									35 heures sous réserve de l'accord de la Caisse Primaire 
									d'Assurance Maladie).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Se dérouler exclusivement dans l'entreprise partie à la présente convention.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Se dérouler exclusivement dans le pays étranger cité.
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
									à cotiser pour la protection du stagiaire et à faire les déclarations 
									nécessaires en cas d'accident de travail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									2)  La déclaration des accidents de travail incombe à 
									l'Etablissement qui doit être informé par l'Organisme 
									par écrit dans un délai de 48 heures.
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
									-	Sur le trajet aller retour habituel entre la résidence du 
									stagiaire sur le territoire étranger et le lieu du stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Sur le trajet aller retour (début et fin de stage) du 
									domicile du stagiaire situé sur le territoire français et le 
									lieu de résidence à l'étranger.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Dans le cadre d'une mission confiée par l'Organisme et obligatoirement sur ordre de mission.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									4)	Pour le cas où l'une seule des conditions prévues au point 
									6.4 1/ n'est pas remplie, l'Organisme s'engage par la 
									présente convention à couvrir le stagiaire contre le risque 
									d'accident de travail, de trajet et les maladies 
									professionnelles et à en assurer toutes les déclarations nécessaires.
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								5)	dans tous les cas,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								-	Si l'étudiant(e) est victime d'un accident du travail 
								durant le stage, l'Organisme d'accueil doit 
								impérativement signaler <fo:inline font-size="10pt" text-decoration="underline">immédiatement</fo:inline> cet accident à 
								l'Etablissement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								-	Si l'étudiant(e) remplit des missions limitées en-dehors 
								de l'Organisme d'accueil ou en en-dehors du pays du 
								stage, l'Organisme doit prendre toutes les dispositions 
								nécessaires pour lui fournir les assurances appropriées.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" 
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 7 : Responsabilité civile et assurances
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								L'Organisme d'accueil et l'étudiant(e) déclarent être garantis au 
								titre de la responsabilité civile.
								Quelle que soit la nature du stage et le pays de destination, le 
								stagiaire s'engage à se couvrir par un contrat d'assistance (
								rapatriement sanitaire, assistance juridique etc.) et par un contrat 
								d'assurance individuel accident.
								Lorsque l'Organisme met un véhicule à la disposition du stagiaire, 
								il lui incombe de vérifier préalablement que la police d'assurance 
								du véhicule couvre son utilisation par un étudiant(e).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Lorsque dans le cadre de son stage, l'étudiant(e) utilise son propre 
								véhicule ou un véhicule, prêté par un tiers, il déclare expressément 
								à l'assureur dudit véhicule cette utilisation qu'il est amené à faire 
								et le cas échéant s'acquitte de la prime y afférente.
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
								Durant son stage, l'étudiant(e) est soumis à la discipline et au 
								règlement intérieur (qui doit être porté à la connaissance de 
								l'étudiant-e) de l'organisme, notamment en ce qui concerne les 
								horaires, et les règles d'hygiène et de sécurité en vigueur dans 
								l'organisme d'accueil.
								Toute sanction disciplinaire ne peut être décidée que par 
								l'Etablissement. Dans ce cas, l'Organisme informe l'Etablissement 
								des manquements et lui fournit éventuellement les éléments 
								constitutifs.
								En cas de manquement particulièrement grave à la discipline, 
								l'Organisme se réserve le droit de mettre fin au stage de 
								l'étudiant(e) tout en respectant les dispositions fixées à l'article 9 
								de la présente convention.

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
								Toute difficulté survenue dans le déroulement du stage devra être portée 
								à la connaissance de tous les intéressés afin d'être résolue au plus vite.

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
								Au cours du stage, le stagiaire pourra bénéficier de congés 
								sous réserve d'accord de l'organisme d'accueil et que la durée du stage 
								soit respectée.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Pour toute autre interruption temporaire du stage (maladie, maternité, 
								absence injustifiée...) l'organisme d'accueil avertira le responsable de l'établissement par courrier.
							</fo:block>
											
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interruption définitive :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								<fo:inline font-size="10pt" font-weight="bold">
								En cas de volonté d'une des trois parties (Organisme, 
								Etablissement, étudiant(e)) d'interrompre définitivement le 
								stage, 
								</fo:inline>, celle-ci devra immédiatement en informer les deux autres 
								parties par écrit. Les raisons invoquées seront examinées en étroite 
								concertation. La décision définitive d'interruption du stage ne sera 
								prise qu'à l'issue de cette phase de concertation.
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 10 : Devoir de réserve et confidentialité
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Le devoir de réserve est de rigueur absolue. Les étudiant(e)s 
								stagiaires prennent donc l'engagement de n'utiliser en aucun cas 
								les informations recueillies ou obtenues par eux pour en faire 
								l'objet de publication, communication à des tiers sans accord 
								préalable de l'Organisme, y compris le rapport de stage. Cet 
								engagement vaudra non seulement pour la durée du stage mais 
								également après son expiration. L'étudiant(e) s'engage à ne 
								conserver, emporter, ou prendre copie d'aucun document ou 
								logiciel, de quelque nature que ce soit, appartenant à l'Organisme, 
								sauf accord de ce dernier.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Nota : Dans le cadre de la confidentialité des informations contenues dans 
								le rapport, l'Organisme peut demander une restriction de la diffusion du 
								rapport, voire le retrait de certains éléments très confidentiels.
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
								Les personnes amenées à en connaître sont contraintes par le secret 
								professionnel à n'utiliser ni ne divulguer les informations du rapport. 
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
								Article 11 : Propriété intellectuelle
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Conformément au code de la propriété intellectuelle, si le travail du 
									stagiaire donne lieu à la création d'une oeuvre protégée par le droit 
									d'auteur ou la propriété industrielle (y compris un logiciel), si 
									l'organisme d'accueil souhaite l'utiliser et que le stagiaire est 
									d'accord, un contrat devra être signé entre le stagiaire (auteur) et l'organisme d'accueil.
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Devront notamment être précisés l'étendue des droits cédés, 
									l'éventuelle exclusivité, la destination, les supports utilisés et la durée 
									de la cession, ainsi que, le cas échéant, le montant 
									de la rémunération due à l'étudiant au titre de la cession.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">
								Cette clause s'applique également dans le cas des stages dans les Organismes publics.
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
									du stage soit signé avec l'organisme d'accueil la présente convention 
									deviendrait caduque ; l' « étudiant(e) » ne relèverait plus de la 
									responsabilité de l'établissement d'enseignement. Ce dernier devrait impérativement 
									en être averti avant la signature du contrat.
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 13 : Fin de stage - Rapport - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									A l'issue du stage, l'organisme d'accueil délivre au stagiaire une 
									attestation de stage et remplit une fiche d'évaluation  de l'activité du 
									stagiaire (annexe) qu'il retourne à l'établissement d'enseignement 
									supérieur.
							</fo:block>		
						</fo:table-cell>
						<fo:table-cell >														
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								A l'issue de son stage l'étudiant devra : (préciser la nature de travail à fournir, en joignant éventuellement une annexe)
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Préciser le cas échéant les modalités de validation du stage accompli par l'étudiant : 
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								Nombre de crédits ECTS : 
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
								Evaluation de la qualité du stage : A l'issue du stage, les trois parties 
								intéressées sont invitées à formuler une appréciation sur la qualité 
								du stage.
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Le tuteur organisme d'accueil ou tout autre membre de l'organisme 
								d'accueil appelé à se rendre à l'établissement dans le cadre de la 
								préparation, du déroulement et de la validation du stage ne peut 
								prétendre à une quelconque prise en charge ou indemnisation de la 
								part de l'établissement.
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Un avenant à la convention pourra éventuellement être établi en cas 
								de prolongation de stage faite à la demande de l'organisme et de 
								l'étudiant(e). En aucun cas la date de fin de stage ne pourra être 
								postérieure au 30/09 de l'année en cours.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								L'accueil successif de stagiaires, au titre de conventions de stage différentes, 
								pour effectuer des stages dans un même poste n'est possible qu'à l'expiration d'un délai de carence 
								égal au tiers de la durée du stage précédent. Cette disposition n'est pas applicable lorsque ce stage 
								précédent a été interrompu avant son terme à l'initiative du stagiaire.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 14 : Droit applicable - Tribunaux compétents
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La présente convention est régie exclusivement par le droit français. 
								Tout litige non résolu par voie amiable sera soumis à la compétence 
								de la juridiction française compétente.
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
								Pour l'établissement d'enseignement supérieur 
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
											(Nom et signature du représentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								
								<xsl:choose>
									<xsl:when test="centre-gestion/nom-viseur">
									Par délégation,
										<fo:inline font-weight="bold">			
											<xsl:variable name="prenom1" 
												select="translate(substring(./centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
											<xsl:variable name="prenom2" 
											select="translate(centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
											<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>											
											<xsl:text> </xsl:text> 
											<xsl:value-of select="translate(centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 											
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
								(Nom et signature du représentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
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
								Pour l'étudiant
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
										select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />  
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
								(Nom et signature du représentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
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
								Tuteur Etablissement d'enseignement supérieur
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
								(Nom et signature du représentant)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
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
								Le Ministre de l'Emploi, de la Cohésion sociale et du Logement
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre de l'Education nationale, de l'Enseignement supérieur et de la Recherche
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre délégué à l'Emploi, au Travail et à l'Insertion professionnelle des jeunes
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Le Ministre délégué à l'Enseignement supérieur et à la Recherche
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
									Le développement des stages est aujourd'hui fondamental en 
									matière d'orientation et d'insertion professionnelle des jeunes.
									En effet, le stage permet la mise en oeuvre de connaissances 
									théoriques dans un cadre professionnel et donne à l'étudiant une 
									expérience du monde de l'entreprise et de ses métiers. Dans cette 
									perspective, il est fondamental de rappeler que les stages ont une 
									finalité pédagogique, ce qui signifie qu'il ne peut y avoir de stage 
									hors parcours pédagogique. En aucun cas un stage ne peut être 
									considéré comme un emploi. La présente charte, qui a été rédigée 
									par les services de l'Etat, les représentants des entreprises, les 
									représentants des établissements d'enseignement supérieur, et les 
									représentants des étudiants, a dès lors pour objectif de sécuriser la 
									pratique des stages, tout en favorisant leur développement 
									bénéfique à la fois pour les jeunes et pour les entreprises.
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
									Le champ de la charte concerne tous les stages d'étudiants en 
									entreprise, sans préjudice des règles particulières applicables aux
									professions réglementées.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - Le stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									La finalité du stage s'inscrit dans un projet pédagogique et n'a de 
									sens que par rapport à ce projet. Dès lors le stage :
									- permet la mise en pratique des connaissances en milieu 
									professionnel ;
									- facilite le passage du monde de l'enseignement supérieur à celui 
									de l'entreprise.
									Le stage ne peut en aucun cas être assimilé à un emploi.
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
									enseignant de l'établissement, un membre de l'entreprise et
									l'étudiant. Ce projet de stage est formalisé dans la convention
									signée par l'établissement d'enseignement, l'entreprise et le
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
									La convention précise les engagements et les responsabilités de 
									l'établissement d'enseignement, de l'entreprise et de l'étudiant. Les 
									rubriques obligatoires sont mentionnées en annexe à la charte.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">3 - Durée du stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									La durée du stage est précisée dès les premiers contacts entre  
									l'établissement d'enseignement et l'entreprise. L'étudiant en est 
									tenu informé. La durée du stage figure explicitement dans la 
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
									- un enseignant de l'établissement ;
									- un membre de l'entreprise.
									L'enseignant et le membre de l'entreprise travaillent en 
									collaboration, sont informés et s'informent de l'état d'avancement 
									du stage et des difficultés éventuelles. Le responsable du stage au 
									sein de l'établissement d'enseignement est le garant de
									l'articulation entre les finalités du cursus de formation et celles du 
									stage, selon les principes de la présente charte. Leurs institutions 
									respectives reconnaissent la nécessité de leur investissement, 
									notamment en temps, consacré à l'encadrement. 
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
									L'activité du stagiaire fait l'objet d'une évaluation qui résulte de la 
									double appréciation des responsables de l'encadrement du stage.
									Chaque établissement d'enseignement décide de la valeur qu'il
									accorde aux stages prévus dans le cursus pédagogique.  
								</fo:block>
							</fo:table-cell>
							<fo:table-cell >
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									 Les modalités concrètes d'évaluation sont mentionnées dans la
									convention. L'évaluation est portée dans une "fiche d'évaluation" 
									qui, avec la convention, constitue le "dossier de stage". Ce
									dossier de stage est conservé par l'établissement d'enseignement. 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify" font-style="italic"
									font-weight="bold">b - Evaluation du stage
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Les signataires de la convention sont invités à formuler une 
									appréciation de la qualité du stage.
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
									font-weight="bold">1 - L'étudiant vis-à-vis de l'entreprise
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'étudiant s'engage à :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- réaliser sa mission et être disponible pour les tâches qui lui sont 
									confiées ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- respecter les règles de l'entreprise ainsi que ses codes et sa
									culture ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- respecter les exigences de confidentialité fixées par l'entreprise ; 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- rédiger, lorsqu'il est exigé, le rapport ou le mémoire dans les
									délais prévus ; ce document devra être présenté aux responsables 
									de l'entreprise avant d'être soutenu <fo:inline font-style="italic">
									(si le contenu le nécessite, le 
									mémoire poura, à la demande de l'entreprise, rester confidentiel).
									</fo:inline> 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - L'entreprise vis-à-vis de l'étudiant
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'entreprise s'engage à : 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- proposer un stage s'inscrivant dans le projet pédagogique défini 
									par l'établissement d'enseignement ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- accueillir l'étudiant et lui donner les moyens de réussir sa mission 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- désigner un responsable de stage ou une équipe tutorale dont la 
									tâche sera de :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* guider et conseiller l'étudiant 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* l'informer sur les règles, les codes et la culture de l'entreprise
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* favoriser son intégration au sein de l'entreprise et l'accès aux 
									informations nécessaires 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* l'aider dans l'acquisition des compétences nécessaires 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* assurer un suivi régulier de ses travaux  
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									*  évaluer la qualité du travail effectué 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									*  le conseiller sur son projet professionnel 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- rédiger une attestation de stage décrivant les missions effectuées
									qui pourra accompagner les futurs <fo:inline font-style="italic">
									curriculum vitae </fo:inline>  de l'étudiant. 
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">3 - L'établissement d'enseignement supérieur vis-à-vis de l'étudiant
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'établissement d'enseignement s'engage à :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- définir les objectifs du stage et s'assurer que le stage proposé y répond ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- accompagner l'étudiant dans la recherche de stage ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- préparer l'étudiant au stage ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- assurer le suivi de l'étudiant pendant la durée de son stage, en lui 
									affectant un enseignant qui veillera au bon déroulement du stage ; 
									mettre à la disposition de ce dernier les outils nécessaires à 
									l'appréciation de la qualité du stage par l'étudiant ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- pour les formations supérieures qui l'exigent, le guider et le 
									conseiller dans la réalisation de son rapport de stage ou de son 
									mémoire et organiser la soutenance en permettant à un 
									représentant de l'entreprise d'y participer.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">4 - L'entreprise et l'établissement d'enseignement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'entreprise et l'établissement d'enseignement supérieur veillent à 
									échanger les informations nécessaires avant, pendant et après le 
									stage. Ils respectent par ailleurs leurs règles respectives de 
									confidentialité et de déontologie.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">5 - L'étudiant vis à vis des établissements d'enseignement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									L'étudiant s'engage à fournir l'appréciation de la qualité de son 
									stage à son établissement d'enseignement.
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