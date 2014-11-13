package com.unitbilisim.research.adt;

import java.util.ArrayList;
import java.util.List;

/**
 * A named graph vertex with optional data.
 * 
 * @author ffurkan.tanriverdi@gmail.com
 * 		   furkan.tanriverdi@unitbilisim.com
 * @version $Revision$
 * @param <T>
 */
public class Vertex<T> {

	private List<Edge<T>> incomingEdges;

	private List<Edge<T>> outgoingEdges;

	private String name;

	private boolean mark;

	private int markState;

	private T data;

	/**
	 * Calls this(null, null).
	 */
	public Vertex() {
		this(null, null);
	}

	/**
	 * Create a vertex with the given name and no data
	 * 
	 * @param n
	 */
	public Vertex(String n) {
		this(n, null);
	}

	/**
	 * Create a Vertex with name n and given data
	 * 
	 * @param n -
	 *          name of vertex
	 * @param data -
	 *          data associated with vertex
	 */
	public Vertex(String n, T data) {
		incomingEdges = new ArrayList<Edge<T>>();
		outgoingEdges = new ArrayList<Edge<T>>();
		setName(n);
		mark = false;
		this.data = data;
	}

	/**
	 * @return the possibly null name of the vertex
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of vertex.
	 * 
	 * @param String
	 *          name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the possibly null data of the vertex
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * @param data
	 *          The data to set.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Add an edge to the vertex. If edge.from is this vertex, its an outgoing
	 * edge. If edge.to is this vertex, its an incoming edge. If neither from or
	 * to is this vertex, the edge is not added.
	 * 
	 * @param e -
	 *          the edge to add
	 * @return true if the edge was added, false otherwise
	 */
	public boolean addEdge(Edge<T> e) {
		if (e.getFrom() == this)
			outgoingEdges.add(e);
		else if (e.getTo() == this)
			incomingEdges.add(e);
		else
			return false;
		return true;
	}

	/**
	 * Add an outgoing edge ending at to.
	 * 
	 * @param Vertex<> - 
	 *          the destination vertex
	 * @param String - 
	 *          the edge name
	 */
	// public void addOutgoingEdge(Vertex<T> to, String name) 

	/**
	 * Add an incoming edge starting at from
	 * 
	 * @param Vertex<> -
	 *          the starting vertex
	 * @param String - 
	 *          the edge 
	 */
	// public void addIncomingEdge(Vertex<T> from, String name)


	/**
	 * Check the vertex for either an incoming or outgoing edge mathcing e.
	 * 
	 * @param e
	 *          the edge to check
	 * @return true it has an edge
	 */
	public boolean hasEdge(Edge<T> e) {
		if (e.getFrom() == this)
			return incomingEdges.contains(e);
		else if (e.getTo() == this)
			return outgoingEdges.contains(e);
		else
			return false;
	}

	  /**
	   * Remove an edge from this vertex
	   * 
	   * @param Edge<T> -
	   *          the edge to remove
	   * @return true if the edge was removed, false if the edge was not connected
	   *         to this vertex
	   */
	// public boolean remove(Edge<T> e)

	  /**
	   * 
	   * @return the count of incoming edges
	   */
	//public int getIncomingEdgeCount()

	 /**
	   * Get the ith incoming edge
	   * 
	   * @param int -
	   *          the index into incoming edges
	   * @return ith incoming edge
	   */
	//public Edge<T> getIncomingEdge(int i)

	/**
	 * Get the incoming edges
	 * 
	 * @return incoming edge list
	 */
	public List<Edge<T>> getIncomingEdges() {
		return this.incomingEdges;
	}


	  /**
	   * 
	   * @return the count of incoming edges
	   */
	//public int getOutgoingEdgeCount() 

	 /**
	   * Get the ith outgoing edge
	   * 
	   * @param i
	   *          the index into outgoing edges
	   * @return ith outgoing edge
	   */
	// public Edge<T> getOutgoingEdge(int i)
	
	/**
	 * Get the outgoing edges
	 * 
	 * @return outgoing edge list
	 */
	public List<Edge<T>> getOutgoingEdges() {
		return this.outgoingEdges;
	}

	/**
	 * Search the outgoing edges looking for an edge whose's edge.to == dest.
	 * 
	 * @param dest
	 *          the destination
	 * @return the outgoing edge going to dest if one exists, null otherwise.
	 */
	//public Edge<T> findEdge(Vertex<T> dest)


	/**
	 * Search the outgoing edges for a match to e.
	 * 
	 * @param e -
	 *          the edge to check
	 * @return e if its a member of the outgoing edges, null otherwise.
	 */
	public Edge<T> findEdge(Edge<T> e) {
		if (outgoingEdges.contains(e)){

			return e;
		}

		else if(incomingEdges.contains(e)){

			return e;
		}

		else{

			return null;
		}

	}

	/**
	 * What is the cost from this vertext to the dest vertex.
	 * 
	 * @param dest -
	 *          the destination vertex.
	 * @return Return Integer.MAX_VALUE if we have no edge to dest, 0 if dest is
	 *         this vertex, the cost of the outgoing edge otherwise.
	 */
	// public int cost(Vertex<T> dest)

	/**
	 * Is there an outgoing edge ending at dest.
	 * 
	 * @param dest -
	 *          the vertex to check
	 * @return true if there is an outgoing edge ending at vertex, false
	 *         otherwise.
	 */
	//public boolean hasEdge(Vertex<T> dest) 

	/**
	 * Has this vertex been marked during a visit
	 * 
	 * @return true is visit has been called
	 */
	//public boolean visited()

	/**
	 * Set the vertex mark flag.
	 * 
	 */
	//public void mark() 

	/**
	 * Set the mark state to state.
	 * 
	 * @param state
	 *          the state
	 */
	//public void setMarkState(int state)

	/**
	 * Get the mark state value.
	 * 
	 * @return the mark state
	 */
	//public int getMarkState()

	/**
	 * Visit the vertex and set the mark flag to true.
	 * 
	 */
	//public void visit()

	/**
	 * Clear the visited mark flag.
	 * 
	 */
	//public void clearMark()

	/**
	 * @return a string form of the vertex with in and out edges.
	 */
	public String toString() {
		StringBuffer tmp = new StringBuffer("Vertex(");
		tmp.append(getName());
		//tmp.append(", data=");
		//tmp.append(data);
		tmp.append("), in:[");
		for (int i = 0; i < incomingEdges.size(); i++) {
			Edge<T> e = incomingEdges.get(i);
			if (i > 0)
				tmp.append(',');
			//tmp.append(e+"\n");

			tmp.append('{');
			tmp.append(e.getFrom().getName());
			tmp.append(',');
			tmp.append(e.getName());
			tmp.append('}');

		}
		tmp.append("], out:[");
		for (int i = 0; i < outgoingEdges.size(); i++) {
			Edge<T> e = outgoingEdges.get(i);
			if (i > 0)
				tmp.append(',');

			//tmp.append(e+"\n");

			tmp.append('{');
			tmp.append(e.getTo().getName());
			tmp.append(',');
			tmp.append(e.getName());
			tmp.append('}');

		}
		tmp.append(']');
		return tmp.toString();
	}


}