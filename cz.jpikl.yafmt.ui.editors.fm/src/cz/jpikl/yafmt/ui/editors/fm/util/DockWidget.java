package cz.jpikl.yafmt.ui.editors.fm.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;

public abstract class DockWidget extends Composite {

    private static final int DEFAULT_HEIGHT = 25;
    private static final int DEFAULT_SIZE = 200;
    private static final int COLLAPSED_SIZE = 13;
    
    private static Layout createGridLayout() {
        return createGridLayout(1);
    }
    
    private static Layout createGridLayout(int numColumns) {
        GridLayout layout = new GridLayout(numColumns, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        return layout;
    }
    
    private Splitter splitter;
    private Control mainControl;
    
    private ToolBar customToolbar;
    private ToolItem collapseButton;
    private Composite title;
    private Label titleImage;
    private Label titleText;
    
    private String openToolTipText;
    private String collapseToolTipText;
    
    private boolean opened;
    private int size;
    
    public DockWidget(Splitter splitter, int style) {
        super(splitter, style);
        
        this.splitter = splitter;
        this.opened = true;
        this.size = DEFAULT_SIZE;
        
        splitter.maintainSize(this);
    }
    
    public void createControl() {
        setLayout(createGridLayout());
        createTopControl(this);
        
        mainControl = createMainControl(this);
        mainControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        initializeControl();
        updateState();
    }
    
    private void createTopControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(createGridLayout(3));
        panel.setBackgroundImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("dock-bg"));
        panel.setSize(1, DEFAULT_HEIGHT);
        
        createTitle(panel);
        
        customToolbar = new  ToolBar(panel, SWT.FLAT);
        customToolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        contributeToToolbar(customToolbar);
        
        ToolBar toolBar = new ToolBar(panel, SWT.FLAT);
        toolBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        collapseButton = new ToolItem(toolBar, SWT.NONE);
        collapseButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchState();
            }
        });
    }
    
    protected abstract Control createMainControl(Composite parent);
    
    protected void initializeControl() {        
    }
    
    protected void contributeToToolbar(ToolBar toolBar) {
    }
    
    private void createTitle(Composite parent) {
        title = new Composite(parent, SWT.NONE);
        title.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        title.setLayout(createGridLayout(2));
        
        titleImage = new Label(title, SWT.NONE);
        titleImage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        
        titleText = new Label(title, SWT.NONE);
        titleText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }
    
    private void switchState() {
        opened = !opened;
        updateState();
    }
    
    private void updateState() {
        if(opened) {
            collapseButton.setImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("right"));
            collapseButton.setToolTipText(collapseToolTipText);
            splitter.setFixedSize(size);
            
        }
        else {
            size = splitter.getFixedSize();
            collapseButton.setImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("left"));
            collapseButton.setToolTipText(openToolTipText);
            splitter.setFixedSize(COLLAPSED_SIZE);
        }
        
        ((GridData) title.getLayoutData()).exclude = !opened;
        ((GridData) customToolbar.getLayoutData()).exclude = !opened;
        ((GridData) mainControl.getLayoutData()).exclude = !opened;
        title.setVisible(opened);
        mainControl.setVisible(opened);
        
        splitter.setResizeEnabled(opened);
        splitter.layout();
    }

    public void setName(String name) {
        titleText.setText(name);
    }
    
    public void setImage(Image image) {
        titleImage.setImage(image);
    }
    
    public void setOpenToolTipText(String openToolTipText) {
        this.openToolTipText = openToolTipText;
    }
    
    public void setCollapseToolTipText(String collapseToolTipText) {
        this.collapseToolTipText = collapseToolTipText;
    }

}
