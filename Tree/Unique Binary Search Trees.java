public class Solution {
    public int numTrees(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if (n <= 1) {
            return 1;
        }
        
        int[] rec = new int[n + 1];
        rec[0] = 1;
        rec[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                rec[i] += rec[j] * rec[i - j - 1];
            }
        }
        
        return rec[n];
    }
}