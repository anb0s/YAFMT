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
    <Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener"/>
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

  <xsl:template match="selection[@id='transaction']">
    <Transaction>
      <xsl:attribute name="factory">
        <xsl:value-of select="attributeValue[@id='factory']/@value"/>
      </xsl:attribute>
    </Transaction>
  </xsl:template>

  <xsl:template match="selection[@id='jasper_jsp']">
    <Listener className="org.apache.catalina.core.JasperListener" />
  </xsl:template>

  <xsl:template match="selection[@id='apr']">
    <Listener className="org.apache.catalina.core.AprLifecycleListener">
      <xsl:apply-templates/>
    </Listener>
  </xsl:template>

  <xsl:template match="selection[@id='apr_ssl']">
    <xsl:attribute name="SSLEngine">on</xsl:attribute>
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="selection[@id='apr_ssl_builtin']">
    <xsl:attribute name="SSLRandomSeed">builtin</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='apr_ssl_urandom']">
    <xsl:attribute name="SSLRandomSeed">/dev/urandom</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='ml_prevention']">
    <Listener className="org.apache.catalina.core.JreMemoryLeakPreventionListener">
      <xsl:attribute name="ldapPoolProtection">
        <xsl:value-of select="string(exists(selection[@id='ml_lda_pool']))"/>
      </xsl:attribute>
      <xsl:attribute name="urlCacheProtection">
        <xsl:value-of select="string(exists(selection[@id='ml_url_cache']))"/>
      </xsl:attribute>
      <xsl:attribute name="appContextProtection">
        <xsl:value-of select="string(exists(selection[@id='ml_app_context']))"/>
      </xsl:attribute>
      <xsl:attribute name="gcDaemonProtection">
        <xsl:value-of select="string(exists(selection[@id='ml_gc_deamon']))"/>
      </xsl:attribute>
      <xsl:attribute name="xmlParsingProtection">
        <xsl:value-of select="string(exists(selection[@id='ml_xml_parsing']))"/>
      </xsl:attribute>
      <xsl:attribute name="driverManagerProtection">
        <xsl:value-of select="string(exists(selection[@id='ml_driver_manager']))"/>
      </xsl:attribute>
    </Listener>
  </xsl:template>

  <xsl:template match="selection[@id='security_lifecycle']">
    <Listener className="org.apache.catalina.security.SecurityListener" />
  </xsl:template>

  <xsl:template match="selection[@id='thread_local_leak_prevention']">
    <Listener className="org.apache.catalina.core.ThreadLocalLeakPreventionListener" />
  </xsl:template>

</xsl:stylesheet>
