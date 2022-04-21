package leetcode.Graph;

public class Edge {
    int src;
    int nbr;
    int weight;

    public Edge(int src, int nbr, int weight) {
        this.src = src;
        this.nbr = nbr;
        this.weight = weight;
    }
}