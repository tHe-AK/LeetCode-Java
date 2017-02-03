public class Solution {
    public int calculate(String s) {
        int len = s.length();
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int sum = s.charAt(i) - '0';
                
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                
                result += sum * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        
        return result;
    }
}
