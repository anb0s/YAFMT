package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.jface.resource.ImageDescriptor;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.ui.tools.CreationToolWithDirectEdit;

public class FeatureModelEditorPaletteRoot extends PaletteRoot {

    public FeatureModelEditorPaletteRoot() {
        ToolEntry selectionEntry = new PanningSelectionToolEntry();
        ToolEntry marqueeEntry = new MarqueeToolEntry();
        ToolEntry optionalFeatureCreationEntry = createOptionalFeatureCreationEntry();
        ToolEntry mandatoryFeatureCreationEntry = createMandatoryFeatureCreationEntry();
        ToolEntry attributeCreationEntry = createAttributeCreationEntry();
        ToolEntry connectionCreationEntry = createConnectionCreationEntry();

        PaletteDrawer selectionTools = new PaletteDrawer("Selection Tools");
        selectionTools.add(selectionEntry);
        selectionTools.add(marqueeEntry);

        PaletteDrawer cretionTools = new PaletteDrawer("Creation Tools");
        cretionTools.add(optionalFeatureCreationEntry);
        cretionTools.add(mandatoryFeatureCreationEntry);
        cretionTools.add(attributeCreationEntry);
        cretionTools.add(connectionCreationEntry);

        add(selectionTools);
        add(cretionTools);
        setDefaultEntry(selectionEntry);
    }

    private ToolEntry createOptionalFeatureCreationEntry() {
        // Use CombinedTemplateCreationEntry instead of CreationToolEntry to support drag and drop
        // via TemplateTransferDragSourceListener and TemplateTransferDropTargetListener.
        ImageDescriptor img = FeatureModelEditorPlugin.getImageDescriptor("icons/feature-opt.png");
        CreationToolEntry featureCreationEntry = new CombinedTemplateCreationEntry(
                "Optional Feature", "Create optional feature.", new FeatureFactory(false), img, null);
        featureCreationEntry.setToolClass(CreationToolWithDirectEdit.class);
        return featureCreationEntry;
    }

    private ToolEntry createMandatoryFeatureCreationEntry() {
        ImageDescriptor img = FeatureModelEditorPlugin.getImageDescriptor("icons/feature-man.png");
        CreationToolEntry featureCreationEntry = new CombinedTemplateCreationEntry(
                "Mandatory Feature", "Create mandatory feature.", new FeatureFactory(true), img, null);
        featureCreationEntry.setToolClass(CreationToolWithDirectEdit.class);
        return featureCreationEntry;
    }

    private ToolEntry createAttributeCreationEntry() {
        ImageDescriptor img = FeatureModelEditorPlugin.getImageDescriptor("icons/attribute.png");
        CreationToolEntry attributeCreationEntry = new CombinedTemplateCreationEntry(
                "Attribute", "Add atribute to a feature.", new AttributeFactory(), img, null);
        return attributeCreationEntry;
    }

    private ToolEntry createConnectionCreationEntry() {
        ImageDescriptor img = FeatureModelEditorPlugin.getImageDescriptor("icons/connection.png");
        return new ConnectionCreationToolEntry("Connection", "Create connection (from feature to sub-feature).", null, img, null);
    }

    private static class FeatureFactory extends SimpleFactory {

        private boolean mandatoryFeatures;

        public FeatureFactory(boolean mandatoryFeatures) {
            super(Feature.class);
            this.mandatoryFeatures = mandatoryFeatures;
        }

        @Override
        public Object getNewObject() {
            Feature feature = FeatureModelFactory.eINSTANCE.createFeature();
            feature.setId(EcoreUtil.generateUUID());
            feature.setName("New feature");
            feature.setMandatory(mandatoryFeatures);
            return feature;
        }

    }

    private static class AttributeFactory extends SimpleFactory {

        public AttributeFactory() {
            super(Attribute.class);
        }

        @Override
        public Object getNewObject() {
            Attribute atttribute = FeatureModelFactory.eINSTANCE.createAttribute();
            atttribute.setId(EcoreUtil.generateUUID());
            atttribute.setName("New Attribute");
            return atttribute;
        }

    }

}
