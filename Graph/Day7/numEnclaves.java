import java.util.*;

public class numEnclaves {

    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size :");
        int V = sc.nextInt();

        if (V <= 0) {
            System.out.println("Invalid input for the number of vertices.");
            sc.close();
            return;
        }

        System.out.println("Enter Matrix: ");
        int[][] adj = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adj[i][j] = sc.nextInt();
            }
        }

        int ans = numberOfEnclaves(adj);
        System.out.println("The number of Provinces are : " + ans);

        sc.close();
    }

    private static int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delrow = { 1, 0, -1, 0 };
        int[] delcol = { 0, -1, 0, 1 };

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int ro = pair.row;
            int co = pair.col;

            for (int i = 0; i < 4; i++) {
                int nrow = ro + delrow[i];
                int ncol = co + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}