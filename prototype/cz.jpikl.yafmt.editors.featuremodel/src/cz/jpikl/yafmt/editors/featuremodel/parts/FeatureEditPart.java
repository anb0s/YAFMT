package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.editors.featuremodel.utils.ModelListener;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureEditPart extends AbstractGraphicalEditPart implements ModelListener {

	//public static final String LOCATION_ANNOTATION = "https://bitbucket.org/jpikl/yafmt/location";
	
	public FeatureEditPart(Feature feature) {
		System.out.println("FeatureEditPart: constructor");
		setModel(feature);
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
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(30, 30, 100, 25));
		super.refreshVisuals();
	}
	
	/*
	@Override
	protected void refreshVisuals() {
		EAnnotation location = ((EModelElement) getModel()).getEAnnotation(LOCATION_ANNOTATION);
		String xStr = location.getDetails().get("x");
		String yStr = location.getDetails().get("y");
		int x = (xStr != null) ? Integer.parseInt(xStr) : 0;
		int y = (yStr != null) ? Integer.parseInt(yStr) : 0;
		Rectangle bounds = new Rectangle(x, y, 20, 8);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, figure, bounds);
	}
	*/

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
