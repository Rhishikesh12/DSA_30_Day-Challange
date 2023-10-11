import java.util.Scanner;

public class floodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Rows :");
        int n = sc.nextInt();
        System.out.println("Enter number of Colums :");
        int m = sc.nextInt();

        System.out.println("X coordinate :");
        int x = sc.nextInt();
        System.out.println("Y coordinate:");
        int y = sc.nextInt();
        System.out.println("Enter Color Key :");
        int k = sc.nextInt();

        int[][] image = new int[n][m];

        System.out.println("Enter the matrix values : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        int[][] ans = floodFillFunction(image, x, y, k);

        System.out.println("Newly Painted Matrix : ");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }

    private static int[][] floodFillFunction(int[][] image, int i, int j, int k) {

        int iniColor = image[i][j];
        int[][] res = image;
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };
        dfs(i, j, image, iniColor, res, delrow, delcol, k);
        return res;
    }

    private static void dfs(int x, int y, int[][] image, int iniColor, int[][] res, int[] delrow, int[] delcol,
            int newColor) {

        res[x][y] = newColor;

        int n = res.length; // row
        int m = res[0].length; // col
        // there are exactly 4 neighbours
        for (int i = 0; i < 4; i++) {
            int nrow = x + delrow[i];
            int mcol = y + delcol[i];
            if (nrow >= 0 && nrow < n && mcol >= 0 && mcol < m && image[nrow][mcol] == iniColor
                    && res[nrow][mcol] != newColor) {
                dfs(nrow, mcol, image, iniColor, res, delrow, delcol, newColor);
            }
        }
    }
}
