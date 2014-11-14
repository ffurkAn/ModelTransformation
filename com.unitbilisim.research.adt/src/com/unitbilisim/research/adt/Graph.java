package com.unitbilisim.research.adt;

import java.util.ArrayList;
import java.util.List;

/**
 * A directed graph data structure.
 * 
 * @author ffurkan.tanriverdi@gmail.com,
 * 		   furkan.tanriverdi@unitbilisim.com
 * @version $Revision$
 * @param <T>
 */
public class Graph<T> {

	/*
	public static final int VISIT_COLOR_WHITE = 1;

	public static final int VISIT_COLOR_GREY = 2;

	public static final int VISIT_COLOR_BLACK = 3;
*/
	
	/** Vector<Vertex> of graph verticies */
	private List<Vertex<T>> verticies;

	/** Vector<Edge> of edges in the graph */
	private List<Edge<T>> edges;

	/** The vertex identified as the root of the graph */
	@SuppressWarnings("unused")
	private Vertex<T> rootVertex;

	/**
	 * Construct a new graph without any vertices or edges
	 */
	public Graph() {
		verticies = new ArrayList<Vertex<T>>();
		edges = new ArrayList<Edge<T>>();
	}

	public void addEdge(Edge<T> edge){
		if(edges.contains(edge) == false)
			edges.add(edge);
	}

	/**
	   * Are there any verticies in the graph
	   * 
	   * @return true if there are no verticies in the graph
	   */
	// public boolean isEmpty() 

	/**
	 * Add a vertex to the graph
	 * 
	 * @param v
	 *          the Vertex to add
	 * @return true if the vertex was added, false if it was already in the graph.
	 */
	public boolean addVertex(Vertex<T> v) {
		boolean added = false;
		if (verticies.contains(v) == false) {
			added = verticies.add(v);
		}
		return added;
	}
	
	/**
	   * Are there any verticies in the graph
	   * 
	   * @return true if there are no verticies in the graph
	   */
	// public int size()

	  /**
	   * Get the root vertex
	   * 
	   * @return the root vertex if one is set, null if no vertex has been set as
	   *         the root.
	   */
	// public Vertex<T> getRootVertex()

	  /**
	   * Set a root vertex. If root does no exist in the graph it is added.
	   * 
	   * @param root -
	   *          the vertex to set as the root and optionally add if it does not
	   *          exist in the graph.
	   */
	// public void setRootVertex(Vertex<T> root)

	  /**
	   * Get the given Vertex.
	   * 
	   * @param n
	   *          the index [0, size()-1] of the Vertex to access
	   * @return the nth Vertex
	   */
	// public Vertex<T> getVertex(int n)

	/**
	 * Get the graph verticies
	 * 
	 * @return the graph verticies
	 */
	public List<Vertex<T>> getVerticies() {
		return this.verticies;
	}

	/**
	 * Insert a directed edge, if there was not added before.
	 * 
	 * @param from -
	 *          the Edge<T> starting vertex
	 * @param to -
	 *          the Edge<T> ending vertex
	 * @param cost -
	 *          the Edge<T> weight/cost
	 * @return true if the Edge<T> was added, false if from already has this Edge<T>
	 * @throws IllegalArgumentException
	 *           if from/to are not verticies in the graph
	 */
	public boolean addEdge(Vertex<T> from, Vertex<T> to, String name) throws IllegalArgumentException {
		if (verticies.contains(from) == false)
			throw new IllegalArgumentException("from is not in graph");
		if (verticies.contains(to) == false)
			throw new IllegalArgumentException("to is not in graph");

		Edge<T> e = new Edge<T>(from, to, name);

		// If there is an edge between to verticies with same name, no matter the direction
		if (from.findEdge(e) != null)
			return false;

		// If there is not
		else {

			from.addEdge(e);

			if(from != to){

				to.addEdge(e);
			}

			edges.add(e);
			return true;
		}
	}

	/**
	 * Insert a bidirectional Edge<T> in the graph
	 * 
	 * @param from -
	 *          the Edge<T> starting vertex
	 * @param to -
	 *          the Edge<T> ending vertex
	 * @param cost -
	 *          the Edge<T> weight/cost
	 * @return true if edges between both nodes were added, false otherwise
	 * @throws IllegalArgumentException
	 *           if from/to are not verticies in the graph
	 */
	public boolean insertBiEdge(Vertex<T> from, Vertex<T> to, String name)
			throws IllegalArgumentException {
		return addEdge(from, to, name) && addEdge(to, from, name);
	}

