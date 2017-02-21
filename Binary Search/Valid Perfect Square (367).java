public class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}

public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        
        while (num > 0) {
            num -= i;
            i += 2;
        }
        
        return num == 0;
    }
}
