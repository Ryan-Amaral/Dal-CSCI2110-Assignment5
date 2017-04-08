

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayDeque;

/**
 * This class implements a directed graph. An undirected grapph can be implemented
 * by subclassing this class. Weights may be attached to the edges by subclassing the
 * Neighbor class accordingly.
 * 
 * @author Sesh Venugopal, modifications by Ryan Amaral
 *
 * @param <T> The type of object used to represent vertices.
 */
public class DirGraph<T> {
    
    /**
     * Array of Vertex instances (vertex info and adjacency list)
     */
    protected ArrayList<Vertex<T>> adjlists;     
    
    /**
     * Initializes a new directed graph instance of default initial vertex capacity.
     */
    public DirGraph() {
        adjlists = new ArrayList<Vertex<T>>();
    }
    
    /**
     * Initializes a new directed graph instance of given initial vertex capacity.
     * 
     * @param vertexCap Initial capacity (number of vertices).
     */
    public DirGraph(int vertexCap) {
        adjlists = new ArrayList<Vertex<T>>(vertexCap);
    }
    
    /**
     * Returns the number of vertices in this graph.
     * 
     * @return Number of vertices in this graph.
     */
    public int numberOfVertices() {
        return adjlists.size();
    }
    
    /**
     * Adds a vertex to this graph.
     * 
     * @param vertex Vertex to be added.
     * @return Number assigned to this vertex in the graph.
     */
    public int addVertex(T vertex) {
        if (!containsVertex(vertex)) {
            adjlists.add(new Vertex<T>(vertex));
        }
        return adjlists.size() - 1;
    }
    
    /**
     * Tells whether this graph contains a given vertex or not.
     * 
     * @param vertex Vertex to be searched for in this graph.
     * @return True if the given vertex is in this graph, false otherwise.
     */
    public boolean containsVertex(T vertex) {
        return adjlists.indexOf(new Vertex<T>(vertex)) != -1;
    }
    
    /**
     * Returns the internal vertex number for the given vertex.
     * 
     * @param vertex Vertex for which internal number is needed.
     * @return Internal number assigned to the given vertex, -1 if the vertex is not in this graph.
     */
    public int vertexNumberOf(T vertex) {
        return adjlists.indexOf(new Vertex<T>(vertex));
    }
    
    /**
     * Returns the client-supplied vertex information associated with a given internal vertex number.
     * 
     * @param vertexNumber Internal vertex number.
     * @return Associated client-supplied vertex information.
     */
    public T vertexInfoOf(int vertexNumber) {
        Vertex<T> v = adjlists.get(vertexNumber);
        return v.info;
    }
    
    /**
     * Tells whether there is an edge from a given vertex (internal number) to another (neighbor).
     * 
     * @param vertexNumber Internal number of vertex.
     * @param nbr Neighbor to which edge is sought.
     * @return True if there is an edge, false otherwise.
     */
    public boolean containsEdge(int vertexNumber, Neighbor nbr) {
        Vertex<T> v = adjlists.get(vertexNumber);
        return v.neighbors.contains(nbr);
    }
    
    /**
     * Adds an edge from a given vertex (internal number) to another (neighbor). Note: If
     * this vertex already has an edge to this neighbor, this method will return without
     * doing anything. In other words, multiple edges are not supported.
     * 
     * @param vertexNumber Internal number of vertex.
     * @param nbr Neighbor to which edge is added.
     */
    public void addEdge(int vertexNumber, Neighbor nbr) {
        Vertex<T> fromVertex = adjlists.get(vertexNumber);
        if (!fromVertex.neighbors.contains(nbr)) {
            fromVertex.neighbors.add(nbr);
        }
    }
    
    /**
     * Change whether the current vertex is discovered or not.
     * @param vertexNumber The number of the vertex to change discovery on.
     * @param discovered Whether vertex is discovered
     */
    public void setDiscovered(int vertexNumber, boolean discovered){
        Vertex<T> v = adjlists.get(vertexNumber);
        v.setDiscovered(discovered);
    }
    
    /**
     * Whether the current vertex is discovered or not.
     * @param vertexNumber The number of the vertex to check.
     * @return Whether the current vertex is discovered or not.
     */
    public boolean isDiscovered(int vertexNumber){
        Vertex<T> v = adjlists.get(vertexNumber);
        return v.isDiscovered();
    }
    
    /**
     * Returns the first neighbor of a given vertex.
     * 
     * @param vertexNumber Internal number of vertex.
     * @return First neighbor of given vertex, null if there are no neighbors.
     */
    public Neighbor firstNeighbor(int vertexNumber) {
        Vertex<T> v = adjlists.get(vertexNumber);
        return v.neighbors.first();
    }
    
    /**
     * Returns the next neighbor of a given vertex.
     * 
     * @param vertexNumber Internal number of vertex.
     * @return Next neighbor of given vertex, relative to an earlier call to
     *          first() or or next(); null if end of neighbors list is reached.
     */
    public Neighbor nextNeighbor(int vertexNumber) {
        Vertex<T> v = adjlists.get(vertexNumber);
        return v.neighbors.next();
    }
    
    /**
     * Clears this graph of all vertices and edges.
     */
    public void clear() {
        adjlists.clear();
    }
    
    /**
     * Marks all vertices as not discovered.
     */
    public void cleanVertices(){
        for(Iterator<Vertex<T>> v = adjlists.iterator(); v.hasNext();){
            Vertex<T> vert = v.next();
            vert.setDiscovered(false);
        }
    }
    
    /**
     * Starts with node start and returns the path taken from a breadth first search.
     * @param start The node to start at.
     * @return List of visited nodes in breadth first order.
     */
    public List<T> breadthFirstSearch(T start){
        
        cleanVertices(); // make all verts not discovered
        
        List<T> sequence = new List<T>(); // the sequence of steps taken
        ArrayDeque<T> queue = new ArrayDeque<T>(); // queue to help traverse
        queue.add(start); // add first element to queue
        sequence.add(start); // add first to sequence
        setDiscovered(vertexNumberOf(start), true); // start is discovered
        
        T cur; // the current vertex to look at
        T nbr; // to iterate through neighbors
        Neighbor nbrObj; // to check next neighbor for null
        
        while(!queue.isEmpty()){
            cur = queue.remove(); // get next
            
            // add all neighbors not in sequence into it
            nbrObj = firstNeighbor(vertexNumberOf(cur));
            while(nbrObj != null){
                nbr = vertexInfoOf(nbrObj.vertexNumber);
                if(!isDiscovered(vertexNumberOf(nbr))){
                    queue.add(nbr);
                    sequence.add(nbr);
                    setDiscovered(vertexNumberOf(nbr), true);
                }
                nbrObj = nextNeighbor(vertexNumberOf(cur));
            }
        }
        
        return sequence;
    }
}


















