public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        int end = len;
        StringBuilder sb = new StringBuilder();
        
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                if (i == len - 1 || s.charAt(i + 1) == ' ') {
                    end = i + 1;
                }
            
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    
                    sb.append(s.substring(i, end));
                }
            }
        }
        
        return sb.toString();
    }
}
