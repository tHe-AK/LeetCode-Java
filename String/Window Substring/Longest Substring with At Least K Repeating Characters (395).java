public class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        int[] counts = new int[26];
        
        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                char ch = (char) ('a' + i);
                String[] strs = s.split(Character.toString(ch));
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
