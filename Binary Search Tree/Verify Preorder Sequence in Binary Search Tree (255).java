public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        long min = Long.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for (int val : preorder) {
            if (val < min) {
                return false;
            }
            
            while (!stack.empty() && val > stack.peek()) {
                min = stack.pop();
            }
            
            stack.push(val);
        }
        
        return true;
    }
}

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        long min = Long.MIN_VALUE;
        int curr = -1;
        
        for (int val : preorder) {
            if (val < min) {
                return false;
            }
            
            while (curr >= 0 && val > preorder[curr]) {
                min = preorder[curr--];
            }
            
            preorder[++curr] = val;
        }
        
        return true;
    }
}
