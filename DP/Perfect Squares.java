public class Solution {
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        
        int[] rec = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            rec[i] = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                rec[i] = Math.min(rec[i], rec[i - j * j] + 1);
            }
        }
        
        return rec[n];
    }
}
