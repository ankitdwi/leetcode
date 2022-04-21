package leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CycleInGraph {
    class Pair {
        int vertex;
        String pathSoFar;

        public Pair(int v, String pathSoFar) {
            this.vertex = v;
            this.pathSoFar = pathSoFar;
        }
    }

    public void isCyclic(int[] vertices, int[] edges, int[] weights) {
        List<List<Edge>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(vertices[i]).add(new Edge(vertices[i], edges[i], weights[i]));
            adjacencyList.get(edges[i]).add(new Edge(edges[i], vertices[i], weights[i]));
        }

        for (int v = 0; v < vertices.length; v++) {
            if (visited[v] == false) {
               boolean cycle = isCyclicUtil(adjacencyList, v, visited);
               if(cycle)
                   System.out.println(true);
            }
        }
    }

    public boolean isCyclicUtil(List<List<Edge>> adjacencyList, int src, boolean[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (!queue.isEmpty()) {
            Pair currPair = queue.remove();

            if(visited[currPair.vertex] == true) {
                return true;
            }
            visited[currPair.vertex] = true;

            for (Edge e : adjacencyList.get(currPair.vertex)) {
                if(visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, currPair.pathSoFar + e.nbr));
                }
            }
        }

        return false;
    }
}
