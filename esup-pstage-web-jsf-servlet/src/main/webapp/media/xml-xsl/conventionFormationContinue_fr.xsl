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
			Fiches à annexer à la convention :
			<fo:inline>
				1) Attestation de stage
			</fo:inline>
			/
			<!--<fo:inline text-decoration="underline">-->
			<!--2) Fiche de stage à l'étranger-->
			<!--(pour informations sécurité sociale voir site cleiss.fr - pour fiche-->
			<!--pays voir site diplomatie.gouv.fr)-->
			<!--</fo:inline>-->
			<!--/-->
			<fo:inline>
				2) Autres annexes (le cas
				échéant)
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
								n°
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
			document, les mots "stagiaire", "référent",
			"tuteur de
			stage", "représentant légal", et "étudiant" sont utilisés
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
								<fo:inline text-decoration="underline">L'ÉTABLISSEMENT
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
										Tél :
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
							Représenté par (signataire
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
													Qualité du représentant :
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
													Qualité du représentant :
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
								Adresse (si différente de celle
								de l'établissement) :
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
								Tél :
							</fo:inline>
							<xsl:value-of select="centre-gestion/telephone" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm">
							<fo:inline font-weight="bold">
								Mél :
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
										<!--<fo:inline text-decoration="underline">L'ÉTABLISSEMENT-->
											<!--DE CERTIFICATION (si différent)-->
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
								<!--Tél :-->
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
								Représenté par (nom du
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
								Qualité du représentant :
							</fo:inline>
							<xsl:value-of select="signataire/fonction" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Service dans lequel le stage
								sera effectué :
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
								Tél :
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
								Mél :
							</fo:inline>
							<xsl:value-of select="structure/mail" />
						</fo:block>
						<xsl:if test="service/voie != structure/voie">
							<fo:block line-height="130%" hyphenate="false" language="fr"
									  country="FR" font-size="9pt" font-family="Times New Roman,serif"
									  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									  padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Lieu du stage (si différent de
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
								Prénom :
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
								Né(e) le :
							</fo:inline>
							<xsl:value-of
									select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Numéro d'étudiant :
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
								Tél :
							</fo:inline>
							<xsl:value-of select="tel-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Portable :
							</fo:inline>
							<xsl:value-of select="tel-portable-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Mél :
							</fo:inline>
							<xsl:value-of select="etudiant/mail" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="8.5pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								INTITULÉ DE LA CERTIFICATION PRÉPARÉE
								DANS
								L'ÉTABLISSEMENT D'ENSEIGNEMENT SUPÉRIEUR :
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
								MODALITÉS DU STAGE
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
								Présence :
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
								Le stage se déroulera à :
							</fo:inline>
							<xsl:value-of select="temps-travail/libelle" />.
							<fo:inline font-weight="bold">
								Précisez la quotité :
							</fo:inline>
							<xsl:value-of select="quotite-travail" />%.
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							Une feuille de présence sera régulièrement fournie par l'établissement d'enseignement.
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Soit une durée hebdomadaire maximale de présence du stagiaire dans l'organisme d'accueil de
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
												La durée effective du stage est de
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
												année(s)
											</xsl:if>
										</fo:block>
									</xsl:when>
									<xsl:otherwise>
										<fo:block line-height="130%" hyphenate="false"
												  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
												  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
												  padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												La durée effective du stage est de
											</fo:inline>
											<fo:inline>
												<xsl:value-of select="duree-exceptionnelle" />
												<xsl:text> heures </xsl:text>
											</fo:inline>
											<fo:inline>
												(représentant une durée
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
										La durée effective du stage est de
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
								Précisions :
							</fo:inline>
							Si le stagiaire doit être présent dans l'organisme d'accueil la nuit, le dimanche ou jours fériés,
							son accord préalable est obligatoire, précisez ces cas particuliers :
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
							Encadrement du stagiaire par l'établissement
							d'enseignement
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm" font-weight="bold">
							Nom et prénom du référent :
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
								Tél :
							</fo:inline>
							<xsl:value-of select="enseignant/tel" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Mél :
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
							Nom et prénom du tuteur de
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
								Tél :
							</fo:inline>
							<xsl:value-of select="contact/tel" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
								  country="FR" font-size="9pt" font-family="Times New Roman,serif"
								  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								  padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Mél :
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
							d'Assurance Maladie à contacter en cas
							d'accident (lieu de
							domicile de l'étudiant sauf exception) :
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
								La présente convention règle les rapports entre l'organisme d'accueil, l'établissement d'enseignement et le stagiaire.
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
								Le stage s'inscrit dans le cadre de la formation et du projet personnel et professionnel d'évolution,
								de reconversion ou d'insertion professionnelle du stagiaire. Il correspond à une période de mise en situation
								en milieu professionnel au cours de laquelle il met en oeuvre les apprentissages de sa formation en vue de
								l'acquisition ou du développement de compétences professionnelles.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le programme du stage établi par le référent du stagiaire de l'établissement d'enseignement
								et le tuteur nommé par l'organisme d'accueil, en accord avec le stagiaire est le suivant :
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
								<fo:inline text-decoration="underline">Activités confiées
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
									Compétences à acquérir ou à
									développer
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
								L'organisme d'accueil garantit que les activités confiées ne constituent pas une tâche régulière
								correspondant à un poste de travail permanent, ne correspondent pas à un accroissement temporaire
								de l'activité de l'organisme d'accueil, à un emploi saisonnier ou au remplacement d'un salarié ou d'un
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
								Le stagiaire est suivi par un référent désigné dans la présente convention qui pourra organiser,
								selon les moyens disponibles de l'organisme d'accueil (rendez-vous téléphoniques, visioconférences,
								voies électroniques...), l'encadrement du stagiaire.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le tuteur de stage désigné par l'organisme d'accueil
								dans la
								présente convention est chargé d'assurer le suivi du stagiaire
								et d'optimiser les conditions de réalisation du
								stage
								conformément aux stipulations pédagogiques définies.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
									  padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Toute difficulté survenue dans la réalisation et le déroulement du stage,
								qu'elle soit constatée par le stagiaire, par le référent ou par le tuteur de
								stage, doit être portée à la connaissance de l'ensemble des parties afin d'être résolue
								au plus vite.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									MODALITÉS
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
								4 - Indemnité - Avantages
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
								L'organisme d'accueil peut décider de verser au stagiaire une indemnité et/ou des
								avantages en nature (restauration, frais de transport, hébergement..) dont le montant
								est fixé librement, en concertation avec le stagiaire, sauf contre-indication du contrat
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
											MONTANT DE L'INDEMNITÉ
										</fo:inline> : 0
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
											  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">
											MONTANT DE L'INDEMNITÉ
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
								Contrairement aux stages réalisés dans le cadre de la formation initiale,
								les sommes versées sont assujetties à l'ensemble des charges patronales et salariales
								(dès le 1er euro) pour les organismes français.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								En cas de suspension ou de résiliation de la présente convention, le montant de
								l'indemnité due au stagiaire est proratisé en fonction de la durée du stage effectuée.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 4 bis - Accès aux
								droits des salariés -
								Avantages
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								(Organisme de
								droit privé en France sauf en cas de règles
								particulières qui peuvent être applicables dans certaines collectivités
								d'outre-mer françaises)
								:
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire
								bénéficie des protections et droits mentionnés aux articles
								L.1121-1, L.1152-1 et L.1153-1 du code du travail, dans les
								mêmes conditions que les salariés.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire peut avoir accès au restaurant d'entreprise ou aux titres-restaurants
								prévus à l'article L.3262-1 du code du travail, dans les mêmes conditions que les
								salariés de l'organisme d'accueil. Il peut bénéficier également de la prise en charge
								des frais de transport prévue à l'article L.3261-2 du même code.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire peut avoir accès aux activités sociales et culturelles mentionnées à
								l'article L.2323-83 du code du travail dans les mêmes conditions que les salariés.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire accueilli dans un organisme de droit privé et qui effectue une mission
								dans ce cadre bénéficie de la prise en charge de ses frais de déplacement temporaire
								selon la réglementation en vigueur.
							</fo:block>


							<fo:block break-after="page" />


							<fo:block line-height="110%" padding-top="2pt"
									  hyphenate="false" language="fr" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 4ter - Accès aux droits
								des agents -
								Avantages
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="4pt">
								(Organisme de droit public en
								France sauf en cas de règles
								particulières applicables dans
								certaines collectivités
								d'outre-mer françaises) :
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Le stagiaire accueilli dans un organisme de droit public et qui effectue une mission
								dans ce cadre bénéficie de la prise en charge de ses frais de déplacement temporaire
								selon la réglementation en vigueur.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
									  padding-bottom="5pt" hyphenate="false" language="fr" country="FR"
									  font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Est considéré comme sa résidence administrative le lieu du stage
								indiqué dans la présente convention.
							</fo:block>
							<xsl:if test="avantages-nature and avantages-nature != ''">
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  text-align="justify" padding-top="2pt">
									<fo:inline text-decoration="underline">
										LISTE DES AVANTAGES ACCORDÉS
									</fo:inline>
									<fo:inline font-style="italic" font-weight="bold">
										(associés à
										l'article 4bis ou
										4ter selon le statut public ou
										privé de
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
									  text-align="justify" font-weight="bold">Article 5 - Régime de
								protection sociale maladie - accidents
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Pendant la durée du stage, le stagiaire conserve son statut de bénéficiaire de la
								formation professionnelle continue, à ce titre, il reste affilié au régime de sécurité
								sociale dont il relève avant son entrée en formation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								<fo:inline text-decoration="underline">
									Maladie
								</fo:inline> : Le bénéficiaire de la formation professionnelle continue qui ne relève
								d'aucun régime avant son entrée en formation, doit vérifier qu'il bénéficie bien de la
								protection maladie universelle auprès de la caisse d'assurance maladie de son lieu de
								résidence et souscrire une assurance volontaire individuelle le couvrant au titre des
								accidents du travail et des maladies professionnelles et fournir, à l'établissement
								d'enseignement, l'attestation de couverture. La charge des cotisations
								incombe au stagiaire.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-bottom="2pt"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">
									Accidents
								</fo:inline> : En cas d'accident survenant au bénéficiaire de la formation professionnelle
								continue dans l'organisme d'accueil, au cours du trajet domicile-lieu de stage ou
								Etablissement d'enseignement-lieu de stage ou lors des missions confiées par
								l'organisme d'accueil dans le cadre de la réalisation du programme du stage,
								le stagiaire accidenté dispose de 24h pour avertir l'organisme d'accueil qui s'engage
								à faire parvenir aussitôt tous les éléments permettant la déclaration de l'accident à
								l'établissement d'enseignement. Au plus tard 48h (non compris les dimanches et
								jours fériés) après avoir eu connaissance de l'accident, l'établissement
								d'enseignement procède à la déclaration d'accident du travail par lettre recommandée
								auprès de la caisse primaire d'assurance maladie du lieu de résidence
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
												Service de l'établissement d'enseignement à informer :
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
								En cas de fermeture administrative de l'établissement d'enseignement,
								ce dernier en informe l'organisme d'accueil afin qu'il puisse établir la déclaration
								en mentionnant l'établissement d'enseignement en qualité d'employeur et l'adresser
								à la caisse primaire d'assurance maladie du stagiaire avec copie à
								l'établissement d'enseignement.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" font-weight="bold">
								Article 6 - Responsabilité et assurance
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								L'organisme
								d'accueil et le stagiaire déclarent
								être
								garantis au titre
								de la responsabilité civile.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Pour les stages à l'étranger ou outre-mer, le
								stagiaire s'engage à souscrire un contrat d'assistance
								(rapatriement sanitaire, assistance juridique...) et un contrat
								d'assurance individuel accident.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								L'organisme d'accueil peut autoriser le stagiaire à se déplacer. Lorsque l'organisme
								d'accueil met un véhicule à la disposition du stagiaire, il lui incombe de vérifier
								préalablement que la police d'assurance du véhicule couvre son utilisation
								par un stagiaire.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Lorsque dans le cadre de son stage, l'étudiant
								utilise son propre véhicule ou un véhicule prêté par un tiers,
								il déclare expressément à l'assureur dudit véhicule et, le cas
								échéant, s'acquitte de la prime y afférente.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Selon le cadre du stage, le stagiaire s'assurera d'être en règle avec les obligations
								tant sanitaires que règlementaires (notamment hygiène et sécurité)
								propres à l'activité ou au lieu du stage.
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
								est soumis à la discipline et aux
								clauses
								du règlement
								intérieur qui lui sont applicables et qui
								sont
								portées à sa
								connaissance avant le début du stage, notamment
								en ce
								qui
								concerne les horaires et les règles d'hygiène et de
								sécurité
								en
								vigueur dans l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Toute sanction disciplinaire ne peut être décidée que
								par l'établissement d'enseignement. Dans ce cas, l'organisme
								d'accueil informe
								les tuteurs de stage et l'établissement d'enseignement des
								manquements et
								fournit éventuellement les éléments constitutifs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas de manquement particulièrement grave à la discipline,
								l'organisme d'accueil se réserve le droit de mettre fin au stage tout en respectant
								les dispositions fixées à l'article 8 de la présente convention,
								et de poursuivre pénalement le stagiaire.
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
								Le stagiaire est autorisé à revenir dans son établissement d'enseignement pendant
								la durée du stage pour y suivre les cours, séminaires prévus par le planning de la
								formation ; les dates sont portées à la connaissance de l'organisme d'accueil par
								l'établissement d'enseignement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify">
								Des autorisations d'absence sont possibles sous réserve que la durée du stage soit
								respectée. Elles sont définies entre le stagiaire et l'organisme d'accueil,
								qui en informe l'établissement d'enseignement.
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
									/ ou modalités des autorisations d'absence durant le stage :
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr"
										  country="FR" font-size="10pt" font-family="Times New Roman,serif"
										  text-align="justify">
									<xsl:value-of select="nb-conges" />
								</fo:block>
							</xsl:if>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="5pt"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Toute absence du stagiaire doit être justifiée et signalée par le stagiaire à
								l'organisme d'accueil et à l'établissement d'enseignement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  padding-top="2pt">
								Toute interruption temporaire du stage doit être signalée aux autres
								parties à la convention et au référent.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Service de l'établissement d'enseignement à informer :
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
								Si le stagiaire n'a pas réalisé la durée de stage nécessaire pour sa validation
								un report de la fin du stage est possible afin de permettre la réalisation de la
								durée totale du stage prévue initialement ou une autre modalité de validation est
								mise en place le cas échéant par l'établissement d'enseignement.
								En tout état de cause le report de la fin de stage n'est pas possible au-delà de la
								date de délibération du jury du diplôme. Ce report fera l'objet d'un avenant
								à la présente convention.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								En cas de volonté d'une des trois parties (organisme d'accueil, stagiaire,
								établissement d'enseignement) d'arrêter le stage, celle-ci doit immédiatement en
								informer les deux autres parties par écrit. Les raisons invoquées seront examinées
								en étroite concertation. La décision définitive d'arrêt du stage ne sera prise qu'à
								l'issue de cette phase de concertation.
							</fo:block>


							<fo:block break-after="page" />


							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
									  font-family="Times New Roman,serif" text-align="justify"
									  font-weight="bold">
								Article 9 - Devoir de réserve et confidentialité
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le devoir de
								réserve est de rigueur absolue et
								apprécié
								par l'organisme
								d'accueil compte-tenu de ses
								spécificités. Le
								stagiaire
								prend donc l'engagement de n'utiliser
								en aucun cas
								les
								informations recueillies ou obtenues pour
								en faire
								publication, communication à des tiers sans accord
								préalable de
								l'organisme d'accueil, y compris le rapport de
								stage. Cet
								engagement vaut non seulement pour la durée du stage
								mais
								également après son expiration. Le stagiaire s'engage à ne
								conserver, emporter, ou prendre copie d'aucun document ou
								logiciel, de quelque nature que ce soit, appartenant à
								l'organisme d'accueil, sauf accord de ce dernier.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Dans le cadre de la confidentialité des informations
								contenues dans le rapport de stage, l'organisme d'accueil peut
								demander une restriction de la diffusion du rapport, voire le
								retrait de certains éléments confidentiels.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  space-before="0cm" space-after="0cm" font-weight="normal"
									  text-align="justify">
								Les personnes amenées à en connaître sont contraintes
								par le secret professionnel à n'utiliser ni ne divulguer les
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
								Article 10 - Propriété intellectuelle
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Conformément au code de la propriété intellectuelle,
								dans le cas où les activités du stagiaire donnent lieu à
								la
								création d'une &#339;uvre protégée par le droit d'auteur ou la
								propriété industrielle (y compris un logiciel), si l'organisme
								d'accueil souhaite l'utiliser et que le stagiaire en est
								d'accord, un contrat devra être signé entre le stagiaire
								(auteur) et l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Le contrat devra alors notamment préciser l'étendue
								des droits cédés, l'éventuelle exclusivité, la destination, les
								supports utilisés et la durée de la cession, ainsi que, le cas
								échéant, le montant de la rémunération due au stagiaire au
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
								: à l'issue du stage, l'organisme d'accueil délivre une attestation dont le modèle
								figure en annexe, mentionnant au minimum la durée effective du stage ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								2)
								<fo:inline text-decoration="underline">Qualité du stage
								</fo:inline>
								: à l'issue du stage, les trois parties à la convention sont invitées à formuler une
								appréciation sur la qualité du stage. Le stagiaire transmet au service compétent de
								l'établissement d'enseignement un document dans lequel il évalue la qualité de
								l'accueil dont il a bénéficié au sein de l'organisme d'accueil. Ce document n'est pas
								pris en compte dans son évaluation ou dans l'obtention du diplôme ou
								de la certification.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline">Évaluation de l'activité
									du
									stagiaire
								</fo:inline>
								: à l'issue du stage, l'organisme d'accueil renseigne une fiche d'évaluation de
								l'activité du stagiaire qu'il retourne au référent
								(ou préciser si fiche annexe ou modalités d'évaluation préalablement
								définis en accord avec le référent).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify" padding-top="2pt">
								4)
								<fo:inline text-decoration="underline">Modalités d'évaluation
									pédagogiques
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
									échéant)
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
								d'accueil ou tout membre de l'organisme d'accueil appelé à se
								rendre dans l'établissement d'enseignement dans le cadre de la
								préparation, du déroulement et de la validation du stage ne peut
								prétendre à une quelconque prise en charge ou indemnisation de
								la part de l'établissement d'enseignement.
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
								Droit applicable - Tribunaux compétents
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								La présente convention
								est régie exclusivement par le
								droit français.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
									  country="FR" font-size="10pt" font-family="Times New Roman,serif"
									  text-align="justify">
								Tout litige non résolu
								par voie amiable sera soumis à
								la compétence de la juridiction
								française compétente.
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
				FAIT À
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
								POUR L'ÉTABLISSEMENT
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
												Viseur du centre, par délégation,
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
										Nom et signature du représentant
										de l'établissement
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
										Nom et signature du représentant de l'organisme
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
								représentant légal le cas échéant)
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
			<!--L'enseignant référent du-->
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
				  select='"abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ"' />
	<xsl:variable name='uppers'
				  select='"ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß"' />
	<!-- majuscule pour 1er lettre de chaque terme (cas prenom composés) -->
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
