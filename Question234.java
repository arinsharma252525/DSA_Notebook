//Topological Sorting using DFS
import java.util.ArrayList;
import java.util.Stack;
public class Question234 {
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

    public static void topologicalSort(ArrayList<Edge>[]graph){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[]graph, int curr, boolean visited[], Stack<Integer> s){
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.destination]) {
                topologicalSortUtil(graph, e.destination, visited, s);
            }
        }
        s.push(curr);   
    }

    public static void main(String[] args) {
       int numberOfVertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[numberOfVertices];

        createGraph(graph); 
        topologicalSort(graph);
    }
}
