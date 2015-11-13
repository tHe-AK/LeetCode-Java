public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = s.length();
        int count;
        int low;
        int high;
        int max = 1;
        String result = s.substring(0, 1);
        
        for (int i = 0; i < len; i++) {
            count = 0;
            low = i - 1;
            high = i;
            
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                count += 2;
                low--;
                high++;
            }
            
            if (count > max) {
                max = count;
                result = s.substring(low + 1, high);
            }
            
            count = 1;
            low = i - 1;
            high = i + 1;
            
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                count += 2;
                low--;
                high++;
            }
            
            if (count > max) {
                max = count;
                result = s.substring(low + 1, high);
            }
        }
        
        return result;
    }
}