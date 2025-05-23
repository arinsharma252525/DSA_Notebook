//Grid Ways- Find the number of ways to reach from (0,0) to (N-1, M-1) in an NxM Grid.Allowed moves - right or down.
public class Question74 {
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == n) {
            return 0;
        }

        int way1 = gridWays(i + 1, j, n, m);
        int way2 = gridWays(i, j + 1, n, m);
        return way1 + way2;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        System.out.println(gridWays(0, 0, n, m));
    }
}
