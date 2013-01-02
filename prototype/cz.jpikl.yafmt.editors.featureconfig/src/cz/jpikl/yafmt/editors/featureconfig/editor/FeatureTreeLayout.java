package cz.jpikl.yafmt.editors.featureconfig.editor;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class FeatureTreeLayout extends AbstractLayout {

    private FeatureConfigurationManager configManager;
    
    public FeatureTreeLayout(FeatureConfigurationManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public void layout(IFigure container) {
        int y = 10;
        for(Object child: container.getChildren()) {
            ((IFigure) child).setBounds(new Rectangle(10, y, 100, 25));
            y += 30;
        }
    }

    @Override
    protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
        return new Dimension(640, 480);
    }

}
