public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        int profit = 0;
        int low = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i] - low);
        }
        
        return profit;
    }
}
