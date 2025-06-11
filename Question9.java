//Best Time to Buy and Sell Stock
public class Question9 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int prices[] = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));
    }
}