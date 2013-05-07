<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fc="http://zcu.cz/yafmt/model/fc"
                exclude-result-prefixes="#all"
                version="2.0">

  <xsl:output method="xml"
              encoding="UTF-8"
              indent="yes"/>

  <xsl:strip-space elements="*"/>
  <xsl:template match="text()"/>

  <!--=======================================================================
       Server
      =======================================================================-->

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

  <!--=======================================================================
       Listeners
      =======================================================================-->

  <xsl:template match="selection[@id='security_lifecycle']">
    <Listener className="org.apache.catalina.security.SecurityListener" />
  </xsl:template>

  <xsl:template match="selection[@id='thread_local_leak_prevention']">
    <Listener className="org.apache.catalina.core.ThreadLocalLeakPreventionListener" />
  </xsl:template>

  <xsl:template match="selection[@id='jasper_jsp']">
    <Listener className="org.apache.catalina.core.JasperListener" />
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

  <!--=======================================================================
       Global Naming Resources
      =======================================================================-->

  <xsl:template match="selection[@id='global_naming']">
    <Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener"/>
    <GlobalNamingResources>
      <xsl:apply-templates/>
    </GlobalNamingResources>
  </xsl:template>

  <!--=======================================================================
       Environment
      =======================================================================-->

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

  <!--=======================================================================
       Transaction
      =======================================================================-->

  <xsl:template match="selection[@id='transaction']">
    <Transaction>
      <xsl:attribute name="factory">
        <xsl:value-of select="attributeValue[@id='factory']/@value"/>
      </xsl:attribute>
    </Transaction>
  </xsl:template>

  <!--=======================================================================
       Resource
      =======================================================================-->

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

  <xsl:template match="selection[@id='res_scope_unsh']">
    <xsl:attribute name="scope">Unshareable</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_scope_sh']">
    <xsl:attribute name="scope">Shareable</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_single']">
    <xsl:attribute name="singleton">true</xsl:attribute>
    <xsl:if test="attributeValue[@id='close_method']/@value != ''">
      <xsl:attribute name="closeMethod">
        <xsl:value-of select="attributeValue[@id='close_method']/@value"/>
      </xsl:attribute>
    </xsl:if>
  </xsl:template>

  <xsl:template match="selection[@id='res_auth_app']">
    <xsl:attribute name="auth">Application</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='res_auth_cont']">
    <xsl:attribute name="auth">Container</xsl:attribute>
  </xsl:template>

  <!--=======================================================================
       Service
      =======================================================================-->

  <xsl:template match="selection[@id='service']">
    <Service>
      <xsl:attribute name="name">
        <xsl:value-of select="attributeValue[@id='name']/@value"/>
      </xsl:attribute>
      <xsl:text>
      </xsl:text>
      <xsl:comment>Note: SSL support needs additional attributes to be specified.</xsl:comment>
      <xsl:text>
      </xsl:text>
      <xsl:apply-templates select="selection[@id='connector']"/>
      <xsl:apply-templates select="selection[@id='engine']"/>
    </Service>
  </xsl:template>

  <!--=======================================================================
       Connector
      =======================================================================-->

  <xsl:template match="selection[@id='connector']">
    <Connector>
      <xsl:attribute name="port">
        <xsl:value-of select="attributeValue[@id='port']/@value"/>
      </xsl:attribute>
      <xsl:choose>
        <xsl:when test="exists(selection[@id='conn_proto']/selection[@id='conn_http'])">
          <xsl:choose>
            <xsl:when test="exists(selection[@id='conn_impl'])">
              <xsl:apply-templates mode="http"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:attribute name="protocol">HTTP/1.1</xsl:attribute>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:when>
        <xsl:otherwise>
          <xsl:choose>
            <xsl:when test="exists(selection[@id='conn_impl'])">
              <xsl:apply-templates mode="ajp"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:attribute name="protocol">AJP/1.3</xsl:attribute>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates/>
    </Connector>
  </xsl:template>

  <xsl:template match="selection[@id='conn_redirect']">
    <xsl:attribute name="redirectPort">
      <xsl:value-of select="attributeValue[@id='port']/@value"/>
    </xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_timeout']">
    <xsl:attribute name="connectionTimeout">
      <xsl:value-of select="attributeValue[@id='timeout']/@value"/>
    </xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_bio']" mode="http">
    <xsl:attribute name="protocol">org.apache.coyote.http11.Http11Protocol</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_nio']" mode="http">
    <xsl:attribute name="protocol">org.apache.coyote.http11.Http11NioProtocol</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_apr']" mode="http">
    <xsl:attribute name="protocol">org.apache.coyote.http11.Http11AprProtocol</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_bio']" mode="ajp">
    <xsl:attribute name="protocol">org.apache.coyote.ajp.AjpProtocol</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_nio']" mode="ajp">
    <xsl:attribute name="protocol">org.apache.coyote.ajp.AjpNioProtocol</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_apr']" mode="ajp">
    <xsl:attribute name="protocol">org.apache.coyote.ajp.AjpAprProtocol</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_lookups']">
    <xsl:attribute name="enableLookups">true</xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='conn_ssl']">
    <xsl:attribute name="SSLEnabled">true</xsl:attribute>
    <xsl:attribute name="scheme">https</xsl:attribute>
    <xsl:attribute name="secure">true</xsl:attribute>
  </xsl:template>

  <!--=======================================================================
       Engine
      =======================================================================-->

  <xsl:template match="selection[@id='engine']">
    <Engine>
      <xsl:attribute name="name">
        <xsl:value-of select="attributeValue[@id='name']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="defaultHost">
        <xsl:value-of select="attributeValue[@id='default_host']/@value"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Engine>
  </xsl:template>

  <!--=======================================================================
       Host
      =======================================================================-->

  <xsl:template match="selection[@id='host']">
    <Host>
      <xsl:attribute name="name">
        <xsl:value-of select="attributeValue[@id='name']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="appBase">
        <xsl:value-of select="attributeValue[@id='app_base']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="autoDeploy">
        <xsl:value-of select="string(exists(selection[@id='auto_deploy']))"/>
      </xsl:attribute>
      <xsl:attribute name="unpackWARs">
        <xsl:value-of select="string(exists(selection[@id='unpack_wars']))"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Host>
  </xsl:template>

  <xsl:template match="selection[@id='access_logging']">
    <Valve className="org.apache.catalina.valves.AccessLogValve">
      <xsl:attribute name="directory">
        <xsl:value-of select="attributeValue[@id='directory']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="prefix">
        <xsl:value-of select="attributeValue[@id='prefix']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="suffix">
        <xsl:value-of select="attributeValue[@id='suffix']/@value"/>
      </xsl:attribute>
      <xsl:apply-templates/>
    </Valve>
  </xsl:template>

  <xsl:template match="selection[@id='access_logging_pattern']">
      <xsl:attribute name="pattern">
        <xsl:value-of select="attributeValue[@id='pattern']/@value"/>
      </xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='single_sing_on']">
    <Valve className="org.apache.catalina.authenticator.SingleSignOn"/>
  </xsl:template>

  <!--=======================================================================
       Context
      =======================================================================-->

  <xsl:template match="selection[@id='context']">
    <Context>
      <xsl:attribute name="docBase">
        <xsl:value-of select="attributeValue[@id='document_base']/@value"/>
      </xsl:attribute>
      <xsl:attribute name="reloadable">
        <xsl:value-of select="string(exists(selection[@id='reloadable']))"/>
      </xsl:attribute>
      <xsl:attribute name="cookies">
        <xsl:value-of select="string(exists(selection[@id='cookies']))"/>
      </xsl:attribute>
      <xsl:if test="exists(selection[@id='alias'])">
        <xsl:attribute name="aliases">
          <xsl:apply-templates select="selection[@id='alias']"/>
        </xsl:attribute>
      </xsl:if>
    </Context>
  </xsl:template>

  <xsl:template match="selection[@id='alias']">
      <xsl:value-of select="attributeValue[@id='alias']/@value"/>
      <xsl:text>=</xsl:text>
      <xsl:value-of select="attributeValue[@id='path']/@value"/>
      <xsl:if test="not(position()=last())">
        <xsl:text>,</xsl:text>
      </xsl:if>
  </xsl:template>

  <!--=======================================================================
       Realm
      =======================================================================-->

  <xsl:template match="selection[@id='realm']">
    <Realm>
      <xsl:apply-templates/>
    </Realm>
  </xsl:template>

  <xsl:template match="selection[@id='realm_jdbc']">
    <xsl:attribute name="className">org.apache.catalina.realm.JDBCRealm</xsl:attribute>
    <xsl:attribute name="connectionName">
      <xsl:value-of select="attributeValue[@id='connection_name']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="connectionPassword">
      <xsl:value-of select="attributeValue[@id='connection_password']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="connectionURL">
      <xsl:value-of select="attributeValue[@id='connection_url']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="driverName">
      <xsl:value-of select="attributeValue[@id='driver_name']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="userTable">
      <xsl:value-of select="attributeValue[@id='user_table']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="userNameCol">
      <xsl:value-of select="attributeValue[@id='user_names_column']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="userCredCol">
      <xsl:value-of select="attributeValue[@id='user_credentials_column']/@value"/>
    </xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='realm_ds']">
    <xsl:attribute name="className">org.apache.catalina.realm.DataSourceRealm</xsl:attribute>
    <xsl:attribute name="dataSourceName">
      <xsl:value-of select="attributeValue[@id='data_source_name']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="userTable">
      <xsl:value-of select="attributeValue[@id='user_table']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="userNameCol">
      <xsl:value-of select="attributeValue[@id='user_names_column']/@value"/>
    </xsl:attribute>
    <xsl:attribute name="userCredCol">
      <xsl:value-of select="attributeValue[@id='user_credentials_column']/@value"/>
    </xsl:attribute>
  </xsl:template>

  <xsl:template match="selection[@id='realm_jndi']">
    <xsl:attribute name="className">org.apache.catalina.realm.JNDIRealm</xsl:attribute>
    <xsl:attribute name="connectionURL">
      <xsl:value-of select="attributeValue[@id='connection_url']/@value"/>
    </xsl:attribute>
  </xsl:template>

</xsl:stylesheet>
