public class Solution {
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        
        int i = 0;
        int len = str.length();
        int sign = 1;
        long value = 0;
        long result = 0;
        
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
            value = value * 10 + str.charAt(i) - '0';
            result = sign * value;
                
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
                
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }
        
        return (int) (result);  
    }
}
