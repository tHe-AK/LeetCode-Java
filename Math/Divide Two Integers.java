public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        
        while (a >= b) {
            for (int i = 0; b << i <= a; i++) {
                a -= b << i;
                result += 1 << i;
            }
        }
        
        return ((dividend >> 31 ^ divisor >> 31) == 0) ? result : -result;
    }
}