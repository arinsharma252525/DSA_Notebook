//Course Schedule II
import java.util.*;
public class Question236 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        Question236 solver = new Question236();

        int numCourses1 = 2;
        int[][] prerequisites1 = { { 1, 0 } };
        int[] result1 = solver.findOrder(numCourses1, prerequisites1);
        System.out.print("Input: numCourses = " + numCourses1 + ", prerequisites = [[1,0]] -> Output: ");
        if (result1.length == 0) {
            System.out.println("[] (No valid order)");
        } else {
            System.out.println(Arrays.toString(result1));
        }

        int numCourses2 = 4;
        int[][] prerequisites2 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] result2 = solver.findOrder(numCourses2, prerequisites2);
        System.out.print(
                "Input: numCourses = " + numCourses2 + ", prerequisites = [[1,0],[2,0],[3,1],[3,2]] -> Output: ");
        if (result2.length == 0) {
            System.out.println("[] (No valid order)");
        } else {
            System.out.println(Arrays.toString(result2));
        }

        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        int[] result3 = solver.findOrder(numCourses3, prerequisites3);
        System.out.print("Input: numCourses = " + numCourses3 + ", prerequisites = [[1,0],[0,1]] -> Output: ");
        if (result3.length == 0) {
            System.out.println("[] (No valid order)");
        } else {
            System.out.println(Arrays.toString(result3));
        }
    }
}