public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return -1;
        }
        
        int cur = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] != A[i - 1]) {
                count = 1;
            }
            else {
                count++;
            }
            
            if (count <= 2) {
                A[cur] = A[i];
                cur++;
            }
        }
        
        return cur;
    }
}
