
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
public class NodeDistance<T> {
    public T From;
    public T To;
    public int Distance;
    
    public NodeDistance(T from, T to, int distance){
        From = from;
        To = to;
        Distance = distance;
    }
}
