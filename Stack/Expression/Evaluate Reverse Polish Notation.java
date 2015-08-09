public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) {
            throw new IllegalArgumentException();
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<String> rec = new HashSet<String>();
        rec.add("+");
        rec.add("-");
        rec.add("*");
        rec.add("/");
        
        for (int i = 0; i < tokens.length; i++) {
            if (rec.contains(tokens[i])) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                if (tokens[i].equals("+")) {
                    stack.push(num1 + num2);
                }
                else if (tokens[i].equals("-")) {
                    stack.push(num1 - num2);
                }
                else if (tokens[i].equals("*")) {
                    stack.push(num1 * num2);
                }
                else {
                    stack.push(num1 / num2);
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.peek();
    }
}