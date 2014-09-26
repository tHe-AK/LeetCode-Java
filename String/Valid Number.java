public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int len = s.length();
        boolean num = false;
        boolean sign = false;
        boolean point = false;
        boolean e = false;
        
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '+')) {
            sign = true;
            i++;
        }
        
        while (i < len) {
            char cur = s.charAt(i);
            
            if ('0' <= cur && cur <= '9') {
                num = true;
            }
            else if ((cur == '+' || cur == '-') && !sign && !num && !point) {
                sign = true;
            }
            else if (cur == '.' && !point && !e) {
                point = true;
            }
            else if (cur == 'e' && !e && num) {
                e = true;
                num = false;
                sign = false;
                point = false;
            }
            else {
                break;
            }
            
            i++;
        }
        
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        
        return i == len && num;
    }
}