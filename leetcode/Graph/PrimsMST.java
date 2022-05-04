package leetcode.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMST {
    class Pair implements Comparable<Pair> {
        int vertex;
        int acquiringVertex;
        int weight;

        public Pair(int vertex, int acquiringVertex, int weight) {
            this.vertex = vertex;
            this.acquiringVertex = acquiringVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public void solution(int[] vertices, int[] edges, int[] weights) {
        List<Edge>[] graph = new ArrayList[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[vertices[i]].add(new Edge(vertices[i], edges[i], weights[i]));
            graph[edges[i]].add(new Edge(edges[i], vertices[i], weights[i]));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0,-1,0));
        boolean[] visited = new boolean[vertices.length];
        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited[rem.vertex] == true) {
                continue;
            }
            visited[rem.vertex] = true;

            if(rem.vertex != -1)
                System.out.println(rem.vertex);

            for (Edge e: graph[rem.vertex]) {
                queue.add(new Pair(e.nbr, rem.vertex, e.weight));
            }
        }
    }
}
