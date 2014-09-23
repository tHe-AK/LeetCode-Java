public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int[] bits = new int[32];
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }
            
            result |= bits[i] << i;
        }
        
        return result;
    }
}
