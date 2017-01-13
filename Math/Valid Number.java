public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int i = 0;
        int len = s.length();
        boolean num = false;
        boolean sign = false;
        boolean e = false;
        boolean point = false;
        
        while (i < len) {
            char c = s.charAt(i);
            
            if ('0' <= c && c <= '9') {
                num = true;
            }
            else if ((c == '+' || c == '-') && !sign && !num && !point) {
                sign = true;
            }
            else if (c == '.' && !point && !e) {
                point = true;
            }
            else if (c == 'e' && !e && num) {
                e = true;
                num = false;
                sign = false;
                point = false;
            }
            else {
                return false;
            }
            
            i++;
        }
        
        return num;
    }
}
