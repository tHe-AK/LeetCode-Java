public class Solution {
    public int calculate(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> opr = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (Character.isDigit(cur)) {
                int val = s.charAt(i) - '0';
                
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                
                num.push(val);
            }
            else if (cur == '(') {
                opr.push(cur);
            }
            else if (cur == ')') {
                while (opr.peek() != '(') {
                    num.push(helper(num.pop(), num.pop(), opr.pop()));
                }
                
                opr.pop();
            }
            else if (cur == '+' || cur == '-') {
                while (!opr.empty() && opr.peek() != '(') {
                    num.push(helper(num.pop(), num.pop(), opr.pop()));
                }
                
                opr.push(cur);
            }
            else {
            }
        }
        
        while (!opr.empty()) {
            num.push(helper(num.pop(), num.pop(), opr.pop()));
        }
                
        return num.peek();
    }
    
    private int helper(int b, int a, char sign) {
        switch (sign) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                throw new RuntimeException();
        }
    }
}
