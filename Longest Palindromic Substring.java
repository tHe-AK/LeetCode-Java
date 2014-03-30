public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() == true) {
            return "";
        }
        
        int[] max = new int[1];
        max[0] = -1;
        String[] result = new String[1];
        result[0] = "";
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i, max, result);
            helper(s, i - 1, i, max, result);
        }
        
        return result[0];
    }
    
    private void helper(String s, int low, int high, int[] max, String[] result) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        
        int len = high - low - 1;
        if (len > max[0]) {
            max[0] = len;
            result[0] = s.substring(low + 1, high);
        }
    }
}
