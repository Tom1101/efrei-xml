<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <div style="max-width: 700px">
                <h2>Domaines</h2>
                    <xsl:for-each select="//domain">
                        <div>
                            <h3>
                                <a href="#{title}"><xsl:value-of select="title"/></a>
                            </h3>
                        </div>
                    </xsl:for-each>
                    <hr></hr><hr></hr>
                </div>
                <div style="max-width: 700px">
                    <xsl:for-each select="//domain">
                        <div>
                            <a name="{title}"><h3><xsl:value-of select="title"/></h3></a>
                            <hr></hr>
                                    <xsl:for-each select="bib_ref">
                                        <h3><xsl:value-of select="title"/></h3>
                                        <p>Auteur(s): <xsl:value-of select="author"/></p>
                                        <p>Année: <xsl:value-of select="year"/></p>
                                        <p>Lien: <a href="{weblink}"><xsl:value-of select="weblink"/></a></p>
                                        <p>Commentaires: </p>
                                        <hr></hr>
                                    </xsl:for-each>
                            <hr></hr>
                        </div>
                    </xsl:for-each>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>