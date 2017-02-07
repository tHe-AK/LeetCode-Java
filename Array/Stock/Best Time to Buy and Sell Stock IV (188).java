public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        
        if (k >= len - 1) {
            return getMaxProfit(prices);
        }
        
        int[] min = new int[k + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[] profit = new int[k + 1];

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                min[i] = Math.min(min[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - min[i]);
            }
        }
        
        return profit[k];
    }
    
    private int getMaxProfit(int[] prices) {
        int sum = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            
            if (diff > 0) {
                sum += diff;
            }
        }
        
        return sum;
    }
}
