package com.unitbilisim.research.transformation;

import java.io.Externalizable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import com.unitbilisim.research.adt.Edge;
import com.unitbilisim.research.adt.Graph;
import com.unitbilisim.research.adt.Vertex;

public class ConvertEcore2Graph {

	private static Resource resource;

	// This commit line was added and commited from EGit, pushed from git ext.

	static HashMap<EObject,Vertex<String>> hash = new HashMap<EObject, Vertex<String>>();

	// Hash to store Edge and target class name
	static HashMap<String, List<Edge<String>>> referenceMap = new HashMap<String, List<Edge<String>>>();

	public static HashMultimap<String, Edge<String>> multiMap = HashMultimap.create();

	//Multimap<String, Integer> myMap = HashMultimap.create();

	// Get EClasses
	static List<EClass> eClasses = new ArrayList<EClass>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Register the XMI resource factory for the .graph extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("ecore", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		resource = resSet.getResource(URI.createURI("Model/My.ecore"), true);

		// Save the resource
		/*
		try 
		{ 
			//resource.save(System.out, Collections.EMPTY_MAP); 
			resource.save(Collections.EMPTY_MAP); 
		} 
		catch (IOException e) {
			System.out.println("ERROR! Saving Resource ")} 
		 */

		// Get EObjects
		Iterator<EObject> resourceObjects = resource.getAllContents();		

		// Create a new Graph instance
		Graph<String> graph = new Graph<String>();


		// Find all EClass and EAttributes(EAttributes should have different EType)
		// and create corresponding vertex
		while (resourceObjects.hasNext()) {
			Object o = resourceObjects.next();

			if(o instanceof EClass){		

				EClass eClass = (EClass)o;
				Vertex<String> v = EClass2Vertex(eClass,graph);

				
				/*
				for(EReference r : eClass.getEAllReferences()){

					EReference2Edge(r,v,graph,false);
				}
				*/
				
				// 
				
				/*
				for(EReference rContainments : eClass.getEAllContainments()){

					System.out.println(rContainments.getEReferenceType().getName());
					EReference2Edge(rContainments, v, graph, true);
				}
				*/

				for(EAttribute a : eClass.getEAllAttributes()){

					// if there is no vertex named EAttribute's EType in graph
					if(graph.findVertexByName(a.getEType().getName()) == null){

						EAttribute2Vertex(a,graph);
						
					}
					
					Vertex<String> source = hash.get(eClass);
					Vertex<String> target = graph.findVertexByName(a.getEType().getName());

					graph.addEdge(source,target, a.getName());
					
				}
				
				/*
				if(multiMap.containsKey(eClass.getName())){

					Set<Edge<String>> list = multiMap.get(eClass.getName());

					for(Edge<String> e : list){
						
						e.setTo(hash.get(eClass));
						System.out.println(e.getTo().getName());
						//graph.addEdge(edge);
						graph.addEdge(e.getFrom(), hash.get(eClass), e.getName());
					}

				}
				 */





			}





		}
		
		
		for(Vertex<String> v : graph.getVerticies()){
			
			System.out.println(v.toString()+"\n");
			
		}

		/*
		// Adding edges between vertices
		for(EClass c : eClasses){

			for(EReference r : c.getEAllReferences()){

				EReference2Edge(r,c,graph);
			}

			for(EAttribute a : c.getEAllAttributes()){

				Vertex<String> source = hash.get(c);
				Vertex<String> target = graph.findVertexByName(a.getEType().getName());

				graph.addEdge(source,target, a.getName());


			}
		}

		 */

		
		//System.out.println(multiMap.toString());
		// Print the Graph
		System.out.println("\n\n");
		System.out.println(graph.toString());

	}



	private static void EReference2Edge(EReference rContainments,
			Vertex<String> vertex, Graph<String> graph, boolean b) {
		// TODO Auto-generated method stub
		
		Edge<String> edge = new Edge<String>();
		
		// Vertexe gelen referans varsa
		if(b == true){
			
			edge.setTo(vertex);
			edge.setName(rContainments.getName());
			multiMap.put(vertex.getName(), edge);
		}
		// Yoksa
		else{
			
			edge.setFrom(vertex);
			edge.setName(rContainments.getName());
			multiMap.put(vertex.getName(), edge);
		}
		
		//graph.addEdge(edge);
	}
	
	private static void EReference2Edge(EReference r, Vertex<String> vertex,
			Graph<String> graph) {
		// TODO Auto-generated method stub

		Edge<String> edge = new Edge<String>();
		edge.setFrom(vertex);
		edge.setName(r.getName());

		multiMap.put(r.getEReferenceType().getName(), edge);

		//graph.addEdge(edge);


		//
		//
		// Get the source vertex from HashMap
		//Vertex<String> source = hash.get(c);

		// Get the target vertex from HashMap

		//Vertex<String> target = hash.get(r.getEReferenceType()) ;

		// Create and add edge between source and target vertices
		//graph.addEdge(source,target, r.getName());
	}




	private static void addEdge(EAttribute a, EClass eClass, Graph<String> graph) {
		// TODO Auto-generated method stub

		Vertex<String> source = hash.get(eClass);
		Vertex<String> target = hash.get(a);

		/*
		Edge<String> edge = new Edge<String>();
		edge.setFrom(source);
		edge.setTo(target);
		edge.setName(a.getName());
		*/
		
		graph.addEdge(source, target, a.getName());

	}



	private static Vertex<String> EClass2Vertex(EClass eClass, Graph<String> graph) {
		// TODO Auto-generated method stub

		// Create new vertex for EAtt.
		Vertex<String> vertex = new Vertex<String>();
		vertex.setName(eClass.getName());
		graph.addVertex(vertex);

		hash.put(eClass, vertex);

		// Add EClasses to the list in order to iterate later
		//eClasses.add(eClass);

		// Add EAtt. and corresponding vertex to the HashMap
		//hash.put(eClass, vertex);

		return vertex;
	}

	
	private static void EAttribute2Vertex(EAttribute eAttribute, Graph<String> graph) {
		// TODO Auto-generated method stub

		// Create new vertex for EAtt.
		Vertex<String> vertex = new Vertex<String>();
		vertex.setName(eAttribute.getEType().getName());
		graph.addVertex(vertex);

		// Add EAtt. and corresponding vertex to the HashMap
		hash.put(eAttribute, vertex);

	}



}
