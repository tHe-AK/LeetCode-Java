public class Solution {
    public int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        
        if (x == 0) {
            return 0;
        }
        
        int low = 1;
        int high = x;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid == x / mid) {
                return mid;
            }
            else if (mid < x / mid) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return high;
    }
}