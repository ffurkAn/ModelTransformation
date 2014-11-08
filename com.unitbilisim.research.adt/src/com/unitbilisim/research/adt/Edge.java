package com.unitbilisim.research.adt;


/**
 * Edge class
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 * @param <E>
 */
public class Edge<E> {

	private String name; 
	private int number;
	private E Data; 
	private int cost;
	private int from;
	private int to;

	public Edge(String edgeName, int source, int target, int cost){
		
		name = edgeName;
		setFrom(source);
		setTo(target);
		this.cost = cost;
				
	}
	
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}  
	

}
