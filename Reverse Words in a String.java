public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        StringBuffer result = new StringBuffer("");
        int end = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                if (i == s.length() - 1 || s.charAt(i + 1) == ' ') {
                    end = i;
                    result.append(' ');
                }
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    for (int j = i; j <= end; j++) {
                        result.append(s.charAt(j));
                    }
                }
            }
        }
        
        if (result.length() > 0) {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
