public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        
        int[] rec = new int[26];
        int len = s.length();
        int idx = 0;
        String result = "";
        
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
        
        return s.charAt(idx) + removeDuplicateLetters(s.substring(idx + 1).replaceAll(s.charAt(idx) + "", ""));
    }
}
