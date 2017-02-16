public class Solution {
    public String removeDuplicateLetters(String s) {
        String result = "";
        
        while (s.length() > 0) {
            int len = s.length();
            int[] rec = new int[26];
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
            
            result += s.charAt(idx);
            s = s.substring(idx + 1).replaceAll(s.charAt(idx) + "", "");
        }
        
        return result;
    }
}
