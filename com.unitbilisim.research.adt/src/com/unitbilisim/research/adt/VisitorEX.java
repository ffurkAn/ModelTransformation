package com.unitbilisim.research.adt;


/**
 * A graph visitor interface that can throw an exception during a visit
 * callback.
 * 
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 * @param <V,E>
 * @param <X>
 */
interface VisitorEX<V,E, X extends Exception> {
  /**
   * Called by the graph traversal methods when a vertex is first visited.
   * 
   * @param g -
   *          the graph
   * @param v -
   *          the vertex being visited.
   * @throws E
   *           exception for any error
   */
  public void visit(Graph<V,E> g, Vertex<E> v) throws X;
}