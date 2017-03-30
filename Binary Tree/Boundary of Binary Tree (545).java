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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        
        TreeNode t = root.left;
        
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        
        addLeaves(root, res);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        
        while (!s.empty()) {
            res.add(s.pop());
        }
        
        return res;
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(root.left, res);
            }
            
            if (root.right != null) {
                addLeaves(root.right, res);
            }
        }
    }
    
    private boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }
}

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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left_boundary = new LinkedList<>();
        List<Integer> right_boundary = new LinkedList<>();
        List<Integer> leaves = new LinkedList<>();
        
        preorder(root, left_boundary, right_boundary, leaves, 0);
        
        left_boundary.addAll(leaves);
        left_boundary.addAll(right_boundary);
        
        return left_boundary;
    }

    private void preorder(TreeNode cur, List<Integer> left_boundary, List<Integer> right_boundary, List<Integer> leaves, int flag) {
        if (cur == null) {
            return;
        }
        
        if (isRoot(flag) || isLeftBoundary(flag)) {
            left_boundary.add(cur.val);
        } else if (isRightBoundary(flag)) {
            right_boundary.add(0, cur.val);
        } else if (isLeaf(cur)) {
            leaves.add(cur.val);
        }
        
        preorder(cur.left, left_boundary, right_boundary, leaves, leftChildFlag(cur, flag));
        preorder(cur.right, left_boundary, right_boundary, leaves, rightChildFlag(cur, flag));
    }
    
        private boolean isLeaf(TreeNode cur) {
        return cur.left == null && cur.right == null;
    }

    private boolean isRightBoundary(int flag) {
        return flag == 2;
    }

    private boolean isLeftBoundary(int flag) {
        return flag == 1;
    }

    private boolean isRoot(int flag) {
        return flag == 0;
    }

    private int leftChildFlag(TreeNode cur, int flag) {
        if (isLeftBoundary(flag) || isRoot(flag)) {
            return 1;
        } else if (isRightBoundary(flag) && cur.right == null) {
            return 2;
        } else {
            return 3;
        }
    }

    private int rightChildFlag(TreeNode cur, int flag) {
        if (isRightBoundary(flag) || isRoot(flag)) {
            return 2;
        } else if (isLeftBoundary(flag) && cur.left == null) {
            return 1;
        } else {
            return 3;
        }
    }
}
