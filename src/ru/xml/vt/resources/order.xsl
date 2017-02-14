<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Проданные товары</h2>
                <table border="1">
                    <tr>
                        <th>Название</th>
                        <th>Количество</th>
                        <th>Общая стоимость</th>
                    </tr>
                    <xsl:for-each select="/order/content/order_line">
                        <tr>
                            <td>
                                <xsl:value-of select="@item"/>
                            </td>
                            <td>
                                <xsl:value-of select="@quantity"/>
                            </td>
                            <xsl:choose>
                                <xsl:when test="unit_price> 30">
                                    <td bgcolor="#FF0000">
                                        <xsl:value-of select="unit_price"/>
                                    </td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td>
                                        <xsl:value-of select="unit_price"/>
                                    </td>
                                    Обзор спецификаций XM L 475
                                </xsl:otherwise>
                            </xsl:choose>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>