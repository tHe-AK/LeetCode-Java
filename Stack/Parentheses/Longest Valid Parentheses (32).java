public class Solution {
    public int longestValidParentheses(String s) {
        return Math.max(getMax(s, '('), getMax(new StringBuilder(s).reverse().toString(), ')'));
    }
    
    private int getMax(String s, char ch) {
        int left = 0;
        int right = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }
        }
        
        return max;
    }
}

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                
                if (stack.empty()) {
                    stack.push(i);
                } else {
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
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    rec[i] = (i >= 2 ? rec[i - 2] : 0) + 2;
                } else if (i - rec[i - 1] > 0 && s.charAt(i - rec[i - 1] - 1) == '(') {
                    rec[i] = rec[i - 1] + ((i - rec[i - 1]) >= 2 ? rec[i - rec[i - 1] - 2] : 0) + 2;
                }
                
                max = Math.max(max, rec[i]);
            }
        }
        
        return max;
    }
}
