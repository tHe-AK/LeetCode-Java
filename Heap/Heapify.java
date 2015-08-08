public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        
        for (int i = 1; i < A.length; i++) {
            int cur = i;
            
            while (cur != 0 && A[(cur - 1) / 2] > A[cur]) {
                int temp = A[cur];
                A[cur] = A[(cur - 1) / 2];
                A[(cur - 1) / 2] = temp;
                cur = (cur - 1) / 2;
            }
        }
    }
}
