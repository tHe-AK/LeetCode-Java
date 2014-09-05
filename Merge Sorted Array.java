public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (B == null || n == 0 || B.length < n) {
            return;
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
