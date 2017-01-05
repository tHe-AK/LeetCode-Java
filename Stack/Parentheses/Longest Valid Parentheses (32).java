public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
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
        
        left = 0;
        right = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (left > right) {
                left = right = 0;
            }
        }
        
        return max;
    }
}

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
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
