<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="2.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
				xmlns:java="http://xml.apache.org/xalan/java" xmlns:str="http://exslt.org/strings"
				exclude-result-prefixes="java">

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
		<fo:block>
			<xsl:call-template name="preambule" />
		</fo:block>
		<fo:block>
			<xsl:call-template name="infosEtuStage" />
		</fo:block>
		<fo:block>
			<xsl:call-template name="Contacts" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block padding-top="8pt">
			<xsl:call-template name="Articles" />
		</fo:block>
		<fo:block padding-top="8pt">
			<xsl:call-template name="AnnexeArticlesPage4" />
		</fo:block>
		<!-- <fo:block break-after="page" /> -->
		<!-- <fo:block> -->
		<!-- <xsl:call-template name="Attestation" /> -->
		<!-- </fo:block> -->
		<fo:block>
			<xsl:choose>
				<xsl:when test="document('config.xml')/config/triptik">
					<xsl:call-template name="triptik" />
				</xsl:when>
				<xsl:otherwise>
					<fo:block id="theEnd" />
				</xsl:otherwise>
			</xsl:choose>
		</fo:block>
	</xsl:template>

	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="all"
									   page-height="29.699cm" page-width="20.999cm" margin-right="1cm"
									   margin-left="0.9cm" margin-bottom="0.4cm" margin-top="0.794cm">
					<fo:region-body margin-bottom="0.6cm" />
					<fo:region-after display-align="after"
									 space-before="0cm" extent="0.55cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="all">
				<fo:static-content flow-name="xsl-region-after">
					<fo:block line-height="110%" hyphenate="false" language="fr"
							  country="FR" font-size="9pt" font-family="Times New Roman,serif"
							  text-align="end">
						<fo:inline>
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

	<xsl:include href="triptik.xsl" />

	<xsl:template name="AnnexeArticlesPage4">
		<fo:block line-height="100%" hyphenate="false" language="fr"
				  country="FR" font-size="9pt" font-family="Times New Roman,serif"
				  padding-top="1.60cm">
			Fiches � annexer � la convention :
			<fo:inline text-decoration="underline">
				1) Attestation de stage
			</fo:inline>
			/
			<fo:inline text-decoration="underline">
				2) Fiche de stage � l'�tranger
				(pour informations s�curit� sociale voir site cleiss.fr - pour fiche
				pays voir site diplomatie.gouv.fr)
			</fo:inline>
			/
			<fo:inline text-decoration="underline">
				3) Autres annexes (le cas
				�ch�ant)
			</fo:inline>
		</fo:block>
	</xsl:template>

	<!-- entete logo/ annee universitaire -->
	<xsl:template name="entete">
		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="11pt" font-family="Times New Roman,serif"
				  margin-left="0cm" margin-right="0cm" text-indent="0cm" font-weight="bold"
				  padding-top="0.5cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell>
							<fo:block>
								<fo:external-graphic>
									<xsl:attribute name="src">
										<xsl:value-of select="document('config.xml')/config/logoUniversite" />
									</xsl:attribute>
									<xsl:attribute name="width">
										<xsl:value-of
												select="document('config.xml')/config/largeurLogoUniversite" />
									</xsl:attribute>
									<xsl:attribute name="height">
										<xsl:value-of
												select="document('config.xml')/config/hauteurLogoUniversite" />
									</xsl:attribute>
								</fo:external-graphic>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block>
								<xsl:choose>
									<xsl:when test="centre-gestion/fichier/nom-fichier">
										<xsl:variable name="cheminLogo"
													  select="document('config.xml')/config/uploadFiles.logosCentre.path" />
										<xsl:variable name="logo"
													  select="centre-gestion/fichier/nom-fichier" />
										<fo:external-graphic height="1cm">
											<xsl:attribute name="src">
												<xsl:value-of select="$cheminLogo" /><xsl:value-of
													select="centre-gestion/fichier/@id-fichier" />_<xsl:value-of
													select="$logo" />
											</xsl:attribute>
										</fo:external-graphic>
									</xsl:when>
									<xsl:otherwise>

									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell width="3cm">
							<fo:block width="3.493cm" line-height="110%" language="fr"
									  country="FR" font-size="12pt" text-align="right">
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
		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="12pt" font-family="Times New Roman,serif"
				  text-align="justify">
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />

			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
						<fo:block line-height="200%" hyphenate="false" language="fr"
								  country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>
						<fo:block line-height="110%" padding-top="10pt"
								  hyphenate="false" language="fr" country="FR" font-size="14pt"
								  font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">
								Convention de stage
								<xsl:text> </xsl:text>
								n�
								<xsl:value-of select="id-convention" />
								<xsl:text> </xsl:text>
								r�alis�e 
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" padding-top="5pt"
								  hyphenate="false" language="fr" country="FR" font-size="14pt"
								  font-family="Times New Roman,serif" text-align="center">
							 <fo:inline font-weight="bold">dans le cadre d'une c�sure entre</fo:inline>
						</fo:block>		  
						<fo:block line-height="200%" hyphenate="false" language="fr"
								  country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<!-- partie Infos Etudiant - Stage -->
	<xsl:template name="infosEtuStage">

		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="7.5pt" font-family="Times New Roman,serif"
				  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
				  padding-bottom="0.3cm" font-style="italic">
			Nota : pour faciliter la
			lecture du
			document, les mots "stagiaire", "enseignant r�f�rent",
			"tuteur de
			stage", "repr�sentant l�gal", et "�tudiant" sont utilis�s
			au masculin.
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="8.5pt" font-family="Times New Roman,serif"
				  padding-left="0.141cm" padding-right="0.141cm"
				  padding-bottom="0.3cm" font-style="italic">
			Remarque : le stage objet de la pr�sente convention entre dans le cadre d'une c�sure. 
			Il n'est pas rattach� � un cursus d'enseignement.
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-column column-width="proportional-column-width(1)" />

			<fo:table-body>
				<fo:table-row margin-top="20px" text-align="left">
					<!-- partie Etablissement Superieur - Stage -->
					<fo:table-cell border="0.018cm solid #000000"
								   padding-left="0.1cm" padding-right="0.4cm" padding-top="0.2cm"
								   padding-bottom="0.2cm">
						<fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0cm"
								  padding-bottom="0.035cm" text-align="center">
							<fo:inline font-weight="bold">
								1 -
								<fo:inline text-decoration="underline">L'�TABLISSEMENT
									D'ENSEIGNEMENT ou DE FORMATION
								</fo:inline>
							</fo:inline>
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nom :
							</fo:inline>
							<xsl:choose>
								<xsl:when test="nom-etab-ref">
									<xsl:value-of select="nom-etab-ref" />
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="document('config.xml')/config/nomUniversite" />
								</xsl:otherwise>
							</xsl:choose>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Adresse :
							</fo:inline>
							<xsl:choose>
								<xsl:when test="adresse-etab-ref">
									<xsl:value-of select="adresse-etab-ref" />
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="document('config.xml')/config/adresseUniversite" />
								</xsl:otherwise> 
							</xsl:choose> 
						</fo:block>
						<xsl:choose>
							<xsl:when test="document('config.xml')/config/telUniversite">
								<fo:block line-height="130%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  padding-left="0.141cm" padding-right="0.141cm">
									<fo:inline font-weight="bold">
										T�l :
									</fo:inline>
									<xsl:value-of select="document('config.xml')/config/telUniversite" />
								</fo:block>
							</xsl:when>
							<xsl:otherwise>
							</xsl:otherwise>
						</xsl:choose>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm" font-weight="bold">
							Repr�sent� par (signataire
							de la
							convention) :
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<xsl:choose>
								<xsl:when test="centre-gestion/nom-viseur">
									<fo:inline>
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="centre-gestion/prenom-viseur" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of
												select="translate(centre-gestion/nom-viseur,$lowers,$uppers)" />
									</fo:inline>
									<xsl:choose>
										<xsl:when test="centre-gestion/qualite-viseur">
											<fo:block line-height="130%" hyphenate="false"
													  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
													  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
													  padding-bottom="0.035cm">
												<fo:inline font-weight="bold">
													Qualit� du repr�sentant :
												</fo:inline>
												<xsl:value-of select="centre-gestion/qualite-viseur" />
											</fo:block>
										</xsl:when>
										<xsl:otherwise>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:when>
								<xsl:otherwise>
									<fo:inline>
										<xsl:value-of select="nom-signataire-composante" />
									</fo:inline>
									<xsl:choose>
										<xsl:when test="qualite-signataire">
											<fo:block line-height="130%" hyphenate="false"
													  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
													  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
													  padding-bottom="0.035cm">
												<fo:inline font-weight="bold">
													Qualit� du repr�sentant :
												</fo:inline>
												<xsl:value-of select="qualite-signataire" />
											</fo:block>
										</xsl:when>
										<xsl:otherwise>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:otherwise>
							</xsl:choose>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm">
							<fo:inline font-weight="bold">
								Adresse (si diff�rente de celle	de l'�tablissement) :
							</fo:inline>
							<xsl:value-of select="centre-gestion/batiment-residence" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="centre-gestion/voie" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="centre-gestion/code-postal" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="centre-gestion/commune" />
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:value-of select="centre-gestion/telephone" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm">
							<fo:inline font-weight="bold">
								M�l :
							</fo:inline>
							<xsl:value-of select="centre-gestion/mail" />
						</fo:block>
					</fo:table-cell>

					<!-- partie Entreprise ou organisme accueil -->
					<fo:table-cell border="0.018cm solid #000000"
								   border-left="none" padding-left="0.1cm" padding-right="0.4cm"
								   padding-top="0.2cm" padding-bottom="0.2cm">

						<fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0cm"
								  padding-bottom="0.035cm" text-align="center">
							<fo:inline font-weight="bold">
								2 -
								<fo:inline text-decoration="underline">
									L'ORGANISME D'ACCUEIL
								</fo:inline>
							</fo:inline>
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nom :
							</fo:inline>
							<xsl:value-of select="structure/raison-sociale" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Adresse :
							</fo:inline>
							<xsl:value-of select="structure/batiment-residence" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="structure/voie" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="structure/code-postal" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="structure/commune" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="structure/pays/libelle" />
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Repr�sent� par (nom du
								signataire de la convention) :
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<xsl:value-of select="signataire/civilite/libelle" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="translate(signataire/nom,$lowers,$uppers)" />
							<xsl:text> </xsl:text>

							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="signataire/prenom" />
								</xsl:with-param>
							</xsl:call-template>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Qualit� du repr�sentant :
							</fo:inline>
							<xsl:value-of select="signataire/fonction" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Service dans lequel le stage
								sera effectu� :
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<xsl:value-of select="service/nom" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:value-of select="structure/telephone" />
							
							<!-- <xsl:if test="structure/fax != ''"> -->
							<!-- &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160; -->
							<!-- <fo:inline font-weight="bold"> -->
							<!-- Fax : -->
							<!-- </fo:inline> -->
							<!-- <xsl:value-of select="structure/fax" /> -->
							<!-- </xsl:if> -->
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								M�l :
							</fo:inline>
							<xsl:value-of select="structure/mail" />
														
						</fo:block>
						<xsl:if test="service/voie != structure/voie">
							<fo:block line-height="130%" hyphenate="false" language="fr"
									  country="FR" font-size="9pt" font-family="Times New Roman,serif"
									  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									  padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Lieu du stage (si diff�rent de
									l'adresse de l'organisme) :
								</fo:inline>

								<xsl:value-of select="service/batiment-residence" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="service/voie" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="service/code-postal" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="service/commune" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="service/pays/libelle" />
							</fo:block>
						</xsl:if>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<!-- partie Etudiant -->
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell border="0.018cm solid #000000"
								   padding-left="0.1cm" padding-right="0.4cm" padding-top="0.2cm"
								   padding-bottom="0.2cm">
						<fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0cm"
								  padding-bottom="0.035cm" text-align="center">
							<fo:inline font-weight="bold">
								3 -
								<fo:inline text-decoration="underline">LE STAGIAIRE
								</fo:inline>
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nom :
							</fo:inline>
							<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="translate(etudiant/nom-marital,$lowers,$uppers)" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Pr�nom :
							</fo:inline>
							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="etudiant/prenom" />
								</xsl:with-param>
							</xsl:call-template>
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Sexe :
							</fo:inline>
							<xsl:value-of select="etudiant/code-sexe" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								N�(e) le :
							</fo:inline>
							<xsl:value-of
									select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Num�ro d'�tudiant :
							</fo:inline>
							<xsl:value-of select="etudiant/num-etudiant" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Adresse :
							</fo:inline>
							<xsl:value-of select="adresse-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="code-postal-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="ville-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="pays-etudiant" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:value-of select="tel-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Portable :
							</fo:inline>
							<xsl:value-of select="tel-portable-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								M�l :
							</fo:inline>
							<xsl:value-of select="etudiant/mail" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="8.5pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Cursus dans lequel l'�tudiant sera inscrit � son retour de c�sure :
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<xsl:value-of select="etape/libelle" />
						</fo:block>						
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="200%" hyphenate="false" language="fr"
				  country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<!-- partie Sujet/Duree -->
		<fo:table table-layout="fixed" width="100%" border="0.018cm solid #000000">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell padding-top="5pt" padding-bottom="5pt"
								   padding-left="5pt" padding-right="5pt">
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold" text-decoration="underline">
								SUJET DE
								STAGE
							</fo:inline>
							:
							<xsl:if test="tem-conf-sujet-teme != 'O'">
								<xsl:value-of select="sujet-stage" />
							</xsl:if>
							<xsl:if test="tem-conf-sujet-teme = 'O'">
								Confidentiel
							</xsl:if>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.5cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Dates :
							</fo:inline>
							<xsl:text> </xsl:text>
							du
							<xsl:text> </xsl:text>
							<xsl:value-of
									select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
							<xsl:text> </xsl:text>
							au
							<xsl:text> </xsl:text>
							<xsl:value-of
									select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />
							<xsl:if test="@interruption-stage = 'true'">
								<xsl:text> </xsl:text>
								avec interruption du
								<xsl:value-of
										select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
								<xsl:text> </xsl:text>
								au
								<xsl:text> </xsl:text>
								<xsl:value-of
										select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))" />
							</xsl:if>
						</fo:block>

						<xsl:choose>
							<xsl:when test="duree-exceptionnelle and duree-exceptionnelle != ''">
								<xsl:choose>
									<xsl:when
											test="id-unite-duree-exceptionnelle and id-unite-duree-exceptionnelle != 0">
										<fo:block line-height="110%" hyphenate="false"
												  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
												  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
												  padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												Repr�sentant une dur�e
												totale de
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> </xsl:text>
											<xsl:if test="id-unite-duree-exceptionnelle = '1'">
												heure(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '2'">
												jour(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '3'">
												semaine(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '4'">
												mois
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '5'">
												ann�e(s)
											</xsl:if>
										</fo:block>
									</xsl:when>
									<xsl:otherwise>
										<fo:block line-height="130%" hyphenate="false"
												  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
												  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
												  padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												Correspondant �
											</fo:inline>
											<fo:inline>
												<xsl:value-of select="duree-exceptionnelle" />
												<xsl:text> heures </xsl:text>
											</fo:inline>
											<fo:inline font-weight="bold">
												de pr�sence effective dans
												l'organisme d'accueil
											</fo:inline>
										</fo:block>
										<fo:block line-height="130%" hyphenate="false"
												  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
												  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
												  padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												et repr�sentant une dur�e
												totale
												de
											</fo:inline>
											<fo:inline>
												<xsl:variable name="nbHeures" select="duree-exceptionnelle" />
												<xsl:variable name="nbJours" select="floor($nbHeures div 7)" />
												<xsl:variable name="nbHeuresRestantes" select="$nbHeures mod 7" />
												<xsl:variable name="nbMois" select="floor($nbJours div 22)" />
												<xsl:variable name="nbJoursRestants" select="$nbJours mod 22" />

												<xsl:value-of select="$nbMois" />
												<xsl:text> mois </xsl:text>
												<xsl:value-of select="$nbJoursRestants" />
												<xsl:text> jour(s) et </xsl:text>
												<xsl:value-of select="$nbHeuresRestantes" />
												<xsl:text> heure(s) </xsl:text>
											</fo:inline>
										</fo:block>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:when>
							<xsl:otherwise>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
										  padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Repr�sentant une dur�e totale
										de
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									semaines
								</fo:block>
							</xsl:otherwise>
						</xsl:choose>

						<xsl:choose>
							<xsl:when test="temps-travail/code-ctrl">
								<xsl:if test="temps-travail/code-ctrl != 'TCOMP'">
									<fo:block line-height="130%" hyphenate="false"
											  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											  padding-bottom="0.035cm">
										<fo:inline font-weight="bold">
											R�partition si pr�sence
											discontinue :
										</fo:inline>
										<xsl:value-of select="nb-heures-hebdo" />
										<xsl:text> </xsl:text>
										<fo:inline font-weight="bold">
											heures par semaine
										</fo:inline>
									</fo:block>
								</xsl:if>
							</xsl:when>
						</xsl:choose>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Commentaire :
							</fo:inline>
							<xsl:choose>
								<xsl:when test="commentaire-duree-travail">
									<xsl:if test="commentaire-duree-travail != ''">
										<fo:inline>
											<xsl:value-of select="commentaire-duree-travail" />
										</fo:inline>
									</xsl:if>
								</xsl:when>
							</xsl:choose>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
				           country="FR" font-size="9pt" font-family="Times New Roman,serif">
			               <fo:leader />
		                </fo:block>		                
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<!-- Partie Encadrement -->
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell border="0.018cm solid #000000"
								   padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
								   padding-bottom="0.035cm">
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm" font-weight="bold" text-align="center"
								  text-decoration="underline">
							Encadrement du stagiaire par l'�tablissement
							d'enseignement
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm" font-weight="bold">
							Nom et pr�nom de
							l'enseignant r�f�rent :
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline>
								<xsl:value-of select="translate(enseignant/nom,$lowers,$uppers)" />
								<xsl:text> </xsl:text>
								<xsl:call-template name="start_upper">
									<xsl:with-param name="prenom">
										<xsl:value-of select="enseignant/prenom" />
									</xsl:with-param>
								</xsl:call-template>
							</fo:inline>
						</fo:block>
						<!--<fo:block line-height="130%" hyphenate="false" language="fr"-->
								  <!--country="FR" font-size="9pt" font-family="Times New Roman,serif"-->
								  <!--padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"-->
								  <!--padding-bottom="0.035cm">-->
							<!--<fo:inline font-weight="bold">-->
								<!--Fonction (ou discipline) :-->
							<!--</fo:inline>-->
							<!--<xsl:choose>-->
								<!--<xsl:when test="enseignant/type-personne and (enseignant/type-personne = 'faculty' or enseignant/type-personne = 'FACULTY')">-->
									<!--Enseignant-->
								<!--</xsl:when>-->
								<!--<xsl:otherwise>-->
									<!--<xsl:value-of select="enseignant/type-personne" />-->
								<!--</xsl:otherwise>-->
							<!--</xsl:choose>-->
						<!--</fo:block>-->
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:value-of select="enseignant/tel" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								M�l :
							</fo:inline>
							<xsl:value-of select="enseignant/mail" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border="0.018cm solid #000000"
								   border-left="none" padding-left="0.141cm" padding-right="0.141cm"
								   padding-top="0.2cm" padding-bottom="0.035cm">
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm" font-weight="bold" text-align="center"
								  text-decoration="underline">
							Encadrement du stagiaire par l'organisme
							d'accueil
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm" font-weight="bold">
							Nom et pr�nom du tuteur de
							stage :
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<xsl:value-of select="translate(contact/nom,$lowers,$uppers)" />
							<xsl:text> </xsl:text>
							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="contact/prenom" />
								</xsl:with-param>
							</xsl:call-template>
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Fonction :
							</fo:inline>
							<xsl:value-of select="contact/fonction" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:value-of select="contact/tel" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								M�l :
							</fo:inline>
							<xsl:value-of select="contact/mail" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="Contacts">
	   <fo:block line-height="200%" hyphenate="false" language="fr"
				  country="FR" font-size="8pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell padding-left="0.141cm" padding-right="0.141cm"
								   padding-top="0.2cm" padding-bottom="0.035cm" border="0.018cm solid #000000">
						<fo:block line-height="130%" hyphenate="false" language="fr"
			               country="FR" font-size="9pt" font-family="Times New Roman,serif"
			                font-weight="bold" text-align="left" text-decoration="underline">
					      CONTACTS
		                </fo:block>
		                <fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>		   
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
							Caisse Primaire
							d'Assurance Maladie � contacter en cas
							d'accident (lieu de
							domicile de l'�tudiant sauf exception) :
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
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
						<fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
						  <fo:inline>
							Contact en cas d'urgence ou de probl�me (parents, r�f�rent �tablissement) :	
						  </fo:inline> 							
						  <fo:inline>.........................................</fo:inline>										
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
						  <fo:inline>
							Service de m�decine pr�ventive de l'�tablissement d'enseignement (le cas �ch�ant) :	
						  </fo:inline> 							
						  <xsl:choose>
							<xsl:when test="document('config.xml')/config/medPrev">
								<fo:inline font-weight="bold"><xsl:value-of select="document('config.xml')/config/medPrev" /></fo:inline>
							</xsl:when>
							<xsl:otherwise>
							  <fo:inline>.........................................</fo:inline>
							</xsl:otherwise>
						  </xsl:choose>						
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
								  country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
						  <fo:inline>
							Contact en cas de conflit (m�diateur, conciliateur, etc.) : 
						  </fo:inline> 							
						  <xsl:choose>
							<xsl:when test="document('config.xml')/config/contactConflit">
								<fo:inline font-weight="bold"><xsl:value-of select="document('config.xml')/config/contactConflit" /></fo:inline>
							</xsl:when>
							<xsl:otherwise>
							  <fo:inline>.........................................</fo:inline>
							</xsl:otherwise>
						  </xsl:choose>						
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>

		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="8pt" font-family="Times New Roman,serif"
				  padding-top="50pt" text-align="center">
			Date d'impression :
			<xsl:value-of
					select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())" />
		</fo:block>
	</xsl:template>
	<xsl:template name="Articles">
		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="10pt" font-family="Times New Roman,serif"
				  margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">Article 1 - Objet de la convention
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La pr�sente convention r�gle les rapports de l'organisme
								d'accueil avec
								l'�tablissement
								d'enseignement et le stagiaire, dans le cadre d'une p�riode de 
								c�sure r�alis�e par le stagiaire.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 2 - Objectif du stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le stage r�alis� dans le cadre d'une c�sure correspond 
								� une p�riode temporaire de mise en situation en milieu 
								professionnel au cours de laquelle l'�tudiant acquiert ou 
								d�veloppe des comp�tences professionnelles ind�pendamment 
								de son cursus de formation d'origine. 
								Le stagiaire se voit confier une ou des missions conformes 
								au projet de c�sure qu'il a au pr�alable soumis et 
								valid� aupr�s de son �tablissement d'enseignement et 
								qui ont �t� approuv�es par l'organisme d'accueil.								
							</fo:block>							
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">ACTIVIT�S CONFI�ES
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="true" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="fonctions-et-taches" />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">
									Comp�tences � acqu�rir ou �
									d�velopper
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="true" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="competences" />
							</fo:block>

							<fo:block line-height="110%" padding-top="4pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 3 - Modalit�s du stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La dur�e hebdomadaire de pr�sence effective du stagiaire
								dans
								l'organisme
								d'accueil sera de
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								heures sur la base d'un
								<fo:inline font-weight="bold">
									<xsl:value-of select="temps-travail/libelle" />
								</fo:inline>
								<xsl:text>.</xsl:text>
								<!-- (quotit� : -->
								<!-- <fo:inline font-weight="bold"> -->
								<!-- <xsl:value-of select="quotite-travail" /> -->
								<!-- %). -->
								<!-- </fo:inline> -->
							</fo:block>

							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Si le stagiaire doit �tre pr�sent dans l'organisme
								d'accueil
								la
								nuit, le
								dimanche ou un jour f�ri�, pr�ciser
								les cas
								particuliers :
								<fo:inline font-weight="bold">
									<xsl:value-of select="travail-nuit-ferie" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">Article 4 - Accueil
								et
								encadrement du stagiaire
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire est suivi par l'enseignant
								r�f�rent d�sign� dans
								la
								pr�sente
								convention ainsi que par le service de
								l'�tablissement
								en
								charge
								des stages.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le tuteur de stage d�sign� par l'organisme d'accueil
								dans la
								pr�sente convention est charg� d'assurer le suivi du stagiaire
								et d'optimiser les conditions de r�alisation du
								stage
								conform�ment aux missions et objectifs d�finis.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'organisme d'accueil
								peut autoriser le stagiaire � se d�placer.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Toute difficult� survenue dans la
								r�alisation et le d�roulement
								du stage, qu'elle soit
								constat�e par
								le stagiaire ou par le
								tuteur
								de stage, doit
								�tre port�e � la
								connaissance de
								l'enseignant-r�f�rent et de
								l'�tablissement
								d'enseignement afin
								d'�tre r�solue au plus vite.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'organisme d'accueil ne doit pas confier de t�ches dangereuses au stagiaire.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									MODALIT�S
									D'ENCADREMENT
								</fo:inline>
								(visites, rendez-vous t�l�phoniques, etc..)
							</fo:block>
							<xsl:choose>
								<xsl:when test="mode-encadre-suivi and mode-encadre-suivi != ''">
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:inline font-weight="bold">
											<xsl:value-of select="mode-encadre-suivi" />
										</fo:inline>
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										.......................................................................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  keep-with-next="always" text-align="justify" font-weight="bold">Article
								5 - Gratification - Avantages
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								A l'�tranger, les r�gles de gratification ou de r�mun�ration rel�veront du 
								droit local.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Lorsque le stage a lieu en France et que la dur�e du stage est sup�rieure 
								� deux mois, cons�cutifs ou non,
								celui-ci fait obligatoirement l'objet d'une
								gratification, sauf en cas de r�gles particuli�res applicables
								dans certaines
								collectivit�s d'outre-mer fran�aises et pour les
								stages relevant de l'article
								L4381-1 du code de la sant�
								publique.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le
								montant horaire de
								la
								gratification
								est fix� � 15%
								du
								plafond horaire de la
								s�curit� sociale d�fini
								en application
								de
								l'article L.241-3 du
								code de la s�curit� sociale. Une
								convention
								de branche ou un
								accord professionnel peut d�finir
								un
								montant
								sup�rieur � ce taux.
								La gratification d'un montant maximum de 15 % du plafond horaire 
								de la s�curit� sociale n'est pas soumise � cotisation sociale. 
								Au-del�, les cotisations sociales sont calcul�es sur le diff�rentiel 
								entre le montant de la gratification et 15 % du plafond horaire 
								de la S�curit� Sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								La gratification due
								par un organisme de droit public
								ne
								peut �tre
								cumul�e avec une
								r�mun�ration
								vers�e par ce m�me
								organisme au cours de
								la p�riode
								concern�e.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								La gratification est
								due sans pr�judice
								du
								remboursement des frais engag�s
								par
								le
								stagiaire pour
								effectuer son
								stage et des avantages
								offerts, le
								cas �ch�ant,
								pour la
								restauration, l'h�bergement, et
								le transport.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'organisme peut
								d�cider de verser une
								gratification pour les
								stages dont la dur�e
								est inf�rieure ou
								�gale � deux mois.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas de suspension
								ou de r�siliation de la pr�sente
								convention, le montant de la
								gratification due au stagiaire
								est
								proratis� en fonction de
								la
								dur�e du stage effectu�.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								La dur�e donnant droit
								� gratification s'appr�cie
								compte tenu du nombre de jours de
								pr�sence effective du
								stagiaire.
							</fo:block>
							<xsl:variable name="indemnisation" select="id-indemnisation" />

							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>
									<fo:block line-height="130%" hyphenate="false"
											  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline" font-weight="bold">
											LE MONTANT DE LA
											GRATIFICATION
										</fo:inline>
										est fix� � :
										<xsl:if test='$indemnisation = 2'>0</xsl:if>
										<xsl:if test='$indemnisation = 3'></xsl:if>
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
											  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">LE MONTANT DE LA
											GRATIFICATION
										</fo:inline>
										est fix� �
										<xsl:variable name="nb-montant-gratification"
													  select="montant-gratification" />
										<xsl:choose>
											<xsl:when test='$nb-montant-gratification=""'>
												0
											</xsl:when>
											<xsl:otherwise>
												<fo:inline font-weight="bold">
													<xsl:value-of select="montant-gratification" />
												</fo:inline>
												<!-- euros -->
												<xsl:text> </xsl:text>
												<xsl:value-of select="monnaie-gratification" />
												<xsl:text> </xsl:text>
												<xsl:value-of select="unite-gratification/libelle" />
												par
												<xsl:text> </xsl:text>
												<xsl:value-of select="unite-duree-gratification/libelle" />
												<xsl:text>.</xsl:text>
											</xsl:otherwise>
										</xsl:choose>
									</fo:block>
									<xsl:if
											test="mode-vers-gratification/libelle and mode-vers-gratification/libelle != ''">
										<fo:block line-height="130%" hyphenate="false"
												  language="fr" country="FR" font-size="10pt"
												  font-family="Times
 										New Roman,serif">
											<fo:inline text-decoration="underline">
												Modalit�s de versement
												de la gratification
											</fo:inline>
											:
											<fo:inline font-weight="bold">
												<xsl:value-of select="mode-vers-gratification/libelle" />
											</fo:inline>
										</fo:block>
									</xsl:if>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 5 bis - France - Acc�s aux
								droits des salari�s -
								Avantages
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								(Organisme de
								droit priv� en France sauf r�gles
								particuli�res
								applicables dans certaines collectivit�s
								d'outre-mer fran�aises)
								:
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire
								b�n�ficie des protections et droits mentionn�s aux articles
								L.1121-1, L.1152-1 et L.1153-1 du code du travail, dans les
								m�mes conditions que les salari�s.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire a
								acc�s au restaurant d'entreprise ou aux titres-restaurants
								pr�vus � l'article L.3262-1 du code du travail, dans les m�mes
								conditions que les salari�s de l'organisme d'accueil. Il
								b�n�ficie �galement de la prise en charge des frais de transport
								pr�vue � l'article L.3261-2 du m�me code.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire
								acc�de aux activit�s sociales et culturelles mentionn�es �
								l'article L.2323-83 du code du travail dans les m�mes conditions
								que les salari�s.
							</fo:block>
							<!-- <xsl:if test="structure/@id-type-structure = 3"> -->
							<!-- <fo:block line-height="110%" hyphenate="false" -->
							<!-- language="fr" country="FR" font-size="9pt" font-family="Times 
								New Roman,serif" -->
							<!-- text-align="justify"> -->
							<!-- <fo:inline text-decoration="underline"> -->
							<!-- AUTRES AVANTAGES ACCORD�S -->
							<!-- </fo:inline> -->
							<!-- : -->
							<!-- <fo:inline font-weight="bold"> -->
							<!-- <xsl:value-of select="avantages-nature" /> -->
							<!-- </fo:inline> -->
							<!-- </fo:block> -->
							<!-- </xsl:if> -->
							<fo:block break-after="page" />
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 5ter - France - Acc�s aux droits
								des agents -
								Avantages
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="4pt">
								(Organisme de droit public en
								France sauf en cas de r�gles
								particuli�res applicables dans
								certaines collectivit�s
								d'outre-mer fran�aises) :
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Les trajets effectu�s par le
								stagiaire d'un organisme de droit
								public entre son domicile et
								son lieu de stage sont pris en
								charge dans les
								conditions fix�es par le d�cret	n�2010-676 du 21
								juin 2010.								
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="5pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Est consid�r� comme sa r�sidence administrative le lieu du stage
								indiqu� dans la pr�sente convention.
							</fo:block>
							<xsl:if test="avantages-nature and avantages-nature != ''">
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<fo:inline text-decoration="underline">
										AUTRES AVANTAGES ACCORD�S
									</fo:inline>
									<fo:inline font-style="italic" font-weight="bold">
										(associ�s �
										l'article 5bis ou
										5ter selon le statut public ou
										priv� de
										l'organisme d'accueil)
										:
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<fo:inline font-weight="bold">
										<xsl:value-of select="avantages-nature" />
									</fo:inline>
								</fo:block>
							</xsl:if>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">Article 6 - R�gime de
								protection sociale
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Pendant la dur�e du stage, le stagiaire b�n�ficie d'une protection maladie 
								et accident d�s lors qu'il est affili� � un r�gime de s�curit� sociale et 
								que le droit fran�ais s'applique.  	  
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Les stages effectu�s � l'�tranger sont signal�s pr�alablement au d�part du 
								stagiaire � la S�curit� sociale lorsque celle-ci le demande. 
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Pour les stages �
								l'�tranger, les dispositions
								suivantes sont
								applicables sous
								r�serve de conformit� avec la
								l�gislation du
								pays d'accueil et de
								celle r�gissant le type
								d'organisme
								d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  font-weight="bold">
								6.1 - Gratification d'un montant maximum de 15%
								du
								plafond horaire
								de la S�curit� sociale :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas d'accident survenant au stagiaire soit au cours
								d'activit�s dans le ou les lieux du stage, soit au cours du trajet entre 
								le domicile et le lieu de stage, soit sur
								les lieux rendus utiles pour les besoins du stage et pour les
								�tudiants en m�decine, en chirurgie dentaire ou en pharmacie qui
								n'ont pas un statut hospitalier pendant le stage effectu� dans
								les conditions pr�vues au b du 2e de l'article L.412-8,
								<fo:inline text-decoration="underline">
									l'organisme d'accueil
									envoie la d�claration � la Caisse Primaire d'Assurance Maladie
								</fo:inline>
								ou la caisse comp�tente (voir adresse en page 1) en mentionnant
								l'�tablissement d'enseignement comme employeur, avec
								<fo:inline text-decoration="underline">
									copie � l'�tablissement
									d'enseignement.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.2 -
									Gratification sup�rieure � 15 % du plafond horaire de la
									S�curit� sociale :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas d'accident survenant au stagiaire soit au
								cours des activit�s dans l'organisme, soit au cours du trajet,
								soit sur des lieux rendus utiles pour les besoins de son stage,
								l'organisme d'accueil effectue toutes les d�marches n�cessaires
								aupr�s de la Caisse Primaire d'Assurance Maladie et informe
								l'�tablissement dans les meilleurs d�lais.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">
								6.3 - Protection
								maladie du/de la stagiaire � l'�tranger :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								1) 
								<fo:inline text-decoration="underline">Protection
									Protection issue du r�gime
									de s�curit� social fran�ais
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								- pour les stages
								au sein de l'Espace Economique Europ�en (EEE) effectu�s par des
								ressortissants d'un Etat de l'Union Europ�enne, ou de la
								Norv�ge, de l'Islande, du Liechtenstein, de la Suisse, ou
								encore de tout autre Etat (dans ce dernier cas, cette
								disposition n'est pas applicable pour un stage au Danemark,
								Norv�ge, Islande, Liechtenstein ou Suisse), le stagiaire doit
								demander la Carte Europ�enne d'Assurance Maladie (CEAM).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" space-before="0cm"
									  space-after="0cm" font-weight="normal" text-align="justify">
								- pour les
								stages effectu�s au Qu�bec par les �tudiant(e)s de
								nationalit�
								fran�aise, le stagiaire doit demander le formulaire
								SE401Q (104
								pour les stages en entreprises, 106 pour les stages
								en
								universit�s) ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" space-before="0cm"
									  space-after="0cm" font-weight="normal" text-align="justify">
								- dans tous
								les autres cas, le stagiaire qui engage des frais de sant�
								doit v�rifier ses conditions de prise en charge. Des �carts
								importants peuvent exister entre les frais engag�s et les tarifs
								fran�ais, base du remboursement. Il est donc fortement conseill�
								au stagiaire de souscrire une assurance maladie
								compl�mentaire
								sp�cifique, valable pour le pays et la dur�e du
								stage, aupr�s de
								l'organisme d'assurance de son choix ou,
								�ventuellement et apr�s v�rification de l'�tendue des garanties
								propos�es, aupr�s de l'organisme d'accueil si celui-ci fournit
								au stagiaire une couverture maladie en vertu du droit local
								(voir 2e ci-dessous).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								2)
								<fo:inline text-decoration="underline">
									Protection sociale issue de
									l'organisme d'accueil
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cochant la case appropri�e, l'organisme d'accueil
								indique ci-apr�s s'il fournit une protection Maladie au
								stagiaire, en vertu du droit local :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> OUI
								</fo:inline>
								: cette protection s'ajoute au maintien, � l'�tranger, des
								droits
								issus du droit fran�ais.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> NON
								</fo:inline>
								: la protection d�coule alors exclusivement du maintien, �
								l'�tranger, des droits issus du r�gime de s�curit� social fran�ais.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Si aucune case n'est coch�e, le 6.3-1 s'applique.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="bold"
									  text-align="justify">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:inline font-weight="bold">6.4 - Protection
									Accident du
									Travail du stagiaire � l'�tranger
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								1)
								<fo:inline text-decoration="underline">Pour pouvoir
									b�n�ficier de
									la l�gislation fran�aise
									sur la
								couverture accident
								de travail, le pr�sent stage doit :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								- �tre d'une
								dur�e au plus �gale � 6 mois,
								prolongations
								incluses ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								- ne donner lieu � aucune
								r�mun�ration susceptible
								d'ouvrir des droits � une protection
								accident de travail dans le
								pays d'accueil ; une indemnit� ou
								gratification est admise dans
								la limite de 15% du plafond
								horaire
								de la s�curit� sociale
								(cf point 5), et sous r�serve de
								l'accord
								de la Caisse Primaire
								d'Assurance Maladie sur la demande
								de
								maintien de droit ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								- se d�rouler exclusivement
								dans l'organisme
								signataire de la pr�sente convention ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								- se d�rouler exclusivement
								dans le pays d'accueil
								�tranger cit�.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" space-before="0cm"
									  space-after="0cm" font-weight="normal" text-align="justify">
								Lorsque ces
								conditions ne sont pas remplies, l'organisme d'accueil
								s'engage �
								cotiser pour la protection du stagiaire et � faire
								les
								d�clarations n�cessaires en cas d'accident de travail.
							</fo:block>
							<fo:block break-after="page" />
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">
									La d�claration
									des accidents
									de travail
								</fo:inline>
								incombe � l'�tablissement d'enseignement qui doit en �tre
								inform� par l'organisme d'accueil par �crit dans un d�lai de 48
								heures.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								3)
								<fo:inline text-decoration="underline">La couverture concerne les
									accidents survenus
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- dans
								l'enceinte du lieu du stage et aux heures du
								stage,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- sur le
								trajet aller-retour habituel entre la
								r�sidence du stagiaire sur
								le territoire �tranger et le lieu du
								stage,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- dans le
								cadre d'une mission confi�e par l'organisme
								d'accueil du
								stagiaire et obligatoirement par ordre de mission,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- lors du
								premier trajet pour se rendre depuis son domicile sur le lieu de
								sa r�sidence durant le stage (d�placement � la date du d�but du
								stage),
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- lors du
								dernier trajet de retour depuis sa r�sidence durant le stage �
								son domicile personnel.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								4)
								<fo:inline text-decoration="underline"> Pour le cas o�
									l'une
									seule
									des conditions pr�vues au point 6.4-1)
								</fo:inline>
								n'est pas
								remplie, l'organisme d'accueil s'engage � couvrir le
								stagiaire contre le risque d'accident de travail, de trajet et
								les maladies professionnelles et � en assurer toutes les
								d�clarations n�cessaires.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								5)
								<fo:inline text-decoration="underline">Dans tous les
									cas
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								- si le stagiaire est victime d'un accident de
								travail
								durant
								le stage, l'organisme d'accueil doit
								imp�rativement
								signaler
								imm�diatement cet accident �
								l'�tablissement
								d'enseignement ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								- si le stagiaire remplit des
								missions limit�es
								en dehors de l'organisme d'accueil ou en dehors
								du pays du
								stage, l'organisme d'accueil doit prendre toutes les
								dispositions n�cessaires pour lui fournir les assurances
								appropri�es.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">
								Article 7 - Responsabilit� et
								assurance
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								L'organisme
								d'accueil et le stagiaire d�clarent
								�tre
								garantis au titre
								de la responsabilit� civile.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Pour les stages � l'�tranger ou en outre-mer, 
								le stagiaire s'engage � souscrire un contrat d'assistance
								(rapatriement sanitaire, assistance juridique...) et un contrat
								d'assurance individuel accident.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Lorsque l'organisme d'accueil met un v�hicule � la
								disposition du stagiaire, il lui incombe de v�rifier
								pr�alablement que la police d'assurance du v�hicule couvre son
								utilisation par un �tudiant (qui dispose du permis ad�quat pour le conduire).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Lorsque dans le cadre de son stage, l'�tudiant
								utilise son propre v�hicule ou un v�hicule pr�t� par un tiers,
								il d�clare express�ment � l'assureur dudit v�hicule et, le cas
								�ch�ant, s'acquitte de la prime y aff�rente.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 8 - Discipline
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le stagiaire
								est soumis � la discipline et aux
								clauses
								du r�glement
								int�rieur qui lui sont applicables et qui
								sont
								port�es � sa
								connaissance avant le d�but du stage, notamment
								en ce
								qui
								concerne les horaires et les r�gles d'hygi�ne et de
								s�curit�
								en
								vigueur dans l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Toute sanction disciplinaire ne peut �tre d�cid�e que
								par l'�tablissement d'enseignement. Dans ce cas, l'organisme
								d'accueil informe
								l'enseignant r�f�rent et l'�tablissement des
								manquements et
								fournit �ventuellement les �l�ments constitutifs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas de manquement particuli�rement grave � la
								discipline, l'organisme d'accueil se r�serve le droit de mettre
								fin au stage tout en respectant les dispositions fix�es �
								l'article 9 de la pr�sente convention.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 9 - Cong�s - Interruption du stage
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Lorsque le stage a lieu en France (sauf
								en cas de r�gles particuli�res applicables dans certaines
								collectivit�s d'outre-mer fran�aises ou dans les organismes de
								droit public), en cas de grossesse,
								de paternit� ou d'adoption,
								le
								stagiaire b�n�ficie de cong�s
								et
								d'autorisations d'absence d'une
								dur�e �quivalente � celle
								pr�vues
								pour les salari�s aux
								articles
								L.1225-16 � L.1225-28,
								L.1225-35, L.1225-37, L.1225-46
								du code du
								travail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Pour les stages
								dont la dur�e est sup�rieure � deux
								mois et dans la limite de la
								dur�e maximale de 6 mois, des
								cong�s ou autorisations d'absence
								sont possibles.
							</fo:block>
							<xsl:variable name="nb-conges" select="nb-conges" />
							<xsl:if test="nb-conges and nb-conges != ''">
								<fo:block line-height="110%" hyphenate="false" language="fr"
										  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<fo:inline text-decoration="underline">
										NOMBRE
										DE JOURS DE CONGES
										AUTORISES
									</fo:inline>
									/ ou modalit�s des cong�s et autorisations d'absence durant le
									stage :
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr"
										  country="FR" font-size="10pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<xsl:value-of select="nb-conges" />
								</fo:block>
							</xsl:if>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="5pt"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								A l'�tranger, les cong�s ne sont pas obligatoires.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  padding-top="2pt">
								Toute interruption temporaire ou d�finitive du stage, est signal�e aux 
								signataires de la convention. Une modalit�
								de validation est mise en place le cas �ch�ant par
								l'�tablissement. En cas d'accord des parties � la convention, un
								report de la fin du stage est possible afin de permettre la
								r�alisation de la dur�e totale du stage pr�vue initialement. Ce
								report fera l'objet d'un avenant � la convention de stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Un avenant � la
								convention pourra �tre
								�tabli en cas de
								prolongation du stage sur demande conjointe de
								l'organisme
								d'accueil et du stagiaire, dans le respect de
								la dur�e
								maximale du
								stage fix�e par la loi (6 mois).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Les raisons invoqu�es seront examin�es en
								�troite concertation. La d�cision d�finitive d'arr�t du stage ne
								sera prise qu'� l'issue de cette phase de concertation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 10 - Devoir de r�serve et confidentialit�
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le devoir de
								r�serve et de confidentialit� est de rigueur absolue et
								appr�ci�
								par l'organisme
								d'accueil compte-tenu de ses
								sp�cificit�s. Le
								stagiaire
								prend donc l'engagement de n'utiliser
								en aucun cas
								les
								informations recueillies ou obtenues par eux pour
								en faire
								publication, communication � des tiers sans accord
								pr�alable de
								l'organisme d'accueil, y compris le rapport de
								stage. Cet
								engagement vaut non seulement pour la dur�e du stage
								mais
								�galement apr�s son expiration. Le stagiaire s'engage � ne
								conserver, emporter, ou prendre copie d'aucun document ou
								logiciel, de quelque nature que ce soit, appartenant �
								l'organisme d'accueil, sauf accord de ce dernier.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Dans le cadre de la confidentialit� des informations
								contenues dans le rapport de stage, l'organisme d'accueil peut
								demander une restriction de la diffusion du rapport, voire le
								retrait de certains �l�ments confidentiels.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Les personnes amen�es � en conna�tre sont contraintes
								par le secret professionnel � n'utiliser ni ne divulguer les
								informations du rapport.
							</fo:block>
							<fo:block break-after="page" />
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 11 - Propri�t� intellectuelle
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En France, dans le cas o� les activit�s du stagiaire donnent 
								lieu � la cr�ation d'une &#339;uvre prot�g�e par le droit d'auteur 
								ou la propri�t� industrielle (y compris un logiciel), un contrat doit 
								�tre sign� entre le stagiaire (auteur) et l'organisme d'accueil.						
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le contrat devra notamment pr�ciser une mission inventive, l'�tendue des droits c�d�s, 
								l'�ventuelle exclusivit�, la destination, les supports utilis�s et la dur�e de la cession, 
								ainsi que, le cas �ch�ant, le montant de la contrepartie financi�re due au stagiaire 
								au titre de la cession. Ces dispositions s'appliquent sauf en cas de r�gles particuli�res 
								relatives aux stages r�alis�s au sein d'une personne morale de droit public ou de droit 
								priv� r�alisant de la recherche qui sont soumis � l'article L611-7-1 du code de 
								la propri�t� intellectuelle.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">
								Article 12 - Fin de stage -
								Rapport - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">Attestation de stage
								</fo:inline>
								: � l'issue du stage, l'organisme d'accueil d�livre une
								attestation dont le mod�le figure en annexe, mentionnant au
								minimum la dur�e effective du stage et, le cas �ch�ant, le
								montant de la gratification per�ue. 
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								2)
								<fo:inline text-decoration="underline">Qualit� du stage
								</fo:inline>
								: � l'issue du stage, les parties � la pr�sente convention sont
								invit�es � formuler une appr�ciation sur la qualit� du stage.
								Le
								stagiaire transmet au service comp�tent de
								l'�tablissement
								d'enseignement un document dans lequel il
								�value la qualit�
								de
								l'accueil dont il a b�n�fici� au sein
								de l'organisme
								d'accueil. Ce
								document n'est pas pris en compte
								dans l'�valuation du stagiaire.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline">Evaluation de la c�sure 
								 sous forme de stage									
								</fo:inline>
								: � l'issue de la p�riode de c�sure sous forme de stage et 
								dans le cas o� cette p�riode ne comporte pas d'autres formes de c�sure, 
								un bilan doit �tre �tabli � la fin du stage. 
								Ce bilan peut servir de support � l'attribution de cr�dits ECTS.								
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  padding-top="2pt" padding-bottom="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								<fo:inline text-decoration="underline">NOMBRE D'ECTS (le
									cas
									�ch�ant)
								</fo:inline>
								:
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
							<fo:block line-height="110%" hyphenate="false" language="fr"
				                country="FR" font-size="7.5pt" font-family="Times New Roman,serif"
				                padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
				                padding-bottom="0.3cm" font-style="italic">
				                (attention, dans le cadre d'une c�sure sous forme de stage, 
				                les ECTS sont le seul mode de validation possible).			
		                    </fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" font-weight="bold">
								Article 13 -
								Droit applicable - Tribunaux comp�tents
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								La pr�sente convention
								est r�gie exclusivement par le
								droit fran�ais.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Tout litige non r�solu
								par voie amiable sera soumis �
								la comp�tence de la juridiction
								fran�aise comp�tente.
							</fo:block>
                            <fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Conform�ment � la r�glementation relative � la protection des donn�es 
								personnelles, le stagiaire devra �tre inform� du traitement r�serv� 
								aux donn�es personnelles qu'il aura �t� amen� � fournir � l'�tablissement 
								de formation et � l'organisme d'accueil.
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
			<fo:block line-height="110%" hyphenate="false" language="fr"
					  country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
					  country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
					  text-align="center">
				____________________________________________________________
			</fo:block>
			<fo:block line-height="200%" hyphenate="false" language="fr"
					  country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
					  country="FR" font-size="10pt" font-family="Times New Roman,serif">
				FAIT �
				..................................................... le
				.....................................................
			</fo:block>
			<fo:block line-height="150%" hyphenate="false" language="fr"
					  country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif"
									  text-decoration="underline" font-weight="bold">
								POUR L'�TABLISSEMENT
								D'ENSEIGNEMENT
							</fo:block>
							<!-- Representant etablissement -->
							<xsl:choose>
								<xsl:when
										test="nom-signataire-composante or centre-gestion/nom-viseur">
									<xsl:choose>
										<xsl:when test="centre-gestion/nom-viseur">
											<fo:block line-height="110%" padding-top="2pt"
													  padding-bottom="2pt" hyphenate="false" language="fr"
													  country="FR" font-size="10pt" font-family="Times New Roman,serif">
												Viseur du centre, par d�l�gation,
												<fo:inline font-weight="bold">
													<xsl:call-template name="start_upper">
														<xsl:with-param name="prenom">
															<xsl:value-of select="centre-gestion/prenom-viseur" />
														</xsl:with-param>
													</xsl:call-template>
													<xsl:text> </xsl:text>
													<xsl:value-of
															select="translate(centre-gestion/nom-viseur,$lowers,$uppers)" />
												</fo:inline>
											</fo:block>
										</xsl:when>
										<xsl:otherwise>
											<fo:block line-height="110%" padding-top="2pt"
													  padding-bottom="2pt" hyphenate="false" language="fr"
													  country="FR" font-size="10pt" font-family="Times New Roman,serif"
													  font-weight="bold">
												<xsl:value-of select="nom-signataire-composante" />
											</fo:block>
										</xsl:otherwise>
									</xsl:choose>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" padding-top="2pt"
											  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
											  font-size="10pt" font-family="Times New Roman,serif">
										Nom et signature du repr�sentant
										de l'�tablissement
									</fo:block>
									<fo:block line-height="110%" padding-top="8pt"
											  hyphenate="false" language="fr" country="FR" font-size="10pt"
											  font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif"
									  text-decoration="underline" font-weight="bold">
								POUR L'ORGANISME
								D'ACCUEIL
							</fo:block>
							<xsl:choose>
								<xsl:when test="signataire/nom">
									<fo:block line-height="110%" padding-top="2pt"
											  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
											  font-size="10pt" font-family="Times New Roman,serif"
											  font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="signataire/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(signataire/nom,$lowers,$uppers)" />
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" padding-top="2pt"
											  hyphenate="false" language="fr" country="FR" font-size="10pt"
											  font-family="Times New Roman,serif">
										Nom et signature du repr�sentant de l'organisme
										d'accueil
									</fo:block>
									<fo:block line-height="110%" padding-top="8pt"
											  hyphenate="false" language="fr" country="FR" font-size="10pt"
											  font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell>
							<!-- Stagiaire -->
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif"
									  text-decoration="underline" font-weight="bold">
								STAGIAIRE (ou son
								repr�sentant l�gal le cas �ch�ant)
							</fo:block>
							<xsl:choose>
								<xsl:when test="etudiant/nom">
									<fo:block line-height="110%" padding-top="2pt"
											  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
											  font-size="10pt" font-family="Times New Roman,serif"
											  font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="etudiant/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(etudiant/nom-marital,$lowers,$uppers)" />
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" padding-top="2pt"
											  hyphenate="false" language="fr" country="FR" font-size="10pt"
											  font-family="Times New Roman,serif">
										Nom et signature
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
			<fo:block line-height="110%" hyphenate="false" language="fr"
					  country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
					  country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell>
							<!-- Tuteur pedago -->
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif"
									  text-decoration="underline" font-weight="bold">
								L'enseignant r�f�rent du
								stagiaire
							</fo:block>
							<xsl:choose>
								<xsl:when test="enseignant/nom">
									<fo:block line-height="110%" padding-top="2pt"
											  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
											  font-size="10pt" font-family="Times New Roman,serif"
											  font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="enseignant/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(enseignant/nom,$lowers,$uppers)" />
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" padding-top="2pt"
											  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
											  font-size="10pt" font-family="Times New Roman,serif">
										Nom et signature
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
						</fo:table-cell>
						<fo:table-cell>
							<!-- Tuteur pro -->
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif"
									  text-decoration="underline" font-weight="bold">
								Le tuteur de stage de
								l'organisme d'accueil
							</fo:block>
							<xsl:choose>
								<xsl:when test="contact/nom">
									<fo:block line-height="110%" padding-top="2pt"
											  hyphenate="false" language="fr" country="FR" font-size="10pt"
											  font-family="Times New Roman,serif" font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="contact/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(contact/nom,$lowers,$uppers)" />
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" padding-top="2pt"
											  hyphenate="false" language="fr" country="FR" font-size="10pt"
											  font-family="Times New Roman,serif">
										Nom et signature
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<!-- mises en majuscules -->
	<xsl:variable name='lowers'
				  select='"abcdefghijklmnopqrstuvwxyz�������������������������������"' />
	<xsl:variable name='uppers'
				  select='"ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������"' />
	<!-- majuscule pour 1er lettre de chaque terme (cas prenom compos�s) -->
	<xsl:template name="start_upper">
		<xsl:param name="prenom" />
		<xsl:variable name="temp-prenom">
			<xsl:call-template name="start_upper_bar">
				<xsl:with-param name="prenom">
					<xsl:value-of select="$prenom" />
				</xsl:with-param>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="clean-temp-prenom">
			<xsl:choose>
				<xsl:when
						test="substring($temp-prenom, string-length($temp-prenom),  string-length($temp-prenom) +1  ) = '-'">
					<xsl:value-of
							select='substring($temp-prenom,1, string-length($temp-prenom)-1 )' />
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select='$temp-prenom' />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:for-each select='str:split($clean-temp-prenom, " ")'>
			<xsl:value-of
					select='concat(
          translate(substring(., 1, 1), $lowers, $uppers),
          substring(., 2),
          " "
         )' />
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="start_upper_bar">
		<xsl:param name="prenom" />
		<xsl:for-each select='str:split($prenom, "-")'>
			<xsl:value-of
					select='concat(
          translate(substring(., 1, 1), $lowers, $uppers),
          translate(substring(., 2),$uppers,$lowers),
          "-"
         )' />
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
