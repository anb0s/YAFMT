package cz.jpikl.yafmt.ui.views.fm.settings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;
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

import cz.jpikl.yafmt.ui.util.SettingsUtil;
import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;
import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;

public class Settings {

    private static final int MAX_SIZE_MULTIPLIER = 5;

    private List<ISettingsListener> listeners = new ArrayList<ISettingsListener>();
    
    private boolean groupsVisible;         // Are groups visible?
    private boolean constraintsVisible;    // Are constraints visible?
    private boolean viewLocked;            // Is graph layout locked?
    private int visibleDistance;           // Visible distance from selected graph nodes.
    private boolean fixedSize;             // Is size of graph canvas is manually adjusted?
    private int sizeMultiplier;            // Size multiplier, used when size of graph canvas is adjusted manually.
    private boolean animationEnabled;      // Is graph animation enabled?
    private AnimationSpeed animationSpeed; // Animation duration.

        
    // ========================================================================
    //  Initialization
    // ========================================================================

    public void init(IDialogSettings settings) {
        groupsVisible = SettingsUtil.getBoolean(settings, "groupsVisible", true);
        constraintsVisible = SettingsUtil.getBoolean(settings, "constraintsVisible", true);
        viewLocked = SettingsUtil.getBoolean(settings, "viewLocked", false);
        visibleDistance = SettingsUtil.getInteger(settings, "visibleDistance", DistanceFilter.INFINITE_DISTACE);
        fixedSize = SettingsUtil.getBoolean(settings, "fixedSize", true);
        sizeMultiplier = SettingsUtil.getInteger(settings, "sizeMultiplier", 1);
        animationEnabled = SettingsUtil.getBoolean(settings, "animationEnabled", true);
        animationSpeed = AnimationSpeed.valueOf(SettingsUtil.getString(settings, "animationSpeed", AnimationSpeed.NORMAL.toString()));
    }

    public void save(IDialogSettings settings) {
        settings.put("groupsVisible", groupsVisible);
        settings.put("constraintsVisible", constraintsVisible);
        settings.put("viewLocked", viewLocked);
        settings.put("visibleDistance", visibleDistance);
        settings.put("fixedSize", fixedSize);
        settings.put("sizeMultiplier", sizeMultiplier);
        settings.put("animationEnabled", animationEnabled);
        settings.put("animationSpeed", animationSpeed.toString());

    }
    
    // ========================================================================
    //  Control creation
    // ========================================================================

    public void createControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(4, false));
        
        createToolBar(panel);
        createDistanceControl(panel);
        createSizeControl(panel);
        createAnimationControl(panel);
    }

    private void createToolBar(Composite panel) {
        ToolBar toolBar = new ToolBar(panel, SWT.FLAT);
        createGroupsButton(toolBar);
        createConstraintsButton(toolBar);
        createLockButton(toolBar);
    }

    private void createGroupsButton(ToolBar toolBar) {
        ToolItem button = new ToolItem(toolBar, SWT.CHECK);
        button.setSelection(groupsVisible);
        button.setToolTipText("Show Groups (Local Constraitns)");
        button.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group"));
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                groupsVisible = ((ToolItem) event.getSource()).getSelection();
                for(ISettingsListener listener: listeners)
                    listener.groupsVisibilityChanged(groupsVisible);
            }
        });
    }

    private void createConstraintsButton(ToolBar toolBar) {
        ToolItem button = new ToolItem(toolBar, SWT.CHECK);
        button.setSelection(constraintsVisible);
        button.setToolTipText("Show (Global) Constraints");
        button.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint"));
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                constraintsVisible = ((ToolItem) event.getSource()).getSelection();
                for(ISettingsListener listener: listeners)
                    listener.constraintsVisibilityChanged(constraintsVisible);
            }
        });
    }

    private void createLockButton(ToolBar toolBar) {
        ToolItem button = new ToolItem(toolBar, SWT.CHECK);
        button.setSelection(viewLocked);
        button.setToolTipText("Lock View");
        button.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("lock"));
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                viewLocked = ((ToolItem) event.getSource()).getSelection();
                for(ISettingsListener listener: listeners)
                    listener.lockedStateChanged(viewLocked);
            }
        });
    }

    private void createDistanceControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout(2, false));
        createDistanceControlText(panel);
        createDistanceControlCombo(panel);
    }

    private void createDistanceControlText(Composite parent) {
        Text text = new Text(parent, SWT.NONE);
        text.setText("Visible distance:");
    }
    
    private void createDistanceControlCombo(Composite parent) {
        Combo combo = new Combo(parent, SWT.READ_ONLY);
        combo.setItems(new String[] { "infinite", "1", "2" });
        combo.setText(combo.getItem(Math.max(0, visibleDistance)));
        combo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                visibleDistance = (index > 0) ? index : DistanceFilter.INFINITE_DISTACE;
                for(ISettingsListener listener: listeners)
                    listener.visibleDistanceChanged(visibleDistance);
            }
        });
    }

    private void createSizeControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout(2, false));
        
        Button button = new Button(panel, SWT.CHECK);
        Combo combo = createSizeControlCombo(panel);
        initSizeControlButton(button, combo);
    }
    
    private void initSizeControlButton(Button button, final Combo combo) {
        button.setSelection(fixedSize);
        button.setText("Adjust size:");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                fixedSize = ((Button) event.getSource()).getSelection();
                combo.setEnabled(fixedSize);
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
    }
    
    private Combo createSizeControlCombo(Composite parent) {
        Combo combo = new Combo(parent, SWT.READ_ONLY);
        for(int i = 1; i <= MAX_SIZE_MULTIPLIER; i++)
            combo.add(i + "x");
        combo.setText(combo.getItem(sizeMultiplier - 1));
        combo.setEnabled(fixedSize);
        combo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                sizeMultiplier = ((Combo) event.getSource()).getSelectionIndex() + 1;
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
        return combo;
    }

    private void createAnimationControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout(2, false));
        
        Button button = new Button(panel, SWT.CHECK);
        Combo combo = createAnimationControlCombo(panel);
        initAnimationControlButton(button, combo);
    }
    
    private void initAnimationControlButton(Button button, final Combo combo) {
        button.setSelection(animationEnabled);
        button.setText("Enable Animation");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                animationEnabled = ((Button) event.getSource()).getSelection();
                combo.setEnabled(animationEnabled);
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled, animationSpeed.getDuration());
            }
        });
    }
    
    private Combo createAnimationControlCombo(Composite parent) {
        Combo combo = new Combo(parent, SWT.READ_ONLY);
        for(AnimationSpeed type: AnimationSpeed.values())
            combo.add(type.getName());
        combo.setText(animationSpeed.getName());
        combo.setEnabled(animationEnabled);
        combo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                if(animationSpeed == AnimationSpeed.values()[index])
                    return;
                animationSpeed = AnimationSpeed.values()[index];
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled, animationSpeed.getDuration());
            }
        });
        return combo;
    }
    
    // ========================================================================
    //  Properties
    // ========================================================================

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
        return animationSpeed.getDuration();
    }

    public void addSettingsListener(ISettingsListener listener) {
        listeners.add(listener);
    }

    public void removeSettingsListener(ISettingsListener listener) {
        listeners.remove(listener);
    }
    
    // ========================================================================
    //  Helpers
    // ========================================================================

    private static enum AnimationSpeed {

        FAST("Fast", 250),
        NORMAL("Normal", 500),
        SLOW("Slow", 1000),
        VERY_SLOW("Very Slow", 2000);

        private String name;
        private int duration;

        private AnimationSpeed(String name, int duration) {
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
