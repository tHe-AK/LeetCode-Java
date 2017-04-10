public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int start = 0;

        for (int i = 0; i <= len; i++) {
            if (i == len || str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        
        return new String(str);
    }
    
    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}
