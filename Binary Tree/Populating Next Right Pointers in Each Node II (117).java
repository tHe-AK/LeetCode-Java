/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = null;
            
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = queue.poll();
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                
                if (pre != null) {
                    pre.next = curr;
                }
                
                pre = curr;
            }
        }
    }
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode curr = dummy;

            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                
                root = root.next;
            }
            
            root = dummy.next;
        }
    }
}
