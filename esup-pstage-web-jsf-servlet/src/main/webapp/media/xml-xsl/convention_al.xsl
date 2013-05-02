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
		<fo:block >
			<xsl:call-template name="preambule" />
		</fo:block>
		<fo:block >
			<xsl:call-template name="infosEtuStage" />
		</fo:block>
		<fo:block >
			<xsl:call-template name="CPAM" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage2" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage3" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block padding-top="8pt">
			<xsl:call-template name="ArticlesPage4" />
		</fo:block>
		<fo:block break-after="page"/>
		<fo:block >
			<xsl:call-template name="Charte" />
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
								
							</fo:block>
						</fo:table-cell>
						<fo:table-cell width="3cm">
							<fo:block  width="3.493cm"
								line-height="110%" language="fr" country="FR" font-size="12pt">
								Universit�tsjahr
								<xsl:value-of select="annee" />
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
	
	<!-- partie preambule -->
	<xsl:template name="preambule">
		<fo:block line-height="110%" 
				hyphenate="false" language="fr" country="FR" font-size="12pt"
				font-family="Times New Roman,serif" text-align="justify">
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell >
						<fo:block line-height="110%" padding-top="5pt"
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">Praktikums�bereinkommen 
							<!--xsl:value-of select="type-convention/libelle" >
							<xsl:text> </xsl:text> n� <xsl:text> </xsl:text> <xsl:value-of select="id-convention" /-->
							</fo:inline>
						</fo:block>
						<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
						</fo:block>
						<!--fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="8pt"
							font-family="Times New Roman,serif" text-align="justify">
							<fo:inline font-size="8pt" font-style="italic"
								font-weight="bold">
								<fo:inline text-decoration="underline">Pr�ambel: Praktika au�erhalb von �ffentlichen Verwaltungen und staatlichen Einrichtungen, die keinen industriellen oder kommerziellen Charakter aufweisen: </fo:inline>
								Die Unterzeichner vorliegenden Praktikums�bereinkommens geben, an vom Artikel 9 des neugefassten Gesetzes Nr. 2006-396 zur Chancengleichheit und seinen Ausf�hrungsbestimmungen, vom Gesetz Nr. 2009-1437 
								vom 24.November 2009 bez�glich der beruflichen Orientierung und Ausbildung w�hrend des ganzen Lebens, sowie der Praktikumscharta (Anlage 1) Kenntnis genommen zu haben. Sie akzeptieren deren Grunds�tze.
								<fo:inline text-decoration="underline">Praktika in �ffentlichen Verwaltungen und staatlichen Einrichtungen die keinen industriellen oder kommerziellen Charakter aufweisen </fo:inline>
								Die Unterzeichner vorliegenden Praktikums�bereinkommens geben an, vom Erlass 2009-885 vom 21. Juli 2009 bez�glich der Aufnahmebedingungen f�r Studenten des Hochschulwesens, 
								die ein Praktikum in �ffentlichen Verwaltungen und staatlichen Einrichtungen, die keinen industriellen oder kommerziellen Charakter aufweisen, durchf�hren, Kenntnis genommen zu haben.
							</fo:inline>
						</fo:block-->
						<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif">
								<fo:leader/>
						</fo:block>
						<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" text-align="center">
							<fo:inline font-weight="bold">ZWISCHEN</fo:inline>
						</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
		</fo:table>
	</xsl:template>
		<!-- partie Infos Etudiant - Stage -->
	<xsl:template name="infosEtuStage">
	
		<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(0.5)" />
				<fo:table-column column-width="proportional-column-width(0.5)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
					<fo:table-row margin-top="20px" text-align="left">
						<!-- partie Etablissement Superieur - Stage -->
							<fo:table-cell number-columns-spanned="3" padding-top="3pt" padding-bottom="3pt" padding-left="5pt" padding-right="5pt">
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									<fo:inline font-weight="bold">
										der Hochschuleinrichtung :
									</fo:inline>
								</fo:block>
								
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								Name der Einrichtung : 
								<fo:inline font-weight="bold">
									<xsl:choose>
										<xsl:when test="nom-etab-ref">
											<xsl:value-of select="nom-etab-ref" />
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
								Adresse : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="adresse-etab-ref">
												<xsl:value-of select="adresse-etab-ref" />
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
								Vertreten durch (Name des (der) Unterzeichneten der Vereinbarung) : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="nom-signataire-composante">
												<xsl:value-of select="nom-signataire-composante" />
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
								Funktion des Vertreters : 
									<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="qualite-signataire">
												<xsl:value-of select="qualite-signataire" />
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
								Einheit/ Fachbereich/ <xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										<xsl:value-of select="centre-gestion/nom-centre" />
									</fo:inline>
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" >
								Adresse:(wenn abweichend) 
									<fo:inline font-weight="bold">
										<xsl:value-of select="centre-gestion/batiment-residence" /> 
										<xsl:text> </xsl:text> 
										<xsl:value-of select="centre-gestion/voie" /> 
										<xsl:text> </xsl:text> 
										<xsl:value-of select="centre-gestion/code-postal" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="centre-gestion/commune" />
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
							T�l :
							<xsl:value-of select="centre-gestion/telephone" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm"  >
							fax : 
							<xsl:value-of select="centre-gestion/fax" /> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" >
							Mail : 
							<xsl:value-of select="centre-gestion/mail" />  
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<!-- partie Entreprise ou organisme accueil -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										<fo:inline font-weight="bold">
											Der Empfangseinrichtung: 
										</fo:inline>
									</fo:block>
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Name : 
									<fo:inline font-weight="bold">
										<xsl:value-of select="structure/raison-sociale" /> 
									</fo:inline>
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Adresse : 
										<fo:inline font-weight="bold">  
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
								
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							T�l :
							<xsl:value-of select="structure/telephone" />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							fax : 
							<xsl:value-of select="structure/fax" /> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Mail: 
							<xsl:value-of select="structure/mail" />  
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-left="5pt" padding-right="5pt">
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Vertreten durch: (Name des (der) Unterzeichneten der Vereinbarung): 
									<fo:inline font-weight="bold"> 
										<xsl:value-of select="signataire/civilite/libelle" />
										<xsl:text> </xsl:text> 
										<xsl:value-of select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />  
										<xsl:text> </xsl:text>
										<xsl:variable name="prenom1" 
												select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
										<xsl:variable name="prenom2" 
											select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
										<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Funktion des Vertreters : 
									<fo:inline font-weight="bold"> 
									 	<xsl:value-of select="signataire/fonction" />
									</fo:inline> 
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Name der Abteilung, in der das Praktikum durchgef�hrt wird:
										<fo:inline font-weight="bold">
											<xsl:value-of select="service/nom" />
										</fo:inline>
									</fo:block>
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									Ort des Praktikums:(wenn abweichend von der Firmenadresse)  
										
										<xsl:if test="service/voie != structure/voie"> 
							 				<fo:inline font-weight="bold">
											<xsl:value-of select="service/batiment-residence" />
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
							</fo:table-cell>
					</fo:table-row>
					<!-- partie Etudiant -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										<fo:inline font-weight="bold">
											Und dem/der Praktikanten/Praktikantin : 
										</fo:inline>
									</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell   padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Name : 
							<fo:inline font-weight="bold">
								<xsl:value-of select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Vorname : 
							<fo:inline font-weight="bold">
								<xsl:variable name="prenom1" 
									select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
								<xsl:variable name="prenom2" 
									select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
								<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" > 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Geschlecht :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold"><xsl:value-of select="etudiant/code-sexe" /></fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							geboren am :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold"> 
							<xsl:value-of select="concat(substring(./etudiant/date-nais,9,2),'/',substring(./etudiant/date-nais,6,2), '/',substring(./etudiant/date-nais,1,4))"/> 
							</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row margin-top="20px" text-align="left">
						<fo:table-cell number-columns-spanned="3"  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Adresse : 
							<fo:inline font-weight="bold">
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
					<fo:table-row text-align="left">
						
						<!--fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Tel :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-etudiant" />
							</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							portable : 
							<fo:inline font-weight="bold">
								<xsl:value-of select="tel-portable-etudiant" />
							</fo:inline>
							</fo:block>
						</fo:table-cell-->
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Mail :  
							<xsl:text> </xsl:text>
							<fo:inline font-weight="bold">
								<xsl:value-of select="etudiant/mail" />							
							</fo:inline> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
					<fo:table-row margin-top="20px" text-align="left">
						<fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Bezeichnung der in der Hochschuleinrichtung belegten Ausbildung oder des Studiengangs: 
							</fo:block>
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							<fo:inline font-weight="bold"> 
								<xsl:value-of select="etape/libelle" /> 
							</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
			</fo:table-body>
		</fo:table>
		<fo:table table-layout="fixed" width="100%" border="0.018cm solid #000000">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
				
					<!-- partie sujet stage -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								GEGENSTAND DES PRAKTIKUMS :
							<fo:inline font-size="11.5pt" font-weight="bold">
									<xsl:if test="tem-conf-sujet-teme != 'O'"> 
											<xsl:value-of select="sujet-stage" />
									 </xsl:if> 
									 <xsl:if test="tem-conf-sujet-teme = 'O'"> 
								 		Confidentiel
									 </xsl:if> 
								 </fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
								<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
									DATEN DES PRAKTIKUMS: Vom 
									<fo:inline font-weight="bold">
										
										<xsl:value-of select="concat(substring(./date-debut-stage,9,2),'/',substring(./date-debut-stage,6,2), '/',substring(./date-debut-stage,1,4))"/> 
									</fo:inline>
									<xsl:text> </xsl:text> bis <xsl:text> </xsl:text>
									<fo:inline font-weight="bold">
										<xsl:value-of select="concat(substring(./date-fin-stage,9,2),'/',substring(./date-fin-stage,6,2), '/',substring(./date-fin-stage,1,4))"/> 
									</fo:inline>
									<xsl:if test="interruption-stage = 'true'"> 
								 		<xsl:text> </xsl:text>
								 		avec interruption du : 
								 		<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./date-debut-interruption,9,2),'/',substring(./date-debut-interruption,6,2), '/',substring(./date-debut-interruption,1,4))"/> 
										</fo:inline>
										<xsl:text> </xsl:text> au <xsl:text> </xsl:text>
										<fo:inline font-weight="bold">
											<xsl:value-of select="concat(substring(./date-fin-interruption,9,2),'/',substring(./date-fin-interruption,6,2), '/',substring(./date-fin-interruption,1,4))"/> 
										</fo:inline>
									 </xsl:if>
								</fo:block>
							</fo:table-cell>
						
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="3pt" padding-bottom="3pt" padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							DAUER DES PRAKTIKUMS : 
								<xsl:choose>
										<xsl:when test="duree-exceptionnelle">
											<xsl:if test="duree-exceptionnelle != ''"> 
		 										<fo:inline font-weight="bold">
													<xsl:value-of select="duree-exceptionnelle" /> <xsl:text> </xsl:text>   <xsl:value-of select="unite-duree/libelle" />
												</fo:inline>
												<xsl:text> </xsl:text> Stunden oder Wochen oder Monate (Nichtzutreffendes bitte streichen)<fo:inline  font-size="5pt" vertical-align="super">1</fo:inline>
											</xsl:if>
											<xsl:if test="duree-exceptionnelle = ''"> 
		 										<fo:inline font-weight="bold">
													<xsl:value-of select="duree-stage" /> 
												</fo:inline> 
											<xsl:text> </xsl:text> Stunden oder Wochen oder Monate (Nichtzutreffendes bitte streichen)<fo:inline  font-size="5pt" vertical-align="super">1</fo:inline>
											</xsl:if>
	       							    </xsl:when>
										<xsl:otherwise>
											<fo:inline font-weight="bold">
													<xsl:value-of select="duree-stage" /> 
											</fo:inline> 
											<xsl:text> </xsl:text>Stunden oder Wochen oder Monate (Nichtzutreffendes bitte streichen)<fo:inline  font-size="5pt" vertical-align="super">1</fo:inline>
										</xsl:otherwise>
									</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="11.5pt"
								font-family="Times New Roman,serif" padding-left="0.141cm"
								padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
								<fo:inline font-weight="bold" font-style="italic">
										<xsl:text> </xsl:text> oder in TAGEN : ...............<fo:inline  font-size="5pt" vertical-align="super">2</fo:inline>
								</fo:inline> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					
				</fo:table-body>
		</fo:table>
		<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
		
				<fo:table-body>
				
					<!-- partie Encadrement -->
					<fo:table-row text-align="left">
						<fo:table-cell number-columns-spanned="2" padding-top="5pt" padding-bottom="5pt" padding-left="5pt" padding-right="5pt">
									<fo:block line-height="110%" 
									hyphenate="false" language="fr" country="FR" font-size="11.5pt"
									font-family="Times New Roman,serif" padding-left="0.141cm"
									padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
										<fo:inline font-weight="bold">
											Betreuung des Praktikanten durch : 
										</fo:inline>
									</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Die Hochschuleinrichtung in Person von :     
							</fo:block>
							
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Die Empfangseinrichtung in Person von :   
							</fo:block>
							
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Name :  
								<fo:inline font-weight="bold"> 
								<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />  
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Name:  
								<fo:inline font-weight="bold"> 
								<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Vorname :  
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Vorname :  
								<fo:inline font-weight="bold"> 
									<xsl:variable name="prenom1" 
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Funktion :  
								<fo:inline font-weight="bold"> 
								<xsl:if test="enseignant/type-personne = 'ENS'"> 
							 		enseignant
							 	</xsl:if>
							 	<xsl:if test="enseignant/type-personne  != 'ENS'"> 
							 		personnel
							 	</xsl:if>
							 </fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Funktion : 
								<fo:inline font-weight="bold"> 
									 <xsl:value-of select="contact/fonction" />
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Tel :  
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="enseignant/tel" />
							 	</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Tel :  
								<fo:inline font-weight="bold">
								<xsl:value-of select="contact/tel" /> 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row text-align="left">
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Mail :  
								<fo:inline font-weight="bold"> 
									<xsl:value-of select="enseignant/mail" />
							 	</fo:inline>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell  padding-left="5pt" padding-right="5pt">
							<fo:block line-height="110%" 
							hyphenate="false" language="fr" country="FR" font-size="11.5pt"
							font-family="Times New Roman,serif" padding-left="0.141cm"
							padding-right="0.141cm" padding-top="0.035cm" padding-bottom="0.035cm" >
							Mail :  
								<fo:inline font-weight="bold">
								<xsl:value-of select="contact/mail" /> 
								</fo:inline>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>

					
				</fo:table-body>
		</fo:table>
		</xsl:template>
		<xsl:template name="CPAM">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%" >
				<fo:table-column column-width="proportional-column-width(1)" />
							
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-top="2pt" padding-bottom="2pt">
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<!--fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
							Im Falle eines Unfalles zu benachrichtigende staatliche Krankenkasse "Caisse Primaire d'Assurance Maladie" 
							(au�er in Ausnahmef�llen am Wohnort des Studenten) :
								<fo:inline font-weight="bold">
									<xsl:choose>
											<xsl:when test="libelle-cPAM">
												<xsl:value-of select="libelle-cPAM" />
											</xsl:when>
											<xsl:otherwise>
												 
											</xsl:otherwise>
									</xsl:choose> 
								</fo:inline> 
							</fo:block-->
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="11.5pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" font-weight="bold" font-style="italic">
								
								<fo:inline  font-size="5pt" vertical-align="super">1</fo:inline>
								<fo:inline font-size="8pt"> Art. L612-9 des frz. Bildungsgesetzbuchs: "Die Dauer des Praktikums oder der Praktika eines selben Praktikanten in einem selben Unternehmen darf eine Dauer von 6 (sechs) Monaten pro Jahr nicht �berschreiten."
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" font-weight="bold" font-style="italic">
								
								<fo:inline  font-size="5pt" vertical-align="super">2</fo:inline>
								<fo:inline font-size="8pt">  Lesehinweis: Die Abschnitte in Fett- und Kursivschrift betreffen die Praktika in der Verwaltung und den �ffentlichen Einrichtungen des Staates.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="8pt" font-family="Times New Roman,serif" padding-top="5pt">
								convention imprim�e le : <xsl:value-of select = "java:format (java:java.text.SimpleDateFormat.new('dd-MM-yyyy kk:mm:ss'), java:java.util.Date.new())"/> 
							</fo:block>

						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
		
	</xsl:template>
	<xsl:template name="ArticlesPage2">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-right="10pt">
							<fo:block line-height="100%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Artikel 1:Gegenstand der Vereinbarung :
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Die vorliegende Vereinbarung regelt die Beziehungen zwischen der Empfangseinrichtung
								Unternehmen, �ffentliche Einrichtung, Verein.), der Hochschuleinrichtung und dem Praktikanten.
							</fo:block>
							
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Artikel 2: Gegenstand des Praktikums</fo:block>
								
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">Das Praktikum hat zum Zweck,
								dem Studenten/der Studentin Gelegenheit zu geben,
								die theoretischen und methodischen Werkzeuge aus der Ausbildung in die Praxis umzusetzen,
								eigene Kompetenzen zu identifizieren und seine/ihre berufliche Zielsetzung zu best�tigen.</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Auf dieses Weise soll das Praktikum den Studenten/die Studentin
								durch eine bessere Kenntnis der Empfangseinrichtung auf den Eintritt
								in die Arbeitswelt vorbereiten. Das Praktikum erfolgt im Rahmen der 
								Ausbildung und des pers�nlichen und beruflichen Projekts des Studenten/der Studentin.
								Es ist Teil des Studiengangs.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Das Programm des Praktikums wird entsprechend dem allgemeinen Unterrichtsprogramm
								zwischen der Empfangseinrichtung und der Hochschule erstellt. 
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">Anvertraute Aufgaben : 								
								<fo:inline font-weight="bold">
									<xsl:value-of select="fonctions-et-taches" />
								</fo:inline>  
							</fo:block>
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="100%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								<fo:inline font-weight="bold">Artikel 3 : </fo:inline>
								<fo:inline font-weight="bold">Modalit�ten des Praktikums
								</fo:inline>
							</fo:block>
							
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Die maximale Wochenarbeitszeit des/der Praktikanten/in im Unternehmen betr�gt 
								<fo:inline font-weight="bold">
									<xsl:value-of select="nb-heures-hebdo" /> 
								</fo:inline> Stunden. 
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Es handelt sich um ein Vollzeit/Teilzeitpraktikum <fo:inline font-style="italic">(Nichtzutreffendes bitte streichen) </fo:inline>
								<fo:inline font-weight="bold">
									<xsl:value-of select="temps-travail/libelle" />
								</fo:inline>
								<xsl:choose>
										<xsl:when test="commentaire-duree-travail">
											<xsl:if test="commentaire-duree-travail != ''"> 
		 										(Anteil bitte angeben :   
												<fo:inline font-weight="bold">
													<xsl:value-of select="commentaire-duree-travail" /> )
												</fo:inline>
											</xsl:if>											
	       							    </xsl:when>		
								</xsl:choose>	
								
							</fo:block>
							
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Bei einer m�glichen Anwesenheit des/der Praktikanten/in in der Empfangseinrichtung
								w�hrend der Nacht, am Sonntag oder an einem Feiertag, muss die Einrichtung
								diese Sonderf�lle untenstehend angeben.<fo:inline font-weight="bold">
									<xsl:value-of select="travail-nuit-ferie" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="100%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">Artikel 4 : Status des Praktikanten - Empfang und Betreuung
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Der Student/die Studentin beh�lt w�hrend des Praktikums
								seinen/ihren vorherigen Status bei und wird von der Hochschuleinrichtung
								regelm��ig betreut. Die Empfangseinrichtung benennt einen 
								<fo:inline font-style="italic">Tutor der Empfangseinrichtung
								</fo:inline>
								der f�r die Betreuung und die Optimierung 
								der Durchf�hrungsbedingungen des
								Praktikums verantwortlich ist.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Der Student/die Studentin kann erm�chtigt werden,
								w�hrend der Dauer des Praktikums an die Universit�t
								zur�ckzukehren oder zu reisen, 
								um an spezifischen, vom Programm vorgesehenen Kursen
								und Versammlungen teilzunehmen, deren Daten dem Leiter der
								Empfangseinrichtung von der Universit�t mitgeteilt werden.
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Betreuungsmodalit�ten :
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-encadre-suivi" /> 
								</fo:inline>
							</fo:block>
							
							
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" keep-with-next="always"
								text-align="justify" font-weight="bold">Artikel 5 :
								Verg�tung - Sachleistungen - Erstattung von Kosten 
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Die Verg�tung ist zwingend, wenn die Praktikumsdauer <fo:inline font-style="italic"> innerhalb eines Unternehmens, eines Vereins, eines Staatsbetriebs
								oder einer �ffentlichen Einrichtung mit kommerziellem und industriellem
								Charakter auf franz�sischem Staatsgebiet</fo:inline> zwei aufeinander folgende Monate �berschreitet.
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Die Verg�tung ist zwingend, wenn die Praktikumsdauer in der Verwaltung oder
								in einer �ffentlichen Verwaltungseinrichtung des Staates auf franz�sischem 
								Staatsgebiet zwei aufeinander folgende Monate �berschreitet und mindestens 
								40 Tage Anwesenheit erreicht.
							</fo:block>
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Fehlt ein branchenspezifisches Abkommen oder ein berufliches �bereinkommen,
								wird der Stundenbetrag der Verg�tung auf 12,5 % des Basisstundenlohns der
								Sozialversicherung gem�� Artikel L.241-3 des Sozialgesetzbuchs festgelegt. 
							</fo:block>
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify"
								font-weight="bold">
								Bei Praktika in Verwaltungen und �ffentlichen Verwaltungseinrichtungen des Staates 
								entspricht die Verg�tung obligatorisch dem obengenannten Basisstundenlohn.
							</fo:block>
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="justify">
								Wenn die Praktikumsdauer <fo:inline font-style="italic">innerhalb eines privaten oder �ffentlichen 
								Unternehmens oder eines Vereins auf franz�sischem Staatsgebiet 
								zwei aufeinander folgende Monate nicht �berschreitet, 
								kann der Praktikant/die Praktikantin eine Verg�tung erhalten.</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								H�he der Verg�tung (wenn abweichend vom gesetzlichen Betrag)
								<xsl:variable name="nb-montant-gratification" select="montant-gratification" />
								<xsl:choose>
									<xsl:when test='$nb-montant-gratification=""'>
 
       							    </xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
												<xsl:value-of select="montant-gratification" /> 
											</fo:inline> euros <xsl:text> </xsl:text> <xsl:value-of select="unite-gratification/libelle" /> par mois
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Modalit�t der Auszahlung der Verg�tung:
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-vers-gratification/libelle" /> 
								</fo:inline>
							</fo:block>					
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Hat der Praktikant/die Praktikantin Anrecht auf Sachleistungen (z.B. kostenlose Mahlzeiten),
								so wird der Betrag, der dem Wert dieser Sachleistungen entspricht,
								zur monatlichen Verg�tung hinzugerechnet, bevor der Gesamtbetrag mit den 12,5 %
								des Basisstundenlohns der Sozialversicherung f�r eine gesetzliche 
								Arbeitsdauer von 35 Wochenstunden verglichen wird. 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Kosten f�r Reisen oder Unterbringung, die der Praktikant/ die Praktikantin auf Anforderung des Unternehmens eingeht sowie die eventuell
								f�r das Praktikum anfallenden Schulungskosten werden entsprechend der
								im Unternehmen geltenden Modalit�ten vollst�ndig von diesem �bernommen. 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								iste der angebotenen Vorteile : <fo:inline font-weight="bold">
									<xsl:value-of select="avantages-nature" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
										>
								Die Praktikanten haben unter den gleichen Bedingungen wie die Angestellten Zugang zu den 
								in Artikel L2323-83 des Arbeitsgesetzbuchs genannten sozialen und kulturellen Aktivit�ten.  
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify"
										font-weight="bold">
								Findet das Praktikum in einer Verwaltung oder einer �ffentlichen Verwaltungseinrichtung des Staates statt,
								so werden dem Studenten/der Studentin die Missionskosten entsprechend dem Dekret 2006-781 erstattet,
								administrativer Wohnsitz ist dabei der Ort des Praktikums. 
							</fo:block>
							
							<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								Bei Praktika in einer Verwaltung oder einer �ffentlichen Verwaltungseinrichtung des Staates: 
								�bernahme der Kosten Wohnort - Praktikumsort entsprechend der Bedingungen des Dekrets 2010-676: ..........(Ja oder Nein angeben)
							</fo:block>
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify" font-weight="bold">Artikel 6: Sozialversicherungsschutz
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								W�hrend der Dauer des Praktikums erh�lt der Student/die Studentin weiterhin die Leistungen seiner/ihrer
								bestehenden Krankenversicherung:
								Er/sie behalten ihren Status als Studenten bei.
								Auslandspraktika m�ssen vor der Abreise des/der Studenten/in gemeldet und von der Krankenkasse genehmigt werden.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die folgenden Bestimmungen gelten unter Vorbehalt der �bereinstimmung mit der Gesetzgebung 
								des Empfangsstaates und den Bestimmungen der Empfangseinrichtung:
							</fo:block>
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.1 Verg�tung weniger oder gleich</fo:inline>
									dem Betrag von 12,5 % des Basisstundenlohns der Sozialversicherung multipliziert mit
									der Anzahl der Stunden, die im betroffenen Monat geleistet wurden:
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								In diesem Fall ist die Praktikumsverg�tung entsprechend geltendem Recht von Sozialabgaben befreit.
								Der/die Student/in profitiert weiterhin von der Gesetzgebung zu den Arbeitsunf�llen gem�� 
								Artikel L.412-8-2 des Sozialgesetzbuchs,
								 studentische Sozialversicherung.
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								F�r den Fall, dass der/die Student/in w�hrend seiner/ihrer Arbeit in der Empfangseinrichtung, oder w�hrend der Fahrt oder an einem durch die
								Anforderungen des Praktikums n�tzlich gewordenen Ort einen Unfall erleidet
								<fo:inline font-size="10pt" font-style="italic">
								sowie f�r die Studenten in Medizin, Zahnmedizin oder Pharmazeutik ohne Krankenhausstatus w�hrend des Praktikums
								im Krankenhaus unter den Bedingungen der Abs�tze b oder 2o des Artikels  L. 412-8,
								</fo:inline>
								<fo:inline font-size="10pt" font-weight="bold">
								schickt die Empfangseinrichtung die Unfallerkl�rung an die 
								</fo:inline> 
								Ortskrankenkasse (siehe Adresse auf der ersten Seite) und nennt dabei die Hochschule als Arbeitgeber, 
								<fo:inline font-size="10pt" font-weight="bold">
								mit Kopie an die Hochschule. 
								</fo:inline> 
							</fo:block>
							
							<fo:block line-height="50%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif">
								<fo:leader />
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.2 Verg�tung von mehr </fo:inline>
									als dem Betrag von 12,5% des Basisstundenlohns der Sozialversicherung multipliziert mit der Anzahl der Stunden,
									die im betroffenen Monat geleistet wurden: 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
								Die Sozialabgaben werden auf dem Unterschied zwischen dem Betrag der Verg�tung und 12,5 % des Basisstundenlohns der
								Sozialversicherung f�r eine gesetzliche Arbeitsdauer von 35 Wochenstunden berechnet.
							</fo:block>					
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
	<!-- troisieme page -->
	
	<xsl:template name="ArticlesPage3">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-right="10pt">
								<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
										hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="justify">
									Der/die Student/in profitiert von den gesetzlichen Leistungen gem�� Artikel L.411-1 folgende des Sozialgesetzbuchs. F�r den Fall, dass der/die 
									Student/in w�hrend seiner/ihrer Arbeit in der Empfangseinrichtung, oder w�hrend der Fahrt oder an einem durch die
								</fo:block>
							
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Anforderungen des Praktikums n�tzlich gewordenen Ort einen Unfall erleidet, unternimmt die Empfangseinrichtung
									alle notwendigen Schritte bei der Krankenkasse und informiert die Hochschule so schnell wie m�glich.
								</fo:block>
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.3 Krankenversicherungen des Praktikanten im Ausland:</fo:inline>
							</fo:block>
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									1) <fo:inline font-size="10pt" font-weight="bold"> Ausgehend von der franz�sischen studentischen Sozialversicherung:</fo:inline>
							</fo:block>
								<fo:block line-height="100%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- F�r Praktika innerhalb des Europ�ischen Wirtschaftsraums (EWR),
									die von Studenten/Studentinnen aus einem EU-Staat durchgef�hrt werden,
									m�ssen die Studenten eine europ�ische Krankenversicherungskarte beantragen.
								</fo:block>
								
								<fo:block line-height="50%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									- F�r Praktika, die in Qu�bec von Studenten/Studentinnen franz�sischer Staatsb�rgerschaft durchgef�hrt werden, muss das Formular 
									<fo:inline font-size="10pt" text-decoration="underline">SE401Q</fo:inline> (104 f�r Unternehmenspraktika, 106 f�r Universit�tspraktika)
									beantragt werden.
								</fo:block>
								<fo:block line-height="50%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
								<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:inline font-size="10pt" text-decoration="underline">- In allen anderen F�llen :</fo:inline>
									Studenten/Studentinnen, die im Ausland Gesundheitsausgaben haben, k�nnen sich diese
									Betr�ge bei ihrer Zusatzkrankenkasse (Mutuelle), die als Studentenkrankenkasse
									funktioniert, nach Vorlage von Belegen bei ihrer R�ckkehr zur�ckerstatten lassen.
									Da diese R�ckerstattung	auf der Basis der franz�sischen Behandlungskosten erfolgt,
									k�nnen bedeutende Abweichungen auftreten.
								</fo:block>
								<fo:block line-height="50%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								Es ist sehr zu empfehlen, dass die Studenten eine spezifische Zusatzversicherung
								f�r das entsprechende Land und die Dauer des Praktikums bei einer von ihnen gew�hlten
								Kasse abschlie�en (Studentenkasse, Versicherung der Eltern, private
								Versicherungsgesellschaft...).
							</fo:block>
							
							<fo:block line-height="50%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt" 
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								
								<fo:inline font-size="10pt" text-decoration="underline">� Ausnahme </fo:inline> : Wenn die Empfangseinrichtung
								dem Studenten/der Studentin entsprechend der �rtlichen Bestimmungen 
								(siehe 2 unten) eine Krankenversicherung bereitstellt, kann der/die Student/die 
								Studentin diese Versicherung in Anspruch nehmen. Vor dieser Wahl m�ssen die 
								angebotenen Leistungen gepr�ft werden.
							</fo:block>
							<fo:block line-height="50%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									2)<fo:inline font-size="10pt" font-style="italic">Krankenversicherung durch die Empfangseinrichtung :</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-style="italic">Durch das Ankreuzen des entsprechenden 
									K�stchens erkl�rt die Empfangseinrichtung untenstehend, ob sie nach lokalem Recht eine Krankenversicherung f�r den 
									Praktikanten/die Praktikantin bereitstellt:
									</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block >
								<fo:external-graphic src="url('square.JPG')" /> <fo:inline font-size="10pt" font-weight="bold"> JA</fo:inline> (diese kommt zum Erhalt der Leistungen aus der
								franz�sischen Studentenversicherung im Ausland hinzu)
							</fo:block>
							<fo:block line-height="100%"  padding-bottom="2pt" hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block>
								<fo:external-graphic src="url('square.JPG')" /> <fo:inline font-size="10pt" font-weight="bold"> NEIN</fo:inline> (der Schutz beruht einzig auf den Leistungen aus der franz�sischen
								Studentenversicherung im Ausland)
								</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Wenn kein K�stchen angekreuzt ist, tritt 6.3 1/ in Kraft.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" space-before="0cm" space-after="0cm" font-weight="bold" text-align="justify">
							<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									<fo:inline font-size="10pt" font-weight="bold">6.4 Arbeitsunfallversicherung des Praktikanten im Ausland:</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									1) Um von der franz�sischen Gesetzgebung hinsichtlich der Leistungen bei 
									Arbeitsunf�llen zu profitieren, darf das vorliegende Praktikum:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Eine maximale Dauer - Verl�ngerungen eingeschlossen - von 12 Monaten haben.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Zu keiner Verg�tung f�hren, die im entsprechenden Ausland das Recht auf einen 
									Arbeitsunfallsschutz er�ffnen k�nnte (eine Verg�tung von 12,5 % des Basisstundenlohns 
									der Sozialversicherung f�r eine gesetzliche Arbeitsdauer von 35 Wochenstunden wird vorbehaltlich
									dem Einverst�ndnis der Krankenkasse akzeptiert). 
							</fo:block>
						</fo:table-cell>
						<fo:table-cell >
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Nur im Unternehmen stattfinden, das Partei der vorliegenden Vereinbarung ist.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-   Nur im genannten Land stattfinden.
							</fo:block>
							<!--fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
									<fo:leader />
								</fo:block-->
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Sind diese Bedingungen nicht erf�llt, verpflichtet sich die Empfangseinrichtung, den Praktikanten
									zu versichern und im Fall eines Arbeitsunfalls die notwendigen Erkl�rungen abzugeben.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									2) Die Unfallerkl�rung ist Sache der Hochschule, die innerhalb von 48 
									Stunden von der Empfangseinrichtung informiert werden muss.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									3) Die Versicherung betrifft Unf�lle an den folgenden Orten: 
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Innerhalb des Praktikumsorts und zu den Uhrzeiten des Praktikums.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Auf dem �blichen Hin- und R�ckweg zwischen dem Wohnort des Praktikanten im 
									Ausland und dem Ort des Praktikums.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Auf dem Hin- und R�ckweg (Beginn und Ende des Praktikums) 
									zwischen dem Wohnort des Praktikanten 
									in Frankreich und dem Wohnort im Ausland.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									-	Im Rahmen einer von der Empfangseinrichtung 
									angeordneten und mit einer entsprechenden Order versehenen Mission.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									4) Ist auch nur eine der Bedingungen von Punkt 6.4 1/ nicht erf�llt, verpflichtet sich die
									Empfangseinrichtung durch die vorliegende Vereinbarung, den Praktikanten gegen
									Arbeitsunf�lle, Reisen und Berufskrankheiten zu versichern und alle notwendigen
									Erkl�rungen abzugeben.
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="1pt" padding-bottom="1pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								5) In jedem Fall:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								-	Muss die Empfangseinrichtung im Fall eines Arbeitsunfalls
								eines Praktikanten/einer Praktikantin diesen Unfall unbedingt <fo:inline font-size="10pt" text-decoration="underline">sofort</fo:inline>
								der Hochschule melden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								-	Wenn der Studenten/die Studentin einzelne Missionen au�erhalb der Empfangseinrichtung oder des Praktikumslands ausf�hrt, muss die Empfangseinrichtung 
								alle notwendigen Ma�nahmen ergreifen, um die entsprechenden Versicherungen bereitzustellen.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" 
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 7: Haftpflicht und Versicherungen
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Die Empfangseinrichtung und der/die Student/in erkl�ren, �ber eine Haftpflichtversicherung zu verf�gen.
							</fo:block>
							<fo:block line-height="100%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Unabh�ngig von der Art des Praktikums und dem Bestimmungsland verpflichtet sich der/die Student/in zum Abschluss
								eines Auslandsschutzes (gesundheitsbedingter R�cktransport, Rechtshilfe.) sowie einer individuellen Unfallversicherung. 
							
							</fo:block>
							<fo:block line-height="100%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Wenn die Empfangseinrichtung dem Studenten/der Studentin ein Fahrzeug zur Verf�gung stellt, muss sie vorher sicherstellen,
								dass die Versicherungspolice des Fahrzeugs eine Nutzung durch den Studenten abdeckt.
							</fo:block>
							<fo:block line-height="100%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Wenn der/die Student/in im Rahmen des Praktikums sein/ihr eigenes oder ein von einem Dritten geliehenes Fahrzeug benutzt,
								muss er/sie dem Versicherer diese Nutzung ausdr�cklich mitteilen und die eventuell anfallende Pr�mie bezahlen.
							</fo:block>					
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 8: Disziplin
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Die Studenten m�ssen die Disziplin und die Hausordnung der Empfangseinrichtung achten (deren Regeln ihnen mitgeteilt werden),
								insbesondere was die Arbeitszeiten sowie die geltenden Hygiene- und Sicherheitsregeln betrifft.
							</fo:block>
							<fo:block line-height="100%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Nur die Hochschule ist berechtigt, disziplinarische Ma�nahmen zu ergreifen. In diesen F�llen informiert die Empfangseinrichtung
								die Hochschule �ber die Vergehen und �bermittelt die eventuell vorhandenen Elemente.
							</fo:block>
							<fo:block line-height="100%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Im Fall besonders schwerer Verst��e gegen die Disziplin beh�lt sich die Empfangsreinrichtung das Recht vor, das Praktikum 
								des/der Studenten/in unter Beachtung des Artikels 9 der vorliegenden Vereinbarung zu beenden.
							</fo:block>					
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
		<!-- quatrieme page -->
	
	<xsl:template name="ArticlesPage4">
		<fo:block line-height="110%" hyphenate="false" language="fr"
			country="FR" font-size="10pt" font-family="Times New Roman,serif"
			margin-left="0cm" margin-right="0cm" text-indent="0cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-body>
					<fo:table-row >
						<fo:table-cell padding-right="10pt">
								
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 9: Abwesenheit und Unterbrechung des Praktikums
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Jede im Verlauf des Praktikums auftretende Schwierigkeit muss
								allen Parteien bekanntgemacht und so schnell wie m�glich bereinigt werden.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="11.5pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Zeitweilige Unterbrechung :
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								W�hrend des Praktikums kann der Studenten/die Studentin �ber Urlaubstage verf�gen,
								wenn die Empfangseinrichtung einverstandenist und die Praktikumsdauer eingehalten wird.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Die Empfangseinrichtung wird jede andere zeitweilige Unterbrechung des Praktikums (Krankheit, Schwangerschaft, ungerechtfertigtes Fehlen...)
								der Hochschule schriftlich melden.
							</fo:block>
											
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Definitive Unterbrechung:
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" >
								Im Fall, dass eine der drei Parteien (Empfangseinrichtung, Hochschule, Student/Studentin) das Praktikum 
								definitiv unterbrechen will, muss sie die beiden anderen Parteien schriftlich davon in Kenntnis setzen.
								Die daf�r angegebenen Gr�nde werden in enger Absprache untersucht. 
								Die definitive Entscheidung eines Abbruchs des Praktikums erfolgt erst nach dieser Abstimmungsphase.
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 10: Schweigepflicht und Vertraulichkeit
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify">
								Die Schweigepflicht ist strikt einzuhalten. Die Studenten verpflichten sich damit,
								die Informationen, die sie w�hrend des Praktikums gesammelt oder erhalten haben,
								nicht ohne das Einverst�ndnis der Empfangseinrichtung zu ver�ffentlichen oder
								sie an Dritte weiterzugeben, inklusive des Praktikumsberichts.
								Diese Verpflichtung gilt nicht nur f�r die Dauer des Praktikums 
								sondern auch nach dessen Ende. Der Studenten/die Studentin verpflichtet sich, 
								ohne die Genehmigung der Empfangseinrichtung keinerlei der Einrichtung geh�rende
								Dokumente oder Software welcher Art auch immer zu behalten, mitzunehmen oder
								zu kopieren.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Nota: Im Rahmen der Vertraulichkeit der im Praktikumsbericht enthaltenen
								Informationen kann das Empfangsunternehmen fordern, dass dieser nur eingeschr�nkt
								ver�ffentlicht oder dass einige sehr vertrauliche Elemente komplett entfernt werden.
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								space-before="0cm" space-after="0cm" font-weight="normal" text-align="justify">
								<fo:inline font-size="10pt" font-style="italic">
								Die Personen, die mit dem Inhalt vertraut gemacht werden,
								sind durch das Berufsgeheimnis verpflichtet, die enthaltenen Informationen
								weder zu nutzen noch zu verbreiten. 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 11: Geistiges Eigentum
							</fo:block>	
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Entsprechend dem Gesetz �ber das geistige Eigentum muss, sollte die Arbeit
									des Praktikanten zu einem vom Urheberrecht oder dem Recht auf industrielles
									Eigentum gesch�tzten Werk f�hren (inklusive einer Software) und sollte
									die Empfangseinrichtung dieses nutzen wollen, und der Praktikant damit
									einverstanden sein, ein Vertag zwischen dem Praktikanten (Autor) und 
									der Empfangseinrichtung geschlossen werden.
							</fo:block>
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Darin m�ssen insbesondere der Rahmen der abgetretenen Rechte,
									eine eventuelle Exklusivit�t, die Bestimmung, die genutzten Tr�ger und die
									Dauer der Abtretung sowie gegebenenfalls der Betrag der Verg�tung f�r die 
									Abtretung festgelegt werden.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold" font-style="italic">
								Diese Klausel ist auch im Fall von Praktika in �ffentlichen Einrichtungen g�ltig.
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-style="italic">
								<fo:leader />
							</fo:block>		
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 12: Anstellung
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Sollte ein Arbeitsvertrag mit der Empfangseinrichtung unterzeichnet werden, der vor 
									Ende des Praktikums in Kraft tritt, so ist die vorliegende Vereinbarung nichtig 
									und der/die betroffene Student/in steht nicht mehr unter der Verantwortung der Hochschule.
									Diese muss vor Vertragsunterzeichnung unbedingt unterrichtet werden.
							</fo:block>			
						</fo:table-cell>
						<fo:table-cell >
							
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 13: Ende des Praktikums - Bericht - Bewertung
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
									country="FR" font-size="10pt" font-family="Times New Roman,serif"
									text-align="justify">
									Anschlie�end an das Praktikum stellt die Empfangseinrichtung dem Praktikanten eine
									Praktikumsbescheinigung aus und f�llt ein Bewertungsblatt �ber die Aktivit�t des 
									Praktikanten aus (Anlage), das sie an die Hochschule zur�ckschickt.
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" text-align="justify" font-family="Times New Roman,serif">
								Anschlie�end an sein Praktikum muss der Student: (Angabe der Art der eventuell zu leistenden Arbeit als Anlage)
								<fo:inline font-weight="bold">
									<xsl:value-of select="nature-travail/libelle" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" text-align="justify"
							hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Gegebenenfalls Modalit�ten f�r die Anerkennung des Praktikums: 
								<fo:inline font-weight="bold">
									<xsl:value-of select="mode-validation-stage/libelle" /> 
								</fo:inline>
							</fo:block>
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif"
								padding-top="2pt">
								<xsl:variable name="nb-credit" select="credit-eCTS" />
								Anzahl der ECTS-Credits:
								<xsl:choose>
									<xsl:when test='$nb-credit=0.00'>
 
       							    </xsl:when>
									<xsl:otherwise>
										<fo:inline font-weight="bold">
											<xsl:value-of select="credit-eCTS" /> 
										</fo:inline>
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
							<fo:block line-height="110%" text-align="justify" hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Bewertung der Praktikumsqualit�t: Nach Ende des Praktikums sind alle Parteien angehalten,
								die Qualit�t des Praktikums zu bewerten.
							</fo:block>
							<fo:block line-height="110%" text-align="justify" hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Weder der Tutor der Empfangseinrichtung noch jedes andere Mitglied der Empfangseinrichtung,
								das w�hrend der Vorbereitung, des Ablaufs und der Anerkennung des Praktikums die
								Hochschule besucht hat, kann seitens der Hochschule die �bernahme von Kosten oder
								eine Entsch�digung fordern.
							</fo:block>
							<fo:block line-height="110%" text-align="justify" hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Es kann eventuell ein Nachtrag zur vorliegenden Vereinbarung erstellt werden, wenn die 
								Empfangseinrichtung oder der/die Student/in einen Antrag auf Verl�ngerung des Praktikums stellt.
								In keinem Fall darf das Ende des Praktikums nach dem 30.09. des laufenden Jahres liegen. 
							</fo:block>
							<fo:block line-height="110%" text-align="justify" hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Der aufeinanderfolgende Empfang von Praktikanten f�r den gleichen, auf der Basis von 
								Praktikumsvereinbarungen zu besetzenden Posten ist nur nach Ablauf einer Karenzzeit m�glich,
								die einem Drittel der Dauer des vorangegangenen Praktikums entspricht.
								Diese Bestimmung ist nicht anwendbar, wenn das vorangegangene Praktikum auf 
								Initiative des Praktikanten vor dem Ende abgebrochen wurde.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%" hyphenate="false" language="fr" padding-top="2pt" padding-bottom="2pt"
								country="FR" font-size="10pt" font-family="Times New Roman,serif"
								text-align="justify" font-weight="bold">
								Artikel 14: Anwendbares Recht - Gerichtsstand
							</fo:block>
							<fo:block  text-align="justify" line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Die vorliegende Vereinbarung unterliegt ausschlie�lich franz�sischem Recht. Jeder Streitfall, 
								der nicht g�tlich beigelegt werden kann, wird der zust�ndigen franz�sischen Gerichtsbarkeit vorgelegt.
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<!--fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block-->
							<fo:block line-height="110%"  hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								Ort ....................................... Datum .......................................
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<!--fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block-->
							<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								F�r die Hochschuleinrichtung
							</fo:block>
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="nom-signataire-composante">											
									</xsl:when>
									<xsl:otherwise>											
											(Name und Unterschrift des Unterzeichneten)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
										<xsl:choose>
											<xsl:when test="centre-gestion/nom-viseur">
												<fo:inline font-weight="bold">
													<xsl:variable name="prenom1" 
														select="translate(substring(./centre-gestion/prenom-viseur,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
													<xsl:variable name="prenom2" 
														select="translate(centre-gestion/prenom-viseur,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
													<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>											
													<xsl:text> </xsl:text> 
													<xsl:value-of select="translate(centre-gestion/nom-viseur,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 											
												</fo:inline> 
											</xsl:when>
									<xsl:otherwise>
											<xsl:value-of select="nom-signataire-composante" />
									</xsl:otherwise>
									</xsl:choose> 
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
								F�r die Empfangseinrichtung
							</fo:block>
							<!--fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block-->
							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">								
								<xsl:choose>
									<xsl:when test="signataire/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Name und Unterschrift des Unterzeichneten)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./signataire/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(signataire/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(signataire/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="5pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" text-align="center">
							__________
							</fo:block>
							<!--fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block-->
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Student/in
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">	
								<xsl:choose>
									<xsl:when test="etudiant/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Name und Unterschrift)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./etudiant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(etudiant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(etudiant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
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
								<fo:inline text-decoration="underline">VERMERKE DER TUTOREN : </fo:inline>
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif" >
								Tutor der Empfangseinrichtung
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
									<xsl:when test="contact/nom">	
									</xsl:when>
									<xsl:otherwise>
								(Name und Unterschrift des Unterzeichneten)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./contact/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(contact/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	
									<xsl:text> </xsl:text> 
									<xsl:value-of select="translate(contact/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
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
								Tutor der Hochschuleinrichtung
							</fo:block>

							<fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block>
							<!--fo:block line-height="110%"  
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:leader/>
							</fo:block-->
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<xsl:choose>
									<xsl:when test="enseignant/nom">	
									</xsl:when>
									<xsl:otherwise>
									(Name und Unterschrift des Unterzeichneten)
									</xsl:otherwise>
								</xsl:choose> 
							</fo:block>
							<fo:block line-height="110%"  padding-top="2pt" padding-bottom="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt" font-family="Times New Roman,serif">
								<fo:inline font-weight="bold">
									<xsl:variable name="prenom1" 
										select="translate(substring(./enseignant/prenom,1,1),'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" />
									<xsl:variable name="prenom2" 
										select="translate(enseignant/prenom,'ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������','abcdefghijklmnopqrstuvwxyz�������������������������������')" />
									<xsl:value-of select="concat($prenom1, substring($prenom2,2))"/>	 
									<xsl:text> </xsl:text>
									<xsl:value-of select="translate(enseignant/nom,'abcdefghijklmnopqrstuvwxyz�������������������������������','ABCDEFGHIJKLMNOPQRSTUVWXYZ�������������������������������')" /> 
								</fo:inline> 
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>

		</fo:block>
	</xsl:template>
		<xsl:template name="Charte">
		<fo:block line-height="110%" 
				hyphenate="false" language="fr" country="FR" font-size="10pt"
				font-family="Times New Roman,serif" text-align="justify">
		
			<fo:table table-layout="fixed" width="100%">
					<fo:table-column column-width="proportional-column-width(1)" />
					
					<fo:table-body>
						<fo:table-row >
							<fo:table-cell >
								<fo:block line-height="110%" padding-top="2pt"
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="center">
								<fo:inline font-weight="bold">CHARTA DER STUDENTISCHEN UNTERNEHMENSPRAKTIKA  
								</fo:inline>  
								</fo:block>
								
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Der Minister f�r Besch�ftigung, sozialen Zusammenhang und Wohnungswesen
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Der Minister f�r Bildung, Hochschulen und Forschung 
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Der beigeordnete Minister f�r Besch�ftigung, Arbeit und berufliche Integration der Jugendlichen 
								</fo:block>
								<fo:block line-height="110%" 
								hyphenate="false" language="fr" country="FR" font-size="10pt"
								font-family="Times New Roman,serif" text-align="left" font-style="italic">
								Der beigeordnete Minister f�r Hochschulen und Forschung 
								</fo:block>

							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
			</fo:table>
			<fo:block line-height="110%" hyphenate="false" language="fr"
				country="FR" font-size="10pt" font-family="Times New Roman,serif"
				margin-left="0cm" margin-right="0cm" text-indent="0cm">
				<fo:table table-layout="fixed" width="100%">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row >
							<fo:table-cell padding-right="10pt">
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">I - EINF�HRUNG
								</fo:block>
								<fo:block line-height="110%" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die Entwicklung von Praktika ist heute im Bereich der beruflichen 
									Orientierung und Integration der Jugendlichen grundlegend. 
									In der Tat erlaubt das Praktikum die Anwendung theoretischer 
									Kenntnisse in einem beruflichen Rahmen und bietet dem Studierenden 
									eine Erfahrung in der Welt des Unternehmens und seiner Berufe. 
									In dieser Perspektive ist es unentbehrlich zu unterstreichen, 
									dass die Praktika einen p�dagogischen Zweck verfolgen, was bedeutet, 
									dass es keine Praktika au�erhalb des p�dagogischen Werdegangs geben kann. 
									Ein Praktikum kann keinesfalls als eine Anstellung betrachtet werden. 
									Vorliegende Charta, die von staatlicher Stelle, von Vertretern der Unternehmen, 
									Vertretern der Hochschulen und Vertretern der Studierenden erstellt wurde, 
									hat somit das Ziel, die Durchf�hrung von Praktika abzusichern und gleichzeitig 
									ihre f�r die Jugendlichen und die Unternehmen n�tzliche Entwicklung zu unterst�tzen.
								</fo:block>
								
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">II - ANWENDUNGSGEBIETE, DEFINITION 
								</fo:block>
								<fo:block line-height="110%" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">1 - Das Anwendungsgebiet der Charta  
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Das Anwendungsgebiet der Charta betrifft alle studentischen Unternehmenspraktika,
									ohne die Sonderregelungen in besonders geregelten Berufen zu beeinflussen.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - Das Praktikum 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Das Ziel des Praktikums reiht sich in ein p�dagogisches Projekt 
									ein und hat nur im Rahmen dieses Projekts einen Sinn. Damit erlaubt das Praktikum :
									- die praktische Anwendung der Kenntnisse in einem beruflichen Umfeld;
									- erleichtert den �bergang von der Welt der Hochschule in die des Unternehmens.
									In keinem Fall kann das Praktikum einer Anstellung  gleichgesetzt werden.
								</fo:block>
								
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">III - BETREUUNG DES PRAKTIKUMS 
								</fo:block>
								<fo:block line-height="110%"  padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">1 - Die Formalisierung des Praktikumsprojekts 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Das Praktikumsprojekt ist Gegenstand einer Abstimmung zwischen 
									einem Lehrer der Institution, einem Mitglied des Unternehmens 
									und dem Studierenden. Dieses Praktikumsprojekt wird in der �bereinkunft, 
									die von der lehrenden Institution, dem Unternehmen und 
									dem Praktikanten unterschrieben wird, formalisiert.    
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - Die �bereinkunft 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die �bereinkunft pr�zisiert die Verpflichtungen und Verantwortlichkeiten
									der lehrenden Institution, des Unternehmens und des Studierenden. 
									Die verpflichtenden Rubriken werden im Anhang der Charta aufgef�hrt.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">3 - Dauer des Praktikums 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die Dauer des Praktikums wird bereits bei den ersten Kontakten zwischen 
									der lehrenden Institution und dem Unternehmen festgelegt. 
									Der Studierende wird dar�ber informiert. Die Dauer des Praktikums wird ausdr�cklich 
									in der Praktikums�bereinkunft angegeben.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">4 - Die Verantwortlichen der Betreuung 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Jedes Praktikum wird doppelt betreut und zwar durch :  
									- einen Lehrer der Lehranstalt ;
									- ein Mitglied des Unternehmens.
									Der Lehrer und das Mitglied des Unternehmens arbeiten zusammen, 
									werden informiert und informieren sich �ber die Fortschritte des Praktikums 
									und die m�glichen Schwierigkeiten. Der Verantwortliche des Praktikums innerhalb 
									der Lehranstalt b�rgt f�r die Artikulation zwischen den Zweckbestimmtheiten des 
									Bildungsstudienganges und denjenigen des Praktikums, den Prinzipien der vorliegenden Charta entsprechend. 
									Die jeweiligen Institutionen erkennen die Notwendigkeit ihres Engagements an, 
									vor allem in Bezug auf die in die Betreuung investierte Zeit. 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" 
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">5 - Bewertung
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" 
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify" font-style="italic"
									font-weight="bold">a - Bewertung des Praktikanten 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die T�tigkeit des Praktikanten ist Gegenstand einer Bewertung, 
									die sich aus der doppelten Einsch�tzung der Verantwortlichen f�r 
									die Betreuung des Praktikums ergibt. Jede Lehranstalt entscheidet �ber den Wert, 
									den sie den im p�dagogischen Studiengang vorgesehenen Praktika zugesteht.
									Die konkreten Bewertungsmodalit�ten sind im �bereinkommen festgelegt.  
								</fo:block>
							</fo:table-cell>
							<fo:table-cell >
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die Bewertung wird in ein "Bewertungsformular" eingetragen, das, zusammen mit dem �bereinkommen, 
									die "Praktikumsakte" bildet.Diese Praktikumsakte wird von der Lehranstalt aufbewahrt. 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify" font-style="italic"
									font-weight="bold">b - Bewertung des Praktikums
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die Unterzeichner des �bereinkommens werden aufgefordert, 
									eine Einsch�tzung der Qualit�t des Praktikums zu formulieren.
								</fo:block>
								
								<fo:block line-height="110%" padding-top="2pt" padding-bottom="2pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">IV - ENGAGEMENT DER PARTEIEN
								</fo:block>
								<fo:block line-height="110%"  padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">1 - Des Studierenden gegen�ber dem Unternehmen
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Der Studierende verpflichtet sich :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- seine Mission durchzuf�hren und f�r die Aufgaben verf�gbar zu sein, die ihm anvertraut werden;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- die Regeln, sowie den Kodex und die Kultur des Unternehmens zu respektieren;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- die vom Unternehmen festgelegten Anforderungen an Vertraulichkeit zu erf�llen;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- falls verlangt, den Bericht oder die Abhandlung in den vorgesehenen Fristen 
									zu schreiben; dieses Dokument muss den Verantwortlichen des Unternehmens vorgelegt werden, 
									bevor es vorgetragen wird (wenn der Inhalt es erfordert, kann der Bericht, 
									auf Antrag des Unternehmens, vertraulich bleiben).
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">2 - Des Unternehmens gegen�ber dem Studierenden
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Das Unternehmen verpflichtet sich  : 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- ein Praktikum anzubieten, das sich ins p�dagogische von 
									der Lehranstalt bestimmte Projekt eingliedert;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- den Studierenden aufzunehmen und ihm die Mittel zu geben, seine Aufgabe durchzuf�hren;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- einen Verantwortlichen oder eine Tutorengruppe f�r das Praktikum zu benennen, 
									deren Aufgabe es sein wird :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* den Studierenden anzuleiten und zu beraten 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* ihn �ber die Regeln, den Kodex und die Unternehmenskultur zu informieren
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* seine Integration ins Unternehmen und seinen Zugang zu 
									den notwendigen Informationen zu erleichtern
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* ihm bei der Erlangung der notwendigen Kompetenzen zu helfen
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									* eine regelm��ige Betreuung seiner Arbeiten zu gew�hrleisten 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									*  die Qualit�t der geleisteten Arbeit zu bewerten 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									*  lihn bei seinem beruflichen Projekt zu beraten
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- eine Praktikumsbescheinigung zu erstellen, die die durchgef�hrten 
									Aufgaben beschreibt, und die in der Folge dem Lebenslauf 
									des Studierenden beigef�gt werden kann
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">3 - Der h�heren Lehranstalt gegen�ber dem Studierenden 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Die Lehranstalt verpflichtet sich :
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- die Ziele des Praktikums zu bestimmen und sich zu �berzeugen, 
									dass das vorgeschlagene Praktikum ihnen entspricht;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- den Studierenden bei seiner Suche nach einem Praktikum zu begleiten ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- den Studierenden auf das Praktikum vorzubereiten ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- die Betreuung des Studierenden w�hrend der Dauer seines Praktikums 
									zu gew�hrleisten, indem sie einen Lehrer bestimmt, der die gute Abwicklung 
									des Praktikums �berwachen wird; Letzterem die Mittel zur Verf�gung zu stellen,
									die f�r die Bewertung der Qualit�t des studentischen Praktikums notwendig sind ;
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									- f�r die h�heren Ausbildungsg�nge, die dies verlangen, ihn bei 
									der Erstellung seines Praktikumsberichtes oder der Abhandlung anzuleiten 
									und zu beraten und deren m�ndliche Vorstellung so zu organisieren, 
									dass einem Vertreter des Unternehmens die Teilnahme daran erlaubt wird.
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">4 - Des Unternehmens und der Lehranstalt
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Das Unternehmen und die h�here Lehranstalt achten darauf, die notwendigen Informationen vor, 
									w�hrend und nach dem Praktikum auszutauschen. Weiterhin respektieren sie 
									die jeweiligen Regeln in Bezug auf Vertraulichkeit und Deontologie. 
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify"
									font-weight="bold">5 - Des Studierenden gegen�ber der Lehranstalt
								</fo:block>
								<fo:block line-height="110%" padding-top="1pt" padding-bottom="1pt"
									hyphenate="false" language="fr" country="FR" font-size="10pt"
									font-family="Times New Roman,serif" text-align="justify">
									Der Studierende verpflichtet sich seiner Lehranstalt 
									die Qualit�tsbewertung seines Praktikums zukommen zu lassen. 
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
	
			</fo:block>
		</fo:block>
		<fo:block id="theEnd" />
	</xsl:template>
	
</xsl:stylesheet>