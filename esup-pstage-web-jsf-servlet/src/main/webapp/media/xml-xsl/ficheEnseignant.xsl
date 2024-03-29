<!-- <?xml version="1.0" encoding="ISO-8859-1" ?> -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes="java">

	<!-- Variable a modifier si vous souhaitez personnaliser les echelles de notation/avis -->
	<xsl:variable name='notation1'
		select='"Excellent"' />
	<xsl:variable name='notation2'
		select='"Très Bien"' />
	<xsl:variable name='notation3'
		select='"Bien"' />
	<xsl:variable name='notation4'
		select='"Satisfaisant"' />
	<xsl:variable name='notation5'
		select='"Insuffisant"' />
	
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
		<fo:block text-align="center">
			<fo:external-graphic>
				<xsl:attribute name="src">
					<xsl:value-of select="document('config.xml')/config/logoUniversite" />
				</xsl:attribute>
				<xsl:attribute name="width">
					<xsl:value-of select="document('config.xml')/config/largeurLogoUniversite" />
				</xsl:attribute>
				<xsl:attribute name="height">
					<xsl:value-of select="document('config.xml')/config/hauteurLogoUniversite" />
				</xsl:attribute>
			</fo:external-graphic>
		</fo:block>
		<fo:leader />
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
					<fo:external-graphic src="url('coche.jpg')" height="3.5mm" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i1a = 'false'">
					<fo:external-graphic src="url('decoche.jpg')" height="3.5mm" />
				</xsl:if>
				Mail&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i1b = 'true'">
					<fo:external-graphic src="url('coche.jpg')" height="3.5mm" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i1b = 'false'">
					<fo:external-graphic src="url('decoche.jpg')" height="3.5mm" />
				</xsl:if>
				Téléphone&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i1c = 'true'">
					<fo:external-graphic src="url('coche.jpg')" height="3.5mm" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i1c = 'false'">
					<fo:external-graphic src="url('decoche.jpg')" height="3.5mm" />
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
					<fo:external-graphic src="url('coche.jpg')" height="3.5mm" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i2a = 'false'">
					<fo:external-graphic src="url('decoche.jpg')" height="3.5mm" />
				</xsl:if>
				Mail&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i2b = 'true'">
					<fo:external-graphic src="url('coche.jpg')" height="3.5mm" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i2b = 'false'">
					<fo:external-graphic src="url('decoche.jpg')" height="3.5mm" />
				</xsl:if>
				Téléphone&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-ens-i2c = 'true'">
					<fo:external-graphic src="url('coche.jpg')" height="3.5mm" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-ens-i2c = 'false'">
					<fo:external-graphic src="url('decoche.jpg')" height="3.5mm" />
				</xsl:if>
				Rencontre
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
		<xsl:if test="fiche-evaluation/@question-ens-i3 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Commentaire(s) :
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:value-of select="reponse-evaluation/reponse-ens-i3" />
			</fo:block>
		</xsl:if>
		<fo:block padding-top="0.5cm" language="fr" country="FR"
			font-size="14pt" font-weight="bold">
			II.
			<fo:inline text-decoration="underline">
				Evaluation du stagiaire
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-ens-iI1 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Impression générale et
					présentation de l'étudiant :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI1 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI2 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Aptitude à cerner et
					situer le projet :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI2 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI3 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Aptitude à appliquer
					ses
					connaissances :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI3 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI4 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Maîtrise du sujet,
					argumentation, analyse :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI4 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI5 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Mise en évidence des
					éléments importants de l'étude :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI5 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI6 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Utilisation des moyens
					de communication :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI6 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI7 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Qualité de l'expression
					orale :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI7 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI8 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Capacité à intéresser
					l'auditoire :
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI8 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI9 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Pertinence des réponses
					:
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI9 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-ens-iI10 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline padding-top="1cm" hyphenate="false" language="fr"
					country="FR" font-size="12pt" font-weight="bold">
					- Respect du temps alloué
					:
				</fo:inline>
				<fo:inline padding-top="0.2cm" hyphenate="false" language="fr"
					country="FR" font-size="11pt" margin-left="2.2cm">
					<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 1">
						<xsl:value-of select="$notation1" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 2">
						<xsl:value-of select="$notation2" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 3">
						<xsl:value-of select="$notation3" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 4">
						<xsl:value-of select="$notation4" />
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-ens-iI10 = 5">
						<xsl:value-of select="$notation5" />
					</xsl:if>
				</fo:inline>
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
		<xsl:if test="fiche-evaluation/@question-ens-iI11 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Commentaire(s) :
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:value-of select="reponse-evaluation/reponse-ens-iI11" />
			</fo:block>
		</xsl:if>
		<fo:block id="theEnd" />
	</xsl:template>

</xsl:stylesheet>