public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int low = 0;
        int high = A.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (A[mid] == target) {
                high = mid - 1;
            }
            else if (A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        if (low < A.length && A[low] == target) {
            result[0] = low;
        }
        else {
            return result;
        }
        
        low = 0;
        high = A.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (A[mid] == target) {
                low = mid + 1;
            }
            else if (A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        result[1] = high;
        
        return result;
    }
}