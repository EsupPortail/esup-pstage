<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xalan/java" exclude-result-prefixes = "java">
	
	
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

		<fo:block padding-top="15pt">
			<xsl:call-template name="infosRecap" />
		</fo:block>
		
	</xsl:template>
	
	<!-- entete logo/ annee universitaire -->
	<xsl:template name="entete">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm"
			font-weight="bold">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(0.50)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell >
							<fo:block>
								<fo:external-graphic width="3cm"  height="1cm">
									<xsl:attribute name="src" >
										<xsl:value-of select="document('config.xml')/config/logoUniversite"/>
									</xsl:attribute>
								</fo:external-graphic>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block>
								<xsl:choose>
									<xsl:when test="centre-gestion/fichier/nom-fichier">
										<xsl:variable name="cheminLogo" select="document('config.xml')/config/uploadFiles.logosCentre.path" />
										<xsl:variable name="logo" select="centre-gestion/fichier/nom-fichier" />
											<fo:external-graphic height="1cm">
											<xsl:attribute name="src" >
												<xsl:value-of select="$cheminLogo"/><xsl:value-of select="centre-gestion/fichier/@id-fichier"/>_<xsl:value-of select="$logo"/>
											</xsl:attribute>
											</fo:external-graphic>
									</xsl:when>
									<xsl:otherwise>
									
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell width="3cm">
							<fo:block  width="3.493cm"
								line-height="110%" language="fr" country="FR" font-size="12pt">
								Année universitaire
								<xsl:value-of select="annee" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
	<xsl:template name="infosRecap">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%" border="2px solid #e6e6e6">
				<fo:table-column column-width="proportional-column-width(0.60)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				
				<fo:table-body padding-left="5pt">
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" font-weight="bold">
								N° convention : 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" font-weight="bold">
								<xsl:value-of select="id-convention" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Etudiant 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="etudiant/prenom" />
									<xsl:text> </xsl:text>
									<xsl:value-of select="etudiant/nom" />
									<xsl:text> </xsl:text>
									(N° Etudiant :
									<xsl:value-of select="etudiant/num-etudiant" />)
							</fo:block>
							<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									UFR -
									<xsl:value-of select="ufr/code" /> - <xsl:value-of select="ufr/libelle" />
							</fo:block>
							<fo:block line-height="110%"  
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									ETAPE -
									<xsl:value-of select="etape/code" /> - <xsl:value-of select="etape/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Type de stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="type-convention/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Thématique du stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="theme/libelle" />
									
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Sujet du stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="sujet-stage" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Fonctions et tâches
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="fonctions-et-taches" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Détails du projet
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="details" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Période de stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									Du 
									<xsl:value-of select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))"/> 
									<xsl:text> </xsl:text> Au <xsl:text> </xsl:text>
										<xsl:value-of select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))"/> 
						</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Interruption du stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="interruption-stage = 'true'"> 
								 		<xsl:text> </xsl:text>
								 		avec interruption du : 
											<xsl:value-of select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))"/> 
										<xsl:text> </xsl:text> au <xsl:text> </xsl:text>
											<xsl:value-of select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))"/> 
									 </xsl:if>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Durée de travail
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									
									<xsl:value-of select="temps-travail/libelle" /> <xsl:text> sur </xsl:text> <xsl:value-of select="nb-jours-hebdo" /> <xsl:text> jour(s)/semaine </xsl:text>

							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Commentaires sur le temps de travail
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="commentaire-duree-travail" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Langue d'impression de la convention
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="langue-convention/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Gratification au cours du stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:variable name="nb-montant-gratification" select="montant-gratification" />
								<xsl:choose>
									<xsl:when test='$nb-montant-gratification=""'>
 
       							    </xsl:when>
									<xsl:otherwise>
												<xsl:value-of select="montant-gratification" /> 
												euros <xsl:text> </xsl:text> <xsl:value-of select="unite-gratification/libelle" /> par mois
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Origine du stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="origine-stage/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Confidentialité du sujet/theme du stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="tem-conf-sujet-teme != 'O'"> 
										non
									 </xsl:if> 
									 <xsl:if test="tem-conf-sujet-teme = 'O'"> 
								 		oui
									 </xsl:if> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Nombres d'heures Hebdomadaires 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="nb-heures-hebdo" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								pourcentage de quotité travaillée 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="quotite-travail" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Modalité de Suivi du stagiaire par l'etablissement 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="mode-encadre-suivi" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Modalité de versement de la gratification 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="mode-vers-gratification/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Listes des avantages en nature 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="avantages-nature" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Nature du travail à fournir suite au Stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="nature-travail/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								modalité de Validation du Stage
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="mode-validation-stage/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Conditions particulières de travail
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="travail-nuit-ferie" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Durée du Stage (en semaines)
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="duree-stage" /> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Durée Effective du Stage (cas plusieurs interruptions)
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="duree-exceptionnelle" /> <xsl:text> </xsl:text>   <xsl:value-of select="unite-duree/libelle" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Responsable pédagogique
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="enseignant/prenom" />
									<xsl:text> </xsl:text> 
									<xsl:value-of select="enseignant/nom" /> 
									(<xsl:value-of select="enseignant/affectation/libelle" /> )
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Etablissement d'accueil
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="structure/raison-sociale" /> 
							</fo:block>

							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
										<xsl:value-of select="structure/batiment-residence" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/voie" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/code-postal" />  
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/commune" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="structure/pays/libelle" /> 
							</fo:block>
							
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Lieu de stage 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="service/nom" />
 						  </fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
											<xsl:value-of select="service/batiment-residence" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/voie" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/code-postal" />  
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/commune" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="service/pays/libelle" /> 
							</fo:block>
							
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Tuteur professionnel
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="contact/prenom" />
									<xsl:text> </xsl:text> 
									<xsl:value-of select="contact/nom" /> 
									<xsl:text> </xsl:text> 
									(<xsl:value-of select="contact/fonction" /> )
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Signataire
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="signataire/prenom" /> 
									<xsl:text> </xsl:text>
									<xsl:value-of select="signataire/nom" /> 
									<xsl:text> </xsl:text> 
									(<xsl:value-of select="signataire/fonction" />)
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Adresse de l'étudiant
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="adresse-etudiant" />
											<xsl:text> </xsl:text>
											<xsl:value-of select="code-postal-etudiant" />  
											<xsl:text> </xsl:text>
											<xsl:value-of select="ville-etudiant" /> 
											<xsl:text> </xsl:text>
											<xsl:value-of select="pays-etudiant" /> 
							</fo:block>
							
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Téléphone de l'étudiant
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="tel-etudiant" />
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="tel-portable-etudiant" /> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Courriel de l'étudiant
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="etudiant/mail" />		
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="courriel-perso-etudiant" /> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Affiliation à la Sécurité Sociale
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="assurance/libelle" />		
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								N° Sécurité Sociale
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="etudiant/num-sS" />		
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Caisse d'Assurance Maladie
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:choose>
											<xsl:when test="libelle-cPAM">
												<xsl:value-of select="libelle-cPAM" />
											</xsl:when>
											<xsl:otherwise>
												 
											</xsl:otherwise>
									</xsl:choose> 	
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								ELP - nbreCredits
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:value-of select="code-elp" />  -  <xsl:value-of select="credit-eCTS" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row >
						<fo:table-cell  background-color="#e6e6e6" text-align="left">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Convention validée
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-left="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
									<xsl:if test="validation-convention = 'true'"> 
								 		<xsl:text> </xsl:text>
								 		oui 
								 	</xsl:if>
								 	<xsl:if test="validation-convention = 'false'"> 
								 		<xsl:text> </xsl:text>
								 		non
								 	</xsl:if>
									
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

				</fo:table-body>
			</fo:table>
		</fo:block>
		<fo:block line-height="110%"  
				hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
				<fo:leader/>
		</fo:block>
		<fo:block line-height="110%"  
			hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" padding-top="5pt">
			récapitulatif imprimé le : <xsl:value-of select = "java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())"/> 
		</fo:block>
		<fo:block id="theEnd" />
	</xsl:template>
</xsl:stylesheet>