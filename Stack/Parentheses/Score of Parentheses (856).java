class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack.push(curr);
                curr = 0;
            } else {
                curr = stack.pop() + Math.max(curr * 2, 1);
            }
        }
        
        return curr;
    }
}
