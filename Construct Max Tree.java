class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode maxTree(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        int len = num.length;
        Integer[] left = new Integer[len];
        Integer[] right = new Integer[len];
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        
        while (i < num.length) {
            if (stack.empty() || stack.peek() > num[i]) {
                left[i] = stack.empty() ? null : stack.peek();
                stack.push(num[i]);
                i++;
            }
            else {
                stack.pop();
            }
        }
        
        stack.clear();
        i = len - 1;
        
        while (i >= 0) {
            if (stack.empty() || stack.peek() > num[i]) {
                right[i] = stack.empty() ? null : stack.peek();
                stack.push(num[i]);
                i--;
            }
            else {
                stack.pop();
            }
        }
        
        HashMap<Integer, TreeNode> hashMap = new HashMap<Integer, TreeNode>();
        
        for (i = 0; i < len; i++) {
            hashMap.put(num[i], new TreeNode(num[i]));
        }
        
        TreeNode root = null;
        
        for (i = 0; i < len; i++) {
            TreeNode cur = hashMap.get(num[i]);
            
            if (left[i] == null && right[i] == null) {
                root = cur;
            }
            else if (left[i] == null) {
                hashMap.get(right[i]).left = cur;
            }
            else if (right[i] == null) {
                hashMap.get(left[i]).right = cur;
            }
            else if (left[i] > right[i]) {
                hashMap.get(right[i]).left = cur;
            }
            else {
                hashMap.get(left[i]).right = cur;
            }
        }
        
        return root;
    }
