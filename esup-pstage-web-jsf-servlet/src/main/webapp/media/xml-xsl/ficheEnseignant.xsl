<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes="java">


	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fo/extensions">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="all"
					border="" page-height="29.699cm" page-width="20.999cm">
					<fo:region-body margin-bottom="0cm" />
					<fo:region-after display-align="after"
						space-before="0cm" extent="0.55cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="all">
				<fo:flow flow-name="xsl-region-body">
					<fo:block margin-left="0.8cm" padding-top="0.8cm">
						<fo:external-graphic>
							<xsl:attribute name="src">
								<xsl:value-of select="document('config.xml')/config/logoUniversite" />
							</xsl:attribute>
						</fo:external-graphic>
					</fo:block>
					<fo:block margin-right="1.5cm" margin-left="1.5cm"
						margin-bottom="1.09cm" font-family="Times New Roman,serif">
						<xsl:apply-templates select="reponse-evaluation-dTO" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="reponse-evaluation-dTO">
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
		<fo:block padding-top="1cm" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block>
			<xsl:call-template name="contenu" />
		</fo:block>
	</xsl:template>

	<!-- entete -->
	<xsl:template name="entete">
		<fo:block text-align="center">
			<fo:inline line-height="110%" hyphenate="false" language="fr"
				country="FR" font-weight="bold" font-size="18pt">
				FICHE D'ÉVALUATION DE STAGE RÉSERVÉE AU TUTEUR PÉDAGOGIQUE
			</fo:inline>
		</fo:block>
		<fo:block line-height="110%" padding-top="5pt" hyphenate="false"
			language="fr" country="FR" font-size="11.5pt"
			text-align="center">
			<fo:inline font-weight="bold">
				Convention de stage n°
				<xsl:text> </xsl:text>
				<xsl:value-of select="id-convention" />
			</fo:inline>
		</fo:block>
	</xsl:template>

	<!-- partie contenu -->
	<xsl:template name="contenu">
		<fo:block padding-top="5pt" language="fr" country="FR"
			font-size="14pt">
			I.
			<fo:inline text-decoration="underline">
				SUIVI DU STAGIAIRE PENDANT SON STAGE
			</fo:inline>
		</fo:block>
		<fo:block padding-top="0.5cm" hyphenate="false"
			language="fr" country="FR" font-size="14pt">
			1.
			Modalité d'échange avec le stagiaire ?
		</fo:block>
		<fo:block hyphenate="false" language="fr"
			country="FR" font-size="11pt"
			margin-left="2.2cm" font-style="italic">
			<xsl:value-of select="reponse-etu-i1" />
		</fo:block>
		<fo:block hyphenate="true" language="fr"
			country="FR" font-size="10pt">
			<fo:leader />
		</fo:block>
	</xsl:template>

</xsl:stylesheet>