public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        
        int low = 0;
        int high = s.length() - 1;
        
        while (low < high) {
            if (!Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            } else if (!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            } else if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        
        return true;
    }
}
