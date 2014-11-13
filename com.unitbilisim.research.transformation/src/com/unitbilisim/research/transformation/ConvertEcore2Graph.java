package com.unitbilisim.research.transformation;

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
import com.unitbilisim.research.adt.Edge;
import com.unitbilisim.research.adt.Graph;
import com.unitbilisim.research.adt.Vertex;


/**
 * Class to convert .ecore metamodel to a Graph instance 
 * using java Graph structure 
 * 
 * @author ffurkan.tanriverdi@gmail.com
 * 		   furkan.tanriverdi@unitbilisim.com
 */
public class ConvertEcore2Graph {

	private static Resource resource;

	// HashMap tos store
	static HashMap<EObject,Vertex<String>> hash = new HashMap<EObject, Vertex<String>>();

	// MultiMap to store Vertex and unconnected edges to that
	public static HashMultimap<String, Edge<String>> multiMap = HashMultimap.create();

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

		// Get EObjects source
		Iterator<EObject> resourceObjects = resource.getAllContents();		

		// Create a new Graph instance
		Graph<String> graph = new Graph<String>();


		// Find all EClass and EAttributes(EAttributes should have different EType)
		// and create corresponding vertex
		while (resourceObjects.hasNext()) {
			Object o = resourceObjects.next();

			if(o instanceof EClass){		

				EClass eClass = (EClass)o;

				// Convert EClass to Vertex
				EClass2Vertex(eClass,graph);

				// Getting all references and convert them to edges
				for(EReference r : eClass.getEAllReferences()){

					// If there is a vertex for EReference type but no edge between them
					if(graph.findVertexByName(r.getEReferenceType().getName()) != null){

						EReference2Edge(r,eClass,graph,false);
					}

					// If there is no vertex for EReference type yet
					else{

						EReference2Edge(r,eClass,graph,true);
					}
				}		

				// Getting all attributes and convert them to verticies
				for(EAttribute a : eClass.getEAllAttributes()){

					// if there is no vertex named EAttribute's EType in graph
					if(graph.findVertexByName(a.getEType().getName()) == null){

						EAttribute2Vertex(a,graph);		
					}

					// Get corresponding vertex for eClass
					Vertex<String> source = hash.get(eClass);

					// Get corresponding vertex for EAttribute
					Vertex<String> target = graph.findVertexByName(a.getEType().getName());

					graph.addEdge(source,target, a.getName());

				}

				// If we have reference to this class from another class and
				// have not added edge between them
				if(multiMap.containsKey(eClass.getName())){

					// Get all edges which point this class
					Set<Edge<String>> list = multiMap.get(eClass.getName());

					for(Edge<String> e : list){

						// Set edge's ending vertex
						e.setTo(hash.get(eClass));

						graph.addEdge(e.getFrom(), hash.get(eClass), e.getName());
					}

				}		

			} // End if

		} // End while

		// Print the Graph
		System.out.println(graph.toString());
	}

	/**
	 * If both starting and ending verticies exists add an edge between them
	 * 
	 * Else, create and edge put to the multiMap
	 * 
	 * @param EReference -
	 *          
	 * @param EClass -
	 * 
	 * @param Graph<String> - 
	 * 
	 * @param Boolean
	 * 		 	True, if both verticies exist                
	 * @return void
	 */
	private static void EReference2Edge(EReference rContainments,
			EClass eClass, Graph<String> graph, boolean b) {
		// TODO Auto-generated method stub

		Vertex<String> vertex = hash.get(eClass);

		if(b == true){
			
			Edge<String> edge = new Edge<String>();

			edge.setFrom(vertex);
			edge.setName(rContainments.getName());
			multiMap.put(rContainments.getEReferenceType().getName(), edge);
		}else{
			
			Vertex<String> to = graph.findVertexByName(
					rContainments.getEReferenceType().getName());

			graph.addEdge(vertex, to, rContainments.getName());
		}
	}



	/**
	 * Convert EClass to Vertex and add to Graph
	 * 
	 * @param EClass -
	 *         
	 * @param Graph<String> -
	 *                 
	 * @return void
	 */
	private static void EClass2Vertex(EClass eClass, Graph<String> graph) {
		// TODO Auto-generated method stub

		// Create new vertex for EAtt.
		Vertex<String> vertex = new Vertex<String>();
		vertex.setName(eClass.getName());
		vertex.visit();
		
		graph.addVertex(vertex);

		hash.put(eClass, vertex);
	}


	/**
	 * Convert EAttribute to Vertex and put to the hash map
	 * 
	 * @param EAttribute -
	 *          
	 * @param Graph<String> -
	 *                 
	 * @return void
	 */
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
