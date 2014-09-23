public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        
        return result;
    }
}
