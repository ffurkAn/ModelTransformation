package com.unitbilisim.research.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.unitbilisim.research.adt.Graph;
import com.unitbilisim.research.adt.Vertex;


/**
 * A class to 
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 */
public class ConvertEcore2Graph {

	/** Resource instance to keep ecore content */
	private static Resource resource;

	/** Map to store EObjects as keys and Verticies as values */
	static HashMap<EObject,Vertex<String>> hash = new HashMap<EObject, Vertex<String>>();

	/** List to store EClasses */
	static List<EClass> eClasses = new ArrayList<EClass>();


	public static void main(String[] args) {

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

		/** Iterator to store EObjects in *.ecore file */
		Iterator<EObject> resourceObjects = resource.getAllContents();		

		// Create a new Graph instance
		Graph<String, String> graph = new Graph<String, String>();


		// Find all EClass and EAttributes(EAttributes should have different EType)
		// and create corresponding vertex
		while (resourceObjects.hasNext()) {
			Object o = resourceObjects.next();

			if(o instanceof EPackage){

				graph.setName(((EPackage) o).getName());
			}

			if(o instanceof EClass){		

				EClass2Node(o,graph);
			}

			if(o instanceof EAttribute){	

				// if there is no vertex named EAttribute's EType in graph
				if(graph.findVertexByName(((EAttribute) o).getEType().getName()) == null){

					EAttribute2Node(o,graph);
				}
			}
		}

		// Adding edges between vertices
		for(EClass c : eClasses){

			for(EReference r : c.getEAllReferences()){

				EReference2Edge(r,c,graph);
			}

			for(EAttribute a : c.getEAllAttributes()){

				Vertex<String> source = hash.get(c);
				Vertex<String> target = graph.findVertexByName(a.getEType().getName());

				graph.addEdge(a.getName(), source.getNumber(), target.getNumber());


			}
		}

		// Print the Graph
		System.out.println(graph.toString());

	}

	/**
	 * Convert EAttribute to Vertex<V>
	 * 
	 * @param Object - o
	 * 			object to be converted
	 * 
	 * @param Graph<String, String> - graph
	 *                
	 * @return void
	 */
	private static void EAttribute2Node(Object o, Graph<String, String> graph) {

		EAttribute eAttribute = (EAttribute)o;

		// Create new vertex for EAtt.
		Vertex<String> vertex = new Vertex<String>();
		vertex.setName(eAttribute.getEType().getName());
		vertex.setNumber(graph.getSize());
		graph.addVertex(vertex);

		// Add EAtt. and corresponding vertex to the HashMap
		hash.put(eAttribute, vertex);

	}

	/**
	 * Convert EClass to Vertex<V>
	 * 
	 * @param Object - o
	 * 			object to be converted
	 * 
	 * @param Graph<String, String> - graph
	 *                
	 * @return void
	 */
	private static void EClass2Node(Object o, Graph<String, String> graph) {

		EClass eClass = (EClass)o;

		// Create new vertex for EAtt.
		Vertex<String> vertex = new Vertex<String>();
		vertex.setName(eClass.getName());
		vertex.setNumber(graph.getSize());

		graph.addVertex(vertex);

		// Add EClasses to the list in order to iterate later
		eClasses.add(eClass);

		// Add EAtt. and corresponding vertex to the HashMap
		hash.put(eClass, vertex);



	}

	/**
	 * Convert EReference to Edge<E>
	 * 
	 * @param EReference - r
	 * 
	 * @param EClass - c
	 * 
	 * @param Graph<String, String> - graph
	 *                
	 * @return void
	 */
	private static void EReference2Edge(EReference r, EClass c, Graph<String, String> graph) {

		// Get the source vertex from HashMap
		Vertex<String> source = hash.get(c);

		// Get the target vertex from HashMap

		Vertex<String> target = hash.get(r.getEReferenceType()) ;

		// Create and add edge between source and target vertices
		graph.addEdge(r.getName(), source.getNumber(), target.getNumber());
	}



}
