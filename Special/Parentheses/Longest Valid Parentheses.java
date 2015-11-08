public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int pre = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (stack.empty()) {
                pre = i;
            }
            else {
                stack.pop();
                
                if (stack.empty()) {
                    max = Math.max(max, i - pre);
                }
                else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        
        return max;
    }
}

public class Solution {
    public int longestValidParentheses(String s) {
        int[] rec = new int[s.length()];
        int max = 0;

        for (int i = 1; i < rec.length; i++) {
            if (s.charAt(i) == ')' && i - rec[i - 1] - 1 >= 0 && s.charAt(i - rec[i - 1] - 1) == '(') {
                rec[i] = rec[i - 1] + 2;
                
                if (i - rec[i - 1] - 2 >= 0) {
                    rec[i] += rec[i - rec[i - 1] - 2];
                }
                
                max = Math.max(max, rec[i]);
            }
        }
        
        return max;
    }
}
