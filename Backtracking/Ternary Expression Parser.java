public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() < 1) {
            throw new IllegalArgumentException();
        }

        return helper(expression, new int[1]);
    }

    private String helper(String expression, int[] start) {
        String pre = "";

        while (start[0] < expression.length()) {
            char c = expression.charAt(start[0]++);

            if (c == '?') {
                if (pre.equals("T")) {
                    String result = helper(expression, start);
                    helper(expression, start);
                    return result;
                } else {
                    helper(expression, start);
                    return helper(expression, start);
                }
            } else if (c == ':') {
                return pre;
            } else {
                pre += c;
            }
        }

        return pre;
    }
}

public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() < 1) {
            throw new IllegalArgumentException();
        }

        Stack<Character> stack = new Stack<Character>();
        int i = expression.length() - 1;
        
        while (i >= 0) {
            char c = expression.charAt(i--);
            
            if (!stack.empty() && stack.peek() == '?') {
                stack.pop();
                
                if (c == 'T') {
                    char left = stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push(left);
                } else {
                    stack.pop();
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        return String.valueOf(stack.peek());
    }
}
