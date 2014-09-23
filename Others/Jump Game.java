public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (max < i) {
                return false;
            }
            
            max = Math.max(max, i + A[i]);
        }
        
        return true;
    }
}
