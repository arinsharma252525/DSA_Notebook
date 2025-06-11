//Best Time to Buy and Sell Stock
public class Question9 {
    public static int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                max = Math.max(max, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return max;
    } 
    public static void main(String args[]) {
        int prices[] = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));
    }
}