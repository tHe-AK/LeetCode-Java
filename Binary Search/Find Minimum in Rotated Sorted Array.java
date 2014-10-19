public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = num.length - 1;
        
        while (low <= high) {
            if (num[low] <= num[high]) {
                return num[low];
            }
            
            int mid = low + (high - low) / 2;
            
            if (num[low] <= num[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        throw new IllegalArgumentException();
    }
}
