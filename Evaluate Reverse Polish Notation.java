public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException();
        }
        
        Stack<Integer> operand = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int b = operand.peek();
                operand.pop();
                int a = operand.peek();
                operand.pop();
                operand.push(a + b);
            }
            else if (tokens[i].equals("-")) {
                int b = operand.peek();
                operand.pop();
                int a = operand.peek();
                operand.pop();
                operand.push(a - b);
            }
            else if (tokens[i].equals("*")) {
                int b = operand.peek();
                operand.pop();
                int a = operand.peek();
                operand.pop();
                operand.push(a * b);
            }
            else if (tokens[i].equals("/")) {
                int b = operand.peek();
                operand.pop();
                int a = operand.peek();
                operand.pop();
                operand.push(a / b);
            }
            else {
                operand.push(Integer.parseInt(tokens[i]));
            }
        }
        
        if (operand.size() != 1) {
            throw new IllegalArgumentException();
        }
        
        return operand.peek();
    }
}
