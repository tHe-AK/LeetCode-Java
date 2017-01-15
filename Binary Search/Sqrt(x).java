public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int low = 1;
        int high = x;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high;
    }
}

public class Solution {
    public double mySqrt(double x, double precision) {
        if (x == 0) {
            return 0;
        }
        
        double low = 1;
        double high = x;
        
        if (x < 1) {
            low = x;
            high = 1;
        }
        
        while (low <= high) { 
            double mid = low + (high - low) / 2;

            if (Math.abs(x - mid * mid) <= precision) {
                return mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                high = mid;
            }            
        }
        
        throw new IllegalArgumentException();
    }
}
