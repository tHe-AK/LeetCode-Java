class Solution {
    public static int findFirstBadVersion(boolean[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            
            if (!array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        if (low == array.length) {
            return -1;
        }
        else {
            return low;
        }
    }
}
