public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return -1;
        }
        
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] != A[i - 1]) {
                A[cur] = A[i];
                cur++;
            }
        }
        
        return cur;
    }
}
