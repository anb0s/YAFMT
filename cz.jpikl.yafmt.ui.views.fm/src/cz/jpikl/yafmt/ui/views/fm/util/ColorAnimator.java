package cz.jpikl.yafmt.ui.views.fm.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.Animator;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.ui.views.fm.figures.DecoratableNodeFigure;
import cz.jpikl.yafmt.ui.views.fm.figures.NodeFigure;

public class ColorAnimator extends LayoutAnimator {

    private static ColorAnimator INSTANCE = new ColorAnimator();
    
    public static ColorAnimator getDefault() {
        return INSTANCE;
    }
    
    @Override
    protected Object getCurrentState(IFigure container) {
        Map<DecoratableNodeFigure, Integer> map = new HashMap<DecoratableNodeFigure, Integer>();
        
        for(Object child: container.getChildren()) {
            if(child instanceof DecoratableNodeFigure) {
                map.put((DecoratableNodeFigure) child, ((NodeFigure) child).getAlpha());  
            }
        }
        
        return map;
    }
    
    @Override
    protected boolean playback(IFigure container) {
        Map<DecoratableNodeFigure, Integer> mi = (Map<DecoratableNodeFigure, Integer>) Animation.getInitialState(this, container);
        Map<DecoratableNodeFigure, Integer> me = (Map<DecoratableNodeFigure, Integer>) Animation.getFinalState(this, container);
        
        for(Object child: container.getChildren()) {
            if(child instanceof DecoratableNodeFigure) {
                int a1 = mi.get(child);
                int a2 = me.get(child);
                int a = Math.min(255, (int) (a1 + (a2 - a1) * Animation.getProgress()));
                ((NodeFigure) child).setAlpha(a);
            }
            if(child instanceof Connection && mi.containsKey(child)) {
                int a = Math.max(0, Math.min(255, (int)(255 * (1.0f - Animation.getProgress()))));
                Color c = new Color(Display.getDefault(), a,a,a);
                ((Connection) child).setForegroundColor(c);
            }
        }
        
        return true;
    }
    
}
