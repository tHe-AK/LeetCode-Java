public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        s = s.trim();
        int i = 0;
        int len = s.length();
        boolean num = false;
        boolean sign = false;
        boolean e = false;
        boolean point = false;
        
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
        
        return i == len && num;
    }
}
