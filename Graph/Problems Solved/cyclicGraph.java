import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Classes.Node;

public class cyclicGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++)
            vis[i] = false;
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (detectCycle(i, adj, vis))
                    return true;
            }
        }

        return false;
    }

    public static boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int i : adj.get(node)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(new Node(i, node));
                } else if (parent != i) {
                    return true;
                }
            }
        }
        return false;
    }
}
