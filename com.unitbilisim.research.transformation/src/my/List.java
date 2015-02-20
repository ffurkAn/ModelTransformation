/**
 */
package my;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link my.List#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link my.List#getListFeatures <em>List Features</em>}</li>
 *   <li>{@link my.List#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see my.MyPackage#getList()
 * @model
 * @generated
 */
public interface List extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link my.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see my.MyPackage#getList_OwnedElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getOwnedElements();

	/**
	 * Returns the value of the '<em><b>List Features</b></em>' reference list.
	 * The list contents are of type {@link my.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Features</em>' reference list.
	 * @see my.MyPackage#getList_ListFeatures()
	 * @model
	 * @generated
	 */
	EList<Feature> getListFeatures();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see my.MyPackage#getList_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link my.List#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

} // List
