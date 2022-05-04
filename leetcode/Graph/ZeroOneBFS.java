package leetcode.Graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZeroOneBFS {
    public static void zeroOneGraph(int[] vertices, int[] edges, int weights, int target) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertices.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < vertices.length; i++) {
            graph.get(vertices[i]).add(new Edge(vertices[i], edges[i], 0));
            graph.get(vertices[i]).add(new Edge(edges[i], vertices[i], 1));
        }

        Deque<Edge> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices.length];

        queue.add(new Edge(0,-1,0));

        while (!queue.isEmpty()) {
            Edge removed = queue.removeFirst();

            if(removed.src == target) {
                System.out.println(removed.weight);
                return;
            }
            visited[removed.src] = true;

            for (Edge edge : graph.get(removed.src)) {
                if (visited[edge.nbr]) {
                    continue;
                }

                if (edge.weight == 0) {
                    queue.addFirst(new Edge(edge.src, edge.nbr, removed.weight + 0));
                } else {
                    queue.addLast(new Edge(edge.src, edge.nbr, removed.weight + 1));
                }
            }
        }
    }
}
