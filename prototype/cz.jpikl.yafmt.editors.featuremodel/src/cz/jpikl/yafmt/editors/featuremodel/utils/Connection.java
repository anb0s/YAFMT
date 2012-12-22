package cz.jpikl.yafmt.editors.featuremodel.utils;

import cz.jpikl.yafmt.models.featuremodel.Feature;

public class Connection {

	private Feature parent;
	private Feature child;
	
	public Connection(Feature parent, Feature child) {
		super();
		this.parent = parent;
		this.child = child;
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
