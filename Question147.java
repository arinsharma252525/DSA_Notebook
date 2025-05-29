//Best Time to Buy and Sell Stock
public class Question147 {
    public static int maxProfit(int prices[], int n) {
        int buy = prices[0];
        int max_profit = 0;
        for (int i = 1; i < n; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (prices[i] - buy > max_profit) {
                max_profit = prices[i] - buy;
            }
        }
        return max_profit;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 6, 4, 3, 1 };
        int n = prices.length;
        int max_profit = maxProfit(prices, n);
        System.out.println(max_profit);
    }
}
