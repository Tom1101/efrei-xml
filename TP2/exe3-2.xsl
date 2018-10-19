<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>My Breakfast Menu</h2>
                <div style="max-width: 700px">
                    <xsl:for-each select="//food">
                    <div style=" margin-bottom: -20px; background-color: cadetblue">
                        <h3>
                            <xsl:value-of select="name"/> -
                            <span style="font-weight: normal;">
                                <xsl:value-of select="price"/>
                            </span>
                        </h3>
                    </div>
                    <div style="background-color: aquamarine">
                        <p>
                            <xsl:value-of select="description"/>
                            <xsl:value-of select="calories"/> (calories par serving)
                        </p>
                    </div>
                    </xsl:for-each>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>