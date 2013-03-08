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

    private List<ISettingsListener> listeners;

    private boolean groupsVisible;         // Are groups visible?
    private boolean constraintsVisible;    // Are constraints visible?
    private boolean viewLocked;            // Is graph layout locked?
    private int visibleDistance;           // Visible distance from selected graph nodes.
    private boolean fixedSize;             // Is size of graph canvas is manually adjusted?
    private int sizeMultiplier;            // Size multiplier, used when size of graph canvas is adjusted manually.
    private boolean animationEnabled;      // Is graph animation enabled?
    private AnimationSpeed animationSpeed; // Animation duration.

    public Settings() {
        listeners = new ArrayList<ISettingsListener>();
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
        return animationSpeed.getDuration();
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
        final ToolItem groupsButton = new ToolItem(toolBar, SWT.CHECK);
        groupsButton.setSelection(groupsVisible);
        groupsButton.setToolTipText("Show Groups (Local Constraitns)");
        groupsButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group"));
        groupsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                groupsVisible = groupsButton.getSelection();
                for(ISettingsListener listener: listeners)
                    listener.groupsVisibilityChanged(groupsVisible);
            }
        });
    }

    private void createConstraintsButton(ToolBar toolBar) {
        final ToolItem constraintsButton = new ToolItem(toolBar, SWT.CHECK);
        constraintsButton.setSelection(constraintsVisible);
        constraintsButton.setToolTipText("Show (Global) Constraints");
        constraintsButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint"));
        constraintsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                constraintsVisible = constraintsButton.getSelection();
                for(ISettingsListener listener: listeners)
                    listener.constraintsVisibilityChanged(constraintsVisible);
            }
        });
    }

    private void createLockButton(ToolBar toolBar) {
        final ToolItem lockButton = new ToolItem(toolBar, SWT.CHECK);
        lockButton.setSelection(viewLocked);
        lockButton.setToolTipText("Lock View");
        lockButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("lock"));
        lockButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                viewLocked = lockButton.getSelection();
                for(ISettingsListener listener: listeners)
                    listener.lockedStateChanged(viewLocked);
            }
        });
    }

    private void createDistanceControl(Composite panel) {
        Composite distancePanel = new Composite(panel, SWT.NONE);
        distancePanel.setLayout(new GridLayout(2, false));

        Text distanceText = new Text(distancePanel, SWT.NONE);
        distanceText.setText("Visible distance:");

        final Combo distanceCombo = new Combo(distancePanel, SWT.READ_ONLY);
        distanceCombo.setItems(new String[] { "infinite", "1", "2" });
        distanceCombo.setText(distanceCombo.getItem(Math.max(0, visibleDistance)));
        distanceCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = distanceCombo.getSelectionIndex();
                visibleDistance = (index > 0) ? index : DistanceFilter.INFINITE_DISTACE;
                for(ISettingsListener listener: listeners)
                    listener.visibleDistanceChanged(visibleDistance);
            }
        });
    }

    private void createSizeControl(Composite panel) {
        Composite sizePanel = new Composite(panel, SWT.NONE);
        sizePanel.setLayout(new GridLayout(2, false));

        final Button sizeButton = new Button(sizePanel, SWT.CHECK);
        final Combo sizeCombo = new Combo(sizePanel, SWT.READ_ONLY);

        sizeButton.setSelection(fixedSize);
        sizeButton.setText("Adjust size:");
        sizeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                fixedSize = sizeButton.getSelection();
                sizeCombo.setEnabled(fixedSize);
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });

        for(int i = 1; i <= MAX_SIZE_MULTIPLIER; i++)
            sizeCombo.add(i + "x");
        sizeCombo.setText(sizeCombo.getItem(sizeMultiplier - 1));
        sizeCombo.setEnabled(fixedSize);
        sizeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                sizeMultiplier = sizeCombo.getSelectionIndex() + 1;
                for(ISettingsListener listener: listeners)
                    listener.viewSizeChanged(fixedSize, sizeMultiplier);
            }
        });
    }

    private void createAnimationControl(Composite panel) {
        Composite animationPanel = new Composite(panel, SWT.NONE);
        animationPanel.setLayout(new GridLayout(2, false));

        final Button animationButton = new Button(animationPanel, SWT.CHECK);
        final Combo animationCombo = new Combo(animationPanel, SWT.READ_ONLY);

        animationButton.setSelection(animationEnabled);
        animationButton.setText("Enable Animation");
        animationButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                animationEnabled = animationButton.getSelection();
                animationCombo.setEnabled(animationEnabled);
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled, animationSpeed.getDuration());
            }
        });

        for(AnimationSpeed type: AnimationSpeed.values())
            animationCombo.add(type.getName());
        animationCombo.setText(animationSpeed.getName());
        animationCombo.setEnabled(animationEnabled);
        animationCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int index = animationCombo.getSelectionIndex();
                if(animationSpeed == AnimationSpeed.values()[index])
                    return;
                animationSpeed = AnimationSpeed.values()[index];
                for(ISettingsListener listener: listeners)
                    listener.animationStateChanged(animationEnabled, animationSpeed.getDuration());
            }
        });
    }

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
