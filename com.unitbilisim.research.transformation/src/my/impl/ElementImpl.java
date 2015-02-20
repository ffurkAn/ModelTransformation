/**
 */
package my.impl;

import my.Element;
import my.Feature;
import my.MyPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link my.impl.ElementImpl#getElementFeature <em>Element Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementImpl extends NamedElementImpl implements Element {
	/**
	 * The cached value of the '{@link #getElementFeature() <em>Element Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature elementFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MyPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getElementFeature() {
		if (elementFeature != null && elementFeature.eIsProxy()) {
			InternalEObject oldElementFeature = (InternalEObject)elementFeature;
			elementFeature = (Feature)eResolveProxy(oldElementFeature);
			if (elementFeature != oldElementFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyPackage.ELEMENT__ELEMENT_FEATURE, oldElementFeature, elementFeature));
			}
		}
		return elementFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetElementFeature() {
		return elementFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementFeature(Feature newElementFeature) {
		Feature oldElementFeature = elementFeature;
		elementFeature = newElementFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyPackage.ELEMENT__ELEMENT_FEATURE, oldElementFeature, elementFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MyPackage.ELEMENT__ELEMENT_FEATURE:
				if (resolve) return getElementFeature();
				return basicGetElementFeature();
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
			case MyPackage.ELEMENT__ELEMENT_FEATURE:
				setElementFeature((Feature)newValue);
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
			case MyPackage.ELEMENT__ELEMENT_FEATURE:
				setElementFeature((Feature)null);
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
			case MyPackage.ELEMENT__ELEMENT_FEATURE:
				return elementFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementImpl
