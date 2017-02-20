public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || k < 0) {
            throw new IllegalArgumentException();
        }
        
        if (s.length() < k) {
            return 0;
        }
        
        int len = s.length();
        int[] counts = new int[26];
        
        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                char c = (char) ('a' + i);
                String[] strs = s.split(Character.toString(c));
                int result = 0;
                
                for (String str : strs) {
                    result = Math.max(result, longestSubstring(str, k));
                }
                
                return result;
            }
        }
        
        return len;
    }
}
