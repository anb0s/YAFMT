package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;
import cz.jpikl.yafmt.editors.featuremodel.utils.ModelListener;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureEditPart extends AbstractGraphicalEditPart implements ModelListener {

	private ModelLayoutStore layoutStore;
	
	public FeatureEditPart(Feature feature, ModelLayoutStore layoutStore) {
		System.out.println("FeatureEditPart: constructor");
		setModel(feature);
		this.layoutStore = layoutStore;
	}
	
	public Feature getModel() {
		return (Feature) super.getModel();
	}
	
	@Override
	protected IFigure createFigure() {
		System.out.println("FeatureEditPart: creating figure");
		Label figure = new Label(getModel().getName()); 
		figure.setBorder(new LineBorder());
		return figure;
	}
	
	@Override
	protected void refreshVisuals() {
		System.out.println("FeatureEditPart: refreshing visuals");
		GraphicalEditPart editPart = (GraphicalEditPart) getParent();
		
		ObjectBounds bounds = (ObjectBounds) layoutStore.getObjectLayout(getModel());
		if(bounds != null) {
			editPart.setLayoutConstraint(this, getFigure(), bounds.getBounds());
		}
		else {
			editPart.setLayoutConstraint(this, getFigure(), new Rectangle(0, 0, 100, 25));
			bounds = ModelLayoutFactory.eINSTANCE.createObjectBounds();
			bounds.setBounds(new Rectangle(0, 0, 100, 25));
			layoutStore.setObjectLayout(getModel(), bounds);
		}
		
		super.refreshVisuals();
	}
	
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modelChanged(Notification notification) {
		System.out.println("FeatureEditPart: model changed");
		// TODO Auto-generated method stub
	}

}
