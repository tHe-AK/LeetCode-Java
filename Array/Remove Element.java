public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                continue;
            }
            
            A[cur] = A[i];
            cur++;
        }
        
        return cur;
    }
}