public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        boolean sign = false;
        boolean num = false;
        boolean dot = false;
        boolean e = false;
        
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = true;
            i++;
        }
        
        while (i < s.length()) {
            char cur = s.charAt(i);
            if ('0' <= cur && cur <= '9') {
                num = true;
                i++;
            }
            else if (cur == '.' && dot == false && e == false) {
                dot = true;
                i++;
            }
            else if ((cur == '+' || cur == '-') && sign == false && s.charAt(i - 1) == 'e') {
                sign = true;
                i++;
            }
            else if (cur == 'e' && e == false && num == true) {
                e = true;
                sign = false;
                num = false;
                dot = false;
                i++;
            }
            else if (cur == ' ') {
                i++;
                break;
            }
            else {
                return false;
            }
        }
        
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == s.length() && num) {
            return true;
        }
        
        return false;
    }
}
