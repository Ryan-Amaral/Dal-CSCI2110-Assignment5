
/**
 * Holds the neighbor of a vertex, also has a weight of the connection.
 * 
 * Assumptions/Restrictions:
 * 
 * Noteworthy Features: 
 * 
 * @author Ryan Amaral
 *
 */
public class WeightedNeighbor extends Neighbor {

    
    /**
     * The default weight of a connection.
     */
    private static final int DEFAULT_WEIGHT = 1;
    
    /**
     * The weight between the nodes. A positive integer.
     */
    public int weight;
    
    public WeightedNeighbor(int vertexNum) {
        super(vertexNum);
        this.weight = DEFAULT_WEIGHT;
    }
    
    public WeightedNeighbor(int vertexNum, int weight) {
        super(vertexNum);
        this.weight = weight;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        return super.equals(((Neighbor)other));
    }
}
