public class Solution {
    public int getMoneyAmount(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        int[][] rec = new int[n + 1][n + 1];
        
        return helper(1, n, rec);
    }
    
    private int helper(int start, int end, int[][] rec) {
        if (start >= end) {
            return 0;
        }
        
        if (rec[start][end] != 0) {
            return rec[start][end];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = start; i <= end; i++) {
            min = Math.min(min, i + Math.max(helper(start, i - 1, rec), helper(i + 1, end, rec)));
        }
        
        rec[start][end] = min;
        
        return min;
    }
}
