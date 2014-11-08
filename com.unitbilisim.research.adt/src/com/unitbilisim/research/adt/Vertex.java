package com.unitbilisim.research.adt;


/**
 * Vertex class
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 * @param <V>
 */
public class Vertex<V> {

	private String name; 
	private Integer number; //index
	private V data;
	

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public V getData() {
		return data;
	}

	public void setData(V data) {
		this.data = data;
	}
	
}