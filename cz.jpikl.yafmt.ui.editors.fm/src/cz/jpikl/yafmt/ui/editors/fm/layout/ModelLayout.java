/**
 */
package cz.jpikl.yafmt.ui.editors.fm.layout;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage#getModelLayout()
 * @model
 * @generated
 */
public interface ModelLayout extends EObject {
    /**
     * Returns the value of the '<em><b>Mapping</b></em>' map.
     * The key is of type {@link org.eclipse.emf.ecore.EObject},
     * and the value is of type {@link org.eclipse.draw2d.geometry.Rectangle},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping</em>' map.
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage#getModelLayout_Mapping()
     * @model mapType="cz.jpikl.yafmt.ui.editors.fm.layout.EObjectToBounds<org.eclipse.emf.ecore.EObject, cz.jpikl.yafmt.ui.editors.fm.layout.Bounds>" changeable="false"
     * @generated
     */
    EMap<EObject, Rectangle> getMapping();

} // ModelLayout
