/**
 */
package my;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link my.Collection#getOwnedLists <em>Owned Lists</em>}</li>
 *   <li>{@link my.Collection#getOwnedFeatures <em>Owned Features</em>}</li>
 *   <li>{@link my.Collection#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see my.MyPackage#getCollection()
 * @model
 * @generated
 */
public interface Collection extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned Lists</b></em>' containment reference list.
	 * The list contents are of type {@link my.List}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Lists</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Lists</em>' containment reference list.
	 * @see my.MyPackage#getCollection_OwnedLists()
	 * @model containment="true"
	 * @generated
	 */
	EList<List> getOwnedLists();

	/**
	 * Returns the value of the '<em><b>Owned Features</b></em>' containment reference list.
	 * The list contents are of type {@link my.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Features</em>' containment reference list.
	 * @see my.MyPackage#getCollection_OwnedFeatures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getOwnedFeatures();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(int)
	 * @see my.MyPackage#getCollection_Name()
	 * @model
	 * @generated
	 */
	int getName();

	/**
	 * Sets the value of the '{@link my.Collection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(int value);

} // Collection
