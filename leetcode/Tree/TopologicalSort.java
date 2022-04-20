package leetcode.Tree;

import java.io.*;
        import java.util.*;

public class TopologicalSort {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] sources = new Integer[]{0,1,2,0,4,5,4};
        Integer[] destinations = new Integer[]{1,2,3,3,5,6,6};

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < sources.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < sources.length; i++) {
            graph.get(sources[i]).add(new Edge(sources[i], destinations[i]));
        }


        boolean[] visited = new boolean[sources.length];
        Stack<Integer> stack = new Stack<>();

        for (int v = 0; v < sources.length; v++) {
            if (visited[v] == false) {
                topologicalSort(graph, v, visited, stack);
            }
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSort(List<List<Edge>> graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for (Edge e: graph.get(src)) {
            if (visited[e.nbr] == false) {
                topologicalSort(graph, e.nbr, visited, st);
            }

            st.push(e.nbr);
        }
    }

}