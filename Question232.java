//Bipartite Graph
import java.util.*;
public class Question232 {
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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int numberOfVertices = graph.length;
        int[] color = new int[numberOfVertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < numberOfVertices; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int currentNode = queue.remove();

                    for (Edge edge : graph[currentNode]) {
                        int neighborNode = edge.destination;

                        if (color[neighborNode] == -1) {
                            color[neighborNode] = 1 - color[currentNode];
                            queue.add(neighborNode);
                        } else if (color[neighborNode] == color[currentNode]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numberOfVertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[numberOfVertices];

        createGraph(graph);

        if (isBipartite(graph)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is NOT bipartite.");
        }
    }
}