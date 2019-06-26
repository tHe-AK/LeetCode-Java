class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int i = 0;
        int j = 1;
        
        while (i < N && j < N) {
            while (i < N && A[i] % 2 == 0) {
                i += 2;
            }
            
            while (j < N && A[j] % 2 == 1) {
                j += 2;
            }
            
            if (i < N && j < N) {
                swap(A, i, j);
                i += 2;
                j += 2;
            }
        }
        
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
