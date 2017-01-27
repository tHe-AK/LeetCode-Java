public class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        long val = 0;
        int len = str.length();
        int i = 0;
        
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            
            i++;
        }
        
        while (i < len && '0' <= str.charAt(i) && str.charAt(i) <= '9') {
            int digit = sign * (str.charAt(i) - '0');
            val = val * 10 + digit;
            
            if (val > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            
            if (val < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int) val;
    }
}
