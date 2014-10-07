public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] != i + 1 && A[i] - 1 < A.length && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        
        int i;
        
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return i + 1;
    }
}