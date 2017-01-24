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

public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, len - 1);
        int index = 0;
        int i = 0;

        while (i < len) {
            if (chars[i] != ' ') {
                if (index > 0) {
                    chars[index++] = ' ';
                }
                
                int start = index;
            
                while (i < len && chars[i] != ' ') {
                    chars[index++] = chars[i++];
                }
                
                reverse(chars, start, index - 1);
            } else {
                i++;
            }
        }
        
        return new String(chars).substring(0, index);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
