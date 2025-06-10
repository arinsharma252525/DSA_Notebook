//Detect cycle in an undirected graph using BFS
import java.util.*;
public class Question239 {
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private static boolean bfsCycleCheck(int src, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        visited[src] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], parent = curr[1];
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        adj.get(3).add(4); adj.get(4).add(3);

        if (hasCycle(V, adj)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}