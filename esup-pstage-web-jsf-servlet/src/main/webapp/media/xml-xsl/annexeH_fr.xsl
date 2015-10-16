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
			<xsl:call-template name="FicheStageEtranger" />
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

	<xsl:template name="FicheStageEtranger">
		<fo:block text-align="center">
			<fo:table border="0.06cm solid #37638B" width="100%"
				table-layout="fixed" color="#37638B">
				<fo:table-column column-width="proportional-column-width(0.05)" />
				<fo:table-column column-width="proportional-column-width(0.55)" />
				<fo:table-column column-width="proportional-column-width(0.40)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding="0.1cm">
							<fo:external-graphic src="url('img_annexe_fiche_etranger.jpg')"
								height="1.25cm" scaling="non-uniform" />
						</fo:table-cell>
						<fo:table-cell border-right="0.06cm solid #37638B"
							padding="0.1cm" text-align="left">
							<fo:block font-size="11pt" font-weight="bold"
								text-align="center">
								Stage à l'étranger
							</fo:block>
							<fo:block font-size="8pt" font-style="italic"
								padding-top="0.2cm">
								Fiche à compléter par l'établissement d'enseignement
								ou
								organisme de formation
							</fo:block>
						</fo:table-cell>
						<fo:table-cell border="1" margin-left="0.2cm"
							display-align="center" padding-top="0.2cm" text-align="left">
							<fo:block font-size="8pt">
								<fo:inline text-decoration="underline" font-weight="bold">
									PAYS D'ACCUEIL
								</fo:inline>
								:
								<fo:inline color="black">
									<xsl:choose>
										<xsl:when test="service/pays/libelle">
											<xsl:value-of select="service/pays/libelle" />
										</xsl:when>
										<xsl:otherwise>
											...................................................
										</xsl:otherwise>
									</xsl:choose>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block padding-top="5pt">
			<fo:table border="0.018cm solid #000000" padding="3pt"
				width="100%" table-layout="fixed">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell border="1" margin-left="0.2cm"
							padding-top="0.2cm">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								CONDITIONS D'ENTRÉE ET DE SÉJOUR DANS LE PAYS
								D'ACCUEIL
							</fo:block>
							<fo:block margin-left="1cm" line-height="130%"
								hyphenate="false" language="fr" country="FR" font-size="8pt"
								font-family="Times New Roman,serif" font-style="italic">
								<fo:inline text-decoration="underline">
									Préciser ici les
									informations extraites de la
								</fo:inline>
								<fo:basic-link
									external-destination="url('www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									Fiche-pays
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">1
								</fo:inline>
								<fo:inline text-decoration="underline">
									essentielles à connaître
									par le stagiaire :
								</fo:inline>
							</fo:block>
							<fo:block line-height="250%" hyphenate="false" language="fr"
								country="FR" font-size="9pt" font-family="Times New Roman,serif">
								.........................................................................................................................................................................................................................................
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block padding-top="5pt">
			<fo:table border="0.018cm solid #000000" padding="3pt"
				width="100%" table-layout="fixed">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell border="1" margin-left="0.2cm"
							padding-top="0.2cm">
							<fo:block font-size="10pt" font-weight="bold"
								text-decoration="underline" color="red">
								AVERTISSEMENT SUR LA SÉCURITÉ
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								<fo:inline font-weight="bold">Consultez la classification de
									la zone
								</fo:inline>
								où doit se dérouler le stage envisagé sur le site du Ministère
								des Affaires étrangères
								et du Développement international,
								rubrique
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/')"
									color="blue" text-decoration="underline">
									Conseils aux voyageurs
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">2
								</fo:inline>
								:
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif">
								- votre établissement d'enseignement
								<fo:inline color="red">ne validera pas</fo:inline>
								une convention de stage pour une zone qualifiée "
								<fo:inline color="red">rouge</fo:inline>
								" ;
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif">
								- votre établissement d'enseignement examinera la situation
								avant une
								<fo:inline color="red">éventuelle validation</fo:inline>
								d'une convention de stage pour une zone qualifiée "
								<fo:inline color="red">orange</fo:inline>
								". Les projets de stage en zone
								orange font toutefois l'objet
								d'un
								<fo:inline font-weight="bold">à priori négatif</fo:inline>
								;
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								<fo:inline font-weight="bold">En cas de basculement en zone
									"rouge"
								</fo:inline>
								pendant votre séjour, il vous est demandé de
								<fo:inline font-weight="bold">mettre fin immédiatement
								</fo:inline>
								au stage.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								<fo:inline font-weight="bold">Avant de partir,</fo:inline>
								vous devez prendre connaissance des
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/')"
									color="blue" text-decoration="underline">
									conseils aux voyageurs
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">2
								</fo:inline>
								<fo:inline font-weight="bold"> accessibles via la </fo:inline>
								<fo:basic-link
									external-destination="url('www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									fiche-pays
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">1
								</fo:inline>
							</fo:block>
							<fo:block line-height="200%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								font-style="italic">
								<fo:inline text-decoration="underline">
									Mentionner ici le lien
									direct vers la fiche-pays concernée
								</fo:inline>
								:
								...............................................................................................................
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								Il vous est demandé de
								<fo:inline font-weight="bold">vous inscrire avant votre
									départ
								</fo:inline>
								sur la
								<fo:basic-link
									external-destination="url('https://pastel.diplomatie.gouv.fr/fildariane/dyn/public/login.html')"
									color="blue" text-decoration="underline">
									base Ariane
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">3
								</fo:inline>
								.
								De cette manière, le Ministère des Affaires étrangères et du
								développement international pourra vous joindre par mail ou sms
								en cas d'incident sécuritaire.
							</fo:block>

							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:external-graphic src="url('cross.jpg')"
									width="0.3cm" height="0.3cm" />
								Si vous demeurez
								<fo:inline font-weight="bold">plus de six mois</fo:inline>
								dans le pays, en tenant compte de votre temps de présence
								<fo:inline font-weight="bold">avant et après le stage,
								</fo:inline>
								vous devrez
								<fo:inline font-weight="bold">vous inscrire au Registre des
									Français
								</fo:inline>
								établis hors de France auprès des autorités consulaires
								Françaises (Consulat général ou section consulaire de
								l'ambassade
								<fo:inline vertical-align="super" font-size="60%">5
								</fo:inline>
								).
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block padding-top="5pt">
			<fo:table border="0.018cm solid #000000" width="100%"
				table-layout="fixed">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell padding="0.2cm">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								CONDITIONS PARTICULIERES DU STATUT DU STAGIAIRE
								DANS LE PAYS
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="12pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								Non
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="12pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								Oui
								:
								<fo:inline font-size="9pt" font-style="italic"
									text-decoration="underline">Mentionner
									ici des particularités liées aux
									stages dans le pays
									(réglementation spécifique / droits
									d'inscription
									complémentaire / convention de partenariat /
									accords cadre /
									conditions particulières sur la gratification ou
									non)
								</fo:inline>
								:
								......................................................
							</fo:block>
							<fo:block line-height="200%" hyphenate="false" language="fr"
								country="FR" font-family="Times New Roman,serif">
								.............................................................................................................................................................................
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell padding="0.2cm" border-top="0.018cm solid #000000">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								ASSURANCE COMPLEMENTAIRE
							</fo:block>
							<fo:block font-size="9pt" line-height="110%" hyphenate="false"
								language="fr" country="FR" font-family="Times New Roman,serif"
								padding-top="2pt">
								Les régimes de protection sont
								différents selon le
								pays d'accueil (y compris en Europe) et les
								modalités du stage
								(gratification supérieure ou non
								au plafond
								légal Français)*. Pour
								votre stage :
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold">Vous bénéficiez d'un régime de
									protection sociale local
								</fo:inline>
								<fo:wrapper font-family="ZapfDingbats">&#x2192; </fo:wrapper>
								<fo:inline font-weight="bold">Votre
									convention de stage doit
									le
									préciser.
								</fo:inline>
								Si vous estimez cette
								protection insuffisante, vous pouvez
								souscrire à l'assurance
								maladie volontaire de la
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									Caisse des Français de l'Etranger
									(CFE)
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								ou à une assurance privée.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm">
								<fo:external-graphic src="url('square.JPG')" />
								<fo:inline font-weight="bold">Vous ne bénéficiez pas
								</fo:inline>
								d'un régime de protection sociale local.
								<fo:inline font-weight="bold">Vous devez souscrire
								</fo:inline>
								à l'assurance maladie volontaire de la
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									Caisse des Français de l'Etranger
									(CFE)
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								ou à une assurance
								privée.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.2cm" padding-bottom="0.2cm">
								<fo:inline font-weight="bold">Dans tous les cas, </fo:inline>
								compte tenu du coût élevé des soins dans de nombreux États,
								<fo:inline font-weight="bold">il est vivement conseillé de
									souscrire
								</fo:inline>
								à l'assurance maladie volontaire de la
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									Caisse des Français de l'Etranger
									(CFE)
								</fo:basic-link>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								ou à une assurance
								privée.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								font-style="italic">
								*L'établissement doit vérifier
								les conditions de
								protection sociale du pays d'accueil afin
								d'informer
								préalablement le stagiaire et, au besoin, faire les
								démarches
								nécessaires auprès de la CPAM notamment pour la
								protection
								accidents du travail : pour les étudiants voir
								convention-type
								de
								stage articles 6 et 7 (cf. arrêté du 29
								décembre 2014 relatif
								aux
								conventions de stage dans
								l'enseignement supérieur). Pour
								les
								élèves en formation
								professionnelle de niveaux V et IV voir
								convention type
								concernant les périodes de formation en milieu
								professionnel à
								l'étranger (cf. circulaire n°2003-203 du
								17/11/2003 notamment
								article 8).
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell padding="0.2cm" border-top="0.018cm solid #000000">
							<fo:block font-size="9pt" font-weight="bold"
								text-decoration="underline">
								STAGIAIRE MINEUR
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif">
								-
								<fo:inline font-weight="bold">Se référer à la convention-type
								</fo:inline>
								concernant les périodes de formation en milieu professionnel à
								l'étranger des élèves en formation professionnelle de niveaux V
								et IV (circulaire n°2003-203 du 17/11/2003 dont notamment
								articles 4, 5 et 6).
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif"
								text-decoration="underline" font-style="italic">
								éventuellement
								indications particulières à mettre en exergue par
								l'établissement
							</fo:block>
							<fo:block font-size="10pt" font-family="Times New Roman,serif"
								padding-top="0.1cm">
								-
								<fo:inline font-weight="bold">Règlementation particulière
									pour les mineurs dans le pays d'accueil :
								</fo:inline>
							</fo:block>
							<fo:block margin-left="1.5cm" padding-top="0.1cm">
								<fo:block line-height="110%" hyphenate="false"
									language="fr" country="FR" font-size="12pt" font-family="Times New Roman,serif">
									<fo:external-graphic src="url('square.JPG')" />
									Non
								</fo:block>
								<fo:block line-height="110%" hyphenate="false"
									padding-top="0.1cm" language="fr" country="FR" font-size="12pt"
									font-family="Times New Roman,serif">
									<fo:external-graphic src="url('square.JPG')" />
									Oui :
									<fo:inline font-style="italic">précisez les particularités
									</fo:inline>
									:
									..............................................................................................
								</fo:block>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell font-size="9pt" padding="0.2cm"
							border-top="0.018cm solid #000000">
							<fo:block font-weight="bold" text-decoration="underline">
								SITES DE
								REFERENCE
							</fo:block>
							<fo:block padding-top="0.1cm">
								<fo:inline vertical-align="super" font-size="60%">1
								</fo:inline>
								Fiches-pays :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">2
								</fo:inline>
								Fiches Conseils aux voyageurs :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">3
								</fo:inline>
								Base Ariane :
								<fo:basic-link
									external-destination="url('https://pastel.diplomatie.gouv.fr/fildariane/dyn/public/login.html')"
									color="blue" text-decoration="underline">
									https://pastel.diplomatie.gouv.fr/fildariane/dyn/public/login.html
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">4
								</fo:inline>
								Caisse des Français de l'Etranger pour assurance complémentaire
								:
								<fo:basic-link external-destination="url('http://www.cfe.fr/')"
									color="blue" text-decoration="underline">
									http://www.cfe.fr/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								<fo:inline vertical-align="super" font-size="60%">5
								</fo:inline>
								Sites internet des ambassades et consulat français indiqués dans
								la Fiche-pays :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/conseils-aux-voyageurs/conseils-par-pays/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								Protection sociale à l'international :
								<fo:basic-link external-destination="url('http://www.cleiss.fr/')"
									color="blue" text-decoration="underline">
									http://www.cleiss.fr/
								</fo:basic-link>
							</fo:block>
							<fo:block>
								Connaissance de l'enseignement supérieur (fiches de la base
								"Curie") :
								<fo:basic-link
									external-destination="url('http://www.diplomatie.gouv.fr/fr/politique-etrangere-de-la-france/cooperation-educative/')"
									color="blue" text-decoration="underline">
									http://www.diplomatie.gouv.fr/fr/politique-etrangere-de-la-france/cooperation-educative/
								</fo:basic-link>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
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