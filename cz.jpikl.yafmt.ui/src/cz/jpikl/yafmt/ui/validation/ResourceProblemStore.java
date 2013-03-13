package cz.jpikl.yafmt.ui.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ResourceProblemStore implements IProblemStore {
    
    public static final String MARKER_ID = "cz.jpikl.yafmt.ui.ModelProblemMarker";
    public static final String MARKER_PROBLEM_OBJECT_URI = "cz.jpikl.yafmt.ui.ModelProblemMarker.ProblemObjectURI";
    public static final String URI_FRAGMENTS_SEPARATOR = ";";
        
    private static class Problems {
        List<IMarker> markers = new ArrayList<IMarker>();
        List<String> messages = new ArrayList<String>();
    }

    private Map<Object, Problems> problems = new HashMap<Object, Problems>();
    private boolean enabled = true;
    private IResource resource;
        
    public ResourceProblemStore(IResource resource) {
        if(resource == null)
            throw new IllegalArgumentException("Resource must not be null.");
        this.resource = resource;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
        
    @Override
    public void readProblems(Diagnostic diagnostic) {
        if(!enabled)
            return;
        
        for(Diagnostic diagnosticChild: diagnostic.getChildren()) {
            int code = diagnosticChild.getCode();
            String message = diagnosticChild.getMessage();
            List<?> objects = diagnosticChild.getData();
            addProblems(code, message, objects);
        }
    }
    
    private void addProblems(int code, String message, List<?> objects) {
        try {
            IMarker marker = resource.createMarker(MARKER_ID);
            marker.setAttribute(IMarker.SEVERITY, getSeverity(code));
            marker.setAttribute(IMarker.MESSAGE, message);
            
            if(objects == null)
                return;
                
            // Generate string containing URI fragments of all EObjects.
            StringBuilder uriBuilder = new StringBuilder();
            for(Object object: objects) {
                if(!(object instanceof EObject))
                    continue;
                
                EObject eObject = (EObject) object;
                Resource emfResource = eObject.eResource();
                if(emfResource != null) {
                    String uri = emfResource.getURIFragment(eObject);
                    uriBuilder.append(uri).append(URI_FRAGMENTS_SEPARATOR);
                    addProblem(eObject, marker, message);
                }
            }
            
            // Save the result as marker attribute.
            marker.setAttribute(MARKER_PROBLEM_OBJECT_URI, uriBuilder.toString());
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addProblem(Object object, IMarker marker, String message) {
        Problems objectProblems = problems.get(object);
        if(objectProblems == null) {
            objectProblems = new Problems();
            problems.put(object, objectProblems);
        }
        objectProblems.markers.add(marker);
        objectProblems.messages.add(message);
    }
    
    private int getSeverity(int code) {
        switch(code) {
            case Diagnostic.ERROR:
                return IMarker.SEVERITY_ERROR;
            
            case Diagnostic.WARNING:
                return IMarker.SEVERITY_WARNING;
                    
            case Diagnostic.INFO:
                return IMarker.SEVERITY_INFO;
                
            default:
                return IMarker.SEVERITY_INFO;
        }
    }

    @Override
    public void clearProblems(Object target) {
        if(!enabled)
            return;
        
        Problems objectProblems = problems.remove(target);
        if(objectProblems == null)
            return;
        
        try {
            for(IMarker marker: objectProblems.markers)
                marker.delete();
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void clearAllProblems() {
        if(!enabled)
            return;
        
        try {
            problems.clear();
            if(resource.exists()) // When user deleted edited file.
                resource.deleteMarkers(MARKER_ID, false, IResource.DEPTH_INFINITE);
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> getProblems(Object target) {
        Problems objectProblems = problems.get(target);
        return (objectProblems != null) ? objectProblems.messages : null;
    }

}
