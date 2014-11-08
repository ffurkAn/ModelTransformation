package com.unitbilisim.research.adt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph<V,E> {

	private List<Vertex<V>> verticies; 
	private List<Edge<E>> edges;
	private List<Integer>[] adjacencyList;
	private static int lastIndex;

	
	
	@SuppressWarnings("unchecked")
	public Graph(){
		
		setLastIndex(0);
		verticies = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
		adjacencyList = (List<Integer>[])new List[getLastIndex()];
		//for (int i = 0; i < lastIndex; i++) 
		//	adjacencyList[i] = new ArrayList<Integer>();
	}
	
	public void addVertex(Vertex<V> v){
		
		if(verticies.contains(findVertexByNumber(v.getNumber())) == false){
			
			setLastIndex(getLastIndex());
			
			verticies.add(v);
			
			adjacencyList[getLastIndex()] = new ArrayList<Integer>();
			adjacencyList[getLastIndex()].add(v.getNumber());
				
		}
		
	}
	
	
	public void addEdge(){
		
		
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
		adjacencyList[i].add(j);
		
		edges.add(new Edge<E>(name, i, j, adjacencyList[i].size()));
		
	}

	public boolean hasEdge(int i, int j) {
		return adjacencyList[i].contains(j);
	}

	public int inDegree(int i) {
		int deg = 0;
		for (int j = 0; j < getLastIndex(); j++)
			if (adjacencyList[j].contains(i)) 
				deg++;
		
		return deg;
	}

	public List<Integer> inEdges(int i) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; j < getLastIndex(); j++)
			if (adjacencyList[j].contains(i))	
				edges.add(j);
		
		return edges;
	}

	public int nVertices() {
		return getLastIndex();
	}

	public int outDegree(int i) {
		return adjacencyList[i].size();
	}

	public List<Integer> outEdges(int i) {
		return adjacencyList[i];
	}

	public void removeEdge(int i, int j) {
		Iterator<Integer> it = adjacencyList[i].iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}	
	}

	public static int getLastIndex() {
		return lastIndex;
	}

	public static void setLastIndex(int lastIndex) {
		Graph.lastIndex = lastIndex;
	}
	
	public String toString() {
	    StringBuffer tmp = new StringBuffer("Graph[\n");
	    
	    for (Vertex<V> vertex : verticies){
	    	tmp.append("Vertex(");
	    	tmp.append(vertex.getName());
	    	tmp.append("), in:[");

	    	List<Integer> incomingEdges = inEdges(vertex.getNumber());
	    	for (int i = 0; i < incomingEdges.size(); i++ ){
	    		
	    		for(Edge<E> e : edges){
	    			
	    			if(e.getFrom() == incomingEdges.get(i) && e.getTo() == vertex.getNumber())
	    			{
	    				
	    				tmp.append(e.getName());
	    				tmp.append("cost:");
	    				tmp.append(e.getCost());
	    			}
	    		}
	    		
	    	}
	    	
	    	List<Integer> outgoingEdges = inEdges(vertex.getNumber());
	    	for(int i = 0; i < outgoingEdges.size(); i++){
	    		
	    		for(Edge<E> e : edges){
	    			
	    			if(e.getTo() == outgoingEdges.get(i) && e.getFrom() == vertex.getNumber()){
	    				
	    				tmp.append(e.getName());
	    				tmp.append("cost:");
	    				tmp.append(e.getCost());
	    			}
	    		}
	    	}
	    	

	    	tmp.append("\n");
	    }
	      
	    tmp.append(']');
	    return tmp.toString();
	  }
	
}

