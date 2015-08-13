public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        if (A == null || k < 0 || target < 0) {
            throw new IllegalArgumentException();
        }
        
        int n = A.length;
        int[][][] rec = new int[n + 1][k + 1][target + 1];
        
        for (int i = 0; i <= n; i++) {
            rec[i][0][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    rec[i][j][t] = 0;
                    rec[i][j][t] += rec[i - 1][j][t];
                    
                    if (t >= A[i - 1]) {
                        rec[i][j][t] += rec[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        
        return rec[n][k][target];
    }
}
