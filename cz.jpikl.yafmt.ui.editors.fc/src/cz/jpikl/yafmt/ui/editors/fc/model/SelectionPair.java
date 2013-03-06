package cz.jpikl.yafmt.ui.editors.fc.model;

import cz.jpikl.yafmt.model.fc.Selection;

public class SelectionPair {

    private Selection parentSelection;
    private Selection selection;
    
    public SelectionPair(Selection parentSelection, Selection selection) {
        this.parentSelection = parentSelection;
        this.selection = selection;
    }
    
    public Selection getParentSelection() {
        return parentSelection;
    }
    
    public Selection getSelection() {
        return selection;
    }
    
}
