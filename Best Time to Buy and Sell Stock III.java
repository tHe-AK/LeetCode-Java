public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        if (prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int low = prices[0];
        int high = prices[len - 1];
        
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], high - prices[i]);
            high = Math.max(high, prices[i]);
        }
        
        for (int i = 0; i < len; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}
