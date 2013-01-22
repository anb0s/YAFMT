/**
 */
package cz.jpikl.yafmt.ui.editors.fm.layout.impl;

import cz.jpikl.yafmt.ui.editors.fm.layout.*;

import java.util.Map;
import java.util.Scanner;

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
            ModelLayoutFactory theModelLayoutFactory = (ModelLayoutFactory)EPackage.Registry.INSTANCE.getEFactory("https://bitbucket.org/jpikl/yafmt/ui/editors/fm/layout"); 
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
            case ModelLayoutPackage.EOBJECT_TO_BOUNDS: return (EObject)createEObjectToBounds();
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
            case ModelLayoutPackage.BOUNDS:
                return createBoundsFromString(eDataType, initialValue);
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
            case ModelLayoutPackage.BOUNDS:
                return convertBoundsToString(eDataType, instanceValue);
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
    public Map.Entry<EObject, Rectangle> createEObjectToBounds() {
        EObjectToBoundsImpl eObjectToBounds = new EObjectToBoundsImpl();
        return eObjectToBounds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Rectangle createBoundsFromString(EDataType eDataType, String initialValue) {
        Scanner scanner = new Scanner(initialValue);
        Rectangle bounds = new Rectangle();
        bounds.x = scanner.nextInt();
        bounds.y = scanner.nextInt();
        bounds.width = scanner.nextInt();
        bounds.height = scanner.nextInt();
        scanner.close();
        return bounds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String convertBoundsToString(EDataType eDataType, Object instanceValue) {
        Rectangle bounds = (Rectangle) instanceValue;
        return String.format("%d %d %d %d", bounds.x, bounds.y, bounds.width, bounds.height);
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
