public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int pre = s.length() - 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            
            if (i == s.length() - 1 || s.charAt(i + 1) == ' ') {
                pre = i;
            }
            
            if (i == 0 || s.charAt(i - 1) == ' ') {
                sb.append(' ');
                sb.append(s.substring(i, pre + 1));
            }
        }
        
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
