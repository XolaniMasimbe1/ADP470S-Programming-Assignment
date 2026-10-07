package za.ac.cput.partE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph implementation using an adjacency matrix.
 * Demonstrates DFS (recursive), BFS (using queue), and shortest path (by edge count).
 */
public class Graph {

    private int[][] adjacencyMatrix;
    private String[] vertexNames;
    private int numVertices;
    private boolean[] visited;

    /**
     * Creates a graph with the specified number of vertices.
     *
     * @param numVertices number of vertices in the graph
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.vertexNames = new String[numVertices];
        this.visited = new boolean[numVertices];

        // Initialize adjacency matrix with 0 (no edges)
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    /**
     * Sets the name of a vertex.
     */
    public void setVertexName(int vertex, String name) {
        if (vertex >= 0 && vertex < numVertices) {
            vertexNames[vertex] = name;
        }
    }

    /**
     * Adds an edge between two vertices (undirected graph).
     *
     * @param v1 first vertex index
     * @param v2 second vertex index
     */
    public void addEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            adjacencyMatrix[v1][v2] = 1;
            adjacencyMatrix[v2][v1] = 1; // Undirected graph
        }
    }

    /**
     * Resets the visited array for new traversals.
     */
    private void resetVisited() {
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
    }

    /**
     * Depth-First Search (DFS) - Recursive implementation.
     *
     * @param startVertex the starting vertex index
     */
    public void dfs(int startVertex) {
        resetVisited();
        System.out.print("DFS starting from " + getVertexName(startVertex) + ": ");
        dfsRecursive(startVertex);
        System.out.println();
    }

    /**
     * Recursive helper for DFS.
     */
    private void dfsRecursive(int vertex) {
        visited[vertex] = true;
        System.out.print(getVertexName(vertex) + " ");

        // Visit all adjacent vertices
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfsRecursive(i);
            }
        }
    }

    /**
     * Breadth-First Search (BFS) - Uses a queue.
     *
     * @param startVertex the starting vertex index
     */
    public void bfs(int startVertex) {
        resetVisited();
        System.out.print("BFS starting from " + getVertexName(startVertex) + ": ");

        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(getVertexName(vertex) + " ");

            // Add all unvisited adjacent vertices to the queue
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    /**
     * Finds the shortest path between two vertices in terms of number of edges.
     * Uses BFS to find the shortest path.
     *
     * @param start starting vertex index
     * @param end target vertex index
     * @return array representing the path, or null if no path exists
     */
    public int[] findShortestPath(int start, int end) {
        resetVisited();

        // Arrays to store parent of each vertex and distance
        int[] parent = new int[numVertices];
        int[] distance = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            parent[i] = -1;
            distance[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        distance[start] = 0;
        queue.add(start);

        // BFS to find shortest path
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                break; // Found the target
            }

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }

        // Check if path exists
        if (distance[end] == -1) {
            return null; // No path found
        }

        // Reconstruct the path by backtracking from end to start
        LinkedList<Integer> path = new LinkedList<>();
        int current = end;
        while (current != -1) {
            path.addFirst(current);
            current = parent[current];
        }

        // Convert to array
        int[] pathArray = new int[path.size()];
        int index = 0;
        for (int vertex : path) {
            pathArray[index++] = vertex;
        }

        return pathArray;
    }

    /**
     * Helper method to get vertex name.
     */
    public String getVertexName(int vertex) {
        if (vertexNames[vertex] != null) {
            return vertexNames[vertex];
        }
        return "V" + vertex;
    }

    /**
     * Displays the adjacency matrix.
     */
    public void displayAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("    ");
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%-4s", getVertexName(i));
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%-4s", getVertexName(i));
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%-4d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
