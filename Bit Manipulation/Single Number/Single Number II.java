public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[32];
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                rec[i] += A[j] >> i & 1;
                rec[i] %= 3;
            }
            
            result |= rec[i] << i;
        }
        
        return result;
    }
}