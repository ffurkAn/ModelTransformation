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
		
		if(verticies.contains(v) == false){
		
			verticies.add(v);
			adjacencyList[getLastIndex()] = new ArrayList<Integer>();
			adjacencyList[getLastIndex()].add(v.getNumber());
			setLastIndex(getLastIndex() + 1);
		}
		
	}
	
	public void addEdge(int i, int j) {
		adjacencyList[i].add(j);
	}

	public boolean hasEdge(int i, int j) {
		return adjacencyList[i].contains(j);
	}

	public int inDegree(int i) {
		int deg = 0;
		for (int j = 0; j < getLastIndex(); j++)
			if (adjacencyList[j].contains(i)) deg++;
		return deg;
	}

	public List<Integer> inEdges(int i) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; j < getLastIndex(); j++)
			if (adjacencyList[j].contains(i))	edges.add(j);
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
	
	
	
}

