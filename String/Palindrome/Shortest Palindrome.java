public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        String result = null;
        
        for (int i = s.length() / 2; i >= 0; i--) {
            if ((result = helper(i - 1, i + 1, s)) != null) {
                return result;
            }
            
            if ((result = helper(i - 1, i, s)) != null) {
                return result;
            }
        }
        
        return result;
    }
    
    private String helper(int low, int high, String s) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        
        if (low == -1) {
            return new StringBuilder(s.substring(high)).reverse().append(s).toString();
        }
        else {
            return null;
        }
    }
}
