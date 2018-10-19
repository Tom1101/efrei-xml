<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>My Breakfast Menu</h2>
                <div style="max-width: 700px">
                    <div style=" margin-bottom: -20px; background-color: cadetblue">
                        <h3>
                            <xsl:value-of select="//food/name"/> -
                            <span style="font-weight: normal;">
                                <xsl:value-of select="//food/price"/>
                            </span>
                        </h3>
                    </div>
                    <div style="background-color: aquamarine">
                        <p>
                            <xsl:value-of select="//food/description"/>
                            <xsl:value-of select="//food/calories"/> (calories par serving)
                        </p>
                    </div>
                    <div style=" margin-bottom: -20px; background-color: cadetblue">
                        <h3>
                            <xsl:value-of select="//food[position()=2]/name"/> -
                            <span style="font-weight: normal;">
                                <xsl:value-of select="//food[position()=2]/price"/>
                            </span>
                        </h3>
                    </div>
                    <div style="background-color: aquamarine">
                        <p>
                            <xsl:value-of select="//food[position()=2]/description"/>
                            <xsl:value-of select="//food[position()=2]/calories"/> (calories par serving)
                        </p>
                    </div>
                    <div style=" margin-bottom: -20px; background-color: cadetblue">
                        <h3>
                            <xsl:value-of select="//food[position()=3]/name"/> -
                            <span style="font-weight: normal;">
                                <xsl:value-of select="//food[position()=3]/price"/>
                            </span>
                        </h3>
                    </div>
                    <div style="background-color: aquamarine">
                        <p>
                            <xsl:value-of select="//food[position()=3]/description"/>
                            <xsl:value-of select="//food[position()=3]/calories"/> (calories par serving)
                        </p>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>