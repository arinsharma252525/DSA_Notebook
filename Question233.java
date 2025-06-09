
//Cycle Detection
import java.util.ArrayList;

public class Question233 {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int current, boolean visited[], boolean stack[]) {
        visited[current] = true;
        stack[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (stack[e.destination]) {
                return true;
            }
            if (!visited[e.destination] && isCycleUtil(graph, e.destination, visited, stack)) {
                return true;
            }
        }
        stack[current] = false;
        return false;
    }

    public static void main(String[] args) {
        int numberOfVertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[numberOfVertices];

        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
