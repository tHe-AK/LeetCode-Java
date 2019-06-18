class Solution {
    public int[] sortArrayByParity(int[] A) {
        int low = 0;
        int high = A.length - 1;
        
        while (low < high) {
            if (A[low] % 2 == 0) {
                low++;
            } else {
                swap(A, low, high--);
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
