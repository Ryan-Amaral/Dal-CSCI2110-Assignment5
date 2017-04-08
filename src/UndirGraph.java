
import java.util.Iterator;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.HashMap;

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
        super.addEdge(nbr.vertexNumber, new Neighbor(vertexNumber, nbr.weight));
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
    
    /**
     * Generates a list of the distances between the selected start node and 
     * all other nodes in the graph.
     * @param start The node to compare distance to all others with.
     * @return A list of the distances between the selected start node and 
     * all other nodes in the graph.
     */
    public List<NodeDistance<T>> dijkstrasAlgorithm(T start){
        
        cleanVertices(); // make all verts not discovered
        
        // the distances between each node and start
        List<NodeDistance<T>> nodesDistances = new List<NodeDistance<T>>();
        PriorityQueue<NodeDistance<T>> pqueue = new PriorityQueue<NodeDistance<T>>();
        
        // map to hold distances
        HashMap<T,Integer> distancesMap = new HashMap<T,Integer>();
        
        NodeDistance<T> tmpNodeDist;
        // add all nodes with initial distances to priority queue
        for(Iterator<Vertex<T>> v = adjlists.iterator(); v.hasNext();){
            Vertex<T> vert = v.next();
            // node is start, distance is 0
            if(vert.info.equals(start))
                tmpNodeDist = new NodeDistance<T>(start, vert.info, 0, vertexNumberOf(vert.info));
            else // distance as high as can go
                tmpNodeDist = new NodeDistance<T>(start, vert.info, Integer.MAX_VALUE, vertexNumberOf(vert.info));
            pqueue.add(tmpNodeDist);
            distancesMap.put(vert.info, tmpNodeDist.Distance);
        }
        
        NodeDistance<T> cur; // the current vertex's container
        T curNode; // the current vertex to look at
        T nbr; // the value of neighbor node
        Neighbor nbrObj; // to check next neighbor for null
        
        while(!pqueue.isEmpty()){
            // add node to cloud
            cur = pqueue.remove(); // get lowest distance node
            curNode = cur.To;
            
            nodesDistances.add(cur); // put in final list
            
            // look at all neighbors that are in pqueue
            nbrObj = firstNeighbor(vertexNumberOf(curNode));
            while(nbrObj != null){
                nbr = vertexInfoOf(nbrObj.vertexNumber);
                // is current neighbor in pqueue? If not, it is in cloud
                if(pqueue.contains(nbrObj)){
                    int potentialDist = cur.Distance + nbrObj.weight;
                    // is new distance better?
                    if(potentialDist < distancesMap.get(nbr)){
                        distancesMap.put(nbr, potentialDist);
                        // reorder priority queue in light of updated distance
                        pqueue.remove(nbrObj);
                        pqueue.add(new NodeDistance<T>(start, nbr, potentialDist, nbrObj.vertexNumber));
                    }
                }
                
                nbrObj = nextNeighbor(vertexNumberOf(curNode));
            }
        }
        
        return nodesDistances;
    }
    
    public void kruskalsAlgorithm(){
        
    }
}
