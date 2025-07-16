//Stock Buy and Sell – Max one Transaction Allowed
public class Question9 {
    public static int maximumProfit(int prices[]) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 1, 3, 6, 9, 11 };
        System.out.println(maximumProfit(prices));
    }
}