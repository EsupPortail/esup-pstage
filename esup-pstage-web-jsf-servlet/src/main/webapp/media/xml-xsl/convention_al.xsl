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
			<xsl:call-template name="ArticlesPage2" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage3" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage4" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage5" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage6" />
		</fo:block>
		<fo:block padding-top="8pt">
			<xsl:call-template name="AnnexeArticlesPage6" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block>
			<xsl:call-template name="Attestation" />
		</fo:block>
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
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fo/extensions">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="all"
					border="" page-height="29.699cm" page-width="20.999cm"
					margin-right="1cm" margin-left="0.9cm" margin-bottom="0.4cm"
					margin-top="0.794cm">
					<fo:region-body margin-bottom="0cm" />
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

	<xsl:template name="AnnexeArticlesPage6">
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif"
			padding-top="0.2cm" font-style="italic" text-decoration="underline"
			font-weight="bold">
			Anlagen zur Vereinbarung :
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			font-style="italic">
			(Fiches à annexer à la conventions)
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif"
			padding-top="0.2cm" font-style="italic">
			<fo:inline font-weight="bold">
				1) Praktikumsbescheinigung
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(folgende Seite)
			</fo:inline>
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			font-style="italic">
			(Attestation de stage (page suivante))
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif"
			padding-top="0.2cm" font-style="italic">
			<fo:inline font-weight="bold">
				2) Formular Auslandspraktikum
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(Informationen zur
				Krankenversicherung finden Sie auf der Website
				cleiss.fr,
				Länderformulare auf diplomatie.gouv.fr)
			</fo:inline>
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			font-style="italic">
			(Fiche de stage à l'étranger
			(pour
			informations sécurité
			sociale voir site
			cleiss.fr, pour fiche
			pays
			voir site
			diplomatie.gouv.fr))
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif"
			padding-top="0.2cm" font-style="italic">
			<fo:inline font-weight="bold">
				3) Sonstige Anlagen
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(falls relevant)
			</fo:inline>
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			font-style="italic">
			(Autres annexes (le cas
			échéant))
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
								<fo:external-graphic width="3cm" height="1cm">
									<xsl:attribute name="src">
										<xsl:value-of select="document('config.xml')/config/logoUniversite" />
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
						<!-- <fo:table-cell width="3cm"> -->
						<!-- <fo:block width="3.493cm" line-height="110%" language="fr" -->
						<!-- country="FR" font-size="12pt" text-align="right"> -->
						<!-- Année universitaire -->
						<!-- <xsl:value-of select="annee" /> -->
						<!-- </fo:block> -->
						<!-- </fo:table-cell> -->
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
						<fo:block line-height="110%" padding-top="10pt"
							hyphenate="false" language="fr" country="FR" font-size="14pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">
								Praktikumsvereinbarung
								<xsl:text> </xsl:text>
								n°
								<xsl:value-of select="id-convention" />
								<xsl:text> </xsl:text>
								zwischen
							</fo:inline>
						</fo:block>
						<fo:block line-height="100%" hyphenate="false" language="fr"
							country="FR" font-size="10pt" font-family="Times New Roman,serif"
							text-align="center" font-style="italic">
							(Convention de stage entre)
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
			font-style="italic">
			Nota: Um das Lesen dieses Dokuments
			zu erleichtern werden
			die Begriffe "Praktikant", "Lehrer-Referent",
			"Tutor des Praktikums",
			"gesetzlicher Vertreter" und "Student" nur in
			der maskulinen Form
			benutzt.
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="6.5pt" font-family="Times New Roman,serif"
			padding-left="0.141cm" padding-right="0.141cm" font-style="italic"
			padding-bottom="0.3cm">
			(Nota : pour faciliter la lecture
			du document, les mots
			"stagiaire", "enseignant référent", "tuteur de
			stage", "représentant
			légal", "étudiant" sont utilisés
			au masculin)
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-column column-width="proportional-column-width(1)" />

			<fo:table-body>
				<fo:table-row margin-top="20px" text-align="left">
					<!-- partie Etablissement Superieur - Stage -->
					<fo:table-cell border="0.018cm solid #000000"
						padding-left="0.1cm" padding-right="0.1cm" padding-top="0.2cm"
						padding-bottom="0.2cm">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-top="0cm" padding-bottom="0.035cm" text-align="center">
							<fo:inline font-weight="bold">
								1 -
								<fo:inline text-decoration="underline">DER HOCHSCHUL- ODER
									AUSBILDUNGSEINRICHTUNG
								</fo:inline>
							</fo:inline>
						</fo:block>
						<fo:block line-height="100%" hyphenate="false" language="fr"
							country="FR" font-size="6.5pt" font-family="Times New Roman,serif"
							text-align="center" font-style="italic">
							(L'ETABLISSEMENT D'ENSEIGNEMENT OU
							DE FORMATION))
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Name
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline font-weight="bold"> :
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
							<fo:inline font-style="italic" font-size="8pt">(Adresse)
							</fo:inline>
							<fo:inline font-weight="bold"> :
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
										Tel :
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
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Vertreten durch (Unterzeichner
								der Vereinbarung)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Représenté
								par (signataire de la convention))
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
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
													Funktion des Vertreters
												</fo:inline>
												<fo:inline font-style="italic" font-size="8pt">(Qualité
													du représentant)
												</fo:inline>
												<fo:inline font-weight="bold"> :
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
													Funktion des Vertreters
												</fo:inline>
												<fo:inline font-style="italic" font-size="8pt">(Qualité
													du représentant)
												</fo:inline>
												<fo:inline font-weight="bold"> :
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
								Einheit/ Fachbereich :
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Composante/UFR)
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
							<xsl:value-of select="centre-gestion/nom-centre" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm">
							<fo:inline font-weight="bold">
								Adresse (wenn abweichend von der
								der Einrichtung)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Adresse (si
								différente de celle
								de l'établissement))
							</fo:inline>
							<fo:inline font-weight="bold"> :
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
								Tel :
							</fo:inline>
							<xsl:value-of select="centre-gestion/telephone" />
							&#160;
							<fo:inline font-weight="bold">
								Mail :
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
									DER EMPFANGSEINRICHTUNG
								</fo:inline>
							</fo:inline>
						</fo:block>
						<fo:block line-height="100%" hyphenate="false" language="fr"
							country="FR" font-size="6.5pt" font-family="Times New Roman,serif"
							text-align="center" font-style="italic">
							(L'ORGANISME D'ACCUEIL)
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Name
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
							<xsl:value-of select="structure/raison-sociale" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Adresse
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Adresse)
							</fo:inline>
							<fo:inline font-weight="bold"> :
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
								Vertreten durch (Name des
								Unterzeichners der Vereinbarung)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Représenté
								par (signataire de la convention))
							</fo:inline>
							<fo:inline> :
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
								Funktion des Vertreters
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt"> (Qualité du
								représentant)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of select="signataire/fonction" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Name der Abteilung, in der das
								Praktikum durchgeführt wird
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Service dans
								lequel le stage
								sera effectué)
							</fo:inline>
							<fo:inline> :
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
								Tel :
							</fo:inline>
							<xsl:value-of select="structure/telephone" />
							&#160;
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:value-of select="structure/mail" />
						</fo:block>
						<xsl:if test="service/voie != structure/voie">
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Ort des Praktikums (wenn
									abweichend von der Empfangseinrichtung)
								</fo:inline>
								<fo:inline font-style="italic" font-size="8pt"> (Lieu du
									stage (si différent de
									l'adresse de l'organisme))
								</fo:inline>
								<fo:inline font-weight="bold"> :
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
			<fo:table-column />
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
								<fo:inline text-decoration="underline">DEM PRAKTIKANTEN
								</fo:inline>
							</fo:inline>
							<fo:inline font-style="italic" font-size="6.5pt">(LE
								STAGIAIRE)
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Name
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
							<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Vorname
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Prénom)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="etudiant/prenom" />
								</xsl:with-param>
							</xsl:call-template>
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Geschlecht
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Sexe)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of select="etudiant/code-sexe" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Geboren am
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Né le)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of
								select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Studenten ID
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Numéro
								d'étudiant)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of select="etudiant/num-etudiant" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Adresse
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Adresse)
							</fo:inline>
							<fo:inline> :
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
								Tel :
							</fo:inline>
							<xsl:value-of select="tel-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Mobiltelefon :
							</fo:inline>
							<xsl:value-of select="tel-portable-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:value-of select="etudiant/mail" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="8.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								BEZEICHNUNG DER IN DER
								HOCHSCHULEINRICHTUNG BELEGTEN AUSBILDUNG ODER DES STUDIENGANGS
								UND STUNDENZAHL (PER JAHR ODER SEMESTER) :
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="7pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm" text-align="justify" font-style="italic">
							(INTITULÉ DE LA FORMATION OU DU
							CURSUS SUIVI DANS
							L'ÉTABLISSEMENT
							D'ENSEIGNEMENT SUPÉRIEUR ET
							VOLUME HORAIRE (ANNUEL OU SEMESTRIEL))
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<xsl:value-of select="etape/libelle" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Stundenzahl
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">
								(Nombre
								d'heures de formation)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
							<fo:inline>
								............................
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<!-- partie Sujet/Duree -->
		<fo:table table-layout="fixed" width="100%" border="0.018cm solid #000000">
			<fo:table-column />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell padding-top="5pt" padding-bottom="5pt"
						padding-left="5pt" padding-right="5pt">
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold" text-decoration="underline">
								GEGENSTAND DES PRAKTIKUMS
							</fo:inline>
							<fo:inline font-style="italic" font-size="7pt">(SUJET DE
								STAGE)
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
							<xsl:if test="tem-conf-sujet-teme != 'O'">
								<xsl:value-of select="sujet-stage" />
							</xsl:if>
							<xsl:if test="tem-conf-sujet-teme = 'O'">
								Vertraulich
							</xsl:if>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.5cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Daten :
							</fo:inline>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Vom
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Du)
							</fo:inline>
							<xsl:text> </xsl:text>
							<xsl:value-of
								select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								bis zum
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Au)
							</fo:inline>
							<xsl:text> </xsl:text>
							<xsl:value-of
								select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />
							<xsl:if test="@interruption-stage = 'true'">
								<xsl:text> </xsl:text>
								mit Unterbrechung Vom
								<xsl:value-of
									select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
								<xsl:text> </xsl:text>
								bis zum
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
												Für eine Gesamtdauer von
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> </xsl:text>
											<xsl:if test="id-unite-duree-exceptionnelle = '1'">
												stunden
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '2'">
												tage
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '3'">
												wochen
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '4'">
												monat
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '5'">
												jahre
											</xsl:if>
										</fo:block>
									</xsl:when>
									<xsl:otherwise>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												Entsprechend
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<fo:inline font-weight="bold">
												tatsächlicher
												Anwesenheitsstunden in der Empfangseinrichtung
											</fo:inline>
										</fo:block>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm" font-style="italic">
											(correspondant
											à ...
											heures de
											présence effective dans
											l'organisme d'accueil)
										</fo:block>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												und für eine Gesamtdauer von
											</fo:inline>
											<fo:inline font-style="italic" font-size="8pt">(et
												correspondant à)
											</fo:inline>
											<fo:inline>
												<xsl:variable name="nbHeures" select="duree-exceptionnelle" />
												<xsl:variable name="nbJours" select="floor($nbHeures div 7)" />
												<xsl:variable name="nbHeuresRestantes" select="$nbHeures mod 7" />
												<xsl:variable name="nbMois" select="floor($nbJours div 22)" />
												<xsl:variable name="nbJoursRestants" select="$nbJours mod 22" />

												<xsl:value-of select="$nbMois" />
												<xsl:text> monat </xsl:text>
												<xsl:value-of select="$nbJoursRestants" />
												<xsl:text> tage und </xsl:text>
												<xsl:value-of select="$nbHeuresRestantes" />
												<xsl:text> stunden </xsl:text>
											</fo:inline>
											<fo:inline font-style="italic" font-size="8pt">
												(... mois
												... jours ... semaines)
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
										Für eine Gesamtdauer von
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									wochen
									<fo:inline font-style="italic" font-size="8pt">(Représentant
										une durée totale de ... semaines)
									</fo:inline>
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
											Verteilung bei nicht
											durchgängiger Anwesenheit
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">(Répartition
											si présence
											discontinue)
										</fo:inline>
										<fo:inline font-weight="bold">
											:
										</fo:inline>
										<xsl:value-of select="nb-heures-hebdo" />
										<xsl:text> </xsl:text>
										<fo:inline font-weight="bold">
											stunden pro Woche
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">
											(heures par
											semaine).
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
								Kommentar
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Commentaire)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
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
							BETREUUNG DES PRAKTIKANTEN DURCH DIE
							SCHULEINRICHTUNG
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm"
							text-align="center" font-style="italic" font-size="7pt">
							(ENCADREMENT DU
							STAGIAIRE PAR L'ETABLISSEMENT
							D'ENSEIGNEMENT)
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Name und Vorname des
								Lehrer-Referenten
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom et
								prénom
								de
								l'enseignant référent)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
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
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Funktion (oder Fachgebiet)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Fonction (ou
								discipline))
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
							<xsl:value-of select="enseignant/type-personne" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Tel :
							</fo:inline>
							<xsl:value-of select="enseignant/tel" />
							&#160;
							<fo:inline font-weight="bold">
								Mail :
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
							BETREUUNG DES PRAKTIKANTEN DURCH DIE
							EMPFANGSEINRICHTUNG
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm"
							text-align="center" font-style="italic" font-size="7pt">
							(ENCADREMENT DU
							STAGIAIRE PAR L'ORGANISME D'ACCUEIL)
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Name und Vorname des Tutors
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom et
								prénom
								du tuteur de stage)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
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
								Funktion
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Fonction)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
							<xsl:value-of select="contact/fonction" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Tel :
							</fo:inline>
							<xsl:value-of select="contact/tel" />
							&#160;
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:value-of select="contact/mail" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="CPAM">
		<fo:block line-height="100%" hyphenate="false" language="fr"
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
							Im Fall eines Unfalls zu
							kontaktierende Krankenkasse (Wohnort des Praktikanten , außer
							Ausnahmen):
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="8pt" font-family="Times New Roman,serif"
							font-style="italic">
							(Caisse primaire
							d'assurance maladie à contacter en cas
							d'accident (lieu de
							domicile de l'étudiant sauf exception))
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
			padding-top="10pt" text-align="center">
			Datum des Druckvorgangs :
			<xsl:value-of
				select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())" />
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="7pt" font-family="Times New Roman,serif"
			text-align="center" font-style="italic">
			(Convention imprimée le : ...)
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
					<fo:table-row>
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Artikel 1 - Gegenstand der Vereinbarung
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die vorliegende Vereinbarung regelt die Beziehungen zwischen der
								Empfangseinrichtung, der Hochschuleinrichtung und dem
								Praktikanten.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								background-color="#E6E6E6" padding-bottom="2pt" hyphenate="false"
								language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">Article 1 -
								Objet de la convention
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								background-color="#E6E6E6" padding-bottom="1pt" hyphenate="false"
								language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								La présente convention règle les
								rapports de l'organisme
								d'accueil avec
								l'établissement
								d'enseignement et le stagiaire.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Artikel 2 - Gegenstand des Praktikums
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Das Praktikum ermöglicht ein befristetes Eintauchen in das
								Berufsleben, während dem die Studenten die Möglichkeit haben,
								professionelle Kompetenzen zu erwerben, bei denen sie ihr in der
								Ausbildung erworbenes Wissen mit dem Ziel, ein Diplom oder ein
								Zeugnis zu erhalten oder die berufliche Eingliederung zu
								fördern, anwenden können. Dem Praktikanten werden eine oder
								mehrere Aufgaben zugewiesen, die dem pädagogischen Projekt der
								Hochschuleinrichtung entsprechen und von der Empfangseinrichtung
								bestätigt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Das Programm des Praktikums wird entsprechend dem
								allgemeinen Unterrichtsprogramm zwischen der Empfangseinrichtung
								und der Hochschule erstellt.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">ANVERTRAUTE AUFGABEN
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
									ZU ERWERBENDE ODER ZU
									ENTWICKELNDE KOMPETENZEN
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="true" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-bottom="4pt">
								<xsl:value-of select="competences" />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								Article 2 - Objectif du
								stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Le stage correspond à une
								période temporaire
								de
								mise en situation
								en milieu professionnel au
								cours de laquelle
								l'étudiant
								acquiert
								des compétences
								professionnelles
								et met en
								&#339;uvre les
								acquis
								de sa
								formation en
								vue de
								l'obtention d'un
								diplôme ou d'une
								certification et de
								favoriser son insertion
								professionnelle.
								Le
								stagiaire se voit
								confier une ou des missions
								conformes au
								projet
								pédagogique défini
								par son établissement
								d'enseignement
								et
								approuvées par l'organisme
								d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								programme est établi
								par l'établissement
								d'enseignement
								et
								l'organisme
								d'accueil en
								fonction du programme
								général de la
								formation
								dispensée.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								<fo:inline text-decoration="underline">ACTIVITÉS CONFIÉES
								</fo:inline>
								: ...
							</fo:block>
							<fo:block line-height="110%" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" background-color="#E6E6E6"
								font-style="italic">
								<fo:inline text-decoration="underline">
									Compétences à acquérir ou à
									développer
								</fo:inline>
								: ...
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Artikel 3 - Modalitäten des Praktikums
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Wochenanwesenheitszeit des Praktikanten in der
								Empfangseinrichtung beträgt
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								Stunden auf der Grundlage eines
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when
											test="temps-travail/code-ctrl='TCOMP' or temps-travail/code-ctrl='TPART'">
											<xsl:if test="temps-travail/code-ctrl='TCOMP'">
												Vollzeit.
											</xsl:if>
											<xsl:if test="temps-travail/code-ctrl='TPART'">
												Teilzeitpraktikums.
											</xsl:if>
										</xsl:when>
										<xsl:otherwise>
											<xsl:value-of select="temps-travail/libelle" />
											<xsl:text>.</xsl:text>
										</xsl:otherwise>
									</xsl:choose>
								</fo:inline>
								<!-- (quotité : -->
								<!-- <fo:inline font-weight="bold"> -->
								<!-- <xsl:value-of select="quotite-travail" /> -->
								<!-- %). -->
								<!-- </fo:inline> -->
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Bei einer möglichen Anwesenheit des Praktikanten in der
								Empfangseinrichtung während der Nacht, am Sonntag oder an einem
								Feiertag, müssen diese Sonderfälle angegeben werden.
								<fo:inline font-weight="bold">
									<xsl:value-of select="travail-nuit-ferie" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="4pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								Article 3 - Modalités du stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								La durée hebdomadaire de
								présence du stagiaire
								dans
								l'organisme
								d'accueil sera de ... heures
								sur la base d'un temps complet/
								temps partiel (rayer la mention
								inutile).
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Si le stagiaire doit être
								présent dans l'organisme
								d'accueil
								la
								nuit, le
								dimanche ou un jour
								férié, préciser
								les cas
								particuliers :
								............
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Artikel 4 - Empfang und Betreuung des Praktikanten
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Der Praktikant wird vom in dieser Vereinbarung benannten
								Referenten und von der mit den Praktika betrauten Abteilung der
								Einrichtung betreut.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Der von der Empfangseinrichtung benannte Tutor des Praktikums
								ist für die Betreuung des Praktikanten und die Optimierung der
								Durchführungsbedingungen entsprechend der definierten
								pädagogischen Ziele verantwortlich.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Der Praktikant darf während der Dauer des Praktikums an die
								Bildungseinrichtung zurückkehren, um an vom Programm
								ausdrücklich vorgesehenen Kursen und Versammlungen teilzunehmen,
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Artikel 4 Fortsetzung)
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								deren Daten dem Leiter der Empfangseinrichtung von der
								Einrichtung mitgeteilt werden. Die Empfangseinrichtung kann
								Reisen des Praktikanten erlauben.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Jedes Problem bei der Durchführung oder
								dem
								Ablauf des
								Praktikums,
								gleichgültig, ob es vom Praktikanten
								oder
								dem Tutor
								des Praktikums
								festgestellt wird, muss dem
								Referenzen
								der
								Hochschuleinrichtung
								mitgeteilt und
								schnellstmöglich gelöst
								werden.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									BETREUUNGSMODALITÄTEN
								</fo:inline>
								(Besuche, Telefongespräche usw.)
							</fo:block>
							<xsl:choose>
								<xsl:when test="mode-encadre-suivi and mode-encadre-suivi != ''">
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
										padding-bottom="4pt">
										<fo:inline font-weight="bold">
											<xsl:value-of select="mode-encadre-suivi" />
										</fo:inline>
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
										padding-bottom="4pt">
										.......................................................................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="100%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">Article
								4 - Accueil
								et
								encadrement du stagiaire
							</fo:block>
							<fo:block line-height="100%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Le stagiaire est suivi par
								l'enseignant référent désigné dans la présente convention ainsi
								que par le service de l'établissement en charge des stages.
							</fo:block>
							<fo:block line-height="100%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Le tuteur de stage désigné
								par l'organisme d'accueil dans la
								présente convention est chargé
								d'assurer le suivi du stagiaire
								et d'optimiser les conditions de
								réalisation du stage
								conformément aux stipulations pédagogiques
								définies.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								keep-with-next="always" text-align="justify" font-weight="bold">Artikel
								5 - Vergütung - Sachleistungen
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Vergütung ist in Frankreich zwingend, wenn die
								Praktikumsdauer zwei aufeinander folgende oder nicht aufeinander
								folgende Monate überschreitet, außer bei Sonderregeln in einigen
								Übersee-Gebietskörperschaften und Praktika im Rahmen von Art.
								L4381-1 des Gesetzbuchs für das öffentliche Gesundheitswesen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Der Stundenbetrag der Vergütung ist auf 13,75 % des
								Basisstundenlohns der Sozialversicherung gemäß Artikel L.241-3
								des Sozialgesetzbuchs festgelegt. In einem branchenspezifischen
								Abkommen oder beruflichem Übereinkommen können höhere Beträge
								festgelegt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Eine Vergütung durch eine öffentliche Einrichtung
								kann nicht mit
								einer in der gleichen Periode von dieser
								Einrichtung geleisteten
								Zahlung kumuliert werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Vergütung erfolgt unbeschadet der Erstattung der
								vom Praktikanten vorgestreckten Kosten zur Durchführung seines
								Praktikums oder der eventuellen Sachleistungen für Verkostung,
								Unterbringung und Transport.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Einrichtung kann sich entschließen, eine Vergütung für
								Praktiken mit einer Dauer von zwei Monaten oder weniger zu
								zahlen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Im Fall einer Unterbrechung oder Kündigung der
								vorliegenden Vereinbarung, wird die Vergütung des Praktikanten
								im Verhältnis zur Dauer des durchgeführten Praktikums berechnet.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Dauer, die ein Anrecht auf die Vergütung gibt,
								wird auf der Grundlage der vorliegenden Vereinbarung und deren
								eventueller Nachträge sowie der Anzahl der effektiven
								Anwesenheitstage des Praktikanten in der Einrichtung berechnet.
							</fo:block>
							<xsl:variable name="indemnisation" select="id-indemnisation" />
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>

								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">DIE HÖHE DER VERGÜTUNG
										</fo:inline>
										ist auf den folgenden Betrag festgelegt:
										<xsl:variable name="nb-montant-gratification"
											select="montant-gratification" />
										<xsl:choose>
											<xsl:when test='$nb-montant-gratification=""'>

											</xsl:when>
											<xsl:otherwise>
												<fo:inline font-weight="bold">
													<xsl:value-of select="montant-gratification" />
												</fo:inline>
												euros
												<xsl:text> </xsl:text>
												<xsl:value-of select="unite-gratification/libelle" />
												/
												<xsl:text> </xsl:text>
												<xsl:value-of select="unite-duree-gratification/libelle" />
												<xsl:text>.</xsl:text>
											</xsl:otherwise>
										</xsl:choose>
									</fo:block>
									<xsl:if
										test="mode-vers-gratification/libelle and mode-vers-gratification/libelle != ''">
										<fo:block line-height="110%" hyphenate="false"
											language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
											<fo:inline text-decoration="underline">
												Auszahlungsmodus
											</fo:inline>
											:
											<xsl:value-of select="mode-vers-gratification/libelle" />
										</fo:block>
									</xsl:if>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">SONSTIGE SACHLEISTUNGEN
								</fo:inline>
								:
								<fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								keep-with-next="always" text-align="justify" font-weight="bold"
								background-color="#E6E6E6" font-style="italic">Article
								5 - Gratification -
								Avantages
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								En France, lorsque la
								durée du stage est supérieure à deux mois
								consécutifs
								ou non,
								celui-ci fait obligatoirement l'objet d'une
								gratification, sauf
								en cas de règles particulières applicables
								dans certaines
								collectivités d'outre-mer françaises et pour les
								stages relevant
								de l'article
								L4381-1 du code de la santé
								publique.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								montant horaire de
								la
								gratification
								est fixé à 13,75%
								du plafond
								horaire de la
								sécurité sociale défini
								en application
								de
								l'article
								L.241-3 du
								code de la sécurité sociale. Une
								convention
								de branche
								ou un
								accord professionnel peut définir
								un
								montant
								supérieur à ce
								taux.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								gratification due
								par un organisme de droit public
								ne
								peut être
								cumulée avec une
								rémunération
								versée par ce même
								organisme au cours
								de
								la période
								concernée.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								gratification est
								due sans préjudice
								du
								remboursement des frais
								engagés
								par
								le
								stagiaire pour
								effectuer son
								stage et des avantages
								offerts, le
								cas échéant,
								pour la
								restauration, l'hébergement, et
								le
								transport.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								L'organisme peut
								décider de
								verser une
								gratification pour les
								stages dont la durée
								est
								inférieure ou
								égale à deux mois.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cas de suspension
								ou de résiliation de la présente
								convention, le
								montant de la
								gratification due au stagiaire
								est
								proratisé en
								fonction de
								la
								durée du stage effectué.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								durée donnant droit
								à gratification s'apprécie
								compte tenu de la
								présente convention
								et de ses avenants
								éventuels, ainsi que du
								nombre de jours de
								présence effective du
								stagiaire dans
								l'organisme.
							</fo:block>
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>

								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										background-color="#E6E6E6" font-style="italic">
										<fo:inline text-decoration="underline">LE MONTANT DE LA
											GRATIFICATION
										</fo:inline>
										est fixé à
										<xsl:variable name="nb-montant-gratification"
											select="montant-gratification" />
										<xsl:choose>
											<xsl:when test='$nb-montant-gratification=""'>

											</xsl:when>
											<xsl:otherwise>
												... euros
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
								country="FR" font-size="9pt" background-color="#E6E6E6"
								font-style="italic" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">
									Mode de versement de la
									gratification
								</fo:inline>
								: ...
							</fo:block>
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								<fo:inline text-decoration="underline">AUTRES AVANTAGES ACCORDES
								</fo:inline>
								: .........
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
					<fo:table-row>
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">Artikel 6 -
								Sozialversicherungsschutz
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Während der Dauer des Praktikums erhält der
								Praktikant weiterhin die Leistungen seiner bestehenden
								Krankenversicherung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Im Ausland durchgeführte Praktika müssen vor der
								Abreise des Praktikanten auf Anfrage der Krankenversicherung
								mitgeteilt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt"> Bei
								den
								Auslandspraktika
								gelten die
								folgenden
								Bestimmungen unter
								Vorbehalt
								der
								Übereinstimmung mit
								der
								Gesetzgebung des
								Empfangsstaates und
								den
								Bestimmungen der
								Empfangseinrichtung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">Article 6 - Régime de
								protection sociale
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Pendant la durée du stage, le stagiaire reste affilié
								à son
								régime de Sécurité sociale antérieur. Les stages effectués
								à
								l'étranger sont signalés préalablement au départ du stagiaire
								à
								la Sécurité sociale lorsque celle-ci le demande.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Pour
								les stages à
								l'étranger, les dispositions
								suivantes sont
								applicables sous
								réserve de conformité avec la
								législation du
								pays
								d'accueil et de
								celle régissant le type
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
								6-1 Vergütung in Höhe eines Mindestbetrags von 13,75
								% des Basisstundenlohns der Sozialversicherung:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Vergütung ist nicht sozialversicherungspflichtig.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Der Praktikant profitiert von den gesetzlichen
								Leistungen der Studentenversicherung bei Arbeitsunfällen gemäß
								Artikel L.411-1 folgende des Sozialgesetzbuchs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Für den Fall, dass der Praktikant während seiner Arbeit in der
								Empfangseinrichtung, oder während der Fahrt, an einem durch die
								Anforderungen des Praktikums nützlich gewordenen Ort, oder für
								die Studenten der Medizin, der Zahnchirurgie oder Pharmazeutik
								ohne Krankenhausstatus während des Praktikums, das unter den
								Bedingungen des Abschnitts 2b des Artikels L.418-2 durchgeführt
								wird, einen Unfall erleidet,
								<fo:inline text-decoration="underline">schickt die
									Empfangseinrichtung die Erklärung an die kompetente
									Krankenkasse
								</fo:inline>
								(siehe Adresse Seite 1) und nennt die Hochschule als
								Arbeitgeber, mit
								<fo:inline text-decoration="underline">
									Kopie an die Hochschule.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								6.1 -
								Gratification d'un
								montant maximum de 13,75%
								du plafond horaire
								de
								la Sécurité
								sociale :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								gratification n'est pas soumise à cotisation
								sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								stagiaire bénéficie de la législation sur les
								accidents de
								travail au titre du régime étudiant de l'article
								L.412-8 2° du
								code de la Sécurité sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En cas d'accident survenant au stagiaire soit au cours
								d'activités dans l'organisme, soit au cours du trajet, soit sur
								les lieux rendus utiles pour les besoins du stage et pour les
								étudiants en médecine, en chirurgie dentaire ou en pharmacie qui
								n'ont pas un statut hospitalier pendant le stage effectué dans
								les conditions prévues au b du 2e de l'article L.418-2,
								<fo:inline text-decoration="underline">
									l'organisme d'accueil
									envoie la déclaration à la Caisse Primaire d'Assurance Maladie
								</fo:inline>
								ou la caisse compétente (voir adresse en page 1) en mentionnant
								l'établissement d'enseignement comme employeur, avec
								<fo:inline text-decoration="underline">
									copie à l'établissement
									d'enseignement.
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								font-weight="bold">
								6.2 -
								Vergütung über 13,75 % des
								Basisstundenlohns der
								Sozialversicherung
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Sozialabgaben werden auf dem Unterschied zwischen
								dem Betrag der Vergütung und 13,75 % des Basisstundenlohns der
								Sozialversicherung berechnet.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Der Student profitiert von
								den gesetzlichen
								Leistungen gemäß Artikel L.411-1 folgende des
								Sozialgesetzbuchs.
								Für den Fall, dass der Praktikant während
								seiner Arbeit in der
								Empfangseinrichtung, oder während der Fahrt,
								oder an einem durch
								die Anforderungen des Praktikums nützlich
								gewordenen Ort einen
								Unfall erleidet, unternimmt die
								Empfangseinrichtung alle
								notwendigen Schritte bei der
								Krankenkasse und informiert die
								Hochschule so schnell wie
								möglich.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic"
								font-weight="bold">
								6.2 -
								Gratification supérieure à
								13,75 % du plafond
								horaire de la
								Sécurité sociale :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Les
								cotisations sociales sont calculées sur le
								différentiel entre le
								montant de la gratification et 13,75 % du
								plafond horaire de la
								Sécurité sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								L'étudiant bénéficie de la couverture légale en
								application des
								dispositions des articles L.411-1 et suivants du
								code de la
								Sécurité sociale. En cas d'accident survenant au stagiaire soit
								au
								cours des activités dans l'organisme, soit au cours du trajet,
								soit sur des lieux rendus utiles pour les besoins de son stage,
								l'organisme d'accueil effectue toutes les démarches nécessaires
								auprès de la Caisse Primaire d'Assurance Maladie et informe
								l'établissement dans les meilleurs délais.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								6.3 Krankenversicherung der
								Praktikanten im Ausland:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								1)
								<fo:inline text-decoration="underline">Ausgehend von der
									französischen studentischen Sozialversicherung:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="9.5pt"
								font-family="Times New Roman,serif" text-align="justify">
								- Für Praktika
								innerhalb des Europäischen Wirtschaftsraums (EWR), die von
								Studenten aus einem EU-Staat oder aus Norwegen, Island,
								Liechtenstein oder der Schweiz durchgeführt werden, oder aus
								einem sonstigen Land (im letzten Fall ist diese Bestimmung nicht
								auf Praktika in Dänemark, Norwegen, Island, Liechtenstein oder
								die Schweiz anwendbar) müssen die Studenten eine europäische
								Krankenversicherungskarte (CEAM) beantragen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- Für
								Praktika, die in Quebec von Studenten französischer
								Staatsbürgerschaft durchgeführt werden, muss das Formular SE401Q
								(104 für Unternehmenspraktika, 106 für Universitätspraktika)
								beantragt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- in den
								anderen Fällen können sich Studenten, die im Ausland
								Gesundheitsausgaben haben, diese Beträge bei ihrer
								Zusatzkrankenkasse (Mutuelle), die als Studentenkrankenkasse
								funktioniert, nach Vorlage von Belegen bei ihrer Rückkehr
								zurückerstatten lassen. Diese Rückerstattung erfolgt auf der
								Grundlage der französischen Behandlungskosten. Es können
								bedeutende Abweichungen zwischen den bezahlten Beträgen und der
								französischen Basiserstattung auftreten. Es ist sehr zu
								empfehlen, dass die Studenten eine spezifische
								Zusatzversicherung für das entsprechende Land und die Dauer des
								Praktikums bei einer von ihnen gewählten Kasse abschließen
								(Studentenkasse, Versicherung der Eltern, private
								Versicherungsgesellschaft...) oder, nach Prüfung der angebotenen
								Garantien, bei der Empfangseinrichtung, wenn diese dem
								Praktikanten entsprechend der örtlichen Bestimmungen (siehe 2
								unten) eine Krankenversicherung bereitstellt.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2)
								<fo:inline text-decoration="underline">
									Krankenversicherung durch
									die Empfangseinrichtung:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Durch das Ankreuzen des entsprechenden Kästchens
								erklärt die Empfangseinrichtung untenstehend, ob sie nach
								lokalem Recht eine Krankenversicherung für den Praktikanten
								bereitstellt :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.1cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> JA
								</fo:inline>
								: dieser Schutz kommt zum Erhalt der Leistungen aus der
								französischen Studentenversicherung im Ausland hinzu.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.1cm" padding-bottom="4pt">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> NEIN
								</fo:inline>
								: der Schutz beruht einzig auf dem Erhalt der Leistungen aus der
								französischen Studentenversicherung im Ausland Wird kein
								Kästchen angekreuzt, kommt 6.3-1 zur Anwendung.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								6.3 - Protection
								maladie du
								stagiaire à l'étranger
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								1)
								<fo:inline text-decoration="underline">Protection
									issue du régime
									étudiant français
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								pour les stages
								au sein
								de l'Espace Economique Européen (EEE)
								effectués par des
								ressortissants d'un Etat de l'Union Européenne,
								ou de la
								Norvège, de l'Islande, du Liechtenstein ou de la Suisse,
								ou
								encore de tout autre Etat (dans ce dernier cas, cette
								disposition n'est pas applicable pour un stage au Danemark,
								Norvège, Islande, Liechtenstein ou Suisse), l'étudiant doit
								demander la Carte Européenne d'Assurance Maladie (CEAM).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								pour les
								stages effectués
								au Québec par les étudiants de
								nationalité
								française, l'étudiant
								doit demander le formulaire
								SE401Q (104
								pour les stages en
								entreprises, 106 pour les stages
								en
								universités) ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								dans tous
								les autres cas
								les étudiants qui engagent des frais de
								santé
								peuvent être
								remboursés auprès de la mutuelle qui leur tient
								lieu de Caisse de
								Sécurité Sociale Étudiante, au retour et sur
								présentation des
								justificatifs : le remboursement s'effectue
								alors sur la base des
								tarifs de soins français. Des écarts
								importants peuvent exister
								entre les frais engagés et les tarifs
								français, base du
								remboursement. Il est donc fortement conseillé
								aux étudiants de
								souscrire une assurance maladie
								complémentaire
								spécifique, valable
								pour le pays et la durée du
								stage, auprès de
								l'organisme
								d'assurance de son choix (mutuelle
								étudiante,
								mutuelle
								des
								parents, compagnie privée ad hoc...) ou,
								éventuellement et
								après
								vérification de l'étendue des garanties
								proposées, auprès de
								l'organisme d'accueil si celui-ci fournit
								au stagiaire une
								couverture maladie en vertu du droit local
								(voir 2e ci-dessous).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								2)
								<fo:inline text-decoration="underline">
									Protection sociale issue de
									l'organisme d'accueil
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cochant la case appropriée, l'organisme d'accueil
								indique
								ci-après s'il fournit une protection Maladie au
								stagiaire, en
								vertu du droit local :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								-
								<fo:inline font-weight="bold"> OUI
								</fo:inline>
								: cette protection s'ajoute au maintien, à l'étranger, des
								droits
								issus du droit français.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								-
								<fo:inline font-weight="bold"> NON
								</fo:inline>
								: la protection découle alors exclusivement du maintien, à
								l'étranger, des droits issus du régime français étudiant.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Si
								aucune case n'est
								cochée, le 6.3-1 s'applique.
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
					<fo:table-row>
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline font-weight="bold">6.4 Arbeitsunfallversicherung
									des Praktikanten im Ausland
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="1pt">
								1)
								<fo:inline text-decoration="underline">Um von der französischen
									Gesetzgebung hinsichtlich der Leistungen bei Arbeitsunfällen zu
									profitieren, muss das vorliegende Praktikum:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Eine maximale Dauer, Verlängerungen eingeschlossen,
								von 6 Monaten haben.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="1pt">
								- Zu keiner Vergütung führen,
								die im entsprechenden Ausland das Recht auf einen
								Arbeitsunfallschutz eröffnen könnte (eine Vergütung von 13,75 %
								des Basisstundenlohns der Sozialversicherung (siehe Punkt 5) für
								eine gesetzliche Arbeitsdauer von 35 Wochenstunden wird
								vorbehaltlich dem Einverständnis der Krankenkasse über den
								Erhalt der Garantie akzeptiert).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Nur im Unternehmen
								stattfinden, die Partei dieser
								Vereinbarung sind.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- Nur im genannten
								ausländischen Empfangsland stattfinden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								Sind diese
								Bedingungen nicht erfüllt, verpflichtet sich die
								Empfangseinrichtung, den Praktikanten zu versichern und im Fall
								eines Arbeitsunfalls die notwendigen Erklärungen abzugeben.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">
									Die Unfallerklärung ist
									Sache der Hochschule, die innerhalb von 48 Stunden von der
									Empfangseinrichtung schriftlich informiert werden muss.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								3)
								<fo:inline text-decoration="underline">Die Versicherung betrifft
									Unfälle an den folgenden Orten
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								-
								Innerhalb des Praktikumsorts
								und zu den Uhrzeiten des
								Praktikums.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- Auf dem
								üblichen Hin- und
								Rückweg zwischen dem Wohnort des Praktikanten
								im Ausland und dem
								Ort des Praktikums,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- Im
								Rahmen einer von der
								Empfangseinrichtung des Praktikanten
								angeordneten und mit einer
								entsprechenden Order versehenen
								Mission.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- Auf dem
								Hinweg (Beginn des
								Praktikums) zwischen dem Wohnort des
								Praktikanten und dem Wohnort
								während des Praktikums.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- Auf dem
								Rückweg (Ende des Praktikums) zwischen dem Wohnort während des
								Praktikums und dem Wohnort des Praktikanten.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4)
								<fo:inline text-decoration="underline"> Ist auch nur eine der
									Bedingungen von Punkt 6.4 -1 nicht erfüllt,
								</fo:inline>
								verpflichtet sich die Empfangseinrichtung durch die vorliegende
								Vereinbarung, den Praktikanten gegen Arbeitsunfälle, Reisen und
								Berufskrankheiten zu versichern und alle notwendigen Erklärungen
								abzugeben.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								5)
								<fo:inline text-decoration="underline">In jedem Fall
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Muss die Empfangseinrichtung im Fall eines
								Arbeitsunfalls eines Praktikanten während des Praktikums, diesen
								Unfall unbedingt sofort der Hochschule melden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="4pt">
								- Wenn der
								Student einzelne
								Missionen außerhalb der Empfangseinrichtung oder
								des
								Praktikumslands ausführt, muss die Empfangseinrichtung alle
								notwendigen Maßnahmen ergreifen, um die entsprechenden
								Versicherungen bereitzustellen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								<fo:inline font-weight="bold">6.4 - Protection
									Accident du
									Travail du stagiaire à l'étranger
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt"
								background-color="#E6E6E6" font-style="italic">
								1)
								<fo:inline text-decoration="underline">Pour pouvoir
									bénéficier de
									la législation française
								</fo:inline>
								sur la
								couverture accident
								de travail, le présent stage doit :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								être d'une
								durée au plus égale à 6 mois,
								prolongations
								incluses ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- ne
								donner lieu à aucune
								rémunération susceptible
								d'ouvrir des droits
								à une protection
								accident de travail dans le
								pays d'accueil ; une
								indemnité ou
								gratification est admise dans
								la limite de 13,75% du
								plafond
								horaire de la sécurité sociale
								(cf
								point 5), et sous
								réserve de
								l'accord de la Caisse Primaire
								d'Assurance Maladie sur
								la demande
								de maintien de droit ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- se
								dérouler exclusivement
								dans l'organisme
								signataire de la présente
								convention ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- se
								dérouler exclusivement
								dans le pays d'accueil
								étranger cité.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Lorsque ces
								conditions ne
								sont pas remplies, l'organisme d'accueil
								s'engage à
								cotiser pour
								la protection du stagiaire et à faire
								les
								déclarations nécessaires
								en cas d'accident de travail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" background-color="#E6E6E6"
								font-style="italic">
								2)
								<fo:inline text-decoration="underline">
									La déclaration
									des accidents
									de travail
								</fo:inline>
								incombe à l'établissement d'enseignement qui doit en être
								informé par l'organisme d'accueil par écrit dans un délai de 48
								heures.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								3)
								<fo:inline text-decoration="underline">La couverture concerne les
									accidents survenus
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								dans
								l'enceinte du lieu
								du stage et aux heures du
								stage,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- sur
								le
								trajet
								aller-retour habituel entre la
								résidence du stagiaire sur
								le
								territoire étranger et le lieu du
								stage,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								dans le
								cadre d'une
								mission confiée par l'organisme
								d'accueil du
								stagiaire et
								obligatoirement par ordre de mission,
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								(Article 6.4 suite)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								lors du
								premier trajet
								pour se rendre depuis son domicile sur le
								lieu de
								sa résidence
								durant le stage (déplacement à la date du
								début du
								stage),
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								lors du
								dernier trajet de
								retour depuis sa résidence durant le
								stage à
								son domicile
								personnel.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" padding-top="2pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								4)
								<fo:inline text-decoration="underline"> Pour le cas où
									l'une
									seule
									des conditions prévues au point 6.4-1)
								</fo:inline>
								n'est pas
								remplie, l'organisme d'accueil s'engage à couvrir le
								stagiaire contre le risque d'accident de travail, de trajet et
								les maladies professionnelles et à en assurer toutes les
								déclarations nécessaires.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								5)
								<fo:inline text-decoration="underline">Dans tous les
									cas
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- si
								l'étudiant est victime d'un accident de
								travail
								durant
								le stage,
								l'organisme d'accueil doit
								impérativement
								signaler
								immédiatement
								cet accident à
								l'établissement
								d'enseignement ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- si
								l'étudiant remplit des
								missions limitées
								en dehors
								de l'organisme
								d'accueil ou en dehors
								du pays du
								stage,
								l'organisme d'accueil doit
								prendre toutes les
								dispositions
								nécessaires pour lui fournir les
								assurances
								appropriées.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 7 - Haftpflicht und
								Versicherungen
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Empfangseinrichtung und der Praktikant erklären,
								über eine Haftpflichtversicherung zu verfügen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Bei allen Praktika im
								Ausland oder in Übersee
								verpflichtet sich der Praktikant zum
								Abschluss eines
								Auslandsschutzes (gesundheitsbedingter
								Rücktransport,
								Rechtshilfe...) sowie einer individuellen
								Unfallversicherung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 7 - Responsabilité et
								assurance
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								L'organisme
								d'accueil et le stagiaire déclarent
								être
								garantis au
								titre
								de la responsabilité civile.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Pour
								les stages à l'étranger ou outre-mer, le
								stagiaire s'engage à
								souscrire un contrat d'assistance
								(rapatriement sanitaire,
								assistance juridique...) et un contrat
								d'assurance individuel
								accident.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Lorsque l'organisme d'accueil met un véhicule à la
								disposition du
								stagiaire, il lui incombe de vérifier
								préalablement que la police
								d'assurance du véhicule couvre son
								utilisation par un étudiant.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Lorsque dans le cadre de son stage, l'étudiant
								utilise son propre
								véhicule ou un véhicule prêté par un tiers,
								il déclare
								expressément à l'assureur dudit véhicule et, le cas
								échéant,
								s'acquitte de la prime y afférente.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Artikel 8 - Disziplin
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Der Praktikant muss auf die geltende Disziplin und
								die Hausordnung deren Empfangseinrichtung achten, deren Regeln
								ihm vor Beginn des Praktikums mitgeteilt werden, besonders die
								Arbeitszeiten sowie die Hygiene- und Sicherheitsregeln, die in
								der Empfangseinrichtung gelten.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Nur die Hochschule ist berechtigt, disziplinarische
								Maßnahmen zu ergreifen. In diesen Fällen informiert die
								Empfangseinrichtung den Referenten über die Vergehen und
								übermittelt die eventuell vorhandenen Elemente.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Im Fall besonders schwerer
								Verstöße gegen die
								Disziplin behält sich die Empfangseinrichtung
								das Recht vor, das
								Praktikum des Studenten unter Beachtung des
								Artikels 9 der
								vorliegenden Vereinbarung zu beenden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 8 - Discipline
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								stagiaire
								est soumis à la discipline et aux
								clauses
								du règlement
								intérieur qui lui sont applicables et qui
								sont
								portées à sa
								connaissance avant le début du stage, notamment
								en ce
								qui
								concerne
								les horaires et les règles d'hygiène et de
								sécurité
								en
								vigueur dans
								l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Toute sanction disciplinaire ne peut être décidée que
								par
								l'établissement d'enseignement. Dans ce cas, l'organisme
								d'accueil informe
								l'enseignant référent et l'établissement des
								manquements et
								fournit éventuellement les éléments constitutifs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cas de manquement particulièrement grave à la
								discipline,
								l'organisme d'accueil se réserve le droit de mettre
								fin au stage
								tout en respectant les dispositions fixées à
								l'article 9 de la
								présente convention.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 9 - Urlaub -
								Unterbrechung des Praktikums
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								In Frankreich hat
								der Praktikant (außer im Fall von Sonderregelungen in einigen
								französischen Übersee-Gebietskörperschaften) im Fall einer
								Schwangerschaft, Vaterschaft oder Adoption ein Anrecht auf
								Urlaub und Abwesenheitsgenehmigungen mit der gleichen Dauer wie
								die Angestellten gemäß der Artikel L.1225-16 à L.1225-28,
								L.1225-35, L.1225-37, L.1225-46 des Arbeitsgesetzbuchs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Bei Praktika mit
								einer Dauer von mehr als 2 Monaten und im Rahmen der maximal
								autorisierten Dauer von 6 Monaten, sind Urlaub oder
								Abwesenheitsgenehmigungen möglich.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline text-decoration="underline">
									ANZAHL DER AUTORISIERTEN
									URLAUBSTAGE
								</fo:inline>
								/ oder Modalitäten für Urlaub und Abwesenheitsgenehmigungen
								während des Praktikums:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<xsl:value-of select="nb-conges" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<!-- cinquieme page -->
	<xsl:template name="ArticlesPage5">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								(Artikel 9 Fortsetzung)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Die
								Empfangseinrichtung wird jede andere zeitweilige Unterbrechung
								des Praktikums (Krankheit, ungerechtfertigtes Fehlen...) der
								Hochschule schriftlich melden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt">
								Jede Unterbrechung des Praktikums muss den anderen
								Parteien der Vereinbarung und dem Lehrer-Referenten mitgeteilt
								werden. Gegebenenfalls führt die Einrichtung
								Validierungsmodalitäten ein. Bei Einverständnis aller Parteien
								kann eine Verschiebung des Praktikums erwogen werden, um die
								gesamte ursprünglich vorgesehene Praktikumsdauer zu erreichen.
								Diese Verschiebung wird Gegenstand eines Nachtrags zu dieser
								Vereinbarung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Im Fall der Verlängerung des Praktikums auf
								gemeinsamen Antrag der
								Empfangseinrichtung und des Praktikanten
								und unter Beachtung der
								gesetzlich vorgesehenen Höchstdauer von 6
								Monaten, kann ein
								Nachtrag zu dieser Vereinbarung erstellt
								werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Im Fall, dass eine der drei
								Parteien
								(Empfangseinrichtung, Hochschule, Praktikant,) das
								Praktikum
								definitiv unterbrechen will, muss sie die beidenanderen
								Parteien
								sofort schriftlich davon in Kenntnis setzen. Die dafür
								angegebenen Gründe werden in enger Absprache untersucht. Die
								definitive Entscheidung eines Abbruchs des Praktikums erfolgt
								erst nach dieser Abstimmungsphase.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 9 - Congés -
								Interruption du stage
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								France (sauf
								en cas de règles particulières applicables dans
								certaines
								collectivités d'outre-mer françaises ou dans les
								organismes de
								droit public), en cas de grossesse,
								de paternité ou
								d'adoption,
								le
								stagiaire bénéficie de congés
								et
								d'autorisations
								d'absence d'une
								durée équivalente à celle
								prévues
								pour les salariés
								aux
								articles
								L.1225-16 à L.1225-28,
								L.1225-35, L.1225-37, L.1225-46
								du code du
								travail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Pour les stages
								dont la
								durée est supérieure à deux
								mois et dans la limite de la
								durée
								maximale de 6 mois, des
								congés ou autorisations d'absence
								sont
								possibles.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								<fo:inline text-decoration="underline">
									NOMBRE
									DE JOURS DE CONGES
									AUTORISES
								</fo:inline>
								/ ou modalités des congés et autorisations d'absence durant le
								stage : ...
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								Pour toute autre
								interruption temporaire du stage (maladie, absence
								injustifiée...)
								l'organisme d'accueil avertit l'établissement
								d'enseignement par
								courrier.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								Toute interruption du
								stage, est signalée aux autres
								parties à la convention et à
								l'enseignant référent. Une modalité
								de validation est mise en
								place le cas échéant par
								l'établissement. En cas d'accord des
								parties à la convention, un
								report de la fin du stage est
								possible afin de permettre la
								réalisation de la durée totale du
								stage prévue initialement. Ce
								report fera l'objet d'un avenant à
								la convention de stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Un
								avenant à la
								convention pourra être
								établi en cas de
								prolongation
								du stage sur demande conjointe de
								l'organisme
								d'accueil et du
								stagiaire, dans le respect de
								la durée
								maximale du
								stage fixée par
								la loi (6 mois).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cas de volonté d'une des trois parties (organisme
								d'accueil,
								stagiaire, établissement d'enseignement) d'arrêter le
								stage,
								celle-ci doit immédiatement en informer les deux autres
								parties
								par écrit. Les raisons invoquées seront examinées en
								étroite
								concertation. La décision définitive d'arrêt du stage ne
								sera
								prise qu'à l'issue de cette phase de concertation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 10 - Schweigepflicht
								und Vertraulichkeit
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Schweigepflicht ist strikt einzuhalten und wird
								von der Empfangseinrichtung entsprechend ihrer Spezifizitäten
								definiert. Die Praktikanten verpflichten sich damit, die
								Informationen, die sie während des Praktikums gesammelt oder
								erhalten haben, nicht ohne das Einverständnis der
								Empfangseinrichtung zu veröffentlichen oder sie an Dritte
								weiterzugeben, inklusive des Praktikumsberichts. Diese
								Verpflichtung gilt nicht nur für die Dauer des Praktikums
								sondern auch nach dessen Ende. Der Praktikant verpflichtet sich,
								ohne die Genehmigung der Empfangseinrichtung keinerlei der
								Einrichtung gehörende Dokumente oder Software welcher Art auch
								immer zu behalten, mitzunehmen oder zu kopieren.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								Im Rahmen der Vertraulichkeit der im
								Praktikumsbericht enthaltenen Informationen kann die
								Empfangseinrichtung fordern, dass dieser nur eingeschränkt
								veröffentlicht oder dass einige sehr vertrauliche Elemente
								komplett entfernt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" padding-bottom="4pt">
								Die Personen, die mit dem
								Inhalt vertraut gemacht
								werden, sind durch das Berufsgeheimnis
								verpflichtet, die
								enthaltenen Informationen weder zu nutzen noch
								zu verbreiten.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 10 - Devoir de réserve
								et confidentialité
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								devoir de
								réserve est de rigueur absolue et
								apprécié
								par
								l'organisme
								d'accueil compte-tenu de ses
								spécificités. Le
								stagiaire
								prend donc l'engagement de n'utiliser
								en aucun cas
								les
								informations recueillies ou obtenues par eux pour
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
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Dans
								le cadre de la confidentialité des informations
								contenues dans le
								rapport de stage, l'organisme d'accueil peut
								demander une
								restriction de la diffusion du rapport, voire le
								retrait de
								certains éléments confidentiels.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Les
								personnes amenées à en connaître sont contraintes
								par le secret
								professionnel à n'utiliser ni ne divulguer les
								informations du
								rapport.
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
								Artikel 11 - Geistiges Eigentum
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Entsprechend dem Gesetz über das geistige Eigentum
								muss, sollte die Arbeit des Praktikanten zu einem vom
								Urheberrecht oder dem Recht auf industrielles Eigentum
								geschützten Werk führen (inklusive einer Software) und sollte
								die Empfangseinrichtung dieses nutzen wollen, und der Praktikant
								damit einverstanden sein, ein Vertrag zwischen dem Praktikanten
								(Autor) und der Empfangseinrichtung geschlossen werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Der Vertrag muss
								insbesondere den Rahmen der abgetretenen Rechte, eine eventuelle
								Exklusivität, die Bestimmung, die genutzten Träger und die Dauer
								der Abtretung sowie gegebenenfalls den Betrag der Vergütung
								desPraktikanten für die Abtretung beinhalten. Diese Klausel ist
								immer gültig und nicht an den Status der Empfangseinrichtung
								gebunden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 11 - Propriété intellectuelle
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Conformément au code de la propriété intellectuelle,
								dans le cas
								où les activités du stagiaire donnent lieu à
								la
								création d'une
								&#339;uvre protégée par le droit d'auteur ou la
								propriété
								industrielle (y compris un logiciel), si l'organisme
								d'accueil
								souhaite l'utiliser et que le stagiaire en est
								d'accord, un
								contrat devra être signé entre le stagiaire
								(auteur) et
								l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								contrat devra alors notamment préciser l'étendue
								des droits
								cédés, l'éventuelle exclusivité, la destination, les
								supports
								utilisés et la durée de la cession, ainsi que, le cas
								échéant, le
								montant de la rémunération due au stagiaire au
								titre
								de la
								cession. Cette clause s'applique quel que soit le
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
								Artikel 12 - Ende des
								Praktikums
								- Bericht - Bewertung
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								1)
								<fo:inline text-decoration="underline">Praktikumsbescheinigung:
								</fo:inline>
								Anschließend an das Praktikum stellt die Empfangseinrichtung dem
								Praktikanten eine Praktikumsbescheinigung aus, in der mindestens
								die effektive Dauer des Praktikums und gegebenenfalls die Höhe
								der erhaltenen Vergütung angegeben sind. Der Praktikant muss
								diese Bescheinigung bei einer eventuellen Öffnung der Rechte für
								die gesetzliche Rentenversicherung gemäß Art. L.351-17 des
								Sozialgesetzbuchs vorlegen;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								2)
								<fo:inline text-decoration="underline">Qualität des Praktikums
								</fo:inline>
								: Nach Abschluss des Praktikums sind die Parteien der
								vorliegenden Vereinbarung eingeladen, eine Bewertung zur
								Qualität des Praktikums abzugeben.
								Der Praktikant übermittelt der
								kompetenten Stelle an der Hochschule
								ein Dokument, in dem er die
								Qualität des Empfangs durch die
								Empfangseinrichtung bewertet.
								Dieses Dokument wird in seiner
								Bewertung oder beim Erreichen des
								Diploms oder der Bescheinigung
								nicht berücksichtigt.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline">Einschätzung der Tätigkeit
									des Praktikanten
								</fo:inline>
								: Nach Abschluss des Praktikums wird von der Empfangseinrichtung
								ein Bewertungsblatt über die Tätigkeit des Praktikanten
								ausgefüllt und an den Lehrer-Referenten weitergeleitet (oder
								präzisieren, ob es eine Anlage oder Bewertungsmodalitäten gibt,
								die vorab gemeinsam mit dem Lehrer-Referenten definiert wurden).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								4)
								<fo:inline text-decoration="underline">Modalitäten der
									pädagogischen Bewertung
								</fo:inline>
								: 
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt" padding-bottom="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								<fo:inline text-decoration="underline">ANZAHL DER ECTS (falls
									relevant)
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
								text-align="justify" padding-top="2pt" padding-bottom="4pt">
								5) Weder
								der Tutor der
								Empfangseinrichtung noch jedes andere Mitglied der
								Empfangseinrichtung, das während der Vorbereitung, des Ablaufs
								und der Anerkennung des Praktikums die Hochschule besucht hat,
								kann seitens der Hochschule die Übernahme von Kosten oder eine
								Entschädigung fordern.
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<!-- sixieme page -->
	<xsl:template name="ArticlesPage6">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 12 - Fin de stage -
								Rapport - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								1)
								<fo:inline text-decoration="underline">Attestation de stage
								</fo:inline>
								: à l'issue du stage, l'organisme d'accueil délivre une
								attestation dont le modèle figure en annexe, mentionnant au
								minimum la durée effective du stage et, le cas échéant, le
								montant de la gratification perçue. Le stagiaire devra
								produire
								cette attestation à l'appui de sa demande éventuelle
								d'ouverture
								de droits au régime général d'assurance vieillesse
								prévue à
								l'art. L.351-17 du code de la sécurité sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								2)
								<fo:inline text-decoration="underline">Qualité du stage
								</fo:inline>
								: à l'issue du stage, les parties à la présente convention sont
								invitées à formuler une appréciation sur la qualité du stage.
								Le
								stagiaire transmet au service compétent de
								l'établissement
								d'enseignement un document dans lequel il
								évalue la qualité
								de
								l'accueil dont il a bénéficié au sein
								de l'organisme
								d'accueil. Ce
								document n'est pas pris en compte
								dans son
								évaluation ou dans
								l'obtention du diplôme ou de la
								certification.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								3)
								<fo:inline text-decoration="underline">Évaluation de l'activité
									du
									stagiaire
								</fo:inline>
								: à l'issue du stage, l'organisme d'accueil renseigne une fiche
								d'évaluation de l'activité du stagiaire qu'il retourne à
								l'enseignant référent (ou préciser si fiche
								annexe ou modalités
								d'évaluation préalablement définis en
								accord avec l'enseignant
								référent).
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic"
								font-weight="bold">
								(Article 12 suite)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								4)
								<fo:inline text-decoration="underline">Modalités d'évaluation
									pédagogiques
								</fo:inline>
								: 
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								<fo:inline text-decoration="underline">NOMBRE D'ECTS (le
									cas
									échéant)
								</fo:inline>
								: ...
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								5) Le
								tuteur de l'organisme
								d'accueil ou tout membre de l'organisme
								d'accueil appelé à se
								rendre dans l'établissement d'enseignement
								dans le cadre de la
								préparation, du déroulement et de la
								validation du stage ne peut
								prétendre à une quelconque prise en
								charge ou indemnisation de
								la part de l'établissement
								d'enseignement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" font-weight="bold">
								Artikel 13 -
								Anwendbares Recht - Gerichtsstand
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die vorliegende Vereinbarung unterliegt
								ausschließlich französischem Recht.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Jeder Streitfall, der nicht gütlich beigelegt werden
								kann, wird der zuständigen französischen Gerichtsbarkeit
								vorgelegt.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								Article 13 -
								Droit applicable - Tribunaux compétents
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								présente convention
								est régie exclusivement par le
								droit français.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Tout
								litige non résolu
								par voie amiable sera soumis à
								la compétence de
								la juridiction
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
				<fo:leader />
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:inline font-weight="bold">AUSGEFERTIGT IN </fo:inline>
				<fo:inline font-size="9pt" font-style="italic">(FAIT A)</fo:inline>
				.....................................................
				<fo:inline font-weight="bold"> AM </fo:inline>
				<fo:inline font-size="9pt" font-style="italic">(LE)</fo:inline>
				.....................................................
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
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
								FÜR DIE
								HOCHSCHULEINRICHTUNG
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="6.5pt" font-family="Times New Roman,serif"
								font-style="italic">
								(POUR L'ÉTABLISSEMENT D'ENSEIGNEMENT)
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
												Unterzeichner der Management-Center, je Delegation,
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
										Name und Unterschrift des
										Vertreters der Hochschule
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="6.5pt" font-family="Times New Roman,serif"
										font-style="italic">
										(Nom et signature du représentant de
										l'établissement)
									</fo:block>
									<fo:block line-height="110%" padding-top="8pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt"
										font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="600%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" font-weight="bold">
								FÜR DIE
								EMPFANGSEINRICHTUNG
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="6.5pt" font-family="Times New Roman,serif"
								font-style="italic">
								(POUR L'ORGANISME D'ACCUEIL)
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
										Name und Unterschrift des Vertreters der
										Empfangseinrichtung
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="6.5pt" font-family="Times New Roman,serif"
										font-style="italic">
										(Nom et signature du représentant de l'organisme
										d'accueil)
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
								PRAKTIKANT (UND
								GEGEBENENFALLS SEIN GESETZLICHER VERTRETER)
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="6.5pt" font-family="Times New Roman,serif"
								font-style="italic">
								(STAGIAIRE (ET SON REPRESENTANT LEGAL LE CAS
								ECHEANT))
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
										Name und Unterschrift
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="6.5pt" font-family="Times New Roman,serif"
										font-style="italic">
										(Nom et signature)
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="600%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<!-- Tuteur pro -->
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" font-weight="bold">
								Der Tutor des Praktikums
								der Empfangseinrichtung
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="6.5pt" font-family="Times New Roman,serif"
								font-style="italic">
								(LE TUTEUR DE STAGE DE L'ORGANISME D'ACCUEIL)
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
										Name und Unterschrift
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="6.5pt" font-family="Times New Roman,serif"
										font-style="italic">
										(Nom et signature)
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell>
							<!-- Tuteur pedago -->
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" font-weight="bold">
								Der Lehrer-Referent des
								Praktikanten
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="6.5pt" font-family="Times New Roman,serif"
								font-style="italic">
								(L'ENSEIGNANT RÉFÉRENT DU STAGIAIRE)
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
										Name und Unterschrift
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="6.5pt" font-family="Times New Roman,serif"
										font-style="italic">
										(Nom et signature)
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										......................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="600%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<xsl:template name="Attestation">
		<fo:block margin-right="1.5cm" margin-left="1.5cm"
			margin-bottom="1.09cm" font-family="Times New Roman,serif"
			padding-top="1cm">
			<fo:block text-align="center" hyphenate="false" language="fr"
				country="FR" font-weight="bold" font-size="18pt">
				PRAKTIKUMSBESCHEINIGUNG
			</fo:block>
			<fo:block text-align="center" line-height="110%"
				padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
				font-size="10pt" font-family="Times New Roman,serif" font-style="italic">
				(ATTESTATION DE STAGE)
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:block text-align="center" padding-top="5pt" hyphenate="false"
				language="fr" country="FR" font-weight="bold" font-size="16pt"
				font-style="italic">
				dem Praktikanten
				nach Abschluss des Praktikums
				auszuhändigen
			</fo:block>
			<fo:block text-align="center" line-height="110%"
				padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
				font-size="10pt" font-family="Times New Roman,serif" font-style="italic">
				(à
				remettre au stagiaire à l'issue du stage)
			</fo:block>
			<fo:block padding-top="20pt">
				<fo:table border="0.018cm solid #000000" padding="3pt"
					width="100%" table-layout="fixed">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
								padding-top="0.2cm">
								<fo:block>
									<fo:inline font-weight="bold" text-decoration="underline"
										font-size="9pt">
										EMPFANGSEINRICHTUNG
									</fo:inline>
									<fo:inline font-size="8pt" font-style="italic">
										(ORGANISME
										D'ACCUEIL)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="150%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">Name oder Firmenbezeichnung
									</fo:inline>
									<fo:inline font-size="8pt" font-style="italic">
										(Nom ou
										dénomination sociale)
									</fo:inline>
									<fo:inline font-weight="bold"> :
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="structure/raison-sociale" />
									</fo:inline>
								</fo:block>
								<fo:block line-height="150%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">Adresse : </fo:inline>
									<fo:inline font-size="8pt" font-style="italic">(Adresse)
									</fo:inline>
									<fo:inline font-weight="bold"> :
									</fo:inline>
									<fo:inline>
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

								<fo:block line-height="150%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">Tel : </fo:inline>
									<xsl:value-of select="structure/telephone" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block padding="0.3cm">
					<fo:inline font-size="9pt" font-weight="bold">
						Bescheinigt, dass
					</fo:inline>
					<fo:inline font-style="italic" font-size="8pt">
						(Certifie que)
					</fo:inline>
				</fo:block>
				<fo:table border="0.018cm solid #000000" padding="3pt"
					width="100%" table-layout="fixed">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
								padding-top="0.2cm">
								<fo:block font-size="9pt">
									<fo:inline font-weight="bold" font-size="9pt"
										text-decoration="underline">
										DER PRAKTIKANT
									</fo:inline>
									<fo:inline font-size="8pt" font-style="italic">
										(LE
										STAGIAIRE)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Name
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Nom)
									</fo:inline>
									<fo:inline>
										:
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
									</fo:inline>

									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Vorname
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Prénom)
									</fo:inline>
									<fo:inline>
										:
									</fo:inline>
									<fo:inline>
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="etudiant/prenom" />
											</xsl:with-param>
										</xsl:call-template>
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Geschlecht
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Sexe)
									</fo:inline>
									<fo:inline>
										:
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="etudiant/code-sexe" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Geboren am
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Né le)
									</fo:inline>
									<fo:inline>
										:
									</fo:inline>
									<fo:inline>
										<xsl:value-of
											select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))" />
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
								padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Adresse
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Adresse)
									</fo:inline>
									<fo:inline>
										:
									</fo:inline>
									<fo:inline>
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
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
								padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
										padding-bottom="0.035cm">
										<fo:inline font-weight="bold">
											Tel :
										</fo:inline>
										<xsl:value-of select="tel-etudiant" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
										padding-bottom="0.035cm">
										<fo:inline font-weight="bold">
											Portable :
										</fo:inline>
										<xsl:value-of select="tel-portable-etudiant" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
										padding-bottom="0.035cm">
										<fo:inline font-weight="bold">
											Mail :
										</fo:inline>
										<xsl:value-of select="etudiant/mail" />
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
								padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										STUDENT DER (Bezeichnung der
										in der Hochschuleinrichtung belegten Ausbildungoder
										Studiengangs des Praktikanten)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-style="italic" font-size="8pt">
										(ETUDIANT
										EN(intitulé de la formation ou du cursus de
										l'enseignement
										supérieur suivi par le ou la stagiaire )) :
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<xsl:value-of select="etape/libelle" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
								padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										IM (Name der Hochschule oder
										der Ausbildungseinrichtung)
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(AU
										SEIN DE
										(nom de
										l'établissement d'enseignement supérieur ou
										de
										l'organisme de
										formation))
									</fo:inline>
									<fo:inline>
										:
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
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block padding="0.3cm" margin-left="0.5cm">
					<fo:inline font-weight="bold" font-size="11pt">
						ein in seinem
						Studium
						vorgesehenes Praktikum absolviert hat
					</fo:inline>
					<fo:inline font-style="italic" font-size="8pt">
						(a
						effectué un
						stage prévu dans le cadre de ses études)
					</fo:inline>
				</fo:block>
				<fo:table table-layout="fixed" width="100%"
					border="0.018cm solid #000000">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									margin-left="0.5cm" padding-top="0.3cm">
									<fo:inline font-size="9pt" font-weight="bold"
										text-decoration="underline">
										DAUER DES PRAKTIKUMS
									</fo:inline>
									<fo:inline font-size="8pt" font-style="italic">
										(DUREE DU
										STAGE)
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Anfangs- und Abschlussdaten
										des Praktikums
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Dates de
										début et de fin
										du stage) :
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">Vom</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Du)
									</fo:inline>
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										bis zum
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">(Au)
									</fo:inline>
									<xsl:text> </xsl:text>
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:if test="@interruption-stage = 'true'">
										<xsl:text> </xsl:text>
										<fo:inline font-weight="bold" font-size="11pt">
											mit
											Unterbrechung Vom
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">(avec
											interruption du)
										</fo:inline>
										<xsl:text> </xsl:text>
										......................................
										<fo:inline font-weight="bold" font-size="11pt">
											bis zum
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">(au)
										</fo:inline>
										<xsl:text> </xsl:text>
										......................................
									</xsl:if>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Für eine Gesamtdauer von
									</fo:inline>
									<fo:inline>
										..................... (Anzahl der Monate / Anzahl
										der Wochen) (Unzutreffendes bitte streichen))
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" font-style="italic">
									(Représentant une durée
									totale de ...
									Nombre de Mois / Nombre de Semaines (rayer la
									mention
									inutile))
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" margin-left="0.5cm" text-align="justify">
									Die
									Gesamtdauer des Praktikums berücksichtigt die effektive
									Anwesenheit des Praktikanten in der Einrichtung, vorbehaltlich
									des Rechts auf Urlaub und Abwesenheitsgenehmigungen wie in Art.
									L.124-13 des Bildungsgesetzbuchs (Art. L.124-18 des
									Bildungsgesetzbuchs) vorgesehen sind. Jede Periode von 7
									Stunden durchgehender oder nicht durchgehender Anwesenheit wird
									als ein Praktikumstag berechnet, und jede Periode von
									mindestens 22 Tagen durchgehender oder nicht durchgehender
									Anwesenheit wird als einen Monat berechnet.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.1cm" margin-left="0.5cm" text-align="justify"
									font-style="italic" background-color="#E6E6E6">
									La
									durée totale du stage
									est appréciée en tenant compte de la
									présence effective du
									stagiaire dans l'organisme, sous réserve
									des droits à congés et
									autorisations d'absence prévus à
									l'article L.124-13 du code de
									l'éducation (art. L.124-18 du code
									de l'éducation). Chaque
									période au moins égale à 7 heures de
									présence consécutives ou
									non est considérée comme équivalente à
									un jour de stage et
									chaque période au moins égale à 22 jours de
									présence
									consécutifs
									ou non est considérée comme équivalente à
									un mois.
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell padding-top="0.2cm" border-top="0.018cm solid #000000">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									margin-left="0.5cm">
									<fo:inline font-weight="bold" text-decoration="underline">
										HÖHE
										DER VERGÜTUNG, DIE DEM PRAKTIKANTEN GEZAHLT WURDE
									</fo:inline>
									<fo:inline font-size="6.5pt" font-style="italic">
										(MONTANT DE
										LA GRATIFICATION
										VERSÉE AU STAGIAIRE)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="9pt" font-family="Times New Roman,serif"
									padding-top="0.2cm">
									Der Praktikant hat eine Praktikumsvergütung in Höhe
									eines Gesamtbetrags von ..................................
									&#8364; </fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="6.5pt" font-family="Times New Roman,serif"
									padding-top="0.1cm" font-style="italic">
									(Le stagiaire a perçu une
									gratification de stage
									pour un
									montant total de)
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>


				<fo:table table-layout="fixed" width="100%" margin="0.1cm"
					padding-top="0.5cm">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" font-style="italic" text-align="justify">
									<fo:inline font-weight="bold">
										Die Praktikumsbescheinigung
									</fo:inline>
									ist unverzichtbar, um, vorbehaltlich der Zahlung eines
									Beitrags, das Praktikum für die Rentenrechte berücksichtigen zu
									können. Die Rentengesetze (Gesetz Nr. 2014-40 vom 20. Januar
									2014) eröffnet den Studenten,
									<fo:inline font-weight="bold">die eine Vergütung für ihr
										Praktikum erhalten haben,
									</fo:inline>
									die Möglichkeit, dieses innerhalb eines Limits
									<fo:inline font-weight="bold">vor zwei Trimestern,
									</fo:inline>
									anrechnen zu lassen, wenn sie dafür
									<fo:inline font-weight="bold">ihren Beitrag eingezahlt
										haben.
									</fo:inline>
									Der
									<fo:inline font-weight="bold">Antrag dafür muss von
										Studenten in den zwei Jahren
									</fo:inline>
									nach dem Ende des Praktikums und mit
									<fo:inline font-weight="bold">obligatorischer Vorlage der
										Praktikumsbescheinigung
									</fo:inline>
									gestellt werden, auf der die Gesamtdauer des Praktikums und die
									erhaltene Vergütung vermerkt sind. Genaue Auskünfte zur
									Beitragszahlung und den Formalitäten gibt die
									Krankenversicherung (Sozialgesetzbuch Art. L.351-17 -
									Bildungsgesetzbuch Art. .D.124-9).
								</fo:block>

								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="7pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" font-style="italic" background-color="#E6E6E6"
									text-align="justify">
									L'attestation de stage est indispensable pour
									pouvoir, sous
									réserve du versement d'une
									cotisation, faire
									prendre en compte
									le stage dans les droits à
									retraite. La
									législation sur les
									retraites (loi n°2014-40 du 20
									Janvier 2014)
									ouvre aux étudiants
									dont le stage a été gratifié, la possibilité
									de faire valider
									celui-ci dans la limite de deux trimestres,
									sous réserve du
									versement d'une cotisation. La demande est à
									faire par
									l'étudiant dans les deux années
									suivant la fin du stage
									et sur
									présentation obligatoire de l'attestation de stage
									mentionnant
									la durée totale du stage et le montant total de la
									gratification perçue. Les informations
									précises sur la
									cotisation à verser et sur la procédure à suivre
									sont à demander
									auprès de la Sécurité sociale (code de la sécurité sociale art.
									L.351-17 - code de
									l'éducation art.D.124-9).
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.4cm" padding-right="0.141cm" padding-top="1cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										AUSGEFERTIGT IN
									</fo:inline>
									(Fait à)
									...................................................................
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.3cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold"> AM
									</fo:inline>
									(Le) ........................
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.5cm"
									padding-bottom="0.035cm">
									Name, Funktion und Unterschrift des Vertreters
									der Empfangseinrichtung
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="6.5pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.1cm"
									padding-bottom="0.035cm" font-style="italic">
									(Nom, fonction et signature
									du représentant de
									l'organisme
									d'accueil)
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</fo:block>
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