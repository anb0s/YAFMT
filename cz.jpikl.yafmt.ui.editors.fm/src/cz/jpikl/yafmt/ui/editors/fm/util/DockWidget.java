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
    
    private ToolItem button;
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
        
        setLayout(createGridLayout());
        createTopControl(this);
        mainControl = createMainControl(this);
        mainControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        splitter.maintainSize(this);
        updateState();
    }
    
    private void createTopControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(createGridLayout(2));
        panel.setBackgroundImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("dock-bg"));
        panel.setSize(1, DEFAULT_HEIGHT);
        
        createTitle(panel);
        
        ToolBar buttonBar = new ToolBar(panel, SWT.FLAT);
        buttonBar.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, true));
        
        button = new ToolItem(buttonBar, SWT.NONE);
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchState();
            }
        });
    }
    
    protected abstract Control createMainControl(Composite parent);
    
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
            button.setImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("right"));
            button.setToolTipText(collapseToolTipText);
            splitter.setFixedSize(size);
            
        }
        else {
            size = splitter.getFixedSize();
            button.setImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("left"));
            button.setToolTipText(openToolTipText);
            splitter.setFixedSize(COLLAPSED_SIZE);
        }
        
        ((GridData) title.getLayoutData()).exclude = !opened;
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
