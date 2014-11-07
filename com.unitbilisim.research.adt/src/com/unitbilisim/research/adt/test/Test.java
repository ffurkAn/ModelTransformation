package com.unitbilisim.research.adt.test;

import java.util.List;

import com.unitbilisim.research.adt.Graph;
import com.unitbilisim.research.adt.Vertex;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//
		//
		//
		Graph<String> myGraph = new Graph<String>();
		
		myGraph.addVertex(new Vertex<String>("A","unit"));
		myGraph.addVertex(new Vertex<String>("B","ferhat"));
		myGraph.addVertex(new Vertex<String>("C","omer"));
		myGraph.addVertex(new Vertex<String>("D","furkan"));
		/*
		myGraph.addEdge(myGraph.getVertex(0), myGraph.getVertex(1),0);
		myGraph.addEdge(myGraph.getVertex(0), myGraph.getVertex(2),0);		
		myGraph.addEdge(myGraph.getVertex(1), myGraph.getVertex(2),0);
		myGraph.addEdge(myGraph.getVertex(3), myGraph.getVertex(1),0);	
		myGraph.insertBiEdge(myGraph.findVertexByData("unit", new ComparatorA<String>()), myGraph.findVertexByName("D"), 0);
		*/
		System.out.println(myGraph.findVertexByData("unit", new ComparatorA<String>()).getName());
		System.out.println(myGraph.findVertexByName("D").getName());
		
		@SuppressWarnings("unused")
		List<Vertex<String>> list = myGraph.getVerticies();
		
		/*
		for(Vertex<String> v : list){
			System.out.println(v.getName());
		}
		*/
		
		//System.out.println(myGraph.toString());
		//System.out.println("testing");
		
		//myGraph.dfsSpanningTree(myGraph.getRootVertex(), );
	}

}
