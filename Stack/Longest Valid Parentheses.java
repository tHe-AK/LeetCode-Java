public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int max = 0;
        Stack<Character> stack = new Stack<Character>();
        int len = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else if (stack.empty()) {
                len = 0;
            }
            else {
                stack.pop();
                len += 2;
                
                if (stack.empty()) {
                    max = Math.max(max, len);
                }
            }
        }
        
        stack.clear();
        len = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                stack.push(s.charAt(i));
            }
            else if (stack.empty()) {
                len = 0;
            }
            else {
                stack.pop();
                len += 2;
                
                if (stack.empty()) {
                    max = Math.max(max, len);
                }
            }
        }
        
        return max;
    }
}