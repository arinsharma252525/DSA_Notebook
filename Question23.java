//Given a route containing 4 directions (E,W,N,S). Find the shortest path to reach destination.
public class Question23 {
    public static float shortestPath(String path) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);

            // South
            if (direction == 'S') {
                y--;
            }

            // North
            else if (direction == 'N') {
                y++;
            }

            // West
            else if (direction == 'W') {
                x--;
            }

            // East
            else {
                x++;
            }
        } 
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        String direction = "WNEENESENNN";
        System.out.println(shortestPath(direction));
    }
}