/**
 */
package my.impl;

import my.Collection;
import my.Feature;
import my.List;
import my.MyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link my.impl.CollectionImpl#getOwnedLists <em>Owned Lists</em>}</li>
 *   <li>{@link my.impl.CollectionImpl#getOwnedFeatures <em>Owned Features</em>}</li>
 *   <li>{@link my.impl.CollectionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionImpl extends MinimalEObjectImpl.Container implements Collection {
	/**
	 * The cached value of the '{@link #getOwnedLists() <em>Owned Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLists()
	 * @generated
	 * @ordered
	 */
	protected EList<List> ownedLists;

	/**
	 * The cached value of the '{@link #getOwnedFeatures() <em>Owned Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> ownedFeatures;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final int NAME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected int name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MyPackage.Literals.COLLECTÝON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<List> getOwnedLists() {
		if (ownedLists == null) {
			ownedLists = new EObjectContainmentEList<List>(List.class, this, MyPackage.COLLECTÝON__OWNED_LÝSTS);
		}
		return ownedLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getOwnedFeatures() {
		if (ownedFeatures == null) {
			ownedFeatures = new EObjectContainmentEList<Feature>(Feature.class, this, MyPackage.COLLECTÝON__OWNED_FEATURES);
		}
		return ownedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(int newName) {
		int oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyPackage.COLLECTÝON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MyPackage.COLLECTÝON__OWNED_LÝSTS:
				return ((InternalEList<?>)getOwnedLists()).basicRemove(otherEnd, msgs);
			case MyPackage.COLLECTÝON__OWNED_FEATURES:
				return ((InternalEList<?>)getOwnedFeatures()).basicRemove(otherEnd, msgs);
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
			case MyPackage.COLLECTÝON__OWNED_LÝSTS:
				return getOwnedLists();
			case MyPackage.COLLECTÝON__OWNED_FEATURES:
				return getOwnedFeatures();
			case MyPackage.COLLECTÝON__NAME:
				return getName();
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
			case MyPackage.COLLECTÝON__OWNED_LÝSTS:
				getOwnedLists().clear();
				getOwnedLists().addAll((java.util.Collection<? extends List>)newValue);
				return;
			case MyPackage.COLLECTÝON__OWNED_FEATURES:
				getOwnedFeatures().clear();
				getOwnedFeatures().addAll((java.util.Collection<? extends Feature>)newValue);
				return;
			case MyPackage.COLLECTÝON__NAME:
				setName((Integer)newValue);
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
			case MyPackage.COLLECTÝON__OWNED_LÝSTS:
				getOwnedLists().clear();
				return;
			case MyPackage.COLLECTÝON__OWNED_FEATURES:
				getOwnedFeatures().clear();
				return;
			case MyPackage.COLLECTÝON__NAME:
				setName(NAME_EDEFAULT);
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
			case MyPackage.COLLECTÝON__OWNED_LÝSTS:
				return ownedLists != null && !ownedLists.isEmpty();
			case MyPackage.COLLECTÝON__OWNED_FEATURES:
				return ownedFeatures != null && !ownedFeatures.isEmpty();
			case MyPackage.COLLECTÝON__NAME:
				return name != NAME_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CollectionImpl
