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
<!-- 		<fo:block break-after="page" /> -->
<!-- 		<fo:block> -->
<!-- 			<xsl:call-template name="Attestation" /> -->
<!-- 		</fo:block> -->
<!-- 		<fo:block break-after="page" /> -->
<!-- 		<fo:block> -->
<!-- 			<xsl:call-template name="FicheStageEtranger" /> -->
<!-- 		</fo:block> -->
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
			Forms to
			be attached to this agreement:
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
				1) Internship certificate
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(following page)
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
				2) Foreign internship form
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(for
				information
				regarding social security, see the website cleiss.fr;
				for
				country-specific documentation see the website
				diplomatie.gouv.fr)
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
				3) Other appendices
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(if any)
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
						<fo:block line-height="110%" padding-top="10pt"
							hyphenate="false" language="fr" country="FR" font-size="14pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">
								Internship agreement
								<xsl:text> </xsl:text>
								n�
								<xsl:value-of select="id-convention" />
								between
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
			NB : for the sake of simplicity,
			the persons referred to in
			this document are designated "he".
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
						padding-left="0.1cm" padding-right="0.4cm" padding-top="0.2cm"
						padding-bottom="0.2cm">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0cm"
							padding-bottom="0.035cm" text-align="center">
							<fo:inline font-weight="bold">
								1 -
								<fo:inline text-decoration="underline">THE EDUCATIONAL or TRAINING
									INSTITUTION
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
								Address
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
										Phone :
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
								Represented by
								(agreement-signing party)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Repr�sent�
								par (signataire de la convention))
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
							<fo:inline>
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
													language="fr" country="FR" font-size="9pt"
													font-family="Times New Roman,serif" padding-left="0.141cm"
													padding-right="0.141cm" padding-top="0.035cm"
													padding-bottom="0.035cm">
													<fo:inline font-weight="bold">
														Capacity of the
														representative
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
													language="fr" country="FR" font-size="9pt"
													font-family="Times New Roman,serif" padding-left="0.141cm"
													padding-right="0.141cm" padding-top="0.035cm"
													padding-bottom="0.035cm">
													<fo:inline font-weight="bold">
														Capacity of the
														representative
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
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Department/UFR
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
								Address (if different from that
								of the institution)
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
								Phone :
							</fo:inline>
							<xsl:value-of select="centre-gestion/telephone" />
							&#160;
							<fo:inline font-weight="bold">
								email :
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
									HOST ORGANIZATION
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
								Address
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
								Represented by
								(agreement-signing party)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Repr�sent�
								par (signataire de la convention))
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<fo:inline>
								<xsl:value-of select="signataire/civilite/libelle" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="translate(signataire/nom,$lowers,$uppers)" />
								<xsl:text> </xsl:text>

								<xsl:call-template name="start_upper">
									<xsl:with-param name="prenom">
										<xsl:value-of select="signataire/prenom" />
									</xsl:with-param>
								</xsl:call-template>
							</fo:inline>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Capacity of the representative
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Qualit� du
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
								Department in which the
								internship will be conducted
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
								Phone :
							</fo:inline>
							<xsl:value-of select="structure/telephone" />
							&#160;
							<fo:inline font-weight="bold">
								email :
							</fo:inline>
							<xsl:value-of select="structure/mail" />
						</fo:block>
						<xsl:if test="service/voie != structure/voie">
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Location of internship (if
									different from that of the
									organization)
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
							country="FR" font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0cm" padding-bottom="0.035cm"
							text-align="center">
							<fo:inline font-weight="bold">
								3 -
								<fo:inline text-decoration="underline" font-size="9pt">THE
									INTERN
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
								Last Name
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline font-weight="bold"> :
							</fo:inline>
							<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								First name
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
								Sex :
							</fo:inline>
							<xsl:value-of select="etudiant/code-sexe" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Date of Birth
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
								Student ID
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
								Address
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
								Phone :
							</fo:inline>
							<xsl:value-of select="tel-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Portable :
							</fo:inline>
							<xsl:value-of select="tel-portable-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								email :
							</fo:inline>
							<xsl:value-of select="etudiant/mail" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="8pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm" text-align="justify" font-weight="bold">
							TITLE
							OF INTERNSHIP OR TRAINING COURSE TAKEN AT THE INSTITUTION OF
							HIGHER EDUCATION, AND HOUR VOLUME (ANNUAL OR HALF-YEARLY) :
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
								Hour volume of internship
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
		<fo:block line-height="200%" hyphenate="false" language="fr"
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
							<fo:inline font-weight="bold" text-decoration="underline"
								font-size="9pt">
								SUBJECT OF INTERNSHIP
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
								Confidential
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
							<fo:inline font-weight="bold">
								From
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Du)
							</fo:inline>

							<xsl:text> </xsl:text>
							<xsl:value-of
								select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								To
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Au)
							</fo:inline>
							<xsl:text> </xsl:text>
							<xsl:value-of
								select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />

							<xsl:if test="@interruption-stage = 'true'">
								<xsl:text> </xsl:text>
								<fo:inline font-weight="bold" font-size="11pt">
									with
									interruption from
								</fo:inline>
								<fo:inline font-style="italic" font-size="8pt">(avec
									interruption du)
								</fo:inline>
								<xsl:value-of
									select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
								<fo:inline font-weight="bold" font-size="11pt">
									to
								</fo:inline>
								<fo:inline font-style="italic" font-size="8pt">(au)
								</fo:inline>
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
												Representing a total
												duration of :
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> </xsl:text>
											<xsl:if test="id-unite-duree-exceptionnelle = '1'">
												hour(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '2'">
												day(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '3'">
												week(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '4'">
												month(s)
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '5'">
												year(s)
											</xsl:if>
										</fo:block>
									</xsl:when>
									<xsl:otherwise>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												Corresponding to
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> hours </xsl:text>
											<fo:inline font-weight="bold">
												of attendance at the host
												organization
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
												and corresponding to
											</fo:inline>
											<fo:inline font-style="italic" font-size="8pt">(et
												correspondant �)
											</fo:inline>
											<xsl:variable name="nbHeures" select="duree-exceptionnelle" />
											<xsl:variable name="nbJours" select="floor($nbHeures div 7)" />
											<xsl:variable name="nbHeuresRestantes" select="$nbHeures mod 7" />
											<xsl:variable name="nbMois" select="floor($nbJours div 22)" />
											<xsl:variable name="nbJoursRestants" select="$nbJours mod 22" />

											<xsl:value-of select="$nbMois" />
											<xsl:text> month(s) </xsl:text>
											<xsl:value-of select="$nbJoursRestants" />
											<xsl:text> day(s) and </xsl:text>
											<xsl:value-of select="$nbHeuresRestantes" />
											<xsl:text> hour(s) </xsl:text>
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
										Representing a total duration
										of :
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									weeks
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
											Distribution, in case of
											discontinuous attendance
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
											hours per week.
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
								Comments
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
							SUPERVISION OF INTERN BY THE EDUCATIONAL
							INSTITUTION
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
								First and Last name of academic
								advisor
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
								Position (or discipline)
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
								Phone :
							</fo:inline>
							<xsl:value-of select="enseignant/tel" />
							&#160;
							<fo:inline font-weight="bold">
								email :
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
							SUPERVISION OF INTERN BY THE HOST ORGANIZATION
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
								Full name of training supervisor
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
								Position
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
								Phone :
							</fo:inline>
							<xsl:value-of select="contact/tel" />
							&#160;
							<fo:inline font-weight="bold">
								email :
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
							Primary health insurance
							agency to contact
							in case of accident (corresponds to intern's
							place of residence, unless otherwise specified)
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="8pt" font-family="Times New Roman,serif"
							font-style="italic">
							(Caisse Primaire
							d'Assurance Maladie � contacter en cas
							d'accident (lieu de
							domicile de l'�tudiant sauf exception)) :
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
			padding-top="20pt" text-align="center">
			Date of printing :
			<xsl:value-of
				select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())" />
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="7pt" font-family="Times New Roman,serif"
			text-align="center" font-style="italic">
			(Date d'impression : ...)
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
								font-weight="bold">Article 1 - Purpose of the Agreement
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								This Agreement governs the host organization's
								relationship with
								the educational institution
								and the intern.
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
								Article 2 - Objective of the internship
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The internship is a temporary period of work
								in a professional
								environment, where the studen
								t will acquire
								professional skills
								and put into
								practice the knowledge gained from his education
								in
								view of earning a
								diploma or certificate, and
								facilitating his
								professional integration. The
								intern will be given one or more
								tasks, in
								conformance with the educational plan established
								by the
								educational institution and approved by
								the host organization.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The educational institution and the host organization
								will establish the schedule based on the general
								training program
								being offered
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">ACTIVITIES ASSIGNED
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
								<fo:inline text-decoration="underline"> SKILLS TO BE ACQUIRED OR
									DEVELOPED
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
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>

							<fo:block line-height="110%" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 3 - Terms of internship
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The weekly duration of the intern's presence
								at the host
								organization will be
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								hours, on a
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when
											test="temps-travail/code-ctrl='TCOMP' or temps-travail/code-ctrl='TPART'">
											<xsl:if test="temps-travail/code-ctrl='TCOMP'">
												Full time basis.
											</xsl:if>
											<xsl:if test="temps-travail/code-ctrl='TPART'">
												Part-time basis.
											</xsl:if>
										</xsl:when>
										<xsl:otherwise>
											<xsl:value-of select="temps-travail/libelle" />
											<xsl:text>.</xsl:text>
										</xsl:otherwise>
									</xsl:choose>
								</fo:inline>
								.
								<!-- (quotit� : -->
								<!-- <fo:inline font-weight="bold"> -->
								<!-- <xsl:value-of select="quotite-travail" /> -->
								<!-- %). -->
								<!-- </fo:inline> -->
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="4pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								If the intern's presence at the host
								organization is to be
								required at night,
								or on Sunday or during a public holiday,
								specify the specific cases :
								<fo:inline font-weight="bold">
									<xsl:value-of select="travail-nuit-ferie" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify"
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
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Article 4 - Intern hosting and supervision
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The intern will be supervised
								by his academic advisor, as
								designated in this agreement,
								as well as by the institution's
								internship program office.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The internship supervisor appointed by the host organization
								in
								this Agreement shall be responsible for supervising the intern
								and ensuring optimal conditions for the execution of the
								internship
								in accordance with the specified educational
								requirements.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The intern shall be permitted to return to his educational
								institution during
								the internship period in order to take the
								courses specifically required by the
								program, or to attend
								meetings; the institution shall notify the host
								organization
								of
								the corresponding dates.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Article 4 continued)
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt">
								The host
								organization may permit the intern to travel.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Any difficulties encountered in the execution and progress of
								the internship,
								whether observed by the intern or by the
								internship supervisor, must be
								brought to
								the attention of the
								academic advisor and the educational
								institution so that the
								issue can be resolved as quickly as possible
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="4pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									SUPERVISORY PROCEDURES
								</fo:inline>
								(visits, scheduled telephone calls, etc.) :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-encadre-suivi" />
								</fo:inline>
							</fo:block>
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
								keep-with-next="always" text-align="justify" font-weight="bold">Article
								5 - Stipend - Benefits
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								In France, whenever an internship is to have a duration greater
								than
								two months, whether they run consecutively or not, a stipend
								must
								be paid,
								except as provided under special regulations
								applicable
								for certain French
								overseas collectivities or for
								internships covered by article L4381-1 of
								the Public Health Code.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								The amount of the
								hourly stipend shall be 15%
								of the hourly ceiling for social
								security established
								pursuant to
								article L.241-3 of the Social
								Security Code.
								A sector-specific convention or labor agreement
								may set
								an amount
								greater than that rate.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Stipends payable by an
								organization under public law may
								not be combined with any
								remuneration to be paid by the
								same organization during the
								relevant period.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Stipends are payable
								without prejudice to any
								reimbursement of expenses incurred by
								the intern
								for purposes of his
								internship, or any benefits
								offered
								for meals, accommodations and transportation.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The organization may decide to pay a stipend
								for internships with
								a duration of two months
								or less.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								In case of a
								suspension or termination of this
								agreement, the amount of the
								stipend due to the
								intern shall be prorated based on the duration
								of the internship conducted.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Internship durations
								qualifying for the payment of a
								stipend are determined in
								consideration of this
								agreement and any
								amendments thereto, as
								well as
								the number of days of the intern's
								physical
								presence within
								the organization.
							</fo:block>
							<xsl:variable name="indemnisation" select="id-indemnisation" />
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>

								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">THE AMOUNT OF THE STIPEND
										</fo:inline>
										is set at
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
												per
												<xsl:text> </xsl:text>
												<xsl:value-of select="unite-duree-gratification/libelle" />
												.
											</xsl:otherwise>
										</xsl:choose>
									</fo:block>
									<xsl:if
										test="mode-vers-gratification/libelle and mode-vers-gratification/libelle != ''">
										<fo:block line-height="110%" hyphenate="false"
											language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
											<fo:inline text-decoration="underline">
												Method of payment
											</fo:inline>
											:
											<xsl:value-of select="mode-vers-gratification/libelle" />
										</fo:block>
									</xsl:if>
								</xsl:otherwise>
							</xsl:choose>
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">
									OTHER BENEFITS GRANTED
								</fo:inline>
								:
								<fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
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
								est fix� � 15%
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
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">Article 6 - Social Welfare
								Coverage Framework
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								For the duration of his internship, the intern shall
								remain covered
								under his previous former social welfare
								protection framework.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Internships conducted abroad shall be reported to the
								Social Security
								administration when required, prior to the
								intern's departure.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								For internships conducted
								abroad, the following
								provisions shall
								apply, subject to their
								conformance with the
								legislation in effect
								in the host country and
								the laws governing
								the host organization.
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
								text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.1
									Maximum
									stipend of 15% of the hourly ceiling for social security:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The stipend is not subject to payroll tax.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The intern shall have the benefit of the legislation
								on workplace
								accidents, under the students' framework set forth
								in article
								L.412-8 no. 2 of the Social Security code.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								If accidents impacting the intern occur, either during his
								activities
								within the organization, or during his commute, or on
								premises used for
								the purposes of the internship, and also for
								students of medicine,
								dental
								surgery, or pharmacy without
								hospital-staff status, engaged in an
								internship
								conducted under
								the conditions provided in item b of the 2nd section of
								Article
								L.412-8,
								<fo:inline text-decoration="underline">
									the host organization shall
									send a statement to the Primary
									Health Insurance Agency
								</fo:inline>
								or appropriate agency (see address on page 1), indicating the
								educational institution as the employer, and
								<fo:inline text-decoration="underline">
									shall send a copy to the
									educational institution as well.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								font-weight="bold" background-color="#E6E6E6" font-style="italic">
								6.1 -
								Gratification d'un
								montant maximum de 15%
								du plafond horaire
								de
								la
								S�curit�
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
								<fo:inline font-size="10pt" font-weight="bold">6.2
									Stipend
									greater than
								</fo:inline>
								15% of the hourly ceiling for social security:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Payroll taxes are calculated based on the difference
								between the amount of the stipend and 15% of the
								hourly
								ceiling
								for social security.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The student shall have the benefit of legal coverage
								under the provisions of L.411-1 et seq. of the social
								security
								code. If accidents impacting the intern occur,
								either during his
								activities within the organization,
								or during his commute, or on
								premises used for the
								purposes of the
								internship, the host
								organization shall handle the necessary
								formalities with the
								Primary Health Insurance
								Agency and shall
								inform the institution
								as soon as possible.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic"
								font-weight="bold">
								6.2 -
								Gratification sup�rieure �
								15 % du plafond
								horaire de la
								S�curit� sociale :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Les
								cotisations sociales sont calcul�es sur le
								diff�rentiel entre le
								montant de la gratification et 15 % du
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
								6.3 - Health Insurance for
								interns working abroad
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">
									Coverage originating in the
									French students' coverage framework
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- for internships
								within the European Economic Area (EEA) conducted
								by nationals of
								a State of the European Union or of Norway, Iceland,
								Liechtenstein or Switzerland, or of any another State (in the
								latter case this provision shall
								not apply for internships in
								Denmark,
								Norway, Iceland, Liechtenstein or Switzerland), students
								must apply for a European Health Insurance Card (EHIC).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- for
								internships conducted in Quebec by students of French
								nationality, students must request form SE401Q (104 for
								internships at companies, and 106 for university internships);
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- In all other
								cases, students who incur medical expenses may
								be reimbursed by
								the mutual insurance company serving as their
								student Social
								Security Agency, upon their return and upon
								presentation of
								receipts: reimbursement shall then be provided
								carried out on the
								basis of French healthcare rates. Significant
								differences may
								exist between the costs incurred and the French
								rates serving as
								the basis for reimbursement. It is strongly
								advised that students
								to take out specific additional health
								insurance coverage valid
								for the country in question and for
								the duration of their
								internships, the course, from the insurance
								company of their
								choice (students' mutual insurance, parents'
								mutual
								insurance, ad
								hoc private company, etc.), or, possibly,
								after checking
								the
								extent of the guarantees proposed, from the
								host organization
								if
								it provides health coverage to interns under local law
								(see item
								2 below).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2)
								<fo:inline text-decoration="underline">
									Social welfare protection
									from the host organization
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								By checking the appropriate box below, the host
								organization
								indicates whether it provides health insurance
								coverage to
								the intern under local law:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> YES
								</fo:inline>
								: This coverage is in addition to the maintenance
								abroad of
								rights granted under French law
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> NO
								</fo:inline>
								: coverage is thus exclusively provided from the
								maintenance
								abroad of the rights granted under
								the French student coverage
								framework).
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								If neither box is checked, item 6.3-1 shall apply.
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
								<fo:inline font-weight="bold">6.4 -
									Workplace Accident
									Coverage for interns abroad
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								1)
								<fo:inline text-decoration="underline">In order to benefit from
									French legislation
								</fo:inline>
								providing coverage for workplace accidents, this internship
								must:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- have a duration not exceeding six months, including
								any extensions;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- not include any remuneration
								that may tend to qualify for rights
								to workplace accident
								protection in the host country;
								compensations
								or stipends are
								acceptable, up to the limit of
								15% of the hourly
								ceiling for
								social security (see point 5),
								and subject to approval
								by the
								Primary Health Insurance Agency of
								a request for the
								maintenance
								of such rights;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- take place exclusively within
								the organization signing this agreement;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- take place exclusively in the
								abovementioned foreign host country.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								When these
								conditions are not met, the host organization
								undertakes to
								contribute to the intern's welfare protection
								and make the
								necessary declarations in case of workplace
								accidents.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">
									The workplace accident
									statement
								</fo:inline>
								is the responsibility of the educational
								institution, which must
								be informed of
								such events in writing within 48 hours
								by the host
								organization.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								3)
								<fo:inline text-decoration="underline">The coverage concerns
									accidents occurring:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- within
								the internship location and during internship working hours,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- on the
								normal commute to and from the intern's residence in
								the foreign
								nation and the internship location,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- as part
								of an assignment provided by the
								intern's host organization upon
								formal
								assignment mandate,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- during
								the first trip from his domicile
								to his place of residence during
								the
								internship (travel on the internship
								start date),
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- during
								the final return trip from his
								residence during the internship to
								his
								personal domicile.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4)
								<fo:inline text-decoration="underline"> In the event
									that one of
									the conditions set forth
									in section 6.4-1 /
								</fo:inline>
								is not satisfied, the host organization commits
								to cover the
								intern for the risks of workplace
								accidents, travel accidents,
								and occupational
								disease, and provide all the necessary
								statements of coverage.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">5) In all cases:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- if the student is the victim of a workplace
								accident
								during his internship, the host organization must
								immediately notify the educational institution of
								the accident;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="4pt">
								- if the
								student performs
								limited assignments outside
								of the host
								organization or outside
								of the internship
								country, the host
								organization must take all
								necessary steps to provide
								him with the
								appropriate insurance.
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
								la limite de 15% du
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
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								(article 6.4 suite)
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
								Article 7 - Liability and
								Insurance
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The host organization and the intern
								declare that they
								possess civil
								liability coverage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								For internships abroad or in overseas territories,
								the intern agrees to take out a travel assistance
								insurance
								contract (repatriation for health reasons,
								legal assistance,
								etc.) and an individual accident
								insurance policy.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								When the host organization makes a vehicle available
								to the intern, it is its responsibility to check
								beforehand that
								the car's insurance policy
								includes coverage for its use by a
								student.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" padding-bottom="4pt">
								When the student is to use
								his own vehicle or a
								vehicle
								loaned by a third party for purposes
								of his internship,
								he shall expressly inform the insurer of the
								vehicle
								and, where
								applicable, pay the corresponding premium.
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
								Article 8 - Discipline
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The intern shall be subject to the applicable
								internal disciplinary
								and regulatory terms, of which he shall be
								made aware prior to the
								start of the internship, particularly in
								regard to schedules and to
								the health and safety regulations in
								effect at the host
								organization.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Disciplinary sanctions may only be imposed by
								decision of
								the educational institution. In such case, the host
								organization shall inform the academic advisor and
								the
								institution of the
								non-compliance and shall
								provide any supporting
								evidence.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								In case of a particularly
								serious breach of
								discipline,
								the host organization reserves the
								right to terminate
								the internship, while respecting the
								provisions set
								forth in
								article 9 of this agreement.
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
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 9 - Leave - Internship Interruption
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In France (except
								as provided under special
								regulations
								applicable for certain
								French overseas
								collectivities
								or for organizations under public
								law),
								in case of pregnancy,
								paternity or
								adoption, the intern shall
								be granted time off and
								leaves of absence for a period
								equivalent
								to that granted to
								employees under
								articles L.1225-16
								to
								L.1225-28,
								L.1225-35,
								L.1225-37,
								and L.1225-46
								the labor code.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Time off or
								leaves of absence are
								possible for internships
								lasting more than 2
								months but
								less than 6 months.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline text-decoration="underline">
									NUMBER OF DAYS OF
									AUTHORIZED LEAVE
								</fo:inline>
								/ or terms of time off and leaves of absence during the
								internship :
							</fo:block>
							<xsl:choose>
								<xsl:when test="nb-conges and nb-conges != ''">
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<fo:inline font-weight="bold">
											<xsl:value-of select="nb-conges" />
										</fo:inline>
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										.......................................................................................................
									</fo:block>
								</xsl:otherwise>
							</xsl:choose>
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
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" font-weight="bold">
								(article 9
								continued)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								The host organization
								shall notify the educational
								institution of any other temporary
								interruption of the internship (illness,
								unjustified absence,
								etc.) by mail.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt">
								Notice of any interruption of the internship shall
								be provided to the other parties
								to the agreement and the
								academic advisor. A validation
								procedure
								shall be implemented by
								the educational institution as needed. A postponement
								of the
								internship end date is possible,
								if approved by the parties
								to the
								agreement, so as to
								permit the full duration of the
								internship
								as
								originally planned. This postponement will be the
								subject of an
								amendment to the
								internship agreement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								If a joint request is made by the host organization
								and the intern to extend
								the duration of the internship up to the
								maximum
								duration prescribed by law
								(6 months), an amendment may be
								made to
								the agreement.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="4pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								If any of the
								three parties (host organization,
								intern, educational
								institution)
								wish to put an end to the
								internship, such party
								must
								immediately inform the other
								two
								parties in writing. The reasons
								given will be
								examined in close
								consultation.
								The definitive
								decision to terminate the internship
								shall be made at
								the end of
								this consultation phase.
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
								Article 10 - Duty of discretion
								and confidentiality
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The duty of confidentiality must at all times be
								observed,
								with its specific aspects taken
								into account by the host
								organization. The intern commits
								to refrain
								from using the
								information
								collected or obtained by him, under any
								circumstances,
								for purposes of publication or
								disclosure to third
								parties without
								prior consent
								of the host organization,
								including
								in the internship report. This commitment
								applies not only to the
								internship period but shall extend after its conclusion
								as well.
								The intern commits
								to not retain, remove, or copy any
								documents or
								software
								of any kind belonging to the
								host organization, except
								upon prior approval
								from the latter.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								For purposes of preserving the confidentiality of
								the
								information contained in
								the internship report, the host
								organization may
								request a restriction on the
								distribution of the
								report, or the removal of
								certain confidential information.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" padding-bottom="2pt">
								Persons with a need to know
								shall be constrained by
								commitments to professional secrecy to
								refrain from any use or
								disclosure of the information
								in the
								report.
							</fo:block>
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
								informations recueillies ou obtenues pour
								en faire
								publication,
								communication � des tiers sans accord
								pr�alable de
								l'organisme
								d'accueil, y compris le rapport de
								stage.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								<fo:inline font-weight="bold">(Article 10 suite)</fo:inline>
								Cet engagement vaut non seulement pour la dur�e du stage
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
								padding-top="4pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 11 - Intellectual Property
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In accordance with the code of intellectual property,
								if the intern's activities result
								in the creation of a work
								protected by copyright or
								industrial property (including
								software),
								and the host organization wishes
								to make use of such
								work with the intern's approval,
								a contract must be signed
								between
								the intern (the author)
								and the host organization.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-bottom="4pt">
								The contract must
								specifically include the extent of
								the rights
								to be transferred,
								any possible
								exclusivity
								requirements, the
								intended use, the media
								used,
								and the duration
								of the transfer
								of rights, as well as, if
								applicable, the amount
								of
								compensation due to the
								intern for the
								transfer. This clause
								shall apply
								regardless of the host
								organization's business
								structure.
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
								Article 12 - End of internship
								- Report - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">Internship certificate
								</fo:inline>
								: at the end of the internship, the host organization shall
								issue a certificate, a template for
								which is included as an
								appendix hereto, indicating as a
								minimum the effective duration
								of
								the internship, and, if applicable, the amount of the stipend
								paid. The intern will need to produce
								this certificate as
								supporting documentation in applying for
								benefits under the
								general retirement
								insurance framework, as provided under article
								L.351-17
								of the social security code;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">Internship Quality
								</fo:inline>
								: Once the internship has ended, the parties to this agreement
								are invited to submit an assessment
								of the quality of the
								internship. The intern will send a
								document to the appropriate
								department
								of the educational institution in
								which he will
								evaluate
								the quality of the reception he was
								given by the host
								organization.
								This document will not be
								taken into consideration
								in his
								evaluation, or in awarding his diploma or certificate.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								3)
								<fo:inline text-decoration="underline"> Evaluation of the intern's
									activity
								</fo:inline>
								: Once the internship has ended, the host organization shall
								fill
								out an assessment form on the
								intern's activity, which it
								will return to the academic advisor
								(or
								specify form attached or
								assessment
								procedures previously
								established in cooperation with
								the
								academic advisor).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								4)
								<fo:inline text-decoration="underline">Educational Assessment
									Procedures
								</fo:inline>
								:
								The intern shall (
								<fo:inline font-style="italic" font-size="10pt">
									specify the
									nature
									of the work
									to be provided - report,
									etc.
									- possibly by
									including an attachment
								</fo:inline>
								<fo:inline>
									) :
								</fo:inline>
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt" padding-bottom="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								<fo:inline text-decoration="underline">NUMBER OF ECTS (if
									applicable):
								</fo:inline>
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
								5) Neither the academic
								supervisor from the host organization,
								nor any member of the host
								organization
								invited to visit the educational institution for
								purposes of
								the preparation, conduct and validation
								of the
								internship, may
								assert any claim for reimbursement or
								compensation from the
								educational institution.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
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
								(Article 12 suite)
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
								d'accueil ou tout membre
								de l'organisme
								d'accueil appel� � se
								rendre dans l'�tablissement
								d'enseignement
								dans le cadre de la
								pr�paration, du d�roulement et
								de la
								validation du stage ne peut
								pr�tendre � une quelconque
								prise en
								charge ou indemnisation de
								la part de l'�tablissement
								d'enseignement.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 13 - Applicable law - Competent courts
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								This agreement shall
								be governed exclusively by French law.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Any disputes that
								cannot be amicably
								resolved shall be subject to the jurisdiction
								of the
								competent French courts.
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
				<fo:inline font-weight="bold">
					MADE IN
				</fo:inline>
				<fo:inline font-style="italic" font-size="8pt">(FAIT �)
				</fo:inline>
				<fo:inline>
					.....................................................
				</fo:inline>
				<fo:inline font-weight="bold">
					THIS DAY THE
				</fo:inline>
				<fo:inline font-style="italic" font-size="8pt">(LE)
				</fo:inline>
				<fo:inline>
					.....................................................
				</fo:inline>
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
								font-weight="bold" text-decoration="underline">
								FOR THE EDUCATIONAL
								INSTITUTION
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="7pt" font-family="Times New Roman,serif" font-style="italic">
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
												Signatory for the management centre, by delegation,
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
											<fo:block line-height="110%" padding-top="2pt"
												padding-bottom="2pt" hyphenate="false" language="fr"
												country="FR" font-size="9pt" font-family="Times New Roman,serif"
												font-style="italic">
												(Viseur du centre, par d�l�gation,)
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
										Name and signature of the
										representative of the institution
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="7pt" font-family="Times New Roman,serif"
										font-style="italic">
										(Nom et signature du repr�sentant
										de
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
								font-weight="bold" text-decoration="underline">
								FOR THE HOST ORGANIZATION
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="7pt" font-family="Times New Roman,serif" font-style="italic">
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
										Name and signature of the representative of the
										host
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										hyphenate="false" language="fr" country="FR" font-size="7pt"
										font-family="Times New Roman,serif" font-style="italic">
										(Nom et
										signature du repr�sentant de l'organisme
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
								INTERN (AND LEGAL
								REPRESENTATIVE IF ANY)
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="7pt" font-family="Times New Roman,serif" font-style="italic">
								(STAGIAIRE (ET SON REPRESENTANT LEGAL LE CAS ECHEANT))
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
										Name and signature
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										hyphenate="false" language="fr" country="FR" font-size="7pt"
										font-family="Times New Roman,serif" font-style="italic">
										(Nom et
										signature)
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
								The internship
								supervisor for the host organization
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="7pt" font-family="Times New Roman,serif" font-style="italic">
								(LE TUTEUR DE STAGE DE
								L'ORGANISME D'ACCUEIL)
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
										Name and signature
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										hyphenate="false" language="fr" country="FR" font-size="7pt"
										font-family="Times New Roman,serif" font-style="italic">
										(Nom et
										signature)
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
								The intern's academic
								advisor
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="7pt" font-family="Times New Roman,serif" font-style="italic">
								(L'ENSEIGNANT REFERENT DU STAGIAIRE)
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
										Name and signature
									</fo:block>
									<fo:block line-height="110%" padding-top="2pt"
										padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
										font-size="7pt" font-family="Times New Roman,serif"
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
			<fo:block text-align="center">
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-weight="bold" font-size="18pt">
					INTERNSHIP CERTIFICATE
				</fo:inline>
			</fo:block>
			<fo:block text-align="center">
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-size="10pt" font-style="italic">
					(ATTESTATION DE STAGE )
				</fo:inline>
			</fo:block>
			<fo:block text-align="center" padding-top="5pt">
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-weight="bold" font-size="16pt" font-style="italic">
					to be issued to the
					intern upon the conclusion of the internship
				</fo:inline>
			</fo:block>
			<fo:block text-align="center">
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-size="10pt" font-style="italic">
					(� remettre au
					stagiaire � l'issue du
					stage)
				</fo:inline>
			</fo:block>
			<fo:block padding-top="10pt">
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
										THE HOST ORGANIZATION
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
									<fo:inline font-weight="bold">
										Name or company name
									</fo:inline>
									<fo:inline font-size="8pt" font-style="italic">
										(Nom ou
										d�nomination sociale)
									</fo:inline>
									<fo:inline font-weight="bold">
										:
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="structure/raison-sociale" />
									</fo:inline>
								</fo:block>
								<fo:block line-height="150%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">Address
									</fo:inline>
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
									<fo:inline font-weight="bold">Phone : </fo:inline>
									<xsl:value-of select="structure/telephone" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block padding="0.3cm">
					<fo:inline font-size="9pt" font-weight="bold">
						Hereby certifies
						that
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
										THE INTERN
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
										Last name
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
										First name
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
										Sex :
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="etudiant/code-sexe" />
									</fo:inline>

									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Date of Birth
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
										Address
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
											Phone :
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
											email :
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
									<fo:inline font-weight="bold" font-size="11pt">
										A
										STUDENT OF
									</fo:inline>
									<fo:inline>
										(title of the training course or higher education
										curriculum being followed by the intern) :
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
										sup�rieur suivi par le ou la stagiaire ))
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
									<fo:inline font-weight="bold" font-size="11pt">
										AT
									</fo:inline>
									<fo:inline>
										(name of the higher education institution or
										training organization)
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
						has completed an
						internship as part of his/her studies
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
										INTERNSHIP DURATION
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
										Internship start and end dates
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Dates de
										d�but et de fin
										du stage)
									</fo:inline>
									<fo:inline font-weight="bold">
										:
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										From
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Du)
									</fo:inline>
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										To
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Au)
									</fo:inline>
									<xsl:text> </xsl:text>
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:if test="@interruption-stage = 'true'">
										<xsl:text> </xsl:text>
										<fo:inline font-weight="bold" font-size="11pt">
											with
											interruption from
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">(avec
											interruption du)
										</fo:inline>
										<xsl:text> </xsl:text>
										......................................
										<fo:inline font-weight="bold" font-size="11pt">
											to
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
									language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Representing a total duration
										of
									</fo:inline>
									<fo:inline>
										..................... (Number of months / Number of
										Weeks) (cross out any inappropriate item)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" font-style="italic">
									(Repr�sentant une dur�e
									totale de ...
									Nombre de Mois
									/ Nombre de Semaines (rayer la
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
									The
									total duration of the internship is assessed in consideration
									of the actual presence of the student
									within the organization,
									subject any authorized time off and
									leaves of absence granted,
									as provided
									under article L.124-13 of the education code (art.
									L.124-18 of
									the education code). Each period of
									at least 7 hours
									of presence, whether consecutive or otherwise,
									is
									considered
									equivalent to one day of
									internship work, and each period equal
									to at least 22 days of presence,
									consecutive or otherwise, is
									considered
									equivalent to one month.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									margin-left="0.5cm" text-align="justify" font-style="italic"
									background-color="#E6E6E6">
									(La dur�e totale du stage
									est appr�ci�e en
									tenant compte de la
									pr�sence effective du
									stagiaire dans
									l'organisme, sous r�serve
									des droits � cong�s et
									autorisations
									d'absence pr�vus �
									l'article L.124-13 du code de
									l'�ducation
									(art. L.124-18 du code
									de l'�ducation). Chaque
									p�riode au moins
									�gale � 7 heures de
									pr�sence cons�cutives ou
									non est consid�r�e
									comme �quivalente �
									un jour de stage et
									chaque p�riode au moins
									�gale � 22 jours de
									pr�sence
									cons�cutifs
									ou non est consid�r�e
									comme �quivalente �
									un mois.)
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
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									margin-left="0.5cm">
									<fo:inline font-weight="bold" text-decoration="underline">
										TOTAL
										AMOUNT OF STIPEND PAID TO THE INTERN :
									</fo:inline>
									<fo:inline font-size="8pt">
										(MONTANT DE LA GRATIFICATION
										VERS�E AU STAGIAIRE)
									</fo:inline>
								</fo:block>
								<!-- <fo:block line-height="110%" language="fr" country="FR" -->
								<!-- font-size="9pt" font-family="Times New Roman,serif" -->
								<!-- padding-top="0.2cm"> -->
								<!-- <fo:inline> -->
								<!-- Le stagiaire a per�u une gratification de stage pour un -->
								<!-- montant total de -->
								<!-- <xsl:variable name="nb-montant-gratification" -->
								<!-- select="montant-gratification" /> -->
								<!-- <xsl:choose> -->
								<!-- <xsl:when test='$nb-montant-gratification=""'> -->
								<!-- .................................. &#8364; -->
								<!-- </xsl:when> -->
								<!-- <xsl:otherwise> -->
								<!-- <fo:inline font-weight="bold"> -->
								<!-- <xsl:value-of select="montant-gratification" /> -->
								<!-- </fo:inline> -->
								<!-- euros -->
								<!-- <xsl:text> </xsl:text> -->
								<!-- <xsl:value-of select="unite-gratification/libelle" /> -->
								<!-- par mois -->
								<!-- </xsl:otherwise> -->
								<!-- </xsl:choose> -->
								<!-- </fo:inline> -->
								<!-- </fo:block> -->
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									padding-top="0.2cm">
									The intern has received an internship stipend
									<fo:inline font-weight="bold"> totaling
									</fo:inline>
									..................................
									&#8364;
								</fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="8pt" font-family="Times New Roman,serif" font-style="italic">
									(Le stagiaire a per�u une
									gratification de stage
									pour un
									montant
									total de)
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>


				<fo:table table-layout="fixed" width="100%" margin-left="0cm"
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
										The course certificate
									</fo:inline>
									is an indispensable element, for consideration, subject to
									the
									payment of a fee, of the internship
									work in determining
									retirement benefits. Retirement pensions
									legislation (Law No.
									2014-40 of January 20, 2014)
									grants students
									<fo:inline font-weight="bold">
										whose internship work is
										allocated a stipend
									</fo:inline>
									the possibility of having such work validated
									<fo:inline font-weight="bold">within two calendar quarters,
									</fo:inline>
									subject to the
									<fo:inline font-weight="bold">payment of a fee.
									</fo:inline>
									The
									<fo:inline font-weight="bold">The application is to be made
										by the student within the two years
									</fo:inline>
									of the end of the internship, and
									<fo:inline font-weight="bold">requires the presentation of
										the internship certificate
									</fo:inline>
									indicating the total duration of the internship
									and the total
									amount of the
									stipends paid. Specific information
									regarding
									the
									fee to be paid and the
									procedure to follow may be requested from
									the
									Social Security administration
									(Social Security Code, art.
									L.351-17 -
									Education Code, art. D.124-9).
								</fo:block>

								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="7pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" font-style="italic" text-align="justify"
									background-color="#E6E6E6">
									(L'attestation de stage est indispensable pour
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
									l'�ducation art.D.124-9).)
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold" font-size="11pt">
										MADE IN
									</fo:inline>
									<fo:inline font-size="8pt">
										(Fait �)
										...................................................................
									</fo:inline>
								</fo:block>

								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.1cm"
									padding-bottom="0.035cm">
									<fo:inline font-weight="bold" font-size="11pt">
										THIS DAY THE
									</fo:inline>
									<fo:inline font-size="8pt">
										(Le)
										.........................................................
									</fo:inline>
								</fo:block>

								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.3cm"
									padding-bottom="0.035cm">
									Name, position and signature of the
									representative of the host organization
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
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
	<xsl:template name="FicheStageEtranger">
		<fo:block text-align="center">
			<fo:table border="0.06cm solid #37638B" width="100%"
				table-layout="fixed" color="#37638B">
				<fo:table-column column-width="proportional-column-width(0.05)" />
				<fo:table-column column-width="proportional-column-width(0.55)" />
				<fo:table-column column-width="proportional-column-width(0.40)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding="0.1cm">
							<fo:external-graphic src="url('img_annexe_fiche_etranger.jpg')"
								height="1.25cm" scaling="non-uniform" />
						</fo:table-cell>
						<fo:table-cell border-right="0.06cm solid #37638B"
							padding="0.1cm" text-align="left">
							<fo:block font-size="11pt" font-weight="bold"
								text-align="center">
								Stage � l'�tranger
							</fo:block>
							<fo:block font-size="8pt" font-style="italic"
								padding-top="0.2cm">
								Fiche � compl�ter par l'�tablissement d'enseignement
								ou
								organisme de formation
							</fo:block>
						</fo:table-cell>
						<fo:table-cell border="1" margin-left="0.2cm"
							display-align="center" padding-top="0.2cm" text-align="left">
							<fo:block font-size="8pt">
								<fo:inline text-decoration="underline" font-weight="bold">
									PAYS D'ACCUEIL
								</fo:inline>
								:
								<fo:inline color="black">
									<xsl:choose>
										<xsl:when test="service/pays/libelle">
											<xsl:value-of select="service/pays/libelle" />
										</xsl:when>
										<xsl:otherwise>
											...................................................
										</xsl:otherwise>
									</xsl:choose>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block padding-top="5pt">
			<fo:table border="0.018cm solid #000000" padding="3pt"
				width="100%" table-layout="fixed">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell border="1" margin-left="0.2cm"
							padding-top="0.2cm">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								CONDITIONS D'ENTR�E ET DE S�JOUR DANS LE PAYS
								D'ACCUEIL
							</fo:block>
							<fo:block margin-left="1cm" line-height="130%"
								hyphenate="false" language="fr" country="FR" font-size="8pt"
								font-family="Times New Roman,serif" font-style="italic">
								<fo:inline text-decoration="underline">
									Pr�ciser ici les
									informations extraites de la
								</fo:inline>
								<fo:basic-link
									external-destination="url('www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									Fiche-pays
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">1
								</fo:inline>
								<fo:inline text-decoration="underline">
									essentielles � conna�tre
									par le stagiaire :
								</fo:inline>
							</fo:block>
							<fo:block line-height="250%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif">
								.........................................................................................................................................................................................................................................
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block padding-top="5pt">
			<fo:table border="0.018cm solid #000000" padding="3pt"
				width="100%" table-layout="fixed">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell border="1" margin-left="0.2cm"
							padding-top="0.2cm">
							<fo:block font-size="10pt" font-weight="bold"
								text-decoration="underline" color="red">
								AVERTISSEMENT SUR LA S�CURIT�
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								<fo:inline font-weight="bold">Consultez la classification de
									la zone
								</fo:inline>
								o� doit se d�rouler le stage envisag� sur le site du Minist�re
								des Affaires �trang�res
								et du D�veloppement international,
								rubrique
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/')"
									color="blue" text-decoration="underline">
									Conseils aux voyageurs
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">2
								</fo:inline>
								:
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif">
								- votre �tablissement d'enseignement
								<fo:inline color="red">ne validera pas</fo:inline>
								une convention de stage pour une zone qualifi�e "
								<fo:inline color="red">rouge</fo:inline>
								" ;
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif">
								- votre �tablissement d'enseignement examinera la situation
								avant une
								<fo:inline color="red">�ventuelle validation</fo:inline>
								d'une convention de stage pour une zone qualifi�e "
								<fo:inline color="red">orange</fo:inline>
								". Les projets de stage en zone
								orange font toutefois l'objet
								d'un
								<fo:inline font-weight="bold">� priori n�gatif</fo:inline>
								;
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								<fo:inline font-weight="bold">En cas de basculement en zone
									"rouge"
								</fo:inline>
								pendant votre s�jour, il vous est demand� de
								<fo:inline font-weight="bold">mettre fin imm�diatement
								</fo:inline>
								au stage.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								<fo:inline font-weight="bold">Avant de partir,</fo:inline>
								vous devez prendre connaissance des
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/')"
									color="blue" text-decoration="underline">
									conseils aux voyageurs
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">2
								</fo:inline>
								<fo:inline font-weight="bold"> accessibles via la </fo:inline>
								<fo:basic-link
									external-destination="url('www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									fiche-pays
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">1
								</fo:inline>
							</fo:block>
							<fo:block line-height="200%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								font-style="italic">
								<fo:inline text-decoration="underline">
									Mentionner ici le lien
									direct vers la fiche-pays concern�e
								</fo:inline>
								:
								...............................................................................................................
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								Il vous est demand� de
								<fo:inline font-weight="bold">vous inscrire avant votre
									d�part
								</fo:inline>
								sur la
								<fo:basic-link
									external-destination="url('https://pastel.diplomatie.gouv.fr/fildariane/dyn/public/login.html')"
									color="blue" text-decoration="underline">
									base Ariane
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">3
								</fo:inline>
								.
								De cette mani�re, le Minist�re des Affaires �trang�res et du
								d�veloppement international pourra vous joindre par mail ou sms
								en cas d'incident s�curitaire.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								Si vous demeurez
								<fo:inline font-weight="bold">plus de six mois</fo:inline>
								dans le pays, en tenant compte de votre temps de pr�sence
								<fo:inline font-weight="bold">avant et apr�s le stage,
								</fo:inline>
								vous devrez
								<fo:inline font-weight="bold">vous inscrire au Registre des
									Fran�ais
								</fo:inline>
								�tablis hors de France aupr�s des autorit�s consulaires
								Fran�aises (Consulat g�n�ral ou section consulaire de
								l'ambassade
								<fo:inline vertical-align="super" font-size="60%">5
								</fo:inline>
								).
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block padding-top="5pt">
			<fo:table border="0.018cm solid #000000" width="100%"
				table-layout="fixed">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding="0.2cm">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								CONDITIONS PARTICULIERES DU STATUT DU STAGIAIRE
								DANS LE PAYS
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="12pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								Non
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="12pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								Oui
								:
								<fo:inline font-size="9pt" font-style="italic"
									text-decoration="underline">Mentionner
									ici des particularit�s li�es aux
									stages dans le pays
									(r�glementation sp�cifique / droits
									d'inscription
									compl�mentaire / convention de partenariat /
									accords cadre /
									conditions particuli�res sur la gratification ou
									non)
								</fo:inline>
								:
								......................................................
							</fo:block>
							<fo:block line-height="200%" hyphenate="false" language="fr"
								country="FR" font-family="Times New Roman,serif">
								.............................................................................................................................................................................
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell padding="0.2cm" border-top="0.018cm solid #000000">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								ASSURANCE COMPLEMENTAIRE
							</fo:block>
							<fo:block font-size="9pt" line-height="110%" hyphenate="false"
								language="fr" country="FR" font-family="Times New Roman,serif"
								padding-top="2pt">
								Les r�gimes de protection sont
								diff�rents selon le
								pays d'accueil (y compris en Europe) et les
								modalit�s du stage
								(gratification sup�rieure ou non
								au plafond
								l�gal Fran�ais)*. Pour
								votre stage :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold">Vous b�n�ficiez d'un r�gime de
									protection sociale local
								</fo:inline>
								<fo:wrapper font-family="ZapfDingbats">&#x2192; </fo:wrapper>
								<fo:inline font-weight="bold">Votre
									convention de stage doit
									le
									pr�ciser.
								</fo:inline>
								Si vous estimez cette
								protection insuffisante, vous pouvez
								souscrire � l'assurance
								maladie volontaire de la
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									Caisse des Fran�ais de l'Etranger
									(CFE)
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								ou � une assurance priv�e.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold">Vous ne b�n�ficiez pas
								</fo:inline>
								d'un r�gime de protection sociale local.
								<fo:inline font-weight="bold">Vous devez souscrire
								</fo:inline>
								� l'assurance maladie volontaire de la
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									Caisse des Fran�ais de l'Etranger
									(CFE)
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								ou � une assurance
								priv�e.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm" padding-bottom="0.2cm">
								<fo:inline font-weight="bold">Dans tous les cas, </fo:inline>
								compte tenu du co�t �lev� des soins dans de nombreux �tats,
								<fo:inline font-weight="bold">il est vivement conseill� de
									souscrire
								</fo:inline>
								� l'assurance maladie volontaire de la
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									Caisse des Fran�ais de l'Etranger
									(CFE)
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								ou � une assurance
								priv�e.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								font-style="italic">
								*L'�tablissement doit v�rifier
								les conditions de
								protection sociale du pays d'accueil afin
								d'informer
								pr�alablement le stagiaire et, au besoin, faire les
								d�marches
								n�cessaires aupr�s de la CPAM notamment pour la
								protection
								accidents du travail : pour les �tudiants voir
								convention-type
								de
								stage articles 6 et 7 (cf. arr�t� du 29
								d�cembre 2014 relatif
								aux
								conventions de stage dans
								l'enseignement sup�rieur). Pour
								les
								�l�ves en formation
								professionnelle de niveaux V et IV voir
								convention type
								concernant les p�riodes de formation en milieu
								professionnel �
								l'�tranger (cf. circulaire n�2003-203 du
								17/11/2003 notamment
								article 8).
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell padding="0.2cm" border-top="0.018cm solid #000000">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								STAGIAIRE MINEUR
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif">
								-
								<fo:inline font-weight="bold">Se r�f�rer � la convention-type
								</fo:inline>
								concernant les p�riodes de formation en milieu professionnel �
								l'�tranger des �l�ves en formation professionnelle de niveaux V
								et IV (circulaire n�2003-203 du 17/11/2003 dont notamment
								articles 4, 5 et 6).
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" font-style="italic">
								�ventuellement
								indications particuli�res � mettre en exergue par
								l'�tablissement
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.1cm">
								-
								<fo:inline font-weight="bold">R�glementation particuli�re
									pour les mineurs dans le pays d'accueil :
								</fo:inline>
							</fo:block>
							<fo:block margin-left="1.5cm" padding-top="0.1cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="12pt" font-family="Times New Roman,serif">
									<fo:external-graphic src="url('square.JPG')" />
									Non
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									padding-top="0.1cm" language="fr" country="FR" font-size="12pt"
									font-family="Times New Roman,serif">
									<fo:external-graphic src="url('square.JPG')" />
									Oui :
									<fo:inline font-style="italic">pr�cisez les particularit�s
									</fo:inline>
									:
									..............................................................................................
								</fo:block>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell font-size="9pt" padding="0.2cm"
							border-top="0.018cm solid #000000">
							<fo:block font-weight="bold" text-decoration="underline">
								SITES DE
								REFERENCE
							</fo:block>
							<fo:block padding-top="0.1cm">
								<fo:inline vertical-align="super" font-size="60%">1
								</fo:inline>
								Fiches-pays :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">2
								</fo:inline>
								Fiches Conseils aux voyageurs :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">3
								</fo:inline>
								Base Ariane :
								<fo:basic-link
									external-destination="url('https://pastel.diplomatie.gouv.fr/fildariane/dyn/public/login.html')"
									color="blue" text-decoration="underline">
									https://pastel.diplomatie.gouv.fr/fildariane/dyn/public/login.html
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								Caisse des Fran�ais de l'Etranger pour assurance compl�mentaire
								:
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									http://www.cfe.fr/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">5
								</fo:inline>
								Sites internet des ambassades et consulat fran�ais indiqu�s dans
								la Fiche-pays :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								Protection sociale � l'international :
								<fo:basic-link external-destination="url('http://www.cleiss.fr/')"
									color="blue" text-decoration="underline">
									http://www.cleiss.fr/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								Connaissance de l'enseignement sup�rieur (fiches de la base
								"Curie") :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/politique-etrangere-de-la-france/cooperation-educative/')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/politique-etrangere-de-la-france/cooperation-educative/
								</fo:basic-link>
							</fo:block>
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
