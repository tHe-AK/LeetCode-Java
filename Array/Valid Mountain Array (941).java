class Solution {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;
        
        while (i < N - 2 && A[i] < A[i + 1]) {
            i++;
        }
        
        if (i == 0) {
            return false;
        }
        
        while (i < N - 1 && A[i] > A[i + 1]) {
            i++;
        }
        
        return i == N - 1;
    }
}
