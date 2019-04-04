class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int start = 0;
        int curr = 0;
        int count = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] < L) {
                count += curr;
            } else if (L <= A[i] && A[i] <= R) {
                curr = i - start + 1;
                count += curr;
            } else {
                start = i + 1;
                curr = 0;
            }
        }
        
        return count;
    }
}
