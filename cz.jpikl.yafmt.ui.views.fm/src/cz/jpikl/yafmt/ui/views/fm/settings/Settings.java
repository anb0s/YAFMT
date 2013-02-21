package cz.jpikl.yafmt.ui.views.fm.settings;

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

import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;
import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.jpikl.yafmt.ui.views.fm.util.SettingsUtil;

public class Settings {
    
    private static final int MAX_SIZE_MULTIPLIER = 5;
    
    private List<ISettingsListener> listeners;
    private ImageRegistry imageRegistry;
    
    private ToolItem groupsButton;
    private ToolItem constraintsButton;
    private ToolItem lockButton;
    private Combo distanceCombo;
    private Button sizeButton;
    private Combo sizeCombo;
    private Button animationButton;
    private Combo animationCombo;
    
    private boolean groupsVisible;       // Are groups visible?
    private boolean constraintsVisible;  // Are constraints visible?
    private boolean viewLocked;          // Is graph layout locked?
    private int visibleDistance;         // Visible distance from selected graph nodes.
    private boolean fixedSize;           // Is size of graph canvas is manually adjusted?
    private int sizeMultiplier;          // Size multiplier, used when size of graph canvas is adjusted manually.
    private boolean animationEnabled;    // Is graph animation enabled?
    private AnimationType animationType; // Animation duration.
    
    public Settings() {        
        listeners = new ArrayList<ISettingsListener>();
        imageRegistry = FeatureModelVisualizerPlugin.getDefault().getImageRegistry();
    }
    
    public boolean areGroupsVisible() {
        return groupsVisible;
    }
    
    public boolean areConstraintsVisible() {
        return constraintsVisible;
    }
    
    public boolean isViewLocked() {
        return viewLocked;
    }
    
    public int getVisibleDistance() {
        return visibleDistance;
    }
    
    public boolean isFixedSize() {
        return fixedSize;
    }
    
    public int getSizeMultiplier() {
        return sizeMultiplier;
    }
    
    public boolean isAnimationEnabled() {
        return animationEnabled;
    }
    
    public int getAnimationTime() {
        return animationType.getDuration();
    }
    
    public void addSettingsListener(ISettingsListener listener) {
        listeners.add(listener);
    }
    
    public void removeSettingsListener(ISettingsListener listener) {
        listeners.remove(listener);
    }
        
    public void init(IDialogSettings settings) {
        groupsVisible = SettingsUtil.getBoolean(settings, "groupsVisible", true);
        constraintsVisible = SettingsUtil.getBoolean(settings, "constraintsVisible", true);
        viewLocked = SettingsUtil.getBoolean(settings, "viewLocked", false);
        visibleDistance = SettingsUtil.getInteger(settings, "visibleDistance", DistanceFilter.INFINITE_DISTACE);
        fixedSize = SettingsUtil.getBoolean(settings, "fixedSize", true);
        sizeMultiplier = SettingsUtil.getInteger(settings, "sizeMultiplier", 1);
        animationEnabled = SettingsUtil.getBoolean(settings, "animationEnabled", true);
        animationType = AnimationType.valueOf(SettingsUtil.getString(settings, "animationType", AnimationType.NORMAL.toString()));
    }
    
    public void save(IDialogSettings settings) {
        settings.put("groupsVisible", groupsVisible);
        settings.put("constraintsVisible", constraintsVisible);
        settings.put("viewLocked", viewLocked);
        settings.put("visibleDistance", visibleDistance);
        settings.put("fixedSize", fixedSize);
        settings.put("sizeMultiplier", sizeMultiplier);
        settings.put("animationEnabled", animationEnabled);
        settings.put("animationType", animationType.toString());
        
    }
    
    public void createControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(4, false));
        
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
        
        distanceCombo = new Combo(distancePanel, SWT.READ_ONLY);
        distanceCombo.setItems(new String[] { "infinite", "1", "2" });
        distanceCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = distanceCombo.getSelectionIndex();
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
                updateSizeCombo();
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
        
        sizeCombo = new Combo(sizePanel, SWT.READ_ONLY);
        for(int i = 1; i <= MAX_SIZE_MULTIPLIER; i++)
            sizeCombo.add(i + "x");
        sizeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                sizeMultiplier = sizeCombo.getSelectionIndex() + 1;
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
        
        Composite animationPanel = new Composite(panel, SWT.NONE);
        animationPanel.setLayout(new GridLayout(2, false));
        
        animationButton = new Button(animationPanel, SWT.CHECK);
        animationButton.setText("Use Animation");
        animationButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                animationEnabled = !animationEnabled;
                updateAnimationCombo();
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled, animationType.getDuration());
            }
        });
        
        animationCombo = new Combo(animationPanel, SWT.READ_ONLY);
        for(AnimationType type: AnimationType.values())
            animationCombo.add(type.getName());
        animationCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int index = animationCombo.getSelectionIndex();
                if(animationType == AnimationType.values()[index])
                    return;
                animationType = AnimationType.values()[index];
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled, animationType.getDuration());
            }
        });
            
        updateGroupsButton();
        updateConstraintsButton();
        updateLockButton();
        updateDistanceCombo();
        updateSizeButton();
        updateSizeCombo();
        updateAnimationButton();
        updateAnimationCombo();
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
    
    private void updateDistanceCombo() {
        distanceCombo.setText(distanceCombo.getItem(Math.max(0, visibleDistance)));
    }
    
    private void updateSizeButton() {
        sizeButton.setSelection(fixedSize);
    }
    
    private void updateSizeCombo() {
        sizeCombo.setText(sizeCombo.getItem(sizeMultiplier - 1));
        sizeCombo.setEnabled(fixedSize);
    }
    
    private void updateAnimationButton() {
        animationButton.setSelection(animationEnabled);
    }
    
    private void updateAnimationCombo() {
        animationCombo.setEnabled(animationEnabled);
        animationCombo.setText(animationType.getName());
    }
    
    private static enum AnimationType {
        
        FAST("Fast", 250),
        NORMAL("Normal", 500),
        SLOW("Slow", 1000),
        VERY_SLOW("Very Slow", 2000);
        
        private String name;
        private int duration;
        
        private AnimationType(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
        
        public int getDuration() {
            return duration;
        }
        
        public String getName() {
            return name;
        }
        
    }

}
