class Solution {
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

class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        int i = 0;
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                int j = ++i;
                int count = 1;
                
                while (count > 0) {
                    if (s.charAt(i) == '(') {
                        count++;
                    } else if (s.charAt(i) == ')') {
                        count--;
                    }
                    
                    i++;
                }
                
                res += sign * calculate(s.substring(j, i - 1));
            } else if (ch == '+') {
                sign = 1;
                i++;
            } else if (ch == '-') {
                sign = -1;
                i++;
            } else if (ch == ' ') {
                i++;
            } else {
                int num = 0;
                
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                
                res += sign * num;
            }
        }
        
        return res;
    }
}
