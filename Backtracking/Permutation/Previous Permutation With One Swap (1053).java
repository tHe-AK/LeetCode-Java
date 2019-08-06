class Solution {
    public int[] prevPermOpt1(int[] A) {
        int i = A.length - 2;
        
        while (i >= 0 && A[i] <= A[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return A;
        }
        
        int j = A.length - 1;
        
        while (A[j] >= A[i] || A[j - 1] == A[j]) {
            j--;
        }
        
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
}
