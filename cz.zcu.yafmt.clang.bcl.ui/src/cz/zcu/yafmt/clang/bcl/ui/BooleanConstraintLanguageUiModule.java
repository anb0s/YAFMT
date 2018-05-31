/*
 * generated by Xtext
 */
package cz.zcu.yafmt.clang.bcl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

import cz.zcu.yafmt.clang.bcl.ui.contentassist.BooleanConstraintLanguageProposalPriorities;
import cz.zcu.yafmt.clang.bcl.ui.highlight.BooleanConstraintLanguageHighlighting;

/**
 * Use this class to register components to be used within the IDE.
 */
public class BooleanConstraintLanguageUiModule extends cz.zcu.yafmt.clang.bcl.ui.AbstractBooleanConstraintLanguageUiModule {

    public BooleanConstraintLanguageUiModule(AbstractUIPlugin plugin) {
        super(plugin);
    }

    public Class<? extends IContentProposalPriorities> bindIContentProposalPriorities() {
        return BooleanConstraintLanguageProposalPriorities.class;
    }

    public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
        return BooleanConstraintLanguageHighlighting.class;
    }

}