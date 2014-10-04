public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        int len = prices.length;
        int profit = 0;
        int min = Integer.MAX_VALUE;
        int[] left = new int[len];
        int max = Integer.MIN_VALUE;
        int[] right = new int[len];
        
        for (int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = i > 0 ? Math.max(left[i - 1], prices[i] - min) : prices[i] - min;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = i < len - 1 ? Math.max(right[i + 1], max - prices[i]) : max - prices[i];
        }
        
        for (int i = 0; i < len; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}