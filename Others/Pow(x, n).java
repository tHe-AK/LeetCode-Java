public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double cur = pow(x, n / 2);
        
        if (n % 2 == 0) {
            return cur * cur;
        }
        else if (n > 0) {
            return cur * cur * x;
        }
        else {
            return cur * cur / x;
        }
    }
}
