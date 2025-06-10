//Topological Sorting using BFS (Kahn's Algorithm)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question235 {
    static class Edge {
        int source;
        int destination;

        public Edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calculateInDegree(ArrayList<Edge>[] graph, int inDegree[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                inDegree[e.destination]++;
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int inDegree[] = new int[graph.length];
        calculateInDegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.destination]--;
                if (inDegree[e.destination] == 0) {
                    q.add(e.destination);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numberOfVertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[numberOfVertices];

        createGraph(graph);
        topologicalSort(graph);
    }
}
