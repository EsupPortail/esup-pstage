<!-- <?xml version="1.0" encoding="ISO-8859-1" ?> -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes="java">

	<xsl:variable name='notation1' select='"Excellent"' />
	<xsl:variable name='notation2' select='"Très Bien"' />
	<xsl:variable name='notation3' select='"Bien"' />
	<xsl:variable name='notation4' select='"Satisfaisant"' />
	<xsl:variable name='notation5' select='"Insuffisant"' />
	<xsl:variable name='avis1' select='"Tout à fait d&#039;accord"' />
	<xsl:variable name='avis2' select='"Plutôt d&#039;accord"' />
	<xsl:variable name='avis3' select='"Sans avis"' />
	<xsl:variable name='avis4' select='"Plutôt pas d&#039;accord"' />
	<xsl:variable name='avis5' select='"Pas du tout d&#039;accord"' />

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
				Appréciation du stage par le tuteur
				professionnel
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
				Savoirs être du stagiaire
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-ent1 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Adaptation au milieu
					professionnel :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent1 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent1 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent1 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent1 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent1 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent1bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent1bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent2 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Intégration au groupe
					de
					travail :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent2 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent2 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent2 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent2 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent2 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent2bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent2bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent3 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Assiduité, ponctualité
					:
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent3 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent3 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent3 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent3 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent3 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent5 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Intérêt pour
					l'établissement, les services et les
					métiers ?
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent5 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent5 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent5 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent5 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent5 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent5bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent5bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>

		<xsl:if test="fiche-evaluation/@question-ent9 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Sens de l'organisation
					:
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent9 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent9 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent9 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent9 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent9 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent9bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent9bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent11 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Capacité d'autonomie :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent11 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent11 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent11 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent11 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent11 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent11bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent11bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent12 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Initiative personnelle
					:
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent12 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent12 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent12 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent12 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent12 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent12bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent12bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent13 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Implication :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent13 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent13 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent13 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent13 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent13 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent13bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent13bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent14 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Rigueur et précision
					dans le travail :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent14 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent14 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent14 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent14 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent14 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent14bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent14bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 6">
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
							<xsl:if test="reponse-supplementaire/reponse-int = 1">
								<xsl:value-of select="$notation1" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 2">
								<xsl:value-of select="$notation2" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 3">
								<xsl:value-of select="$notation3" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 4">
								<xsl:value-of select="$notation4" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 5">
								<xsl:value-of select="$notation5" />
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
				Savoirs faire du stagiaire
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-ent4 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Aptitude à cerner et
					situer le projet :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent4 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent4 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent4 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent4 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent4 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent4bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent4bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent6 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Aptitude à appliquer
					ses
					connaissances :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent6 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent6 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent6 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent6 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent6 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent6bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent6bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent7 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Esprit d'observation et
					pertinence des remarques :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent7 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent7 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent7 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent7 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent7 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent7bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent7bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent8 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Esprit de synthèse :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent8 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent8 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent8 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent8 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent8 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent8bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent8bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>

		<xsl:if test="fiche-evaluation/@question-ent15 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Aptitude à la
					communication :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent15 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent15 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent15 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent15 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent15 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent15bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent15bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>

		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 7">
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
							<xsl:if test="reponse-supplementaire/reponse-int = 1">
								<xsl:value-of select="$notation1" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 2">
								<xsl:value-of select="$notation2" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 3">
								<xsl:value-of select="$notation3" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 4">
								<xsl:value-of select="$notation4" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 5">
								<xsl:value-of select="$notation5" />
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
			III.
			<fo:inline text-decoration="underline">
				Appréciation générale du stage
			</fo:inline>
		</fo:block>

		<xsl:if test="fiche-evaluation/@question-ent16 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Les objectifs ont-ils
					été atteints ?
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent16 = 1">
						<xsl:value-of select="$avis1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent16 = 2">
						<xsl:value-of select="$avis2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent16 = 3">
						<xsl:value-of select="$avis3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent16 = 4">
						<xsl:value-of select="$avis4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent16 = 5">
						<xsl:value-of select="$avis5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
			<xsl:if test="reponse-evaluation/reponse-ent16bis != ''">
				<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="reponse-evaluation/reponse-ent16bis" />
				</fo:block>
			</xsl:if>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ent17 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Indiquez votre
					appréciation générale de ce stage :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent17 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent17 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent17 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent17 = 4">
						<xsl:value-of select="$notation4" /> :
						<xsl:value-of select="reponse-evaluation/reponse-ent17bis" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent17 = 5">
						<xsl:value-of select="$notation5" /> :
						<xsl:value-of select="reponse-evaluation/reponse-ent17bis" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>

		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 8">
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
							<xsl:if test="reponse-supplementaire/reponse-int = 1">
								<xsl:value-of select="$notation1" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 2">
								<xsl:value-of select="$notation2" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 3">
								<xsl:value-of select="$notation3" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 4">
								<xsl:value-of select="$notation4" />
							</xsl:if>
							<xsl:if test="reponse-supplementaire/reponse-int = 5">
								<xsl:value-of select="$notation5" />
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>

						</xsl:otherwise>
					</xsl:choose>
				</fo:block>
			</xsl:if>
		</xsl:for-each>

		<xsl:if test="fiche-evaluation/@question-ent19 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Observation(s) ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:value-of select="reponse-evaluation/reponse-ent19" />
			</fo:block>
		</xsl:if>

		<xsl:if test="fiche-evaluation/@question-ent10 = 'true'">
			<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Avez-vous remis au
				stagiaire une attestation de stage ?
			</fo:inline>
			<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-ent10 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ent10 = 'false'">
					Non
				</xsl:if>
			</fo:inline>
		</xsl:if>

		<xsl:if test="fiche-evaluation/@question-ent18 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="0.3cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Accepteriez-vous de
					reprendre un de nos étudiants en stage ?
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ent18 = 'true'">
						Oui
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ent18 = 'false'">
						Non :
						<xsl:value-of select="reponse-evaluation/reponse-ent18bis" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<fo:block id="theEnd" />
	</xsl:template>

</xsl:stylesheet>