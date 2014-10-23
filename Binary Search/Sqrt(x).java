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

public class Solution {
    public double sqrt(double x, double precision) {
        double low = 0;
        double high = x;
        double mid = low + (high - low) / 2;
        
        while (Math.abs(x - mid * mid) > precision) {
            if (mid * mid < x) {
                low = mid;
            }
            else {
                high = mid;
            }
            
            mid = low + (high - low) / 2;
        }
        
        return mid;
    }