	/**
	 * Get the graph edges
	 * 
	 * @return the graph edges
	 */
	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	  /**
	   * Remove a vertex from the graph
	   * 
	   * @param v
	   *          the Vertex to remove
	   * @return true if the Vertex was removed
	   */
	// public boolean removeVertex(Vertex<T> v)

	  /**
	   * Remove an Edge<T> from the graph
	   * 
	   * @param from -
	   *          the Edge<T> starting vertex
	   * @param to -
	   *          the Edge<T> ending vertex
	   * @return true if the Edge<T> exists, false otherwise
	   */
	// public boolean removeEdge(Vertex<T> from, Vertex<T> to)

	  /**
	   * Clear the mark state of all verticies in the graph by calling clearMark()
	   * on all verticies.
	   * 
	   * @see Vertex#clearMark()
	   */
	// public void clearMark()

	/**
	   * Clear the mark state of all edges in the graph by calling clearMark() on
	   * all edges.
	   */
	// public void clearEdges()


	  /**
	   * Perform a depth first serach using recursion.
	   * 
	   * @param v -
	   *          the Vertex to start the search from
	   * @param visitor -
	   *          the vistor to inform prior to
	   * @see Visitor#visit(Graph, Vertex)
	   */
	// public void depthFirstSearch(Vertex<T> v, final Visitor<T> visitor) 

	  /**
	   * Perform a depth first serach using recursion. The search may be cut short
	   * if the visitor throws an exception.
	   * 
	   * @param <E>
	   * 
	   * @param v -
	   *          the Vertex to start the search from
	   * @param visitor -
	   *          the vistor to inform prior to
	   * @see Visitor#visit(Graph, Vertex)
	   * @throws E
	   *           if visitor.visit throws an exception
	   */
	// public <E extends Exception> void depthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor) throws E 

  /**
   * Perform a breadth first search of this graph, starting at v.
   * 
   * @param v -
   *          the search starting point
   * @param visitor -
   *          the vistor whose vist method is called prior to visting a vertex.
   */
	// public void breadthFirstSearch(Vertex<T> v, final Visitor<T> visitor)
	
	  /**
	   * Perform a breadth first search of this graph, starting at v. The vist may
	   * be cut short if visitor throws an exception during a vist callback.
	   * 
	   * @param <E>
	   * 
	   * @param v -
	   *          the search starting point
	   * @param visitor -
	   *          the vistor whose vist method is called prior to visting a vertex.
	   * @throws E
	   *           if vistor.visit throws an exception
	   */
	// public <E extends Exception> void breadthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor)
	//		throws E 

	  /**
	   * Find the spanning tree using a DFS starting from v.
	   * 
	   * @param v -
	   *          the vertex to start the search from
	   * @param visitor -
	   *          visitor invoked after each vertex is visited and an edge is added
	   *          to the tree.
	   */
	// public void dfsSpanningTree(Vertex<T> v, DFSVisitor<T> visitor)

	/**
	 * Search the verticies for one with name.
	 * 
	 * @param name -
	 *          the vertex name
	 * @return the first vertex with a matching name, null if no matches are found
	 */
	public Vertex<T> findVertexByName(String name) {
		Vertex<T> match = null;
		for (Vertex<T> v : verticies) {
			if (name.equals(v.getName())) {
				match = v;
				break;
			}
		}
		return match;
	}

	  /**
	   * Search the verticies for one with data.
	   * 
	   * @param data -
	   *          the vertex data to match
	   * @param compare -
	   *          the comparator to perform the match
	   * @return the first vertex with a matching data, null if no matches are found
	   */
	// public Vertex<T> findVertexByData(T data, Comparator<T> compare)

	  /**
	   * Search the graph for cycles. In order to detect cycles, we use a modified
	   * depth first search called a colored DFS. All nodes are initially marked
	   * white. When a node is encountered, it is marked grey, and when its
	   * descendants are completely visited, it is marked black. If a grey node is
	   * ever encountered, then there is a cycle.
	   * 
	   * @return the edges that form cycles in the graph. The array will be empty if
	   *         there are no cycles.
	   */
	// public Edge<T>[] findCycles()
	
	// private void visit(Vertex<T> v, ArrayList<Edge<T>> cycleEdges)
	
	public String toString() {
		StringBuffer tmp = new StringBuffer("Graph[\n");
		for (Vertex<T> v : verticies)
			tmp.append(v+"\n");
		tmp.append(']');
		return tmp.toString();
	}

}
