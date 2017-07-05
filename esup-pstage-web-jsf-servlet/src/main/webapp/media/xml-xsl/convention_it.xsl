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
		<!-- <fo:block break-after="page" /> -->
		<!-- <fo:block> -->
		<!-- <xsl:call-template name="Attestation" /> -->
		<!-- </fo:block> -->
		<!-- <fo:block break-after="page" /> -->
		<!-- <fo:block> -->
		<!-- <xsl:call-template name="FicheStageEtranger" /> -->
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
			padding-top="0.1cm" font-style="italic" text-decoration="underline"
			font-weight="bold">
			Documenti da allegare alla convenzione :
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
				1) Attestato di tirocinio
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(pagina seguente)
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
				2) Scheda tirocinio all'estero
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(per informazioni
				sulla previdenza sociale, visitare il sito cleiss.fr, per i
				documenti inerenti a ciascun paese, visitare il sito
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
				3) Altri allegati
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(se del caso)
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
								Anno accademico
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
								Convenzione di stage
								<xsl:text> </xsl:text>
								n�
								<xsl:value-of select="id-convention" />
								tra

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
			Nota : per facilitare la lettura del documento, le parole
			"stagista o tirocinante", "insegnante di riferimento o referente",
			"tutor di stage", "rappresentante legale", "studente" sono utilizzate
			al maschile.
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="6.5pt" font-family="Times New Roman,serif"
			padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
			padding-bottom="0.3cm" font-style="italic">
			(Nota: : pour faciliter la lecture
			du document,
			les mots � stagiaire �,
			� enseignant r�f�rent �, � tuteur
			de stage �,
			� repr�sentant l�gal �,
			� �tudiant � sont utilis�s au
			masculin )
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
								<fo:inline text-decoration="underline">L'ISTITUTO DI ISTRUZIONE
									SUPERIORE O DI FORMAZIONE
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
								Nome
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
								Indirizzo
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
								Rappresentato da (segnatario
								della convenzione)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Repr�sent�
								par (nom du
								signataire de la convention))
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
													In qualit� di
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
													Cargo del representante
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
								Componente/UFR
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
								Indirizzo (se differente da
								quello dell'istituto)
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
								E-mail :
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
									L'ORGANISMO OSPITANTE
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
								Nome
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of select="structure/raison-sociale" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Indirizzo
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Adresse)
							</fo:inline>
							<fo:inline> :
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
								Rappresentato da (segnatario
								della convenzione)
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Repr�sent�
								par (nom du
								signataire de la convention))
							</fo:inline>
							<fo:inline> :
							</fo:inline>
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
								In qualit� di
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
								Ufficio o servizio di
								svolgimento dello stage
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Service dans
								lequel le stage
								sera effectu�)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
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
								E-mail :
							</fo:inline>
							<xsl:value-of select="structure/mail" />
						</fo:block>
						<xsl:if test="service/voie != structure/voie">
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Luogo di svolgimento dello
									stage (se diverso dall'indirizzo dell'organismo):
								</fo:inline>
								<fo:inline font-style="italic" font-size="8pt"> (Lieu du
									stage (si diff�rent de
									l'adresse de l'organisme))
								</fo:inline>
								<fo:inline> :
								</fo:inline>
							</fo:block>
							<fo:block line-height="130%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
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
							text-align="center" font-size="9pt">
							<fo:inline font-weight="bold">
								3 -
								<fo:inline text-decoration="underline" font-size="9pt">IL
									TIROCINANTE
								</fo:inline>
								<fo:inline font-style="italic" font-size="6.5pt">(LE
									STAGIAIRE)
								</fo:inline>
							</fo:inline>
						</fo:block>

						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.2cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nome
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Cognome
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
								Sesso :
							</fo:inline>
							<xsl:value-of select="etudiant/code-sexe" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Nato/a il
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
								Numero Studente
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Num�ro
								d'�tudiant)
							</fo:inline>
							<xsl:value-of select="etudiant/num-etudiant" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Indirizzo
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
								Tel m�vil :
							</fo:inline>
							<xsl:value-of select="tel-portable-etudiant" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								E-mail :
							</fo:inline>
							<xsl:value-of select="etudiant/mail" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="8pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm" text-align="justify" font-weight="bold">
							DENOMINAZIONE DELLA FORMAZIONE O DEL PERCORSO DI FORMAZIONE
							SEGUITO NELL'ISTITUTO DI ISTRUZIONE SUPERIORE E VOLUME ORARIO
							(ANNUALE O SEMESTRALE):
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
							padding-left="0.141cm" padding-right="0.141cm" padding-bottom="0.035cm">
							<xsl:value-of select="etape/libelle" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Numero di ore di formazione
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">
								(Nombre
								d'heures de formation)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
							<xsl:choose>
								<xsl:when test="volume-horaire-formation and volume-horaire-formation != '0'">
									<xsl:value-of select="volume-horaire-formation" />
								</xsl:when>
								<xsl:otherwise>
									<fo:inline>
										.........................................
									</fo:inline>
								</xsl:otherwise>
							</xsl:choose>
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
								OGGETTO DELLO STAGE
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
								Confidenziale
							</xsl:if>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.5cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Date :
							</fo:inline>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Dal
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Du)
							</fo:inline>
							<fo:inline> :
							</fo:inline>

							<xsl:text> </xsl:text>
							<xsl:value-of
								select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Al
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Au)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:text> </xsl:text>
							<xsl:value-of
								select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />
							<xsl:if test="@interruption-stage = 'true'">
								<xsl:text> </xsl:text>
								<fo:inline font-weight="bold">
									con interruzione di
								</fo:inline>
								<fo:inline font-style="italic" font-size="8pt">(avec
									interruption du)
								</fo:inline>
								<xsl:value-of
									select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
								<fo:inline font-weight="bold">
									al
								</fo:inline>
								<fo:inline font-style="italic" font-size="8pt">(au)
								</fo:inline>
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
											<fo:inline>
												Per una
											</fo:inline>
											<fo:inline font-weight="bold"> durata totale
											</fo:inline>
											<fo:inline> di :
											</fo:inline>

											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> </xsl:text>
											<xsl:if test="id-unite-duree-exceptionnelle = '1'">
												ore
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '2'">
												giorni
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '3'">
												settimane
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '4'">
												mesi
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '5'">
												anno
											</xsl:if>
										</fo:block>
									</xsl:when>
									<xsl:otherwise>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												Corrispondente a
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> ore </xsl:text>
											<fo:inline font-weight="bold">
												di presenza effettiva
												nell'organismo ospitante
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
												E corrispondente a
											</fo:inline>
											<fo:inline font-style="italic" font-size="8pt">(et
												correspondant � )
											</fo:inline>
											<xsl:variable name="nbHeures" select="duree-exceptionnelle" />
											<xsl:variable name="nbJours" select="floor($nbHeures div 7)" />
											<xsl:variable name="nbHeuresRestantes" select="$nbHeures mod 7" />
											<xsl:variable name="nbMois" select="floor($nbJours div 22)" />
											<xsl:variable name="nbJoursRestants" select="$nbJours mod 22" />

											<xsl:value-of select="$nbMois" />
											<xsl:text> mesi  </xsl:text>
											<xsl:value-of select="$nbJoursRestants" />
											<xsl:text> giorni </xsl:text>
											<xsl:value-of select="$nbHeuresRestantes" />
											<xsl:text> ore  </xsl:text>
											<fo:inline font-style="italic" font-size="8pt">
												(... mois
												... jours ... heures)
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
										Per una durata totale di :
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									settimmane
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
											In caso di presenza
											discontinua, ripartizione:
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
											numero di ore a settimana
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
								Commenti
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
							INQUADRAMENTO DEL TIROCINANTE IN SENO
							ALL'ISTITUTO DI ISTRUZIONE SUPERIORE
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
								Nome e cognome dell'insegnante
								di riferimento
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom et
								pr�nom
								de
								l'enseignant r�f�rent)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
							<xsl:value-of select="translate(enseignant/nom,$lowers,$uppers)" />
							<xsl:text> </xsl:text>
							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="enseignant/prenom" />
								</xsl:with-param>
							</xsl:call-template>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Funzione (o disciplina)
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
								E-mail :
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
							INQUADRAMENTO DEL TIROCINANTE IN SENO
							ALL'ORGANISMO OSPITANTE
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm"
							font-weight="bold" text-align="center" font-style="italic"
							font-size="7pt">
							(ENCADREMENT DU STAGIAIRE PAR L'ORGANISME D'ACCUEIL)
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nome e cognome del tutor di
								stage
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom et
								pr�nom
								du tuteur de stage)
							</fo:inline>
							<fo:inline font-weight="bold">
								:
							</fo:inline>
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
								Funzione
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
								E-mail :
							</fo:inline>
							<xsl:value-of select="contact/mail" />
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
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
							Ente sanitario da
							contattare in caso di incidente (Cassa Primaria di Assicurazione
							Malattia del luogo di domicilio del tirocinante, tranne casi
							eccezionali) :
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
			Stampa data :
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
								font-weight="bold">Articolo 1 - Oggetto della convenzione
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La presente convenzione regola i rapporti tra l'organismo
								ospitante e l'istituto di formazione del tirocinante.
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
								Articolo 2 - Obiettivo dello stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Lo stage corrisponde a un periodo di tempo limitato che permette
								allo studente di sperimentare l'inserimento in ambiente
								professionale. Grazie ad esso, lo studente acquisisce nuove
								competenze mentre applica quelle gi� acquisite durante il suo
								percorso di formazione, in vista dell'ottenimento di un diploma
								o di una certificazione. Lo stage � volto a facilitare
								l'inserimento professionale dello studente. Allo stagista
								saranno affidate una o due missioni conformi al progetto
								pedagogico definito dal suo istituto di formazione e approvato
								dall'organismo ospitante.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Il programma � stabilito dall'istituto di formazione
								e dall'organismo ospitante in funzione del programma generale
								della formazione seguita.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">ATTIVIT� DI STAGE
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
								<fo:inline text-decoration="underline"> COMPETENZE DA ACQUISIRE O
									DA SVILUPPARE
								</fo:inline>
								:
							</fo:block>
							<fo:block line-height="110%" hyphenate="true" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
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

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Articolo 3 - Modalit� di svolgimento dello stage
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La durata settimanale e la presenza dello stagista presso
								l'organismo ospitante sar� di
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								ore, calcolate sulla base di un contratto
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when
											test="temps-travail/code-ctrl='TCOMP' or temps-travail/code-ctrl='TPART'">
											<xsl:if test="temps-travail/code-ctrl='TCOMP'">
												ordinario.
											</xsl:if>
											<xsl:if test="temps-travail/code-ctrl='TPART'">
												part-time.
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Servizio presso l'organismo ospitante nelle ore notturne, la
								domenica o in giorni feriali, precisare i casi particolari :
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
								font-weight="bold">Articolo 4 - Accoglienza e inserimento del
								tirocinante
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Il tirocinante � seguito dall'insegnante di riferimento
								designato nella presente convenzione, come anche dal servizio
								dedicato agli stage dell'istituto di formazione.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Il tutor dello stage, designato dall'organismo ospitante nel
								presente documento, ha il compito di assicurare il monitoraggio
								dell'esperienza del tirocinante e di ottimizzare le condizioni
								di realizzazione dello stage, conformemente agli obiettivi
								pedagogici individuati.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Il tirocinante, durante lo stage, � autorizzato a recarsi presso
								l'istituto di provenienza per seguire lezioni esplicitamente
								richieste dal programma, o per partecipare a eventuali riunioni,
								le cui date saranno rese note dall'istituto di appartenenza
								all'organismo ospitante.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Articolo 4 continuazione)
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt">
								L'organismo
								ospitante potr� autorizzare il tirocinante a spostarsi.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Qualsiasi difficolt� riscontrata durante lo svolgimento del
								tirocinio, constatata dal tirocinante o dal tutor assegnatogli,
								dovr� essere sottoposta all'attenzione dell'insegnate referente
								e dell'istituto di appartenenza, cos� da poter essere risolta
								nel pi� breve tempo possibile.
							</fo:block>

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									MODALIT� DI INSERIMENTO
								</fo:inline>
								(visite, appuntamenti telefonici, etc) :
							</fo:block>
							<xsl:choose>
								<xsl:when test="mode-encadre-suivi and mode-encadre-suivi != ''">
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
										font-weight="bold">
										<xsl:value-of select="mode-encadre-suivi" />
									</fo:block>
								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="110%" hyphenate="false"
										language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
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
								keep-with-next="always" text-align="justify" font-weight="bold">Articolo
								5 - Gratificazioni - Vantaggi
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								In Francia, qualsiasi tipo di stage dalla durata di due mesi che
								siano consecutivi o meno, � obbligatoriamente oggetto di una
								gratificazione in denaro, eccezion fatta per particolari regole
								applicabili in alcune collettivit� d'oltremare francesi e per le
								tipologie di stage disciplinate dall'articolo L4381-1 del Codice
								di Deontologia Medica francese.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								L'importo orario della gratificazione � fissato al
								15% del tetto orario massimo di previdenza sociale definito in
								applicazione dell'articolo L.241-3 del Codice di Previdenza
								Sociale francese. Una convenzione di settore o uno specifico
								accordo professionale pu� definire un importo orario superiore.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								La gratificazione dovuta da un organismo di diritto
								pubblico non pu� essere cumulata con una remunerazione versata
								dallo stesso organismo durante il periodo interessato.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								La gratificazione � dovuta indipendentemente dal
								rimborso delle spese affrontate del tirocinante durante lo stage
								e i vantaggi dovuti, se del caso, per la ristorazione,
								l'alloggio e il trasporto.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								L'organismo pu� altres� decidere di versare una gratificazione
								per gli stage di una durate inferiore o pari a due mesi.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								In caso di sospensione
								o scioglimento della presente convenzione, l'importo della
								gratificazione dovuta al tirocinante sar� calcolata pro rata in
								funzione della durata dello stage effettuato.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La durata a partire
								dalla quale il tirocinante ha diritto alla gratificazione sar�
								individuata tenendo conto della presente convenzione e delle
								eventuali clausole ad essa allegate, cos� come del numero di
								giorni di presenza effettiva del tirocinante presso l'organismo
								ospitante.
							</fo:block>
							<xsl:variable name="indemnisation" select="id-indemnisation" />
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>

								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">L'IMPORTO DELLA
											GRATIFICAZIONE
										</fo:inline>
										� fissato a
										<xsl:variable name="nb-montant-gratification"
											select="montant-gratification" />
										<xsl:choose>
											<xsl:when test='$nb-montant-gratification=""'>

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
												Modalit� di pagamento
											</fo:inline>
											:
											<xsl:value-of select="mode-vers-gratification/libelle" />
										</fo:block>
									</xsl:if>
								</xsl:otherwise>
							</xsl:choose>
							<xsl:if test="avantages-nature and avantages-nature != ''">
								<fo:block line-height="130%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:inline text-decoration="underline">
										ALTRI VANTAGGI ACCORDATI
									</fo:inline>
									:
									<fo:inline font-weight="bold">
										<xsl:value-of select="avantages-nature" />
									</fo:inline>
								</fo:block>
							</xsl:if>
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
												...
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
								text-align="justify" font-weight="bold">Articolo 6 - Regime di
								previdenza sociale
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Per tutta la durata dello stage, il tirocinante
								continuer� a dipendere dal regime di previdenza sociale
								antecedente all'attivit� di tirocinio.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Se richiesto, i tirocini effettuati all'estero
								saranno segnalati all'ente di Previdenza Sociale prima della
								partenza del tirocinante.
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
									Importo
									massimo della gratificazione di stage pari al 15% del tetto
									orario massimo di previdenza sociale:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								La gratificazione � esente da contributi.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Il tirocinante beneficia della legislazione sugli
								infortuni sul lavoro secondo il regime di previdenza sociale
								studenti dell'articolo L.412-8 comma 2 del Codice di Previdenza
								Sociale francese.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In caso di incidente durante l'attivit� svolta presso
								l'organismo, durante il tragitto per raggiungere il luogo di
								stage, in specifici luoghi utili allo svolgimento dello stage e
								per gli studenti in medicina, chirurgia dentale o farmacia non
								aventi lo statuto di personale ospedaliero, durante lo stage
								effettuato secondo le condizioni previste al punto b del comma 2
								dell'articolo L.412-8,
								<fo:inline text-decoration="underline">
									l'organismo ospitante invia
									la dichiarazione alla Cassa Primaria di Assicurazione Malattia
								</fo:inline>
								o all'ente competente (vedi indirizzo pag.1) menzionando
								l'istituto di formazione come
								datore di lavoro,
								<fo:inline text-decoration="underline">
									con copia all'istituto di
									formazione
								</fo:inline>
								.
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
									Gratificazione superiore
								</fo:inline>
								al 15% del tetto orario massimo di previdenza sociale:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								I contributi sociali sono calcolati sul differenziale
								tra l'importo della gratificazione e il 15% del tetto massimo
								orario di Previdenza Sociale.
								Lo studente beneficia della
								copertura legale in applicazione delle
								disposizioni degli
								articoli L.411-1 e seguenti del Codice di
								Previdenza Sociale
								francese. In caso di incidente durante
								l'attivit� svolta presso
								l'organismo, durante il tragitto per
								raggiungere il luogo di
								stage, in specifici luoghi utili allo
								svolgimento dello stage,
								l'organismo ospitante sar� tenuto a
								effettuare tutte le pratiche
								necessarie presso la Cassa Primaria
								di Assicurazione Malattia e a
								informarne l'istituto di
								provenienza dal tirocinante nel pi�
								breve tempo possibile.
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
								6.3 - Assistenza sanitaria
								dello stagista all'estero
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">
									Assistenza secondo il
									regime di previdenza francese per gli studenti
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- Per i tirocini
								svolti in seno allo Spazio Economico Europeo (SEE), qualsiasi
								studente proveniente da uno stato membro, dalla Norvegia,
								dall'Islanda, dal Liechtenstein o dalla Svizzera, o ancora da
								qualsiasi altro Stato (in questo ultimo caso, la presente
								disposizione non sar� applicabile per un tirocinio in Danimarca,
								Norvegia, Islanda, Liechtenstein o Svizzera) dovr� richiedere la
								sua Tessera Europea di Assicurazione Malattia (TEAM);
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- Per i
								tirocini effettuati in Qu�bec da studenti di nazionalit�
								francese, il tirocinante dovr� richiedere il modulo SE401Q (104
								per i tirocini in azienda, 106 per i tirocini in universit�);
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- In tutti gli
								altri casi, gli studenti che si trovano a dover affrontare spese
								sanitarie, potranno essere rimborsati al ritorno presso la cassa
								mutua che funge per loro come Cassa di Previdenza Sociale
								Studente, su presentazione dei dovuti giustificativi. Il
								rimborso verr� effettuato, allora, sulla base delle tariffe
								applicate alle spese sanitarie in Francia.
								Possono verificarsi
								importanti differenze tra le spese affrontate e le
								tariffe
								francesi alla base del rimborso. Pertanto, � fortemente
								consigliato agli studenti di sottoscrivere un'assicurazione
								sanitaria complementare specifica, valida per il paese e per la
								durata del tirocinio, presso l'organismo assicurativo di propria
								scelta (cassa mutua studentesca, cassa mutua dei genitori,
								compagnia privata ad hoc...) o, eventualmente e dopo verifica
								dell'estensione delle garanzie proposte, presso l'organismo
								ospitante, nel momento in cui quest'ultimo fornisca al
								tirocinante una copertura sanitaria in ottemperanza di leggi
								locali (cfr. 2� punto qui di seguito).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2)
								<fo:inline text-decoration="underline">
									Previdenza sociale
									dell'organismo ospitante
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Barrando la casella corrispondente, l'organismo
								ospitante fornisce al tirocinante maggiori informazioni sulla
								protezione sanitaria offerta, in virt� della legislazione
								locale:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm" text-align="justify">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> S�
								</fo:inline>
								la protezione sanitaria si aggiunte, all'estero, al mantenimento
								dei diritti gi� garantiti dalla legislazione francese.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm" text-align="justify">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> NO
								</fo:inline>
								la protezione sanitaria, all'estero, sar� esclusivamente
								garantita dal mantenimento dei diritti del regime di previdenza
								sociale studenti francese.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								Nel caso in cui nessuna delle caselle fosse barrata,
								si applicher� l'articolo
								6.3-1.
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
									Protezione infortuni sul
									lavoro tirocinante all'estero
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								1)
								<fo:inline text-decoration="underline">Per poter beneficiare dei
									diritti francesi
								</fo:inline>
								sulla copertura assicurativa degli infortuni sul lavoro, il
								presente stage deve:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- avere una durata di massimo 6 mesi, esclusi
								eventuali prolungamenti;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- non dar luogo a nessuna
								remunerazione suscettibile di aprire i diritti a una protezione
								infortuni sul lavoro nel paese ospitante; sono ammesse
								un'indennit� o una gratificazione che non superi il tetto
								massimo orario del 15% della previdenza sociale francese (cfr.
								punto 5) e, con riserva dell'accordo della Cassa Primaria di
								Assicurazione Malattia sulla richiesta di mantenimento dei
								diritti;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- svolgersi esclusivamente in
								seno all'organismo segnatario della presente convenzione;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- svolgersi esclusivamente nel
								paese ospitante menzionato.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								Qualora le
								sopracitate condizioni non fossero rispettate, l'organismo
								ospitante si impegna a versare i contributi per la protezione
								del tirocinante e a effettuare tutte le dichiarazioni necessarie
								in caso di infortunio sul lavoro.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">
									La dichiarazione degli
									infortuni sul lavoro
								</fo:inline>
								spetta all'istituto di provenienza dello studente che dovr�
								esserne informato per iscritto dall'organismo ospitante entro 48
								ore.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								3)
								<fo:inline text-decoration="underline">La copertura assicurativa
									riguarda gli incidenti verificatisi:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- sul
								posto di svolgimento dello stage e durante le ore ad esso
								dedicate,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- sul
								tragitto di andata e ritorno che il tirocinante percorre
								abitualmente per recarsi dalla sua residenza al luogo di lavoro,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- nel
								quadro di una missione affidata al tirocinante dall'organismo
								ospitante e obbligatoriamente tramite ordine di missione.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- durante
								il primo tragitto per recarsi dal domicilio al luogo di
								residenza durante lo stage (spostamento alla data di inizio del
								tirocinio),
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- durante
								l'ultimo tragitto di ritorno dalla residenza occupata durante lo
								stage fino al proprio domicilio alla fine di quest'ultimo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4)
								<fo:inline text-decoration="underline"> Per i casi in cui soltanto
									una delle condizioni dell'articolo 6.4-1/
								</fo:inline>
								non fosse rispettata, l'organismo ospitante si impegna alla
								copertura assicurativa del tirocinante contro il rischio di
								infortunio sul lavoro, di infortunio durante il tragitto e di
								malattie professionali e ad assicurarne tutte le dichiarazioni
								necessarie.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">5) In tutti i casi:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- se lo studente � vittima di un infortunio sul
								lavoro durante lo stage, l'organismo ospitante dovr�
								imperativamente e immediatamente segnalare l'incidente
								all'istituto di provenienza;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- se lo studente svolge
								missioni limitate al di fuori dell'organismo ospitante o al di
								fuori del paese ospitante, l'organismo ospitante dovr� occuparsi
								di tutte le disposizioni necessarie per offrirgli le
								assicurazioni appropriate.
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
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								(Article 6.4 suite)
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
								Articolo 7 - Responsabilit� e
								assicurazione.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								L'organismo ospitante e il tirocinante dichiarano di
								essere coperti dell'assicurazione di responsabilit� civile di
								base.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Per i tirocini all'estero o in territori d'oltremare,
								il tirocinante si impegna a sottoscrivere un contrato di
								assistenza (rimpatrio sanitario, assistenza giuridica...) e un
								contratto di assicurazione individuale incidenti.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Nel momento in cui l'organismo ospitante mette un
								veicolo a disposizione del tirocinante, dovr� occuparsi di
								verificare precedentemente che la polizza assicurativa compra
								l'utilizzo di esso da parte di uno studente.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								Se nel quadro dello stage, lo studente utilizza il
								suo veicolo personale o un veicolo preso in prestito da terzi,
								lo fa espressamente presente all'assicuratore del suddetto
								veicolo e, se del caso, si far� carico del premio ad essa
								afferente.
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
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Articolo 8 - Disciplina
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Il tirocinante � sottoposto alle regole disciplinari
								e alle clausole del regolamento interno applicabili, di cui deve
								essere messo a conoscenza prima dell'inizio dello stage, in
								particolare per quanto riguarda gli orari, le regole igieniche e
								di sicurezza in vigore nell'organismo di accoglienza.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Qualsiasi sanzione disciplinare pu� essere decisa
								soltanto dall'istituto di provenienza. In questo caso,
								l'organismo ospitante informa l'insegnante di riferimento e
								l'istituto di provenienza delle mancanze dello studente e
								fornisce gli eventuali elementi costitutivi.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In caso di mancanze particolarmente gravi alle regole
								disciplinari, l'organismo ospitante si riserva il diritto di
								porre fine allo stage, rispettando le disposizioni previste
								all'articolo 9 della presente convenzione.
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
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Articolo 9 - Giorni di congedo - Interruzione dello
								stage
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								In Francia
								(tranne in casi di regolamentazioni particolari applicabili in
								alcune collettivit� d'oltremare francesi o negli organismi di
								diritto pubblico), in caso di maternit�, paternit� o adozione,
								il tirocinante beneficia di congedi e assenze giustificate di
								una durata equivalente a quella prevista per gli effettivi
								dipendenti dagli articoli da L.1225-16 a L.1225-28, L.1225-35,
								L.1225-37, L.1225-46 del Codice del Lavoro francese.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify">
								Per gli stage la
								cui durata � superiore a due mesi e nei limiti della durata
								massima di 6 mesi, � possibile richiedere ed accordare congedi o
								assenze giustificate.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline text-decoration="underline">
									NUMERO DI GIORNI DI CONGEDO
									AUTORIZZATI
								</fo:inline>
								/ o modalit� di congedo e assenze giustificate durante il
								tirocinio:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<xsl:value-of select="nb-conges" />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Per qualsiasi altra interruzione temporanea dello
								stage (malattia, assenza ingiustificata...) l'organismo
								ospitante avverte per iscritto l'istituto di provenienza.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt" text-align="justify">
								Qualsivoglia interruzione dello
								stage, � segnalata alle altre parti della convenzione e
								all'insegnante di riferimento. Se del caso, sar� messa in atto
								dall'istituto di provenienza una procedura di convalida.
								In caso
								di accordo delle parti della convenzione,
								sar� possibile
								effettuare un rapporto finale di stage al fine di
								permettere la
								realizzazione della durata del tirocinio prevista
								inizialmente.
								Tale rapporto sar� da considerare come una
								clausola alla
								convenzione di stage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In caso di prolungamento della sua durata, potr�
								essere stipulata una clausola alla convenzione di stage, su
								richiesta congiunta dell'organismo ospitante del tirocinante,
								nel rispetto della durata massima dello stage fissata dalla
								legge (6 mesi).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Nel caso in cui una delle tre parti (organismo
								ospitante, tirocinante, istituto di provenienza) volesse porre
								fine al tirocinio, sar� necessario che ne informi immediatamente
								le altre due parti per iscritto. Le ragioni riportate saranno
								esaminate in stretta concertazione. La decisione definitiva di
								porre fine allo stage sar� presa soltanto alla fine di questa
								fase di concertazione.
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
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Articolo 10 - Dovere di riservatezza e
								confidenzialit�
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Il dovere di riservatezza � applicato con rigore
								assoluto ed � apprezzato dall'organismo ospitante, conto tenuto
								delle sue proprie specificit�. Il tirocinante si impegna,
								dunque, a non utilizzare in alcun caso le informazioni raccolte
								o ottenute per pubblicarle o comunicarle a terzi, senza
								l'accordo dell'organismo ospitante, compreso il rapporto di
								stage. Tale impegno resta valido non soltanto dello stage ma
								anche dopo la data di fine rapporto. Il tirocinante si impegna a
								non conservare, portare con s�, o effettuare una copia di
								documenti o programmi di qualsiasi natura, di propriet�
								dell'organismo ospitante, tranne in caso di accordo da parte di
								quest'ultimo.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Articolo 10 continuazione)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								Nel quadro della confidenzialit� delle informazioni
								contenute nel rapporto di stage, l'organismo ospitante pu�
								chiedere una restrizione della diffusione del rapporto, nonch�
								il ritiro di alcuni elementi confidenziali.
								I soggetti che ne
								saranno a conoscenza sono obbligati dal segreto professionale al
								non utilizzo e alla non divulgazione delle informazioni
								contenute nel rapporto.
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
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify" background-color="#E6E6E6" font-style="italic">
								Cet
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
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Articolo 11 - Propriet� intellettuale
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Conformemente al Codice della Propriet� Intellettuale
								francese, nel caso in cui le attivit� del tirocinante diano
								luogo a un'opera protetta da diritti d'autore o da propriet�
								industriale (compresi alcuni programmi informatici), se
								l'organismo ospitante desidera utilizzarli e il tirocinante d�
								il proprio accordo, dovr� essere firmato un contratto tra lo
								studente (autore) e l'organismo ospitate.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Il contratto dovr� allora precisare l'estensione dei
								diritti ceduti, l'eventuale esclusivit�, la destinazione, i
								supporti utilizzati e la durata della cessione, come anche, se
								del caso, l'importo della remunerazione dovuta al tirocinante
								per la cessione. Tale clausola si applica a prescindere dallo
								statuto dell'organismo ospitante.
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
								Articolo 12 - Fine dello stage
								- Rapporto - Valutazione
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">Attestati di stage
								</fo:inline>
								: alla fine dello stage, l'organismo ospitante fornisce allo
								studente un attestato il cui modello figura in allegato, facente
								menzione almeno della durata effettiva del tirocinio e, se del
								caso, l'importo della gratificazione percepita. Il tirocinante
								dovr� fornire tale attestato in caso di richiesta postuma di
								apertura dei diritti al regime generale di assicurazione
								vecchiaia previsto dall'art. L.351-17 del Codice di Prevenzione
								Sociale francese;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								El estudiante
								deber� presentar este certificado
								en caso de que solicite
								la
								apertura de derechos al r�gimen general
								del seguro de pensiones
								previsto en el art. L.351-17 del C�digo
								de la Seguridad Social.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								2)
								<fo:inline text-decoration="underline">Qualit� dello stage
								</fo:inline>
								: alla conclusione dello stage, le parti della presente
								convenzione sono invitate a formulare una valutazione sulla
								qualit� dello stage. Il tirocinante trasmette al servizio
								competente dell'istituto di formazione superiore di provenienza
								un documento nel quale valuta la qualit� dell'accoglienza di cui
								ha beneficiano in seno all'organismo ospitante. Tale documento
								non sar� preso in considerazione nella valutazione o
								nell'ottenimento del diploma o della certificazione.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline"> Valutazione dell'attivit�
									del tirocinante
								</fo:inline>
								: al termine dello stage, l'organismo ospitante compila una
								scheda di valutazione dell'attivit� del tirocinante che
								consegner� all'insegnante di riferimento (diversamente precisare
								se scheda annessa o modalit� di valutazione precedentemente
								definite in accordo con l'insegnante di riferimento).
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
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Articolo 12 continuazione)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								4)
								<fo:inline text-decoration="underline">Modalit� di valutazione
									pedagogica :
								</fo:inline>

								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt" padding-bottom="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								<fo:inline text-decoration="underline">NUMERO DI ECTS (se del
									caso) :
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
								5) Il tutor dell'organismo
								ospitante o qualsiasi suo membro chiamato a recarsi presso
								l'istituto di provenienza del tirocinante nel quadro della
								preparazione, svolgimento e convalida dello stage non pu�
								pretendere nessun rimborso o indennizzo da parte dell'istituto
								di formazione.
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
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" background-color="#E6E6E6"
								font-style="italic">
								(Article 12 suite)
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
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Articolo 13 - Diritto applicabile - Tribunali di
								competenza
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La presente
								convenzione � regolata esclusivamente dal diritto francese.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Qualsiasi litigio non
								risolto per via amichevole sar� sottoposto alla competenza della
								giurisdizione francese competente.
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
				<fo:inline font-weight="bold">
					(LUOGO)
				</fo:inline>
				<fo:inline font-style="italic" font-size="8pt">(FAIT �)
				</fo:inline>
				<fo:inline>
					.....................................................
				</fo:inline>
				<fo:inline font-weight="bold">
					IL
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
								PER L'ISTITUTO DI FORMAZIONE
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
												Firmatario il centro di gestione, per delega,
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
										Nome e firma del rappresentante
										d'istituto
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
								PER L'ORGANISMO OSPITANTE
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
										Nome e firma del rappresentante dell'organismo
										ospitante
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
								TIROCINANTE (E IL SUO
								RAPPRESENTANTE LEGALE SE DEL CASO)
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
										Nome e firma
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
								Il tutor di stage
								dell'organismo ospitante
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
										Nome e firma
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
								L'insegnante di
								riferimento del tirocinante
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
										Nome e firma
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
