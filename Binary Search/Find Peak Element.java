public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = num.length - 1;
        
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            
            if (num[mid - 1] < num[mid] && num[mid] > num[mid + 1]) {
                return mid;
            }
            else if (num[mid - 1] > num[mid]) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        
        return num[low] < num[high] ? high : low; 
    }
}
