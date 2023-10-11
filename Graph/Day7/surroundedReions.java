public class surroundedReions {
    public static void main(String[] args) {
        char mat[][] = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } };

        char[][] ans = fill(mat);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        char[][] vis = new char[n][m];
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        // traverse row
        for (int j = 0; j < m; j++) {
            // first row
            if (vis[0][j] == 0 && grid[0][j] == 'O') {
                dfs(0, j, vis, grid, delrow, delcol);
            }

            // last row
            if (vis[n - 1][j] == 0 && grid[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, grid, delrow, delcol);
            }
        }

        // traverse column
        for (int i = 0; i < n; i++) {
            // first col
            if (vis[i][0] == 0 && grid[i][0] == 'O') {
                dfs(i, 0, vis, grid, delrow, delcol);
            }

            // last col
            if (vis[i][m - 1] == 0 && grid[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, grid, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }

        return grid;
    }

    static void dfs(int n, int m, char[][] vis, char[][] grid,
            int[] delrow, int[] delcol) {
        vis[n][m] = 1;

        for (int i = 0; i < 4; i++) {
            int nrow = n + delrow[i];
            int ncol = m + delcol[i];

            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] == 0
                    && grid[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, grid, delrow, delcol);
            }
        }
    }
}
