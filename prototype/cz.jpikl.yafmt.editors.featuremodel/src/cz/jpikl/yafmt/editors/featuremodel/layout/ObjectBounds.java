package cz.jpikl.yafmt.editors.featuremodel.layout;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface ObjectBounds extends EObject {

    /**
     * @model
     */
    int getX();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getX <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>X</em>' attribute.
     * @see #getX()
     * @generated
     */
    void setX(int value);

    /**
     * @model
     */
    int getY();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getY <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' attribute.
     * @see #getY()
     * @generated
     */
    void setY(int value);

    /**
     * @model
     */
    int getWidth();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth(int value);

    /**
     * @model
     */
    int getHeight();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight(int value);

    /**
     * @model transient="true" volatile="true"
     */
    Rectangle getBounds();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getBounds <em>Bounds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Bounds</em>' attribute.
     * @see #getBounds()
     * @generated
     */
    void setBounds(Rectangle value);

}
