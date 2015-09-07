public class Solution {
    public int numWays(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return k;
        }
        
        int[] rec = new int[n + 1];
        rec[1] = k;
        rec[2] = k * k;
        
        for (int i = 3; i <= n; i++) {
            rec[i] = (rec[i - 2] + rec[i - 1]) * (k - 1);
        }
        
        return rec[n];
    }
}
