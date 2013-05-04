<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fc="http://zcu.cz/yafmt/model/fc"
                exclude-result-prefixes="#all"
                version="2.0">

  <xsl:output method="xml"
              encoding="UTF-8"
              indent="yes"/>

  <xsl:strip-space elements="*"/>

  <xsl:template match="/fc:FeatureConfiguration/rootSelection[@id='server']">
    <Server>
      <xsl:attribute name="port">
        <xsl:value-of select="attributeValue[@id='port']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="shutdown">
        <xsl:value-of select="attributeValue[@id='shutdown']/@value"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Server>
  </xsl:template>

  <xsl:template match="selection[@id='service']">
    <Service>
      <xsl:attribute name="name">
        <xsl:value-of select="attributeValue[@id='name']/@value"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Service>
  </xsl:template>

  <xsl:template match="selection[@id='global_naming']">
    <GlobalNamingResources>
      <xsl:apply-templates/>
    </GlobalNamingResources>
  </xsl:template>

  <xsl:template match="selection[@id='environment']">
    <Environment>
      <xsl:attribute name="name">
        <xsl:value-of select="attributeValue[@id='name']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="value">
        <xsl:value-of select="attributeValue[@id='value']/@value"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Environment>
  </xsl:template>

  <xsl:template match="selection[@id='env_override']">
    <xsl:attribute name="override">true</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='env_bool']">
    <xsl:attribute name="type">java.lang.Boolean</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='env_int']">
    <xsl:attribute name="type">java.lang.Integer</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='env_str']">
    <xsl:attribute name="type">java.lang.String</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='resource']">
    <Resource>
      <xsl:attribute name="name">
        <xsl:value-of select="attributeValue[@id='name']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="type">
        <xsl:value-of select="attributeValue[@id='type']/@value"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Resource>
  </xsl:template>

  <xsl:template match="selection[@id='res_auth_app']">
    <xsl:attribute name="type">Application</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_auth_cont']">
    <xsl:attribute name="type">Container</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_scope_unsh']">
    <xsl:attribute name="scope">Unshareable</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_scope_sh']">
    <xsl:attribute name="scope">Shareable</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_single']">
    <xsl:attribute name="singletor">true</xsl:attribute>
    <xsl:if test="attributeValue[@id='closeMethod']/@value != ''">
      <xsl:attribute name="closeMethod">
        <xsl:value-of select="attributeValue[@id='closeMethod']/@value"/>
      </xsl:attribute>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>
