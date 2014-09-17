public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        if (prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        int low = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        
        return profit;
    }
}
