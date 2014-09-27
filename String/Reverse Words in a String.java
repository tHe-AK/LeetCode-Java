public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int len = s.length();
        int end = -1;
        StringBuilder sb = new StringBuilder();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            
            if (i == len - 1 || s.charAt(i + 1) == ' ') {
                end = i;
            }
            
            if (i == 0 || s.charAt(i - 1) == ' ') {
                sb.append(s.substring(i, end + 1));
                sb.append(" ");
            }
        }
        
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}