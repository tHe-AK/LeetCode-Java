public class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int val = 0;
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

            if (val > 0 && val > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            }
                
            if (val < 0 && val < (Integer.MIN_VALUE - digit) / 10) {
                return Integer.MIN_VALUE;
            }
            
            val = val * 10 + digit;
            i++;
        }
        
        return val;
    }
}
