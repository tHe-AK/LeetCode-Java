public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        if (A == null || A.length == 0) {
            return result;
        }
        
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {
                result[0] = mid;
                high = mid - 1;
            }
            else if (A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        if (result[0] == -1) {
            return result;
        }
        
        low = 0;
        high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {
                result[1] = mid;
                low = mid + 1;
            }
            else if (A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return result;
    }
}
