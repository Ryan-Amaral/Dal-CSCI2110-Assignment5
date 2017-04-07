
/**
 * The main class for this assignment which tests all major features in main method.
 * 
 * Assumptions/Restrictions:
 * 
 * Noteworthy Features: 
 * 
 * @author Ryan Amaral
 *
 */
public class TestGraph {

    public static void main(String[] args) {
        
        ///// Creating the first graph by calling the required methods
        WeightedUndirGraph<String> graph = createGraph1();
        
        // Calling its DFS


        // Calling its BFS


        // Calling Dijkstra (S)


        // Calling Kruskal


        ///// Creating the second graph by calling the required methods
        
        // Calling its DFS
    
        
        // Calling its BFS
        
        
        // Calling Dijkstra (S)


        // Calling Kruskal


    }
    
    private static WeightedUndirGraph<String> createGraph1(){
        
        // create a graph of size 9
        WeightedUndirGraph<String> graph = new WeightedUndirGraph<>(9);
        
        int idA = graph.addVertex("A"); // create node "A" and save id
        int idB = graph.addVertex("B"); // create node "B" and save id
        int idC = graph.addVertex("C"); // create node "C" and save id
        int idD = graph.addVertex("D"); // create node "D" and save id
        int idE = graph.addVertex("E"); // create node "E" and save id
        int idF = graph.addVertex("F"); // create node "F" and save id
        int idG = graph.addVertex("G"); // create node "G" and save id
        int idH = graph.addVertex("H"); // create node "H" and save id
        int idI = graph.addVertex("I"); // create node "I" and save id
        
        Neighbor nbr; // to be multiply reused to add neighbors between all vertices
        
        nbr = new Neighbor(idA, 13);
        graph.addEdge(idA, nbr);
        
        return graph;
    }

}
