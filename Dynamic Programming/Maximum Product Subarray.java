public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int max = A[0];
        int min = A[0];
        int result = A[0];
        
        for (int i = 1; i < A.length; i++) {
            int max_temp = max * A[i];
            int min_temp = min * A[i];
            
            max = Math.max(Math.max(max_temp, min_temp), A[i]);
            min = Math.min(Math.min(max_temp, min_temp), A[i]);
            
            result = Math.max(result, max);
        }
        
        return result;
    }
}