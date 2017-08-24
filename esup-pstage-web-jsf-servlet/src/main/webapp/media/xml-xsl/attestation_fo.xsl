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
			<xsl:call-template name="Attestation" />
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

	<xsl:template name="Attestation">
		<fo:block margin-right="1.5cm" margin-left="1.5cm"
				  margin-bottom="1.09cm" font-family="Times New Roman,serif"
				  padding-top="1.5cm">
			<fo:block text-align="center">
				<fo:inline hyphenate="false" language="fr" country="FR"
						   font-weight="bold" font-size="18pt">
					ATTESTATION DE STAGE
				</fo:inline>
			</fo:block>
			<fo:block text-align="center" padding-top="5pt">
				<fo:inline hyphenate="false" language="fr" country="FR"
						   font-weight="bold" font-size="16pt" font-style="italic">
					à remettre au
					stagiaire à l'issue du stage
				</fo:inline>
			</fo:block>
			<fo:block padding-top="60pt">
				<fo:table border="0.018cm solid #000000" padding="3pt"
						  width="100%" table-layout="fixed">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
										   padding-top="0.2cm">
								<fo:block font-size="9pt" font-weight="bold"
										  text-decoration="underline">
									ORGANISME D'ACCUEIL
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
									<fo:leader />
								</fo:block>
								<fo:block line-height="150%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
										  padding-bottom="0.035cm">
									<fo:inline font-weight="bold">Nom ou dénomination sociale :
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
									<fo:inline font-weight="bold">Tél : </fo:inline>
									<xsl:value-of select="structure/telephone" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block padding="0.3cm" font-weight="bold">
					Certifie que
				</fo:block>
				<fo:table border="0.018cm solid #000000" padding="3pt"
						  width="100%" table-layout="fixed">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell border="1" margin-left="0.2cm"
										   padding-top="0.2cm">
								<fo:block font-size="9pt" font-weight="bold"
										  text-decoration="underline">
									LE STAGIAIRE
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
										Nom :
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="translate(etudiant/nom,$lowers,$uppers)" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Prénom :
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
										Sexe :
									</fo:inline>
									<fo:inline>
										<xsl:value-of select="etudiant/code-sexe" />
									</fo:inline>
									<xsl:text>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</xsl:text>
									<fo:inline font-weight="bold">
										Né(e) le :
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
										Adresse :
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
											Tél :
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
											Mél :
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
										ÉTUDIANT EN (intitulé de la
										formation ou du cursus de
										l'enseignement supérieur suivi par le
										ou la stagiaire) :
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
										AU SEIN DE (nom de
										l'établissement d'enseignement supérieur ou
										de l'organisme de
										formation) :
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif"
										  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
										  padding-bottom="0.035cm">
									<fo:inline>
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
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block padding="0.3cm" font-weight="bold">
					A effectué un stage
					prévu dans le cadre de ses études
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
										DURÉE DU STAGE
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
										Dates de début et de fin du
										stage :
									</fo:inline>
									du
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:text> </xsl:text>
									au
									<xsl:text> </xsl:text>
									<fo:inline>
										......................................
									</fo:inline>
									<xsl:if test="@interruption-stage = 'true'">
										<xsl:text> </xsl:text>
										avec interruption du ......................................
										<xsl:text> </xsl:text>
										au
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
										Représentant une durée totale
										de
									</fo:inline>
									<fo:inline>
										..................... (Nombre de mois / Nombre de
										semaines) (rayer la mention inutile)
									</fo:inline>
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
						<xsl:if test="type-convention/code-ctrl != 'FC'">
							<fo:table-row>
								<fo:table-cell padding-top="0.2cm">
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
											  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.035cm"
											  padding-bottom="0.035cm" margin-left="0.5cm" text-align="justify">
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
										consécutifs ou non est considérée comme équivalente à
										un mois.
									</fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
										<fo:leader />
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
											MONTANT
											DE LA GRATIFICATION VERSÉE AU STAGIAIRE
										</fo:inline>
									</fo:block>
									<!-- <fo:block line-height="110%" language="fr" country="FR" -->
									<!-- font-size="9pt" font-family="Times New Roman,serif" -->
									<!-- padding-top="0.2cm"> -->
									<!-- <fo:inline> -->
									<!-- Le stagiaire a perçu une gratification de stage pour un -->
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
											  font-size="9pt" font-family="Times New Roman,serif"
											  padding-top="0.2cm">
										Le stagiaire a perçu une gratification de stage
										pour un
										montant total de ..................................
										&#8364; </fo:block>
									<fo:block line-height="110%" hyphenate="false"
											  language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
										<fo:leader />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</xsl:if>
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
									<xsl:if test="type-convention/code-ctrl != 'FC'">
										<fo:inline font-weight="bold">
											L'attestation de stage
										</fo:inline>
										est indispensable pour pouvoir, sous réserve du versement d'une
										cotisation, faire prendre en compte le stage dans les droits à
										retraite. La législation sur les retraites (loi n°2014-40 du 20
										Janvier 2014) ouvre aux étudiants
										<fo:inline font-weight="bold">
											dont le stage a été gratifié,
										</fo:inline>
										la possibilité de faire valider celui-ci dans la
										<fo:inline font-weight="bold">limite de deux trimestres,
										</fo:inline>
										sous réserve du
										<fo:inline font-weight="bold">versement d'une cotisation.
										</fo:inline>
										La
										<fo:inline font-weight="bold">demande est à faire par
											l'étudiant dans les deux années
										</fo:inline>
										suivant la fin du stage et sur
										<fo:inline font-weight="bold">présentation obligatoire de
											l'attestation de stage
										</fo:inline>
										mentionnant la durée totale du stage et
										le
										montant total de la
										gratification perçue. Les informations
										précises sur la
										cotisation
										à verser et sur la procédure à suivre
										sont à demander
										auprès de
										la Sécurité sociale
										(code de la
										sécurité
										sociale art.
										L.351-17 - code de l'éducation
										art.D.124-9).
									</xsl:if>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
										  padding-left="0.141cm" padding-right="0.141cm" padding-top="1cm"
										  padding-bottom="0.035cm">
									<fo:inline font-weight="bold">
										Fait à
										...................................................................
										le ........................
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
										  language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif"
										  padding-left="0.141cm" padding-right="0.141cm" padding-top="0.5cm"
										  padding-bottom="0.035cm">
									Nom, fonction et signature du représentant de
									l'organisme d'accueil
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</fo:block>
		</fo:block>

		<fo:block line-height="110%" hyphenate="false" language="fr"
				  country="FR" font-size="8pt" font-family="Times New Roman,serif"
				  padding-top="100pt" text-align="center">
			Date d'impression :
			<xsl:value-of
					select="java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())" />
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