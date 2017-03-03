public class Solution {
    public String parseTernary(String expression) {
        return parseTernary(expression, new int[1]);
    }

    private String parseTernary(String expression, int[] start) {
        String str = "";

        while (start[0] < expression.length()) {
            char ch = expression.charAt(start[0]++);

            if (ch == '?') {
                if (str.equals("T")) {
                    String result = parseTernary(expression, start);
                    parseTernary(expression, start);
                    return result;
                } else {
                    parseTernary(expression, start);
                    return parseTernary(expression, start);
                }
            } else if (ch == ':') {
                return str;
            } else {
                str += ch;
            }
        }

        return str;
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
