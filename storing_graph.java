// How to Store a graph in adjacency list [Directed and Undirected]

import java.util.*;

public class storing_graph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of Vertices/ nodes : ");
        int nodes = sc.nextInt();

        // Using List<List<Integer>> for the adjacency list
        // * We can use ArrayList<Integer>[] for strict and specific type constraint,
        // Time complexity: O(2E)
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {

            // ! Why are we adding new ArrayList here?
            // * For each iteration, it adds a new ArrayList<Integer> to the adj list. This
            // * newly created ArrayList represents the adjacency list for a vertex.
            adjList.add(new ArrayList<>());
            // adjList[i] = new ArrayList<>();
        }

        System.out.println("Enter the number of edges : ");
        int edge = sc.nextInt();

        for (int i = 0; i < edge; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        sc.close();
    }
}