/**
 * Definition for doubly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode pre;
 *     ListNode next;
 *     ListNode(int x) { val = x; pre = null; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode BSTTosortedList(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ListNode[] pre = new ListNode[1];
        ListNode[] head = new ListNode[1];
        helper(root, pre, head);

        return head[0];
    }
    
    private void helper(TreeNode root, ListNode[] pre, ListNode[] head) {
        if (root == null) {
            return;
        }
        
        helper(root.left, pre, head);

        ListNode cur = new ListNode(root.val);

        if (head[0] == null) {
            head[0] = cur;
        } 

        if (pre[0] != null) {
            pre[0].next = cur;
            cur.pre = pre[0];
        }

        pre[0] = cur;      

        helper(root.right, pre, head);  
    }
}