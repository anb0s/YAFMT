package cz.jpikl.yafmt.views.featuremodel.view;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureModelLabelProvider implements ILabelProvider,
												  IEntityConnectionStyleProvider {

	// =============================================================
	//  ILabelProvider
	// =============================================================

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
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
		return null;
	}

	// =============================================================
	//  IEntityConnectionStyleProvider
	// =============================================================

	@Override
	public int getConnectionStyle(Object src, Object dest) {
		if(((Feature) dest).getParent() == src)
			return ZestStyles.CONNECTIONS_DIRECTED;
		return ZestStyles.NONE;
	}

	@Override
	public Color getColor(Object src, Object dest) {
		return ColorConstants.black;
	}

	@Override
	public Color getHighlightColor(Object src, Object dest) {
		return ColorConstants.black;
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
