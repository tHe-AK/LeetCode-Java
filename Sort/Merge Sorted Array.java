public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) {
            throw new IllegalArgumentException();
        }
        
        m--;
        n--;
        
        while (n >= 0) {
            if (m >= 0 && A[m] > B[n]) {
                A[m + n + 1] = A[m];
                m--;
            }
            else {
                A[m + n + 1] = B[n];
                n--;
            }
        }
    }
}