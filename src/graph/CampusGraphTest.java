package graph;

public class CampusGraphTest {

    public static void main(String[] args) {

        CampusGraph graph = new CampusGraph();

        // Add campus locations
        graph.addLocation("Main Gate");
        graph.addLocation("Library");
        graph.addLocation("Cafeteria");
        graph.addLocation("Science Block");
        graph.addLocation("Admin Block");

        // Add campus connections
        graph.addConnection("Main Gate", "Library");
        graph.addConnection("Main Gate", "Cafeteria");
        graph.addConnection("Library", "Science Block");
        graph.addConnection("Cafeteria", "Admin Block");
        graph.addConnection("Science Block", "Admin Block");

        System.out.println("Campus Connections:");
        graph.displayConnections();

        System.out.println();

        // BFS
        graph.bfs("Main Gate");

        // DFS
        graph.dfs("Main Gate");

        System.out.println();

        // Remove connection
        System.out.println("Removing connection: Main Gate - Cafeteria");
        graph.removeConnection("Main Gate", "Cafeteria");

        graph.displayConnections();

        System.out.println();

        // Remove location
        System.out.println("Removing location: Admin Block");
        graph.removeLocation("Admin Block");

        graph.displayConnections();
    }
}
