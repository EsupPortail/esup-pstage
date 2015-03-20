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
			(Fiches � annexer � la conventions)
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
				L�nderformulare auf diplomatie.gouv.fr)
			</fo:inline>
		</fo:block>
		<fo:block line-height="100%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			font-style="italic">
			(Fiche de stage � l'�tranger
			(pour
			informations s�curit�
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
			�ch�ant))
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
						<!-- Ann�e universitaire -->
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
								n�
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
			"stagiaire", "enseignant r�f�rent", "tuteur de
			stage", "repr�sentant
			l�gal", "�tudiant" sont utilis�s
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
							<fo:inline font-style="italic" font-size="8pt">(Repr�sent�
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
												<fo:inline font-style="italic" font-size="8pt">(Qualit�
													du repr�sentant)
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
												<fo:inline font-style="italic" font-size="8pt">(Qualit�
													du repr�sentant)
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
								diff�rente de celle
								de l'�tablissement))
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
							<fo:inline font-style="italic" font-size="8pt">(Repr�sent�
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
							<fo:inline font-style="italic" font-size="8pt"> (Qualit� du
								repr�sentant)
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
								Praktikum durchgef�hrt wird
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Service dans
								lequel le stage
								sera effectu�)
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
									stage (si diff�rent de
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
							<fo:inline font-style="italic" font-size="8pt">(Pr�nom)
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
							<fo:inline font-style="italic" font-size="8pt">(N� le)
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
							<fo:inline font-style="italic" font-size="8pt">(Num�ro
								d'�tudiant)
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
							(INTITUL� DE LA FORMATION OU DU
							CURSUS SUIVI DANS
							L'�TABLISSEMENT
							D'ENSEIGNEMENT SUP�RIEUR ET
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
												F�r eine Gesamtdauer von
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
												tats�chlicher
												Anwesenheitsstunden in der Empfangseinrichtung
											</fo:inline>
										</fo:block>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm" font-style="italic">
											(correspondant
											� ...
											heures de
											pr�sence effective dans
											l'organisme d'accueil)
										</fo:block>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												und f�r eine Gesamtdauer von
											</fo:inline>
											<fo:inline font-style="italic" font-size="8pt">(et
												correspondant �)
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
										F�r eine Gesamtdauer von
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									wochen
									<fo:inline font-style="italic" font-size="8pt">(Repr�sentant
										une dur�e totale de ... semaines)
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
											durchg�ngiger Anwesenheit
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">(R�partition
											si pr�sence
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
								pr�nom
								de
								l'enseignant r�f�rent)
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
								pr�nom
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
							kontaktierende Krankenkasse (Wohnort des Praktikanten , au�er
							Ausnahmen):
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="8pt" font-family="Times New Roman,serif"
							font-style="italic">
							(Caisse primaire
							d'assurance maladie � contacter en cas
							d'accident (lieu de
							domicile de l'�tudiant sauf exception))
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
			(Convention imprim�e le : ...)
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
								La pr�sente convention r�gle les
								rapports de l'organisme
								d'accueil avec
								l'�tablissement
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
								Das Praktikum erm�glicht ein befristetes Eintauchen in das
								Berufsleben, w�hrend dem die Studenten die M�glichkeit haben,
								professionelle Kompetenzen zu erwerben, bei denen sie ihr in der
								Ausbildung erworbenes Wissen mit dem Ziel, ein Diplom oder ein
								Zeugnis zu erhalten oder die berufliche Eingliederung zu
								f�rdern, anwenden k�nnen. Dem Praktikanten werden eine oder
								mehrere Aufgaben zugewiesen, die dem p�dagogischen Projekt der
								Hochschuleinrichtung entsprechen und von der Empfangseinrichtung
								best�tigt werden.
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
								Le stage correspond � une
								p�riode temporaire
								de
								mise en situation
								en milieu professionnel au
								cours de laquelle
								l'�tudiant
								acquiert
								des comp�tences
								professionnelles
								et met en
								&#339;uvre les
								acquis
								de sa
								formation en
								vue de
								l'obtention d'un
								dipl�me ou d'une
								certification et de
								favoriser son insertion
								professionnelle.
								Le
								stagiaire se voit
								confier une ou des missions
								conformes au
								projet
								p�dagogique d�fini
								par son �tablissement
								d'enseignement
								et
								approuv�es par l'organisme
								d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								programme est �tabli
								par l'�tablissement
								d'enseignement
								et
								l'organisme
								d'accueil en
								fonction du programme
								g�n�ral de la
								formation
								dispens�e.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								<fo:inline text-decoration="underline">ACTIVIT�S CONFI�ES
								</fo:inline>
								: ...
							</fo:block>
							<fo:block line-height="110%" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" background-color="#E6E6E6"
								font-style="italic">
								<fo:inline text-decoration="underline">
									Comp�tences � acqu�rir ou �
									d�velopper
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
								Artikel 3 - Modalit�ten des Praktikums
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Wochenanwesenheitszeit des Praktikanten in der
								Empfangseinrichtung betr�gt
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
								<!-- (quotit� : -->
								<!-- <fo:inline font-weight="bold"> -->
								<!-- <xsl:value-of select="quotite-travail" /> -->
								<!-- %). -->
								<!-- </fo:inline> -->
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Bei einer m�glichen Anwesenheit des Praktikanten in der
								Empfangseinrichtung w�hrend der Nacht, am Sonntag oder an einem
								Feiertag, m�ssen diese Sonderf�lle angegeben werden.
								<fo:inline font-weight="bold">
									<xsl:value-of select="travail-nuit-ferie" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="4pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								Article 3 - Modalit�s du stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								La dur�e hebdomadaire de
								pr�sence du stagiaire
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
								Si le stagiaire doit �tre
								pr�sent dans l'organisme
								d'accueil
								la
								nuit, le
								dimanche ou un jour
								f�ri�, pr�ciser
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
								ist f�r die Betreuung des Praktikanten und die Optimierung der
								Durchf�hrungsbedingungen entsprechend der definierten
								p�dagogischen Ziele verantwortlich.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Der Praktikant darf w�hrend der Dauer des Praktikums an die
								Bildungseinrichtung zur�ckkehren, um an vom Programm
								ausdr�cklich vorgesehenen Kursen und Versammlungen teilzunehmen,
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
								Jedes Problem bei der Durchf�hrung oder
								dem
								Ablauf des
								Praktikums,
								gleichg�ltig, ob es vom Praktikanten
								oder
								dem Tutor
								des Praktikums
								festgestellt wird, muss dem
								Referenzen
								der
								Hochschuleinrichtung
								mitgeteilt und
								schnellstm�glich gel�st
								werden.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									BETREUUNGSMODALIT�TEN
								</fo:inline>
								(Besuche, Telefongespr�che usw.)
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
								l'enseignant r�f�rent d�sign� dans la pr�sente convention ainsi
								que par le service de l'�tablissement en charge des stages.
							</fo:block>
							<fo:block line-height="100%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Le tuteur de stage d�sign�
								par l'organisme d'accueil dans la
								pr�sente convention est charg�
								d'assurer le suivi du stagiaire
								et d'optimiser les conditions de
								r�alisation du stage
								conform�ment aux stipulations p�dagogiques
								d�finies.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								keep-with-next="always" text-align="justify" font-weight="bold">Artikel
								5 - Verg�tung - Sachleistungen
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Verg�tung ist in Frankreich zwingend, wenn die
								Praktikumsdauer zwei aufeinander folgende oder nicht aufeinander
								folgende Monate �berschreitet, au�er bei Sonderregeln in einigen
								�bersee-Gebietsk�rperschaften und Praktika im Rahmen von Art.
								L4381-1 des Gesetzbuchs f�r das �ffentliche Gesundheitswesen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Der Stundenbetrag der Verg�tung ist auf 13,75 % des
								Basisstundenlohns der Sozialversicherung gem�� Artikel L.241-3
								des Sozialgesetzbuchs festgelegt. In einem branchenspezifischen
								Abkommen oder beruflichem �bereinkommen k�nnen h�here Betr�ge
								festgelegt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Eine Verg�tung durch eine �ffentliche Einrichtung
								kann nicht mit
								einer in der gleichen Periode von dieser
								Einrichtung geleisteten
								Zahlung kumuliert werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Verg�tung erfolgt unbeschadet der Erstattung der
								vom Praktikanten vorgestreckten Kosten zur Durchf�hrung seines
								Praktikums oder der eventuellen Sachleistungen f�r Verkostung,
								Unterbringung und Transport.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Einrichtung kann sich entschlie�en, eine Verg�tung f�r
								Praktiken mit einer Dauer von zwei Monaten oder weniger zu
								zahlen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Im Fall einer Unterbrechung oder K�ndigung der
								vorliegenden Vereinbarung, wird die Verg�tung des Praktikanten
								im Verh�ltnis zur Dauer des durchgef�hrten Praktikums berechnet.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Dauer, die ein Anrecht auf die Verg�tung gibt,
								wird auf der Grundlage der vorliegenden Vereinbarung und deren
								eventueller Nachtr�ge sowie der Anzahl der effektiven
								Anwesenheitstage des Praktikanten in der Einrichtung berechnet.
							</fo:block>
							<xsl:variable name="indemnisation" select="id-indemnisation" />
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>

								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">DIE H�HE DER VERG�TUNG
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
								dur�e du stage est sup�rieure � deux mois
								cons�cutifs
								ou non,
								celui-ci fait obligatoirement l'objet d'une
								gratification, sauf
								en cas de r�gles particuli�res applicables
								dans certaines
								collectivit�s d'outre-mer fran�aises et pour les
								stages relevant
								de l'article
								L4381-1 du code de la sant�
								publique.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								montant horaire de
								la
								gratification
								est fix� � 13,75%
								du plafond
								horaire de la
								s�curit� sociale d�fini
								en application
								de
								l'article
								L.241-3 du
								code de la s�curit� sociale. Une
								convention
								de branche
								ou un
								accord professionnel peut d�finir
								un
								montant
								sup�rieur � ce
								taux.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								gratification due
								par un organisme de droit public
								ne
								peut �tre
								cumul�e avec une
								r�mun�ration
								vers�e par ce m�me
								organisme au cours
								de
								la p�riode
								concern�e.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								gratification est
								due sans pr�judice
								du
								remboursement des frais
								engag�s
								par
								le
								stagiaire pour
								effectuer son
								stage et des avantages
								offerts, le
								cas �ch�ant,
								pour la
								restauration, l'h�bergement, et
								le
								transport.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								L'organisme peut
								d�cider de
								verser une
								gratification pour les
								stages dont la dur�e
								est
								inf�rieure ou
								�gale � deux mois.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cas de suspension
								ou de r�siliation de la pr�sente
								convention, le
								montant de la
								gratification due au stagiaire
								est
								proratis� en
								fonction de
								la
								dur�e du stage effectu�.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								dur�e donnant droit
								� gratification s'appr�cie
								compte tenu de la
								pr�sente convention
								et de ses avenants
								�ventuels, ainsi que du
								nombre de jours de
								pr�sence effective du
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
										est fix� �
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
								W�hrend der Dauer des Praktikums erh�lt der
								Praktikant weiterhin die Leistungen seiner bestehenden
								Krankenversicherung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Im Ausland durchgef�hrte Praktika m�ssen vor der
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
								�bereinstimmung mit
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
								font-style="italic">Article 6 - R�gime de
								protection sociale
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Pendant la dur�e du stage, le stagiaire reste affili�
								� son
								r�gime de S�curit� sociale ant�rieur. Les stages effectu�s
								�
								l'�tranger sont signal�s pr�alablement au d�part du stagiaire
								�
								la S�curit� sociale lorsque celle-ci le demande.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Pour
								les stages �
								l'�tranger, les dispositions
								suivantes sont
								applicables sous
								r�serve de conformit� avec la
								l�gislation du
								pays
								d'accueil et de
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
								6-1 Verg�tung in H�he eines Mindestbetrags von 13,75
								% des Basisstundenlohns der Sozialversicherung:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Verg�tung ist nicht sozialversicherungspflichtig.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Der Praktikant profitiert von den gesetzlichen
								Leistungen der Studentenversicherung bei Arbeitsunf�llen gem��
								Artikel L.411-1 folgende des Sozialgesetzbuchs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								F�r den Fall, dass der Praktikant w�hrend seiner Arbeit in der
								Empfangseinrichtung, oder w�hrend der Fahrt, an einem durch die
								Anforderungen des Praktikums n�tzlich gewordenen Ort, oder f�r
								die Studenten der Medizin, der Zahnchirurgie oder Pharmazeutik
								ohne Krankenhausstatus w�hrend des Praktikums, das unter den
								Bedingungen des Abschnitts 2b des Artikels L.418-2 durchgef�hrt
								wird, einen Unfall erleidet,
								<fo:inline text-decoration="underline">schickt die
									Empfangseinrichtung die Erkl�rung an die kompetente
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
								la S�curit�
								sociale :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								gratification n'est pas soumise � cotisation
								sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								stagiaire b�n�ficie de la l�gislation sur les
								accidents de
								travail au titre du r�gime �tudiant de l'article
								L.412-8 2� du
								code de la S�curit� sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En cas d'accident survenant au stagiaire soit au cours
								d'activit�s dans l'organisme, soit au cours du trajet, soit sur
								les lieux rendus utiles pour les besoins du stage et pour les
								�tudiants en m�decine, en chirurgie dentaire ou en pharmacie qui
								n'ont pas un statut hospitalier pendant le stage effectu� dans
								les conditions pr�vues au b du 2e de l'article L.418-2,
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
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								font-weight="bold">
								6.2 -
								Verg�tung �ber 13,75 % des
								Basisstundenlohns der
								Sozialversicherung
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Sozialabgaben werden auf dem Unterschied zwischen
								dem Betrag der Verg�tung und 13,75 % des Basisstundenlohns der
								Sozialversicherung berechnet.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Der Student profitiert von
								den gesetzlichen
								Leistungen gem�� Artikel L.411-1 folgende des
								Sozialgesetzbuchs.
								F�r den Fall, dass der Praktikant w�hrend
								seiner Arbeit in der
								Empfangseinrichtung, oder w�hrend der Fahrt,
								oder an einem durch
								die Anforderungen des Praktikums n�tzlich
								gewordenen Ort einen
								Unfall erleidet, unternimmt die
								Empfangseinrichtung alle
								notwendigen Schritte bei der
								Krankenkasse und informiert die
								Hochschule so schnell wie
								m�glich.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic"
								font-weight="bold">
								6.2 -
								Gratification sup�rieure �
								13,75 % du plafond
								horaire de la
								S�curit� sociale :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Les
								cotisations sociales sont calcul�es sur le
								diff�rentiel entre le
								montant de la gratification et 13,75 % du
								plafond horaire de la
								S�curit� sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								L'�tudiant b�n�ficie de la couverture l�gale en
								application des
								dispositions des articles L.411-1 et suivants du
								code de la
								S�curit� sociale. En cas d'accident survenant au stagiaire soit
								au
								cours des activit�s dans l'organisme, soit au cours du trajet,
								soit sur des lieux rendus utiles pour les besoins de son stage,
								l'organisme d'accueil effectue toutes les d�marches n�cessaires
								aupr�s de la Caisse Primaire d'Assurance Maladie et informe
								l'�tablissement dans les meilleurs d�lais.
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
									franz�sischen studentischen Sozialversicherung:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="9.5pt"
								font-family="Times New Roman,serif" text-align="justify">
								- F�r Praktika
								innerhalb des Europ�ischen Wirtschaftsraums (EWR), die von
								Studenten aus einem EU-Staat oder aus Norwegen, Island,
								Liechtenstein oder der Schweiz durchgef�hrt werden, oder aus
								einem sonstigen Land (im letzten Fall ist diese Bestimmung nicht
								auf Praktika in D�nemark, Norwegen, Island, Liechtenstein oder
								die Schweiz anwendbar) m�ssen die Studenten eine europ�ische
								Krankenversicherungskarte (CEAM) beantragen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- F�r
								Praktika, die in Quebec von Studenten franz�sischer
								Staatsb�rgerschaft durchgef�hrt werden, muss das Formular SE401Q
								(104 f�r Unternehmenspraktika, 106 f�r Universit�tspraktika)
								beantragt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- in den
								anderen F�llen k�nnen sich Studenten, die im Ausland
								Gesundheitsausgaben haben, diese Betr�ge bei ihrer
								Zusatzkrankenkasse (Mutuelle), die als Studentenkrankenkasse
								funktioniert, nach Vorlage von Belegen bei ihrer R�ckkehr
								zur�ckerstatten lassen. Diese R�ckerstattung erfolgt auf der
								Grundlage der franz�sischen Behandlungskosten. Es k�nnen
								bedeutende Abweichungen zwischen den bezahlten Betr�gen und der
								franz�sischen Basiserstattung auftreten. Es ist sehr zu
								empfehlen, dass die Studenten eine spezifische
								Zusatzversicherung f�r das entsprechende Land und die Dauer des
								Praktikums bei einer von ihnen gew�hlten Kasse abschlie�en
								(Studentenkasse, Versicherung der Eltern, private
								Versicherungsgesellschaft...) oder, nach Pr�fung der angebotenen
								Garantien, bei der Empfangseinrichtung, wenn diese dem
								Praktikanten entsprechend der �rtlichen Bestimmungen (siehe 2
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
								Durch das Ankreuzen des entsprechenden K�stchens
								erkl�rt die Empfangseinrichtung untenstehend, ob sie nach
								lokalem Recht eine Krankenversicherung f�r den Praktikanten
								bereitstellt :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.1cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> JA
								</fo:inline>
								: dieser Schutz kommt zum Erhalt der Leistungen aus der
								franz�sischen Studentenversicherung im Ausland hinzu.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.1cm" padding-bottom="4pt">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> NEIN
								</fo:inline>
								: der Schutz beruht einzig auf dem Erhalt der Leistungen aus der
								franz�sischen Studentenversicherung im Ausland Wird kein
								K�stchen angekreuzt, kommt 6.3-1 zur Anwendung.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								6.3 - Protection
								maladie du
								stagiaire � l'�tranger
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								1)
								<fo:inline text-decoration="underline">Protection
									issue du r�gime
									�tudiant fran�ais
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								pour les stages
								au sein
								de l'Espace Economique Europ�en (EEE)
								effectu�s par des
								ressortissants d'un Etat de l'Union Europ�enne,
								ou de la
								Norv�ge, de l'Islande, du Liechtenstein ou de la Suisse,
								ou
								encore de tout autre Etat (dans ce dernier cas, cette
								disposition n'est pas applicable pour un stage au Danemark,
								Norv�ge, Islande, Liechtenstein ou Suisse), l'�tudiant doit
								demander la Carte Europ�enne d'Assurance Maladie (CEAM).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								pour les
								stages effectu�s
								au Qu�bec par les �tudiants de
								nationalit�
								fran�aise, l'�tudiant
								doit demander le formulaire
								SE401Q (104
								pour les stages en
								entreprises, 106 pour les stages
								en
								universit�s) ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								dans tous
								les autres cas
								les �tudiants qui engagent des frais de
								sant�
								peuvent �tre
								rembours�s aupr�s de la mutuelle qui leur tient
								lieu de Caisse de
								S�curit� Sociale �tudiante, au retour et sur
								pr�sentation des
								justificatifs : le remboursement s'effectue
								alors sur la base des
								tarifs de soins fran�ais. Des �carts
								importants peuvent exister
								entre les frais engag�s et les tarifs
								fran�ais, base du
								remboursement. Il est donc fortement conseill�
								aux �tudiants de
								souscrire une assurance maladie
								compl�mentaire
								sp�cifique, valable
								pour le pays et la dur�e du
								stage, aupr�s de
								l'organisme
								d'assurance de son choix (mutuelle
								�tudiante,
								mutuelle
								des
								parents, compagnie priv�e ad hoc...) ou,
								�ventuellement et
								apr�s
								v�rification de l'�tendue des garanties
								propos�es, aupr�s de
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
								cochant la case appropri�e, l'organisme d'accueil
								indique
								ci-apr�s s'il fournit une protection Maladie au
								stagiaire, en
								vertu du droit local :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								-
								<fo:inline font-weight="bold"> OUI
								</fo:inline>
								: cette protection s'ajoute au maintien, � l'�tranger, des
								droits
								issus du droit fran�ais.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								-
								<fo:inline font-weight="bold"> NON
								</fo:inline>
								: la protection d�coule alors exclusivement du maintien, �
								l'�tranger, des droits issus du r�gime fran�ais �tudiant.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify"
								background-color="#E6E6E6" font-style="italic">
								Si
								aucune case n'est
								coch�e, le 6.3-1 s'applique.
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
								<fo:inline text-decoration="underline">Um von der franz�sischen
									Gesetzgebung hinsichtlich der Leistungen bei Arbeitsunf�llen zu
									profitieren, muss das vorliegende Praktikum:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Eine maximale Dauer, Verl�ngerungen eingeschlossen,
								von 6 Monaten haben.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="1pt">
								- Zu keiner Verg�tung f�hren,
								die im entsprechenden Ausland das Recht auf einen
								Arbeitsunfallschutz er�ffnen k�nnte (eine Verg�tung von 13,75 %
								des Basisstundenlohns der Sozialversicherung (siehe Punkt 5) f�r
								eine gesetzliche Arbeitsdauer von 35 Wochenstunden wird
								vorbehaltlich dem Einverst�ndnis der Krankenkasse �ber den
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
								ausl�ndischen Empfangsland stattfinden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								Sind diese
								Bedingungen nicht erf�llt, verpflichtet sich die
								Empfangseinrichtung, den Praktikanten zu versichern und im Fall
								eines Arbeitsunfalls die notwendigen Erkl�rungen abzugeben.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">
									Die Unfallerkl�rung ist
									Sache der Hochschule, die innerhalb von 48 Stunden von der
									Empfangseinrichtung schriftlich informiert werden muss.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								3)
								<fo:inline text-decoration="underline">Die Versicherung betrifft
									Unf�lle an den folgenden Orten
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
								�blichen Hin- und
								R�ckweg zwischen dem Wohnort des Praktikanten
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
								w�hrend des Praktikums.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- Auf dem
								R�ckweg (Ende des Praktikums) zwischen dem Wohnort w�hrend des
								Praktikums und dem Wohnort des Praktikanten.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4)
								<fo:inline text-decoration="underline"> Ist auch nur eine der
									Bedingungen von Punkt 6.4 -1 nicht erf�llt,
								</fo:inline>
								verpflichtet sich die Empfangseinrichtung durch die vorliegende
								Vereinbarung, den Praktikanten gegen Arbeitsunf�lle, Reisen und
								Berufskrankheiten zu versichern und alle notwendigen Erkl�rungen
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
								Arbeitsunfalls eines Praktikanten w�hrend des Praktikums, diesen
								Unfall unbedingt sofort der Hochschule melden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="4pt">
								- Wenn der
								Student einzelne
								Missionen au�erhalb der Empfangseinrichtung oder
								des
								Praktikumslands ausf�hrt, muss die Empfangseinrichtung alle
								notwendigen Ma�nahmen ergreifen, um die entsprechenden
								Versicherungen bereitzustellen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								<fo:inline font-weight="bold">6.4 - Protection
									Accident du
									Travail du stagiaire � l'�tranger
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt"
								background-color="#E6E6E6" font-style="italic">
								1)
								<fo:inline text-decoration="underline">Pour pouvoir
									b�n�ficier de
									la l�gislation fran�aise
								</fo:inline>
								sur la
								couverture accident
								de travail, le pr�sent stage doit :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								�tre d'une
								dur�e au plus �gale � 6 mois,
								prolongations
								incluses ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- ne
								donner lieu � aucune
								r�mun�ration susceptible
								d'ouvrir des droits
								� une protection
								accident de travail dans le
								pays d'accueil ; une
								indemnit� ou
								gratification est admise dans
								la limite de 13,75% du
								plafond
								horaire de la s�curit� sociale
								(cf
								point 5), et sous
								r�serve de
								l'accord de la Caisse Primaire
								d'Assurance Maladie sur
								la demande
								de maintien de droit ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- se
								d�rouler exclusivement
								dans l'organisme
								signataire de la pr�sente
								convention ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- se
								d�rouler exclusivement
								dans le pays d'accueil
								�tranger cit�.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Lorsque ces
								conditions ne
								sont pas remplies, l'organisme d'accueil
								s'engage �
								cotiser pour
								la protection du stagiaire et � faire
								les
								d�clarations n�cessaires
								en cas d'accident de travail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" background-color="#E6E6E6"
								font-style="italic">
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
								r�sidence du stagiaire sur
								le
								territoire �tranger et le lieu du
								stage,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								dans le
								cadre d'une
								mission confi�e par l'organisme
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
								sa r�sidence
								durant le stage (d�placement � la date du
								d�but du
								stage),
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								-
								lors du
								dernier trajet de
								retour depuis sa r�sidence durant le
								stage �
								son domicile
								personnel.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" padding-top="2pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
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
								l'�tudiant est victime d'un accident de
								travail
								durant
								le stage,
								l'organisme d'accueil doit
								imp�rativement
								signaler
								imm�diatement
								cet accident �
								l'�tablissement
								d'enseignement ;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								- si
								l'�tudiant remplit des
								missions limit�es
								en dehors
								de l'organisme
								d'accueil ou en dehors
								du pays du
								stage,
								l'organisme d'accueil doit
								prendre toutes les
								dispositions
								n�cessaires pour lui fournir les
								assurances
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
								Artikel 7 - Haftpflicht und
								Versicherungen
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Empfangseinrichtung und der Praktikant erkl�ren,
								�ber eine Haftpflichtversicherung zu verf�gen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Bei allen Praktika im
								Ausland oder in �bersee
								verpflichtet sich der Praktikant zum
								Abschluss eines
								Auslandsschutzes (gesundheitsbedingter
								R�cktransport,
								Rechtshilfe...) sowie einer individuellen
								Unfallversicherung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 7 - Responsabilit� et
								assurance
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								L'organisme
								d'accueil et le stagiaire d�clarent
								�tre
								garantis au
								titre
								de la responsabilit� civile.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Pour
								les stages � l'�tranger ou outre-mer, le
								stagiaire s'engage �
								souscrire un contrat d'assistance
								(rapatriement sanitaire,
								assistance juridique...) et un contrat
								d'assurance individuel
								accident.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Lorsque l'organisme d'accueil met un v�hicule � la
								disposition du
								stagiaire, il lui incombe de v�rifier
								pr�alablement que la police
								d'assurance du v�hicule couvre son
								utilisation par un �tudiant.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Lorsque dans le cadre de son stage, l'�tudiant
								utilise son propre
								v�hicule ou un v�hicule pr�t� par un tiers,
								il d�clare
								express�ment � l'assureur dudit v�hicule et, le cas
								�ch�ant,
								s'acquitte de la prime y aff�rente.
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
								Ma�nahmen zu ergreifen. In diesen F�llen informiert die
								Empfangseinrichtung den Referenten �ber die Vergehen und
								�bermittelt die eventuell vorhandenen Elemente.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Im Fall besonders schwerer
								Verst��e gegen die
								Disziplin beh�lt sich die Empfangseinrichtung
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
								est soumis � la discipline et aux
								clauses
								du r�glement
								int�rieur qui lui sont applicables et qui
								sont
								port�es � sa
								connaissance avant le d�but du stage, notamment
								en ce
								qui
								concerne
								les horaires et les r�gles d'hygi�ne et de
								s�curit�
								en
								vigueur dans
								l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Toute sanction disciplinaire ne peut �tre d�cid�e que
								par
								l'�tablissement d'enseignement. Dans ce cas, l'organisme
								d'accueil informe
								l'enseignant r�f�rent et l'�tablissement des
								manquements et
								fournit �ventuellement les �l�ments constitutifs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cas de manquement particuli�rement grave � la
								discipline,
								l'organisme d'accueil se r�serve le droit de mettre
								fin au stage
								tout en respectant les dispositions fix�es �
								l'article 9 de la
								pr�sente convention.
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
								der Praktikant (au�er im Fall von Sonderregelungen in einigen
								franz�sischen �bersee-Gebietsk�rperschaften) im Fall einer
								Schwangerschaft, Vaterschaft oder Adoption ein Anrecht auf
								Urlaub und Abwesenheitsgenehmigungen mit der gleichen Dauer wie
								die Angestellten gem�� der Artikel L.1225-16 � L.1225-28,
								L.1225-35, L.1225-37, L.1225-46 des Arbeitsgesetzbuchs.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Bei Praktika mit
								einer Dauer von mehr als 2 Monaten und im Rahmen der maximal
								autorisierten Dauer von 6 Monaten, sind Urlaub oder
								Abwesenheitsgenehmigungen m�glich.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline text-decoration="underline">
									ANZAHL DER AUTORISIERTEN
									URLAUBSTAGE
								</fo:inline>
								/ oder Modalit�ten f�r Urlaub und Abwesenheitsgenehmigungen
								w�hrend des Praktikums:
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
								werden. Gegebenenfalls f�hrt die Einrichtung
								Validierungsmodalit�ten ein. Bei Einverst�ndnis aller Parteien
								kann eine Verschiebung des Praktikums erwogen werden, um die
								gesamte urspr�nglich vorgesehene Praktikumsdauer zu erreichen.
								Diese Verschiebung wird Gegenstand eines Nachtrags zu dieser
								Vereinbarung.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Im Fall der Verl�ngerung des Praktikums auf
								gemeinsamen Antrag der
								Empfangseinrichtung und des Praktikanten
								und unter Beachtung der
								gesetzlich vorgesehenen H�chstdauer von 6
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
								sofort schriftlich davon in Kenntnis setzen. Die daf�r
								angegebenen Gr�nde werden in enger Absprache untersucht. Die
								definitive Entscheidung eines Abbruchs des Praktikums erfolgt
								erst nach dieser Abstimmungsphase.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 9 - Cong�s -
								Interruption du stage
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								France (sauf
								en cas de r�gles particuli�res applicables dans
								certaines
								collectivit�s d'outre-mer fran�aises ou dans les
								organismes de
								droit public), en cas de grossesse,
								de paternit� ou
								d'adoption,
								le
								stagiaire b�n�ficie de cong�s
								et
								d'autorisations
								d'absence d'une
								dur�e �quivalente � celle
								pr�vues
								pour les salari�s
								aux
								articles
								L.1225-16 � L.1225-28,
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
								dur�e est sup�rieure � deux
								mois et dans la limite de la
								dur�e
								maximale de 6 mois, des
								cong�s ou autorisations d'absence
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
								/ ou modalit�s des cong�s et autorisations d'absence durant le
								stage : ...
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								Pour toute autre
								interruption temporaire du stage (maladie, absence
								injustifi�e...)
								l'organisme d'accueil avertit l'�tablissement
								d'enseignement par
								courrier.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								background-color="#E6E6E6" font-style="italic">
								Toute interruption du
								stage, est signal�e aux autres
								parties � la convention et �
								l'enseignant r�f�rent. Une modalit�
								de validation est mise en
								place le cas �ch�ant par
								l'�tablissement. En cas d'accord des
								parties � la convention, un
								report de la fin du stage est
								possible afin de permettre la
								r�alisation de la dur�e totale du
								stage pr�vue initialement. Ce
								report fera l'objet d'un avenant �
								la convention de stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Un
								avenant � la
								convention pourra �tre
								�tabli en cas de
								prolongation
								du stage sur demande conjointe de
								l'organisme
								d'accueil et du
								stagiaire, dans le respect de
								la dur�e
								maximale du
								stage fix�e par
								la loi (6 mois).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								En
								cas de volont� d'une des trois parties (organisme
								d'accueil,
								stagiaire, �tablissement d'enseignement) d'arr�ter le
								stage,
								celle-ci doit imm�diatement en informer les deux autres
								parties
								par �crit. Les raisons invoqu�es seront examin�es en
								�troite
								concertation. La d�cision d�finitive d'arr�t du stage ne
								sera
								prise qu'� l'issue de cette phase de concertation.
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
								von der Empfangseinrichtung entsprechend ihrer Spezifizit�ten
								definiert. Die Praktikanten verpflichten sich damit, die
								Informationen, die sie w�hrend des Praktikums gesammelt oder
								erhalten haben, nicht ohne das Einverst�ndnis der
								Empfangseinrichtung zu ver�ffentlichen oder sie an Dritte
								weiterzugeben, inklusive des Praktikumsberichts. Diese
								Verpflichtung gilt nicht nur f�r die Dauer des Praktikums
								sondern auch nach dessen Ende. Der Praktikant verpflichtet sich,
								ohne die Genehmigung der Empfangseinrichtung keinerlei der
								Einrichtung geh�rende Dokumente oder Software welcher Art auch
								immer zu behalten, mitzunehmen oder zu kopieren.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								Im Rahmen der Vertraulichkeit der im
								Praktikumsbericht enthaltenen Informationen kann die
								Empfangseinrichtung fordern, dass dieser nur eingeschr�nkt
								ver�ffentlicht oder dass einige sehr vertrauliche Elemente
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
								Article 10 - Devoir de r�serve
								et confidentialit�
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								devoir de
								r�serve est de rigueur absolue et
								appr�ci�
								par
								l'organisme
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
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Dans
								le cadre de la confidentialit� des informations
								contenues dans le
								rapport de stage, l'organisme d'accueil peut
								demander une
								restriction de la diffusion du rapport, voire le
								retrait de
								certains �l�ments confidentiels.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Les
								personnes amen�es � en conna�tre sont contraintes
								par le secret
								professionnel � n'utiliser ni ne divulguer les
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
								Entsprechend dem Gesetz �ber das geistige Eigentum
								muss, sollte die Arbeit des Praktikanten zu einem vom
								Urheberrecht oder dem Recht auf industrielles Eigentum
								gesch�tzten Werk f�hren (inklusive einer Software) und sollte
								die Empfangseinrichtung dieses nutzen wollen, und der Praktikant
								damit einverstanden sein, ein Vertrag zwischen dem Praktikanten
								(Autor) und der Empfangseinrichtung geschlossen werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								Der Vertrag muss
								insbesondere den Rahmen der abgetretenen Rechte, eine eventuelle
								Exklusivit�t, die Bestimmung, die genutzten Tr�ger und die Dauer
								der Abtretung sowie gegebenenfalls den Betrag der Verg�tung
								desPraktikanten f�r die Abtretung beinhalten. Diese Klausel ist
								immer g�ltig und nicht an den Status der Empfangseinrichtung
								gebunden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								Article 11 - Propri�t� intellectuelle
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Conform�ment au code de la propri�t� intellectuelle,
								dans le cas
								o� les activit�s du stagiaire donnent lieu �
								la
								cr�ation d'une
								&#339;uvre prot�g�e par le droit d'auteur ou la
								propri�t�
								industrielle (y compris un logiciel), si l'organisme
								d'accueil
								souhaite l'utiliser et que le stagiaire en est
								d'accord, un
								contrat devra �tre sign� entre le stagiaire
								(auteur) et
								l'organisme d'accueil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Le
								contrat devra alors notamment pr�ciser l'�tendue
								des droits
								c�d�s, l'�ventuelle exclusivit�, la destination, les
								supports
								utilis�s et la dur�e de la cession, ainsi que, le cas
								�ch�ant, le
								montant de la r�mun�ration due au stagiaire au
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
								Anschlie�end an das Praktikum stellt die Empfangseinrichtung dem
								Praktikanten eine Praktikumsbescheinigung aus, in der mindestens
								die effektive Dauer des Praktikums und gegebenenfalls die H�he
								der erhaltenen Verg�tung angegeben sind. Der Praktikant muss
								diese Bescheinigung bei einer eventuellen �ffnung der Rechte f�r
								die gesetzliche Rentenversicherung gem�� Art. L.351-17 des
								Sozialgesetzbuchs vorlegen;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								2)
								<fo:inline text-decoration="underline">Qualit�t des Praktikums
								</fo:inline>
								: Nach Abschluss des Praktikums sind die Parteien der
								vorliegenden Vereinbarung eingeladen, eine Bewertung zur
								Qualit�t des Praktikums abzugeben.
								Der Praktikant �bermittelt der
								kompetenten Stelle an der Hochschule
								ein Dokument, in dem er die
								Qualit�t des Empfangs durch die
								Empfangseinrichtung bewertet.
								Dieses Dokument wird in seiner
								Bewertung oder beim Erreichen des
								Diploms oder der Bescheinigung
								nicht ber�cksichtigt.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline">Einsch�tzung der T�tigkeit
									des Praktikanten
								</fo:inline>
								: Nach Abschluss des Praktikums wird von der Empfangseinrichtung
								ein Bewertungsblatt �ber die T�tigkeit des Praktikanten
								ausgef�llt und an den Lehrer-Referenten weitergeleitet (oder
								pr�zisieren, ob es eine Anlage oder Bewertungsmodalit�ten gibt,
								die vorab gemeinsam mit dem Lehrer-Referenten definiert wurden).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								4)
								<fo:inline text-decoration="underline">Modalit�ten der
									p�dagogischen Bewertung
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
								Empfangseinrichtung, das w�hrend der Vorbereitung, des Ablaufs
								und der Anerkennung des Praktikums die Hochschule besucht hat,
								kann seitens der Hochschule die �bernahme von Kosten oder eine
								Entsch�digung fordern.
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
								: � l'issue du stage, l'organisme d'accueil d�livre une
								attestation dont le mod�le figure en annexe, mentionnant au
								minimum la dur�e effective du stage et, le cas �ch�ant, le
								montant de la gratification per�ue. Le stagiaire devra
								produire
								cette attestation � l'appui de sa demande �ventuelle
								d'ouverture
								de droits au r�gime g�n�ral d'assurance vieillesse
								pr�vue �
								l'art. L.351-17 du code de la s�curit� sociale.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
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
								dans son
								�valuation ou dans
								l'obtention du dipl�me ou de la
								certification.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								3)
								<fo:inline text-decoration="underline">�valuation de l'activit�
									du
									stagiaire
								</fo:inline>
								: � l'issue du stage, l'organisme d'accueil renseigne une fiche
								d'�valuation de l'activit� du stagiaire qu'il retourne �
								l'enseignant r�f�rent (ou pr�ciser si fiche
								annexe ou modalit�s
								d'�valuation pr�alablement d�finis en
								accord avec l'enseignant
								r�f�rent).
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
								<fo:inline text-decoration="underline">Modalit�s d'�valuation
									p�dagogiques
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
									�ch�ant)
								</fo:inline>
								: ...
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								5) Le
								tuteur de l'organisme
								d'accueil ou tout membre de l'organisme
								d'accueil appel� � se
								rendre dans l'�tablissement d'enseignement
								dans le cadre de la
								pr�paration, du d�roulement et de la
								validation du stage ne peut
								pr�tendre � une quelconque prise en
								charge ou indemnisation de
								la part de l'�tablissement
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
								ausschlie�lich franz�sischem Recht.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Jeder Streitfall, der nicht g�tlich beigelegt werden
								kann, wird der zust�ndigen franz�sischen Gerichtsbarkeit
								vorgelegt.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								Article 13 -
								Droit applicable - Tribunaux comp�tents
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								La
								pr�sente convention
								est r�gie exclusivement par le
								droit fran�ais.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Tout
								litige non r�solu
								par voie amiable sera soumis �
								la comp�tence de
								la juridiction
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
								F�R DIE
								HOCHSCHULEINRICHTUNG
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="6.5pt" font-family="Times New Roman,serif"
								font-style="italic">
								(POUR L'�TABLISSEMENT D'ENSEIGNEMENT)
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
										(Nom et signature du repr�sentant de
										l'�tablissement)
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
								F�R DIE
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
										(Nom et signature du repr�sentant de l'organisme
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
								(L'ENSEIGNANT R�F�RENT DU STAGIAIRE)
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
				auszuh�ndigen
			</fo:block>
			<fo:block text-align="center" line-height="110%"
				padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
				font-size="10pt" font-family="Times New Roman,serif" font-style="italic">
				(�
				remettre au stagiaire � l'issue du stage)
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
										d�nomination sociale)
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
										(Pr�nom)
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
										(N� le)
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
										EN(intitul� de la formation ou du cursus de
										l'enseignement
										sup�rieur suivi par le ou la stagiaire )) :
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
										l'�tablissement d'enseignement sup�rieur ou
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
						effectu� un
						stage pr�vu dans le cadre de ses �tudes)
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
										d�but et de fin
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
										F�r eine Gesamtdauer von
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
									(Repr�sentant une dur�e
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
									Gesamtdauer des Praktikums ber�cksichtigt die effektive
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
									dur�e totale du stage
									est appr�ci�e en tenant compte de la
									pr�sence effective du
									stagiaire dans l'organisme, sous r�serve
									des droits � cong�s et
									autorisations d'absence pr�vus �
									l'article L.124-13 du code de
									l'�ducation (art. L.124-18 du code
									de l'�ducation). Chaque
									p�riode au moins �gale � 7 heures de
									pr�sence cons�cutives ou
									non est consid�r�e comme �quivalente �
									un jour de stage et
									chaque p�riode au moins �gale � 22 jours de
									pr�sence
									cons�cutifs
									ou non est consid�r�e comme �quivalente �
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
										H�HE
										DER VERG�TUNG, DIE DEM PRAKTIKANTEN GEZAHLT WURDE
									</fo:inline>
									<fo:inline font-size="6.5pt" font-style="italic">
										(MONTANT DE
										LA GRATIFICATION
										VERS�E AU STAGIAIRE)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="9pt" font-family="Times New Roman,serif"
									padding-top="0.2cm">
									Der Praktikant hat eine Praktikumsverg�tung in H�he
									eines Gesamtbetrags von ..................................
									&#8364; </fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="6.5pt" font-family="Times New Roman,serif"
									padding-top="0.1cm" font-style="italic">
									(Le stagiaire a per�u une
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
									Beitrags, das Praktikum f�r die Rentenrechte ber�cksichtigen zu
									k�nnen. Die Rentengesetze (Gesetz Nr. 2014-40 vom 20. Januar
									2014) er�ffnet den Studenten,
									<fo:inline font-weight="bold">die eine Verg�tung f�r ihr
										Praktikum erhalten haben,
									</fo:inline>
									die M�glichkeit, dieses innerhalb eines Limits
									<fo:inline font-weight="bold">vor zwei Trimestern,
									</fo:inline>
									anrechnen zu lassen, wenn sie daf�r
									<fo:inline font-weight="bold">ihren Beitrag eingezahlt
										haben.
									</fo:inline>
									Der
									<fo:inline font-weight="bold">Antrag daf�r muss von
										Studenten in den zwei Jahren
									</fo:inline>
									nach dem Ende des Praktikums und mit
									<fo:inline font-weight="bold">obligatorischer Vorlage der
										Praktikumsbescheinigung
									</fo:inline>
									gestellt werden, auf der die Gesamtdauer des Praktikums und die
									erhaltene Verg�tung vermerkt sind. Genaue Ausk�nfte zur
									Beitragszahlung und den Formalit�ten gibt die
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
									r�serve du versement d'une
									cotisation, faire
									prendre en compte
									le stage dans les droits �
									retraite. La
									l�gislation sur les
									retraites (loi n�2014-40 du 20
									Janvier 2014)
									ouvre aux �tudiants
									dont le stage a �t� gratifi�, la possibilit�
									de faire valider
									celui-ci dans la limite de deux trimestres,
									sous r�serve du
									versement d'une cotisation. La demande est �
									faire par
									l'�tudiant dans les deux ann�es
									suivant la fin du stage
									et sur
									pr�sentation obligatoire de l'attestation de stage
									mentionnant
									la dur�e totale du stage et le montant total de la
									gratification per�ue. Les informations
									pr�cises sur la
									cotisation � verser et sur la proc�dure � suivre
									sont � demander
									aupr�s de la S�curit� sociale (code de la s�curit� sociale art.
									L.351-17 - code de
									l'�ducation art.D.124-9).
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
									(Fait �)
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
									du repr�sentant de
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