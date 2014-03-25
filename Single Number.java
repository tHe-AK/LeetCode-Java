public class Solution {
    public int singleNumber(int[] A) {
        if (A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur ^= A[i];
        }
        
        return cur;
    }
}
