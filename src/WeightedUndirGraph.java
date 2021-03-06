
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
    public void addEdge(int vertexNumber, Neighbor nbr) {
        super.addEdge(vertexNumber, nbr);
        // added the weight of neighbor in this one
        super.addEdge(nbr.vertexNumber, new Neighbor(vertexNumber, nbr.weight));
    }
}
