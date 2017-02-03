public class Solution {
    public int calculate(String s) {
        int len = s.length();
        char sign = '+';
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
                
                if (sign == '+') {
                    stack.push(sum);
                } else if (sign == '-') {
                    stack.push(-sum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * sum);
                } else {
                    stack.push(stack.pop() / sum);
                }
            } else if (ch != ' ') {
                sign = ch;
            }
        }
        
        for (int i : stack) {
            result += i;
        }

        return result;
    }
}
