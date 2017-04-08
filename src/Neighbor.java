
/**
 * This class encapsulated a neighbor of a vertex. In this implementation, the
 * neighbor is simply an vertex number, but this class may be subclassed by
 * adding an edge weight field, which may then be used in the implementation
 * of a weighted graph.
 * 
 * @author Sesh Venugopal, modified by Ryan Amaral
 *
 */
public class Neighbor {
    
    /**
     * The default weight of a connection.
     */
    private static final int DEFAULT_WEIGHT = 1;
    
    /**
     * Internal vertex number of neighbor.
     */
    public int vertexNumber;
    
    /**
     * Weight used by weighted graphs, ignored by non-weighted graphs.
     */
    public int weight;
    
    /**
     * Initializes a new instance with given vertex number and default weight.
     * 
     * @param vertexNum Vertex number.
     */
    public Neighbor(int vertexNum) {
        vertexNumber = vertexNum;
        weight = DEFAULT_WEIGHT;
    }
    
    /**
     * Initializes a new instance with given vertex number and weight.
     * 
     * @param vertexNum Vertex number.
     * @param weight Weight.
     */
    public Neighbor(int vertexNum, int weight){
        vertexNumber = vertexNum;
        this.weight = weight;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((other != null) && (other instanceof Neighbor)) {
            Neighbor another = (Neighbor)other;
            return (vertexNumber == another.vertexNumber);
        }
        // modification to compare to NodeDistance object
        else if((other != null) && (other instanceof NodeDistance)){
            return vertexNumber == ((NodeDistance<?>)other).VertexNumber;
        }
        return false;
    }
}
