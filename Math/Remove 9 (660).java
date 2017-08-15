public class Solution {
    public int newInteger(int n) {
        int res = 0;
        int base = 1;
        
        while (n > 0) {
            res += base * (n % 9);
            n /= 9;
            base *= 10;
        }
        
        return res;
    }
}
