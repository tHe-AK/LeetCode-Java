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
        
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            TreeLinkNode pre = null;
            TreeLinkNode next = null;
            
            while (cur != null) {
                if (cur.left != null) {
                    if (next == null) {
                        next = cur.left;
                    }
                    if (pre != null) {
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (next == null) {
                        next = cur.right;
                    }
                    if (pre != null) {
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            
            start = next;
        }
    }
}
