import java.util.*;

public class numberOfIsland {

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '0', '1', '1', '1', '0', '0', '0' },
                { '0', '0', '1', '1', '0', '1', '0' }
        };

        int ans = numberOfIslands(grid);

        System.out.println(ans);
    }

    public static int numberOfIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    public static void bfs(int row, int col, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        vis[row][col] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));

        while (!q.isEmpty()) {
            Node node = q.poll();
            row = node.row;
            col = node.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1'
                        && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Node(newRow, newCol));
                }
            }
        }
    }
}
