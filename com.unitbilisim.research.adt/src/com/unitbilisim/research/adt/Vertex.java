package com.unitbilisim.research.adt;


/**
 * Vertex class
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 * @param <V>
 */
public class Vertex<V> {

	/** Vertex's name */
	private String name;

	/** Vertex's number (index of vertex on adjacency list) */
	private Integer number;

	/** Data which will be kept by the Vertex */
	private V data;


	/**
	 * Returns name of vertex
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set vertex's name
	 * 
	 * @param String - name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns number of Vertex
	 * 		index of the adjacency list
	 * 
	 * @return Integer
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Set vertex's number
	 * 
	 * @param Integer - number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Returns Data of vertex
	 * 
	 * @return V
	 */
	public V getData() {
		return data;
	}


	/**
	 * Set edge's Data
	 * 
	 * @param V data
	 */
	public void setData(V data) {
		this.data = data;
	}

}