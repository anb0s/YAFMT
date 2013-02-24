package cz.jpikl.yafmt.ui.editors.fc.model;

import cz.jpikl.yafmt.model.fc.Selection;

public class Connection {

    private Selection source;
    private Selection target;
    
    public Connection(Selection source, Selection target) {
        this.source = source;
        this.target = target;
    }
    
    public Selection getSource() {
        return source;
    }
    
    public Selection getTarget() {
        return target;
    }
    
}
