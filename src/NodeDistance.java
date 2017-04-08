import java.util.Comparator;

/**
 * A class to store two node data's and the distance between the nodes.
 * 
 * Assumptions/Restrictions:
 * 
 * Noteworthy Features: 
 * 
 * @author Ryan Amaral
 *
 */
public class NodeDistance<T> implements Comparator<NodeDistance<T>>, Comparable {
    public T From;
    public T To;
    public int Distance;
    public int VertexNumber;
    
    /**
     * Creates a new node distance object.
     * @param from The start node.
     * @param to The end node.
     * @param distance The distance between the nodes.
     */
    public NodeDistance(T from, T to, int distance, int vertexNumber){
        From = from;
        To = to;
        Distance = distance;
        VertexNumber = vertexNumber;
    }
    
    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(NodeDistance<T> me, NodeDistance<T> other)
    {
        return other.Distance - me.Distance;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
        return From.toString() + "->" + To.toString() + ": " + Distance + "\n";
    }

    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }
}
