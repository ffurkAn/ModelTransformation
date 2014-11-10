package com.unitbilisim.research.adt;

import java.util.ArrayList;
import java.util.List;


/**
 * Graph class with adjacency list
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 * @param <V>
 * @param <E>
 */
public class Graph<V,E> {

	/** List to store verticies in graph */
	private List<Vertex<V>> verticies; 

	/** List to store edges in graph */
	private List<Edge<E>> edges;

	/** List to present graph */
	private List<List<Integer>> adjacencyList;

	/** Specifies the last index of verticies */
	private int lastIndex;

	/** Name of graph */
	private String name;


	/**
	 * Construct a new graph without any vertices or edges
	 */
	public Graph(){

		lastIndex = -1;
		verticies = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
		adjacencyList = new ArrayList<List<Integer>>();
		//for (int i = 0; i < lastIndex; i++) 
		//	adjacencyList[i] = new ArrayList<Integer>();
	}

	/**
	 * Returns name of graph
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set graph's name
	 * 
	 * @param String - name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * Returns last index of the adjacency list 
	 *
	 * @return int
	 */
	public int getLastIndex() {
		return lastIndex;
	}

	/**
	 * Update the last index of adjacency list
	 * 
	 * @param int - lastIndex
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	/**
	 * Add a vertex to the graph
	 * 
	 * @param Vertex<V> - v
	 *          the Vertex to add
	 *          
	 * @return void
	 */
	public void addVertex(Vertex<V> v){

		if(findVertexByName(v.getName()) == null){

			//setLastIndex(getLastIndex());

			verticies.add(v);
			lastIndex++;
			v.setNumber(lastIndex);

			adjacencyList.add(new ArrayList<Integer>());
			adjacencyList.get(lastIndex).add(v.getNumber());

		}

	}


	/**
	 * Search the verticies for one with number of vertex.
	 * 
	 * @param int - number
	 *          the vertex number
	 *          
	 * @return the first vertex with a matching number, null if no matches are found
	 */
	public Vertex<V> findVertexByNumber(int number) {
		Vertex<V> match = null;
		for (Vertex<V> v : verticies) {
			if (v.getNumber() == number) {
				match = v;
				break;
			}
		}
		return match;
	}

	/**
	 * Search the verticies for one with name.
	 * 
	 * @param String - name 
	 *          the vertex name
	 * @return the first vertex with a matching name, null if no matches are found
	 */
	public Vertex<V> findVertexByName(String name) {
		Vertex<V> match = null;
		for (Vertex<V> v : verticies) {
			if (name.equals(v.getName())) {
				match = v;
				break;
			}
		}
		return match;
	}

	/**
	 * Insert a directed, weighted Edge<T> into the graph.
	 * 
	 * @param String - name
	 * 			edge's name
	 * 
	 * @param int - from
	 *          starting vertex
	 *          
	 * @param int - to
	 *          ending vertex
	 *          
	 * @return void
	 */
	public void addEdge(String name, int from, int to) {
		if(!hasEdge(from, to)){
			adjacencyList.get(from).add(to);

		}

		edges.add(new Edge<E>(name, from, to, adjacencyList.get(from).indexOf(to)));

	}

	/**
	 * Is there an edge between source and target verticies
	 * 
	 * @param int - from
	 * 			source vertex
	 * 
	 * @param int - to
	 * 			target vertex
	 * 
	 * @return true if there is an edge
	 */
	public boolean hasEdge(int from, int to) {
		return adjacencyList.get(from).contains(to);
	}

	/*
	public int inDegree(int to) {
		int deg = 0;
		for (int from = 0; from < getLastIndex(); from++)
			if (adjacencyList.get(from).contains(to)) 
				deg++;

		return deg;
	}

	public List<Integer> inEdges(int i) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; j < getLastIndex(); j++)
			if (adjacencyList.get(j).contains(i) && j != i)	
				edges.add(j);

		return edges;
	}


	public int nVertices() {
		return getLastIndex();
	}

	public int outDegree(int i) {
		return adjacencyList.get(i).size();
	}

	public List<Integer> outEdges(int i) {
		return adjacencyList.get(i);
	}


	public void removeEdge(int i, int j) {
		Iterator<Integer> it = adjacencyList.get(i).iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}	
	}
	 */


	/**
	 * Get the incoming edges
	 * 
	 * @return incoming edge list
	 */
	public List<Edge<E>> getIncomingEdges(Vertex<V> v){

		List<Edge<E>> incomingEdges = new ArrayList<Edge<E>>();

		for(Edge<E> e : edges){

			int target = e.getTo();

			if(findVertexByNumber(target) == v){
				
				incomingEdges.add(e);
			}
		}

		return incomingEdges;

	}

	/**
	 * 
	 * @return the count of incoming edges
	 */
	public List<Edge<E>> getOutgoingEdges(Vertex<V> v){

		List<Edge<E>> outgoingEdges = new ArrayList<Edge<E>>();

		for(Edge<E> e : edges){

			int target = e.getFrom();

			if(findVertexByNumber(target) == v){
		
				outgoingEdges.add(e);
			}
		}

		return outgoingEdges;
	}

	/**
	 * @return a string form of the vertex with in and out edges.
	 */
	public String toString() {
		
		StringBuffer tmp = new StringBuffer("Graph[\n");

		for (Vertex<V> vertex : verticies){
			
			tmp.append("Vertex(");
			tmp.append(vertex.getName());
			tmp.append("), in:[");

			List<Edge<E>> incomingEdges = getIncomingEdges(vertex);
			
			for (int i = 0; i < incomingEdges.size(); i++ ){

				Vertex<V> sourceVertex = findVertexByNumber(incomingEdges.get(i).getFrom());
				//Edge<E> edge = getEdge(sourceVertex, vertex);

				if (i > 0)
					tmp.append(',');
				//tmp.append(e+"\n");

				tmp.append('{');
				tmp.append("From: ");
				tmp.append(sourceVertex.getName());
				tmp.append(", ");
				tmp.append(incomingEdges.get(i).getName());
				tmp.append(", Cost:");
				tmp.append(incomingEdges.get(i).getCost());
				tmp.append('}');
			}

			tmp.append("], out:[");

			List<Edge<E>> outgoingEdges = getOutgoingEdges(vertex);
			
			for(int i = 0; i < outgoingEdges.size(); i++){

				Vertex<V> targetVertex = findVertexByNumber(outgoingEdges.get(i).getTo());						
				if (i > 0)
					tmp.append(',');
				//tmp.append(e+"\n");

				tmp.append('{');
				tmp.append("To: ");
				tmp.append(targetVertex.getName());
				tmp.append(", ");
				tmp.append(outgoingEdges.get(i).getName());
				tmp.append(", Cost:");
				tmp.append(outgoingEdges.get(i).getCost());
				tmp.append('}');			
			}

			tmp.append(']');
			tmp.append("\n");			
		}

		tmp.append("]");

		return tmp.toString();
	}




	/*
	private Edge<E> getEdge(Vertex<V> vertex, Vertex<V> targetVertex) {
		// TODO Auto-generated method stub

		for(Edge<E> e : edges){

			int target = e.getTo();
			int source = e.getFrom();

			if(findVertexByNumber(source) == vertex && findVertexByNumber(target) == targetVertex)
			{
				return e;
			}
		}

		return null;
	}
	 */


}

