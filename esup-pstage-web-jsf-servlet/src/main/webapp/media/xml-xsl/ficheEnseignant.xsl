<!-- <?xml version="1.0" encoding="ISO-8859-1" ?> -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes="java">

	<xsl:template match="/">

		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fo/extensions">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="all"
					border="" page-height="29.699cm" page-width="20.999cm"
					margin-right="0.5cm" margin-left="0.5cm" margin-bottom="1.5cm"
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
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:apply-templates select="convention-dTO" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="convention-dTO">
		<fo:block>
			<!-- appel mise en page -->
			<xsl:call-template name="miseEnPage" />
		</fo:block>
	</xsl:template>

	<!-- structure du document -->
	<xsl:template name="miseEnPage">

		<xsl:call-template name="entete" />

		<fo:block margin-right="1.5cm" margin-left="1.5cm"
			margin-bottom="1.09cm" font-family="Times New Roman,serif">
			<xsl:call-template name="contenu" />
		</fo:block>
	</xsl:template>

	<!-- entete -->
	<xsl:template name="entete">
		<fo:block>
			<fo:external-graphic>
				<xsl:attribute name="src">
					<xsl:value-of select="document('config.xml')/config/logoUniversite" />
				</xsl:attribute>
			</fo:external-graphic>
		</fo:block>
		<fo:block text-align="center">
			<fo:inline hyphenate="false" language="fr" country="FR"
				font-weight="bold" font-size="18pt">
				Evaluation du stage par le tuteur
				pédagogique
			</fo:inline>
		</fo:block>
		<fo:block line-height="110%" padding-top="5pt" hyphenate="false"
			language="fr" country="FR" font-size="11.5pt" text-align="center">
			<fo:inline font-weight="bold">
				Convention de stage n°
				<xsl:text> </xsl:text>
				<xsl:value-of select="id-convention" />
			</fo:inline>
		</fo:block>
	</xsl:template>

	<!-- partie contenu -->
	<xsl:template name="contenu">
		<fo:block padding-top="1cm" language="fr" country="FR"
			font-size="14pt" font-weight="bold">
			I.
			<fo:inline text-decoration="underline">
				Suivi du stagiaire pendant son
				stage
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-ens-i1 = 'true'">
			<fo:block padding-top="0.5cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Modalité d'échange avec
				le stagiaire
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-i1a = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i1a = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Téléphone&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i1b = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i1b = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Mail&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i1c = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i1c = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Rencontre
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-i2 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Modalité d'échange avec
				le tuteur professionnel
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-i2a = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i2a = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Téléphone&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i2b = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i2b = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Mail&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i2c = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i2c = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Rencontre
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-i3 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Commentaire(s) ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:value-of select="reponse-evaluation/reponse-ens-i3" />
			</fo:block>
		</xsl:if>
		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 4">
				<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					-
					<xsl:value-of select="question" />
				</fo:block>
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:choose>
						<xsl:when test="type-question = 'TXT'">
							<xsl:value-of select="reponse-supplementaire/reponse-txt" />
						</xsl:when>
						<xsl:when test="type-question = 'BOOL'">
							<xsl:if test="reponse-supplementaire/@reponse-bool = 'true'">
								Oui
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-bool = 'false'">
								Non
							</xsl:if>
						</xsl:when>
						<xsl:when test="type-question = 'INT'">
							<xsl:if test="reponse-supplementaire/@reponse-int = 1">
								Excellent
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 2">
								Très Bien
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 3">
								Bien
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 4">
								Satisfaisant
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 5">
								Insuffisant
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>

						</xsl:otherwise>
					</xsl:choose>
				</fo:block>
			</xsl:if>
		</xsl:for-each>
		<fo:block padding-top="0.5cm" language="fr" country="FR"
			font-size="14pt" font-weight="bold">
			II.
			<fo:inline text-decoration="underline">
				Evaluation du stagiaire
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-ens-iI1 = 'true'">
			<fo:block padding-top="0.5cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Impression générale et
				présentation de l'étudiant ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI2 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Aptitude à cerner et
				situer le projet ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI3 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Aptitude à appliquer ses
				connaissances ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI4 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Maîtrise du sujet,
				argumentation, analyse ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI5 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Mise en évidence des
				éléments importants de l'étude ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI6 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Utilisation des moyens
				de communication ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI7 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Qualité de l'expression
				orale ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI8 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Capacité à intéresser
				l'auditoire ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI9 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Pertinence des réponses
				?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI10 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Respect du temps alloué
				?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 4">
					Satisfaisant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 5">
					Insuffisant
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI11 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Commentaire(s) ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:value-of select="reponse-evaluation/reponse-ens-iI11" />
			</fo:block>
		</xsl:if>
		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 5">
				<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					-
					<xsl:value-of select="question" />
				</fo:block>
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:choose>
						<xsl:when test="type-question = 'TXT'">
							<xsl:value-of select="reponse-supplementaire/reponse-txt" />
						</xsl:when>
						<xsl:when test="type-question = 'BOOL'">
							<xsl:if test="reponse-supplementaire/@reponse-bool = 'true'">
								Oui
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-bool = 'false'">
								Non
							</xsl:if>
						</xsl:when>
						<xsl:when test="type-question = 'INT'">
							<xsl:if test="reponse-supplementaire/@reponse-int = 1">
								Excellent
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 2">
								Très Bien
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 3">
								Bien
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 4">
								Satisfaisant
							</xsl:if>
							<xsl:if test="reponse-supplementaire/@reponse-int = 5">
								Insuffisant
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>

						</xsl:otherwise>
					</xsl:choose>
				</fo:block>
			</xsl:if>
		</xsl:for-each>
		<fo:block id="theEnd" />
	</xsl:template>

</xsl:stylesheet>