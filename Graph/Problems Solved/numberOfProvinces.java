import java.util.Scanner;

public class numberOfProvinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        if (V <= 0) {
            System.out.println("Invalid input for the number of vertices.");
            sc.close();
            return;
        }

        int[][] adj = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adj[i][j] = sc.nextInt();
            }
        }

        int ans = findNumOfProvinces(adj, V);
        System.out.println("The number of Provinces are : " + ans);

        sc.close();
    }

    static void dfs(int node, int[][] roads, int[] vis, int n) {
        vis[node] = 1;
        for (int i = 0; i < n; i++) {
            if (roads[node][i] == 1 && vis[i] == 0) {
                dfs(i, roads, vis, n);
            }
        }
    }

    public static int findNumOfProvinces(int[][] roads, int n) {
        int[] vis = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, roads, vis, n);
            }
        }
        return count;
    }
}
