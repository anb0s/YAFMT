package cz.jpikl.yafmt.ui.editors.fm.model;

import org.eclipse.emf.ecore.EObject;

public class Connection {

    private EObject parent;
    private EObject child;

    public Connection(EObject parent, EObject child) {
        this.parent = parent;
        this.child = child;
    }

    public EObject getParent() {
        return parent;
    }

    public EObject getChild() {
        return child;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Connection))
            return false;
        Connection con = (Connection) obj;
        return (parent == con.parent) && (child == con.child);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if(parent != null)
            hash += parent.hashCode();
        if(child != null)
            hash += child.hashCode();
        return hash;
    }
    
}
