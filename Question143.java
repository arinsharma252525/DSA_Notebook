//Chocola Problem
import java.util.Arrays;
import java.util.Collections;
public class Question143 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        Integer verticalCost[] = { 2, 1, 3, 1, 4 };
        Integer horizontalCost[] = { 4, 1, 2 };

        Arrays.sort(verticalCost, Collections.reverseOrder());
        Arrays.sort(horizontalCost, Collections.reverseOrder());

        int h = 0, v = 0;
        int horizontalPiece = 1;
        int verticalPiece = 1;
        int cost = 0;

        while (h < horizontalCost.length && v < verticalCost.length) {
            if (verticalCost[v] <= horizontalCost[h]) {
                cost += (horizontalCost[h] * verticalPiece);
                horizontalPiece++;
                h++;
            } else {
                cost += (verticalCost[v] * horizontalPiece);
                verticalPiece++;
                v++;
            }
        }
        while (h < horizontalCost.length) {
            cost += (horizontalCost[h] * verticalPiece);
            horizontalPiece++;
            h++;
        }

        while (v < verticalCost.length) {
            cost += (verticalCost[v] * horizontalPiece);
            verticalPiece++;
            v++;
        }
        System.out.println("Minimum cost of cuts: " + cost);
    }
}
