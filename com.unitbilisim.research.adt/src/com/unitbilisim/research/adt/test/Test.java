package com.unitbilisim.research.adt.test;

import java.util.ArrayList;
import java.util.List;

import com.unitbilisim.research.adt.Edge;
import com.unitbilisim.research.adt.Graph;
import com.unitbilisim.research.adt.Vertex;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//
		//
		//
		Graph<String> graph = new  Graph<String>(); 
		List<Edge<String>> list = new ArrayList<Edge<String>>();
		
		Edge<String> e1 = new Edge<String>();
		Edge<String> e2 = new Edge<String>();
		Edge<String> e3 = new Edge<String>();
		e1.setName("1");
		e2.setName("2");
		e3.setName("3");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Vertex<String> v1 = new Vertex<String>();
		Vertex<String> v2 = new Vertex<String>();
		Vertex<String> v3 = new Vertex<String>();
		
		v1.setName("v1");
		v3.setName("v3");
		
		v2.setName("v2");
		
		graph.addVertex(v3);
		graph.addVertex(v2);
		graph.addVertex(v1);
		
		for(Edge<String> e : list){
			
			//graph.addEdge(edge);
			graph.addEdge(v1, v2, e.getName());
		}
		
		System.out.println(graph.toString());
		
	}

}
