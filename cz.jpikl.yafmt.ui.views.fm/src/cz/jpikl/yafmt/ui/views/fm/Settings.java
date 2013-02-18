package cz.jpikl.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.jpikl.yafmt.ui.views.fm.util.SettingsUtil;

public class Settings {

    private static final int MAX_SIZE_MULTIPLIER = 5;
    
    private List<ISettingsListener> listeners;
    private ImageRegistry imageRegistry;
    
    private ToolItem groupsButton;
    private ToolItem constraintsButton;
    private ToolItem animationButton;
    private ToolItem lockButton;
    private Combo distanceComboBox;
    private Combo sizeComboBox;
    private Button sizeButton;
    
    private int visibleDistance;        // Visible distance from selected graph nodes.
    private int sizeMultiplier;         // Size multiplier, used when size of graph canvas is adjusted manually.
    private boolean fixedSize;          // Is size of graph canvas is manually adjusted?
    private boolean groupsVisible;      // Are groups visible?
    private boolean constraintsVisible; // Are constraints visible?
    private boolean animationEnabled;   // Is graph animation enabled?
    private boolean viewLocked;         // Is graph layout locked?
    
    public Settings() {        
        listeners = new ArrayList<ISettingsListener>();
        imageRegistry = FeatureModelVisualizerPlugin.getDefault().getImageRegistry();
    }
    
    public int getVisibleDistance() {
        return visibleDistance;
    }
    
    public int getSizeMultiplier() {
        return sizeMultiplier;
    }
    
    public boolean isFixedSize() {
        return fixedSize;
    }
    
    public boolean areGroupsVisible() {
        return groupsVisible;
    }
    
    public boolean areConstraintsVisible() {
        return constraintsVisible;
    }
    
    public boolean isAnimationEnabled() {
        return animationEnabled;
    }
    
    public boolean isViewLocked() {
        return viewLocked;
    }
    
    public void addSettingsListener(ISettingsListener listener) {
        listeners.add(listener);
    }
    
    public void removeSettingsListener(ISettingsListener listener) {
        listeners.remove(listener);
    }
        
    public void init(IDialogSettings settings) {
        visibleDistance = SettingsUtil.getInteger(settings, "visibleDistance", DistanceFilter.INFINITE_DISTACE);
        sizeMultiplier = SettingsUtil.getInteger(settings, "sizeMultiplier", 1);
        fixedSize = SettingsUtil.getBoolean(settings, "fixedSize", true);
        groupsVisible = SettingsUtil.getBoolean(settings, "groupsVisible", true);
        constraintsVisible = SettingsUtil.getBoolean(settings, "constraintsVisible", true);
        animationEnabled = SettingsUtil.getBoolean(settings, "animationEnabled", true);
        viewLocked = SettingsUtil.getBoolean(settings, "viewLocked", false);
    }
    
    public void save(IDialogSettings settings) {
        settings.put("visibleDistance", visibleDistance);
        settings.put("sizeMultiplier", sizeMultiplier);
        settings.put("fixedSize", fixedSize);
        settings.put("groupsVisible", groupsVisible);
        settings.put("constraintsVisible", constraintsVisible);
        settings.put("animationEnabled", animationEnabled);
        settings.put("viewLocked", viewLocked);
    }
    
