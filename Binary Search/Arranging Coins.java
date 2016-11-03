public class Solution {
    public int arrangeCoins(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            
            if (sum == n) {
                return mid;
            } else if (sum <= n) {
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
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }
}
