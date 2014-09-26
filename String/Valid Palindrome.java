public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        if (s.length() == 0) {
            return true;
        }
        
        int low = 0;
        int high = s.length() - 1;
        
        while (low < high) {
            if (!isAlphanumeric(s.charAt(low))) {
                low++;
            }
            else if (!isAlphanumeric(s.charAt(high))) {
                high--;
            }
            else if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                return false;
            }
            else {
                low++;
                high--;
            }
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')) {
            return true;
        }
        else {
            return false;
        }
    }
}