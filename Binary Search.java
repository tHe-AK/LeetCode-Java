import java.util.Arrays;

class Solution {
    /**
     * @param array source array
     * @param target target to search
     * @return the first occurrence position of target
     */
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = array.length - 1;
        int mid;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }
            else if (num[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}
