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
									Anexo 1:
								</fo:inline>
								<fo:inline font-size="9pt">
									Carta de principios de las
									práticas /
								</fo:inline>
								<fo:inline font-size="9pt" font-weight="bold"
									text-decoration="underline">
									Anexo 2:
								</fo:inline>
								<fo:inline font-size="9pt">
									Fichas de evaluatión /
								</fo:inline>
								<fo:inline font-size="9pt" font-weight="bold"
									text-decoration="underline">
									Anexo 3:
								</fo:inline>
								<fo:inline font-size="9pt">
									A entregar por el estudiante:
									certificado de seguro de responsabilidad civil
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
								Año académico:
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
								Acuerdo de prácticas
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
						<!-- <fo:block line-height="110%" hyphenate="false" language="fr" country="FR" 
							font-size="8pt" font-family="Times New Roman,serif" text-align="justify"> 
							<fo:inline font-size="8pt" font-style="italic" font-weight="bold"> <fo:inline 
							text-decoration="underline">Préambule : stages hors administrations et établissement 
							publics de l'Etat ne présentant pas un caractère industriel et commercial : 
							</fo:inline> Les signataires de la présente convention de stage reconnaissent 
							avoir pris connaissance de l'article 9 de la loi n°2006-396 pour l'égalité 
							des chances modifiée, de ses décrets d'application, de la loi n° 2009-1437 
							du 24 novembre 2009 relative à l'orientation et à la formation professionnelle 
							tout au long de la vie ainsi que de la charte des stages (annexe 1). Ils 
							en acceptent les principes. <fo:inline text-decoration="underline">stages 
							en administrations et établissement publics de l'Etat ne présentant pas un 
							caractère industriel et commercial : </fo:inline> Les signataires de la présente 
							convention de stage reconnaissent avoir pris connaissance du décret 2009-885 
							du 21 juillet 2009 relatif aux modalités d'accueil des étudiants de l'enseignement 
							supérieur en stage dans les administrations et établissements publics de 
							l'Etat ne présentant pas un caractère industriel et commercial. </fo:inline> 
							</fo:block> <fo:block line-height="110%" hyphenate="false" language="fr" 
							country="FR" font-size="8pt" font-family="Times New Roman,serif"> <fo:leader/> 
							</fo:block> -->
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							text-align="center">
							<fo:inline font-weight="bold">ENTRE</fo:inline>
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
								El establecimiento de enseñanza
								superior:
							</fo:inline>
						</fo:block>

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Nombre del establecimiento :
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
							Dirección :
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
							Representado por :
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
							Cargo del representante :
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
							Facultad/Instituto :
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="centre-gestion/nom-centre" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm">
							Dirección: (si fuera diferente a la del establecimiento)
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
							Tfno. :
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
								El organismo de acogida :
							</fo:inline>
						</fo:block>

						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Nombre :
							<fo:inline font-weight="bold">
								<xsl:value-of select="structure/raison-sociale" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Dirección :
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
							Tfno. :
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
							Representado por : (nombre del signatario o signataria del
							acuerdo)
							<fo:inline font-weight="bold">
								<xsl:value-of select="signataire/civilite/libelle" />
								<xsl:text> </xsl:text>
								<xsl:value-of
									select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
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
							Cargo del representante :
							<fo:inline font-weight="bold">
								<xsl:value-of select="signataire/fonction" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Nombre del servicio en el que se efectuarán las prácticas :
							<fo:inline font-weight="bold">
								<xsl:value-of select="service/nom" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Lugar de las prácticas: (si fuera diferente a la dirección del
							organismo de acogida)

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
								Y el estudiante en prácticas :
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
							Apellidos :
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
							Nombre :
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
							Sexo :
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
							Fecha de nacimiento :
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
							Dirección :
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
							Tfno. :
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-etudiant" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Móvil :
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-portable-etudiant" />
							</fo:inline>
						</fo:block>
					</fo:table-cell>
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
							Título de la formación o plan de estudios seguido
							en el establecimiento de enseñanza superior :
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
							TEMA DE LAS PRÁCTICAS :
							<fo:inline font-size="11.5pt" font-weight="bold">
								<xsl:if test="tem-conf-sujet-teme != 'O'">
									<xsl:value-of select="sujet-stage" />
								</xsl:if>
								<xsl:if test="tem-conf-sujet-teme = 'O'">
									Confidencial
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
							PERIODO DE LAS PRÁCTICAS : Del
							<fo:inline font-weight="bold">

								<xsl:value-of
									select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))" />
							</fo:inline>
							<xsl:text> </xsl:text>
							al
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of
									select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))" />
							</fo:inline>
							<xsl:if test="@interruption-stage = 'true'">
								<xsl:text> </xsl:text>
								con interrupción : Del
								<fo:inline font-weight="bold">
									<xsl:value-of
										select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))" />
								</fo:inline>
								<xsl:text> </xsl:text>
								al
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
							DURACIÓN DE LAS PRÁCTICAS :
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
										semanas
									</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<fo:inline font-weight="bold">
										<xsl:value-of select="duree-stage" />
									</fo:inline>
									<xsl:text> </xsl:text>
									semanas
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
								Acompañamiento del estudiante en
								prácticas a cargo de :
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
							El establecimiento de enseñanza superior de origen
							en la persona de :
						</fo:block>


					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							El organismo de acogida en la persona de :
						</fo:block>

					</fo:table-cell>
				</fo:table-row>
				<fo:table-row text-align="left">

					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Apellidos :
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
							Apellidos :
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
							Nombre :
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
							Nombre :
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
							Cargo :
							<fo:inline font-weight="bold">
								<xsl:if test="enseignant/type-personne = 'ENS'">
									enseignant
								</xsl:if>
								<xsl:if test="enseignant/type-personne  != 'ENS'">
									personnel
								</xsl:if>
							</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell padding-left="5pt" padding-right="5pt">
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Cargo :
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
							Tfno. :
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
							Tfno. :
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
								Caja primaria de seguro médico a la que contactar en caso de
								accidente
								(en el lugar de residencia del estudiante salvo
								excepción) :
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
								<fo:inline font-size="8pt"> Article L612-9 du code de
									Artículo L612-9 del Código de Educación francés : "La duración
									de las prácticas efectuadas por un mismo estudiante no puede
									exceder seis meses por curso académico", salvo excepciones.
								</fo:inline>
							</fo:block>
							<!-- <fo:block line-height="110%" hyphenate="false" language="fr" -->
							<!-- country="FR" font-size="8pt" font-family="Times New Roman,serif" -->
							<!-- font-weight="bold" font-style="italic"> -->
							<!-- <fo:inline font-size="5pt" vertical-align="super">2 -->
							<!-- </fo:inline> -->
							<!-- <fo:inline font-size="8pt"> Note de lecture : les caractères -->
							<!-- gras et italiques s'appliquent aux -->
							<!-- stages en administration et -->
							<!-- établissements publics de l'Etat. -->
							<!-- </fo:inline> -->
							<!-- </fo:block> -->
							<!-- <fo:block line-height="110%" hyphenate="false" language="fr" -->
							<!-- country="FR" font-size="8pt" font-family="Times New Roman,serif" -->
							<!-- padding-top="5pt"> -->
							<!-- convention imprimée le : -->
							<!-- <xsl:value-of -->
							<!-- select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy 
								kk:mm:ss'), java:java.util.Date.new())" /> -->
							<!-- Exemplaire destiné à : organisme d'accueil / établissement -->
							<!-- d'origine / étudiant. -->
							<!-- </fo:block> -->

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
								font-weight="bold">Artículo 1: Objeto del acuerdo
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El presente acuerdo regula las relaciones del organismo de
								acogida (empresa, organismo público, asociación...) con el
								establecimiento de enseñanza superior y el estudiante en
								prácticas.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Artículo 2: Objetivo de las prácticas</fo:block>

							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Las prácticas de formación permiten al estudiante acceder a un
								entorno profesional de manera temporal y adquirir competencias
								profesionales que ponen en práctica los conocimientos adquiridos
								durante su formación con vistas a la obtención de un título o
								certificación. El estudiante en prácticas recibe una o varias
								misiones relacionadas con el proyecto pedagógico del
								establecimiento de enseñanza y aprobadas por el organismo de
								acogida.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El programa de las prácticas es diseñado entre el
								establecimiento y el organismo de acogida en función del
								programa general de la formación impartida.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Actividades encomendadas :
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
								<fo:inline font-weight="bold">Artículo 3: Modalidad de las
									prácticas
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La duración semanal máxima de presencia del o de la estudiante
								en prácticas en la empresa será de
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								horas.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Las prácticas son
								<xsl:if test="temps-travail/libelle = 'Temps Complet'">
									a tiempo completo
								</xsl:if>
								<xsl:if test="temps-travail/libelle != 'Temps Complet'">
									a tiempo parcial
								</xsl:if>
								<xsl:choose>
									<xsl:when test="commentaire-duree-travail">
										<xsl:if test="commentaire-duree-travail != ''">
											(precisar :
											<fo:inline font-weight="bold">
												<xsl:value-of select="commentaire-duree-travail" />
												)
											</fo:inline>
										</xsl:if>
									</xsl:when>
								</xsl:choose>
							</fo:block>

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Si el o la estudiante en prácticas debe estar presente en el
								organismo de acogida durante la noche, los domingos o un día
								festivo, el organismo debe precisar a continuación los casos
								particulares :
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
								font-weight="bold">Artículo 4: Estatus del estudiante en prácticas -
								Acogida y acompañamiento
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								El o la estudiante, durante el periodo de prácticas
								en el organismo de acogida, conserva su estatus anterior y
								recibirá
								seguimiento regular por parte del establecimiento. El
								organismo de acogida
								nombra a un tutor responsable del
								seguimiento
								y de la optimización de las condiciones de
								realización de las
								prácticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								El o la estudiante podrá volver al establecimiento de
								enseñanza durante el periodo de las prácticas para asistir
								a
								ciertas clases explícitamente requeridas por el programa y
								participar en reuniones, cuyas fechas serán
								pertinentemente
								transmitidas al organismo de acogida por parte del
								establecimiento, en cuyo caso, el o la estudiante estará
								autorizado a desplazarse.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Modalidades de acompañamiento :
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
								keep-with-next="always" text-align="justify" font-weight="bold">
								Artículo 5: Gratificación - Retribuciones en especie - Reembolso
								de gastos
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Cuando la duración de las prácticas exceda los dos meses,
								consecutivos o no, estas deben ser objeto de una gratificación
								dentro el territorio francés, salvo normas particulares
								aplicables en algunos municipios de ultramar o en virtud del
								artículo L4381-1 del Código de Salud Pública francés.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La gratificación está fijada por el convenio colectivo
								correspondiente, sectorial o nacional, y en su defecto, en un
								12,5% de la base máxima horaria de cotización de la seguridad
								social definida en aplicación del artículo L 241-3 del Código de
								la Seguridad Social francés.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Se entiende que para las
								prácticas en administraciones o en establecimientos públicos
								administrativos del Estado, la gratificación es obligatoriamente
								igual a la base máxima precitada.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Cuando la duración de las prácticas es inferior o igual a dos
								meses, el o la estudiante puede percibir una gratificación, en
								empresas privadas o públicas, en asociaciones, dentro del
								territorio francés.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Importe de la gratificación (si difiere del importe establecido
								legalmente):
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
										per meses
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Modalidades de pago de la gratificación :
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
								Si el o la estudiante en prácticas se beneficia de retribuciones
								en especie (comidas gratis, por ejemplo), el importe que
								representa el valor de estas retribuciones se añadirá al importe
								de la gratificación mensual antes de comparación con el 12,5% de
								la base máxima horaria de la seguridad social para una duración
								legal de trabajo semanal de 35 horas.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Los gastos de desplazamiento y de alojamiento realizados por el
								o la estudiante a petición del organismo, así como los gastos de
								misión eventualmente necesarios para las prácticas, correrán
								íntegramente a cargo del o la estudiante según las modalidades
								vigentes en el organismo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Lista de las retribuciones ofrecidas :
								<fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Los estudiantes en prácticas acceden a las
								actividades sociales y culturales mencionadas en el artículo
								L2323-83 del Código de Trabajo francés en las mismas condiciones
								que los asalariados.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Cuando las prácticas se
								desarrollen en administraciones o establecimientos públicos
								administrativos del Estado, los gastos de misión mencionados
								anteriormente del o la estudiante serán sufragados de
								conformidad con el decreto 2006-781, siendo su residencia
								administrativa el lugar de las prácticas.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Para las prácticas en
								administraciones o establecimientos públicos del Estado: costeo
								de los trayectos entre el domicilio y el lugar de las prácticas,
								según las condiciones del decreto 2010-676:
								...................(indicar sí o no)
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">Artículo 6: Protección social
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Durante el periodo de las prácticas, el o la
								estudiante permanece afiliado a su sistema de seguridad social
								anterior: conserva su estatus de estudiante. Las prácticas
								efectuadas en el extranjero deben haberse señalado previamente a
								la partida del o la estudiante y haber recibido la aprobación de
								la Seguridad Social.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Las siguientes disposiciones son aplicables siempre y
								cuando sean conformes con la legislación del país de destino y
								con la legislación específica por la que se rige el organismo de
								acogida :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.1
									6.1
									Gratificación inferior o igual
								</fo:inline>
								al producto de 12,5% de la base máxima horaria de la seguridad
								social por el número de horas de prácticas efectuadas durante el
								mes considerado:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En este caso, conformemente a la legislación vigente,
								la gratificación de las prácticas no está sometida a cotización
								social.
								El o la estudiante sigue beneficiándose de la legislación
								que
								regula los accidentes de trabajo en virtud del artículo L
								412-8-2 del Código de la Seguridad Social francés, régimen
								"estudiante".
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Si el o la estudiante sufriera un accidente, bien durante el
								desarrollo de su actividad en el organismo, bien durante el
								trayecto o en los lugares considerados útiles para las
								necesidades de sus prácticas
								<fo:inline font-size="10pt" font-style="italic">
									y, en el caso
									de los/las estudiantes en medicina, en cirugía dental o en
									farmacia que no tengan estatus de personal de hospital, para
									las necesidades de las prácticas en hospital efectuadas en las
									condiciones previstas en b del 2° apartado del artículo L.
									412-8,
								</fo:inline>
								<fo:inline font-size="10pt" font-weight="bold">
									organismo de
									acogida enviará la declaración de accidente
								</fo:inline>
								a la Caja Primaria de Seguro Médico (ver dirección en la primera
								página)
								donde se indicará al establecimiento como empleador.
								Asimismo,
								deberá enviar
								<fo:inline font-size="10pt" font-weight="bold">
									una copia de
									la misma al establecimiento.
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
									Gratificación superior
								</fo:inline>
								al producto de 12,5% de la base máxima horaria de la seguridad
								social por el número de horas de prácticas efectuadas durante el
								mes considerado:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Las cotizaciones sociales se calculan en base al
								diferencial entre
								el importe de la gratificación y 12,5% de la
								base máxima horaria
								de la Seguridad Social para una duración
								legal de trabajo
								semanal de 35 horas.
							</fo:block>
							<!--<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times 
								New Roman,serif" text-align="justify"> L'étudiant(e) bénéficie de la couverture 
								légale en application des dispositions des articles L 411-1 et suivants du 
								code de la Sécurité Sociale. En cas d'accident survenant à l'étudiant(e), 
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
								font-family="Times New Roman,serif" text-align="justify">
								El o la
								estudiante se beneficia de la cobertura legal en
								aplicación de
								las disposiciones de los artículos L 411-1 y
								siguientes del
								Código de la Seguridad Social francés. En el
								supuesto que el o la
								estudiante sufriera un accidente, bien
								durante el desarrollo de
								su actividad en el organismo, bien
								durante el trayecto o en los
								lugares considerados útiles para
								las necesidades de sus
								prácticas, el organismo de acogida
								efectuará todos los trámites
								necesarios para con la Caja
								Primaria de Seguro Médico e informará
								al establecimiento en la
								mayor brevedad posible.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.3 Protección
									médica del o la estudiante en el extranjero :
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1) Protección
								derivada del régimen "estudiante" francés:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- Para las prácticas dentro del Espacio Económico Europeo (EEE)
								efectuadas por los/las estudiantes de
								nacionalidad de un país
								miembro de la Unión Europea, el o la estudiante debe
								solicitar la
								Tarjeta Sanitaria Europea
								<fo:inline font-size="10pt" text-decoration="underline">(TSE)
								</fo:inline>
								.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- Para las prácticas efectuadas en Quebec por los/las
								estudiantes de nacionalidad francesa, el/la estudiante debe
								solicitar el formulario
								<fo:inline font-size="10pt" text-decoration="underline">SE401Q
								</fo:inline>
								(104 para las prácticas en empresa, 106 para las prácticas en
								universidad).
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt" text-decoration="underline">- En los
									casos restantes :
								</fo:inline>
								Los/las estudiantes que incurran en gastos sanitarios en el
								extranjero pueden ser reembolsados por la mutua
								elegida como Caja
								de Seguridad Social de Estudiantes, una vez de vuelta
								y bajo
								presentación de los justificantes
								correspondientes: el reembolso
								se efectúa en base a las tarifas sanitarias
								francesas, por lo que
								pueden existir diferencias importantes.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								° Por ello, se recomienda vivamente al o la
								estudiante suscribir un seguro médico complementario específico,
								válido para el país
								de destino y el periodo de las prácticas, a
								través del organismo
								de acogida de su elección (mutua para los
								estudiantes, mutua de
								los padres, compañía privada de seguros ad
								hoc.).
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								°
								<fo:inline font-size="10pt" text-decoration="underline">Excepción
								</fo:inline>
								: si el organismo de acogida proporciona al o la estudiante una
								cobertura médica en virtud de las disposiciones del derecho
								local (ver 2 más abajo), el o la estudiante puede elegir
								beneficiarse de esta protección médica local. Antes de efectuar
								dicha elección, debe verificar la extensión de las garantías
								ofertadas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">2) Protección
									proporcionada por el organismo de acogida :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Al marcar la
								casilla correspondiente, el organismo de acogida
								indica a
								continuación si proporciona una protección
								médica al o la
								estudiante en prácticas, en virtud del derecho local :
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-size="10pt" font-weight="bold">SI</fo:inline>
								(esta se añade a la conservación, en el extranjero, de los
								derechos inherentes al régimen francés "estudiante").
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-size="10pt" font-weight="bold">NO</fo:inline>
								(la protección procede únicamente de la conservación, en el
								extranjero, de los derechos inherentes al régimen francés
								"estudiante").
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								En caso de no marcarse ninguna casilla, se aplica el
								6.3.1/.
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
								<fo:inline font-size="10pt" font-weight="bold">
									6.4 Protección
									ante accidentes de trabajo del o la estudiante en el
									extranjero:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								1) Para poder beneficiarse de la legislación francesa
								sobre la cobertura de accidentes de trabajo, las presentes
								prácticas deben:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Tener una duración máxima igual a 12 meses,
								prolongaciones incluidas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- No dar lugar a ninguna remuneración susceptible
								de
								abrir derechos a una protección contra accidentes laborales
								en el
								país de destino (se admite una indemnización o
								gratificación en
								un máximo de 12,5% de la base máxima horaria de
								la seguridad
								social para una duración legal semanal de 35 horas
								bajo el
								consentimiento de la Caja Primaria de Seguro Médico).
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Desarrollarse exclusivamente en la empresa
								signataria del presente acuerdo.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Desarrollarse exclusivamente en el país extranjero
								citado.
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
								Cuando no se
								cumplan estas condiciones, el organismo de acogida se compromete
								a cotizar para la protección del estudiante en prácticas y a
								hacer las declaraciones necesarias en caso de accidente de
								trabajo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2) La
								declaración
								de los accidentes de trabajo concierne al
								establecimiento de
								enseñanza que debe ser informado por escrito
								en un plazo de 48
								horas por el organismo de acogida.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								3) La cobertura
								abarca los accidentes sobrevenidos:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- En el recinto del lugar de las prácticas y durante
								las horas de prácticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Durante el trayecto de ida y vuelta habitual entre
								la residencia del estudiante en prácticas en el territorio
								extranjero y el lugar de las prácticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- En el trayecto de ida y vuelta (al inicio y al
								final de las prácticas) del domicilio del estudiante en
								prácticas situado en territorio francés y el lugar de residencia
								en el extranjero
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- En el contexto de una misión encomendada por el
								organismo de acogida y obligatoriamente recogida por escrito.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4) En caso de
								cumplirse una sola condición de las previstas en el punto 6.4
								1/, el organismo de acogida se compromete por el presente
								acuerdo a cubrir al estudiante en prácticas contra el riesgo de
								accidente de trabajo, de trayecto y enfermedades profesionales
								así como encargarse de todas las declaraciones necesarias.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								5) En cualquiera
								de los casos,
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Si el o la estudiante sufriera un accidente de trabajo durante
								las prácticas, el organismo de acogida debe imperativamente
								señalar este accidente al establecimiento de
								<fo:inline font-size="10pt" text-decoration="underline">manera
									inmediata.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Si el estudiante cumple misiones fuera del
								organismo de acogida o fuera del país de las prácticas, el
								organismo de acogida debe realizar todos los trámites necesarios
								para asegurarle adecuadamente.
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
								Artículo 7: Responsabilidad civil y seguros
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								El organismo de
								acogida y el o la estudiante declaran estar cubiertos en materia
								de responsabilidad civil.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Independientemente de la naturaleza de las prácticas
								y del país de destino, el o la estudiante en prácticas se
								compromete a suscribir un contrato de asistencia (repatriación o
								traslado sanitario, asistencia legal, etc.) y un contrato de
								seguro individual de accidentes.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de que el organismo de acogida ponga un
								vehículo a disposición del o de la estudiante en prácticas, será
								su responsabilidad verificar previamente que la póliza de seguro
								del vehículo cubre la utilización por un estudiante.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									En caso de que, en el marco de
									las prácticas, el o la estudiante utilice su propio vehículo o
									un vehículo prestado por un tercero, él o ella declarará
									expresamente al asegurador de dicho vehículo la utilización que
									él o ella piensa hacer del mismo y, en su caso, abonará la
									prima correspondiente.
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
								Artículo 8: Disciplina
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Durante las
								prácticas, el o la estudiante se somete a la disciplina y al
								reglamento interior del organismo (que debe ser puesto en
								conocimiento del o de la estudiante), en especial, en lo
								referente a los horarios y las normas de higiene y seguridad
								vigentes en el organismo de acogida.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El establecimiento es el único que tiene potestad
								para decidir cualquier sanción disciplinaria. En su caso, el
								organismo de acogida informará al establecimiento de las
								infracciones y eventualmente le proporcionará los elementos
								constitutivos de la infracción.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de infracción disciplinaria particularmente
								grave, el organismo de acogida se reserva el derecho de
								finalizar las prácticas de conformidad con las disposiciones
								fijadas en el artículo 9 del presente acuerdo.
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
								Artículo 9: Ausencia e interrupción de las prácticas
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Todos los
								interesados deberán ser informados de
								cualquier dificultad
								surgida durante el desarrollo de las
								prácticas con el objetivo
								de resolverla en la mayor brevedad
								posible.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interrupción temporal:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Durante las prácticas,
								el estudiante podrá beneficiarse de días de vacaciones bajo el
								consentimiento del organismo de acogida y siempre y cuando se
								respete la duración de las prácticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Para cualquier otra
								interrupción temporal de las prácticas (enfermedad, maternidad,
								ausencia injustificada...), el organismo de acogida deberá
								informar al responsable del establecimiento por correo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interrupción definitiva :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">
									En el caso de
									que una de las tres partes (organismo de acogida,
									establecimiento, estudiante) deseara interrumpir de manera
									definitiva las prácticas,
								</fo:inline>
								esta deberá informar inmediatamente a las otras dos partes por
								escrito. Las razones argumentadas se examinarán en estrecha
								concertación. La decisión definitiva de interrupción de las
								prácticas se tomará únicamente tras dicha fase de concertación.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Artículo 10: Deber de reserva y confidencialidad
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								El deber de
								reserva es de rigor absoluto. Los o las estudiantes en prácticas
								se comprometen, por lo tanto, a no utilizar bajo ninguna
								circunstancia las informaciones obtenidas para su publicación o
								comunicación a terceros sin previo consentimiento del organismo
								de acogida, el informe de las prácticas inclusive. Este
								compromiso no solo será válido durante el periodo de las
								prácticas sino que se extenderá tras su finalización. El o la
								estudiante se compromete a no conservar, llevarse o copiar
								ningún documento o software, independientemente de su
								naturaleza, que pertenezca al organismo de acogida, salvo
								consentimiento de este último.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									Nota: En razón de la
									confidencialidad de las informaciones contenidas en el informe,
									el organismo de acogida puede solicitar una restricción de la
									difusión del informe o, incluso, la retirada de ciertos
									elementos confidenciales.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									Las personas que accedan a dichas
									informaciones están obligadas por el secreto profesional a no
									divulgar las mismas.
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
								Artículo 11: Propiedad intelectual
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								De conformidad con el Código de Propiedad Intelectual
								francés, si el trabajo del estudiante en prácticas desembocara
								en la creación de una obra protegida con derechos de autor o de
								la propiedad industrial (software incluido), y en cuyo caso, el
								organismo de acogida deseara utilizarla y el estudiante en
								prácticas estuviera de acuerdo, este último (el autor) y el
								organismo de acogida deberán suscribir un contrato.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En particular, deberá precisarse la extensión de los
								derechos cedidos, una posible exclusividad, la finalidad, los
								soportes utilizados y la duración de la cesión así como, en su
								caso, el importe de la remuneración debida al estudiante en
								concepto de dicha cesión.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">
								Esta cláusula
								también se aplica en el caso de las prácticas desarrolladas en
								los organismos públicos.
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
								Artículo 12: Contratación
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								En el caso de
								firmarse un contrato de trabajo con el organismo de acogida
								antes del término de las prácticas, el presente acuerdo quedará
								obsoleto; el o la "estudiante" dejará de ser responsabilidad del
								establecimiento de enseñanza. Este último deberá ser informado
								imperativamente antes de la firma del contrato.
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
								Artículo 13: Final de las
								prácticas - Informe - Evaluación
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Al término de las
								prácticas, el organismo de acogida entregará al estudiante un
								certificado de prácticas y completará una ficha de evaluación de
								la actividad del estudiante en prácticas (anexo) que remitirá al
								establecimiento de enseñanza superior.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Al término de sus prácticas, el estudiante deberá: (precisar la
								naturaleza del trabajo que eventualmente deba entregar y
								adjuntar un anexo)
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Precisar, en su caso, las modalidades de validación de las
								prácticas :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								Número de créditos ECTS :
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
								Evaluación de la
								calidad de las prácticas: Al término de las prácticas, se
								invitará a las tres partes interesadas a formular una
								apreciación sobre la calidad de las prácticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								El tutor responsable
								del organismo de acogida o cualquier otro miembro del organismo
								de acogida que deba acudir a el establecimiento en el marco de
								la preparación, del desarrollo y la validación de las prácticas
								no puede aspirar a ningún tipo de sufrago o indemnización por
								parte del establecimiento.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Se podrá introducir
								una adenda al acuerdo en caso de prolongación de las prácticas,
								a petición del organismo y del o de la estudiante. En ningún
								caso la fecha de finalización de las prácticas podrá ser
								posterior al 30/09 del año en curso.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La recepción sucesiva
								de estudiantes en prácticas, en el marco de acuerdos de
								prácticas diferentes, para efectuar prácticas en un mismo puesto
								solo es posible tras la expiración de un plazo de carencia igual
								al tercio de la duración de las prácticas precedentes. Esta
								disposición no se aplica en el caso de que las prácticas
								precedentes hayan sido interrumpidas antes de llegar a término a
								iniciativa del estudiante.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Artículo 14: Sumisión expresa
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								El presente acuerdo
								está únicamente regido por el Derecho francés. Cualquier litigio
								no resuelto por vía amistosa se someterá la jurisdicción de los
								juzgados y tribunales franceses competentes.
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
								En
								....................................... el
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
								Por el establecimiento de enseñanza
								superior
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
										(nombre y firma del representante)
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>

							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">

								<xsl:choose>
									<xsl:when test="centre-gestion/nom-viseur">
										<fo:inline font-weight="bold">
											<xsl:variable name="prenom1"
												select="translate(substring(./centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
											<xsl:variable name="prenom2"
												select="translate(centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
											<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
											<xsl:text> </xsl:text>
											<xsl:value-of
												select="translate(centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										</fo:inline>
									</xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
											<xsl:value-of select="nom-signataire-composante" />
										</fo:inline>
									</xsl:otherwise>
								</xsl:choose>
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
								Por el organismo de acogida :
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
										(nombre y firma del representante)
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
								Por el estudiante
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
										(nombre y firma)
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
								<fo:inline text-decoration="underline">RATIFICACIÓN DE LOS TUTORES
									:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif">
								Tutor del organismo de acogida
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
										(nombre y firma del representante)
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
								Tutor del establecimiento de
								enseñanza superior
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
										(nombre y firma del representante)
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
							<fo:block line-height="110%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="center">
								<fo:inline font-weight="bold">REGLAMENTACIÓN DE LAS PRÁCTICAS
									DE LOS ALUMNOS EN LA EMPRESA
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro de Empleo, de Cohesión
								social y de Vivienda
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro de Educación nacional,
								de Enseñanza superior y de Investigación
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro delegado de Empleo,
								Trabajo e Inserción profesional de los jóvenes
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro delegado de Enseñanza
								superior y de Investigación
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
									text-align="justify" font-weight="bold">I - INTRODUCCIÓN
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El desarrollo de las prácticas es hoy en día
									fundamental para la orientación e inserción profesional de los
									jóvenes. En efecto, las
									prácticas permiten la aplicación de los
									conocimientos teóricos dentro de
									un marco profesional y ofrecen
									al estudiante una
									experiencia en el mundo empresarial. Dentro de
									esta perspectiva, es
									fundamental que se tenga en cuenta que las
									prácticas tienen
									una finalidad pedagógica, es decir que no puede
									haber práctica
									alguna si ésta no está inscrita dentro de un
									programa
									pedagógico.
									En ningún caso se deben considerar las
									prácticas como un empleo.
									La presente reglamentación, redactada
									por servicios del
									Estado, representantes de empresas,
									representantes de establecimientos
									de la enseñanza superior y
									delegados estudiantiles;
									tiene por objetivo establecer un marco
									más seguro para las prácticas
									y promover al mismo tiempo su
									desarrollo tanto entre los
									jóvenes
									como en las empresas.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">II - ÁMBITO DE APLICACIÓN,
									DEFINICIÓN
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - El ámbito de aplicación
									del convenio
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El ámbito de aplicación de la presente
									reglamentación se extiende a todas las prácticas profesionales
									de los estudiantes en una
									empresa, sin perjuicio en la
									aplicación de reglas particulares
									aplicables a profesiones
									reglamentadas.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - Las prácticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La finalidad de las prácticas se encuadra dentro de
									un proyecto pedagógico
									y es válida sólo con relación a dicho
									proyecto.
									Así las
									prácticas:
									- permiten la aplicación de los
									conocimientos en un
									medio profesional.
									- facilitan el paso del
									mundo de la enseñanza
									superior al de la empresa.
									Las prácticas no
									se consideran en
									ningún caso como un empleo.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">III - MARCO DE LAS PRÁCTICAS
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - La formalización del
									proyecto de prácticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El proyecto de prácticas resulta del concierto entre
									un profesor
									del centro de enseñanza, un miembro de la empresa y
									el alumno.
									Este proyecto de prácticas se formaliza al firmarse
									el convenio
									y debe ser firmado por el centro de enseñanza, la
									empresa y el
									alumno en prácticas.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - El convenio
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El convenio detalla los compromisos y
									responsabilidades del
									centro educativo, de la empresa y del
									alumno.
									Las rúbricas obligatorias se mencionan en el anexo de la
									reglamentación.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">3 - Duración de las prácticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La duración de las prácticas se especifica desde los
									primeros contactos entre
									el centro de enseñanza y la empresa. Se
									informará al estudiante
									al respecto.
									La duración de las prácticas
									figurará explícitamente en el
									convenio de prácticas.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">4 - Los responsables de la
									supervisión
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Las prácticas están sometidas a una doble
									supervisión realizada por:
									- Un profesor del establecimiento
									educativo;
									- Un miembro de la empresa.
									El profesor y el miembro
									de la empresa trabajan en colaboración,
									informándose mutuamente
									sobre el avance de las prácticas y las dificultades
									eventuales.
									El responsable de las prácticas en el seno del centro de
									enseñanza es el garante
									de la articulación entre los objetivos
									del ciclo formativo y los
									de las prácticas,
									según los principios
									de la presente reglamentación. Las respectivas
									instituciones
									reconocen la necesidad de su aportación, especialmente en
									tiempo
									consagrado
									a la supervisión de las prácticas.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">5 - Evaluación
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-style="italic" font-weight="bold">a -
									Evaluación del alumno en prácticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La actividad del alumno en prácticas será evaluada y
									dicha evaluación
									resultará de la doble apreciación de los
									responsables de la supervisión
									de las prácticas. Cada centro de
									enseñanza define el valor que
									concede a
									las prácticas que ha
									previsto en su programa pedagógico.
									Las
									modalidades concretas de
									evaluación se mencionan en el
									convenio.
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La evaluación se realiza mediante una "ficha de
									evaluación" que, al igual
									que el convenio, constituye parte del
									“expediente de prácticas“.
									Este expediente de prácticas es
									conservado por el centro de
									enseñanza.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-style="italic" font-weight="bold">b -
									Evaluación del as prácticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Se solicita a los firmantes del convenio que
									formulen
									una apreciación sobre la calidad de las prácticas.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">IV - OBLIGACIONES DE LOS
									FIRMANTES
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - El alumno ante la empresa
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El estudiante se compromete a :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Cumplir con su misión y estar disponible para las
									tareas que se le confíen;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Respetar las reglas, los códigos y la cultura
									organizacional de la empresa;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Respetar las exigencias de confidencialidad
									fijadas por la empresa;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Redactar, si es obligatorio, el informe o la memoria en el
									plazo previsto;
									Se deberá presentar este documento a los
									responsables de la
									empresa antes
									de ser presentado
									<fo:inline font-style="italic">
										(si el contenido lo requiere y
										la empresa así lo solicita, el
										informe será confidencial)).
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - La empresa ante el
									estudiante
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La empresa se compromete a:
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Proponer prácticas que se inscriban dentro del
									proyecto pedagógico
									definido por el centro educativo;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Acoger al estudiante y darle los medios necesarios
									para cumplir con su misión;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Designar a un responsable de prácticas o a un
									equipo de tutoría cuyas tareas serán:
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* guiar y aconsejar al estudiante
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* informarlo sobre las reglas, los códigos y la
									cultura organizacional de la empresa
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* favorecer su integración en el seno de la empresa
									y el acceso a las informaciones necesarias
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* ayudarle en la adquisición de las competencias
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* asegurar una supervisión regular de sus trabajos
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* evaluar la calidad del trabajo efectuado
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* aconsejarle en su proyecto profesional
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Redactar un certificado de prácticas que describa las
									misiones efectuadas,
									documento que podrá incluirse en el futuro
									<fo:inline font-style="italic">
										curriculum vitae
									</fo:inline>
									del estudiante.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">3 - El centro de enseñanza
									superior ante el estudiante
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El centro de enseñanza se compromete a:
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- definir los objetivos de las prácticas y
									asegurarse de que las prácticas propuestas respondan a ellos ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- asistir al estudiante en la búsqueda de prácticas;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- preparar al estudiante para las prácticas;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- garantizar el seguimiento del estudiante durante
									la duración de sus prácticas,
									asignándole un profesor que velará
									por el buen desarrollo de las
									prácticas;
									poner a la disposición
									de este último los medios necesarios para que
									pueda evaluar
									la
									calidad de las prácticas del estudiante;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- para las formaciones superiores que lo exijan,
									guiarlo y aconsejarle en la realización
									de su informe de
									prácticas o de su memoria y organizar la defensa
									de su
									tesis
									permitiendo que un representante de la empresa participe en
									ello.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">4 - La empresa y el centro de
									enseñanza
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La empresa y el centro de enseñanza superior velan
									por intercambiar
									la información necesaria antes, durante y
									después de las
									prácticas.
									Asimismo respetan sus respectivas
									reglas de confidencialidad y de
									deontología
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">5 - El estudiante ante los
									centros de enseñanza
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El alumno se compromete a entregar la ficha de
									evaluación de calidad
									de las prácticas al centro de enseñanza.
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