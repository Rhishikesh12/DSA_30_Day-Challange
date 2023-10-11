
/**
 * rottenOranges
 */

import java.util.*;

public class rottenOranges {

    static class Triplet {
        int row;
        int col;
        int time;

        public Triplet(int row, int col, int time) {
            this.col = col;
            this.row = row;
            this.time = time;
        }

    }

    public static void main(String args[]) {
        int arr[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }

    private static int orangesRotting(int[][] arr) {
        Queue<Triplet> q = new LinkedList<>();
        int n = arr.length;
        int m = arr[0].length;
        int vis[][] = new int[n][m];
        int counterFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Triplet(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (arr[i][j] == 1)
                    counterFresh++;
            }
        }

        int time = 0;
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };
        int cnt = 0;
        while (!q.isEmpty()) {
            Triplet tp = q.poll();
            int row = tp.row;
            int col = tp.col;
            int t = tp.time;
            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && arr[nrow][ncol] == 1) {
                    q.add(new Triplet(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != counterFresh)
            return -1;
        return time;
    }
}