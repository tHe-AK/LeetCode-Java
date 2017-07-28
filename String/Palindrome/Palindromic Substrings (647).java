public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i - 1, i);
        }
        
        return count;
    }
    
    private int expandAroundCenter(String s, int start, int end) {
        int count = 0;
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        
        return count;
    }
}
