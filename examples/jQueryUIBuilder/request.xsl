<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fc="http://zcu.cz/yafmt/model/fc"
                exclude-result-prefixes="#all"
                version="2.0">

  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:strip-space elements="*"/>
  <xsl:template match="text()"/>

  <xsl:template match="/fc:FeatureConfiguration/rootSelection[@id='jquery_ui']">
    <xsl:apply-templates/>
    <xsl:if test="not(exists(//selection[starts-with(@id, 'theme_')]))">
        <xsl:text>&amp;theme=none</xsl:text>
        <xsl:text>&amp;theme-folder-name=no-theme</xsl:text>
        <xsl:text>&amp;scope=</xsl:text>
    </xsl:if>
  </xsl:template>

  <xsl:template match="selection[@id='version_stable']">
    <xsl:text>version=1.10.3</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='version_legacy']">
    <xsl:text>version=1.9.2</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='core']">
    <xsl:text>&amp;core=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='widget']">
    <xsl:text>&amp;widget=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='mouse']">
    <xsl:text>&amp;mouse=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='position']">
    <xsl:text>&amp;position=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='draggable']">
    <xsl:text>&amp;draggable=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='droppable']">
    <xsl:text>&amp;droppable=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='resizable']">
    <xsl:text>&amp;resizable=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='selectable']">
    <xsl:text>&amp;selectable=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='sortable']">
    <xsl:text>&amp;sortable=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='accordion']">
    <xsl:text>&amp;accordion=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='autocomplete']">
    <xsl:text>&amp;autocomplete=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='button']">
    <xsl:text>&amp;button=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='datepicker']">
    <xsl:text>&amp;datepicker=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='dialog']">
    <xsl:text>&amp;dialog=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='menu']">
    <xsl:text>&amp;menu=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='progressbar']">
    <xsl:text>&amp;progressbar=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='slider']">
    <xsl:text>&amp;slider=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='spinner']">
    <xsl:text>&amp;spinner=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='tabs']">
    <xsl:text>&amp;tabs=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='tooltip']">
    <xsl:text>&amp;tooltip=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='effects']">
    <xsl:text>&amp;effect=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='blind_effect']">
    <xsl:text>&amp;effect-blind=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='bounce_effect']">
    <xsl:text>&amp;effect-bounce=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='clip_effect']">
    <xsl:text>&amp;effect-clip=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='drop_effect']">
    <xsl:text>&amp;effect-drop=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='explode_effect']">
    <xsl:text>&amp;effect-explode=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='fade_effect']">
    <xsl:text>&amp;effect-fade=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='fold_effect']">
    <xsl:text>&amp;effect-fold=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='highlight_effect']">
    <xsl:text>&amp;effect-highlight=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='pulsate_effect']">
    <xsl:text>&amp;effect-pulsate=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='scale_effect']">
    <xsl:text>&amp;effect-scale=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='shake_effect']">
    <xsl:text>&amp;effect-shake=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='slide_effect']">
    <xsl:text>&amp;effect-slide=on</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='transfer_effect']">
    <xsl:text>&amp;effect-transfer=on</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_ui_lightness']">
    <xsl:text>&amp;theme=ffDefault%3DTrebuchet%2520MS%252CTahoma%252CVerdana%252CArial%252Csans-serif%26fwDefault%3Dbold%26fsDefault%3D1.1em%26cornerRadius%3D4px%26bgColorHeader%3Df6a828%26bgTextureHeader%3Dgloss_wave%26bgImgOpacityHeader%3D35%26borderColorHeader%3De78f08%26fcHeader%3Dffffff%26iconColorHeader%3Dffffff%26bgColorContent%3Deeeeee%26bgTextureContent%3Dhighlight_soft%26bgImgOpacityContent%3D100%26borderColorContent%3Ddddddd%26fcContent%3D333333%26iconColorContent%3D222222%26bgColorDefault%3Df6f6f6%26bgTextureDefault%3Dglass%26bgImgOpacityDefault%3D100%26borderColorDefault%3Dcccccc%26fcDefault%3D1c94c4%26iconColorDefault%3Def8c08%26bgColorHover%3Dfdf5ce%26bgTextureHover%3Dglass%26bgImgOpacityHover%3D100%26borderColorHover%3Dfbcb09%26fcHover%3Dc77405%26iconColorHover%3Def8c08%26bgColorActive%3Dffffff%26bgTextureActive%3Dglass%26bgImgOpacityActive%3D65%26borderColorActive%3Dfbd850%26fcActive%3Deb8f00%26iconColorActive%3Def8c08%26bgColorHighlight%3Dffe45c%26bgTextureHighlight%3Dhighlight_soft%26bgImgOpacityHighlight%3D75%26borderColorHighlight%3Dfed22f%26fcHighlight%3D363636%26iconColorHighlight%3D228ef1%26bgColorError%3Db81900%26bgTextureError%3Ddiagonals_thick%26bgImgOpacityError%3D18%26borderColorError%3Dcd0a0a%26fcError%3Dffffff%26iconColorError%3Dffd27a%26bgColorOverlay%3D666666%26bgTextureOverlay%3Ddiagonals_thick%26bgImgOpacityOverlay%3D20%26opacityOverlay%3D50%26bgColorShadow%3D000000%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D10%26opacityShadow%3D20%26thicknessShadow%3D5px%26offsetTopShadow%3D-5px%26offsetLeftShadow%3D-5px%26cornerRadiusShadow%3D5px</xsl:text>
    <xsl:text>&amp;theme-folder-name=ui-lightness</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_ui_darkness']">
    <xsl:text>&amp;theme=ffDefault%3DSegoe%2520UI%252CArial%252Csans-serif%26fwDefault%3Dbold%26fsDefault%3D1.1em%26cornerRadius%3D6px%26bgColorHeader%3D333333%26bgTextureHeader%3Dgloss_wave%26bgImgOpacityHeader%3D25%26borderColorHeader%3D333333%26fcHeader%3Dffffff%26iconColorHeader%3Dffffff%26bgColorContent%3D000000%26bgTextureContent%3Dinset_soft%26bgImgOpacityContent%3D25%26borderColorContent%3D666666%26fcContent%3Dffffff%26iconColorContent%3Dcccccc%26bgColorDefault%3D555555%26bgTextureDefault%3Dglass%26bgImgOpacityDefault%3D20%26borderColorDefault%3D666666%26fcDefault%3Deeeeee%26iconColorDefault%3Dcccccc%26bgColorHover%3D0078a3%26bgTextureHover%3Dglass%26bgImgOpacityHover%3D40%26borderColorHover%3D59b4d4%26fcHover%3Dffffff%26iconColorHover%3Dffffff%26bgColorActive%3Df58400%26bgTextureActive%3Dinset_soft%26bgImgOpacityActive%3D30%26borderColorActive%3Dffaf0f%26fcActive%3Dffffff%26iconColorActive%3D222222%26bgColorHighlight%3Deeeeee%26bgTextureHighlight%3Dhighlight_soft%26bgImgOpacityHighlight%3D80%26borderColorHighlight%3Dcccccc%26fcHighlight%3D2e7db2%26iconColorHighlight%3D4b8e0b%26bgColorError%3Dffc73d%26bgTextureError%3Dglass%26bgImgOpacityError%3D40%26borderColorError%3Dffb73d%26fcError%3D111111%26iconColorError%3Da83300%26bgColorOverlay%3D5c5c5c%26bgTextureOverlay%3Dflat%26bgImgOpacityOverlay%3D50%26opacityOverlay%3D80%26bgColorShadow%3Dcccccc%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D30%26opacityShadow%3D60%26thicknessShadow%3D7px%26offsetTopShadow%3D-7px%26offsetLeftShadow%3D-7px%26cornerRadiusShadow%3D8px</xsl:text>
    <xsl:text>&amp;theme-folder-name=ui-darkness</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_smoothness']">
    <xsl:text>&amp;theme=ffDefault%3DVerdana%252CArial%252Csans-serif%26fwDefault%3Dnormal%26fsDefault%3D1.1em%26cornerRadius%3D4px%26bgColorHeader%3Dcccccc%26bgTextureHeader%3Dhighlight_soft%26bgImgOpacityHeader%3D75%26borderColorHeader%3Daaaaaa%26fcHeader%3D222222%26iconColorHeader%3D222222%26bgColorContent%3Dffffff%26bgTextureContent%3Dflat%26bgImgOpacityContent%3D75%26borderColorContent%3Daaaaaa%26fcContent%3D222222%26iconColorContent%3D222222%26bgColorDefault%3De6e6e6%26bgTextureDefault%3Dglass%26bgImgOpacityDefault%3D75%26borderColorDefault%3Dd3d3d3%26fcDefault%3D555555%26iconColorDefault%3D888888%26bgColorHover%3Ddadada%26bgTextureHover%3Dglass%26bgImgOpacityHover%3D75%26borderColorHover%3D999999%26fcHover%3D212121%26iconColorHover%3D454545%26bgColorActive%3Dffffff%26bgTextureActive%3Dglass%26bgImgOpacityActive%3D65%26borderColorActive%3Daaaaaa%26fcActive%3D212121%26iconColorActive%3D454545%26bgColorHighlight%3Dfbf9ee%26bgTextureHighlight%3Dglass%26bgImgOpacityHighlight%3D55%26borderColorHighlight%3Dfcefa1%26fcHighlight%3D363636%26iconColorHighlight%3D2e83ff%26bgColorError%3Dfef1ec%26bgTextureError%3Dglass%26bgImgOpacityError%3D95%26borderColorError%3Dcd0a0a%26fcError%3Dcd0a0a%26iconColorError%3Dcd0a0a%26bgColorOverlay%3Daaaaaa%26bgTextureOverlay%3Dflat%26bgImgOpacityOverlay%3D0%26opacityOverlay%3D30%26bgColorShadow%3Daaaaaa%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D0%26opacityShadow%3D30%26thicknessShadow%3D8px%26offsetTopShadow%3D-8px%26offsetLeftShadow%3D-8px%26cornerRadiusShadow%3D8px</xsl:text>
    <xsl:text>&amp;theme-folder-name=smoothness</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_start']">
    <xsl:text>&amp;theme=ffDefault%3DVerdana%252CArial%252Csans-serif%26fwDefault%3Dnormal%26fsDefault%3D1.1em%26cornerRadius%3D5px%26bgColorHeader%3D2191c0%26bgTextureHeader%3Dgloss_wave%26bgImgOpacityHeader%3D75%26borderColorHeader%3D4297d7%26fcHeader%3Deaf5f7%26iconColorHeader%3Dd8e7f3%26bgColorContent%3Dfcfdfd%26bgTextureContent%3Dinset_hard%26bgImgOpacityContent%3D100%26borderColorContent%3Da6c9e2%26fcContent%3D222222%26iconColorContent%3D0078ae%26bgColorDefault%3D0078ae%26bgTextureDefault%3Dglass%26bgImgOpacityDefault%3D45%26borderColorDefault%3D77d5f7%26fcDefault%3Dffffff%26iconColorDefault%3De0fdff%26bgColorHover%3D79c9ec%26bgTextureHover%3Dglass%26bgImgOpacityHover%3D75%26borderColorHover%3D448dae%26fcHover%3D026890%26iconColorHover%3D056b93%26bgColorActive%3D6eac2c%26bgTextureActive%3Dgloss_wave%26bgImgOpacityActive%3D50%26borderColorActive%3Dacdd4a%26fcActive%3Dffffff%26iconColorActive%3Df5e175%26bgColorHighlight%3Df8da4e%26bgTextureHighlight%3Dglass%26bgImgOpacityHighlight%3D55%26borderColorHighlight%3Dfcd113%26fcHighlight%3D915608%26iconColorHighlight%3Df7a50d%26bgColorError%3De14f1c%26bgTextureError%3Dgloss_wave%26bgImgOpacityError%3D45%26borderColorError%3Dcd0a0a%26fcError%3Dffffff%26iconColorError%3Dfcd113%26bgColorOverlay%3Daaaaaa%26bgTextureOverlay%3Dflat%26bgImgOpacityOverlay%3D75%26opacityOverlay%3D30%26bgColorShadow%3D999999%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D55%26opacityShadow%3D45%26thicknessShadow%3D0px%26offsetTopShadow%3D5px%26offsetLeftShadow%3D5px%26cornerRadiusShadow%3D5px</xsl:text>
    <xsl:text>&amp;theme-folder-name=start</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_redmont']">
    <xsl:text>&amp;theme=ffDefault%3DLucida%2520Grande%252CLucida%2520Sans%252CArial%252Csans-serif%26fwDefault%3Dbold%26fsDefault%3D1.1em%26cornerRadius%3D5px%26bgColorHeader%3D5c9ccc%26bgTextureHeader%3Dgloss_wave%26bgImgOpacityHeader%3D55%26borderColorHeader%3D4297d7%26fcHeader%3Dffffff%26iconColorHeader%3Dd8e7f3%26bgColorContent%3Dfcfdfd%26bgTextureContent%3Dinset_hard%26bgImgOpacityContent%3D100%26borderColorContent%3Da6c9e2%26fcContent%3D222222%26iconColorContent%3D469bdd%26bgColorDefault%3Ddfeffc%26bgTextureDefault%3Dglass%26bgImgOpacityDefault%3D85%26borderColorDefault%3Dc5dbec%26fcDefault%3D2e6e9e%26iconColorDefault%3D6da8d5%26bgColorHover%3Dd0e5f5%26bgTextureHover%3Dglass%26bgImgOpacityHover%3D75%26borderColorHover%3D79b7e7%26fcHover%3D1d5987%26iconColorHover%3D217bc0%26bgColorActive%3Df5f8f9%26bgTextureActive%3Dinset_hard%26bgImgOpacityActive%3D100%26borderColorActive%3D79b7e7%26fcActive%3De17009%26iconColorActive%3Df9bd01%26bgColorHighlight%3Dfbec88%26bgTextureHighlight%3Dflat%26bgImgOpacityHighlight%3D55%26borderColorHighlight%3Dfad42e%26fcHighlight%3D363636%26iconColorHighlight%3D2e83ff%26bgColorError%3Dfef1ec%26bgTextureError%3Dglass%26bgImgOpacityError%3D95%26borderColorError%3Dcd0a0a%26fcError%3Dcd0a0a%26iconColorError%3Dcd0a0a%26bgColorOverlay%3Daaaaaa%26bgTextureOverlay%3Dflat%26bgImgOpacityOverlay%3D0%26opacityOverlay%3D30%26bgColorShadow%3Daaaaaa%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D0%26opacityShadow%3D30%26thicknessShadow%3D8px%26offsetTopShadow%3D-8px%26offsetLeftShadow%3D-8px%26cornerRadiusShadow%3D8px</xsl:text>
    <xsl:text>&amp;theme-folder-name=redmond</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_sunny']">
    <xsl:text>&amp;theme=ffDefault%3DSegoe%2520UI%252CArial%252Csans-serif%26fwDefault%3Dbold%26fsDefault%3D1.1em%26cornerRadius%3D8px%26bgColorHeader%3D817865%26bgTextureHeader%3Dgloss_wave%26bgImgOpacityHeader%3D45%26borderColorHeader%3D494437%26fcHeader%3Dffffff%26iconColorHeader%3Dfadc7a%26bgColorContent%3Dfeeebd%26bgTextureContent%3Dhighlight_soft%26bgImgOpacityContent%3D100%26borderColorContent%3D8e846b%26fcContent%3D383838%26iconColorContent%3Dd19405%26bgColorDefault%3Dfece2f%26bgTextureDefault%3Dgloss_wave%26bgImgOpacityDefault%3D60%26borderColorDefault%3Dd19405%26fcDefault%3D4c3000%26iconColorDefault%3D3d3d3d%26bgColorHover%3Dffdd57%26bgTextureHover%3Dgloss_wave%26bgImgOpacityHover%3D70%26borderColorHover%3Da45b13%26fcHover%3D381f00%26iconColorHover%3Dbd7b00%26bgColorActive%3Dffffff%26bgTextureActive%3Dinset_soft%26bgImgOpacityActive%3D30%26borderColorActive%3D655e4e%26fcActive%3D0074c7%26iconColorActive%3Deb990f%26bgColorHighlight%3Dfff9e5%26bgTextureHighlight%3Dgloss_wave%26bgImgOpacityHighlight%3D90%26borderColorHighlight%3Deeb420%26fcHighlight%3D1f1f1f%26iconColorHighlight%3Ded9f26%26bgColorError%3Dd34d17%26bgTextureError%3Ddiagonals_medium%26bgImgOpacityError%3D20%26borderColorError%3Dffb73d%26fcError%3Dffffff%26iconColorError%3Dffe180%26bgColorOverlay%3D5c5c5c%26bgTextureOverlay%3Dflat%26bgImgOpacityOverlay%3D50%26opacityOverlay%3D80%26bgColorShadow%3Dcccccc%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D30%26opacityShadow%3D60%26thicknessShadow%3D7px%26offsetTopShadow%3D-7px%26offsetLeftShadow%3D-7px%26cornerRadiusShadow%3D8px</xsl:text>
    <xsl:text>&amp;theme-folder-name=sunny</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

  <xsl:template match="selection[@id='theme_overcast']">
    <xsl:text>&amp;theme=ffDefault%3DTrebuchet%2520MS%252CHelvetica%252CArial%252Csans-serif%26fwDefault%3Dbold%26fsDefault%3D1.1em%26cornerRadius%3D6px%26bgColorHeader%3Ddddddd%26bgTextureHeader%3Dglass%26bgImgOpacityHeader%3D35%26borderColorHeader%3Dbbbbbb%26fcHeader%3D444444%26iconColorHeader%3D999999%26bgColorContent%3Dc9c9c9%26bgTextureContent%3Dinset_soft%26bgImgOpacityContent%3D50%26borderColorContent%3Daaaaaa%26fcContent%3D333333%26iconColorContent%3D999999%26bgColorDefault%3Deeeeee%26bgTextureDefault%3Dglass%26bgImgOpacityDefault%3D60%26borderColorDefault%3Dcccccc%26fcDefault%3D3383bb%26iconColorDefault%3D70b2e1%26bgColorHover%3Df8f8f8%26bgTextureHover%3Dglass%26bgImgOpacityHover%3D100%26borderColorHover%3Dbbbbbb%26fcHover%3D599fcf%26iconColorHover%3D3383bb%26bgColorActive%3D999999%26bgTextureActive%3Dinset_hard%26bgImgOpacityActive%3D75%26borderColorActive%3D999999%26fcActive%3Dffffff%26iconColorActive%3D454545%26bgColorHighlight%3Deeeeee%26bgTextureHighlight%3Dflat%26bgImgOpacityHighlight%3D55%26borderColorHighlight%3Dffffff%26fcHighlight%3D444444%26iconColorHighlight%3D3383bb%26bgColorError%3Dc0402a%26bgTextureError%3Dflat%26bgImgOpacityError%3D55%26borderColorError%3Dc0402a%26fcError%3Dffffff%26iconColorError%3Dfbc856%26bgColorOverlay%3Deeeeee%26bgTextureOverlay%3Dflat%26bgImgOpacityOverlay%3D0%26opacityOverlay%3D80%26bgColorShadow%3Daaaaaa%26bgTextureShadow%3Dflat%26bgImgOpacityShadow%3D0%26opacityShadow%3D60%26thicknessShadow%3D4px%26offsetTopShadow%3D-4px%26offsetLeftShadow%3D-4px%26cornerRadiusShadow%3D0px</xsl:text>
    <xsl:text>&amp;theme-folder-name=overcast</xsl:text>
    <xsl:text>&amp;scope=</xsl:text>
  </xsl:template>

</xsl:stylesheet>
