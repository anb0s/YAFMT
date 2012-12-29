/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout.impl;

import cz.jpikl.yafmt.editors.featuremodel.layout.*;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelLayoutFactoryImpl extends EFactoryImpl implements ModelLayoutFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ModelLayoutFactory init() {
        try {
            ModelLayoutFactory theModelLayoutFactory = (ModelLayoutFactory)EPackage.Registry.INSTANCE.getEFactory("https://bitbucket.org/jpikl/yafmt/modellayout.ecore");
            if (theModelLayoutFactory != null) {
                return theModelLayoutFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ModelLayoutFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelLayoutFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ModelLayoutPackage.MODEL_LAYOUT: return createModelLayout();
            case ModelLayoutPackage.OBJECT_BOUNDS: return createObjectBounds();
            case ModelLayoutPackage.OBJECT_LAYOUT: return createObjectLayout();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ModelLayoutPackage.RECTANGLE:
                return createRectangleFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ModelLayoutPackage.RECTANGLE:
                return convertRectangleToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelLayout createModelLayout() {
        ModelLayoutImpl modelLayout = new ModelLayoutImpl();
        return modelLayout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ObjectBounds createObjectBounds() {
        ObjectBoundsImpl objectBounds = new ObjectBoundsImpl();
        return objectBounds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ObjectLayout createObjectLayout() {
        ObjectLayoutImpl objectLayout = new ObjectLayoutImpl();
        return objectLayout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Rectangle createRectangleFromString(EDataType eDataType, String initialValue) {
        return (Rectangle)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertRectangleToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelLayoutPackage getModelLayoutPackage() {
        return (ModelLayoutPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ModelLayoutPackage getPackage() {
        return ModelLayoutPackage.eINSTANCE;
    }

} //ModelLayoutFactoryImpl
