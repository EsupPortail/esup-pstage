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
					<fo:block margin-right="2.5cm" margin-left="2.5cm"
						margin-bottom="1.09cm" padding-top="0.4cm">
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
		<fo:block padding-top="2cm" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block>
			<xsl:call-template name="contenu" />
		</fo:block>
	</xsl:template>

	<!-- entete logo/ annee universitaire -->
	<xsl:template name="entete">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="14cm" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
							<fo:block font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block font-family="Times New Roman,serif" width="2cm">
								<xsl:value-of select="centre-gestion/nom-centre" />
							</fo:block>
							<fo:block font-family="Times New Roman,serif">
								<xsl:value-of select="centre-gestion/batiment-residence" />
							</fo:block>
							<fo:block font-family="Times New Roman,serif">
								<xsl:value-of select="centre-gestion/voie" />
							</fo:block>
							<fo:block font-family="Times New Roman,serif">
								<xsl:value-of select="centre-gestion/code-postal" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="centre-gestion/commune" />
							</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>

		<fo:block padding-top="0.5cm" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>

		<fo:table table-layout="fixed" width="100%" margin-right="2.5cm">
			<fo:table-column column-width="proportional-column-width(0.5)" />
			<fo:table-column column-width="proportional-column-width(0.5)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
					</fo:table-cell>
					<fo:table-cell wrap-option="wrap">
						<fo:block text-align="left">
							<xsl:value-of select="structure/raison-sociale" />
						</fo:block>
						<fo:block text-align="left" font-family="Times New Roman,serif">
							<xsl:value-of select="adresse-etudiant" />
						</fo:block>
						<fo:block text-align="left" font-family="Times New Roman,serif">
							<xsl:value-of select="structure/voie" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="structure/batiment-residence" />
						</fo:block>
						<fo:block text-align="left" font-family="Times New Roman,serif">
							<xsl:value-of select="structure/code-postal" />
							<xsl:text> </xsl:text>
							<xsl:value-of select="structure/commune" />
						</fo:block>
						<fo:block text-align="left" font-family="Times New Roman,serif">
							<xsl:value-of select="structure/pays/libelle" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<!-- partie contenu -->
	<xsl:template name="contenu">
		<fo:inline font-weight="bold" text-decoration="underline">
			Objet :
		</fo:inline>
		<fo:inline font-weight="bold">
			Remerciement pour l'accueil en stage.
		</fo:inline>

		<fo:block padding-top="1cm" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>

		<fo:block>
			Corps du texte
		</fo:block>
		<fo:block font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block>
			Veuillez agréer, Madame, Monsieur, l'expression de mes
			salutations distinguées.
		</fo:block>
		<fo:block padding-top="1cm" font-family="Times New Roman,serif">
			<fo:leader />
		</fo:block>
		<fo:block text-align="right" margin-right="5cm">
			Signature
		</fo:block>

	</xsl:template>

</xsl:stylesheet>