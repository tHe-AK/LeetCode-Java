public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int j = 0;
        int star = -1;
        int pos = -1;
        
        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                pos = i;
                star = j;
                j++;
            }
            else if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (star != -1) {
                i = ++pos;
                j = star + 1;
            }
            else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}