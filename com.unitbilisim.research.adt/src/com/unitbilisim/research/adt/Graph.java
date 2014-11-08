package com.unitbilisim.research.adt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph<V,E> {

	private List<Vertex<V>> verticies; 
	private List<Edge<E>> edges;
	private List<List<Integer>> adjacencyList;
	private int lastIndex;
	private String name;



	public Graph(){

		lastIndex = -1;
		verticies = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
		adjacencyList = new ArrayList<List<Integer>>();
		//for (int i = 0; i < lastIndex; i++) 
		//	adjacencyList[i] = new ArrayList<Integer>();
	}

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
	 * @param name -
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

	public void addEdge(String name, int i, int j) {
		if(!hasEdge(i, j)){
			adjacencyList.get(i).add(j);

		}
			
		edges.add(new Edge<E>(name, i, j, adjacencyList.get(i).indexOf(j)));

	}

	public boolean hasEdge(int i, int j) {
		return adjacencyList.get(i).contains(j);
	}

	public int inDegree(int i) {
		int deg = 0;
		for (int j = 0; j < getLastIndex(); j++)
			if (adjacencyList.get(i).contains(i)) 
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

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public List<Edge<E>> getIncomingEdges(Vertex<V> v){

		List<Edge<E>> incomingEdges = new ArrayList<Edge<E>>();

		for(Edge<E> e : edges){

			int target = e.getTo();

			if(findVertexByNumber(target) == v)
			{
				incomingEdges.add(e);
			}
		}
		
		return incomingEdges;

	}
	
	public List<Edge<E>> getOutgoingEdges(Vertex<V> v){
		
		List<Edge<E>> outgoingEdges = new ArrayList<Edge<E>>();

		for(Edge<E> e : edges){

			int target = e.getFrom();

			if(findVertexByNumber(target) == v)
			{
				outgoingEdges.add(e);
			}
		}
		
		return outgoingEdges;

	}
	
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

