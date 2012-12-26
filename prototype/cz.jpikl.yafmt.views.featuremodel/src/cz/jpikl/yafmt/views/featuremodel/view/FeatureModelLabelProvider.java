package cz.jpikl.yafmt.views.featuremodel.view;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureModelLabelProvider implements ILabelProvider,
												  IEntityConnectionStyleProvider,
												  IEntityStyleProvider {

	private Color lightRed;
	
	public FeatureModelLabelProvider() {
		lightRed = new Color(Display.getCurrent(), 255, 192, 192);
	}
	
	// =============================================================
	//  ILabelProvider
	// =============================================================

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
		lightRed.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if(element instanceof Feature)
			return ((Feature) element).getName();
		if(element instanceof Constraint)
			return ((Constraint) element).getValue();
		return null;
	}

	// =============================================================
	//  IEntityStyleProvider
	// =============================================================
	
	@Override
	public Color getForegroundColour(Object entity) {
		if(entity instanceof Feature)
			return ColorConstants.darkBlue; 
		return ColorConstants.red;
	}
	
	@Override
	public Color getBackgroundColour(Object entity) {
		return ColorConstants.white;
	}
	
	@Override
	public Color getNodeHighlightColor(Object entity) {
		if(entity instanceof Feature)
			return ColorConstants.lightBlue;
		return lightRed;
	}

	@Override
	public Color getBorderColor(Object entity) {
		if(entity instanceof Feature)
			return ColorConstants.darkBlue;
		return ColorConstants.red;
	}

	@Override
	public Color getBorderHighlightColor(Object entity) {
		if(entity instanceof Feature)
			return ColorConstants.darkBlue;
		return ColorConstants.red;
	}

	@Override
	public int getBorderWidth(Object entity) {
		return 1;
	}

	@Override
	public boolean fisheyeNode(Object entity) {
		return false;
	}
	
	// =============================================================
	//  IEntityConnectionStyleProvider
	// =============================================================

	@Override
	public int getConnectionStyle(Object src, Object dest) {
		if((src instanceof Feature) && (dest instanceof Feature)) {
			if(((Feature) dest).getParent() == src)
				return ZestStyles.CONNECTIONS_DIRECTED;
			return ZestStyles.NONE;
		}
		return ZestStyles.CONNECTIONS_DASH;
	}

	@Override
	public Color getColor(Object src, Object dest) {
		if((src instanceof Feature) && (dest instanceof Feature))
			return ColorConstants.darkBlue;
		return ColorConstants.red;
	}

	@Override
	public Color getHighlightColor(Object src, Object dest) {
		return getColor(src, dest);
	}

	@Override
	public int getLineWidth(Object src, Object dest) {
		return 1;
	}

	@Override
	public IFigure getTooltip(Object entity) {
		return null;
	}

}
