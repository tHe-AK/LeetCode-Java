public class Solution {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        
        int[] rec = new int[n + 1];
        rec[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += rec[j] * rec[i - j - 1];
            }
            rec[i] = sum;
        }
        
        return rec[n];
    }
}
