package cz.jpikl.yafmt.ui.editors.fm.parts;

import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__LOWER;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__UPPER;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.GROUP__FEATURES;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.GROUP__LOWER;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.GROUP__UPPER;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.validation.fm.FeatureModelValidator;
import cz.jpikl.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionCreationPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.GroupEditPolicy;
import cz.jpikl.yafmt.ui.figures.MiddlePointAnchor;
import cz.jpikl.yafmt.ui.validation.IProblemStore;

public class GroupEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private Group group;
    private Adapter groupAdapter;
    private LayoutData layoutData;
    private IProblemStore problemStore;

    public GroupEditPart(Group group, LayoutData layoutData, IProblemStore problemStore) {
        this.group = group;
        this.groupAdapter = new GroupAdapter();
        this.layoutData = layoutData;
        this.problemStore = problemStore;
        setModel(group);
    }

    // ===================================================================
    //  Initialization
    // ===================================================================

    @Override
    public void activate() {
        super.activate();
        group.eAdapters().add(groupAdapter);
        revalidateModel();
        refreshLayoutData();
        refreshVisuals();
    }

    @Override
    public void deactivate() {
        problemStore.clearProblems(group);
        group.eAdapters().remove(groupAdapter);
        super.deactivate();
    }

    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    protected IFigure createFigure() {
        return new GroupFigure(group, layoutData);
    }

    public GroupFigure getFigure() {
        return (GroupFigure) super.getFigure();
    }

    @Override
    protected void refreshVisuals() {
        GroupFigure figure = getFigure();
        figure.setErrors(problemStore.getProblems(group));
        figure.refresh();
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new MiddlePointAnchor(getFigure());
    }

    // ===================================================================
    //  Layout
    // ===================================================================
    
    public LayoutData getLayoutData() {
        return layoutData;
    }
    
    private void refreshLayoutData() {
        Rectangle bounds = layoutData.get(group);
        if(bounds == null)
            bounds = createInitialLayoutData();
        layoutData.set(group, bounds);
    }

    private Rectangle createInitialLayoutData() {
        Rectangle parentBounds = layoutData.get(group.getParent());
        if(parentBounds == null)
            return new Rectangle(0, 0, GroupFigure.SIZE, GroupFigure.SIZE);
        int x = parentBounds.x + (parentBounds.width - GroupFigure.SIZE) / 2;
        int y = parentBounds.y + parentBounds.height - (GroupFigure.SIZE / 2);
        return new Rectangle(x, y, GroupFigure.SIZE, GroupFigure.SIZE);

    }

    // ===================================================================
    //  Model
    // ===================================================================

    private void revalidateModel() {
        problemStore.clearProblems(group);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(group, diagnostic))
            problemStore.readProblems(diagnostic);
    }

    @Override
    protected List<Object> getModelTargetConnections() {
        if(group.getFeatures().isEmpty())
            return null;

        List<Object> connections = new ArrayList<Object>();
        for(Feature child: group.getFeatures())
            connections.add(new Connection(group, child));
        return connections;
    }

    // ===================================================================
    //  Policies
    // ===================================================================

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new GroupEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectionCreationPolicy());
    }

    // ===================================================================
    //  Events
    // ===================================================================

    class GroupAdapter extends EContentAdapter {

        @Override
        protected void addAdapter(Notifier notifier) {
            // Listen only to children features changes.
            if((notifier instanceof Feature) && ((Feature) notifier).getParentGroup() == group)
                super.addAdapter(notifier);
        }

        @Override
        public void notifyChanged(Notification msg) {
            if(msg.getNotifier() instanceof Group)
                notifyChangedFromGroup(msg);
            else
                notifyChangedFromFeature(msg);
        }
        
        private void notifyChangedFromFeature(Notification msg) {
            switch(msg.getFeatureID(Feature.class)) {
                case FEATURE__LOWER:
                case FEATURE__UPPER:
                    revalidateModel();
                    refreshVisuals();
                    break;
            }
        }

        private void notifyChangedFromGroup(Notification msg) {
            switch(msg.getFeatureID(Group.class)) {
                case GROUP__LOWER:
                case GROUP__UPPER:
                case GROUP__FEATURES:
                    revalidateModel();
                    refreshVisuals();
                    break;
            }
        }

    }

}
