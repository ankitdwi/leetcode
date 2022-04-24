package leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {
    public static void main(String[] args) {
        int n = 5, m = 5;
        int[][] prerequisites = new int[m][2];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            graph.get(v).add(u);
        }

        findOrder(n, graph);
    }

    public static int[] findOrder(int n, List<List<Integer>> graph) {
        int[] inDegrees = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int nbrs : graph.get(i)) {
                inDegrees[nbrs]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            ans[idx] = curr;
            idx++;

            for (int nbr : graph.get(curr)) {
                inDegrees[nbr]--;

                if (inDegrees[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        if(idx == n ) {
            return ans;
        } else {
            return new int[]{-1};
        }
    }
}