    public void createControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(3, false));
        
        ToolBar toolBar = new ToolBar(panel, SWT.FLAT);
        
        groupsButton = new ToolItem(toolBar, SWT.NONE);
        groupsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                groupsVisible = !groupsVisible;
                updateGroupsButton();
                for(ISettingsListener listener: listeners)
                    listener.groupsVisibilityChanged(groupsVisible);
            }
        });
        
        constraintsButton = new ToolItem(toolBar, SWT.NONE);
        constraintsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                constraintsVisible = !constraintsVisible;
                updateConstraintsButton();
                for(ISettingsListener listener: listeners)
                    listener.constraintsVisibilityChanged(constraintsVisible);
            }
        });
        
        animationButton = new ToolItem(toolBar, SWT.NONE);
        animationButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                animationEnabled = !animationEnabled;
                updateAnimationButton();
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled);
            }
        });
        
        lockButton = new ToolItem(toolBar, SWT.NONE);
        lockButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                viewLocked = !viewLocked;
                updateLockButton();
                for(ISettingsListener listener: listeners)
                    listener.lockedStateChanged(viewLocked);
            }
        });
                
        Composite distancePanel = new Composite(panel, SWT.NONE);
        distancePanel.setLayout(new GridLayout(2, false));
        Text distanceText = new Text(distancePanel, SWT.NONE);
        distanceText.setText("Visible distance:");
        
        distanceComboBox = new Combo(distancePanel, SWT.READ_ONLY);
        distanceComboBox.setItems(new String[] { "infinite", "1", "2" });
        distanceComboBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = distanceComboBox.getSelectionIndex();
                visibleDistance = (index > 0) ? index : DistanceFilter.INFINITE_DISTACE;
                for(ISettingsListener listener: listeners)
                    listener.visibleDistanceChanged(visibleDistance);
            }
        });
        
        Composite sizePanel = new Composite(panel, SWT.NONE);
        sizePanel.setLayout(new GridLayout(2, false));
        
        sizeButton = new Button(sizePanel, SWT.CHECK);
        sizeButton.setText("Adjust size:");
        sizeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                fixedSize = sizeButton.getSelection();
                updateSizeComboBox();
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
        
        sizeComboBox = new Combo(sizePanel, SWT.READ_ONLY);
        for(int i = 1; i <= MAX_SIZE_MULTIPLIER; i++)
            sizeComboBox.add(i + "x");
        sizeComboBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                sizeMultiplier = sizeComboBox.getSelectionIndex() + 1;
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
        
        updateGroupsButton();
        updateConstraintsButton();
        updateAnimationButton();
        updateLockButton();
        updateDistanceComboBox();
        updateSizeButton();
        updateSizeComboBox();
    }
    
    private void updateGroupsButton() {
        if(groupsVisible) {
            groupsButton.setImage(imageRegistry.get("groups-enabled"));
            groupsButton.setToolTipText("Hide Groups");
        }
        else {
            groupsButton.setImage(imageRegistry.get("groups-disabled"));
            groupsButton.setToolTipText("Show Groups");
        }
    }
    
    private void updateConstraintsButton() {
        if(constraintsVisible) {
            constraintsButton.setImage(imageRegistry.get("constraints-enabled"));
            constraintsButton.setToolTipText("Hide Constraints");
        }
        else {
            constraintsButton.setImage(imageRegistry.get("constraints-disabled"));
            constraintsButton.setToolTipText("Show Constraints");
        }
    }
    
    private void updateAnimationButton() {
        if(animationEnabled) {
            animationButton.setImage(imageRegistry.get("animation-enabled"));
            animationButton.setToolTipText("Disable Animation");
        }
        else {
            animationButton.setImage(imageRegistry.get("animation-disabled"));
            animationButton.setToolTipText("Enable Animation");
        }
    }
    
    private void updateLockButton() {
        if(viewLocked) {
            lockButton.setImage(imageRegistry.get("locked"));
            lockButton.setToolTipText("Unlock View");
        }
        else {
            lockButton.setImage(imageRegistry.get("unlocked"));
            lockButton.setToolTipText("Lock View");
        }
    }
    
    private void updateDistanceComboBox() {
        distanceComboBox.setText(distanceComboBox.getItem(Math.max(0, visibleDistance)));
    }
    
    private void updateSizeButton() {
        sizeButton.setSelection(fixedSize);
    }
    
    private void updateSizeComboBox() {
        sizeComboBox.setText(sizeComboBox.getItem(sizeMultiplier - 1));
        sizeComboBox.setEnabled(fixedSize);
    }

}
