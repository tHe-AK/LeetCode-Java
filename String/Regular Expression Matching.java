public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0);
    }
    
    private boolean helper(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            int k = i;
            
            while (equal(s, k, p, j)) {
                if (helper(s, k + 1, p, j + 2)) {
                    return true;
                }
                
                k++;
            }
            
            return helper(s, i, p, j + 2);
        }
        else {
            return equal(s, i, p, j) && helper(s, i + 1, p, j + 1);
        }
    }
    
    private boolean equal(String s, int i, String p, int j) {
        return i < s.length() && (p.charAt(j) == '.' || (s.charAt(i) == p.charAt(j)));
    }
}
