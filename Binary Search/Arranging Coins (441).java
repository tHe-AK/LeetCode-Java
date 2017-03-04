public class Solution {
    public int arrangeCoins(int n) {
        int low = 0;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            
            if (sum <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high;
    }
}

public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }
}
