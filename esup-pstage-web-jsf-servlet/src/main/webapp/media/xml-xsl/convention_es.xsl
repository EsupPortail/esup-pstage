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
			padding-top="0.1cm" font-style="italic" text-decoration="underline"
			font-weight="bold">
			Fichas a adjuntar al Acuerdo :
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
				1) Certificado de pr�cticas
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(p�gina siguiente)
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
				2) Ficha de pr�cticas en el
				extranjero
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(informaci�n sobre
				seguridad social: cleiss.fr; informaci�n por pa�ses:
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
				3) Otros anexos
			</fo:inline>
			<fo:inline font-weight="bold" font-size="8pt">
				(en su caso)
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
								Acuerdo de pr�cticas
								<xsl:text> </xsl:text>
								n�
								<xsl:value-of select="id-convention" />
								entre

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
			Nota: para facilitar la lectura del documento, las
			palabras
			�estudiante en pr�cticas�,
			�profesor referente�, �tutor de
			pr�cticas�,
			�representante legal�
			y �estudiante� se emplean en
			masculino
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
								<fo:inline text-decoration="underline">EL ESTABLECIMIENTO DE
									ENSE�ANZA o DE FORMACI�N
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
								Nombre
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
								Direcci�n
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
								Representado por (firmante del
								acuerdo)
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
													Cargo del representante
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
								Facultad/Instituto
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
								Direcci�n (si fuera diferente a
								la del establecimiento)
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
									EL ORGANISMO DE ACOGIDA
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
								Nombre
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
								Direcci�n
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
								Representado por (nombre del
								firmante del acuerdo)
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
								Cargo del representante
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
								Servicio en el que se realizar�n
								las pr�cticas
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
									Lugar de las pr�cticas (si
									fuera diferente a la direcci�n del
									organismo)
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
							text-align="center">
							<fo:inline font-weight="bold">
								3 -
								<fo:inline text-decoration="underline" font-size="9pt">EL
									ESTUDIANTE EN PR�CTICAS
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
								Apellidos
							</fo:inline>
							<fo:inline font-style="italic" font-size="8pt">(Nom)
							</fo:inline>
							<fo:inline> :
							</fo:inline>
							<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Nombre
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
								Sexo :
							</fo:inline>
							<xsl:value-of select="etudiant/code-sexe" />
							&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
							<fo:inline font-weight="bold">
								Nacido/a el
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
								N�mero de estudiante
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
								Direcci�n
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
							T�TULO
							DE LA FORMACI�N O DEL PLAN DE ESTUDIOS SEGUIDO EN EL
							ESTABLECIMIENTO DE ENSE�ANZA SUPERIOR Y N�MERO DE HORAS (ANUAL O
							SEMESTRAL) :
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
								N�mero de horas
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
								TEMA DE LAS PR�CTICAS
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
								Confidentiel
							</xsl:if>
						</fo:block>
						<fo:block line-height="130%" hyphenate="false" language="fr"
							country="FR" font-size="9pt" font-family="Times New Roman,serif"
							padding-left="0.5cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Fechas :
							</fo:inline>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Del
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
									con interrupci�n del
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
												Representando una
											</fo:inline>
											<fo:inline font-weight="bold"> duraci�n total
											</fo:inline>
											<fo:inline> de :
											</fo:inline>

											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> </xsl:text>
											<xsl:if test="id-unite-duree-exceptionnelle = '1'">
												horas
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '2'">
												d�as
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '3'">
												Semanas
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '4'">
												Meses
											</xsl:if>
											<xsl:if test="id-unite-duree-exceptionnelle = '5'">
												a�o
											</xsl:if>
										</fo:block>
									</xsl:when>
									<xsl:otherwise>
										<fo:block line-height="130%" hyphenate="false"
											language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
											padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											padding-bottom="0.035cm">
											<fo:inline font-weight="bold">
												Que corresponden a
											</fo:inline>
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> horas </xsl:text>
											<fo:inline font-weight="bold">
												de presencia efectiva en el
												organismo de acogida
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
												y que corresponden a
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
											<xsl:text> Meses  </xsl:text>
											<xsl:value-of select="$nbJoursRestants" />
											<xsl:text> d�as </xsl:text>
											<xsl:value-of select="$nbHeuresRestantes" />
											<xsl:text> horas  </xsl:text>
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
										Representando una duraci�n
										total de :
									</fo:inline>
									<xsl:value-of select="duree-stage" />
									<xsl:text> </xsl:text>
									semanas
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
											Repartici�n en caso de
											presencia discontinua
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
											horas a la semana
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
								Comentario
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
							ACOMPA�AMIENTO DEL ESTUDIANTE EN PR�CTICAS POR EL
							ESTABLECIMIENTO DE ENSE�ANZA
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
								Apellidos y nombre del profesor
								referente
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
								Cargo (o disciplina)
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
							ACOMPA�AMIENTO DEL ESTUDIANTE EN PR�CTICAS POR EL
							ORGANISMO DE ACOGIDA
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
								Apellidos y nombre del tutor de
								pr�cticas
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
								Cargo
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
							Seguridad social o
							seguro m�dico principal al que contactar
							en caso de accidente (el
							del
							lugar del domicilio del estudiante salvo excepci�n) :
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
			Fecha de imprenta :
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
								font-weight="bold">Art�culo 1 - Objeto del acuerdo
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El presente acuerdo regula las relaciones del
								organismo de
								acogida con
								el establecimiento de ense�anza superior y
								el
								estudiante en pr�cticas.
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
								Art�culo 2 - Objetivo de las pr�cticas
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Las pr�cticas de formaci�n permiten al estudiante acceder
								de
								manera temporal a un entorno
								profesional en el que adquiere
								competencias profesionales
								y pone en pr�ctica
								los conocimientos
								adquiridos durante su formaci�n con vistas a la
								obtenci�n
								de un
								t�tulo o certificaci�n y para
								favorecer su inserci�n profesional.
								El estudiante en
								pr�cticas recibe una
								o varias
								misiones
								relacionadas con el proyecto pedag�gico
								del
								establecimiento de
								ense�anza
								y aprobadas por el organismo de
								acogida.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El programa de las pr�cticas es dise�ado
								por el
								establecimiento y
								el organismo de acogida seg�n el programa
								general de la formaci�n
								impartida.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">ACTIVIDADES ENCOMENDADAS
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
								<fo:inline text-decoration="underline"> COMPETENCIAS A ADDQUIRIR O
									A DESARROLLAR
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
								Art�culo 3 - Modalidad de las pr�cticas
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La presencia semanal del estudiante
								en pr�cticas en la empresa
								ser� de
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								horas en base a
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when
											test="temps-travail/code-ctrl='TCOMP' or temps-travail/code-ctrl='TPART'">
											<xsl:if test="temps-travail/code-ctrl='TCOMP'">
												tiempo completo.
											</xsl:if>
											<xsl:if test="temps-travail/code-ctrl='TPART'">
												tiempo parcial.
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
								Si el estudiante debe estar presente en el organismo
								de acogida
								por la noche,
								un domingo o un d�a festivo,
								precisar los casos :
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
								font-weight="bold">Art�culo 4 - Acogida y acompa�amiento del estudiante
								en pr�cticas
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El estudiante es seguido por un profesor referente
								nombrado en el
								presente acuerdo,
								as� como por el servicio del
								establecimiento
								encargado de las pr�cticas.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El tutor de las pr�cticas nombrado por el organismo
								de acogida en
								el presente acuerdo
								es responsable del seguimiento del estudiante
								y de
								la optimizaci�n de las condiciones
								de realizaci�n de las
								pr�cticas de acuerdo con las
								estipulaciones pedag�gicas
								definidas.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El estudiante puede volver al establecimiento de ense�anza
								durante el periodo de pr�cticas
								para asistir a ciertas clases
								expl�citamente requeridas
								por el
								programa o participar en
								reuniones; las fechas ser�n
								pertinentemente transmitidas
								al
								organismo de acogida por
								parte del
								establecimiento.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Art�culo 4 continuaci�n)
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt">
								El organismo de
								acogida puede autorizar el desplazamiento del
								estudiante.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Cualquier dificultad que pueda surgir en la realizaci�n o
								desarrollo
								de las pr�cticas, ya sea constatada por
								el estudiante o
								por el
								tutor de pr�cticas, debe ponerse en
								conocimiento del
								profesor referente
								y del establecimiento de ense�anza para ser
								resuelta
								cuanto antes.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="9pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">
									MODALIDADES DE
									ACOMPA�AMIENTO
								</fo:inline>
								(visitas, citas telef�nicas, etc) :
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
								keep-with-next="always" text-align="justify" font-weight="bold">Art�culo
								5 - Gratificaci�n - Beneficios
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								En Francia, si la duraci�n de las pr�cticas es superior a dos
								meses,
								consecutivos o no, estas deben
								ser objeto de una
								gratificaci�n, salvo en caso de normas
								particulares aplicables en
								algunas
								colectividades de ultramar francesas o en las pr�cticas
								enmarcadas en el
								art�culo L4381-1
								del C�digo de Salud P�blica.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El importe horario de la gratificaci�n est� fijado en
								un 15 %
								de la base m�xima horaria de la
								Seguridad Social
								definida en aplicaci�n del art�culo L 241-3
								del C�digo de
								la
								Seguridad Social.
								Se puede establecer un importe superior a este
								porcentaje
								por
								convenio colectivo sectorial
								o por acuerdo
								profesional.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								La gratificaci�n debida por un organismo de derecho
								p�blico
								no puede acumularse a una
								remuneraci�n pagada por este
								mismo organismo
								durante el mismo periodo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								La gratificaci�n se debe sin perjuicio del reembolso
								de los gastos incurridos por
								el estudiante durante las pr�cticas
								y de los
								beneficios que se le ofrezcan,
								en su caso, para comida,
								alojamiento y
								transporte.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El organismo puede establecer una gratificaci�n
								para pr�cticas de
								duraci�n
								inferior o igual a dos meses.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								En caso de suspensi�n
								o ruptura del presente acuerdo,
								la cuant�a de la gratificaci�n
								debida al estudiante se calcula a
								prorrata seg�n
								la duraci�n de
								las pr�cticas efectuadas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La duraci�n con
								derecho a gratificaci�n se determina en
								atenci�n al presente
								acuerdo y a
								sus posibles anexos, as� como al n�mero de d�as de
								presencia efectiva del estudiante
								en pr�cticas en el organismo.
							</fo:block>
							<xsl:variable name="indemnisation" select="id-indemnisation" />
							<xsl:choose>
								<xsl:when test='$indemnisation!=1'>

								</xsl:when>
								<xsl:otherwise>
									<fo:block line-height="130%" hyphenate="false"
										language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
										<fo:inline text-decoration="underline">El IMPORTE DE LA
											GRATIFICACI�N
										</fo:inline>
										se fija en
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
												por
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
												M�todo de pago
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
									OTROS BENEFICIOS ACORDADOS
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
								text-align="justify" font-weight="bold">Art�culo 6 - R�gimen de
								protecci�n social
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Durante el periodo de las pr�cticas, el estudiante
								permanece afiliado a su
								sistema de Seguridad Social anterior.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Las pr�cticas efectuadas en el extranjero deben
								ser
								comunicadas a la Seguridad
								Social antes de la partida del
								estudiante,
								si esta as� lo solicitara.
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
									Gratificaci�n por un importe m�ximo del 15% de la base
									m�xima horaria de la Seguridad Social:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								La gratificaci�n no est� sujeta a cotizaci�n social.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El estudiante disfruta de la legislaci�n sobre a
								ccidentes de trabajo en atenci�n
								al r�gimen de estudiante del
								art�culo L.412-8-2 del
								C�digo de la Seguridad Social.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Si el estudiante sufriera un accidente, bien durante el
								desarrollo
								de su actividad en el organismo,
								bien durante el
								trayecto o en los lugares considerados �tiles
								para las
								necesidades de sus pr�cticas y,
								en el caso de los
								estudiantes en
								medicina, en cirug�a dental
								o en farmacia que no tengan estatus
								de personal de hospital, para las necesidades de las pr�cticas
								en hospital efectuadas en las condiciones
								previstas en b del 2�
								apartado del
								art�culo L. 412-8,
								<fo:inline text-decoration="underline">
									el organismo de acogida
									enviar� la declaraci�n
									de accidente al sistema de seguro m�dico
									principal
								</fo:inline>
								(ver direcci�n en la primera p�gina) donde se
								indicar� al
								establecimiento como empleador, y
								<fo:inline text-decoration="underline">
									enviar una copia de la
									misma al establecimiento de ense�anza
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
									Gratificaci�n superior
								</fo:inline>
								al 15 % de la base m�xima horaria de la Seguridad Social:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Las cotizaciones sociales se calculan en base al
								diferencial entre el importe
								de la gratificaci�n y el 15 % de
								la base
								m�xima horaria de la
								Seguridad Social. El estudiante se
								beneficia de la cobertura
								legal
								en aplicaci�n de las disposiciones
								de los art�culos
								L 411-1 y
								siguientes del C�digo de
								la Seguridad
								Social. En el supuesto de
								que el estudiante
								sufriera un accidente,
								bien durante
								el
								desarrollo de su actividad en el organismo, bien
								durante el
								trayecto o en los lugares
								considerados �tiles para las
								necesidades de sus pr�cticas,
								el organismo de acogida efectuar�
								todos
								los tr�mites necesarios respecto al sistema de seguro
								m�dico
								principal e informar� al establecimiento
								lo antes posible.
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
								6.3 - Protecci�n sanitaria del
								estudiante en el extranjero
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">
									Protecci�n derivada del
									r�gimen de estudiante franc�s
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- para las
								pr�cticas dentro del Espacio Econ�mico Europeo (EEE)
								efectuadas
								por nacionales de un pa�s
								miembro de la Uni�n Europea, o de
								Noruega, Islandia, Liechtenstein
								o
								Suiza, o incluso de otro pa�s
								(en este
								�ltimo caso, esta
								disposici�n no se aplica a las
								pr�cticas en
								Dinamarca, Noruega, Islandia,
								Liechtenstein o Suiza),
								el estudiante debe solicitar
								la Tarjeta Sanitaria Europea (TSE).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- para las
								pr�cticas efectuadas en Quebec por los estudiantes de
								nacionalidad francesa, el estudiante
								debe solicitar el formulario
								SE401Q (104 para las pr�cticas en
								empresa, 106 para las pr�cticas
								en universidad).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								- en el resto
								de los casos, los estudiantes que incurran en gastos
								sanitarios
								en el extranjero pueden ser
								reembolsados por la mutua elegida
								como Caja de Seguridad Social
								de
								Estudiantes, una vez de vuelta y
								bajo
								presentaci�n de los
								justificantes correspondientes: el
								reembolso
								se efect�a en base a
								las tarifas sanitarias
								francesas.
								Pueden existir diferencias importantes entre los gastos
								efectuados y las tarifas francesas de base
								de reembolso. Por eso
								es muy recomendable que el estudiante
								suscriba
								un seguro m�dico
								complementario espec�fico,
								v�lido para el pa�s de destino y el
								periodo de las pr�cticas, a trav�s
								del organismo de acogida de su
								elecci�n
								(mutua para los estudiantes, mutua de los padres,
								compa��a privada de
								seguros ad hoc.) o en su caso, y despu�s
								de
								verificar el alcance de las garant�as ofertadas, ante el
								organismo
								de acogida si este proporcionara al estudiante
								cobertura sanitaria en virtud del derecho local (ver 2 m�s
								abajo).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2)
								<fo:inline text-decoration="underline">
									Protecci�n social
									proporcionada por el organismo de acogida
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Al marcar la casilla correspondiente, el organismo de
								acogida
								indica a continuaci�n si proporciona
								cobertura sanitaria
								al estudiante en pr�cticas, en virtud
								del derecho local:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm" text-align="justify">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> SI
								</fo:inline>
								(esta se a�ade a los derechos derivados del r�gimen franc�s
								"estudiante", los cuales se mantienen en el extranjero).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm" text-align="justify">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold"> NO
								</fo:inline>
								(la cobertura es facilitada �nicamente por los derechos
								derivados del r�gimen franc�s "estudiante",
								los cuales se
								mantienen en el extranjero).
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								En caso de no marcarse ninguna casilla, se aplica el
								6.3.1.
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
									Protecci�n Accidentes de
									trabajo del estudiante en el extranjero
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								1)
								<fo:inline text-decoration="underline">Para poder beneficiarse de
									la legislaci�n francesa
								</fo:inline>
								sobre la cobertura de accidentes de trabajo, las presentes
								pr�cticas deben:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- tener una duraci�n m�xima de 6 meses, pr�rrogas
								incluidas;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- no dar lugar a ninguna
								remuneraci�n susceptible de generar
								derechos a la protecci�n
								contra
								accidentes laborales en el pa�s de destino; se admite una
								indemnizaci�n o gratificaci�n de
								un m�ximo de 15 % de la base
								m�xima horaria de la Seguridad
								Social (vid. punto 5), y bajo el
								consentimiento de la Caja
								Primaria de Seguro M�dico respecto
								a la
								solicitud de
								mantenimiento de derecho;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- desarrollarse �nicamente en
								el organismo signatario del presente acuerdo;
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- desarrollarse �nicamente en
								el pa�s extranjero citado.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								Cuando no se
								cumplan estas condiciones, el organismo de acogida
								se compromete
								a cotizar para la
								protecci�n del estudiante en pr�cticas y a
								hacer las declaraciones
								necesarias en caso de accidente de
								trabajo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								2)
								<fo:inline text-decoration="underline">
									La declaraci�n de los
									accidentes de trabajo
								</fo:inline>
								concierne al establecimiento de ense�anza que debe
								ser informado
								por escrito en
								un plazo de 48 horas por el organismo de acogida.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								3)
								<fo:inline text-decoration="underline">La cobertura abarca los
									accidentes acontecidos:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- En el
								recinto del lugar de las pr�cticas y durante las horas de
								pr�cticas,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- Durante
								el trayecto de ida y vuelta habitual entre la residencia
								del
								estudiante en pr�cticas en el
								territorio extranjero y el lugar de
								las pr�cticas,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- En el
								contexto de una misi�n encomendada por el organismo
								de acogida
								del estudiante y
								obligatoriamente recogida por orden de misi�n,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- durante
								el trayecto para ir de su domicilio al lugar de
								su residencia
								durante las pr�cticas
								(desplazamiento al inicio de las
								pr�cticas),
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt" padding-bottom="2pt">
								- durante
								el trayecto de vuelta desde su residencia
								durante las pr�cticas a
								su domicilio personal.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4)
								<fo:inline text-decoration="underline"> En caso de que una sola
									condici�n de
									las previstas en el punto 6.4.1.
								</fo:inline>
								no se cumpla, el organismo de acogida se compromete por el
								presente acuerdo a cubrir al
								estudiante en pr�cticas contra el
								riesgo de accidente de
								trabajo, de trayecto y enfermedades
								profesionales as� como encargarse de
								todas las
								declaraciones
								necesarias.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline text-decoration="underline">5) En cualquiera de los
									casos:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Si el estudiante sufriera un accidente de trabajo
								durante
								las pr�cticas, el organismo de acogida
								debe
								imperativamente se�alar este accidente al establecimiento
								de
								ense�anza de manera inmediata.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								- Si el estudiante cumple
								misiones fuera del organismo de acogida
								o fuera del pa�s de las
								pr�cticas,
								el organismo de acogida debe realizar todos los
								tr�mites
								necesarios para asegurarle adecuadamente.
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
								Art�culo 7 - Responsabilidad y
								seguro
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El organismo de acogida y el estudiante declaran
								estar cubiertos en materia
								de responsabilidad civil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Para las pr�cticas en el extranjero o en
								territorios
								de ultramar
								el estudiante se compromete a suscribir un
								contrato
								de
								asistencia
								en viaje (repatriaci�n sanitaria, asistencia
								jur�dica.) y un contrato
								de seguro individual de accidentes.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de que el organismo de acogida ponga un
								veh�culo
								a disposici�n del estudiante en
								pr�cticas, ser� su
								responsabilidad verificar previamente
								que la p�liza de seguro del
								veh�culo
								cubre la utilizaci�n por un estudiante.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								En caso de que, en el marco de las pr�cticas, el
								estudiante
								utilice su propio veh�culo o un
								veh�culo prestado por
								un tercero, lo declarar� expresamente
								al asegurador
								de dicho
								veh�culo y,
								en su caso, abonar� la prima
								correspondiente.
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
								Art�culo 8 - Disciplina
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El estudiante se somete a la disciplina y a las
								cl�usulas
								del reglamento interior del
								organismo que le son
								aplicables y que son puestas en su
								conocimiento antes
								de empezar
								las pr�cticas, en especial en lo referente a los
								horarios
								y las
								normas de higiene y
								seguridad vigentes en el organismo de
								acogida.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El establecimiento es el �nico que tiene potestad
								para
								decidir cualquier sanci�n
								disciplinaria. En su caso, el
								organismo de
								acogida
								informar� al profesor referente
								y al
								establecimiento de las infracciones
								y, en su caso,
								le
								proporcionar� los
								elementos constitutivos de la infracci�n.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de infracci�n disciplinaria particularmente
								grave,
								el organismo de acogida se
								reserva el derecho de poner
								t�rmino a las pr�cticas de
								conformidad con
								las disposiciones
								fijadas en el art�culo 9 del presente acuerdo.
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
								Art�culo 9 - Ausencias - Interrupci�n de las
								pr�cticas
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								En Francia (salvo
								en caso de normas particulares aplicables
								en algunas
								colectividades
								de ultramar francesas o en organismos de derecho
								p�blico),
								en caso
								de maternidad,
								paternidad o adopci�n, el
								estudiante en pr�cticas disfruta
								de permisos de
								ausencias de
								una
								duraci�n equivalente a las previstas para los
								asalariados
								en los
								art�culos 225-16 al
								L.1225-28,
								L.1225-35,
								L.1225-37,
								L.1225-46
								del
								C�digo de Trabajo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="9pt"
								font-family="Times New Roman,serif" text-align="justify">
								Para las
								pr�cticas de duraci�n superior a dos
								meses y sin que pueda
								superar un m�ximo de 6 meses, los permisos
								de ausencia son
								posibles.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline text-decoration="underline">
									N�MERO DE D�AS DE PERMISO
									AUTORIZADOS
								</fo:inline>
								/ o modalidades de permisos de ausencia durante las pr�cticas:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<xsl:value-of select="nb-conges" />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Para cualquier otra interrupci�n temporal de las
								pr�cticas
								(enfermedad, ausencia injustificada.),
								el organismo de
								acogida deber� informar al responsable del
								establecimiento por
								correo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt" text-align="justify">
								Cualquier interrupci�n de las
								pr�cticas ha de ser comunicada
								a las otras partes del acuerdo
								y al
								profesor referente, instaurando en su caso un proceso
								de
								validaci�n. En caso de conformidad
								de las partes del acuerdo, se
								puede aplazar el final de
								las pr�cticas para permitir la
								realizaci�n de la duraci�n total de
								las pr�cticas previstas
								inicialmente. El aplazamiento
								ser� objeto de un anexo al acuerdo
								de pr�cticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Podr� incorporarse un anexo al acuerdo en caso de
								pr�rroga
								de las pr�cticas a petici�n
								conjunta del organismo de
								acogida y el estudiante,
								dentro de la duraci�n
								m�xima
								de las
								pr�cticas fijadas por ley (6 meses).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de que una de las tres partes (organismo de
								acogida,
								establecimiento, estudiante)
								deseara interrumpir de
								manera definitiva las pr�cticas,
								esta deber�
								informar
								inmediatamente
								a las otras dos partes por escrito. Las razones
								argumentadas
								se examinar�n de manera concertada.
								La decisi�n
								definitiva de
								interrupci�n de las pr�cticas
								se tomar� �nicamente
								tras dicha fase de concertaci�n.
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
								Art�culo 10 - Deber de reserva y confidencialidad
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El deber de reserva es de estricto cumplimiento y
								es
								determinado por el
								organismo de acogida en atenci�n a sus
								particularidades.
								El estudiante en pr�cticas
								se compromete, por lo
								tanto, a no utilizar bajo ninguna
								circunstancia las informaciones
								obtenidas para su publicaci�n o
								comunicaci�n a terceros
								sin previo
								consentimiento del
								organismo de acogida, incluido el informe de
								las
								pr�cticas. Este compromiso no
								solo ser� v�lido durante el
								periodo de las
								pr�cticas
								sino que se extender� tras su
								finalizaci�n. El estudiante se compromete a no conservar,
								llevarse o copiar
								ning�n
								documento o software, independientemente
								de su naturaleza,
								que pertenezca al organismo
								de acogida, salvo
								consentimiento de este
								�ltimo.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								(Art�culo 10 continuaci�n)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								En raz�n de la confidencialidad de las informaciones
								contenidas en el informe,
								el organismo de acogida puede solicitar
								una
								restricci�n de la
								difusi�n del informe o, incluso, la retirada
								de ciertos elementos
								confidenciales. Las personas que accedan a
								dichas informaciones
								est�n obligadas por el secreto profesional
								a
								no divulgar las mismas.
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
								informations recueillies ou obtenues par eux pour
								en faire
								publication, communication � des tiers sans accord
								pr�alable de
								l'organisme d'accueil, y compris le rapport de
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
								Art�culo 11 - Propiedad intelectual
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								De conformidad con el C�digo de Propiedad
								Intelectual,
								si el trabajo del estudiante
								en pr�cticas diera lugar
								a la creaci�n de una
								obra protegida con derechos
								de autor o de
								propiedad industrial
								(software incluido),
								y en cuyo caso, el
								organismo
								de acogida
								deseara utilizarla y el estudiante en
								pr�cticas estuviera de
								acuerdo,
								este �ltimo (el autor) y el
								organismo de acogida
								deber�n
								suscribir un contrato.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En el contrato deber� precisarse el alcance de
								los
								derechos cedidos,
								una posible exclusividad, la finalidad, los
								soportes utilizados y
								la duraci�n de la cesi�n as� como, en su
								caso,
								el importe de la remuneraci�n
								debida al estudiante en
								concepto de
								dicha cesi�n.
								Esta cl�usula se aplica
								independientemente del estatuto del organismo
								de acogida.
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
								Art�culo 12 - Final de las
								pr�cticas - Informe - Evaluaci�n
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1)
								<fo:inline text-decoration="underline">Certificado de pr�cticas
								</fo:inline>
								: Al t�rmino de las pr�cticas, el organismo de acogida
								entregar�
								al estudiante
								un certificado, cuyo modelo se incluye como anexo,
								mencionando al
								menos la
								duraci�n efectiva de las pr�cticas y, en
								su caso,
								la
								cuant�a de la gratificaci�n percibida.
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
								<fo:inline text-decoration="underline">Calidad de las pr�cticas
								</fo:inline>
								: Al t�rmino de las pr�cticas, se invitar� a las partes
								del
								presente acuerdo a formular
								una apreciaci�n sobre la calidad de
								las pr�cticas.
								El estudiante entrega al
								servicio competente del
								establecimiento de ense�anza
								un documento en el
								que
								valora la
								calidad de la acogida recibida en el organismo
								de acogida.
								Este
								documento
								no se tiene en cuenta en su evaluaci�n o en la
								obtenci�n
								del
								diploma o del certificado.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" padding-top="2pt">
								3)
								<fo:inline text-decoration="underline"> Evaluaci�n de la actividad
									del estudiante
								</fo:inline>
								: Al t�rmino de las pr�cticas, el organismo de acogida
								completar� una ficha de
								evaluaci�n de la actividad del estudiante
								en pr�cticas
								que entregar� al
								profesor
								referente (o precisar en
								caso de ficha anexa o
								modalidades de evaluaci�n
								previamente
								acordadas con el profesor referente).
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
								(Art�culo 12 continuaci�n)
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								4)
								<fo:inline text-decoration="underline">Modalidades de evaluaci�n
									pedag�gica : 
								</fo:inline>
								
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt" padding-bottom="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								<fo:inline text-decoration="underline">N�MERO DE CR�DITOS ECTS (en
									su caso):
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
								5) El tutor responsable del
								organismo de acogida o
								cualquier otro miembro del
								organismo de
								acogida que debiera personarse en el
								establecimiento de ense�anza
								para la preparaci�n, el desarrollo y la validaci�n
								de las
								pr�cticas no puede aspirar
								a ning�n tipo de pago o
								indemnizaci�n
								por parte del
								establecimiento de ense�anza.
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
								Art�culo 13 - Derecho aplicable - Tribunales
								competentes
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								El presente acuerdo
								est� �nicamente regido por el Derecho franc�s.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Cualquier litigio no
								resuelto por v�a amistosa se
								someter� la jurisdicci�n
								de los
								juzgados y tribunales franceses competentes.
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
					HECHO EN
				</fo:inline>
				<fo:inline font-style="italic" font-size="8pt">(FAIT �)
				</fo:inline>
				<fo:inline>
					.....................................................
				</fo:inline>
				<fo:inline font-weight="bold">
					EL
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
								POR EL ESTABLECIMIENTO DE
								ENSE�ANZA
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
												Signatario del centro de gesti�n, por delegaci�n,
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
										Nombre y firma del representante
										del establecimiento
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
								POR EL ORGANISMO DE ACOGIDA
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
										Nombre y firma del representante del organismo de
										acogida
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
								ESTUDIANTE EN PR�CTICAS
								(Y SU REPRESENTANTE LEGAL EN SU CASO)
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
										Nombre y firma
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
								El tutor de pr�cticas
								del organismo de acogida
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
										Nombre y firma
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
								El profesor referente
								del estudiante en pr�cticas
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
										Nombre y firma
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
			<fo:block text-align="center" hyphenate="false" language="fr"
				country="FR" font-weight="bold" font-size="18pt">
				CERTIFICADO DE PR�CTICAS
			</fo:block>
			<fo:block text-align="center" line-height="110%"
				padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
				font-size="10pt" font-family="Times New Roman,serif" font-style="italic">
				(ATTESTATION DE STAGE )
			</fo:block>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif">
				<fo:leader />
			</fo:block>
			<fo:block text-align="center" padding-top="5pt" hyphenate="false"
				language="fr" country="FR" font-weight="bold" font-size="16pt"
				font-style="italic">
				a entregar al
				estudiante al finalizar las pr�cticas
			</fo:block>
			<fo:block text-align="center" line-height="110%"
				padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
				font-size="10pt" font-family="Times New Roman,serif" font-style="italic">
				(�
				remettre au
				stagiaire � l'issue du
				stage)
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
										ORGANISMO DE ACOGIDA
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
										Nombre o Denominaci�n social
									</fo:inline>
									<fo:inline font-size="8pt" font-style="italic">
										(Nom ou
										D�nomination sociale)
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
									<fo:inline font-weight="bold">Direcci�n
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
									<fo:inline font-weight="bold">Tel : </fo:inline>
									<xsl:value-of select="structure/telephone" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block padding="0.1cm" font-weight="bold">
					<fo:inline font-size="9pt" font-weight="bold">
						Certifica que
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
										EL ESTUDIANTE
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
										Apellidos
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Nom)
									</fo:inline>
									<fo:inline font-weight="bold">
										:
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Nombre
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Pr�nom)
									</fo:inline>
									<fo:inline font-weight="bold">
										:
									</fo:inline>
									<fo:inline>
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="etudiant/prenom" />
											</xsl:with-param>
										</xsl:call-template>
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Sexo :
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="etudiant/code-sexe" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Nacido/a el
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(N�
										le)
									</fo:inline>
									<fo:inline font-weight="bold">
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
										Direcci�n
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Adresse)
									</fo:inline>
									<fo:inline font-weight="bold">
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
									<fo:inline font-weight="bold">
										Tel :
									</fo:inline>
									<xsl:value-of select="tel-etudiant" />
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Tel m�vil :
									</fo:inline>
									<xsl:value-of select="tel-portable-etudiant" />
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										E-mail :
									</fo:inline>
									<xsl:value-of select="etudiant/mail" />
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
										QUE
										CURSA
									</fo:inline>
									<fo:inline>
										(nombre de la formaci�n o del plan de ense�anza
										superior seguido por el o la estudiante) :
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
										EN
									</fo:inline>
									<fo:inline>
										(nombre del establecimiento de ense�anza superior o
										del organismo de formaci�n)
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
									<fo:inline font-weight="bold">
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
				<fo:block padding="0.3cm" margin-left="0.1cm">
					<fo:inline font-weight="bold" font-size="11pt">
						ha realizado unas
						pr�cticas previstas en el marco de sus estudios
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
									<fo:inline font-size="11pt" font-weight="bold"
										text-decoration="underline">
										DURACI�N DE LAS PR�CTICAS
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
										Fechas de inicio y de fin de
										las pr�cticas
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
										Del
									</fo:inline>
									<fo:inline font-style="italic" font-size="8pt">
										(Du)
									</fo:inline>
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										Al
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
										<fo:inline font-weight="bold">
											con interrupci�n del
										</fo:inline>
										<fo:inline font-style="italic" font-size="8pt">(avec
											interruption du)
										</fo:inline>
										<xsl:text> </xsl:text>
										......................................
										<fo:inline font-weight="bold">
											al
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
										Representan una
										duraci�n total
										de
									</fo:inline>
									<fo:inline>
										..................... (N� de meses / N� de semanas)
										(tachar la menci�n in�til)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" font-style="italic">
									<fo:inline>
										(Repr�sentant une dur�e totale de)
										<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
										((Nombre de Mois / Nombre de Semaines) (rayer la mention
										inutile))
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell padding-top="0.2cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
									padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
									padding-bottom="0.035cm" margin-left="0.5cm" text-align="justify">
									La
									duraci�n total de las pr�cticas se computa teniendo en cuenta
									la presencia efectiva del
									estudiante en el organismo, sin
									perjuicio del derecho a
									las ausencias
									previstas
									en el art�culo
									L.124-13 del C�digo de la Educaci�n
									(art. L.124-18 del C�digo de
									la Educaci�n). Cada periodo de como
									m�nimo 7 horas de presencia,
									consecutivas o no, equivale a
									un d�a de pr�cticas y cada per�odo
									de c�mo m�nimo 22 d�as de
									presencia, consecutivos o
									no, es
									considerado como equivalente a un mes.
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
										CUANT�A DE LA GRATIFICACI�N PAGADA AL ESTUDIANTE
									</fo:inline>
									<fo:inline font-size="8pt">
										(MONTANT DE LA GRATIFICATION
										VERS�E AU STAGIAIRE)
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									padding-top="0.2cm">
									El estudiante ha recibido una gratificaci�n de pr�cticas de una
									<fo:inline font-weight="bold"> cuant�a total
									</fo:inline>
									de ..................................
									&#8364;
								</fo:block>
								<fo:block line-height="110%" language="fr" country="FR"
									font-size="8pt" font-family="Times New Roman,serif"
									padding-top="0.035cm" font-style="italic">
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
										El certificado de pr�cticas
									</fo:inline>
									es indispensable para que, previo pago de una cotizaci�n,
									se
									pueda tener en cuenta
									las pr�cticas en los derechos a la
									jubilaci�n.
									La legislaci�n sobre
									jubilaciones (Ley n� 2014-40 de
									20 de enero
									de 2014) otorga a los estudiantes
									<fo:inline font-weight="bold">
										cuyas pr�cticas han sido
										objeto de gratificaci�n
									</fo:inline>
									la posibilidad de validarlas, con un
									<fo:inline font-weight="bold">m�ximo de dos trimestres,
									</fo:inline>
									a condici�n de pagar una cotizaci�n.
									<fo:inline font-weight="bold">El estudiante debe hacer la
										solicitud en los dos a�os
									</fo:inline>
									siguientes a la finalizaci�n de las pr�cticas
									<fo:inline font-weight="bold">debiendo presentar
										obligatoriamente el certificado de pr�cticas
									</fo:inline>
									indicando la duraci�n total de las mismas y la
									cuant�a total de
									la
									gratificaci�n percibida. Solicitar informaci�n
									exacta sobre la
									cotizaci�n a abonar y el procedimiento a seguir
									a la Seguridad
									Social
									(C�digo de la Seguridad social art.
									L.351-17
									-C�digo de la
									Educaci�n art.D.124-9).
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
										HECHO EN
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
										EL
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
									Nombre, cargo y firma del representante del
									organismo de acogida
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