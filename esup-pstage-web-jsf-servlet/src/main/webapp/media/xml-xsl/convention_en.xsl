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
						<xsl:apply-templates select="convention-dTO" />
					</fo:block>

				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>

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
		<fo:block padding-top="8pt">
			<xsl:call-template name="AnnexeArticlesPage4" />
		</fo:block>
		<fo:block break-after="page" />
		<fo:block>
			<xsl:call-template name="Charte" />
		</fo:block>
		<fo:block>
			<xsl:choose>
				<xsl:when test="document('config.xml')/config/triptik">
					<xsl:call-template name="triptik" />
				</xsl:when>
			</xsl:choose>
		</fo:block>

	</xsl:template>
	<xsl:include href="triptik.xsl" />


	<xsl:template name="AnnexeArticlesPage4">
		<fo:block width="100%">
			<fo:table table-layout="fixed" width="100%" border="0.018cm solid #000000">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2"
							padding-top="1pt" padding-bottom="1pt" padding-left="5pt"
							padding-right="5pt">
							<fo:block line-height="100%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif"
								padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
								padding-bottom="0.035cm">
								<fo:inline font-size="9pt" font-weight="bold"
									text-decoration="underline">
									Appendix 1 :
								</fo:inline>
								<fo:inline font-size="9pt">
									internship charter /
								</fo:inline>
								<fo:inline font-size="9pt" font-weight="bold"
									text-decoration="underline">
									Appendix 2 :
								</fo:inline>
								<fo:inline font-size="9pt">
									evaluation forms /
								</fo:inline>
								<fo:inline font-size="9pt" font-weight="bold"
									text-decoration="underline">
									Appendix 3:
								</fo:inline>
								<fo:inline font-size="9pt">
									to be provided by the student:
									certificate of civil liability
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
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
								Academic year
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
						<fo:block line-height="110%" padding-top="5pt" hyphenate="false"
							language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							text-align="center">
							<fo:inline font-weight="bold">
								INTERNSHIP CONTRACT
								<xsl:value-of select="type-convention/libelle" />
								<xsl:text> </xsl:text>
								n°
								<xsl:text> </xsl:text>
								<xsl:value-of select="id-convention" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="8pt" font-family="Times New Roman,serif">
							<fo:leader />
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							text-align="center">
							<fo:inline font-weight="bold">BETWEEN</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<!-- partie Infos Etudiant - Stage -->
	<xsl:template name="infosEtuStage">

		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(0.5)" />
			<fo:table-column column-width="proportional-column-width(0.5)" />
			<fo:table-column column-width="proportional-column-width(1)" />

			<fo:table-body>
				<fo:table-row margin-top="20px" text-align="left">
					<!-- partie Etablissement Superieur - Stage -->
					<fo:table-cell number-columns-spanned="3"
						padding-top="3pt" padding-bottom="3pt" padding-left="5pt"
						padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								The higher education institution
								:
							</fo:inline>
						</fo:block>

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Name of institution :
							<fo:inline font-weight="bold">
								<xsl:choose>
									<xsl:when test="nom-etab-ref">
										<xsl:value-of select="nom-etab-ref" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="document('config.xml')/config/nomUniversite" />
									</xsl:otherwise>
								</xsl:choose>
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Address :
							<fo:inline font-weight="bold">
								<xsl:choose>
									<xsl:when test="adresse-etab-ref">
										<xsl:value-of select="adresse-etab-ref" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of
											select="document('config.xml')/config/adresseUniversite" />
									</xsl:otherwise>
								</xsl:choose>
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Represented by :
							<fo:inline font-weight="bold">
								<xsl:choose>
									<xsl:when test="nom-signataire-composante">
										<xsl:value-of select="nom-signataire-composante" />
									</xsl:when>
									<xsl:otherwise>

									</xsl:otherwise>
								</xsl:choose>
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Job title :
							<fo:inline font-weight="bold">
								<xsl:choose>
									<xsl:when test="qualite-signataire">
										<xsl:value-of select="qualite-signataire" />
									</xsl:when>
									<xsl:otherwise>
										.....................................
									</xsl:otherwise>
								</xsl:choose>
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Department/Faculty
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="centre-gestion/nom-centre" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm">
							Address: (if different from address of institution)
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
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm">
							Tel :
							<xsl:value-of select="centre-gestion/telephone" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm">
							Fax :
							<xsl:value-of select="centre-gestion/fax" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm">
							E-mail :
							<xsl:value-of select="centre-gestion/mail" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<!-- partie Entreprise ou organisme accueil -->
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="3"
						padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
						padding-right="5pt">

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								The host organisation :
							</fo:inline>
						</fo:block>

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Name :
							<fo:inline font-weight="bold">
								<xsl:value-of select="structure/raison-sociale" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Address :
							<fo:inline font-weight="bold">
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

					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Tel :
							<xsl:value-of select="structure/telephone" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Fax :
							<xsl:value-of select="structure/fax" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							E-mail :
							<xsl:value-of select="structure/mail" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="3"
						padding-left="5pt" padding-right="5pt">

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Represented by : (name of person signing contract) :
							<fo:inline font-weight="bold">
								<xsl:value-of select="signataire/civilite/libelle" />
								<xsl:text> </xsl:text>
								<xsl:value-of
									select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÃ€ÃÃ‚ÃƒÃ„Ã…Ã†Ã‡ÃˆÃ‰ÃŠÃ‹ÃŒÃÃŽÃÃÃ‘Ã’Ã“Ã”Ã•Ã–Ã˜Ã™ÃšÃ›ÃœÃÃžÃŸÃ€ÃÃ‚ÃƒÃ„Ã…Ã†Ã‡ÃˆÃ‰ÃŠÃ‹ÃŒÃÃŽÃÃÃ‘Ã’Ã“Ã”Ã•Ã–Ã˜Ã™ÃšÃ›ÃœÃÃžÃŸ')" />
								<xsl:text> </xsl:text>
								<xsl:variable name="prenom1"
									select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								<xsl:variable name="prenom2"
									select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Job title :
							<fo:inline font-weight="bold">
								<xsl:value-of select="signataire/fonction" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Name of department where internship will take place :
							<fo:inline font-weight="bold">
								<xsl:value-of select="service/nom" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Place of internship (if different from host organisation) :

							<xsl:if test="service/voie != structure/voie">
								<fo:inline font-weight="bold">
									<xsl:value-of select="service/batiment-residence" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/voie" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/code-postal" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/commune" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="service/pays/libelle" />
								</fo:inline>
							</xsl:if>

						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<!-- partie Etudiant -->
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="3"
						padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
						padding-right="5pt">

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								And the intern student :
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Surname :
							<fo:inline font-weight="bold">
								<xsl:value-of
									select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							First name :
							<fo:inline font-weight="bold">
								<xsl:variable name="prenom1"
									select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								<xsl:variable name="prenom2"
									select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">

					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Gender :
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="etudiant/code-sexe" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Date of birth :
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of
									select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row margin-top="20px" text-align="left">
					<fo:table-cell number-columns-spanned="3"
						padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Address :
							<fo:inline font-weight="bold">
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
				<fo:table-row text-align="left">

					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Tel :
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-etudiant" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<!--<fo:table-cell padding-left="5pt" padding-right="5pt"> <fo:block 
						line-height="110%" hyphenate="false" language="fr" country="FR" font-size="11.5pt" 
						font-family="Times New Roman,serif" padding-left="0.141cm" padding-right="0.141cm" 
						padding-top="0.035cm" padding-bottom="0.035cm"> portable : <fo:inline font-weight="bold"> 
						<xsl:value-of select="tel-portable-etudiant" /> </fo:inline> </fo:block> 
						</fo:table-cell> -->
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							E-mail :
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="etudiant/mail" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>

				<fo:table-row margin-top="20px" text-align="left">
					<fo:table-cell number-columns-spanned="3"
						padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
						padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Title of course taken at the higher education
							institution :
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								<xsl:value-of select="etape/libelle" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>

			</fo:table-body>
		</fo:table>
		<fo:table table-layout="fixed" width="100%" border="0.018cm solid #000000">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-column column-width="proportional-column-width(1)" />

			<fo:table-body>

				<!-- partie sujet stage -->
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="2"
						padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
						padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							SUBJECT OF INTERNSHIP :
							<fo:inline font-size="11.5pt" font-weight="bold">
								<xsl:if test="tem-conf-sujet-teme != 'O'">
									<xsl:value-of select="sujet-stage" />
								</xsl:if>
								<xsl:if test="tem-conf-sujet-teme = 'O'">
									Confidential
								</xsl:if>
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="2"
						padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
						padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							DATES OF INTERNSHIP : From
							<fo:inline font-weight="bold">

								<xsl:value-of
									select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
							</fo:inline>
							<xsl:text> </xsl:text>
							to
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of
									select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />
							</fo:inline>
							<xsl:if test="@interruption-stage = 'true'">
								<xsl:text> </xsl:text>
								with interruption from :
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
								</fo:inline>
								<xsl:text> </xsl:text>
								to
								<xsl:text> </xsl:text>
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))" />
								</fo:inline>
							</xsl:if>
						</fo:block>
					</fo:table-cell>

				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="2"
						padding-top="3pt" padding-bottom="3pt" padding-left="5pt"
						padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							DURATION OF INTERNSHIP :
							<xsl:choose>
								<xsl:when test="duree-exceptionnelle">
									<xsl:if test="duree-exceptionnelle != ''">
										<fo:inline font-weight="bold">
											<xsl:value-of select="duree-exceptionnelle" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="unite-duree/libelle" />
										</fo:inline>
									</xsl:if>
									<xsl:if test="duree-exceptionnelle = ''">
										<fo:inline font-weight="bold">
											<xsl:value-of select="duree-stage" />
										</fo:inline>
										<xsl:text> </xsl:text>
										weeks
									</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<fo:inline font-weight="bold">
										<xsl:value-of select="duree-stage" />
									</fo:inline>
									<xsl:text> </xsl:text>
									weeks
								</xsl:otherwise>
							</xsl:choose>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>

			</fo:table-body>
		</fo:table>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-column column-width="proportional-column-width(1)" />

			<fo:table-body>

				<!-- partie Encadrement -->
				<fo:table-row text-align="left">
					<fo:table-cell number-columns-spanned="2"
						padding-top="5pt" padding-bottom="5pt" padding-left="5pt"
						padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							<fo:inline font-weight="bold">
								Supervision of intern provided
								by :
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">

					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							On behalf of the higher education institution :
						</fo:block>


					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							On behalf of the host organisation :
						</fo:block>

					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">

					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Surname :
							<fo:inline font-weight="bold">
								<xsl:value-of
									select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Surname :
							<fo:inline font-weight="bold">
								<xsl:value-of
									select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">

					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							First name :
							<fo:inline font-weight="bold">
								<xsl:variable name="prenom1"
									select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								<xsl:variable name="prenom2"
									select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							First name :
							<fo:inline font-weight="bold">
								<xsl:variable name="prenom1"
									select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								<xsl:variable name="prenom2"
									select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Job title :
							<fo:inline font-weight="bold">
								<xsl:if test="enseignant/type-personne = 'ENS'">
									teacher
								</xsl:if>
								<xsl:if test="enseignant/type-personne  != 'ENS'">
									personal
								</xsl:if>
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Job title :
							<fo:inline font-weight="bold">
								<xsl:value-of select="contact/fonction" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Tel :
							<fo:inline font-weight="bold">
								<xsl:value-of select="enseignant/tel" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Tel :
							<fo:inline font-weight="bold">
								<xsl:value-of select="contact/tel" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							E-mail :
							<fo:inline font-weight="bold">
								<xsl:value-of select="enseignant/mail" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							E-mail :
							<fo:inline font-weight="bold">
								<xsl:value-of select="contact/mail" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>


			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="CPAM">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />

				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding-top="2pt" padding-bottom="2pt">
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								Healthcare insurance office to be contacted in the event of an
								accident (place of residence of student unless otherwise
								indicated) :
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
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								_____________________________________________
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:inline font-size="5pt" vertical-align="super">1
								</fo:inline>
								<fo:inline font-size="8pt"> Article L612-9 of the Education
									Code: "The duration of any internship(s) undertaken by a single
									intern in any one organisation must not exceed six months per
									academic year," subject to certain exceptions.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="8pt" font-family="Times New Roman,serif"
								font-weight="bold" font-style="italic">
								<fo:inline font-size="5pt" vertical-align="super">2
								</fo:inline>
								<fo:inline font-size="8pt"> Note to reader : Text in italics
									and bold type applies to internships in administration and
									public institutions of government.
								</fo:inline>
							</fo:block>
							<!--<fo:block line-height="110%" hyphenate="false" language="fr" country="FR" 
								font-size="8pt" font-family="Times New Roman,serif" padding-top="5pt"> convention 
								imprimÃ©e le : <xsl:value-of select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy 
								kk:mm:ss'), java:java.util.Date.new())" /> Exemplaire destinÃ© Ã  : organisme 
								d'accueil / Ã©tablissement d'origine / Ã©tudiant. </fo:block> -->

						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

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
								font-weight="bold">Article 1: Purpose of the contract
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The present contract governs the relationship between the host
								organisation (company, public agency, association...), the
								higher education institution and the intern.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Article 2: Objective of the internship</fo:block>

							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The internship offers the opportunity to spend a fixed period of
								time in a working environment, during which time students can
								develop their professional skills and apply the theoretical
								knowledge gained in the course of their training, with a view to
								obtaining a degree or other certification. Interns will be
								entrusted with one or more responsibilities which correspond to
								the educational objectives of their academic institutions, and
								which meet with the approval of the host organisation.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The objectives of the internship programme are determined by the
								HE institution and the host organisation in accordance with the
								general nature of the course curriculum.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Duties to be carried out :
								<fo:inline font-weight="bold">
									<xsl:value-of select="fonctions-et-taches" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-weight="bold">Article 3</fo:inline>
								<fo:inline font-weight="bold">: Practical terms of internship
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The maximum weekly amount of time the intern will be present at
								the company is
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								hours.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The internship is
								<fo:inline font-weight="bold">
									<xsl:value-of select="temps-travail/libelle" />
								</fo:inline>
								(please specify the percentage :
								<fo:inline font-weight="bold">
									<xsl:value-of select="quotite-travail" />
									%)
								</fo:inline>

								<!--<xsl:choose> <xsl:when test="commentaire-duree-travail"> <xsl:if 
									test="commentaire-duree-travail != ''"> (commentaire sur le temps de travail 
									: <fo:inline font-weight="bold"> <xsl:value-of select="commentaire-duree-travail" 
									/> ) </fo:inline> </xsl:if> </xsl:when> </xsl:choose> -->
							</fo:block>

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								If the intern must be present at the host organisation at night,
								on a Sunday or on a bank holiday, the organisation must indicate
								these special cases here :
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
								font-weight="bold">Article 4: Status of intern - Reception and
								monitoring
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The student will retain his/her previous status throughout the
								duration of the internship in the host organisation and will
								receive regular monitoring from the HE institution. The host
								organisation will designate a
								<fo:inline font-style="italic">host organisation tutor
								</fo:inline>
								who will be responsible for mentoring the student and optimising
								the conditions for carrying out the internship.
								Throughout the
								duration of the internship, the student may return to the
								HE
								institution for any lessons they are explicitly required to
								take
								as part of the course or to attend meetings, provided the
								host
								organisation is informed of the dates by the HE institution
								and
								the student receives authorisation to travel, if applicable.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Terms of monitoring :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-encadre-suivi" />
								</fo:inline>
							</fo:block>


							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								keep-with-next="always" text-align="justify" font-weight="bold">Article
								5: Remuneration - Benefits in kind - Reimbursement of expenses
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								The intern must receive remuneration if the length of the
								internship is longer than two months (consecutive or
								non-consecutive) and the internship takes place on French
								territory, notwithstanding special rules which apply in certain
								overseas territories, or the conditions set out in Article
								L4381-1 of the French Public Health Code.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								When the length of the
								internship is longer than two consecutive months and equal to at
								least 40 working days, and the internship takes place in
								administration or an administrative public institution of
								government on French territory, the intern must receive
								remuneration.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Remuneration is fixed by a sector-specific or professional
								agreement, or failing this, at 12.5% of the hourly social
								security limit defined in accordance with article L 241-3 of the
								Social Security Code.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								For internships in
								administration or an administrative public institution of
								government, remuneration must be equal to the hourly limit
								outlined above.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								When the duration of the internship is less than or equal to two
								months and takes place in a public or private enterprise or an
								association on French territory, the student may receive
								remuneration.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Amount of remuneration (if different to legal amount) :
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
										per month
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Method of payment of remuneration :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-vers-gratification/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								If an intern receives benefits in kind (for example, free
								meals), the amount representing the value of these benefits will
								be added to the monthly amount of remuneration before comparison
								with 12.5% of the hourly social security limit for a legal
								duration of weekly work equal to 35 hours.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Accommodation and travel costs incurred by the student at the
								request of the organisation in addition to any training expenses
								required to carry out the internship will be covered by the
								organisation in accordance with the terms in force within the
								organisation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								List of benefits provided :
								<fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Interns can access social and cultural activities
								listed in article L2323-83 of the Employment Code under the same
								conditions as salaried employees.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								When the internship takes place
								in administration or in an administrative public institution of
								government, the student's assignment expenses will be covered
								under the 2006-781 decree, with the place where the internship
								takes place as the place of work for administrative purposes.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								For internships in
								administration or administrative public institutions of
								government: travel expenses for travel between the place of
								residence and the place of work will be covered in accordance
								with the conditions outlined in decree 2010-676:
								...............(please indicate yes or no)
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">Article 6: Social security
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The student remains affiliated with his/her prior
								social security system throughout the duration of the internship
								and will retain student status. In the case of internships
								undertaken abroad, social security must be informed and
								verification must be received from them prior to the departure
								of the student.

							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The following clauses are applicable subject to
								compliance with the legislation of the host country and
								legislation governing the type of host organisation :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.1
									Remuneration less than or equal to
								</fo:inline>
								12.5% of the hourly social security limit multiplied by the
								number of hours of internship completed within the month in
								question:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In accordance with the legislation in force, in this
								situation, the remuneration received for the internship is not
								subject to social security contributions. The student continues
								to benefit from the legislation relating to accidents in the
								workplace under article L 412-8-2 of the Social Security Code,
								student scheme.

							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In the event of the student being involved in an accident,
								regardless of whether this takes place whilst undertaking work
								in the organisation, during travel or on any premises pertaining
								to fulfilling the requirements of the internship,
								<fo:inline font-size="10pt" font-style="italic">
									and for
									students of medicine, dentistry or pharmacy who do not hold a
									medical position, in relation to medical internships carried
									out under the conditions outlined in section b) of 2o of
									article L 412-8,
								</fo:inline>
								<fo:inline font-size="10pt" font-weight="bold">
									the host
									organisation shall send a declaration to the
								</fo:inline>
								"Caisse Primaire d'assurance maladie" (healthcare insurance
								office) (see address on the first page), specifying the
								institution as the employer,
								<fo:inline font-size="10pt" font-weight="bold">
									and must send
									a copy to the institution.
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
									Remuneration greater
								</fo:inline>
								than 12.5% of the hourly social security limit multiplied by the
								number of hours of internship completed within the month in
								question :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Social security contributions are calculated on the
								difference between the amount of remuneration and 12.5% of the
								hourly social security limit for a legal duration of weekly work
								equal to 35 hours.
							</fo:block>
							<!--<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times 
								New Roman,serif" text-align="justify"> L'Ã©tudiant(e) bÃ©nÃ©ficie de la couverture 
								lÃ©gale en application des dispositions des articles L 411-1 et suivants 
								du code de la SÃ©curitÃ© Sociale. En cas d'accident survenant Ã  l'Ã©tudiant(e), 
								soit au cours </fo:block> -->

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
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">The student
								benefits from legal cover in accordance with the clauses of
								article L 411-1 and onwards of the Social Security Code. In the
								event of the student being involved in an accident, regardless
								of whether this takes place whilst undertaking work in the
								organisation, during travel or on any premises pertaining to
								fulfilling the requirements of the internship, the host
								organisation will take all necessary steps required by the
								"Caisse Primaire d'Assurance Maladie" and inform the HE
								institution as soon as possible.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.3 Health
									protection for interns abroad :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1) Protection
								under the French student scheme :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- For internships in the European Economic Area (EEA) undertaken
								by students who are nationals of member states of the European
								Union, the student must obtain a European Health Insurance Card
								<fo:inline font-size="10pt" text-decoration="underline">(EHIC).
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- For internships carried out in Quebec by students who are
								French nationals, the student must obtain a
								<fo:inline font-size="10pt" text-decoration="underline">SE401Q
								</fo:inline>
								form (104
								for internships in companies, 106 for internships in
								universities).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt" text-decoration="underline">- In all
									other cases:
								</fo:inline>
								<!-- Les Ã©tudiant(e)s qui engagent des frais de santÃ© Ã  l'Ã©tranger 
									peuvent Ãªtre remboursÃ©(e)s auprÃ¨s de la mutuelle qui leur tient lieu de 
									Caisse de SÃ©curitÃ© Sociale Ã©tudiante, au retour, et sur prÃ©sentation 
									des justificatifs : le remboursement s'effectue alors sur la base des tarifs 
									de soins franÃ§ais, des Ã©carts importants peuvent exister. -->
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Students who incur health costs abroad can be
								reimbursed by the organisation which serves as "Caisse de
								Sécurité Sociale" for students, on their return to France and
								on
								the presentation of documentary evidence: the reimbursement
								is
								granted on the basis of French healthcare costs, meaning
								major
								differences may exist.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								° It is therefore strongly recommended that the
								student takes out additional private health insurance which is
								valid in the country where the internship takes place and for
								the duration of the internship, with the host organisation of
								his/her choice (student insurance company, insurance company of
								parents, private company on a one-off basis...).
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="bold"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								°
								<fo:inline font-size="10pt" text-decoration="underline">
									Exception
								</fo:inline>
								: if the host organisation provides the student with health
								insurance pursuant to the clauses outlined in local law (see
								section 2) below), the student can choose to benefit from this
								local health insurance cover. Before making a decision, the
								student should verify the specific details of cover provided.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt">2) Protection from the host
									organisation:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt">By ticking the appropriate box,
									the host organisation indicates hereunder if it will provide
									the intern with health insurance pursuant to local law :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="bold"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-size="10pt" font-weight="bold">YES
								</fo:inline>
								(this is in addition to the rights of the student under the
								French student insurance scheme, which continues when the
								student is abroad)
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-size="10pt" font-weight="bold">NO
								</fo:inline>
								(protection follows exclusively from the rights of the student
								under the French student scheme, which continues when the
								student is abroad)
							</fo:block>
							<fo:block>
								If neither of these options is ticked, section 1) of
								article 6.3 will apply.
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
								<fo:inline font-size="10pt" font-weight="bold">6.4
									Occupational accident insurance for interns abroad :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								1) In order to benefit from French legislation in
								relation to occupational accident cover, the present internship
								must :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° Be no longer than 12 months, including any
								extensions
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° Not give rise to any remuneration likely to grant
								rights to occupational accident insurance in the foreign country
								(an allowance or remuneration is accepted up to 12.5% of the
								hourly social security limit for a legal duration of weekly work
								equal to 35 hours subject to the consent of the "Caisse Primaire
								d'Assurance Maladie").
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° Take place exclusively in the company party to
								the
								present contract.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° Take place exclusively in the foreign country
								stated.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" space-before="0cm"
								space-after="0cm" font-weight="normal" text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								When these
								conditions are not fulfilled, the host organisation agrees to
								pay contributions for the protection of the intern and to make
								the necessary declarations in the event of an accident in the
								workplace.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2) The
								declaration of occupational accidents is the responsibility of
								the HE institution who must be informed by the host organisation
								in writing within 48 hours.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								3) The student is
								covered for accidents occurring:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° Within the confines of the location of the
								internship and the hours of the internship.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° On the daily journey between the place of
								internship and the place of residence abroad.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° On the journey between the place of residence of
								the intern on French territory and the place of residence abroad
								(at the beginning or the end of the internship).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° In the course of any assignment commissioned by
								the
								host organisation and where the activity is a necessary part
								of
								the given assignment.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4) In the event
								that any condition outlined in point 6.4 1) is not met, in
								accordance with the present contract, the host organisation
								agrees to provide cover for the intern against the risk of a
								workplace or travel accident and against occupational diseases
								and to provide any declarations required.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								5) In all cases,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° If a student suffers an accident in the workplace during the
								internship, it is imperative that the host organisation informs
								the HE institution of the accident
								<fo:inline font-size="10pt" text-decoration="underline">immediately.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								° If a student completes limited tasks outside of
								the
								host organisation or outside the country where the
								internship
								takes place, the host organisation must make all the
								necessary
								arrangements to provide the student with appropriate
								insurance.
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
								Article 7 : Civil liability and insurance
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								The host
								organisation and the student declare that they have civil
								liability coverage.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Regardless of the nature of the internship and the
								destination country, the intern agrees to obtain cover for
								him/herself by way of a general insurance policy (medical
								repatriation, legal assistance, etc) and a personal accident
								insurance policy.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								If the host organisation provides the intern with a
								vehicle, it is the responsibility of the host organisation to
								confirm beforehand that the vehicle insurance policy covers use
								of the vehicle by a student.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									When the student uses his/her own
									vehicle or a vehicle loaned by a third party within the
									framework of the internship, the student expressly agrees to
									declare this use to the insurer of the said vehicle, and if
									required, to pay the relevant premium.
								</fo:inline>
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
								Article 8 : Conduct
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Throughout the
								internship, the student is subject to the conduct and internal
								regulations of the organisation, specifically, in relation to
								hours of work, and hygiene and safety regulations in force
								within the host organisation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Disciplinary procedures may only be determined by the
								HE institution. In the event of a breach of discipline, the host
								organisation should inform the HE institution of the breach(es)
								and provide the constitutive elements.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In the event of a particularly serious breach of
								discipline, the host organisation reserves the right to
								terminate the internship while respecting the clauses fixed in
								article 9 of the present contract.
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
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 9 : Leave of absence and curtailment of
								internship
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Any difficulties
								which occur during the course of the internship shall be brought
								to the attention of all parties concerned in order to resolve
								the issue as soon as possible.

							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Temporary curtailment :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								During the course of
								the internship, the intern can take annual leave subject to
								approval from the host organisation and with respect of the
								duration of the internship.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								For any other
								temporary curtailment of the internship (illness, maternity,
								unauthorised absence...), the host organisation should inform
								the HE institution representative in writing.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Definitive curtailment :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">
									In the event
									that one of the three parties (host organisation, HE
									institution, student) wishes to permanently curtail the
									internship,
								</fo:inline>
								the party in question shall inform the other parties in writing
								immediately. The reasons outlined will be considered together. A
								definitive decision to curtail the internship will only be made
								after this dialogue phase.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 10 : Duty of circumspection and
								nondisclosure
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								The duty of
								circumspection is absolute. In this respect, intern students
								agree that in no circumstances will they use information they
								have gathered or obtained, including the internship report, for
								the purpose of publication or communication with third parties,
								without prior consent from the host organisation. In addition to
								the duration of the internship, this continues to apply after
								the internship has ended. The student agrees not to keep, take
								or make a copy of any document or software belonging to the host
								organisation, regardless of its nature, without consent from the
								host organisation.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									Note: Within the framework of
									nondisclosure of information contained within the report, the
									host organisation can request a restriction on the distribution
									of the report and even the withdrawal of certain elements of
									highly confidential information.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									Those who have knowledge of the
									information contained within the report are restricted by
									professional confidentiality not to use or disclose any
									information contained therein.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 11 : Intellectual property
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								In accordance with the Intellectual Property Code, if
								the work undertaken by the intern results in the creation of a
								piece of work protected by copyright or industrial property
								(including software), and if the host organisation wishes to use
								the work and the student consents to this, a contract should be
								drawn up and signed by the intern (author) and the host
								organisation.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								The contract should notably include the extent of
								transferred rights, the conditions of exclusivity, the
								destination of the work, the resources used and the duration of
								the transfer of rights as well as the total remuneration owed to
								the student in relation to the transfer of rights, if
								applicable.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">
								This clause
								also applies in the case of internships carried out in public
								institutions.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 12 : Recruitment
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								In the event that
								a work contract is signed by the host organisation and comes
								into effect before the end date of the internship, the present
								contract will become null and void; the HE institution is no
								longer responsible for the student. It is imperative that the HE
								institution is informed of the work contract before it is
								signed.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Article 13 : End of internship
								- Report - Evaluation
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								At the end of the
								internship, the host organisation will provide the intern with
								an internship certificate and will complete an evaluation form
								in relation to the performance of the intern (see appendix)
								which should be returned to the HE institution.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								At the end of the internship, the student shall: (specify the
								nature of work to be provided by an attachment in the appendix,
								if necessary)
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								State the terms of validation of the internship, if required:
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								Number of ECTS credits :
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
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Quality evaluation of
								the internship: At the end of the internship, the three parties
								involved are invited to formulate an appraisal of the quality of
								the internship.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								The host organisation
								tutor or any other member of the host organisation required to
								visit the HE institution as part of the preparation,
								implementation or validation of the internship may not claim
								reimbursement or compensation from the HE institution.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								An addendum to the
								contract may be drawn up in the event of an extension of the
								internship at the request of the host organisation and the
								student. The date of the end of the internship may not take
								place after the 30th September of the year in question, under
								any circumstances.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								The successive hosting
								of interns undertaking internships in a certain post under
								internship contracts is only possible after a waiting period
								equal to a third of the duration of the previous internship.
								This clause is not applicable when the previous internship was
								curtailed by the student before the end of the contract.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Article 14 : Applicable law - Courts of competent
								jurisdiction
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								The present contract
								is governed exclusively by French law. Any dispute which cannot
								be settled out of court will be submitted to the competent
								French jurisdiction.
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
								At
								....................................... on
								.......................................
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								On behalf of the higher education
								institution
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="nom-signataire-composante">
									</xsl:when>
									<xsl:otherwise>
										(name and signature of representative)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>

							<!-- <fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times 
								New Roman,serif"> <xsl:choose> <xsl:when test="centre-gestion/nom-viseur"> 
								Par dÃ©lÃ©gation, <fo:inline font-weight="bold"> <xsl:variable name="prenom1" 
								select="translate(substring(./centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" 
								/> <xsl:variable name="prenom2" select="translate(centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" 
								/> <xsl:value-of select="concat($prenom1, substring($prenom2,2))" /> <xsl:text> 
								</xsl:text> <xsl:value-of select="translate(centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" 
								/> </fo:inline> </xsl:when> <xsl:otherwise> <fo:inline font-weight="bold"> 
								<xsl:value-of select="nom-signataire-composante" /> </fo:inline> </xsl:otherwise> 
								</xsl:choose> </fo:block> <fo:block line-height="110%" padding-top="5pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times 
								New Roman,serif" text-align="center"> __________ </fo:block> <fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times 
								New Roman,serif"> <fo:leader /> </fo:block> -->

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								On behalf of the host organisation
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="signataire/nom">
									</xsl:when>
									<xsl:otherwise>
										(name and signature of representative)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1"
										select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2"
										select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="center">
								__________
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								On behalf of the student
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="etudiant/nom">
									</xsl:when>
									<xsl:otherwise>
										(name and signature)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1"
										select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2"
										select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="center">
								__________
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline text-decoration="underline">SIGNATURES OF TUTORS:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Host organisation tutor
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="contact/nom">
									</xsl:when>
									<xsl:otherwise>
										(name and signature of representative)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1"
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2"
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="center">
								__________
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Higher education institution tutor
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
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="enseignant/nom">
									</xsl:when>
									<xsl:otherwise>
										(name and signature of representative)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1"
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2"
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
			<!--<fo:block line-height="110%" hyphenate="false" language="fr" country="FR" 
				font-size="10pt" font-family="Times New Roman,serif"> <fo:leader /> </fo:block> -->
		</fo:block>

	</xsl:template>
	<xsl:template name="Charte">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			text-align="justify">

			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />

				<fo:table-body>
					<fo:table-row>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="5pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="center">
								<fo:inline font-weight="bold">STUDENT WORK PLACEMENT CHARTER
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								The Minister for Employment, Social
								Cohesion and Housing
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								The Minster for Higher Education
								and Research
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								The Minister for Employment, Labour
								and Professional integration of young people
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								The Minister for Higher Education
								and Research
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
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">I - INTRODUCTION
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Today, the development of work placements is crucial
									to the professional
									orientation and integration of young people.
									Work placements enable
									theoretical
									knowledge to be used in a
									professional setting and give students
									experience of the
									business
									world and work. From this point of view, it is vital to
									underscore
									the pedagogical aim of work placements,
									which means
									that work placements cannot take place without reference
									to the
									relevant course.
									On no account may work placements be considered
									as employment.
									The aim of this charter,
									which has been drafted by
									government departments, representatives
									from companies,
									representatives of higher
									education establishments and student
									representatives, is therefore to
									stabilise the way work
									placements
									are carried out, whilst enabling them to be developed
									in a way
									that is of benefit both to young people and
									to
									businesses.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">II - SCOPE AND DEFINITION
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - Scope of the charter
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The charter applies to all work placements of
									students in companies,
									without prejudice to the particular rules
									applicable to regulated
									professions.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - The work placement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The work placement forms part of a pedagogical
									project and is meaningful only with respect to this project.
									It
									follows that the work placement:
									- enables knowledge to be put
									into practice in a professional setting;
									- facilitates movement
									from the world of higher education to the business world.
									On no
									account may work placements be considered as employment.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">III - PROCEDURES GOVERNING
									WORK PLACEMENTS
								</fo:block>

								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - Formalising planned work
									placements
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Work placements are envisaged in liaison between a
									member of teaching staff
									from the establishment, a
									representative of the company and the
									student.
									The planned work
									placement is formalised in the
									agreement signed by the
									educational establishment,
									the company
									and the student.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - The agreement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The agreement specifies the commitments and
									responsibilities of
									the educational establishment, the company
									and the student.
									The mandatory sections are specified in an
									appendix to the
									charter.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">3 - Duration of the work
									placement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The duration of the work placement is specified
									during the initial
									contacts between the educational
									establishment and the company.
									The student is kept informed of
									this.
									The duration of the work placement is explicitly specified
									in the
									work placement agreement.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">4 - Supervisors
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									All work placements come under dual supervision :
									-
									by a member of the establishment's teaching staff;
									- by a
									representative of the company.
									The member of teaching staff and
									the company representative work in cooperation,
									are informed and
									inform each other of the progress of the work placement and any
									difficulties which may occur.
									The supervisor from the
									educational establishment guarantees the coherence of the aims
									of the work placement
									and those of the training course, in line
									with the principles of
									this charter.
									Their respective
									institutions recognise the necessary investment,
									notably in
									terms of time,
									required for supervisory duties.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">5 - Assessment
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-style="italic" font-weight="bold">a -
									Assessment of the student
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The student's work is assessed by both the work
									placement supervisors.
									Each educational establishment decides on
									the value they place on work
									placements planned as part of the
									academic course.
									The exact methods of
									assessment are specified in
									the agreement.
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The assessment is filled in on an "assessment sheet"
									which,
									together with the agreement,
									forms the "work placement
									file".
									This work placement file is kept by the educational
									establishment.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-style="italic" font-weight="bold">b -
									Assessment of the work placement
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The signatories of the agreement are invited to give
									their assessment of
									the quality of the work placement.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">IV - COMMITMENTS OF THE
									PARTIES
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - Commitment of the student
									with respect to the company
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The student undertakes to :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- fulfil their mission and be available for the
									tasks entrusted to them;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- observe the company rules, its codes and culture;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- observe the non-disclosure requirements
									established by the company;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- write, where required, the report or dissertation for the set
									deadline:
									this document must be presented to the company
									managers before
									being
									presented for academic purposes
									<fo:inline font-style="italic">
										(where the content makes this
										necessary, the dissertation may,
										at the request of the company,
										remain confidential).
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - Commitment of the company
									with respect to the student
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The company undertakes to :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- offer a work placement in line with the
									pedagogical project defined by the educational establishment;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- welcome the student and provide them with the
									resources for them to be successful in their mission;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- appoint a work placement supervisor or supervisory
									team with the task of
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* guiding and advising the student;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* informing them of the rules, codes and culture of
									the company;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* enable their integration into the company and
									provide access to necessary information;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* help them to gain the necessary skills;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* monitor their work regularly;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* assess the quality of the work done;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* advise them with respect to their professional
									project;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- write a work placement certificate describing the missions
									performed which can be enclosed with
									<fo:inline font-style="italic"> the student's CV </fo:inline>
									in the future.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">3 - Commitment of the higher
									education establishment with respect to the student
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The educational establishment undertakes to :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- define the objective of the work placement and
									ensure that the proposed work placement meets these objectives;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- help the student look for a work placement;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- prepare the student for the work placement;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- supervise the student throughout their work
									placement, by appointing a member of teaching staff
									who will
									ensure that the work placement runs smoothly; provide the
									latter with the tools necessary
									for the student to appraise the
									quality of the work placement;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- for higher education courses for which it is a
									requirement, guide and advise them in writing
									their work
									placement report or dissertation and organise its
									presentation,
									including allowing a representative
									of the company to be
									present.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">4 - Commitment of the company
									and the educational establishment
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The company and higher education establishment
									undertake to exchange the necessary information before,
									during
									and after the work placement. They will also observe their
									respective rules with respect
									to non-disclosure and professional
									practice.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">5 - Commitment of the student
									with respect to the educational establishments
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									The student undertakes to give an appraisal of the
									quality of their
									work placement to their educational
									establishment.
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>

			</fo:block>
		</fo:block>
		<fo:block id="theEnd" />
	</xsl:template>

</xsl:stylesheet>