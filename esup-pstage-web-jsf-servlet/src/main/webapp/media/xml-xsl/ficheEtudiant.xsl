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
				Evaluation du stage par
				l'étudiant
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
				Avant votre départ en stage
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-etu-i1 = 'true'">
			<fo:block padding-top="0.5cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Avez-vous rencontré des
				difficultés pour
				trouver un stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i1 = 1">
					Non, il est automatiquement proposé dans le cadre de la formation.
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i1 = 2">
					Non, je l’ai trouvé assez facilement par moi-même.
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i1 = 3">
					Oui j’ai eu des difficultés.
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i2 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Combien de temps a duré
				votre recherche de
				stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i2 = 1">
					1 jour à 1 semaine
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i2 = 2">
					2 semaines à 1 mois
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i2 = 3">
					1 mois à 3 mois
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i2 = 4">
					3 mois à 6 mois
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i2 = 5">
					+ de 6 mois
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i3 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Combien
				d'établissement(s) d'accueil
				avez-vous prospecté(s) ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i3 = 1">
					1 à 5
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i3 = 2">
					6 à 10
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i3 = 3">
					11 à 20
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i3 = 4">
					20 et plus
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i4 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Quel procédé de
				démarchage avez-vous
				utilisé ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i4a = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i4a = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Mail&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-etu-i4b = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i4b = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Téléphone&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-etu-i4c = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i4c = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Courrier&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-etu-i4d = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i4d = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Prospection directe
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i5 = 'true'">
			<fo:block padding-top="0.3cm">
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-size="12pt" font-weight="bold">
					- Origine du stage :
				</fo:inline>
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-size="11pt" margin-left="2.2cm">
					<xsl:value-of select="origine-stage/libelle" />
					(remonté des informations de la convention)
				</fo:inline>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i6 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Comment avez-vous
				déterminé le contenu de
				stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i6 = 1">
					Proposé par votre tuteur professionnel
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i6 = 2">
					Proposé par votre tuteur enseignant
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i6 = 3">
					Élaboré par vous-même
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i6 = 4">
					Négocié entre les parties
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i7 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Avez-vous été
				accompagné(e) dans vos
				démarches ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i7 = 'true'">
					Oui -
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 1">
						Par votre réseau personnel.
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 2">
						Au sein de votre formation.
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 3">
						Par le service d'Information, d'Orientation, et d'Insertion
						Professionnelle.
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 4">
						Par le BAIP.
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 5">
						Autre :
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 3">
						<fo:block padding-top="0.1cm" hyphenate="false" language="fr"
							country="FR" font-size="11pt" margin-left="2.2cm" font-weight="bold">
							Avez-vous utilisé les
							ressources mises à votre disposition par ce
							service ?
						</fo:block>
						<fo:block padding-top="0.1cm" hyphenate="false" language="fr"
							country="FR" font-size="11pt" margin-left="2.2cm">
							<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1a = 'true'">
								Oui
							</xsl:if>
							<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1a = 'false'">
								Non
							</xsl:if>
						</fo:block>
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis1 = 5">
						<xsl:value-of select="reponse-evaluation/reponseEtuI7bis1b" />
					</xsl:if>
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i7 = 'false'">
					Non -
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis2 = 1">
						Par choix.
					</xsl:if>
					<xsl:if test="reponse-evaluation/@reponse-etu-i7bis2 = 2">
						Par méconnaissance des dispositifs proposés par votre université.
					</xsl:if>
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-i8 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Est-ce que les modalités
				d'évaluation de
				stage vous ont été clairement présentées avant le
				début du stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-i8 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-i8 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 1">
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
				Pendant le stage
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-etu-iI1 = 'true'">
			<fo:block padding-top="0.5cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Comment
				qualifieriez-vous l'accueil de
				votre entreprise ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iI1 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI1 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI1 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI1 = 4">
					Satisfaisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iI1bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI1 = 5">
					Insuffisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iI1bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iI2 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Comment
				qualifieriez-vous l'encadrement de
				votre stage dans l’entreprise ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iI2 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI2 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI2 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI2 = 4">
					Satisfaisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iI2bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI2 = 5">
					Insuffisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iI2bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iI3 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Comment
				qualifieriez-vous votre adaptation
				au sein de l'établissement
				d'accueil?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iI3 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI3 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI3 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI3 = 4">
					Satisfaisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iI3bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI3 = 5">
					Insuffisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iI3bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iI4 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Est-ce que les
				conditions matérielles vous
				ont permis d'atteindre les objectifs de
				votre stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iI4 = 1">
					Tout à fait d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI4 = 2">
					Plutôt d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI4 = 3">
					Sans avis
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI4 = 4">
					Plutôt pas d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI4 = 5">
					Pas du tout d'accord
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iI5 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Avez-vous exercé des
				responsabilités ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iI5 = 'true'">
					<fo:inline>Oui - </fo:inline>
					<fo:inline>
						<xsl:if test="reponse-evaluation/@reponse-etu-iI5a = 1">
							Très importantes -
						</xsl:if>
						<xsl:if test="reponse-evaluation/@reponse-etu-iI5a = 2">
							Importantes -
						</xsl:if>
						<xsl:if test="reponse-evaluation/@reponse-etu-iI5a = 3">
							Peu importantes -
						</xsl:if>
					</fo:inline>
					<fo:inline>
						<xsl:if test="reponse-evaluation/@reponse-etu-iI5b = 'true'">
							Avec autonomie
						</xsl:if>
						<xsl:if test="reponse-evaluation/@reponse-etu-iI5b = 'false'">
							Sans autonomie
						</xsl:if>
					</fo:inline>
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI5 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iI6 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Votre stage avait-il une
				dimension
				internationale ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iI6 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iI6 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 2">
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
			III.
			<fo:inline text-decoration="underline">
				Après le stage
			</fo:inline>
		</fo:block>
		<xsl:if test="fiche-evaluation/@question-etu-iII1 = 'true'">
			<fo:block padding-top="0.5cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt">
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-size="12pt" font-weight="bold">
					- Votre sujet de stage était à
					l'origine :
				</fo:inline>
				<fo:inline hyphenate="false" language="fr" country="FR"
					font-size="12pt" margin-left="2.2cm">
					<xsl:value-of select="sujet-stage" />
				</fo:inline>
			</fo:block>
			<fo:block hyphenate="false" language="fr" country="FR"
				font-size="12pt" font-weight="bold" margin-left="2.2cm">
				Avez-vous du le
				changer ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII1 = 'true'">
					Oui, pour le sujet suivant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII1bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII1 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII2 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Selon vous, le stage
				a-t-il bien été en
				adéquation avec votre formation ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII2 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII2 = 'false'">
					Non :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII2bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII4 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Les missions confiées
				ont été ?
			</fo:block>

			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII4 = 1">
					Très au-dessous de vos compétences
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII4 = 2">
					Au-dessous de vos compétences
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII4 = 3">
					A votre niveau de compétences
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII4 = 4">
					Au-dessus de vos compétences
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII4 = 5">
					Très au-dessus de vos compétences
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII4 = 6">
					Inatteignables
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII5 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Ce stage vous a-t-il
				permis d'acquérir :
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII5a = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII5a = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Compétences techniques&#x00A0;&#x00A0;&#x00A0;&#x00A0;

				<xsl:if test="reponse-evaluation/@reponse-etu-iII5c = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII5c = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Nouvelles connaissances théoriques
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII5b = 'true'">
					<fo:character character="&#x2784;" font-family="ZapfDingbats" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII5b = 'false'">
					<fo:character character="&#xF8E7;" font-family="Symbol" />
				</xsl:if>
				Nouvelles méthodologies :
				<xsl:value-of select="reponse-evaluation/reponse-etu-iII5bis" />
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII6 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Ce stage vous a permis
				de progresser dans
				la construction de votre projet personnel et
				professionnel ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII6 = 1">
					Tout à fait d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII6 = 2">
					Plutôt d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII6 = 3">
					Sans avis
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII6 = 4">
					Plutôt pas d'accord :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII6bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII6 = 5">
					Pas du tout d'accord :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII6bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII7 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Ce stage vous parait
				déterminant à cette
				étape de votre formation
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII7 = 1">
					Tout à fait d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII7 = 2">
					Plutôt d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII7 = 3">
					Sans avis
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII7 = 4">
					Plutôt pas d'accord :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII7bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII7 = 5">
					Pas du tout d'accord :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII7bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII8 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Votre travail a-t-il
				abouti à une
				réorganisation du travail ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII8 = 'true'">
					Oui :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII8bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII8 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII9 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Allez-vous valoriser
				cette expérience dans
				une prochaine recherche d'emploi/stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII9 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII9 = 'false'">
					Non :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII9bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII10 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Votre travail va-t-il
				donner lieu à un
				dépôt de brevet ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII10 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII10 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII11 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Avez-vous reçu une
				attestation de stage ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII11 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII11 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII12 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Avez-vous rencontré des
				difficultés à
				percevoir la gratification ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII12 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII12 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII14 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Est-ce que ce stage a
				donné lieu à une
				proposition d'emploi ou d'alternance ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII14 = 'true'">
					Oui
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII14 = 'false'">
					Non
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII15 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Conseilleriez-vous cet
				établissement
				d'accueil à un autre étudiant ?
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII15 = 1">
					Tout à fait d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII15 = 2">
					Plutôt d'accord
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII15 = 3">
					Sans avis
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII15 = 4">
					Plutôt pas d'accord :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII15bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII15 = 5">
					Pas du tout d'accord :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII15bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:if test="fiche-evaluation/@question-etu-iII16 = 'true'">
			<fo:block padding-top="0.3cm" hyphenate="false" language="fr"
				country="FR" font-size="12pt" font-weight="bold">
				- Indiquez votre
				appréciation générale de ce
				stage :
			</fo:block>
			<fo:block padding-top="0.2cm" hyphenate="false" language="fr"
				country="FR" font-size="11pt" margin-left="2.2cm">
				<xsl:if test="reponse-evaluation/@reponse-etu-iII16 = 1">
					Excellent
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII16 = 2">
					Très Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII16 = 3">
					Bien
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII16 = 4">
					Satisfaisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII16bis" />
				</xsl:if>
				<xsl:if test="reponse-evaluation/@reponse-etu-iII16 = 5">
					Insuffisant :
					<xsl:value-of select="reponse-evaluation/reponse-etu-iII16bis" />
				</xsl:if>
			</fo:block>
		</xsl:if>
		<xsl:for-each select="questions-supplementaires">
			<xsl:if test="id-placement = 3">
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