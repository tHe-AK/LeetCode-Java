public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            if (i > 0 && A[i - 1] > A[i]) {
                left[i] = left[i - 1];
            }
            
            left[i]++;
            max = Math.max(max, left[i]);
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && A[i] < A[i + 1]) {
                right[i] = right[i + 1];
            }
            
            right[i]++;
            max = Math.max(max, right[i]);
        }
        
        return max;
    }
}
