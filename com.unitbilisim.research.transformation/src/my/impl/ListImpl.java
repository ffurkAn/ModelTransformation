/**
 */
package my.impl;

import java.util.Collection;

import my.Element;
import my.Feature;
import my.List;
import my.MyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link my.impl.ListImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link my.impl.ListImpl#getListFeatures <em>List Features</em>}</li>
 *   <li>{@link my.impl.ListImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListImpl extends NamedElementImpl implements List {
	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> ownedElements;

	/**
	 * The cached value of the '{@link #getListFeatures() <em>List Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> listFeatures;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SÝZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SÝZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MyPackage.Literals.LÝST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getOwnedElements() {
		if (ownedElements == null) {
			ownedElements = new EObjectContainmentEList<Element>(Element.class, this, MyPackage.LÝST__OWNED_ELEMENTS);
		}
		return ownedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getListFeatures() {
		if (listFeatures == null) {
			listFeatures = new EObjectResolvingEList<Feature>(Feature.class, this, MyPackage.LÝST__LÝST_FEATURES);
		}
		return listFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyPackage.LÝST__SÝZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MyPackage.LÝST__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MyPackage.LÝST__OWNED_ELEMENTS:
				return getOwnedElements();
			case MyPackage.LÝST__LÝST_FEATURES:
				return getListFeatures();
			case MyPackage.LÝST__SÝZE:
				return getSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MyPackage.LÝST__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends Element>)newValue);
				return;
			case MyPackage.LÝST__LÝST_FEATURES:
				getListFeatures().clear();
				getListFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case MyPackage.LÝST__SÝZE:
				setSize((Integer)newValue);
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
			case MyPackage.LÝST__OWNED_ELEMENTS:
				getOwnedElements().clear();
				return;
			case MyPackage.LÝST__LÝST_FEATURES:
				getListFeatures().clear();
				return;
			case MyPackage.LÝST__SÝZE:
				setSize(SÝZE_EDEFAULT);
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
			case MyPackage.LÝST__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
			case MyPackage.LÝST__LÝST_FEATURES:
				return listFeatures != null && !listFeatures.isEmpty();
			case MyPackage.LÝST__SÝZE:
				return size != SÝZE_EDEFAULT;
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
		result.append(" (Size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //ListImpl
