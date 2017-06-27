public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        
        while (dvd >= dvs) { 
            int shift = 0;
            
            while (dvd >= dvs << (shift + 1)) {
                shift++;
            }
            
            dvd -= dvs << shift;
            result += 1 << shift;
        }
        
        return sign == 1 ? result : -result; 
    }
}
