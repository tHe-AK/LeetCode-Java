class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for (String op : ops) {
            if (op.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num = num1 + num2;
                sum += num;
                stack.push(num2);
                stack.push(num1);
                stack.push(num);
            } else if (op.equals("D")) {
                int num1 = stack.pop();
                int num = num1 * 2;
                sum += num;
                stack.push(num1);
                stack.push(num);
            } else if (op.equals("C")) {
                sum -= stack.pop();
            } else {
                int num = Integer.parseInt(op);
                sum += num;
                stack.push(num);
            }
        }
        
        return sum;
    }
}
