/**
 */
package cz.jpikl.yafmt.ui.editors.fm.layout.impl;

import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelLayoutImpl extends EObjectImpl implements ModelLayout {
    /**
     * The cached value of the '{@link #getMapping() <em>Mapping</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapping()
     * @generated
     * @ordered
     */
    protected EMap<EObject, Rectangle> mapping;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModelLayoutImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelLayoutPackage.Literals.MODEL_LAYOUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<EObject, Rectangle> getMapping() {
        if (mapping == null) {
            mapping = new EcoreEMap<EObject,Rectangle>(ModelLayoutPackage.Literals.EOBJECT_TO_BOUNDS, EObjectToBoundsImpl.class, this, ModelLayoutPackage.MODEL_LAYOUT__MAPPING);
        }
        return mapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelLayoutPackage.MODEL_LAYOUT__MAPPING:
                if (coreType) return getMapping();
                else return getMapping().map();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelLayoutPackage.MODEL_LAYOUT__MAPPING:
                return mapping != null && !mapping.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ModelLayoutImpl
