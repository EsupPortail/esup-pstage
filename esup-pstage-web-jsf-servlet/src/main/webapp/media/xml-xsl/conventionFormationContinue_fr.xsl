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
			<xsl:call-template name="CPAM" />
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
			<fo:inline>
				1) Attestation de stage
			</fo:inline>
			/
			<!--<fo:inline text-decoration="underline">-->
			<!--2) Fiche de stage � l'�tranger-->
			<!--(pour informations s�curit� sociale voir site cleiss.fr - pour fiche-->
			<!--pays voir site diplomatie.gouv.fr)-->
			<!--</fo:inline>-->
			<!--/-->
			<fo:inline>
				2) Autres annexes (le cas
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
								entre
							</fo:inline>
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
			document, les mots "stagiaire", "r�f�rent",
			"tuteur de
			stage", "repr�sentant l�gal", et "�tudiant" sont utilis�s
			au masculin.
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
									D'ENSEIGNEMENT
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
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Composante/UFR :
							</fo:inline>
							<xsl:value-of select="centre-gestion/nom-centre" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm">
							<fo:inline font-weight="bold">
								Adresse (si diff�rente de celle
								de l'�tablissement) :
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

						<!--<xsl:choose>-->
							<!--<xsl:when test="nom-etab-certif">-->
								<!--<fo:block line-height="110%" hyphenate="false" language="fr"-->
										  <!--country="FR" font-size="9pt" font-family="Times New Roman,serif">-->
									<!--<fo:leader />-->
								<!--</fo:block>-->

								<!--<fo:block line-height="110%" hyphenate="false" language="fr"-->
										  <!--country="FR" font-size="9pt" font-family="Times New Roman,serif"-->
										  <!--padding-left="0.141cm" padding-right="0.141cm" padding-top="0cm"-->
										  <!--padding-bottom="0.035cm" text-align="center">-->
									<!--<fo:inline font-weight="bold">-->
										<!--1bis - -->
										<!--<fo:inline text-decoration="underline">L'�TABLISSEMENT-->
											<!--DE CERTIFICATION (si diff�rent)-->
										<!--</fo:inline>-->
									<!--</fo:inline>-->
								<!--</fo:block>-->
								<!--<fo:block line-height="130%" hyphenate="false" language="fr"-->
										  <!--country="FR" font-size="9pt" font-family="Times New Roman,serif"-->
										  <!--padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"-->
										  <!--padding-bottom="0.035cm">-->
									<!--<fo:inline font-weight="bold">-->
										<!--Nom :-->
									<!--</fo:inline>-->
									<!--<xsl:value-of select="nom-etab-certif" />-->
								<!--</fo:block>-->
								<!--<xsl:choose>-->
									<!--<xsl:when test="adresse-etab-certif">-->
										<!--<fo:block line-height="130%" hyphenate="false" language="fr"-->
												  <!--country="FR" font-size="9pt" font-family="Times New Roman,serif"-->
												  <!--padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"-->
												  <!--padding-bottom="0.035cm">-->
											<!--<fo:inline font-weight="bold">-->
												<!--Adresse :-->
											<!--</fo:inline>-->
											<!--<xsl:value-of select="adresse-etab-certif" />-->
										<!--</fo:block>-->
									<!--</xsl:when>-->
								<!--</xsl:choose>-->
								<!--<fo:block line-height="130%" hyphenate="false" language="fr"-->
								<!--country="FR" font-size="9pt" font-family="Times New Roman,serif"-->
								<!--padding-left="0.141cm" padding-right="0.141cm">-->
								<!--<fo:inline font-weight="bold">-->
								<!--T�l :-->
								<!--</fo:inline>-->
								<!--<xsl:value-of select="centre-gestion/telephone" />-->
								<!--&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;-->
								<!--</fo:block>-->
							<!--</xsl:when>-->
							<!--<xsl:otherwise>-->

							<!--</xsl:otherwise>-->
						<!--</xsl:choose>-->
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
								INTITUL� DE LA CERTIFICATION PR�PAR�E
								DANS
								L'�TABLISSEMENT D'ENSEIGNEMENT SUP�RIEUR :
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
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.1cm">
							<fo:inline font-weight="bold" text-decoration="underline">
								MODALIT�S DU STAGE
							</fo:inline>
							:
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Sujet du stage
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

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Pr�sence :
							</fo:inline>
							<xsl:choose>
								<xsl:when test="type-presence">
									<fo:inline>
										<xsl:value-of select="type-presence" />
									</fo:inline>
								</xsl:when>
							</xsl:choose>
						</fo:block>

						<fo:block line-height="110%" padding-top="1pt"
								  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
							<fo:inline font-weight="bold">
								Le stage se d�roulera � :
							</fo:inline>
							<xsl:value-of select="temps-travail/libelle" />.
							<fo:inline font-weight="bold">
								Pr�cisez la quotit� :
							</fo:inline>
							<xsl:value-of select="quotite-travail" />%.
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							Une feuille de pr�sence sera r�guli�rement fournie par l'�tablissement d'enseignement.
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Soit une dur�e hebdomadaire maximale de pr�sence du stagiaire dans l'organisme d'accueil de
							</fo:inline>
							<xsl:value-of select="nb-heures-hebdo" /> heures.
						</fo:block>
						<fo:block line-height="100%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
							<fo:leader />
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
												La dur�e effective du stage est de
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
												La dur�e effective du stage est de
											</fo:inline>
											<fo:inline>
												<xsl:value-of select="duree-exceptionnelle" />
												<xsl:text> heures </xsl:text>
											</fo:inline>
											<fo:inline>
												(repr�sentant une dur�e
												totale
												de
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
												</fo:inline>)
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
										La dur�e effective du stage est de
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									semaines
								</fo:block>
							</xsl:otherwise>
						</xsl:choose>
						<fo:block line-height="100%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>

						<xsl:choose>
							<xsl:when test="commentaire-duree-travail">
								<xsl:if test="commentaire-duree-travail != ''">
									<fo:block line-height="130%" hyphenate="false" language="fr"
											  country="FR" font-size="9pt" font-family="Times New Roman,serif"
											  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											  padding-bottom="0.035cm">
										<fo:inline font-weight="bold">
											Commentaire :
										</fo:inline>
										<fo:inline>
											<xsl:value-of select="commentaire-duree-travail" />
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
								Pr�cisions :
							</fo:inline>
							Si le stagiaire doit �tre pr�sent dans l'organisme d'accueil la nuit, le dimanche ou jours f�ri�s,
							son accord pr�alable est obligatoire, pr�cisez ces cas particuliers :
							<xsl:value-of select="travail-nuit-ferie" />
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
							Nom et pr�nom du r�f�rent :
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
						<!-- <fo:block line-height="130%" hyphenate="false" language="fr" -->
						<!-- country="FR" font-size="9pt" font-family="Times New Roman,serif" -->
						<!-- padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm" -->
						<!-- padding-bottom="0.035cm"> -->
						<!-- <fo:inline font-weight="bold"> -->
						<!-- Fonction (ou discipline) : -->
						<!-- </fo:inline> -->
						<!-- <xsl:value-of select="enseignant/type-personne" /> -->
						<!-- </fo:block> -->
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
	<xsl:template name="CPAM">
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
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>

		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="8pt" font-family="Times New Roman,serif"
				  padding-top="80pt" text-align="center">
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
								La pr�sente convention r�gle les rapports entre l'organisme d'accueil, l'�tablissement d'enseignement et le stagiaire.
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
								Le stage s'inscrit dans le cadre de la formation et du projet personnel et professionnel d'�volution,
								de reconversion ou d'insertion professionnelle du stagiaire. Il correspond � une p�riode de mise en situation
								en milieu professionnel au cours de laquelle il met en oeuvre les apprentissages de sa formation en vue de
								l'acquisition ou du d�veloppement de comp�tences professionnelles.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le programme du stage �tabli par le r�f�rent du stagiaire de l'�tablissement d'enseignement
								et le tuteur nomm� par l'organisme d'accueil, en accord avec le stagiaire est le suivant :
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">Objectifs
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">Activit�s confi�es
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

							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'organisme d'accueil garantit que les activit�s confi�es ne constituent pas une t�che r�guli�re
								correspondant � un poste de travail permanent, ne correspondent pas � un accroissement temporaire
								de l'activit� de l'organisme d'accueil, � un emploi saisonnier ou au remplacement d'un salari� ou d'un
								agent absent ou dont le contrat de travail est suspendu.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">Article 3 - Accueil
								et
								encadrement du stagiaire
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire est suivi par un r�f�rent d�sign� dans la pr�sente convention qui pourra organiser,
								selon les moyens disponibles de l'organisme d'accueil (rendez-vous t�l�phoniques, visioconf�rences,
								voies �lectroniques...), l'encadrement du stagiaire.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le tuteur de stage d�sign� par l'organisme d'accueil
								dans la
								pr�sente convention est charg� d'assurer le suivi du stagiaire
								et d'optimiser les conditions de r�alisation du
								stage
								conform�ment aux stipulations p�dagogiques d�finies.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Toute difficult� survenue dans la r�alisation et le d�roulement du stage,
								qu'elle soit constat�e par le stagiaire, par le r�f�rent ou par le tuteur de
								stage, doit �tre port�e � la connaissance de l'ensemble des parties afin d'�tre r�solue
								au plus vite.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									MODALIT�S
									D'ENCADREMENT
								</fo:inline>
								(IMPORTANT) :
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
								4 - Indemnit� - Avantages
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'indemnisation du stagiaire en formation continue n'est pas obligatoire et est
								interdite dans un organisme de droit public.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								L'organisme d'accueil peut d�cider de verser au stagiaire une indemnit� et/ou des
								avantages en nature (restauration, frais de transport, h�bergement..) dont le montant
								est fix� librement, en concertation avec le stagiaire, sauf contre-indication du contrat
								de formation professionnelle.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>

							<xsl:variable name="indemnisation" select="id-indemnisation" />
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>
									<fo:block line-height="130%" hyphenate="false"
											  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline" font-weight="bold">
											MONTANT DE L'INDEMNIT�
										</fo:inline> : 0
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
											  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">
											MONTANT DE L'INDEMNIT�
										</fo:inline> :
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
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Contrairement aux stages r�alis�s dans le cadre de la formation initiale,
								les sommes vers�es sont assujetties � l'ensemble des charges patronales et salariales
								(d�s le 1er euro) pour les organismes fran�ais.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								En cas de suspension ou de r�siliation de la pr�sente convention, le montant de
								l'indemnit� due au stagiaire est proratis� en fonction de la dur�e du stage effectu�e.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 4 bis - Acc�s aux
								droits des salari�s -
								Avantages
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								(Organisme de
								droit priv� en France sauf en cas de r�gles
								particuli�res qui peuvent �tre applicables dans certaines collectivit�s
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
								Le stagiaire peut avoir acc�s au restaurant d'entreprise ou aux titres-restaurants
								pr�vus � l'article L.3262-1 du code du travail, dans les m�mes conditions que les
								salari�s de l'organisme d'accueil. Il peut b�n�ficier �galement de la prise en charge
								des frais de transport pr�vue � l'article L.3261-2 du m�me code.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire peut avoir acc�s aux activit�s sociales et culturelles mentionn�es �
								l'article L.2323-83 du code du travail dans les m�mes conditions que les salari�s.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire accueilli dans un organisme de droit priv� et qui effectue une mission
								dans ce cadre b�n�ficie de la prise en charge de ses frais de d�placement temporaire
								selon la r�glementation en vigueur.
							</fo:block>


							<fo:block break-after="page" />


							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 4ter - Acc�s aux droits
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
								Le stagiaire accueilli dans un organisme de droit public et qui effectue une mission
								dans ce cadre b�n�ficie de la prise en charge de ses frais de d�placement temporaire
								selon la r�glementation en vigueur.
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
										  text-align="justify" padding-top="2pt">
									<fo:inline text-decoration="underline">
										LISTE DES AVANTAGES ACCORD�S
									</fo:inline>
									<fo:inline font-style="italic" font-weight="bold">
										(associ�s �
										l'article 4bis ou
										4ter selon le statut public ou
										priv� de
										l'organisme d'accueil)
										:
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  text-align="justify" padding-top="2pt">
									<fo:inline font-weight="bold">
										<xsl:value-of select="avantages-nature" />
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr"
										  country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</xsl:if>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">Article 5 - R�gime de
								protection sociale maladie - accidents
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Pendant la dur�e du stage, le stagiaire conserve son statut de b�n�ficiaire de la
								formation professionnelle continue, � ce titre, il reste affili� au r�gime de s�curit�
								sociale dont il rel�ve avant son entr�e en formation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:inline text-decoration="underline">
									Maladie
								</fo:inline> : Le b�n�ficiaire de la formation professionnelle continue qui ne rel�ve
								d'aucun r�gime avant son entr�e en formation, doit v�rifier qu'il b�n�ficie bien de la
								protection maladie universelle aupr�s de la caisse d'assurance maladie de son lieu de
								r�sidence et souscrire une assurance volontaire individuelle le couvrant au titre des
								accidents du travail et des maladies professionnelles et fournir, � l'�tablissement
								d'enseignement, l'attestation de couverture. La charge des cotisations
								incombe au stagiaire.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-bottom="2pt"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">
									Accidents
								</fo:inline> : En cas d'accident survenant au b�n�ficiaire de la formation professionnelle
								continue dans l'organisme d'accueil, au cours du trajet domicile-lieu de stage ou
								Etablissement d'enseignement-lieu de stage ou lors des missions confi�es par
								l'organisme d'accueil dans le cadre de la r�alisation du programme du stage,
								le stagiaire accident� dispose de 24h pour avertir l'organisme d'accueil qui s'engage
								� faire parvenir aussit�t tous les �l�ments permettant la d�claration de l'accident �
								l'�tablissement d'enseignement. Au plus tard 48h (non compris les dimanches et
								jours f�ri�s) apr�s avoir eu connaissance de l'accident, l'�tablissement
								d'enseignement proc�de � la d�claration d'accident du travail par lettre recommand�e
								aupr�s de la caisse primaire d'assurance maladie du lieu de r�sidence
								habituelle du stagiaire.
							</fo:block>

							<fo:table table-layout="fixed" width="100%">
								<fo:table-column column-width="proportional-column-width(1)" />
								<fo:table-body>
									<fo:table-row>
										<fo:table-cell padding-left="0.141cm" padding-right="0.141cm"
													   padding-top="0.2cm" padding-bottom="0.035cm" border="0.018cm solid #000000">
											<fo:block line-height="130%" hyphenate="false" language="fr"
													  country="FR" font-size="9pt" font-family="Times New Roman,serif">
												Service de l'�tablissement d'enseignement � informer :
											</fo:block>
											<fo:block line-height="130%" hyphenate="false" language="fr"
													  country="FR" font-size="9pt" font-family="Times New Roman,serif">
												<fo:inline font-weight="bold">
													<xsl:value-of select="centre-gestion/nom-centre" /> -
												</fo:inline>
												<fo:inline>
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
								</fo:table-body>
							</fo:table>

							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="3pt"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								En cas de fermeture administrative de l'�tablissement d'enseignement,
								ce dernier en informe l'organisme d'accueil afin qu'il puisse �tablir la d�claration
								en mentionnant l'�tablissement d'enseignement en qualit� d'employeur et l'adresser
								� la caisse primaire d'assurance maladie du stagiaire avec copie �
								l'�tablissement d'enseignement.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">
								Article 6 - Responsabilit� et assurance
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
								Pour les stages � l'�tranger ou outre-mer, le
								stagiaire s'engage � souscrire un contrat d'assistance
								(rapatriement sanitaire, assistance juridique...) et un contrat
								d'assurance individuel accident.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								L'organisme d'accueil peut autoriser le stagiaire � se d�placer. Lorsque l'organisme
								d'accueil met un v�hicule � la disposition du stagiaire, il lui incombe de v�rifier
								pr�alablement que la police d'assurance du v�hicule couvre son utilisation
								par un stagiaire.
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
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Selon le cadre du stage, le stagiaire s'assurera d'�tre en r�gle avec les obligations
								tant sanitaires que r�glementaires (notamment hygi�ne et s�curit�)
								propres � l'activit� ou au lieu du stage.
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
								Article 7 - Discipline
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
								les tuteurs de stage et l'�tablissement d'enseignement des
								manquements et
								fournit �ventuellement les �l�ments constitutifs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas de manquement particuli�rement grave � la discipline,
								l'organisme d'accueil se r�serve le droit de mettre fin au stage tout en respectant
								les dispositions fix�es � l'article 8 de la pr�sente convention,
								et de poursuivre p�nalement le stagiaire.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 8 - Absences - Interruption du stage
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire est autoris� � revenir dans son �tablissement d'enseignement pendant
								la dur�e du stage pour y suivre les cours, s�minaires pr�vus par le planning de la
								formation ; les dates sont port�es � la connaissance de l'organisme d'accueil par
								l'�tablissement d'enseignement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Des autorisations d'absence sont possibles sous r�serve que la dur�e du stage soit
								respect�e. Elles sont d�finies entre le stagiaire et l'organisme d'accueil,
								qui en informe l'�tablissement d'enseignement.
							</fo:block>
							<xsl:variable name="nb-conges" select="nb-conges" />
							<xsl:if test="nb-conges and nb-conges != ''">
								<fo:block line-height="110%" hyphenate="false" language="fr"
										  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<fo:inline text-decoration="underline">
										NOMBRE
										DE JOURS D'ABSENCES AUTORISEES
									</fo:inline>
									/ ou modalit�s des autorisations d'absence durant le stage :
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr"
										  country="FR" font-size="10pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<xsl:value-of select="nb-conges" />
								</fo:block>
							</xsl:if>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="5pt"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Toute absence du stagiaire doit �tre justifi�e et signal�e par le stagiaire �
								l'organisme d'accueil et � l'�tablissement d'enseignement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  padding-top="2pt">
								Toute interruption temporaire du stage doit �tre signal�e aux autres
								parties � la convention et au r�f�rent.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Service de l'�tablissement d'enseignement � informer :
							</fo:block>
							<fo:block line-height="130%" hyphenate="false" language="fr"
									  country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:value-of select="centre-gestion/nom-centre" /> -
								</fo:inline>
								<fo:inline>
									<xsl:value-of select="centre-gestion/batiment-residence" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="centre-gestion/voie" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="centre-gestion/code-postal" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="centre-gestion/commune" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Si le stagiaire n'a pas r�alis� la dur�e de stage n�cessaire pour sa validation
								un report de la fin du stage est possible afin de permettre la r�alisation de la
								dur�e totale du stage pr�vue initialement ou une autre modalit� de validation est
								mise en place le cas �ch�ant par l'�tablissement d'enseignement.
								En tout �tat de cause le report de la fin de stage n'est pas possible au-del� de la
								date de d�lib�ration du jury du dipl�me. Ce report fera l'objet d'un avenant
								� la pr�sente convention.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas de volont� d'une des trois parties (organisme d'accueil, stagiaire,
								�tablissement d'enseignement) d'arr�ter le stage, celle-ci doit imm�diatement en
								informer les deux autres parties par �crit. Les raisons invoqu�es seront examin�es
								en �troite concertation. La d�cision d�finitive d'arr�t du stage ne sera prise qu'�
								l'issue de cette phase de concertation.
							</fo:block>


							<fo:block break-after="page" />


							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 9 - Devoir de r�serve et confidentialit�
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le devoir de
								r�serve est de rigueur absolue et
								appr�ci�
								par l'organisme
								d'accueil compte-tenu de ses
								sp�cificit�s. Le
								stagiaire
								prend donc l'engagement de n'utiliser
								en aucun cas
								les
								informations recueillies ou obtenues pour
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
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 10 - Propri�t� intellectuelle
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Conform�ment au code de la propri�t� intellectuelle,
								dans le cas o� les activit�s du stagiaire donnent lieu �
								la
								cr�ation d'une &#339;uvre prot�g�e par le droit d'auteur ou la
								propri�t� industrielle (y compris un logiciel), si l'organisme
								d'accueil souhaite l'utiliser et que le stagiaire en est
								d'accord, un contrat devra �tre sign� entre le stagiaire
								(auteur) et l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le contrat devra alors notamment pr�ciser l'�tendue
								des droits c�d�s, l'�ventuelle exclusivit�, la destination, les
								supports utilis�s et la dur�e de la cession, ainsi que, le cas
								�ch�ant, le montant de la r�mun�ration due au stagiaire au
								titre
								de la cession. Cette clause s'applique quel que soit le
								statut de
								l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">
								Article 11 - Fin de stage -
								Rapport - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">Attestation de stage
								</fo:inline>
								: � l'issue du stage, l'organisme d'accueil d�livre une attestation dont le mod�le
								figure en annexe, mentionnant au minimum la dur�e effective du stage ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								2)
								<fo:inline text-decoration="underline">Qualit� du stage
								</fo:inline>
								: � l'issue du stage, les trois parties � la convention sont invit�es � formuler une
								appr�ciation sur la qualit� du stage. Le stagiaire transmet au service comp�tent de
								l'�tablissement d'enseignement un document dans lequel il �value la qualit� de
								l'accueil dont il a b�n�fici� au sein de l'organisme d'accueil. Ce document n'est pas
								pris en compte dans son �valuation ou dans l'obtention du dipl�me ou
								de la certification.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline">�valuation de l'activit�
									du
									stagiaire
								</fo:inline>
								: � l'issue du stage, l'organisme d'accueil renseigne une fiche d'�valuation de
								l'activit� du stagiaire qu'il retourne au r�f�rent
								(ou pr�ciser si fiche annexe ou modalit�s d'�valuation pr�alablement
								d�finis en accord avec le r�f�rent).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								4)
								<fo:inline text-decoration="underline">Modalit�s d'�valuation
									p�dagogiques
								</fo:inline>
								:
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" />
								</fo:inline>,
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
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
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								5) Le tuteur de l'organisme
								d'accueil ou tout membre de l'organisme d'accueil appel� � se
								rendre dans l'�tablissement d'enseignement dans le cadre de la
								pr�paration, du d�roulement et de la validation du stage ne peut
								pr�tendre � une quelconque prise en charge ou indemnisation de
								la part de l'�tablissement d'enseignement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" font-weight="bold">
								Article 12 -
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
							<fo:block line-height="400%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
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
			<!--<fo:table table-layout="fixed" width="100%">-->
			<!--<fo:table-column column-width="proportional-column-width(1)" />-->
			<!--<fo:table-column column-width="proportional-column-width(1)" />-->
			<!--<fo:table-body>-->
			<!--<fo:table-row>-->
			<!--<fo:table-cell>-->
			<!--&lt;!&ndash; Tuteur pedago &ndash;&gt;-->
			<!--<fo:block line-height="110%" padding-top="2pt"-->
			<!--padding-bottom="2pt" hyphenate="false" language="fr" country="FR"-->
			<!--font-size="10pt" font-family="Times New Roman,serif"-->
			<!--text-decoration="underline" font-weight="bold">-->
			<!--L'enseignant r�f�rent du-->
			<!--stagiaire-->
			<!--</fo:block>-->
			<!--<xsl:choose>-->
			<!--<xsl:when test="enseignant/nom">-->
			<!--<fo:block line-height="110%" padding-top="2pt"-->
			<!--padding-bottom="2pt" hyphenate="false" language="fr" country="FR"-->
			<!--font-size="10pt" font-family="Times New Roman,serif"-->
			<!--font-weight="bold">-->
			<!--<xsl:call-template name="start_upper">-->
			<!--<xsl:with-param name="prenom">-->
			<!--<xsl:value-of select="enseignant/prenom" />-->
			<!--</xsl:with-param>-->
			<!--</xsl:call-template>-->
			<!--<xsl:text> </xsl:text>-->
			<!--<xsl:value-of select="translate(enseignant/nom,$lowers,$uppers)" />-->
			<!--</fo:block>-->
			<!--<fo:block line-height="110%" hyphenate="false"-->
			<!--language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">-->
			<!--<fo:leader />-->
			<!--</fo:block>-->
			<!--</xsl:when>-->
			<!--<xsl:otherwise>-->
			<!--<fo:block line-height="110%" padding-top="2pt"-->
			<!--padding-bottom="2pt" hyphenate="false" language="fr" country="FR"-->
			<!--font-size="10pt" font-family="Times New Roman,serif">-->
			<!--Nom et signature-->
			<!--</fo:block>-->
			<!--<fo:block line-height="110%" hyphenate="false"-->
			<!--language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">-->
			<!--......................................................-->
			<!--</fo:block>-->
			<!--</xsl:otherwise>-->
			<!--</xsl:choose>-->
			<!--</fo:table-cell>-->
			<!--<fo:table-cell>-->
			<!--&lt;!&ndash; Tuteur pro &ndash;&gt;-->
			<!--<fo:block line-height="110%" padding-top="2pt"-->
			<!--padding-bottom="2pt" hyphenate="false" language="fr" country="FR"-->
			<!--font-size="10pt" font-family="Times New Roman,serif"-->
			<!--text-decoration="underline" font-weight="bold">-->
			<!--Le tuteur de stage de-->
			<!--l'organisme d'accueil-->
			<!--</fo:block>-->
			<!--<xsl:choose>-->
			<!--<xsl:when test="contact/nom">-->
			<!--<fo:block line-height="110%" padding-top="2pt"-->
			<!--hyphenate="false" language="fr" country="FR" font-size="10pt"-->
			<!--font-family="Times New Roman,serif" font-weight="bold">-->
			<!--<xsl:call-template name="start_upper">-->
			<!--<xsl:with-param name="prenom">-->
			<!--<xsl:value-of select="contact/prenom" />-->
			<!--</xsl:with-param>-->
			<!--</xsl:call-template>-->
			<!--<xsl:text> </xsl:text>-->
			<!--<xsl:value-of select="translate(contact/nom,$lowers,$uppers)" />-->
			<!--</fo:block>-->
			<!--<fo:block line-height="110%" hyphenate="false"-->
			<!--language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">-->
			<!--<fo:leader />-->
			<!--</fo:block>-->
			<!--</xsl:when>-->
			<!--<xsl:otherwise>-->
			<!--<fo:block line-height="110%" padding-top="2pt"-->
			<!--hyphenate="false" language="fr" country="FR" font-size="10pt"-->
			<!--font-family="Times New Roman,serif">-->
			<!--Nom et signature-->
			<!--</fo:block>-->
			<!--<fo:block line-height="110%" hyphenate="false"-->
			<!--language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">-->
			<!--......................................................-->
			<!--</fo:block>-->
			<!--</xsl:otherwise>-->
			<!--</xsl:choose>-->
			<!--</fo:table-cell>-->
			<!--</fo:table-row>-->
			<!--</fo:table-body>-->
			<!--</fo:table>-->
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
