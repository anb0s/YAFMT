package cz.jpikl.yafmt.ui.pages;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
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

public class EditorContentOutlinePage extends ContentOutlinePage implements ISelectionListener {

    private CTabFolder tabFolder;
    private ScrollableThumbnail thumbmail;
    private Canvas thumbmailCanvas;
    private FreeformGraphicalRootEditPart rootEditPart;

    private Object input;
    private IContentProvider contentProvider;
    private ILabelProvider labelProvider;

    public EditorContentOutlinePage(GraphicalEditor editor, Object input, IContentProvider contentProvider, ILabelProvider labelProvider) {
        this.rootEditPart = (FreeformGraphicalRootEditPart) editor.getAdapter(EditPart.class);
        this.input = input;
        this.contentProvider = contentProvider;
        this.labelProvider = labelProvider;
    }
    
    @Override
    public Control getControl() {
        return tabFolder;
    }
    
    // ==================================================================
    //  Basic initialization
    // ==================================================================

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
    public void createControl(Composite parent) {
        tabFolder = new CTabFolder(parent, SWT.BOTTOM); // Use CTabFolder, because TabFolder looks ugly.
        createTreeView();
        createMinimap();
        tabFolder.setSelection(0);
    }

    protected void addTabControll(Control control, String title) {
        CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
        tabItem.setText(title);
        tabItem.setControl(control);
    }
    
    // ==================================================================
    //  Tabs initialization
    // ==================================================================

    private void createTreeView() {
        super.createControl(tabFolder); // Creates TreeViewer.

        TreeViewer treeViewer = getTreeViewer();
        treeViewer.setContentProvider(contentProvider);
        treeViewer.setLabelProvider(labelProvider);
        treeViewer.setInput(input);

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
    
    // ==================================================================
    //  Event handling
    // ==================================================================

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        // Ignore invalid selections.
        IWorkbenchPart activePart = getSite().getPage().getActivePart();
        if((part != activePart) || (part instanceof ContentOutline) || (part instanceof PropertySheet))
            return;

        // Forward selection to the TreeViewer.
        if(!getSelection().equals(selection))
            setSelection(selection);
    }

}
