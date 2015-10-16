<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" xmlns:str="http://exslt.org/strings"
	exclude-result-prefixes="java">


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
						<xsl:apply-templates select="avenant-dTO" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>

	<!-- definition du noeud convention -->
	<xsl:template match="avenant-dTO">
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
			<xsl:call-template name="titre" />
		</fo:block>
		<fo:block padding-top="8pt">
			<xsl:call-template name="avenant" />
		</fo:block>
		<fo:block padding-top="8pt">
			<xsl:call-template name="infosAvenant" />
		</fo:block>

		<fo:block>
			<xsl:call-template name="Fait" />
		</fo:block>
	</xsl:template>

	<!-- entete logo/ annee universitaire -->
	<xsl:template name="entete">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm" font-weight="bold">
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
									<xsl:when test="convention/centre-gestion/fichier/nom-fichier">
										<xsl:variable name="cheminLogo"
											select="document('config.xml')/config/uploadFiles.logosCentre.path" />
										<xsl:variable name="logo"
											select="convention/centre-gestion/fichier/nom-fichier" />
										<fo:external-graphic height="1cm">
											<xsl:attribute name="src">
												<xsl:value-of select="$cheminLogo" /><xsl:value-of
												select="convention/centre-gestion/fichier/@id-fichier" />_<xsl:value-of
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
								country="FR" font-size="12pt">
								Ann�e universitaire
								<xsl:value-of select="convention/annee" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
	<!-- partie nom etablissement / titre convention -->
	<xsl:template name="titre">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			padding-top="0.3cm">

			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />

				<fo:table-body border="0.018cm solid #000000" padding="3pt">
					<fo:table-row text-align="left">
						<!-- partie Etablissement Superieur - Stage -->
						<fo:table-cell number-columns-spanned="3"
							padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
							padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Nom de l'�tablissement
									(universit�) :
								</fo:inline>
								<xsl:choose>
									<xsl:when test="convention/nom-etab-ref">
										<xsl:value-of select="convention/nom-etab-ref" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="document('config.xml')/config/nomUniversite" />
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Adresse :
								</fo:inline>
								<xsl:choose>
									<xsl:when test="convention/adresse-etab-ref">
										<xsl:value-of select="convention/adresse-etab-ref" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of
											select="document('config.xml')/config/adresseUniversite" />
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Repr�sent� par : (nom du (de
									la) signataire de la convention) :
								</fo:inline>
								<xsl:choose>
									<xsl:when test="convention/nom-signataire-composante">
										<xsl:value-of select="convention/nom-signataire-composante" />
									</xsl:when>
									<xsl:otherwise>

									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Qualit� du repr�sentant :
								</fo:inline>
								<xsl:choose>
									<xsl:when test="convention/qualite-signataire">
										<xsl:value-of select="convention/qualite-signataire" />
									</xsl:when>
									<xsl:otherwise>
										.....................................
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Composante /UFR/
								</fo:inline>
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/centre-gestion/nom-centre" />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-weight="bold">
									Adresse : (si diff�rente de
									celle de l'universit�)
								</fo:inline>
								<xsl:value-of select="convention/centre-gestion/batiment-residence" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/centre-gestion/voie" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/centre-gestion/code-postal" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/centre-gestion/commune" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/centre-gestion/town-center" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm">
								<fo:inline font-weight="bold">
									T�l :
								</fo:inline>
								<xsl:value-of select="convention/centre-gestion/telephone" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm">
								<fo:inline font-weight="bold">
									Fax :
								</fo:inline>
								<xsl:value-of select="convention/centre-gestion/fax" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm">
								<fo:inline font-weight="bold">
									Mail :
								</fo:inline>
								<xsl:value-of select="convention/centre-gestion/mail" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>
	<!-- partie pr�liminaire -->
	<xsl:template name="avenant">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="16pt" font-family="Times New Roman,serif"
							text-align="center" font-weight="bold" text-decoration="underline">
							Avenant n�
							<xsl:value-of select="id-avenant" />
							<xsl:text> </xsl:text>
							� la convention de stage n�
							<xsl:value-of select="id-convention" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>

			</fo:table-body>
		</fo:table>
	</xsl:template>
	<!-- partie Avenant - Stage -->
	<xsl:template name="infosAvenant">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row text-align="left">
					<fo:table-cell>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="12pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm" font-weight="bold">
							Le pr�sent
							avenant vise �
							modifier le d�roulement du stage qui avait �t�
							convenu entre :
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell border="0.018cm solid #000000"
						padding="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nom de l'organisme d'accueil :
							</fo:inline>
							<xsl:value-of select="convention/structure/raison-sociale" />
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Adresse :
							</fo:inline>
							<xsl:value-of select="convention/structure/batiment-residence" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/structure/voie" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/structure/code-postal" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/structure/commune" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/structure/pays/libelle" />
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:value-of select="convention/structure/telephone" />
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Fax :
							</fo:inline>
							<xsl:value-of select="convention/structure/fax" />
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:value-of select="convention/structure/mail" />
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Repr�sent� par : (nom du
								signataire de la convention) :
							</fo:inline>
							<xsl:value-of select="convention/signataire/civilite/libelle" />
							<xsl:text> </xsl:text>
							<xsl:value-of
								select="translate(convention/signataire/nom,$lowers,$uppers)" />
							<xsl:text> </xsl:text>
							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="convention/signataire/prenom" />
								</xsl:with-param>
							</xsl:call-template>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Qualit� du repr�sentant :
							</fo:inline>
							<xsl:value-of select="convention/signataire/fonction" />
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Nom du tuteur professionnel :
							</fo:inline>
							<xsl:if test="@modification-salarie = 'true'">
								<xsl:value-of select="contact/civilite/libelle" />
								<xsl:text> </xsl:text>
								<xsl:value-of
									select="translate(contact/nom,$lowers,$uppers)" />
								<xsl:text> </xsl:text>
								<xsl:call-template name="start_upper">
									<xsl:with-param name="prenom">
										<xsl:value-of select="contact/prenom" />
									</xsl:with-param>
								</xsl:call-template>
							</xsl:if>
							<xsl:if test="@modification-salarie = 'false'">
								<xsl:value-of select="convention/contact/civilite/libelle" />
								<xsl:text> </xsl:text>
								<xsl:value-of
									select="translate(convention/contact/nom,$lowers,$uppers)" />
								<xsl:text> </xsl:text>
								<xsl:call-template name="start_upper">
									<xsl:with-param name="prenom">
										<xsl:value-of select="convention/contact/prenom" />
									</xsl:with-param>
								</xsl:call-template>
							</xsl:if>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:if test="@modification-salarie = 'true'">
								<xsl:value-of select="contact/tel" />
							</xsl:if>
							<xsl:if test="@modification-salarie = 'false'">
								<xsl:value-of select="convention/contact/tel" />
							</xsl:if>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:if test="@modification-salarie = 'true'">
								<xsl:value-of select="contact/mail" />
							</xsl:if>
							<xsl:if test="@modification-salarie = 'false'">
								<xsl:value-of select="convention/contact/mail" />
							</xsl:if>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="12pt" font-family="Times New Roman,serif"
			padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
			padding-bottom="0.035cm" font-weight="bold">
			et l'
			<xsl:value-of select="document('config.xml')/config/nomUniversite" />
			, repr�sent� par son Pr�sident, agissant pour le compte de :
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row text-align="left">
					<fo:table-cell border="0.018cm solid #000000"
						padding="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Composante/UFR :
							</fo:inline>
							<xsl:value-of select="convention/ufr/libelle" />
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								et sous la responsabilit� de
								l'enseignant r�f�rent :
							</fo:inline>
							<xsl:if test="@modification-enseignant = 'true'">
								<xsl:value-of
									select="translate(enseignant/nom,$lowers,$uppers)" />
								<xsl:text> </xsl:text>
								<xsl:call-template name="start_upper">
									<xsl:with-param name="prenom">
										<xsl:value-of select="enseignant/prenom" />
									</xsl:with-param>
								</xsl:call-template>
							</xsl:if>
							<xsl:if test="@modification-enseignant = 'false'">
								<xsl:value-of
									select="translate(convention/enseignant/nom,$lowers,$uppers)" />
								<xsl:text> </xsl:text>
								<xsl:call-template name="start_upper">
									<xsl:with-param name="prenom">
										<xsl:value-of select="convention/enseignant/prenom" />
									</xsl:with-param>
								</xsl:call-template>
							</xsl:if>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:if test="@modification-enseignant = 'true'">
								<xsl:value-of select="enseignant/tel" />
							</xsl:if>
							<xsl:if test="@modification-enseignant = 'false'">
								<xsl:value-of select="convention/enseignant/tel" />
							</xsl:if>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:if test="@modification-enseignant = 'true'">
								<xsl:value-of select="enseignant/mail" />
							</xsl:if>
							<xsl:if test="@modification-enseignant = 'false'">
								<xsl:value-of select="convention/enseignant/mail" />
							</xsl:if>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="12pt" font-family="Times New Roman,serif"
			padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
			padding-bottom="0.035cm" font-weight="bold">
			et effectu� par :
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row text-align="left">
					<fo:table-cell border="0.018cm solid #000000"
						padding="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<xsl:value-of
								select="translate(convention/etudiant/nom,$lowers,$uppers)" />
							<xsl:text> </xsl:text>
							<xsl:call-template name="start_upper">
								<xsl:with-param name="prenom">
									<xsl:value-of select="convention/etudiant/prenom" />
								</xsl:with-param>
							</xsl:call-template>
							<fo:inline font-weight="bold">
								�tudiant(e) en
							</fo:inline>
							<xsl:value-of select="convention/etape/libelle" />
						</fo:block>
						<fo:block line-height="110%" padding-top="2pt"
							padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
							font-size="10pt" font-family="Times New Roman,serif">
							<fo:inline font-weight="bold">
								Adresse de l'�tudiant :
							</fo:inline>
							<xsl:value-of select="convention/adresse-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/code-postal-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/ville-etudiant" />
							<xsl:text> - </xsl:text>
							<xsl:value-of select="convention/pays-etudiant" />
						</fo:block>
						<fo:block line-height="110%" padding-top="2pt"
							padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
							font-size="10pt" font-family="Times New Roman,serif">
							<fo:inline font-weight="bold">
								T�l :
							</fo:inline>
							<xsl:text> </xsl:text>
							<xsl:value-of select="convention/tel-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Portable :
							</fo:inline>
							<xsl:value-of select="convention/tel-portable-etudiant" />
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								Mail :
							</fo:inline>
							<xsl:value-of select="convention/etudiant/mail" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="9pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="12pt" font-family="Times New Roman,serif"
			padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
			padding-bottom="0.035cm" font-weight="bold">
			pour le motif suivant :
		</fo:block>

		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row text-align="left">
					<fo:table-cell border="0.018cm solid #000000"
						padding="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="10pt" font-family="Times New Roman,serif">
							<fo:inline font-weight="bold">
								Titre :
							</fo:inline>
							<xsl:value-of select="titre-avenant" />
						</fo:block>
						<fo:block line-height="110%" padding-top="2pt" hyphenate="false"
							language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
							font-weight="bold">
							D'un
							commun accord :
						</fo:block>

						<xsl:if test="@rupture = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									Rupture du stage � compter du :
								</fo:inline>
								<xsl:value-of
									select="concat(substring(./date-rupture,9,2),'/',substring(./date-rupture,6,2), '/',substring(./date-rupture,1,4))" />
							</fo:block>
							<fo:block hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="commentaire-rupture!=''">
									Commentaire :
									<fo:inline font-weight="bold">
										<xsl:value-of select="commentaire-rupture" />
									</fo:inline>
								</xsl:if>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-periode = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Le stage initialement pr�vu du
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./convention/date-debut-stage,9,2),'/',substring(./convention/date-debut-stage,6,2), '/',substring(./convention/date-debut-stage,1,4))" />
								</fo:inline>
								au
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./convention/date-fin-stage,9,2),'/',substring(./convention/date-fin-stage,6,2), '/',substring(./convention/date-fin-stage,1,4))" />
								</fo:inline>
								aura lieu du
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
								</fo:inline>
								au
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />
								</fo:inline>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-periode = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">

								<xsl:if test="@interruption-stage = 'true'">
									Interruption de stage :
									<fo:inline font-weight="bold">
										Oui, du
										<xsl:value-of
											select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
										au
										<xsl:value-of
											select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))" />
									</fo:inline>
									<xsl:if test="convention/@interruption-stage = 'false'">
										au lieu de :
										<fo:inline font-weight="bold">
											"pas d'interruption de stage"
										</fo:inline>
									</xsl:if>

									<xsl:if test="convention/@interruption-stage = 'true'">
										au lieu de :
										<fo:inline font-weight="bold">
											interruption pr�vu du
											<xsl:value-of
												select="concat(substring(./convention/date-debut-interruption,9,2),'/',substring(./convention/date-debut-interruption,6,2), '/',substring(./convention/date-debut-interruption,1,4))" />
											au
											<xsl:value-of
												select="concat(substring(./convention/date-fin-interruption,9,2),'/',substring(./convention/date-fin-interruption,6,2), '/',substring(./convention/date-fin-interruption,1,4))" />
										</fo:inline>
									</xsl:if>
								</xsl:if>
								<xsl:if test="@interruption-stage = 'false'">
									<xsl:if test="convention/@interruption-stage = 'true'">
										Interruption de stage :
										<fo:inline font-weight="bold">Non</fo:inline>
										au lieu de :
										<fo:inline font-weight="bold">
											Interruption pr�vu du
											<xsl:value-of
												select="concat(substring(./convention/date-debut-interruption,9,2),'/',substring(./convention/date-debut-interruption,6,2), '/',substring(./convention/date-debut-interruption,1,4))" />
											au
											<xsl:value-of
												select="concat(substring(./convention/date-fin-interruption,9,2),'/',substring(./convention/date-fin-interruption,6,2), '/',substring(./convention/date-fin-interruption,1,4))" />
										</fo:inline>
									</xsl:if>

								</xsl:if>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-sujet = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Le sujet de stage sera remplac� par :
								<fo:inline font-weight="bold">
									<xsl:value-of select="sujet-stage" />
								</fo:inline>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-salarie = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Le tuteur professionnel initialement pr�vu
								<xsl:text> </xsl:text>
								<fo:inline font-weight="bold">
									<xsl:value-of select="convention/contact/civilite/libelle" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(convention/contact/nom,$lowers,$uppers)" />
									<xsl:text> </xsl:text>
									<xsl:call-template name="start_upper">
										<xsl:with-param name="prenom">
											<xsl:value-of select="convention/contact/prenom" />
										</xsl:with-param>
									</xsl:call-template>
								</fo:inline>
								<xsl:text> </xsl:text>
								sera remplac� par :
								<fo:inline font-weight="bold">
									<xsl:value-of select="contact/civilite/libelle" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(contact/nom,$lowers,$uppers)" />
									<xsl:text> </xsl:text>
									<xsl:call-template name="start_upper">
										<xsl:with-param name="prenom">
											<xsl:value-of select="contact/prenom" />
										</xsl:with-param>
									</xsl:call-template>
								</fo:inline>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-enseignant = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								L'enseignant r�f�rent initialement pr�vu
								<xsl:text> </xsl:text>
								<fo:inline font-weight="bold">
									<xsl:value-of select="convention/enseignant/civilite/libelle" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(convention/enseignant/nom,$lowers,$uppers)" />
									<xsl:text> </xsl:text>
									<xsl:call-template name="start_upper">
										<xsl:with-param name="prenom">
											<xsl:value-of select="convention/enseignant/prenom" />
										</xsl:with-param>
									</xsl:call-template>
								</fo:inline>
								<xsl:text> </xsl:text>
								sera remplac� par :
								<fo:inline font-weight="bold">
									<xsl:value-of select="enseignant/civilite/libelle" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(enseignant/nom,$lowers,$uppers)" />
									<xsl:text> </xsl:text>
									<xsl:call-template name="start_upper">
										<xsl:with-param name="prenom">
											<xsl:value-of select="enseignant/prenom" />
										</xsl:with-param>
									</xsl:call-template>
								</fo:inline>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-lieu = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Le stage initialement pr�vu
								<fo:inline font-weight="bold">
									<xsl:value-of select="convention/service/nom" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="convention/service/voie" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="convention/service/code-postal" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="convention/service/commune" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="convention/service/pays/libelle" />
								</fo:inline>
								s'effectuera dans le service :
								<fo:inline font-weight="bold">
									<xsl:value-of select="service/nom" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/voie" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/code-postal" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/commune" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/pays/libelle" />
								</fo:inline>
							</fo:block>
						</xsl:if>

						<xsl:if test="@modification-montant-gratification = 'true'">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Le montant de la gratification sera de :
								<fo:inline font-weight="bold">
									<xsl:value-of select="montant-gratification" />
									<xsl:text> </xsl:text>
