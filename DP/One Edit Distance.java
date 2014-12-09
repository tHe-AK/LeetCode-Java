public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        
        int m = s.length();
        int n = t.length();
        
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        
        if (n - m > 1) {
            return false;
        }
        
        int i = 0;
        int shift = n - m;
        
        while (i < m && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        
        if (shift == 0) {
            i++;
        }
        
        while (i < m && s.charAt(i) == t.charAt(i + shift)) {
            i++;
        }
        
        return i == m;
    }
}
