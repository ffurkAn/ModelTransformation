package com.unitbilisim.research.adt;

public class Edge<E> {

	private String name; 
	private E Data; 
	private int cost;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public E getData() {
		return Data;
	}

	public void setData(E data) {
		Data = data;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}  
	
}
