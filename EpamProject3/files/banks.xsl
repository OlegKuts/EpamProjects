<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:mns="http://bankinfo.com/banks"
                exclude-result-prefixes="mns">

    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <tr>
                        <th>name</th>
                        <th>country</th>
                        <th>type</th>
                        <th>accountId</th>
                        <th>depositor</th>
                        <th>amount</th>
                        <th>profitability</th>
                        <th>constraints</th>
                    </tr>
                    <xsl:for-each select="mns:banks/mns:bank">
                        <tr>
                            <td><xsl:value-of select="mns:name"/></td>
                            <td><xsl:value-of select="mns:country"/></td>
                            <td><xsl:value-of select="mns:deposit/@type"/></td>
                            <td><xsl:value-of select="mns:deposit/@accountId"/></td>
                            <td><xsl:value-of select="mns:deposit/mns:depositor"/></td>
                            <td><xsl:value-of select="mns:deposit/mns:amount"/></td>
                            <td><xsl:value-of select="mns:deposit/mns:profitability"/></td>
                            <td><xsl:value-of select="mns:deposit/mns:constraints"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>