package com.unitbilisim.research.adt;


public class Vertex<V> {

	private String name; 
	private Integer number;
	private V data;
	private Vertex<V> from;
	private Vertex<V> to;
	
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

	public Vertex<V> getFrom() {
		return from;
	}

	public void setFrom(Vertex<V> from) {
		this.from = from;
	}

	public Vertex<V> getTo() {
		return to;
	}

	public void setTo(Vertex<V> to) {
		this.to = to;
	}

	
}