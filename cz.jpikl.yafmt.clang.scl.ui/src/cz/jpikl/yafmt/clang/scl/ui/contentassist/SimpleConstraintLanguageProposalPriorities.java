package cz.jpikl.yafmt.clang.scl.ui.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities;

public class SimpleConstraintLanguageProposalPriorities extends ContentProposalPriorities {

    @Override
    public void adjustKeywordPriority(ICompletionProposal proposal, String prefix) {
        // Keywords go always first.
        adjustPriority(proposal, prefix, 2 * keywordPriority);
    }
    
}
