class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = A.length - 1;
        
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            else if (A[mid - 1] > A[mid]) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        
        throw new IllegalArgumentException();
    }
}

