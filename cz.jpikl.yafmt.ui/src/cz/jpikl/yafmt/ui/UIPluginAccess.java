package cz.jpikl.yafmt.ui;

import java.util.Enumeration;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;


public class UIPluginAccess {

    private static final String IMAGE_DIRECTORY = "icons";
    
    private AbstractUIPlugin plugin;
    private String pluginId;
    
    public UIPluginAccess(AbstractUIPlugin plugin, String pluginId) {
        this.plugin = plugin;
        this.pluginId = pluginId;
    }

    // ==================================================================================
    //  Settings utilities
    // ==================================================================================
    
    public IDialogSettings getDialogSettings() {
        return plugin.getDialogSettings();
    }
    
    // ==================================================================================
    //  Image utilities
    // ==================================================================================
    
    public ImageDescriptor getImageDescriptor(String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, IMAGE_DIRECTORY + "/" + path);
    }
    
    public Image getImage(String name) {
        return plugin.getImageRegistry().get(name);
    }
    
    public void initializeImageRegistry(ImageRegistry registry) {
        // Automatically load all images in icons directory.
        Enumeration<String> iconPaths = plugin.getBundle().getEntryPaths(IMAGE_DIRECTORY);
        while(iconPaths.hasMoreElements()) {
            String iconPath = iconPaths.nextElement();
            if(!iconPath.endsWith(".png") && !iconPath.endsWith(".gif"))
                continue;
            
            String iconName = iconPath.substring(IMAGE_DIRECTORY.length() + 1);
            registry.put(iconName, getImageDescriptor(iconName).createImage());
        }
    }
    
    // ==================================================================================
    //  Logging utilities
    // ==================================================================================
        
    public void log(int severity, String message, Throwable exception) {
        plugin.getLog().log(new Status(severity, pluginId, message, exception));
    }
    
    public void log(int severity, String message) {
        log(severity, message, null);
    }
    
    public void logError(String message, Throwable exception) {
        log(IStatus.ERROR, message, exception);
    }
    
    public void logError(String message) {
        logError(message, null);
    }
    
    public void logError(Throwable exception) {
        logError(exception.getMessage(), exception);
    }
    
    // ==================================================================================
    //  Dialog utilities
    // ==================================================================================
    
    public void showErrorDialog(IShellProvider shellProvider, String title, String message, Throwable exception) {
        String statusMessage = (exception != null) ? exception.getMessage() : message;
        IStatus status = new Status(IStatus.ERROR, pluginId, statusMessage, exception);
        ErrorDialog.openError(shellProvider.getShell(), title, message, status);
    }
    
    public void showErrorDialog(IShellProvider shellProvider, String title, Throwable exception) {
        showErrorDialog(shellProvider, title, exception.getMessage(), exception);
    }
    
    public void showErrorDialog(IShellProvider shellProvider, String title, String message) {
        showErrorDialog(shellProvider, title, message, null);
    }
    
}
