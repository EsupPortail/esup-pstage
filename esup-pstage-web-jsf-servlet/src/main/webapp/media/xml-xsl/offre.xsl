<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes="java">

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
						country="FR" font-size="12pt" font-family="Times New Roman,serif"
						text-align="end">
						<fo:inline font-size="8pt">
							<fo:page-number />
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
						<xsl:apply-templates select="offre-dTO" />
					</fo:block>

				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>

	<!-- definition du noeud avenant -->
	<xsl:template match="offre-dTO">
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

		<fo:block padding-top="15pt">
			<xsl:call-template name="infosOffre" />
		</fo:block>

	</xsl:template>

	<!-- entete logo/ -->
	<xsl:template name="entete">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm" font-weight="bold">

			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell>
							<fo:block>
								<xsl:choose>
									<xsl:when test="document('config.xml')/config/logoUniversiteOffre">
										<fo:external-graphic width="3cm" height="1cm">
											<xsl:attribute name="src">
												<xsl:value-of
												select="document('config.xml')/config/logoUniversiteOffre" />
											</xsl:attribute>
										</fo:external-graphic>
									</xsl:when>
									<xsl:otherwise>
										<xsl:choose>
											<xsl:when test="document('config.xml')/config/logoUniversite">
												<fo:external-graphic width="3cm" height="1cm">
													<xsl:attribute name="src">
														<xsl:value-of
														select="document('config.xml')/config/logoUniversite" />
													</xsl:attribute>
												</fo:external-graphic>
											</xsl:when>
											<xsl:otherwise>

											</xsl:otherwise>
										</xsl:choose>
									</xsl:otherwise>
								</xsl:choose>
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
								country="FR" font-size="12pt">
								<xsl:value-of select="centre-gestion/nom-centre" />
							</fo:block>
							<fo:block width="3.493cm" line-height="110%" language="fr"
								country="FR" font-size="12pt">
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

							<fo:block width="3.493cm" line-height="110%" language="fr"
								country="FR" font-size="12pt">
								Tél :
								<xsl:value-of select="centre-gestion/telephone" />
							</fo:block>
							<fo:block width="3.493cm" line-height="110%" language="fr"
								country="FR" font-size="12pt">
								Courriel :
								<xsl:value-of select="centre-gestion/mail" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>

	<xsl:template name="infosOffre">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%" border="2px solid #e6e6e6">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />

				<fo:table-body padding-left="5pt">
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="14pt" font-family="Times New Roman,serif"
								font-weight="bold" text-decoration="underline">
								Titre de l'offre :
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								font-weight="bold">
								<xsl:value-of select="intitule" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Réf. de l'offre
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="@id-offre" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Année Universitaire
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="annee-universitaire" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Date de diffusion
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of
									select="concat(substring(./date-diffusion,9,2),'/',substring(./date-diffusion,6,2), '/',substring(./date-diffusion,1,4))" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Date limite de diffusion
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of
									select="concat(substring(./date-fin-diffusion,9,2),'/',substring(./date-fin-diffusion,6,2), '/',substring(./date-fin-diffusion,1,4))" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Réf. de l'offre au sein de
								l'établissement d'accueil :
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="reference-offre-etablissement" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="14pt" font-family="Times New Roman,serif"
								font-weight="bold" text-decoration="underline">
								Etablissement d'accueil
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:text> </xsl:text>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Raison
								sociale
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="structure/raison-sociale" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Type
								d'établissement
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="structure/type-structure/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Effectif
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="structure/effectif/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Numéro de
								Siret
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="structure/numero-siret" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Adresse de l'établissement
								d'accueil
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
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
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="14pt" font-family="Times New Roman,serif"
								font-weight="bold" text-decoration="underline">
								Poste
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:text> </xsl:text>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Mission(s) :
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="description" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Domaine de l'offre :
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="fap-n1/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Type d'offre :
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="type-offre/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<xsl:if test="(@avec-fichier = 'false') and (@avec-lien = 'false')">
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Début de la mission
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="mois-debut" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="annee-debut" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Précision sur le début de la
									mission
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="precision-debut" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Durée de la mission
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="@duree" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="unite-duree/libelle" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</xsl:if>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Lieu
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Code postal :
								<xsl:value-of select="lieu-code-postal" />
								<xsl:text>  Commune : </xsl:text>
								<xsl:value-of select="lieu-commune" />
								<xsl:text> Pays :  </xsl:text>
								<xsl:value-of select="lieu-pays/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<xsl:if test="(@avec-fichier = 'false') and (@avec-lien = 'false')">
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Déplacement à prévoir
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@deplacement = 'true'">
										<xsl:text> oui </xsl:text>
									</xsl:if>
									<xsl:if test="@deplacement = 'false'">
										<xsl:text> non </xsl:text>
									</xsl:if>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Permis nécessaire
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@permis = 'true'">
										<xsl:text> oui </xsl:text>
									</xsl:if>
									<xsl:if test="@permis = 'false'">
										<xsl:text> non </xsl:text>
									</xsl:if>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Indemnité
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@remuneration = 'true'">
										<xsl:text> oui </xsl:text>
									</xsl:if>
									<xsl:if test="@remuneration = 'false'">
										<xsl:text> non </xsl:text>
									</xsl:if>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Précisions sur l'indemnité
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="precision-remuneration" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Avantages
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="avantages" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Temps de travail
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="temps-travail/libelle" />

								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Commentaire(s) sur le temps de
									travail
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="commentaire-temps-travail" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									observations
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="observations" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</xsl:if>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="14pt" font-family="Times New Roman,serif"
								font-weight="bold" text-decoration="underline">
								Candidat
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:text> </xsl:text>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:text> </xsl:text>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@est-prio-eRQTH = 'true'">
									<xsl:text> L'offre est prioritaire aux étudiants ayant une Reconnaissance de Qualification de Travailleur Handicapé. </xsl:text>
								</xsl:if>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:text> </xsl:text>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@est-access-eRQTH = 'true'">
									<xsl:text> L'offre est accessible aux étudiants ayant une Reconnaissance de Qualification de Travailleur Handicapé. </xsl:text>
								</xsl:if>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell background-color="#e6e6e6"
							text-align="left">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Niveau de formation souhaité à
								partir de :
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:value-of select="niveau-formation/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<xsl:if test="(@avec-fichier = 'false') and (@avec-lien = 'false')">
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Compétence(s) souhaitée(s)
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="competences" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>

						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="14pt" font-family="Times New Roman,serif"
									font-weight="bold" text-decoration="underline">
									Pour postuler
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:text> </xsl:text>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Modalité(s) de réponse :
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="modes-candidature/libelle" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Contact pour candidater
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-nom-contact-cand = 'false'">
										<xsl:value-of select="contact-cand/civilite/libelle" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="contact-cand/prenom" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="contact-cand/nom" />
									</xsl:if>

								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-nom-contact-cand = 'false'">
										Fonction :
										<xsl:value-of select="contact-cand/fonction" />
									</xsl:if>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-tel-contact-cand = 'false'">
										Tél :
										<xsl:value-of select="contact-cand/tel" />
									</xsl:if>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-mail-contact-cand = 'false'">
										Mail :
										<xsl:value-of select="contact-cand/mail" />
									</xsl:if>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell background-color="#e6e6e6"
								text-align="left">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									Contact pour s'informer
								</fo:block>
							</fo:table-cell>
							<fo:table-cell text-align="left" padding-left="5pt">
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-nom-contact-info = 'false'">
										<xsl:value-of select="contact-info/civilite/libelle" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="contact-info/prenom" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="contact-info/nom" />
									</xsl:if>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-nom-contact-info = 'false'">
										Fonction :
										<xsl:value-of select="contact-info/fonction" />
									</xsl:if>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-tel-contact-info = 'false'">
										Tél :
										<xsl:value-of select="contact-info/tel" />
									</xsl:if>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="@cacher-mail-contact-info = 'false'">
										Mail :
										<xsl:value-of select="contact-info/mail" />
									</xsl:if>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</xsl:if>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<xsl:if test="(@avec-fichier = 'true') or (@avec-lien = 'true')">
			<fo:block line-height="110%" padding-top="5pt"
				padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
				font-size="14pt" font-family="Times New Roman,serif" font-weight="bold"
				text-decoration="underline">
				Un fichier ou un lien est fourni avec cette offre.
			</fo:block>
		</xsl:if>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="8pt" font-family="Times New Roman,serif"
			padding-top="5pt">
			offre imprimée le :
			<xsl:value-of
				select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())" />
		</fo:block>
		<fo:block id="theEnd" />
	</xsl:template>
</xsl:stylesheet>