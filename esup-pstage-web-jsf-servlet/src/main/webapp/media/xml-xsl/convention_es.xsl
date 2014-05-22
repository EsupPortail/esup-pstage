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
									pr�ticas /
								</fo:inline>
								<fo:inline font-size="9pt" font-weight="bold"
									text-decoration="underline">
									Anexo 2:
								</fo:inline>
								<fo:inline font-size="9pt">
									Fichas de evaluati�n /
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
								A�o acad�mico:
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
								Acuerdo de pr�cticas
								<xsl:text> </xsl:text>
								n�
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
							text-decoration="underline">Pr�ambule : stages hors administrations et �tablissement 
							publics de l'Etat�ne pr�sentant pas un caract�re industriel et commercial�: 
							</fo:inline> Les signataires de la pr�sente convention de stage reconnaissent 
							avoir pris connaissance de l'article 9 de la loi n�2006-396 pour l'�galit� 
							des chances modifi�e, de ses d�crets d'application, de la loi n� 2009-1437 
							du 24 novembre 2009 relative � l'orientation et � la formation professionnelle 
							tout au long de la vie ainsi que de la charte des stages (annexe 1). Ils 
							en acceptent les principes. <fo:inline text-decoration="underline">stages 
							en administrations et �tablissement publics de l'Etat�ne pr�sentant pas un 
							caract�re industriel et commercial : </fo:inline> Les signataires de la pr�sente 
							convention de stage reconnaissent avoir pris connaissance du d�cret 2009-885 
							du 21 juillet 2009 relatif aux modalit�s d'accueil des �tudiants de l'enseignement 
							sup�rieur en stage dans les administrations et �tablissements publics de 
							l'Etat ne pr�sentant pas un caract�re industriel et commercial. </fo:inline> 
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
								El establecimiento de ense�anza
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
							Direcci�n :
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
							Direcci�n: (si fuera diferente a la del establecimiento)
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
							Direcci�n :
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
									select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ��������������������������������������������������������������')" />
								<xsl:text> </xsl:text>
								<xsl:variable name="prenom1"
									select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
								<xsl:variable name="prenom2"
									select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
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
							Nombre del servicio en el que se efectuar�n las pr�cticas :
							<fo:inline font-weight="bold">
								<xsl:value-of select="service/nom" />
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%" hyphenate="false" language="fr"
							country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
							padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
							padding-bottom="0.035cm">
							Lugar de las pr�cticas: (si fuera diferente a la direcci�n del
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
								Y el estudiante en pr�cticas :
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
									select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
									select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
								<xsl:variable name="prenom2"
									select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
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
							Direcci�n :
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
							M�vil :
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
							T�tulo de la formaci�n o plan de estudios seguido
							en el establecimiento de ense�anza superior :
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
							TEMA DE LAS PR�CTICAS :
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
							PERIODO DE LAS PR�CTICAS : Del
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
								con interrupci�n : Del
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
							DURACI�N DE LAS PR�CTICAS :
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
								Acompa�amiento del estudiante en
								pr�cticas a cargo de :
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
							El establecimiento de ense�anza superior de origen
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
									select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
									select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
									select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
								<xsl:variable name="prenom2"
									select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
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
									select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
								<xsl:variable name="prenom2"
									select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
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
								Caja primaria de seguro m�dico a la que contactar en caso de
								accidente
								(en el lugar de residencia del estudiante salvo
								excepci�n) :
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
									Art�culo L612-9 del C�digo de Educaci�n franc�s : "La duraci�n
									de las pr�cticas efectuadas por un mismo estudiante no puede
									exceder seis meses por curso acad�mico", salvo excepciones.
								</fo:inline>
							</fo:block>
							<!-- <fo:block line-height="110%" hyphenate="false" language="fr" -->
							<!-- country="FR" font-size="8pt" font-family="Times New Roman,serif" -->
							<!-- font-weight="bold" font-style="italic"> -->
							<!-- <fo:inline font-size="5pt" vertical-align="super">2 -->
							<!-- </fo:inline> -->
							<!-- <fo:inline font-size="8pt"> Note de lecture : les caract�res -->
							<!-- gras et italiques s'appliquent aux -->
							<!-- stages en administration et -->
							<!-- �tablissements publics de l'Etat. -->
							<!-- </fo:inline> -->
							<!-- </fo:block> -->
							<!-- <fo:block line-height="110%" hyphenate="false" language="fr" -->
							<!-- country="FR" font-size="8pt" font-family="Times New Roman,serif" -->
							<!-- padding-top="5pt"> -->
							<!-- convention imprim�e le : -->
							<!-- <xsl:value-of -->
							<!-- select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy 
								kk:mm:ss'), java:java.util.Date.new())" /> -->
							<!-- Exemplaire destin� � : organisme d'accueil / �tablissement -->
							<!-- d'origine / �tudiant. -->
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
								font-weight="bold">Art�culo 1: Objeto del acuerdo
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El presente acuerdo regula las relaciones del organismo de
								acogida (empresa, organismo p�blico, asociaci�n...) con el
								establecimiento de ense�anza superior y el estudiante en
								pr�cticas.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Art�culo 2: Objetivo de las pr�cticas</fo:block>

							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Las pr�cticas de formaci�n permiten al estudiante acceder a un
								entorno profesional de manera temporal y adquirir competencias
								profesionales que ponen en pr�ctica los conocimientos adquiridos
								durante su formaci�n con vistas a la obtenci�n de un t�tulo o
								certificaci�n. El estudiante en pr�cticas recibe una o varias
								misiones relacionadas con el proyecto pedag�gico del
								establecimiento de ense�anza y aprobadas por el organismo de
								acogida.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								El programa de las pr�cticas es dise�ado entre el
								establecimiento y el organismo de acogida en funci�n del
								programa general de la formaci�n impartida.
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
								<fo:inline font-weight="bold">Art�culo 3: Modalidad de las
									pr�cticas
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La duraci�n semanal m�xima de presencia del o de la estudiante
								en pr�cticas en la empresa ser� de
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" />
								</fo:inline>
								horas.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Las pr�cticas son
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
								Si el o la estudiante en pr�cticas debe estar presente en el
								organismo de acogida durante la noche, los domingos o un d�a
								festivo, el organismo debe precisar a continuaci�n los casos
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
								font-weight="bold">Art�culo 4: Estatus del estudiante en pr�cticas -
								Acogida y acompa�amiento
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								El o la estudiante, durante el periodo de pr�cticas
								en el organismo de acogida, conserva su estatus anterior y
								recibir�
								seguimiento regular por parte del establecimiento. El
								organismo de acogida
								nombra a un tutor responsable del
								seguimiento
								y de la optimizaci�n de las condiciones de
								realizaci�n de las
								pr�cticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								El o la estudiante podr� volver al establecimiento de
								ense�anza durante el periodo de las pr�cticas para asistir
								a
								ciertas clases expl�citamente requeridas por el programa y
								participar en reuniones, cuyas fechas ser�n
								pertinentemente
								transmitidas al organismo de acogida por parte del
								establecimiento, en cuyo caso, el o la estudiante estar�
								autorizado a desplazarse.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Modalidades de acompa�amiento :
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
								Art�culo 5: Gratificaci�n - Retribuciones en especie - Reembolso
								de gastos
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Cuando la duraci�n de las pr�cticas exceda los dos meses,
								consecutivos o no, estas deben ser objeto de una gratificaci�n
								dentro el territorio franc�s, salvo normas particulares
								aplicables en algunos municipios de ultramar o en virtud del
								art�culo L4381-1 del C�digo de Salud P�blica franc�s.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								La gratificaci�n est� fijada por el convenio colectivo
								correspondiente, sectorial o nacional, y en su defecto, en un
								12,5% de la base m�xima horaria de cotizaci�n de la seguridad
								social definida en aplicaci�n del art�culo L 241-3 del C�digo de
								la Seguridad Social franc�s.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Se entiende que para las
								pr�cticas en administraciones o en establecimientos p�blicos
								administrativos del Estado, la gratificaci�n es obligatoriamente
								igual a la base m�xima precitada.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" padding-top="1pt"
								padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Cuando la duraci�n de las pr�cticas es inferior o igual a dos
								meses, el o la estudiante puede percibir una gratificaci�n, en
								empresas privadas o p�blicas, en asociaciones, dentro del
								territorio franc�s.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Importe de la gratificaci�n (si difiere del importe establecido
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
								Modalidades de pago de la gratificaci�n :
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
								Si el o la estudiante en pr�cticas se beneficia de retribuciones
								en especie (comidas gratis, por ejemplo), el importe que
								representa el valor de estas retribuciones se a�adir� al importe
								de la gratificaci�n mensual antes de comparaci�n con el 12,5% de
								la base m�xima horaria de la seguridad social para una duraci�n
								legal de trabajo semanal de 35 horas.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Los gastos de desplazamiento y de alojamiento realizados por el
								o la estudiante a petici�n del organismo, as� como los gastos de
								misi�n eventualmente necesarios para las pr�cticas, correr�n
								�ntegramente a cargo del o la estudiante seg�n las modalidades
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
								Los estudiantes en pr�cticas acceden a las
								actividades sociales y culturales mencionadas en el art�culo
								L2323-83 del C�digo de Trabajo franc�s en las mismas condiciones
								que los asalariados.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Cuando las pr�cticas se
								desarrollen en administraciones o establecimientos p�blicos
								administrativos del Estado, los gastos de misi�n mencionados
								anteriormente del o la estudiante ser�n sufragados de
								conformidad con el decreto 2006-781, siendo su residencia
								administrativa el lugar de las pr�cticas.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-style="italic" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Para las pr�cticas en
								administraciones o establecimientos p�blicos del Estado: costeo
								de los trayectos entre el domicilio y el lugar de las pr�cticas,
								seg�n las condiciones del decreto 2010-676:
								...................(indicar s� o no)
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">Art�culo 6: Protecci�n social
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Durante el periodo de las pr�cticas, el o la
								estudiante permanece afiliado a su sistema de seguridad social
								anterior: conserva su estatus de estudiante. Las pr�cticas
								efectuadas en el extranjero deben haberse se�alado previamente a
								la partida del o la estudiante y haber recibido la aprobaci�n de
								la Seguridad Social.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Las siguientes disposiciones son aplicables siempre y
								cuando sean conformes con la legislaci�n del pa�s de destino y
								con la legislaci�n espec�fica por la que se rige el organismo de
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
									Gratificaci�n inferior o igual
								</fo:inline>
								al producto de 12,5% de la base m�xima horaria de la seguridad
								social por el n�mero de horas de pr�cticas efectuadas durante el
								mes considerado:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En este caso, conformemente a la legislaci�n vigente,
								la gratificaci�n de las pr�cticas no est� sometida a cotizaci�n
								social.
								El o la estudiante sigue benefici�ndose de la legislaci�n
								que
								regula los accidentes de trabajo en virtud del art�culo L
								412-8-2 del C�digo de la Seguridad Social franc�s, r�gimen
								"estudiante".
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Si el o la estudiante sufriera un accidente, bien durante el
								desarrollo de su actividad en el organismo, bien durante el
								trayecto o en los lugares considerados �tiles para las
								necesidades de sus pr�cticas
								<fo:inline font-size="10pt" font-style="italic">
									y, en el caso
									de los/las estudiantes en medicina, en cirug�a dental o en
									farmacia que no tengan estatus de personal de hospital, para
									las necesidades de las pr�cticas en hospital efectuadas en las
									condiciones previstas en b del 2� apartado del art�culo L.
									412-8,
								</fo:inline>
								<fo:inline font-size="10pt" font-weight="bold">
									organismo de
									acogida enviar� la declaraci�n de accidente
								</fo:inline>
								a la Caja Primaria de Seguro M�dico (ver direcci�n en la primera
								p�gina)
								donde se indicar� al establecimiento como empleador.
								Asimismo,
								deber� enviar
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
									Gratificaci�n superior
								</fo:inline>
								al producto de 12,5% de la base m�xima horaria de la seguridad
								social por el n�mero de horas de pr�cticas efectuadas durante el
								mes considerado:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Las cotizaciones sociales se calculan en base al
								diferencial entre
								el importe de la gratificaci�n y 12,5% de la
								base m�xima horaria
								de la Seguridad Social para una duraci�n
								legal de trabajo
								semanal de 35 horas.
							</fo:block>
							<!--<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times 
								New Roman,serif" text-align="justify"> L'�tudiant(e) b�n�ficie de la couverture 
								l�gale en application des dispositions des articles L 411-1 et suivants du 
								code de la S�curit� Sociale. En cas d'accident survenant � l'�tudiant(e), 
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
								aplicaci�n de
								las disposiciones de los art�culos L 411-1 y
								siguientes del
								C�digo de la Seguridad Social franc�s. En el
								supuesto que el o la
								estudiante sufriera un accidente, bien
								durante el desarrollo de
								su actividad en el organismo, bien
								durante el trayecto o en los
								lugares considerados �tiles para
								las necesidades de sus
								pr�cticas, el organismo de acogida
								efectuar� todos los tr�mites
								necesarios para con la Caja
								Primaria de Seguro M�dico e informar�
								al establecimiento en la
								mayor brevedad posible.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">6.3 Protecci�n
									m�dica del o la estudiante en el extranjero :
								</fo:inline>
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								1) Protecci�n
								derivada del r�gimen "estudiante" franc�s:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- Para las pr�cticas dentro del Espacio Econ�mico Europeo (EEE)
								efectuadas por los/las estudiantes de
								nacionalidad de un pa�s
								miembro de la Uni�n Europea, el o la estudiante debe
								solicitar la
								Tarjeta Sanitaria Europea
								<fo:inline font-size="10pt" text-decoration="underline">(TSE)
								</fo:inline>
								.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="1pt" padding-bottom="1pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								- Para las pr�cticas efectuadas en Quebec por los/las
								estudiantes de nacionalidad francesa, el/la estudiante debe
								solicitar el formulario
								<fo:inline font-size="10pt" text-decoration="underline">SE401Q
								</fo:inline>
								(104 para las pr�cticas en empresa, 106 para las pr�cticas en
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
								presentaci�n de los justificantes
								correspondientes: el reembolso
								se efect�a en base a las tarifas sanitarias
								francesas, por lo que
								pueden existir diferencias importantes.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								� Por ello, se recomienda vivamente al o la
								estudiante suscribir un seguro m�dico complementario espec�fico,
								v�lido para el pa�s
								de destino y el periodo de las pr�cticas, a
								trav�s del organismo
								de acogida de su elecci�n (mutua para los
								estudiantes, mutua de
								los padres, compa��a privada de seguros ad
								hoc.).
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt"
								padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
								font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								�
								<fo:inline font-size="10pt" text-decoration="underline">Excepci�n
								</fo:inline>
								: si el organismo de acogida proporciona al o la estudiante una
								cobertura m�dica en virtud de las disposiciones del derecho
								local (ver 2 m�s abajo), el o la estudiante puede elegir
								beneficiarse de esta protecci�n m�dica local. Antes de efectuar
								dicha elecci�n, debe verificar la extensi�n de las garant�as
								ofertadas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">2) Protecci�n
									proporcionada por el organismo de acogida :
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Al marcar la
								casilla correspondiente, el organismo de acogida
								indica a
								continuaci�n si proporciona una protecci�n
								m�dica al o la
								estudiante en pr�cticas, en virtud del derecho local :
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-size="10pt" font-weight="bold">SI</fo:inline>
								(esta se a�ade a la conservaci�n, en el extranjero, de los
								derechos inherentes al r�gimen franc�s "estudiante").
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-size="10pt" font-weight="bold">NO</fo:inline>
								(la protecci�n procede �nicamente de la conservaci�n, en el
								extranjero, de los derechos inherentes al r�gimen franc�s
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
									6.4 Protecci�n
									ante accidentes de trabajo del o la estudiante en el
									extranjero:
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								1) Para poder beneficiarse de la legislaci�n francesa
								sobre la cobertura de accidentes de trabajo, las presentes
								pr�cticas deben:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Tener una duraci�n m�xima igual a 12 meses,
								prolongaciones incluidas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- No dar lugar a ninguna remuneraci�n susceptible
								de
								abrir derechos a una protecci�n contra accidentes laborales
								en el
								pa�s de destino (se admite una indemnizaci�n o
								gratificaci�n en
								un m�ximo de 12,5% de la base m�xima horaria de
								la seguridad
								social para una duraci�n legal semanal de 35 horas
								bajo el
								consentimiento de la Caja Primaria de Seguro M�dico).
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
								- Desarrollarse exclusivamente en el pa�s extranjero
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
								a cotizar para la protecci�n del estudiante en pr�cticas y a
								hacer las declaraciones necesarias en caso de accidente de
								trabajo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								2) La
								declaraci�n
								de los accidentes de trabajo concierne al
								establecimiento de
								ense�anza que debe ser informado por escrito
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
								- En el recinto del lugar de las pr�cticas y durante
								las horas de pr�cticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Durante el trayecto de ida y vuelta habitual entre
								la residencia del estudiante en pr�cticas en el territorio
								extranjero y el lugar de las pr�cticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- En el trayecto de ida y vuelta (al inicio y al
								final de las pr�cticas) del domicilio del estudiante en
								pr�cticas situado en territorio franc�s y el lugar de residencia
								en el extranjero
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- En el contexto de una misi�n encomendada por el
								organismo de acogida y obligatoriamente recogida por escrito.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								4) En caso de
								cumplirse una sola condici�n de las previstas en el punto 6.4
								1/, el organismo de acogida se compromete por el presente
								acuerdo a cubrir al estudiante en pr�cticas contra el riesgo de
								accidente de trabajo, de trayecto y enfermedades profesionales
								as� como encargarse de todas las declaraciones necesarias.
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
								las pr�cticas, el organismo de acogida debe imperativamente
								se�alar este accidente al establecimiento de
								<fo:inline font-size="10pt" text-decoration="underline">manera
									inmediata.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								- Si el estudiante cumple misiones fuera del
								organismo de acogida o fuera del pa�s de las pr�cticas, el
								organismo de acogida debe realizar todos los tr�mites necesarios
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
								Art�culo 7: Responsabilidad civil y seguros
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
								Independientemente de la naturaleza de las pr�cticas
								y del pa�s de destino, el o la estudiante en pr�cticas se
								compromete a suscribir un contrato de asistencia (repatriaci�n o
								traslado sanitario, asistencia legal, etc.) y un contrato de
								seguro individual de accidentes.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de que el organismo de acogida ponga un
								veh�culo a disposici�n del o de la estudiante en pr�cticas, ser�
								su responsabilidad verificar previamente que la p�liza de seguro
								del veh�culo cubre la utilizaci�n por un estudiante.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									En caso de que, en el marco de
									las pr�cticas, el o la estudiante utilice su propio veh�culo o
									un veh�culo prestado por un tercero, �l o ella declarar�
									expresamente al asegurador de dicho veh�culo la utilizaci�n que
									�l o ella piensa hacer del mismo y, en su caso, abonar� la
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
								Art�culo 8: Disciplina
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Durante las
								pr�cticas, el o la estudiante se somete a la disciplina y al
								reglamento interior del organismo (que debe ser puesto en
								conocimiento del o de la estudiante), en especial, en lo
								referente a los horarios y las normas de higiene y seguridad
								vigentes en el organismo de acogida.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								El establecimiento es el �nico que tiene potestad
								para decidir cualquier sanci�n disciplinaria. En su caso, el
								organismo de acogida informar� al establecimiento de las
								infracciones y eventualmente le proporcionar� los elementos
								constitutivos de la infracci�n.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En caso de infracci�n disciplinaria particularmente
								grave, el organismo de acogida se reserva el derecho de
								finalizar las pr�cticas de conformidad con las disposiciones
								fijadas en el art�culo 9 del presente acuerdo.
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
								Art�culo 9: Ausencia e interrupci�n de las pr�cticas
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Todos los
								interesados deber�n ser informados de
								cualquier dificultad
								surgida durante el desarrollo de las
								pr�cticas con el objetivo
								de resolverla en la mayor brevedad
								posible.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interrupci�n temporal:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Durante las pr�cticas,
								el estudiante podr� beneficiarse de d�as de vacaciones bajo el
								consentimiento del organismo de acogida y siempre y cuando se
								respete la duraci�n de las pr�cticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Para cualquier otra
								interrupci�n temporal de las pr�cticas (enfermedad, maternidad,
								ausencia injustificada...), el organismo de acogida deber�
								informar al responsable del establecimiento por correo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Interrupci�n definitiva :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:inline font-size="10pt" font-weight="bold">
									En el caso de
									que una de las tres partes (organismo de acogida,
									establecimiento, estudiante) deseara interrumpir de manera
									definitiva las pr�cticas,
								</fo:inline>
								esta deber� informar inmediatamente a las otras dos partes por
								escrito. Las razones argumentadas se examinar�n en estrecha
								concertaci�n. La decisi�n definitiva de interrupci�n de las
								pr�cticas se tomar� �nicamente tras dicha fase de concertaci�n.
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
								Art�culo 10: Deber de reserva y confidencialidad
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								El deber de
								reserva es de rigor absoluto. Los o las estudiantes en pr�cticas
								se comprometen, por lo tanto, a no utilizar bajo ninguna
								circunstancia las informaciones obtenidas para su publicaci�n o
								comunicaci�n a terceros sin previo consentimiento del organismo
								de acogida, el informe de las pr�cticas inclusive. Este
								compromiso no solo ser� v�lido durante el periodo de las
								pr�cticas sino que se extender� tras su finalizaci�n. El o la
								estudiante se compromete a no conservar, llevarse o copiar
								ning�n documento o software, independientemente de su
								naturaleza, que pertenezca al organismo de acogida, salvo
								consentimiento de este �ltimo.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									Nota: En raz�n de la
									confidencialidad de las informaciones contenidas en el informe,
									el organismo de acogida puede solicitar una restricci�n de la
									difusi�n del informe o, incluso, la retirada de ciertos
									elementos confidenciales.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal"
								text-align="justify">
								<fo:inline font-size="10pt">
									Las personas que accedan a dichas
									informaciones est�n obligadas por el secreto profesional a no
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
								Art�culo 11: Propiedad intelectual
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								De conformidad con el C�digo de Propiedad Intelectual
								franc�s, si el trabajo del estudiante en pr�cticas desembocara
								en la creaci�n de una obra protegida con derechos de autor o de
								la propiedad industrial (software incluido), y en cuyo caso, el
								organismo de acogida deseara utilizarla y el estudiante en
								pr�cticas estuviera de acuerdo, este �ltimo (el autor) y el
								organismo de acogida deber�n suscribir un contrato.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								En particular, deber� precisarse la extensi�n de los
								derechos cedidos, una posible exclusividad, la finalidad, los
								soportes utilizados y la duraci�n de la cesi�n as� como, en su
								caso, el importe de la remuneraci�n debida al estudiante en
								concepto de dicha cesi�n.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">
								Esta cl�usula
								tambi�n se aplica en el caso de las pr�cticas desarrolladas en
								los organismos p�blicos.
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
								Art�culo 12: Contrataci�n
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								En el caso de
								firmarse un contrato de trabajo con el organismo de acogida
								antes del t�rmino de las pr�cticas, el presente acuerdo quedar�
								obsoleto; el o la "estudiante" dejar� de ser responsabilidad del
								establecimiento de ense�anza. Este �ltimo deber� ser informado
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
								Art�culo 13: Final de las
								pr�cticas - Informe - Evaluaci�n
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								padding-top="2pt" padding-bottom="2pt" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Al t�rmino de las
								pr�cticas, el organismo de acogida entregar� al estudiante un
								certificado de pr�cticas y completar� una ficha de evaluaci�n de
								la actividad del estudiante en pr�cticas (anexo) que remitir� al
								establecimiento de ense�anza superior.
							</fo:block>
						</fo:table-cell>
						<fo:table-cell>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Al t�rmino de sus pr�cticas, el estudiante deber�: (precisar la
								naturaleza del trabajo que eventualmente deba entregar y
								adjuntar un anexo)
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Precisar, en su caso, las modalidades de validaci�n de las
								pr�cticas :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								N�mero de cr�ditos ECTS :
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
								Evaluaci�n de la
								calidad de las pr�cticas: Al t�rmino de las pr�cticas, se
								invitar� a las tres partes interesadas a formular una
								apreciaci�n sobre la calidad de las pr�cticas.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								El tutor responsable
								del organismo de acogida o cualquier otro miembro del organismo
								de acogida que deba acudir a el establecimiento en el marco de
								la preparaci�n, del desarrollo y la validaci�n de las pr�cticas
								no puede aspirar a ning�n tipo de sufrago o indemnizaci�n por
								parte del establecimiento.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Se podr� introducir
								una adenda al acuerdo en caso de prolongaci�n de las pr�cticas,
								a petici�n del organismo y del o de la estudiante. En ning�n
								caso la fecha de finalizaci�n de las pr�cticas podr� ser
								posterior al 30/09 del a�o en curso.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								La recepci�n sucesiva
								de estudiantes en pr�cticas, en el marco de acuerdos de
								pr�cticas diferentes, para efectuar pr�cticas en un mismo puesto
								solo es posible tras la expiraci�n de un plazo de carencia igual
								al tercio de la duraci�n de las pr�cticas precedentes. Esta
								disposici�n no se aplica en el caso de que las pr�cticas
								precedentes hayan sido interrumpidas antes de llegar a t�rmino a
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
								Art�culo 14: Sumisi�n expresa
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								El presente acuerdo
								est� �nicamente regido por el Derecho franc�s. Cualquier litigio
								no resuelto por v�a amistosa se someter� la jurisdicci�n de los
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
								Por el establecimiento de ense�anza
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
												select="translate(substring(./centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
											<xsl:variable name="prenom2"
												select="translate(centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
											<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
											<xsl:text> </xsl:text>
											<xsl:value-of
												select="translate(centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
										select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2"
										select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
										select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2"
										select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
								<fo:inline text-decoration="underline">RATIFICACI�N DE LOS TUTORES
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
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2"
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
								ense�anza superior
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
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2"
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))" />
									<xsl:text> </xsl:text>
									<xsl:value-of
										select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
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
								<fo:inline font-weight="bold">REGLAMENTACI�N DE LAS PR�CTICAS
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
								El Ministro de Empleo, de Cohesi�n
								social y de Vivienda
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro de Educaci�n nacional,
								de Ense�anza superior y de Investigaci�n
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro delegado de Empleo,
								Trabajo e Inserci�n profesional de los j�venes
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="left" font-style="italic">
								El Ministro delegado de Ense�anza
								superior y de Investigaci�n
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
									text-align="justify" font-weight="bold">I - INTRODUCCI�N
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El desarrollo de las pr�cticas es hoy en d�a
									fundamental para la orientaci�n e inserci�n profesional de los
									j�venes. En efecto, las
									pr�cticas permiten la aplicaci�n de los
									conocimientos te�ricos dentro de
									un marco profesional y ofrecen
									al estudiante una
									experiencia en el mundo empresarial. Dentro de
									esta perspectiva, es
									fundamental que se tenga en cuenta que las
									pr�cticas tienen
									una finalidad pedag�gica, es decir que no puede
									haber pr�ctica
									alguna si �sta no est� inscrita dentro de un
									programa
									pedag�gico.
									En ning�n caso se deben considerar las
									pr�cticas como un empleo.
									La presente reglamentaci�n, redactada
									por servicios del
									Estado, representantes de empresas,
									representantes de establecimientos
									de la ense�anza superior y
									delegados estudiantiles;
									tiene por objetivo establecer un marco
									m�s seguro para las pr�cticas
									y promover al mismo tiempo su
									desarrollo tanto entre los
									j�venes
									como en las empresas.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">II - �MBITO DE APLICACI�N,
									DEFINICI�N
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - El �mbito de aplicaci�n
									del convenio
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El �mbito de aplicaci�n de la presente
									reglamentaci�n se extiende a todas las pr�cticas profesionales
									de los estudiantes en una
									empresa, sin perjuicio en la
									aplicaci�n de reglas particulares
									aplicables a profesiones
									reglamentadas.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">2 - Las pr�cticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La finalidad de las pr�cticas se encuadra dentro de
									un proyecto pedag�gico
									y es v�lida s�lo con relaci�n a dicho
									proyecto.
									As� las
									pr�cticas:
									- permiten la aplicaci�n de los
									conocimientos en un
									medio profesional.
									- facilitan el paso del
									mundo de la ense�anza
									superior al de la empresa.
									Las pr�cticas no
									se consideran en
									ning�n caso como un empleo.
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">III - MARCO DE LAS PR�CTICAS
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">1 - La formalizaci�n del
									proyecto de pr�cticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El proyecto de pr�cticas resulta del concierto entre
									un profesor
									del centro de ense�anza, un miembro de la empresa y
									el alumno.
									Este proyecto de pr�cticas se formaliza al firmarse
									el convenio
									y debe ser firmado por el centro de ense�anza, la
									empresa y el
									alumno en pr�cticas.
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
									Las r�bricas obligatorias se mencionan en el anexo de la
									reglamentaci�n.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">3 - Duraci�n de las pr�cticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La duraci�n de las pr�cticas se especifica desde los
									primeros contactos entre
									el centro de ense�anza y la empresa. Se
									informar� al estudiante
									al respecto.
									La duraci�n de las pr�cticas
									figurar� expl�citamente en el
									convenio de pr�cticas.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">4 - Los responsables de la
									supervisi�n
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Las pr�cticas est�n sometidas a una doble
									supervisi�n realizada por:
									- Un profesor del establecimiento
									educativo;
									- Un miembro de la empresa.
									El profesor y el miembro
									de la empresa trabajan en colaboraci�n,
									inform�ndose mutuamente
									sobre el avance de las pr�cticas y las dificultades
									eventuales.
									El responsable de las pr�cticas en el seno del centro de
									ense�anza es el garante
									de la articulaci�n entre los objetivos
									del ciclo formativo y los
									de las pr�cticas,
									seg�n los principios
									de la presente reglamentaci�n. Las respectivas
									instituciones
									reconocen la necesidad de su aportaci�n, especialmente en
									tiempo
									consagrado
									a la supervisi�n de las pr�cticas.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">5 - Evaluaci�n
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-style="italic" font-weight="bold">a -
									Evaluaci�n del alumno en pr�cticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La actividad del alumno en pr�cticas ser� evaluada y
									dicha evaluaci�n
									resultar� de la doble apreciaci�n de los
									responsables de la supervisi�n
									de las pr�cticas. Cada centro de
									ense�anza define el valor que
									concede a
									las pr�cticas que ha
									previsto en su programa pedag�gico.
									Las
									modalidades concretas de
									evaluaci�n se mencionan en el
									convenio.
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La evaluaci�n se realiza mediante una "ficha de
									evaluaci�n" que, al igual
									que el convenio, constituye parte del
									�expediente de pr�cticas�.
									Este expediente de pr�cticas es
									conservado por el centro de
									ense�anza.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-style="italic" font-weight="bold">b -
									Evaluaci�n del as pr�cticas
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Se solicita a los firmantes del convenio que
									formulen
									una apreciaci�n sobre la calidad de las pr�cticas.
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
									- Cumplir con su misi�n y estar disponible para las
									tareas que se le conf�en;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Respetar las reglas, los c�digos y la cultura
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
									Se deber� presentar este documento a los
									responsables de la
									empresa antes
									de ser presentado
									<fo:inline font-style="italic">
										(si el contenido lo requiere y
										la empresa as� lo solicita, el
										informe ser� confidencial)).
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
									- Proponer pr�cticas que se inscriban dentro del
									proyecto pedag�gico
									definido por el centro educativo;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Acoger al estudiante y darle los medios necesarios
									para cumplir con su misi�n;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- Designar a un responsable de pr�cticas o a un
									equipo de tutor�a cuyas tareas ser�n:
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
									* informarlo sobre las reglas, los c�digos y la
									cultura organizacional de la empresa
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* favorecer su integraci�n en el seno de la empresa
									y el acceso a las informaciones necesarias
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* ayudarle en la adquisici�n de las competencias
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									* asegurar una supervisi�n regular de sus trabajos
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
									- Redactar un certificado de pr�cticas que describa las
									misiones efectuadas,
									documento que podr� incluirse en el futuro
									<fo:inline font-style="italic">
										curriculum vitae
									</fo:inline>
									del estudiante.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">3 - El centro de ense�anza
									superior ante el estudiante
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El centro de ense�anza se compromete a:
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- definir los objetivos de las pr�cticas y
									asegurarse de que las pr�cticas propuestas respondan a ellos ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- asistir al estudiante en la b�squeda de pr�cticas;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- preparar al estudiante para las pr�cticas;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- garantizar el seguimiento del estudiante durante
									la duraci�n de sus pr�cticas,
									asign�ndole un profesor que velar�
									por el buen desarrollo de las
									pr�cticas;
									poner a la disposici�n
									de este �ltimo los medios necesarios para que
									pueda evaluar
									la
									calidad de las pr�cticas del estudiante;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- para las formaciones superiores que lo exijan,
									guiarlo y aconsejarle en la realizaci�n
									de su informe de
									pr�cticas o de su memoria y organizar la defensa
									de su
									tesis
									permitiendo que un representante de la empresa participe en
									ello.
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">4 - La empresa y el centro de
									ense�anza
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									La empresa y el centro de ense�anza superior velan
									por intercambiar
									la informaci�n necesaria antes, durante y
									despu�s de las
									pr�cticas.
									Asimismo respetan sus respectivas
									reglas de confidencialidad y de
									deontolog�a
								</fo:block>
								<fo:block line-height="110%" padding-top="2pt"
									padding-bottom="2pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">5 - El estudiante ante los
									centros de ense�anza
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt"
									padding-bottom="1pt" hyphenate="false" language="fr" country="FR"
									font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									El alumno se compromete a entregar la ficha de
									evaluaci�n de calidad
									de las pr�cticas al centro de ense�anza.
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