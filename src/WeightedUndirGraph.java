
/**
 * A weighted undirected graph.
 * 
 * Assumptions/Restrictions:
 * 
 * Noteworthy Features: 
 * 
 * @author Ryan Amaral
 *
 * @param <T>
 */
public class WeightedUndirGraph<T> extends UndirGraph<T> {
    
    /**
     * Initializes a new weighted undirected graph instance of default initial vertex capacity.
     */
    public WeightedUndirGraph() {
        super();
    }
    
    /**
     * Initializes a new weighted undirected graph instance of given initial vertex capacity.
     * 
     * @param vertexCap Initial capacity (number of vertices).
     */
    public WeightedUndirGraph(int vertexCap) {
        super(vertexCap);
    }
    
    /* (non-Javadoc)
     * @see structures.graph.DirGraph#addEdge(int, structures.graph.Neighbor)
     */
    public void addEdge(int vertexNumber, WeightedNeighbor nbr) {
        super.addEdge(vertexNumber, nbr);
        super.addEdge(nbr.vertexNumber, new WeightedNeighbor(vertexNumber));
    }

    /* (non-Javadoc)
     * @see structures.graph.DirGraph#addEdge(int, structures.graph.Neighbor)
     */
    public void addEdge(int vertexNumber, WeightedNeighbor nbr, int weight) {
        super.addEdge(vertexNumber, nbr);
        super.addEdge(nbr.vertexNumber, new WeightedNeighbor(vertexNumber, weight));
    }
}
