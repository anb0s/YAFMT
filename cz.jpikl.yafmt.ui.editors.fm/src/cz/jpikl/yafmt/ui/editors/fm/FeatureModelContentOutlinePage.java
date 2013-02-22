package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;

public class FeatureModelContentOutlinePage extends ContentOutlinePage implements ISelectionListener {

    private CTabFolder tabFolder;
    private ScrollableThumbnail thumbmail;
    private Canvas thumbmailCanvas;
    private FeatureModel featureModel;
    private ScalableFreeformRootEditPart rootEditPart;
    
    public FeatureModelContentOutlinePage(FeatureModel featureModel, ScalableFreeformRootEditPart rootEditPart) {
        this.featureModel = featureModel;
        this.rootEditPart = rootEditPart;
    }
    
    @Override
    public void init(IPageSite pageSite) {
        super.init(pageSite);
        pageSite.getPage().addSelectionListener(this);
    }
    
    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        thumbmail.deactivate();
        thumbmailCanvas.dispose();
        getTreeViewer().getControl().dispose();
        super.dispose();
    }
    
    @Override
    public Control getControl() {
        return tabFolder;
    }
    
    @Override
    public void createControl(Composite parent) {
        tabFolder = new CTabFolder(parent, SWT.BOTTOM); // Use CTabFolder, because TabFolder looks ugly.
        createTreeView();
        createMinimap();
    }
    
    protected void addTabControll(Control control, String title) {
        CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
        tabItem.setText(title);
        tabItem.setControl(control);
    }
    
    private void createTreeView() {
        super.createControl(tabFolder); // Creates TreeViewer.
        
        TreeViewer treeViewer = getTreeViewer();
        treeViewer.setContentProvider(FeatureModelProviderUtil.getContentProvider());
        treeViewer.setLabelProvider(FeatureModelProviderUtil.getLabelProvider());
        treeViewer.setInput(featureModel);
        
        addTabControll(treeViewer.getControl(), "Tree View");
    }
    
    private void createMinimap() {
        thumbmail = new ScrollableThumbnail();
        thumbmail.setViewport((Viewport) rootEditPart.getFigure());
        thumbmail.setSource(rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS));
        
        thumbmailCanvas = new Canvas(tabFolder, SWT.NONE);
        LightweightSystem lightweightSystem = new LightweightSystem(thumbmailCanvas);
        lightweightSystem.setContents(thumbmail);
        
        addTabControll(thumbmailCanvas, "Minimap");
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        // Ignore invalid selections.
        if(part != getSite().getPage().getActivePart())
            return;
        if((part instanceof ContentOutline) || (part instanceof PropertySheet))
            return;
                
        setSelection(selection); // Forward selection to the TreeViewer.
    }

}
