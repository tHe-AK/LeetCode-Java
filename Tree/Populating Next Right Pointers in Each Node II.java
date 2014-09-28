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
        
        while (root != null) {
            TreeLinkNode cur = root;
            TreeLinkNode pre = null;
            TreeLinkNode first = null;
            
            while (cur != null) {
                if (cur.left != null) {
                    if (first == null) {
                        first = cur.left;
                    }
                    
                    if (pre == null) {
                        pre = cur.left;
                    }
                    else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                
                if (cur.right != null) {
                    if (first == null) {
                        first = cur.right;
                    }
                    
                    if (pre == null) {
                        pre = cur.right;
                    }
                    else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                
                cur = cur.next;
            }
            
            root = first;
        }
    }
}