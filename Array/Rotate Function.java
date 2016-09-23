public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int sum = 0;
        int F = 0;
        int len = A.length;
        
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            sum += A[i];
        }
        
        int max = F;
        
        for (int i = len - 1; i > 0; i--) {
            F += sum - len * A[i];
            max = Math.max(max, F);
        }
        
        return max;
    }
}
