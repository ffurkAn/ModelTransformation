/**
 */
package my;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link my.Element#getElementFeature <em>Element Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see my.MyPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Element Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Feature</em>' reference.
	 * @see #setElementFeature(Feature)
	 * @see my.MyPackage#getElement_ElementFeature()
	 * @model
	 * @generated
	 */
	Feature getElementFeature();

	/**
	 * Sets the value of the '{@link my.Element#getElementFeature <em>Element Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Feature</em>' reference.
	 * @see #getElementFeature()
	 * @generated
	 */
	void setElementFeature(Feature value);

} // Element
