public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        
        return profit;
    }
}