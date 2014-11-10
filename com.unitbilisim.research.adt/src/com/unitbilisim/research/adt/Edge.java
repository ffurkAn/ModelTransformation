package com.unitbilisim.research.adt;


/**
 * Edge class
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 * @param <E>
 */
public class Edge<E> {

	/** Edge's name */
	private String name;
	
	/** Data which will be kept by the Edge */
	private E Data; 

	/** Edge's cost */
	private int cost;

	/** Number of starting vertex */
	private int from;

	/** Number of ending vertex */
	private int to;


	/**
	 * Construct a new Edge 
	 */
	public Edge(String edgeName, int source, int target, int cost){

		name = edgeName;
		setFrom(source);
		setTo(target);
		this.cost = cost;

	}

	/**
	 * Returns name of edge
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set edge's name
	 * 
	 * @param String - name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns Data of edge
	 * 
	 * @return E
	 */
	public E getData() {
		return Data;
	}

	/**
	 * Set edge's Data
	 * 
	 * @param E data
	 */
	public void setData(E data) {
		Data = data;
	}

	/**
	 * Returns cost of edge
	 * 
	 * @return int
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Set edge's cost
	 * 
	 * @param int - cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Returns edge's starting vertex number
	 * 
	 * @return int
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * Set edge's starting vertex number
	 * 
	 * @param int
	 * 			from
	 */
	public void setFrom(int from) {
		this.from = from;
	}

	/**
	 * Returns number of ending vertex of edge
	 * 
	 * @return int
	 */
	public int getTo() {
		return to;
	}

	/**
	 * Set edge's ending vertex number
	 * 
	 * @param int 
	 * 			to
	 */
	public void setTo(int to) {
		this.to = to;
	}  


}
