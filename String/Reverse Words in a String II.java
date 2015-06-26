public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        
        int start = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                continue;
            }
            else {
                if (i == 0 || s[i - 1] == ' ') {
                    start = i;
                }
            
                if (i == s.length - 1 || s[i + 1] == ' ') {
                    helper(s, start, i);
                }
            }
        }
        
        helper(s, 0, s.length - 1);
    }
    
    private void helper(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
