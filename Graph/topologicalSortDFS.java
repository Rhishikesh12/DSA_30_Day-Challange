package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class topologicalSortDFS {
    public static void dfs(int node, List<List<Integer>> adj, boolean vis[], Stack<Integer> s) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, s);
            }
        }
        s.push(node);
    }

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int src = edge[0];
            int des = edge[1];
            adj.get(src).add(des);
        }

        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, s);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        // Sample graph represented by edges
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 1, 5 },
                { 5, 4 }
        };

        int vertices = 6; // Total number of vertices in the graph
        int edgesCount = edges.length; // Total number of edges in the graph

        // Perform topological sorting
        List<Integer> result = topologicalSortDFS.topologicalSort(edges, edgesCount, vertices);

        // Print the topological order
        System.out.println("Topological Order:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
