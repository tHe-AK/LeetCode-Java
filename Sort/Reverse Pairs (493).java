class TreeNode {
    public int val;
    public int same;
    public int count;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val, int same, int count) {
        this.val = val;
        this.same = same;
        this.count = count;
    }
}

public class Solution {
    public int reversePairs(int[] nums) {
        int result = 0;
        TreeNode root = null;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            result += search(root, nums[i] / 2.0);
            root = insert(root, nums[i]);
        }
        
        return result;
    }
    
    private int search(TreeNode root, double num) {
        if (root == null) {
            return 0;
        } else {
            if (root.val == num) {
                return root.count;
            } else if (root.val < num) {
                return root.same + root.count + search(root.right, num);
            } else {
                return search(root.left, num);
            }
        }
    }
    
    private TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num, 1, 0);
        } else {
            if (root.val == num) {
                root.same++;
            } else if (root.val < num) {
            	root.right = insert(root.right, num);
            } else {
                root.count++;
                root.left = insert(root.left, num);
            }
            
            return root;
        }
    }
}
