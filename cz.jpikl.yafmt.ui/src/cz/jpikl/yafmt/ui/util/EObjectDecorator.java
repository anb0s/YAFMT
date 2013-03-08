package cz.jpikl.yafmt.ui.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class EObjectDecorator implements EObject {

    private EObject decoratedObject;

    public EObjectDecorator(EObject object) {
        this.decoratedObject = object;
    }

    public EObject getDecoratedEObject() {
        return decoratedObject;
    }

    @Override
    public EList<Adapter> eAdapters() {
        return decoratedObject.eAdapters();
    }

    @Override
    public boolean eDeliver() {
        return decoratedObject.eDeliver();
    }

    @Override
    public void eSetDeliver(boolean deliver) {
        decoratedObject.eSetDeliver(deliver);
    }

    @Override
    public void eNotify(Notification notification) {
        decoratedObject.eNotify(notification);
    }

    @Override
    public EClass eClass() {
        return decoratedObject.eClass();
    }

    @Override
    public Resource eResource() {
        return decoratedObject.eResource();
    }

    @Override
    public EObject eContainer() {
        return decoratedObject.eContainer();
    }

    @Override
    public EStructuralFeature eContainingFeature() {
        return eContainingFeature();
    }

    @Override
    public EReference eContainmentFeature() {
        return eContainmentFeature();
    }

    @Override
    public EList<EObject> eContents() {
        return decoratedObject.eContents();
    }

    @Override
    public TreeIterator<EObject> eAllContents() {
        return decoratedObject.eAllContents();
    }

    @Override
    public boolean eIsProxy() {
        return decoratedObject.eIsProxy();
    }

    @Override
    public EList<EObject> eCrossReferences() {
        return decoratedObject.eCrossReferences();
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
        return decoratedObject.eGet(feature);
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return decoratedObject.eGet(feature, resolve);
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        decoratedObject.eSet(feature, newValue);
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return decoratedObject.eIsSet(feature);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        decoratedObject.eUnset(feature);
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
        return decoratedObject.eInvoke(operation, arguments);
    }

}
