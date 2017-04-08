
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
        System.out.println("Graph 1 DFS:\n" + graph.depthFirstSearch("A").toString());

        // Calling its BFS
        System.out.println("\nGraph 1 BFS:\n" + graph.breadthFirstSearch("A").toString());

        // Calling Dijkstra (S)
        System.out.println("\nGraph 1 Dijkstra's (Showing distances between nodes):\n" 
                    + graph.dijkstrasAlgorithm("A"));

        // Calling Kruskal
        System.out.println("\nGraph 1 Kruskal's (Showing vertex pairs that are in MST with distances):\n" 
                    + graph.kruskalsAlgorithm());
        
        System.out.println();
        
        ///// Creating the second graph by calling the required methods
        graph = createGraph2();
        
        // Calling its DFS
        System.out.println("Graph 2 DFS:\n" + graph.depthFirstSearch("A").toString());

        // Calling its BFS
        System.out.println("\nGraph 2 BFS:\n" + graph.breadthFirstSearch("A").toString());

        // Calling Dijkstra (S)
        System.out.println("\nGraph 2 Dijkstra's (Showing distances between nodes):\n" 
                    + graph.dijkstrasAlgorithm("A"));

        // Calling Kruskal
        System.out.println("\nGraph 2 Kruskal's (Showing vertex pairs that are in MST with distances):\n" 
                    + graph.kruskalsAlgorithm());

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
        int idJ = graph.addVertex("J"); // create node "J" and save id
        int idK = graph.addVertex("K"); // create node "K" and save id
        int idL = graph.addVertex("L"); // create node "L" and save id
        int idM = graph.addVertex("M"); // create node "M" and save id
        int idN = graph.addVertex("N"); // create node "N" and save id
        
        Neighbor nbr; // to be multiply reused to add neighbors between all vertices
        
        // connect A and D with weight 4
        nbr = new Neighbor(idD, 4);
        graph.addEdge(idA, nbr);
        
        // connect D and E with weight 1
        nbr = new Neighbor(idE, 1);
        graph.addEdge(idD, nbr);
        
        // connect D and F with weight 5
        nbr = new Neighbor(idF, 5);
        graph.addEdge(idD, nbr);
        
        // connect B and C with weight 3
        nbr = new Neighbor(idC, 3);
        graph.addEdge(idB, nbr);
        
        // connect C and E with weight 1
        nbr = new Neighbor(idE, 1);
        graph.addEdge(idC, nbr);
        
        // connect E and G with weight 6
        nbr = new Neighbor(idG, 6);
        graph.addEdge(idE, nbr);
        
        // connect F and G with weight 9
        nbr = new Neighbor(idG, 9);
        graph.addEdge(idF, nbr);
        
        // connect G and J with weight 8
        nbr = new Neighbor(idJ, 8);
        graph.addEdge(idG, nbr);
        
        // connect H and I with weight 2
        nbr = new Neighbor(idI, 2);
        graph.addEdge(idH, nbr);
        
        // connect I and J with weight 6
        nbr = new Neighbor(idJ, 6);
        graph.addEdge(idI, nbr);
        
        // connect J and K with weight 7
        nbr = new Neighbor(idK, 7);
        graph.addEdge(idJ, nbr);
        
        // connect J and L with weight 2
        nbr = new Neighbor(idL, 2);
        graph.addEdge(idJ, nbr);
        
        // connect I and M with weight 5
        nbr = new Neighbor(idM, 5);
        graph.addEdge(idI, nbr);
        
        // connect L and M with weight 7
        nbr = new Neighbor(idM, 7);
        graph.addEdge(idL, nbr);
        
        // connect M and N with weight 3
        nbr = new Neighbor(idN, 3);
        graph.addEdge(idM, nbr);
        
        return graph;
    }

    
    private static WeightedUndirGraph<String> createGraph2(){
        
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
        int idJ = graph.addVertex("J"); // create node "J" and save id
        int idK = graph.addVertex("K"); // create node "K" and save id
        
        Neighbor nbr; // to be multiply reused to add neighbors between all vertices
        
        // connect A and B with weight 3
        nbr = new Neighbor(idB, 3);
        graph.addEdge(idA, nbr);
        
        // connect A and E with weight 9
        nbr = new Neighbor(idE, 9);
        graph.addEdge(idA, nbr);
        
        // connect B and C with weight 1
        nbr = new Neighbor(idC, 1);
        graph.addEdge(idB, nbr);
        
        // connect B and D with weight 1
        nbr = new Neighbor(idD, 1);
        graph.addEdge(idB, nbr);
        
        // connect C and D with weight 4
        nbr = new Neighbor(idD, 4);
        graph.addEdge(idC, nbr);
        
        // connect D and E with weight 5
        nbr = new Neighbor(idE, 5);
        graph.addEdge(idD, nbr);
        
        // connect E and F with weight 9
        nbr = new Neighbor(idF, 9);
        graph.addEdge(idE, nbr);
        
        // connect E and J with weight 7
        nbr = new Neighbor(idJ, 7);
        graph.addEdge(idE, nbr);
        
        // connect F and G with weight 2
        nbr = new Neighbor(idG, 2);
        graph.addEdge(idF, nbr);
        
        // connect F and H with weight 6
        nbr = new Neighbor(idH, 6);
        graph.addEdge(idF, nbr);
        
        // connect F and I with weight 5
        nbr = new Neighbor(idI, 5);
        graph.addEdge(idF, nbr);
        
        // connect H and K with weight 5
        nbr = new Neighbor(idK, 5);
        graph.addEdge(idH, nbr);
        
        // connect H and I with weight 3
        nbr = new Neighbor(idI, 3);
        graph.addEdge(idH, nbr);
        
        // connect I and J with weight 9
        nbr = new Neighbor(idJ, 9);
        graph.addEdge(idI, nbr);
        
        // connect I and K with weight 6
        nbr = new Neighbor(idK, 6);
        graph.addEdge(idI, nbr);
        
        // connect J and K with weight 8
        nbr = new Neighbor(idK, 8);
        graph.addEdge(idJ, nbr);
        
        return graph;
    }
}
