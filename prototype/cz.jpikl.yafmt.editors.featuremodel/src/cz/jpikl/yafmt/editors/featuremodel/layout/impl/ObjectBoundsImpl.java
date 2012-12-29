/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout.impl;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Bounds</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl#getX <em>X</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl#getY <em>Y</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl#getBounds <em>Bounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectBoundsImpl extends EObjectImpl implements ObjectBounds {
    /**
     * The default value of the '{@link #getX() <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getX()
     * @generated
     * @ordered
     */
    protected static final int X_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getX() <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getX()
     * @generated
     * @ordered
     */
    protected int x = X_EDEFAULT;

    /**
     * The default value of the '{@link #getY() <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getY()
     * @generated
     * @ordered
     */
    protected static final int Y_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getY()
     * @generated
     * @ordered
     */
    protected int y = Y_EDEFAULT;

    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final int WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected int width = WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final int HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected int height = HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getBounds() <em>Bounds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBounds()
     * @generated
     * @ordered
     */
    protected static final Rectangle BOUNDS_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ObjectBoundsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelLayoutPackage.Literals.OBJECT_BOUNDS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getX() {
        return x;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setX(int newX) {
        int oldX = x;
        x = newX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_BOUNDS__X, oldX, x));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getY() {
        return y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setY(int newY) {
        int oldY = y;
        y = newY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_BOUNDS__Y, oldY, y));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getWidth() {
        return width;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidth(int newWidth) {
        int oldWidth = width;
        width = newWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_BOUNDS__WIDTH, oldWidth, width));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getHeight() {
        return height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeight(int newHeight) {
        int oldHeight = height;
        height = newHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_BOUNDS__HEIGHT, oldHeight, height));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setBounds(Rectangle bounds) {
        x = bounds.x();
        y = bounds.y();
        width = bounds.width();
        height = bounds.height();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelLayoutPackage.OBJECT_BOUNDS__X:
                return getX();
            case ModelLayoutPackage.OBJECT_BOUNDS__Y:
                return getY();
            case ModelLayoutPackage.OBJECT_BOUNDS__WIDTH:
                return getWidth();
            case ModelLayoutPackage.OBJECT_BOUNDS__HEIGHT:
                return getHeight();
            case ModelLayoutPackage.OBJECT_BOUNDS__BOUNDS:
                return getBounds();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelLayoutPackage.OBJECT_BOUNDS__X:
                setX((Integer)newValue);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__Y:
                setY((Integer)newValue);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__WIDTH:
                setWidth((Integer)newValue);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__HEIGHT:
                setHeight((Integer)newValue);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__BOUNDS:
                setBounds((Rectangle)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelLayoutPackage.OBJECT_BOUNDS__X:
                setX(X_EDEFAULT);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__Y:
                setY(Y_EDEFAULT);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__WIDTH:
                setWidth(WIDTH_EDEFAULT);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__HEIGHT:
                setHeight(HEIGHT_EDEFAULT);
                return;
            case ModelLayoutPackage.OBJECT_BOUNDS__BOUNDS:
                setBounds(BOUNDS_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelLayoutPackage.OBJECT_BOUNDS__X:
                return x != X_EDEFAULT;
            case ModelLayoutPackage.OBJECT_BOUNDS__Y:
                return y != Y_EDEFAULT;
            case ModelLayoutPackage.OBJECT_BOUNDS__WIDTH:
                return width != WIDTH_EDEFAULT;
            case ModelLayoutPackage.OBJECT_BOUNDS__HEIGHT:
                return height != HEIGHT_EDEFAULT;
            case ModelLayoutPackage.OBJECT_BOUNDS__BOUNDS:
                return BOUNDS_EDEFAULT == null ? getBounds() != null : !BOUNDS_EDEFAULT.equals(getBounds());
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (x: ");
        result.append(x);
        result.append(", y: ");
        result.append(y);
        result.append(", width: ");
        result.append(width);
        result.append(", height: ");
        result.append(height);
        result.append(')');
        return result.toString();
    }

} //ObjectBoundsImpl
