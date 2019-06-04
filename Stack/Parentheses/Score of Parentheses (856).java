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

class Solution {
    public int scoreOfParentheses(String S) {
        int ans = 0;
        int curr = 0;
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                curr++;
            } else {
                curr--;
                
                if (S.charAt(i - 1) == '(') {
                    ans += 1 << curr;
                }
            }
        }
        
        return ans;
    }
}
