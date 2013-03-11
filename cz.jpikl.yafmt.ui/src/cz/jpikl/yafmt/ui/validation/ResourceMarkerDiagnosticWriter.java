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

public class ResourceMarkerDiagnosticWriter implements IDiagnosticWriter {
    
    public static final String MARKER_ID = "cz.jpikl.yafmt.ui.ModelProblemMarker";
    public static final String MARKER_PROBLEM_OBJECT_URI = "cz.jpikl.yafmt.ui.ModelProblemMarker.ProblemObjectURI";
    public static final String URI_FRAGMENTS_SEPARATOR = ";";

    private Map<Object, List<IMarker>> objectMarkers = new HashMap<Object, List<IMarker>>();
    private IResource resource;
    
    public ResourceMarkerDiagnosticWriter(IResource resource) {
        if(resource == null)
            throw new IllegalArgumentException("Resource must not be null.");
        this.resource = resource;
    }
    
    private void addMarkerForObject(Object object, IMarker marker) {
        List<IMarker> markers = objectMarkers.get(object);
        if(markers == null) {
            markers = new ArrayList<IMarker>();
            objectMarkers.put(object, markers);
        }
        markers.add(marker);            
    }
    
    @Override
    public void writeResults(Diagnostic diagnostic) {
        for(Diagnostic diagnosticChild: diagnostic.getChildren()) {
            int code = diagnosticChild.getCode();
            String message = diagnosticChild.getMessage();
            List<?> objects = diagnosticChild.getData();
            createMarker(code, message, objects);
        }
    }
    
    private void createMarker(int code, String message, List<?> objects) {
        try {
            IMarker marker = resource.createMarker(MARKER_ID);
            marker.setAttribute(IMarker.SEVERITY, getSeverity(code));
            marker.setAttribute(IMarker.MESSAGE, message);
            
            if(objects == null)
                return;
                
            // Generate string containing uri fragments of all EObjects.
            StringBuilder uriBuilder = new StringBuilder();
            for(Object object: objects) {
                if(!(object instanceof EObject))
                    continue;
                
                EObject eObject = (EObject) object;
                Resource emfResource = eObject.eResource();
                if(emfResource != null) {
                    String uri = emfResource.getURIFragment(eObject);
                    uriBuilder.append(uri).append(URI_FRAGMENTS_SEPARATOR);
                    addMarkerForObject(object, marker);
                }
            }
            
            // Save the result as marker attribute.
            marker.setAttribute(MARKER_PROBLEM_OBJECT_URI, uriBuilder.toString());
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
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
    public void clearResults(Object target) {
        List<IMarker> markers = objectMarkers.remove(target);
        if(markers == null)
            return;
        
        try {
            for(IMarker marker: markers)
                marker.delete();
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void clearAllResults() {
        try {
            objectMarkers.clear();
            resource.deleteMarkers(MARKER_ID, false, IResource.DEPTH_INFINITE);
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
    }

}
