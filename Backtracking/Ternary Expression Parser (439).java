public class Solution {
    public String parseTernary(String expression) {
        int len = expression.length();
        
        if (len <= 1) {
            return expression;
        }
        
        int count = 0;
        int idx = 2;
        
        while (idx < len) {
            char ch = expression.charAt(idx++);
            
            if (ch == '?') {
                count++;
            } else if (ch == ':') {
                if (count-- == 0) {
                    break;
                }
            }
        }
        
        return expression.charAt(0) == 'T' ? parseTernary(expression.substring(2, idx - 1)) : parseTernary(expression.substring(idx, len));
    }
}

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
        Stack<Character> stack = new Stack<Character>();
        int i = expression.length() - 1;
        
        while (i >= 0) {
            char ch = expression.charAt(i--);
            
            if (!stack.empty() && stack.peek() == '?') {
                stack.pop();
                
                if (ch == 'T') {
                    char left = stack.pop();
                    stack.pop();
                    stack.push(left);
                } else {
                    stack.pop();
                }
            } else if (ch != ':') {
                stack.push(ch);
            }
        }
        
        return String.valueOf(stack.peek());
    }
}
