public class Solution {
    public int findNthDigit(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        int digit = 1;
        long count = 9;
        int num = 1;
        
        while (n > digit * count) {
            num += count;
            n -= digit * count;
            digit++;
            count *= 10;
        }
        
        return Integer.toString(num + (n - 1) / digit).charAt((n - 1) % digit) - '0';
    }
}
