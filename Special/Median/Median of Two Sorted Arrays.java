public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length + B.length;
        
        if (len % 2 == 0) {
            return (helper(A, 0, B, 0, len / 2) + helper(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
        else {
            return helper(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    private int helper(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        
        int A_mid = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_mid = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (A_mid <= B_mid) {
            return helper(A, A_start + k / 2, B, B_start, k - k / 2);
        }
        else {
            return helper(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}