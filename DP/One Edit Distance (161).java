public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if (m < n) {
            return isOneEditDistance(t, s);
        }
        
        if (m - n > 1) {
            return false;
        }
        
        int i = 0;
        int shift = m - n;
        
        while (i < n && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        
        if (shift == 0) {
            i++;
        }
        
        while (i < n && s.charAt(i + shift) == t.charAt(i)) {
            i++;
        }
        
        return i == n;
    }
}
