public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int y = 0;

        while (x != 0) {
            int digit = x % 10;
            int curr = y * 10 + digit;
            
            if (y > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            
            x /= 10;
            y = curr;
        }

        return sign * y;
    }
}
