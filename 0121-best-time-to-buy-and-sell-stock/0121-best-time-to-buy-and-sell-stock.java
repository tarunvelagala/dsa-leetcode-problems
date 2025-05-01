class Solution {

    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        // Causes TLE -
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1622650004
        // maxProfitBruteForce(prices);

        if(prices.length == 1) {
            return 0;
        }
        // Firstly we would initiate the buy price i.e the price at which we bought the stock i.e the intial buying price of the stock.
        int sellPrice = prices[0];
        // Initialize the maxProfit which is the result.
        int maxProfit = Integer.MIN_VALUE;
        // Iterate the array from i+1 to check the sell price.
        for (int i = 1; i < prices.length; i++) {
            // We calculate the minimum of the selling price so to gain maximum profit i.e with the minimum sell price we could get the maximum profit.
            sellPrice = Math.min(sellPrice, prices[i]);
            // Calculate if we have profit or loss.
            int profitOrLoss = prices[i] - sellPrice;
            // Calculate the maxProfit (If it is loss then its covered with maxProfit.
            maxProfit = Math.max(maxProfit, profitOrLoss);
        }
        return maxProfit;
    }
}
