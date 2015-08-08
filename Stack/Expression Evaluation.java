public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        
        Stack<Integer> num = new Stack<Integer>();
        Stack<String> opr = new Stack<String>();

        for (int i = 0; i < expression.length; i++) {
            String cur = expression[i];
            
            if (cur.equals("(")) {
                opr.push(cur);
            }
            else if (cur.equals(")")) {
                while (!opr.peek().equals("(")) {
                    num.push(helper(num.pop(), num.pop(), opr.pop()));
                }
                
                opr.pop();
            }
            else if (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")) {
                while (!opr.empty() && !opr.peek().equals("(") && priority(opr.peek(), cur)) {
                    num.push(helper(num.pop(), num.pop(), opr.pop()));
                }
                
                opr.push(cur);
            }
            else {
                num.push(Integer.parseInt(cur));
            }
        }
        
        while (!opr.empty()) {
            num.push(helper(num.pop(), num.pop(), opr.pop()));
        }
                
        return num.empty() ? 0 : num.peek();
    }
    
    private int helper(int b, int a, String sign) {
        switch (sign) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException();
        }
    }
    
    private boolean priority(String a, String b) {
        if (a.equals("*") || a.equals("/")) {
            return true;
        }
        else if (b.equals("+") || b.equals("-")) {
            return true;
        }
        else {
            return false;
        }
    }
};
