/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode cur = head;
        int len = 0;
        
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        
        ListNode[] rec = new ListNode[1];
        rec[0] = head;
        
        return helper(0, len - 1, rec);
    }
    
    private TreeNode helper(int start, int end, ListNode[] rec) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        
        TreeNode left = helper(start, mid - 1, rec);
        
        TreeNode root = new TreeNode(rec[0].val);
        root.left = left;
        rec[0] = rec[0].next;
        
        TreeNode right = helper(mid + 1, end, rec);
        root.right = right;
        
        return root;
    }
}