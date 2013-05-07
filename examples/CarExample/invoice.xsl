<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fc="http://zcu.cz/yafmt/model/fc"
                exclude-result-prefixes="#all"
                version="2.0">

  <xsl:output method="html"
              encoding="UTF-8"
              indent="yes"/>

  <xsl:strip-space elements="*"/>
  <xsl:template match="text()"/>

  <xsl:template match="/fc:FeatureConfiguration/rootSelection">
    <xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;
    </xsl:text>

    <html>
      <head>
        <title>Car Invoice</title>
        <style>
            table  { border-collapse:collapse; text-align: right; }
            thead  { border-bottom: 1px solid black; }
            tfoot  { border-top: 1px solid black; font-weight: bold; }
            td, th { padding: 4px 8px 4px 8px; }
            td:first-child, th:first-child { text-align: left; }
        </style>
      </head>
      <body>
        <h1>Car Invoice</h1>

        <p>
          <strong>Vehicle:</strong>
          <xsl:text> </xsl:text>
          <xsl:value-of select="attributeValue[@id='name']/@value"/>
        </p>

        <xsl:variable name="bill">
          <item>
            <description>Car Body</description>
            <price>5000</price>
            <quantity>1</quantity>
          </item>
          <xsl:apply-templates/>
        </xsl:variable>

        <xsl:variable name="prices">
          <xsl:for-each select="$bill/item">
            <item>
              <xsl:value-of select="price * quantity"/>
            </item>
          </xsl:for-each>
        </xsl:variable>

        <table>
          <thead>
            <tr>
              <th>Part</th>
              <th>Price / Part</th>
              <th>Quantity</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            <xsl:for-each select="$bill/item">
              <tr>
                <td><xsl:value-of select="description"/></td>
                <td><xsl:value-of select="price"/>$</td>
                <td><xsl:value-of select="quantity"/></td>
                <td><xsl:value-of select="price * quantity"/>$</td>
              </tr>
            </xsl:for-each>
          </tbody>
          <tfoot>
            <tr>
              <td>Total Price</td>
              <td></td>
              <td></td>
              <td><xsl:value-of select="sum($prices/item)"/>$</td>
            </tr>
          </tfoot>
        </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="selection[@id='engine']">
    <xsl:variable name="engine">
      <xsl:choose>
        <xsl:when test="selection[@id='elec_eng'] and selection[@id!='gas_eng']">
          <description>Hybrid Engine</description>
          <price>3000</price>
        </xsl:when>
        <xsl:when test="selection[@id='elec_eng']">
          <description>Electric Engine</description>
          <price>2000</price>
        </xsl:when>
        <xsl:when test="selection[@id='dies_eng']">
          <description>Diesel Engine</description>
          <price>1500</price>
        </xsl:when>
        <xsl:when test="selection[@id='gas_eng']">
          <description>Gasoline Engine</description>
          <price>1000</price>
        </xsl:when>
      </xsl:choose>
      <hp>
          <xsl:value-of select="attributeValue[@id='hp']/@value"/>
      </hp>
    </xsl:variable>
    <item>
      <description>
          <xsl:value-of select="$engine/description"/>
          <xsl:text> (</xsl:text>
          <xsl:value-of select="$engine/hp"/>
          <xsl:text> HP)</xsl:text>
      </description>
      <price><xsl:value-of select="$engine/price * ($engine/hp div 100)"/></price>
      <quantity>1</quantity>
    </item>
  </xsl:template>

  <xsl:template match="selection[@id='man_tr']">
    <item>
      <description>Manual Transmission</description>
      <price>500</price>
      <quantity>1</quantity>
    </item>
  </xsl:template>

  <xsl:template match="selection[@id='auto_tr']">
    <item>
      <description>Automatic Transmission</description>
      <price>1000</price>
      <quantity>1</quantity>
    </item>
  </xsl:template>

  <xsl:template match="selection[@id='sunroof']">
    <item>
      <description>Sunroof</description>
      <price>200</price>
      <quantity>1</quantity>
    </item>
  </xsl:template>

  <xsl:template match="selection[@id='door'][1]">
    <item>
      <description>Door</description>
      <price>300</price>
      <quantity><xsl:value-of select="count(//selection[@id='door'])"/></quantity>
    </item>
  </xsl:template>

  <xsl:template match="selection[@id='pw_lock']">
    <item>
      <description>Power Locks</description>
      <price>400</price>
      <quantity>1</quantity>
    </item>
  </xsl:template>

  <xsl:template match="selection[@id='kl_entry']">
    <item>
      <description>Keyless Entry</description>
      <price>500</price>
      <quantity>1</quantity>
    </item>
  </xsl:template>

</xsl:stylesheet>
