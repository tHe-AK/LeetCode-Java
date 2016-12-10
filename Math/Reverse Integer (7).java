public class Solution {
    public int reverse(int x) {
        int y = 0;

        while (x != 0) {
            int val = x % 10;
            int curr = y * 10 + val;
            
            if ((curr - val) / 10 != y) {
                return 0;
            }
            
            x /= 10;
            y = curr;
        }

        return y;
    }
}
