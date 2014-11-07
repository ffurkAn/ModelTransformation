package com.unitbilisim.research.adt;


/**
 * A graph visitor interface.
 * 
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 * @param <V,E>
 */
interface Visitor<V,E> {
  /**
   * Called by the graph traversal methods when a vertex is first visited.
   * 
   * @param g -
   *          the graph
   * @param v -
   *          the vertex being visited.
   */
  public void visit(Graph<V,E> g, Vertex<V> v);
}
