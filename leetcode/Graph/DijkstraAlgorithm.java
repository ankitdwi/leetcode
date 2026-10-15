package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    // Class to represent a node and its weight relative to a neighbor
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // Min-heap comparison based on the edge/path weight
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void dijkstra(List<List<Node>> adjList, int src, int numVertices) {
        // Array to store the shortest distance from source to each vertex
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Array to track parent nodes for path reconstruction
        int[] parent = new int[numVertices];
        Arrays.fill(parent, -1);

        // Min-Priority Queue tracking the next lowest-cost node
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));

        // Set to track finalized nodes
        boolean[] visited = new boolean[numVertices];

        while (!pq.isEmpty()) {
            // Extract the vertex with the minimum distance
            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            // Relax neighboring edges
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If a shorter path to v is found through u
                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        printSolution(src, dist, parent);
    }

    // Helper method to print distances and reconstruct paths
    private static void printSolution(int src, int[] dist, int[] parent) {
        System.out.println("Vertex\tDistance\tShortest Path");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(src + " -> " + i + "\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]) + "\t\t");
            if (dist[i] != Integer.MAX_VALUE) {
                printPath(i, parent);
            }
            System.out.println();
        }
    }

    // Recursive helper to backtrack the path from target to source
    private static void printPath(int currentVertex, int[] parent) {
        if (currentVertex == -1) {
            return;
        }
        printPath(parent[currentVertex], parent);
        System.out.print(currentVertex + " ");
    }

    public static void main(String[] args) {
        int numVertices = 5;
        List<List<Node>> adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Graph construction: Graph topology with node indexes (0 to 4)
        adjList.get(0).add(new Node(1, 9));
        adjList.get(0).add(new Node(2, 6));
        adjList.get(0).add(new Node(3, 5));
        adjList.get(0).add(new Node(4, 3));

        adjList.get(2).add(new Node(1, 2));
        adjList.get(2).add(new Node(3, 4));

        // Execute Dijkstra's starting from Source Node 0
        dijkstra(adjList, 0, numVertices);
    }
}
