public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] rec = new int[26];
        int len = s.length();
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            rec[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (ch < s.charAt(idx)) {
                idx = i;
            }
            
            if (--rec[ch - 'a'] == 0) {
                break;
            }
        }
        
        return len == 0 ? "" : s.charAt(idx) + removeDuplicateLetters(s.substring(idx + 1).replaceAll(s.charAt(idx) + "", ""));
    }
}
