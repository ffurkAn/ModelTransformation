package test;

import com.unitbilisim.research.adt.Graph;
import com.unitbilisim.research.adt.Vertex;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph<String, String> graph = new Graph<String, String>();
		
		
		Vertex<String> vertex = new Vertex<String>();
		vertex.setName("Ali");
		graph.addVertex(vertex);
		
		Vertex<String> vertex2 = new Vertex<String>();
		vertex2.setName("Veli");
		graph.addVertex(vertex2);
		
		graph.addEdge("Ali->Veli", vertex.getNumber(), vertex2.getNumber());
		
		System.out.println(graph.toString());

		
		
		
	}

}
