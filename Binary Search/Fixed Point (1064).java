class Solution {
    public int fixedPoint(int[] A) {
        int low = 0;
        int high = A.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid <= A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low < A.length && A[low] == low ? low : -1;
    }
}
