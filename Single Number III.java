public class Solution {
    public int[] twoSingleNumber(int[] A) {
        if (A == null || A.length < 2) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        
        int k = 0;
        
        while ((result >> k & 1) == 0) {
            k++;
        }
        
        int[] num = new int[2];
        
        for (int i = 0; i < A.length; i++) {
            if ((A[i] >> k & 1) == 0) {
                num[0] ^= A[i];
            }
            else {
                num[1] ^= A[i];
            }
        }
        
        return num;
    }
}