<!-- 									euros -->
									<xsl:value-of select="monnaie-gratification" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="unite-gratification/libelle" />
									par
									<xsl:text> </xsl:text>
									<xsl:value-of select="unite-duree-gratification/libelle" />
									<xsl:text>.</xsl:text>
								</fo:inline>
							</fo:block>
						</xsl:if>

						<fo:block hyphenate="false" language="fr" country="FR"
							font-size="10pt" font-family="Times New Roman,serif">
							<xsl:if test="motif-avenant!=''">
								<fo:inline font-weight="bold">
									<xsl:value-of select="motif-avenant" />
								</fo:inline>
							</xsl:if>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="Fait">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">

			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />

				<fo:table-body>

					<!-- partie signature -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2"
							padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
							padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								A ....................................... le
								.......................................
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">

						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline">
								Pour
								l'�tablissement d'enseignement
								sup�rieur :
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="convention/centre-gestion/nom-viseur">
										Par d�l�gation,
										<fo:inline font-weight="bold">
											<xsl:call-template name="start_upper">
												<xsl:with-param name="prenom">
													<xsl:value-of select="convention/centre-gestion/prenom-viseur" />
												</xsl:with-param>
											</xsl:call-template>
											<xsl:text> </xsl:text>
											<xsl:value-of
												select="translate(convention/centre-gestion/nom-viseur,$lowers,$uppers)" />
										</fo:inline>
									</xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
											<xsl:value-of select="convention/nom-signataire-composante" />
										</fo:inline>
									</xsl:otherwise>
								</xsl:choose>
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
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-decoration="underline">
								Pour
								l'organisme d'accueil :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="convention/signataire/nom">
									</xsl:when>
									<xsl:otherwise>
										(Nom et signature du repr�sentant)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:call-template name="start_upper">
										<xsl:with-param name="prenom">
											<xsl:value-of select="convention/signataire/prenom" />
										</xsl:with-param>
									</xsl:call-template>
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(convention/signataire/nom,$lowers,$uppers)" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-bottom="0.1cm"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-decoration="underline">
								Pour
								l'�tudiant :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="convention/etudiant/nom">
									</xsl:when>
									<xsl:otherwise>
										(Nom et signature )
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:call-template name="start_upper">
										<xsl:with-param name="prenom">
											<xsl:value-of select="convention/etudiant/prenom" />
										</xsl:with-param>
									</xsl:call-template>
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(convention/etudiant/nom,$lowers,$uppers)" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" padding-bottom="0.1cm">
								Tuteur
								Organisme
								d'accueil :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-salarie = 'false'">
									<xsl:choose>
										<xsl:when test="convention/contact/nom">
										</xsl:when>
										<xsl:otherwise>
											(Nom et signature du repr�sentant)
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>
								<xsl:if test="@modification-salarie = 'true'">
									<xsl:choose>
										<xsl:when test="contact/nom">
										</xsl:when>
										<xsl:otherwise>
											(Nom et signature du repr�sentant)
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-salarie = 'true'">
									<fo:inline font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="contact/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of
											select="translate(contact/nom,$lowers,$uppers)" />
									</fo:inline>
								</xsl:if>
								<xsl:if test="@modification-salarie = 'false'">
									<fo:inline font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="convention/contact/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of
											select="translate(convention/contact/nom,$lowers,$uppers)" />
									</fo:inline>
								</xsl:if>
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
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" padding-bottom="0.1cm">
								Tuteur
								Etablissement
								d'enseignement
								sup�rieur :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-enseignant = 'true'">
									<xsl:choose>
										<xsl:when test="enseignant/nom">
										</xsl:when>
										<xsl:otherwise>
											(Nom et signature du repr�sentant)
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>
								<xsl:if test="@modification-enseignant = 'false'">
									<xsl:choose>
										<xsl:when test="convention/enseignant/nom">
										</xsl:when>
										<xsl:otherwise>
											(Nom et signature du repr�sentant)
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-enseignant = 'true'">
									<fo:inline font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="enseignant/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of
											select="translate(enseignant/nom,$lowers,$uppers)" />
									</fo:inline>
								</xsl:if>
								<xsl:if test="@modification-enseignant = 'false'">
									<fo:inline font-weight="bold">
										<xsl:call-template name="start_upper">
											<xsl:with-param name="prenom">
												<xsl:value-of select="convention/enseignant/prenom" />
											</xsl:with-param>
										</xsl:call-template>
										<xsl:text> </xsl:text>
										<xsl:value-of
											select="translate(convention/enseignant/nom,$lowers,$uppers)" />
									</fo:inline>
								</xsl:if>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2"
							padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
							padding-right="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								_____________________________________________
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif"
								padding-top="5pt">
								avenant imprim�e le :
								<xsl:value-of
									select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())" />
								Exemplaire destin� � : organisme d'accueil / �tablissement
								d'origine / �tudiant.
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
		<fo:block id="theEnd" />
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