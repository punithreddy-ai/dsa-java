public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];        // found cheaper buy day
            } else {
                int profit = prices[i] - minPrice;  // sell today
                if (profit > maxProfit) {
                    maxProfit = profit;      // best profit so far
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices)); // 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2)); // 0 (prices only fall)
    }
}