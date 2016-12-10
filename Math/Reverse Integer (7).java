public class Solution {
    public int reverse(int x) {
        int y = 0;

        while (x != 0) {
            int digit = x % 10;
            int curr = y * 10 + digit;
            
            if ((curr - digit) / 10 != y) {
                return 0;
            }
            
            x /= 10;
            y = curr;
        }

        return y;
    }
}
