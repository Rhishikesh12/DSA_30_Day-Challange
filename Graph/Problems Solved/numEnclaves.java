import java.util.Scanner;

public class numEnclaves {

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

        int ans = numberOfEnclaves(adj);
        System.out.println("The number of Provinces are : " + ans);

        sc.close();
    }

    private static int numberOfEnclaves(int[][] adj) {
        return 0;
    }
}