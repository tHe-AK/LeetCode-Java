public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        
        if (len % 2 == 0) {
            return (findK(A, 0, B, 0, len / 2) + findK(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
        else {
            return findK(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    private int findK(int[] A, int i, int[] B, int j, int k) {
        if (i >= A.length) {
            return B[j + k - 1];
        }

        if (j >= B.length) {
            return A[i + k - 1];
        }

        if (k == 1) {
            return Math.min(A[i], B[j]);
        }

        int x = i + k / 2 - 1 < A.length ? A[i + k / 2 - 1] : Integer.MAX_VALUE;
        int y = j + k / 2 - 1 < B.length ? B[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (x <= y) {
            return findK(A, i + k / 2, B, j, k - k / 2);
        }
        else {
            return findK(A, i, B, j + k / 2, k - k / 2);
        }
    }
}
