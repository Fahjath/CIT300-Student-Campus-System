package graph;

import java.util.*;

public class CampusGraph {

    private Map<String, List<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a campus location
    public boolean addLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            return false;
        }

        if (adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.put(location, new ArrayList<>());
        return true;
    }

    // Remove a campus location
    public boolean removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.remove(location);

        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // Add a connection between two locations
    public boolean addConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)
                || location1.equals(location2)) {
            return false;
        }

        if (adjacencyList.get(location1).contains(location2)) {
            return false;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        return true;
    }

    // Remove a connection
    public boolean removeConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        boolean removed1 = adjacencyList.get(location1).remove(location2);
        boolean removed2 = adjacencyList.get(location2).remove(location1);

        return removed1 && removed2;
    }

    // Display all campus connections
    public void displayConnections() {
        for (String location : adjacencyList.keySet()) {
            System.out.println(location + " -> "
                    + adjacencyList.get(location));
        }
    }

    // BFS traversal
    public void bfs(String startLocation) {
        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // DFS traversal
    public void dfs(String startLocation) {
        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.print("DFS: ");
        dfsRecursive(startLocation, visited);
        System.out.println();
    }

    private void dfsRecursive(String location, Set<String> visited) {
        visited.add(location);
        System.out.print(location + " ");

        for (String neighbour : adjacencyList.get(location)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }
}
