public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        if (A.length <= 1) {
            return A.length;
        }
        
        int cur = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (i != 0 && A[i] == A[i - 1]) {
                continue;
            }
            
            A[cur] = A[i];
            cur++;
        }
        
        return cur;
    }
}