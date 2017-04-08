
import java.util.Iterator;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;

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
    
    /**
     * Runs Kruskal's algorithm on the graph to get the minimum spanning tree.
     * @return A list of NodeDistance<T> objects, which shows which edges are part of the MST,
     * as well as the distance of the edges. Edges displayed as "From->To: Distance".
     */
    public List<NodeDistance<T>> kruskalsAlgorithm(){
        
        // the list containing vertex pairs in MST
        List<NodeDistance<T>> mstMembers = new List<NodeDistance<T>>();
        
        // all sets of vertices
        List<HashSet<T>> vertexSets = new List<HashSet<T>>();
        // priority queue for closest neighbor
        PriorityQueue<NodeDistance<T>> pqueue = new PriorityQueue<NodeDistance<T>>();
        
        // to help with initializing
        NodeDistance<T> tmpNodeDist;
        HashSet<T> tmpHashSet;

        T nbr; // the value of neighbor node
        Neighbor nbrObj; // to check next neighbor for null
        
        // add all edges with distances to priority queue, and all vertices to own set
        for(Iterator<Vertex<T>> v = adjlists.iterator(); v.hasNext();){
            Vertex<T> vert = v.next(); // the current vertex
            
            tmpHashSet = new HashSet<T>();
            tmpHashSet.add(vert.info); // add vertex to hash set
            vertexSets.add(tmpHashSet); // add new hash set with 1 vert to list
            
            // add all neighbors to pqueue
            nbrObj = firstNeighbor(vertexNumberOf(vert.info));
            while(nbrObj != null){
                nbr = vertexInfoOf(nbrObj.vertexNumber);
                pqueue.add(new NodeDistance<T>(vert.info, nbr, nbrObj.weight, nbrObj.vertexNumber));
                nbrObj = nextNeighbor(vertexNumberOf(vert.info)); // get next neighbor
            }
        }
        
        // references to clusters that contain the respective vertices of an edge
        HashSet<T> cluster1;
        HashSet<T> cluster2;
        
        // add all needed vertex pairs to MST
        // needs to be amount of vertices - 1
        while(mstMembers.size() < adjlists.size() - 1){
            tmpNodeDist = pqueue.remove(); // get smallest distance neighbors
            cluster1 = getClusterOf(tmpNodeDist.From, vertexSets);
            cluster2 = getClusterOf(tmpNodeDist.To, vertexSets);
            // if verts are not in same cluster
            if(cluster1 != cluster2){
                mstMembers.add(tmpNodeDist); // add to mst
                mergeClusters(cluster1, cluster2); // 1 consumes 2
                vertexSets.remove(cluster2); // removes obsolete one
            }
        }
        
        return mstMembers;
    }
    
    /**
     * Returns the cluster that data belongs to, from set clusterSet.
     * @param data The data to look for.
     * @param clusterSet The set of all clusters to search in.
     * @return The cluster that data belongs to, from set clusterSet.
     */
    private HashSet<T> getClusterOf(T data, List<HashSet<T>> clusterSet){
        HashSet<T> curSet = clusterSet.first();
        while(curSet != null){
            if(curSet.contains(data))
                return curSet; // the set
            curSet = clusterSet.next();
        }
        return null; // no set found
    }
    
    /**
     * Puts all of the elements from cluster 2 into cluster 1.
     * @param cluster1 The first cluster.
     * @param cluster2 The second cluster.
     */
    public void mergeClusters(HashSet<T> cluster1, HashSet<T> cluster2){
        // add all of cluster 2 into the cluster 1
        for(Iterator<T> i = cluster2.iterator(); i.hasNext();){
            cluster1.add(i.next());
        }
    }
}
