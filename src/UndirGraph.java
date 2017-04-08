
import java.util.Iterator;
import java.util.Stack;
import java.util.PriorityQueue;

/**
 * This class implements an undirected graph. Since an undirected graph is a special
 * kind of directed graph--an undirected edge is two directed edges in opposite
 * directions--it is implemented by subclassing DirGraph.
 * 
 * @author Sesh Venugopal, modified by Ryan Amaral
 *
 */
public class UndirGraph<T> extends DirGraph<T> {
    
    /**
     * Initializes a new undirected graph instance of default initial vertex capacity.
     */
    public UndirGraph() {
        super();
    }
    
    /**
     * Initializes a new undirected graph instance of given initial vertex capacity.
     * 
     * @param vertexCap Initial capacity (number of vertices).
     */
    public UndirGraph(int vertexCap) {
        super(vertexCap);
    }
    
    /* (non-Javadoc)
     * @see structures.graph.DirGraph#addEdge(int, structures.graph.Neighbor)
     */
    public void addEdge(int vertexNumber, Neighbor nbr) {
        super.addEdge(vertexNumber, nbr);
        super.addEdge(nbr.vertexNumber, new Neighbor(vertexNumber));
    }
    
    /**
     * Starts with node start and returns the path taken from a depth first search.
     * @param start The node to start at.
     * @return List of visited nodes in depth first order.
     */
    public List<T> depthFirstSearch(T start){
        
        cleanVertices(); // make all verts not discovered
        
        List<T> sequence = new List<T>(); // the sequence of steps taken
        Stack<T> stack = new Stack<T>(); // stack to help traverse
        
        stack.push(start); // start with start
        
        T cur; // the current vertex to look at
        T nbr; // to iterate through neighbors
        Neighbor nbrObj; // to check next neighbor for null
        
        while(!stack.isEmpty()){
            cur = stack.pop();
            // have not visited yet
            if(!isDiscovered(vertexNumberOf(cur))){
                sequence.add(cur); // add to list
                setDiscovered(vertexNumberOf(cur), true); // set discovered
                
                // push all neighbor vertices to stack
                nbrObj = firstNeighbor(vertexNumberOf(cur));
                while(nbrObj != null){
                    nbr = vertexInfoOf(nbrObj.vertexNumber);
                    stack.push(nbr);
                    nbrObj = nextNeighbor(vertexNumberOf(cur));
                }
            }
        }
        
        return sequence;
    }
    
    public List<NodeDistance<T>> dijkstrasAlgorithm(T start){
        
        cleanVertices(); // make all verts not discovered
        
        // the distances between each node and start
        List<NodeDistance<T>> nodesDistances = new List<NodeDistance<T>>();
        
        
        T cur; // the current vertex to look at
        T nbr; // to iterate through neighbors
        Neighbor nbrObj; // to check next neighbor for null
        
        return nodesDistances;
    }
}
