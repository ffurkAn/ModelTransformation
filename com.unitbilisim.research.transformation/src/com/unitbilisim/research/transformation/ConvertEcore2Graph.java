package com.unitbilisim.research.transformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;

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

	private static XMIResource xmiResource;
	
	private static Resource resource;

	// HashMap tos store
	static HashMap<EObject,Vertex<String>> hash = new HashMap<EObject, Vertex<String>>();

	// MultiMap to store Vertex and unconnected edges to that
	public static HashMultimap<String, Edge<String>> multiMap = HashMultimap.create();

	// Get EClasses
	static List<EClass> eClasses = new ArrayList<EClass>();


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		EPackage.Registry reg = EPackage.Registry.INSTANCE;
		EPackage m = reg.getEPackage("my");
	
		System.out.println(m.toString());
		
		/*
		ResourceSet myResourceSet = new ResourceSetImpl();
		ExtendedMetaData modelMetaData = new BasicExtendedMetaData(myResourceSet.getPackageRegistry());

		EClass List = (EClass) modelMetaData.getType("my", "Collection");
		
		EStructuralFeature nameAttr = modelMetaData.getElement(List, null, "name");
		
		System.out.println("attr: " + modelMetaData.getNamespace(nameAttr) + ":" + nameAttr.getName());
		
		*/
		
		/*
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		resource = resSet.getResource(URI.createURI("model/List.xmi"), true);
		// resource.load(Collections.EMPTY_MAP);

		for (EObject eo : resource.getContents()) {
			System.out.println(eo);
		}

*/
		
		////////////
		/*
		URI uri = URI.createURI("model/Collection.xmi");

				try {

					ResourceSet resourceSet = new ResourceSetImpl();

					// register UML
					Map packageRegistry = resourceSet.getPackageRegistry();
					packageRegistry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

					// Register XML resource as UMLResource.Factory.Instance
					Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE
							.getExtensionToFactoryMap();
					extensionFactoryMap.put(UMLResource.FILE_EXTENSION,
							UMLResource.Factory.INSTANCE);
					extensionFactoryMap.put("xmi", UMLResource.Factory.INSTANCE);

					Resource resource = (Resource) resourceSet.createResource(uri);

					// try to load the file into resource
					resource.load(null);
					System.out.println("XMI Resource has "
							+ resource.getContents().size() + " objects.");
					for (EObject obj : resource.getContents()) {

						System.out.println(obj.toString());
					}
				}// end of try
				catch (NullPointerException | IOException e) {
					e.printStackTrace();
				}
		
		*/
		//MyPackage.eINSTANCE.eClass();

		/*
		// Register the XMI resource factory for the .xmi extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSetImpl resourceSet = new ResourceSetImpl();

		// Get the resource
		URI uri = URI.createFileURI("C:/..../simple.java_java.xmi");
		Resource resource = resourceSet.getResource(uri, true);
		
		Model javaModel = (Model) resource.getContents().get(0);

		//Read the top-packages contained in the model
		EList<Package> pagckages = javaModel.;
		for (Package p : pagckages) {
			System.out.println(p.getName());
		}

	*/
	    /*
		xmiResource = new XMIResourceImpl(URI.createURI("model/List.xmi"));
		//resource.load(null);
		
		for (EObject eo : resource.getContents()) {
		      System.out.println(eo);
		    }
		
		*/
		
		// PARSER
		
				/*
		try {
			 
			File fXmlFile = new File("model/Collection.xmi");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName()+"\n");
		 
		 
			NodeList nodeList = doc.getElementsByTagName("*");
		    for (int i = 0; i < nodeList.getLength(); i++) {
		        Node node = nodeList.item(i);
		        if (node.getNodeType() == Node.ELEMENT_NODE) {
		            // do something with the current element
		        	
		        	EClass c = (EClass)node.getClass();
		        	
		        }
		    }
		    
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		
		*/
		////
		
				
		/*
		// generate EPackages from schemas
		XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
		Collection generatedPackages = xsdEcoreBuilder.generate(schemaURI);

		// register the packages loaded from XSD
		for (EObject generatedEObject : generatedPackages) {
		    if (generatedEObject instanceof EPackage) {
		        EPackage generatedPackage = (EPackage) generatedEObject;
		        EPackage.Registry.INSTANCE.put(generatedPackage.getNsURI(),
		            generatedPackage);
		    }
		}

		// add file extension to registry
		ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap()
		    .put(MY_FILE_EXTENSION, new GenericXMLResourceFactoryImpl());
		
		*/
		
		// Save the resource
		/*
		try 
		{ 
			resource.save(System.out, Collections.EMPTY_MAP); 
			//resource.save(Collections.EMPTY_MAP); 
		} 
		catch (IOException e) {
			System.out.println("ERROR! Saving Resource ");} 
		 */

/*		
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

*/
		// Print the Graph
		// System.out.println(graph.toString());
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
