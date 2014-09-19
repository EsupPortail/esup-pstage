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
						<xsl:apply-templates select="avenant-dTO" />
					</fo:block>

				</fo:flow>
			</fo:page-sequence>

		</fo:root>
	</xsl:template>

	<!-- definition du noeud convention -->
	<xsl:template match="avenant-dTO">
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
			<xsl:call-template name="titre" />
		</fo:block>
		<fo:block padding-top="15pt">
			<xsl:call-template name="avenant" />
		</fo:block>
		<fo:block padding-top="8pt">
			<xsl:call-template name="infosAvenant" />
		</fo:block>
		
		<fo:block >
			<xsl:call-template name="Fait" />
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
									<xsl:when test="convention/centre-gestion/fichier/nom-fichier">
										<xsl:variable name="cheminLogo" select="document('config.xml')/config/uploadFiles.logosCentre.path" />
										<xsl:variable name="logo" select="convention/centre-gestion/fichier/nom-fichier" />
											<fo:external-graphic height="1cm">
											<xsl:attribute name="src" >
												<xsl:value-of select="$cheminLogo"/><xsl:value-of select="convention/centre-gestion/fichier/@id-fichier"/>_<xsl:value-of select="$logo"/>
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
								Academic year
								<xsl:value-of select="convention/annee" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
		<!-- partie nom etablissement / titre convention -->
	<xsl:template name="titre">
		<fo:block line-height="110%" 
				  hyphenate="false" language="fr" country="FR" font-size="8pt"
				  font-family="Times New Roman,serif">
	
		<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
					<fo:table-row margin-top="20px" text-align="left">
						<!-- partie Etablissement Superieur - Stage -->
							<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Name of institution (university) :  
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when test="convention/nom-etab-ref">
											<xsl:value-of select="convention/nom-etab-ref" />
										</xsl:when>
										<xsl:otherwise>
											<xsl:value-of select="document('config.xml')/config/nomUniversite"/>
										</xsl:otherwise>
									</xsl:choose>
								</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Address : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="convention/adresse-etab-ref">
												<xsl:value-of select="convention/adresse-etab-ref" />
											</xsl:when>
											<xsl:otherwise>
												<xsl:value-of select="document('config.xml')/config/adresseUniversite"/> 
											</xsl:otherwise>
										</xsl:choose>
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Represented by (name of (the) signatory to the Convention) :  
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="convention/nom-signataire-composante">
												<xsl:value-of select="convention/nom-signataire-composante" />
											</xsl:when>
											<xsl:otherwise>
												 
											</xsl:otherwise>
										</xsl:choose>
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Quality Representative : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="convention/qualite-signataire">
												<xsl:value-of select="convention/qualite-signataire" />
											</xsl:when>
											<xsl:otherwise>
												 .....................................
											</xsl:otherwise>
										</xsl:choose>
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Department / Faculty / Other <xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										<xsl:value-of select="convention/centre-gestion/nom-centre" />
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Address : (if different from the university)  
									<fo:inline font-weight="bold">
										<xsl:value-of select="convention/centre-gestion/batiment-residence" /> 
										<xsl:text> </xsl:text> 
										<xsl:value-of select="convention/centre-gestion/voie" /> 
										<xsl:text> </xsl:text> 
										<xsl:value-of select="convention/centre-gestion/code-postal" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="convention/centre-gestion/commune" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="convention/centre-gestion/town-center" /> 
									</fo:inline>
										
								</fo:block>
							</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" >
							Tél :
							<xsl:value-of select="convention/centre-gestion/telephone" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm"  >
							fax : 
							<xsl:value-of select="convention/centre-gestion/fax" /> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" >
							mél : 
							<xsl:value-of select="convention/centre-gestion/mail" />  
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
			</fo:table-body>
		</fo:table>
		</fo:block>
	</xsl:template>
	<!-- partie préliminaire -->
	<xsl:template name="avenant">
		<fo:block line-height="110%" 
				hyphenate="false" language="fr" country="FR" font-size="12pt"
				font-family="Times New Roman,serif" text-align="justify">
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell >
							
						<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold" text-decoration="underline">							
							ADDITIONAL CLAUSE TO THE INTERSHIP CONTRACT N° <xsl:value-of select="id-avenant" /><xsl:text> </xsl:text>PLACEMENT AGREEMENT
							<xsl:text> </xsl:text><xsl:value-of select="convention/type-convention/libelle" />
							<xsl:text> </xsl:text> n° <xsl:text> </xsl:text> <xsl:value-of select="id-convention" />
							</fo:inline>
						</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
				</fo:table-body>
		</fo:table>
	</xsl:template>
		<!-- partie Avenant - Stage -->
	<xsl:template name="infosAvenant">
	
		<fo:table table-layout="fixed" width="100%"  >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row text-align="left">
						<fo:table-cell padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="12pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold" font-size="12pt">
								ARTICLE 1 
							</fo:inline> 
							<fo:inline font-weight="bold" font-size="10.5pt">
								The present additional clause aims to modify the course of the internship whose terms had been agreed on by both : 
							</fo:inline> 
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold">
								<xsl:value-of select="convention/structure/raison-sociale" /> 
							</fo:inline>
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold">  
								<xsl:value-of select="convention/structure/batiment-residence" /> 
								<xsl:text> </xsl:text> 
								<xsl:value-of select="convention/structure/voie" />
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/structure/code-postal" />  
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/structure/commune" /> 
								<xsl:text> </xsl:text>
								<xsl:value-of select="convention/structure/pays/libelle" />
							</fo:inline> 
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Tél : 
							<fo:inline font-weight="bold">  
								<xsl:value-of select="convention/structure/telephone" />
							</fo:inline> 
							<xsl:text> </xsl:text><xsl:text> </xsl:text><xsl:text> </xsl:text> 
							fax :
							<fo:inline font-weight="bold"> 	
								<xsl:value-of select="convention/structure/fax" />
							</fo:inline> 
							<xsl:text> </xsl:text><xsl:text> </xsl:text><xsl:text> </xsl:text> 							
							mél : 
							<fo:inline font-weight="bold"> 	
								<xsl:value-of select="convention/structure/mail" />  
							</fo:inline> 
							</fo:block>
							<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Represented by : (Name of the person signing the agreement) :  
									<fo:inline font-weight="bold"> 
										<xsl:value-of select="convention/signataire/civilite/libelle" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="translate(convention/signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./convention/signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(convention/signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Position / Title :
									<fo:inline font-weight="bold"> 
									 	<xsl:value-of select="convention/signataire/fonction" />
									</fo:inline> 
									</fo:block>
							
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Name of the internship mentor :
							<xsl:if test="@modification-salarie = 'true'"> 
								 <fo:inline font-weight="bold"> 
									<xsl:value-of select="contact/civilite/libelle" />
									<xsl:text> </xsl:text>  
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
									<xsl:text> </xsl:text>
									<xsl:variable name="prenom1" 
											select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
								</fo:inline>
							 </xsl:if>
							 <xsl:if test="@modification-salarie = 'false'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="convention/contact/civilite/libelle" />
									<xsl:text> </xsl:text>  
									<xsl:value-of select="translate(convention/contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
									<xsl:text> </xsl:text>
									<xsl:variable name="prenom1" 
											select="translate(substring(./convention/contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(convention/contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
								</fo:inline>
							</xsl:if>
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Tél : 
							<xsl:if test="@modification-salarie = 'true'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="contact/tel" />
								</fo:inline>
							</xsl:if>
							<xsl:if test="@modification-salarie = 'false'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="convention/contact/tel" />
								</fo:inline>
							</xsl:if>
							<xsl:text> </xsl:text><xsl:text> </xsl:text><xsl:text> </xsl:text>
							Mél : 
							<xsl:if test="@modification-salarie = 'true'"> 
								<fo:inline font-weight="bold">
									<xsl:value-of select="contact/mail" /> 
								</fo:inline>
							</xsl:if>
							<xsl:if test="@modification-salarie = 'false'"> 
								<fo:inline font-weight="bold">
									<xsl:value-of select="convention/contact/mail" /> 
								</fo:inline>
							</xsl:if>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold">
							And the <xsl:value-of select="document('config.xml')/config/nomUniversite"/>, represented by its president,
							</fo:inline>
							and acting on behalf of the department of :  
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold"> 
								<xsl:value-of select="convention/ufr/libelle" /> 
							</fo:inline>
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							And under the responsibility of the university internship coordinator:
							<xsl:if test="@modification-enseignant = 'true'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
									<xsl:text> </xsl:text> 
									<xsl:variable name="prenom1" 
											select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
								</fo:inline>
							</xsl:if>
							<xsl:if test="@modification-enseignant = 'false'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="translate(convention/enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
									<xsl:text> </xsl:text> 
									<xsl:variable name="prenom1" 
											select="translate(substring(./convention/enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(convention/enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
								</fo:inline>
							</xsl:if>
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Tél : 
							<xsl:if test="@modification-enseignant = 'true'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="enseignant/tel" />
								</fo:inline>
							</xsl:if>
							<xsl:if test="@modification-enseignant = 'false'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="convention/enseignant/tel" />
								</fo:inline>
							</xsl:if>
							<xsl:text> </xsl:text><xsl:text> </xsl:text><xsl:text> </xsl:text>
							Mél :  
							<xsl:if test="@modification-enseignant = 'true'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="enseignant/mail" />
								</fo:inline>
							</xsl:if>
							<xsl:if test="@modification-enseignant = 'false'"> 
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="convention/enseignant/mail" />
								</fo:inline>
							</xsl:if>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							And completed by :
							<fo:inline font-weight="bold">
								<xsl:value-of select="translate(convention/etudiant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
								<xsl:text> </xsl:text>
								<xsl:variable name="prenom1" 
									select="translate(substring(./convention/etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
								<xsl:variable name="prenom2" 
									select="translate(convention/etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
								<xsl:text> </xsl:text>
							</fo:inline> 
							student in : 
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="10.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold">
								<xsl:value-of select="convention/etape/libelle" />
							</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							 Student's postal address  :
							<fo:inline font-weight="bold">
								<xsl:value-of select="convention/adresse-etudiant" />
								<xsl:text> </xsl:text> 
								<xsl:value-of select="convention/code-postal-etudiant" />
								<xsl:text> </xsl:text> 
								<xsl:value-of select="convention/ville-etudiant" />
								<xsl:text> - </xsl:text> 
								<xsl:value-of select="convention/pays-etudiant" />
							</fo:inline>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							Tél :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="convention/tel-etudiant" />
							</fo:inline>
							<xsl:text> </xsl:text><xsl:text> </xsl:text><xsl:text> </xsl:text>
							portable : 
							<fo:inline font-weight="bold">
								<xsl:value-of select="convention/tel-portable-etudiant" />
							</fo:inline>
							<xsl:text> </xsl:text><xsl:text> </xsl:text><xsl:text> </xsl:text>
							Mél : 
								<fo:inline font-weight="bold">
									<xsl:value-of select="convention/etudiant/mail" />
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="9pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							For the following reason : 
								<fo:inline font-weight="bold">
									<xsl:value-of select="motif-avenant" />
								</fo:inline>
							</fo:block>							
							<fo:block line-height="110%" padding-top="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							By mutual agreement, 
							</fo:block>
						
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@rupture = 'true'"> 
								Interruption of the internship
								</xsl:if>
							</fo:block>
							
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							<xsl:if test="@modification-periode = 'true'"> 
							 The internship originally scheduled from :
								<fo:inline font-weight="bold">
									<xsl:value-of select="concat(substring(./convention/date-debut-stage,9,2),'/',substring(./convention/date-debut-stage,6,2), '/',substring(./convention/date-debut-stage,1,4))"/> 
								</fo:inline>
							 	to
							 	<fo:inline font-weight="bold">
									<xsl:value-of select="concat(substring(./convention/date-fin-stage,9,2),'/',substring(./convention/date-fin-stage,6,2), '/',substring(./convention/date-fin-stage,1,4))"/> 
								</fo:inline>
								will take place form 
								<fo:inline font-weight="bold">
									<xsl:value-of select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))"/> 
								</fo:inline>
								 from
							 	<fo:inline font-weight="bold">
									<xsl:value-of select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))"/> 
								</fo:inline>
							</xsl:if>
							</fo:block>
							
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							<xsl:if test="@modification-periode = 'true'"> 
								<xsl:if test="@interruption-stage = 'true'"> 
									interruption of internship : yes
									from
									<fo:inline font-weight="bold">
										<xsl:value-of select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))"/> 
									</fo:inline>
									 to
								 	<fo:inline font-weight="bold">
										<xsl:value-of select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))"/> 
									</fo:inline>
									<xsl:if test="convention/interruption-stage = 'false'"> 
								 	in place of : "no interruption of internship"
									</xsl:if>
									
									<xsl:if test="convention/interruption-stage = 'true'"> 
								 	in place of : interruption scheduled : 
										<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./convention/date-debut-interruption,9,2),'/',substring(./convention/date-debut-interruption,6,2), '/',substring(./convention/date-debut-interruption,1,4))"/> 
										</fo:inline>
								 		from
								 		<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./convention/date-fin-interruption,9,2),'/',substring(./convention/date-fin-interruption,6,2), '/',substring(./convention/date-fin-interruption,1,4))"/> 
										</fo:inline>
								</xsl:if>
									
								</xsl:if>
								<xsl:if test="@interruption-stage = 'false'"> 
									<xsl:if test="convention/interruption-stage = 'true'"> 
									interruption of internship : no in place of : 
								 	interruption scheduled :  
										<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./convention/date-debut-interruption,9,2),'/',substring(./convention/date-debut-interruption,6,2), '/',substring(./convention/date-debut-interruption,1,4))"/> 
										</fo:inline>
								 		from
								 		<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./convention/date-fin-interruption,9,2),'/',substring(./convention/date-fin-interruption,6,2), '/',substring(./convention/date-fin-interruption,1,4))"/> 
										</fo:inline>
									</xsl:if>
									
								</xsl:if>
							</xsl:if>
							</fo:block>
							
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							<xsl:if test="@modification-sujet = 'true'"> 
							 		The subject of the internship will be replaced by : 
							 		<fo:inline font-weight="bold">
										<xsl:value-of select="sujet-stage" />
									</fo:inline>
							 </xsl:if>
							 </fo:block>
							 
							 <fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							 <xsl:if test="@modification-salarie = 'true'"> 
									The internship mentor originally planned <xsl:text> </xsl:text>
									<fo:inline font-weight="bold"> 
										<xsl:value-of select="convention/contact/civilite/libelle" />
										<xsl:text> </xsl:text>  
										<xsl:value-of select="translate(convention/contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./convention/contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
												select="translate(convention/contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
									</fo:inline>
									<xsl:text> </xsl:text> will be replaced by : 
									<fo:inline font-weight="bold">
										<xsl:value-of select="contact/civilite/libelle" />
										<xsl:text> </xsl:text>  
										<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
												select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
									</fo:inline>
							 </xsl:if>
							 </fo:block>
							 
							 <fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-enseignant = 'true'"> 
									The university internship coordinator originally planned <xsl:text> </xsl:text>
									<fo:inline font-weight="bold"> 
										<xsl:value-of select="convention/enseignant/civilite/libelle" />
										<xsl:text> </xsl:text>  
										<xsl:value-of select="translate(convention/enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./convention/enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
												select="translate(convention/enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
									</fo:inline>
									<xsl:text> </xsl:text> will be replaced by  : 
									<fo:inline font-weight="bold">
										<xsl:value-of select="enseignant/civilite/libelle" />
										<xsl:text> </xsl:text>  
										<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
												select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
									</fo:inline>
							 </xsl:if>
							  </fo:block>
							 
							  <fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							 <xsl:if test="@modification-lieu = 'true'"> 
									The internship originally planned  
									<fo:inline font-weight="bold">
										<xsl:value-of select="convention/service/nom" />
										<xsl:text> </xsl:text>
										<xsl:value-of select="convention/service/voie" /> 
										<xsl:text> </xsl:text>
										<xsl:value-of select="convention/service/code-postal" />  
										<xsl:text> </xsl:text>
										<xsl:value-of select="convention/service/commune" /> 
										<xsl:text> </xsl:text>
										<xsl:value-of select="convention/service/pays/libelle" /> 
									</fo:inline>
							 		will be completed in the department :
							 		<fo:inline font-weight="bold">
										<xsl:value-of select="service/nom" />
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
							
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
							 <xsl:if test="@modification-montant-gratification = 'true'">			 
							 		The amount  of the gratuity will be  :
							 		<fo:inline font-weight="bold">
										<xsl:value-of select="montant-gratification" />
										<xsl:text> </xsl:text>
										euros <xsl:text> </xsl:text> 
										<xsl:value-of select="unite-gratification/libelle" /> per month
									</fo:inline>
							 </xsl:if>
							</fo:block>				
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
		</fo:table>
	</xsl:template>
		<xsl:template name="Fait">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">			
			
			<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
				
					<!-- partie signature -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										Signed in ....................................... date .......................................
									</fo:block>
									<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>										
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								For the sending Institution 
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="convention/nom-signataire-composante">											
									</xsl:when>
									<xsl:otherwise>											
											(name and signature of its representative)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								
								<xsl:choose>
									<xsl:when test="convention/centre-gestion/nom-viseur">
									Delegated,  
										<fo:inline font-weight="bold">			
											<xsl:variable name="prenom1" 
												select="translate(substring(./convention/centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
											<xsl:variable name="prenom2" 
											select="translate(convention/centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
											<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>											
											<xsl:text> </xsl:text> 
											<xsl:value-of select="translate(convention/centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 											
										</fo:inline> 
									</xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
											<xsl:value-of select="convention/nom-signataire-composante" />
										</fo:inline>
									</xsl:otherwise>
								</xsl:choose> 	
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								For the Host organisation :
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="convention/signataire/nom">	
									</xsl:when>
									<xsl:otherwise>
								(name and signature of its representative)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./convention/signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(convention/signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(convention/signataire/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
								</fo:inline> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								For the student
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="convention/etudiant/nom">	
									</xsl:when>
									<xsl:otherwise>
								(name and signature)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./convention/etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
										select="translate(convention/etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(convention/etudiant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />  
								</fo:inline> 
							</fo:block>												
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								<fo:inline text-decoration="underline">VISAS OF THE SUPERVISORS : </fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Host organisation mentor
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-salarie = 'false'"> 
									<xsl:choose>
										<xsl:when test="convention/contact/nom">	
										</xsl:when>
										<xsl:otherwise>
									(name and signature)
										</xsl:otherwise>
									</xsl:choose>
								 </xsl:if>
								 <xsl:if test="@modification-salarie = 'true'"> 
									<xsl:choose>
										<xsl:when test="contact/nom">	
										</xsl:when>
										<xsl:otherwise>
									(name and signature)
										</xsl:otherwise>
									</xsl:choose>
								 </xsl:if>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-salarie = 'true'"> 
								 <fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
											select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
									<xsl:variable name="prenom2" 
											select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
									<xsl:text> </xsl:text>  
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
								</fo:inline>
							 </xsl:if>
							 <xsl:if test="@modification-salarie = 'false'"> 
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
											select="translate(substring(./convention/contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(convention/contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(convention/contact/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')"  /> 
								</fo:inline>
							</xsl:if>
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Sending institution supervisor
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-enseignant = 'true'"> 
									<xsl:choose>
										<xsl:when test="enseignant/nom">	
										</xsl:when>
										<xsl:otherwise>
									(name and signature)
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>
								<xsl:if test="@modification-enseignant = 'false'"> 
									<xsl:choose>
										<xsl:when test="convention/enseignant/nom">	
										</xsl:when>
										<xsl:otherwise>
									(name and signature)
										</xsl:otherwise>
									</xsl:choose>
								</xsl:if>	
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:if test="@modification-enseignant = 'true'"> 
									<fo:inline font-weight="bold">
										<xsl:variable name="prenom1" 
											select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
									</fo:inline> 
								 </xsl:if>
								 <xsl:if test="@modification-enseignant = 'false'"> 
									<fo:inline font-weight="bold">
										<xsl:variable name="prenom1" 
											select="translate(substring(./convention/enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" />
										<xsl:variable name="prenom2" 
											select="translate(convention/enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß','abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
										<xsl:text> </xsl:text>
										<xsl:value-of select="translate(convention/enseignant/nom,'abcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ','ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß')" /> 
									</fo:inline> 
								 </xsl:if>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								_____________________________________________
							</fo:block>
							
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" padding-top="5pt">
								Additional clause printed on : <xsl:value-of select = "java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())"/> 
								Copy for: host the Host organisation / home institution / student. 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
		</fo:table>

		</fo:block>
		<fo:block id="theEnd" />
	</xsl:template>
	
</xsl:stylesheet>