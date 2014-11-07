package com.unitbilisim.research.adt;


/**
 * A spanning tree visitor callback interface
 * 
 * @see Graph#dfsSpanningTree(Vertex, DFSVisitor)
 * 
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 * @param <V,E>
 */
interface DFSVisitor<V,E> {
  /**
   * Called by the graph traversal methods when a vertex is first visited.
   * 
   * @param g -
   *          the graph
   * @param v -
   *          the vertex being visited.
   */
  public void visit(Graph<V,E> g, Vertex<V> v);

  /**
   * Used dfsSpanningTree to notify the visitor of each outgoing edge to an
   * unvisited vertex.
   * 
   * @param g -
   *          the graph
   * @param v -
   *          the vertex being visited
   * @param e -
   *          the outgoing edge from v
   */
  public void visit(Graph<V,E> g, Vertex<V> v, Edge<E> e);
}