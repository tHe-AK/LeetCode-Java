public class Solution {
    public int maxSubArray(int[] A, int count) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        int[][] rec = new int[len][len];
        int cur;
        int[][] result = new int[count][len];

        for (int i = 0; i < len; i++) {
            cur = A[i];
            rec[i][0] = cur;
            
            for (int j = i + 1; j < len; j++) {
                cur = Math.max(cur + A[j], A[j]);
                rec[i][j] = Math.max(rec[i][j - 1], cur);
            }
        }
        
        for (int i = 0; i < count; i++) {
            for (int j = i; j < len; j++) {
                if (i == 0) {
                    result[i][j] = rec[0][j];
                }
                else {
                    int max = Integer.MIN_VALUE;
                    
                    for (int k = i - 1; k < j; k++) {
                        max = Math.max(max, result[i - 1][k] + rec[k + 1][j]);
                    }
                    
                    result[i][j] = max;
                }
            }
        }
        
        return result[count - 1][len - 1];
    }
}
