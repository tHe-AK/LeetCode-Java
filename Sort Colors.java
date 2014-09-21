class Solution {
public:
    void sortColors(int A[], int n) {
        if (n <= 1) {
            return;
        }
        
        int r = 0;
        int w = 0;
        int b = n - 1;
        
        while (w <= b) {
            if (A[w] == 0) {
                swap(A[w++], A[r++]);
            }
            else if (A[w] == 2) {
                swap(A[w], A[b--]);
            }
            else {
                w++;
            }
        }
    }
};
