


/**
 * This class encapsulates a vertex by packaging together the client-supplied
 * vertex object and a reference to the list of its neighbors.
 * 
 * @author Sesh Venugopal, modified by Ryan Amaral
 *
 */
public class Vertex<T> {
    
    /**
     * Client-supplied vertex information.
     */
    protected T info;
    
    
    /**
     * To help in traversals.
     */
    private boolean discovered;
    
    /**
     * Neighbors of this vertex.
     */
    protected List<Neighbor> neighbors;  
    
    /**
     * Initializes a new instance with vertex information.
     * 
     * @param vertexInfo Vertex information.
     */
    protected Vertex(T vertexInfo) {
        setDiscovered(false); // default not discovered
        info = vertexInfo;
        neighbors = new List<Neighbor>();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((other != null) && (other instanceof Vertex)) {
            Vertex another = (Vertex)other;
            return (info.equals(another.info));
        }
        return false;
    }
    
    public String toString(){
        return info.toString();
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }
}
