public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1) {
            return 0;
        }
        
        int m = primes.length;
        int[] rec = new int[n];
        rec[0] = 1;
        int[] idx = new int[m];
        
        for (int i = 1; i < n; i++) {
            rec[i] = Integer.MAX_VALUE;
            
            for (int j = 0; j < m; j++) {
                rec[i] = Math.min(rec[i], rec[idx[j]] * primes[j]);
            }
            
            for (int j = 0; j < m; j++) {
                if (rec[i] == rec[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        
        return rec[n - 1];
    }
}
