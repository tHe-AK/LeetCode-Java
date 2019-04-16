class Solution {
    public int minSwap(int[] A, int[] B) {
        int swap = 1;
        int keep = 0;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                int temp = swap;
                swap = keep + 1;
                keep = temp;
            } else if (B[i - 1] >= A[i] || A[i - 1] >= B[i]) {
                swap++;
            } else {
                int min = Math.min(swap, keep);
                swap = min + 1;
                keep = min;
            }
        }
        
        return Math.min(swap, keep);
    }
}
