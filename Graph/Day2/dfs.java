package Day2;

import java.util.*;

public class dfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of nodes :");
        int node = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter total number of Edges :");
        int edge = sc.nextInt();
        for (int i = 0; i < edge; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        ArrayList<Integer> ans = dfsOfGraph(node, adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
        sc.close();
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfsmethod(0, adj, ls, vis);
        return ls;
    }

    static void dfsmethod(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls, boolean vis[]) {
        vis[node] = true;
        ls.add(node);

        for (Integer i : adj.get(node)) {
            if (!vis[i]) {
                dfsmethod(i, adj, ls, vis);
            }
        }
    }
}
