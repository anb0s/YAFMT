package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;

public class FeatureTreeEditorPaletteRoot extends PaletteRoot {

    public FeatureTreeEditorPaletteRoot() {
        ToolEntry selectionEntry = new PanningSelectionToolEntry();
        ToolEntry marqueeEntry = new MarqueeToolEntry();
        ToolEntry featureCreationEntry = createFeatureCreationEntry();
        ToolEntry connectionCreationEntry = new ConnectionCreationToolEntry(
                "Connection", "Create a connection.", null, null, null);
        
        // TODO use PaletteToolbar or PaletteDrawer instead.
        // TODO add icons.
        PaletteGroup group = new PaletteGroup(null);
        group.add(selectionEntry);
        group.add(marqueeEntry);
        group.add(featureCreationEntry);
        group.add(connectionCreationEntry);
        
        add(group);
        setDefaultEntry(selectionEntry);
    }
    
    private ToolEntry createFeatureCreationEntry() {
        CreationToolEntry featureCreationEntry = new CombinedTemplateCreationEntry(
            "Feature", "Add a new feature.", new FeatureFactory(), null, null);
        return featureCreationEntry;
    }
    
    private static class FeatureFactory extends SimpleFactory {

        public FeatureFactory() {
            super(Feature.class);
        }
        
        @Override
        public Object getNewObject() {
            Feature feature = FeatureModelFactory.eINSTANCE.createFeature();
            feature.setId(EcoreUtil.generateUUID());
            feature.setName("New feature");
            return feature;
        }
        
    }
    
}
