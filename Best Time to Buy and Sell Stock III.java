public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[] first = new int[len];
        int[] second = new int[len];
        
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            first[i] = Math.max(prices[i] - min, first[i - 1]);
            min = Math.min(min, prices[i]);
        }
        
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            second[i] = Math.max(max - prices[i], second[i + 1]);
            max = Math.max(max, prices[i]);
        }
        
        int profit = 0;
        for (int i = 0; i < len; i++) {
            profit = Math.max(profit, first[i] + second[i]);
        }
        
        return profit;
    }
}
