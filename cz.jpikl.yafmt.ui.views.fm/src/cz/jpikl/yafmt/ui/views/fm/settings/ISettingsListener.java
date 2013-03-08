package cz.jpikl.yafmt.ui.views.fm.settings;

public interface ISettingsListener {

    void groupsVisibilityChanged(boolean groupsVisible);

    void constraintsVisibilityChanged(boolean constraintsVisible);

    void animationStateChanged(boolean animationEnabled, int animationTime);

    void lockedStateChanged(boolean viewLocked);

    void visibleDistanceChanged(int visibleDistance);

    void viewSizeChanged(boolean fixedSize, int sizeMultiplier);

}
