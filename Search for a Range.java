public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return null;
        }
        
        int[] result = new int[] { -1, -1 };
        
        int low = 0;
        int high = A.length - 1;
        int mid;
        
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        if (low == A.length || A[low] != target) {
            return result;
        }
        else {
            result[0] = low;
        }
        
        low = 0;
        high = A.length - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        result[1] = high;
        return result;
    }
}
