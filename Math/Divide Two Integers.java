public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long result = 0;
        
        while (a >= b) {
            int shift = 0;
            
            while (a >= (b << shift)) {
                shift++;
            }
            
            shift--;
        
            a -= b << shift;
            result += (long) 1 << shift;
        }
        
        result = (dividend < 0) ^ (divisor < 0) ? -result : result;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return (int) result;
    }
}
