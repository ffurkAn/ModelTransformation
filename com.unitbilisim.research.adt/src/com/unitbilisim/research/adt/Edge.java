package com.unitbilisim.research.adt;

/**
 * A directed, weighted edge in a graph
 * 
 * @author ffurkan.tanriverdi@gmail.com
 * 		   furkan.tanriverdi@unitbilisim.com
 * @version $Revision$
 * @param <T>
 */
public class Edge<T> {

	private Vertex<T> from;

	private Vertex<T> to;

	private String name;

	/*
	private boolean mark;

	private int cost;
	 */

	public Edge(){

	}

	/**
	 * Create an edge between from and to with the given cost.
	 * 
	 * @param from
	 *          the starting vertex
	 * @param to
	 *          the ending vertex
	 * @param cost
	 *          the cost of the edge
	 */
	public Edge(Vertex<T> from, Vertex<T> to, String name) {
		this.from = from;
		this.to = to;
		this.name = name;
		//mark = false;
	}

	/**
	 * Get the ending vertex
	 * 
	 * @return ending vertex
	 */
	public Vertex<T> getTo() {
		return to;
	}

	/**
	 * Set the target vertex
	 * 
	 * @param Vertex<T>
	 * 					to
	 */
	public void setTo(Vertex<T> to){
		this.to = to;
	}

	/**
	 * Set the source vertex
	 * 
	 * @param Vertex<T>
	 * 					from
	 */
	public void setFrom(Vertex<T> from){
		this.from = from;
	}

	/**
	 * Get the starting vertex
	 * 
	 * @return starting vertex
	 */
	public Vertex<T> getFrom() {
		return from;
	}

	/**
	 * Get the cost of the edge
	 * 
	 * @return cost of the edge
	 */
	//public int getCost()

	/**
	 * Set the cost of edge
	 * 
	 * @param int
	 * 			 cost
	 */
	//public void setCost(int cost)

	/**
	 * Set the mark flag of the edge
	 * 
	 */
	//public void mark() 

	/**
	 * Clear the edge mark flag
	 * 
	 */
	//public void clearMark()

	/**
	 * Get the edge mark flag
	 * 
	 * @return edge mark flag
	 */
	//public boolean isMarked()

	/**
	 * String rep of edge
	 * 
	 * @return string rep with from/to vertex names and cost
	 */
	public String toString() {
		StringBuffer tmp = new StringBuffer("Edge[from: ");
		tmp.append(from.getName());
		tmp.append(",to: ");
		tmp.append(to.getName());
		tmp.append(", name: ");
		tmp.append(name);
		//tmp.append(", cost: ");
		//tmp.append(cost);
		tmp.append("]");
		return tmp.toString();
	}

	/**
	 * Get the name of edge
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of edge
	 * 
	 * @param String
	 * 					name
	 */
	public void setName(String name) {
		this.name = name;
	}
}