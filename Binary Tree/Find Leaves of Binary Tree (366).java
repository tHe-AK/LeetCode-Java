/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        getHeight(root, result);
        return result;
    }
    
    private int getHeight(TreeNode root, List<List<Integer>> result){
        if (root == null) {
            return -1;
        }
        
        int height = Math.max(getHeight(root.left, result), getHeight(root.right, result)) + 1;
        
        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(height).add(root.val);
        
        return height;
    }
}

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        while (root != null) {
            List<Integer> list = new ArrayList<>();
            remove(root, list);
            res.add(list);
        }

        return res;
    }

    private TreeNode remove(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        } else {
            root.left = remove(root.left, list);
            root.right = remove(root.right, list);
            return root;
        }
    }
}
