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
        
        ListNode[] cur = new ListNode[1];
        cur[0] = head;
        int count = 0;
        while (cur[0] != null) {
            count++;
            cur[0] = cur[0].next;
        }
        
        cur[0] = head;
        return helper(0, count - 1, cur);
    }
    
    private TreeNode helper(int low, int high, ListNode[] cur) {
        if (low > high) {
            return null;
        }
        
        int mid = low + (high - low) / 2;
        
        TreeNode left = helper(low, mid - 1, cur);
        
        TreeNode root = new TreeNode(cur[0].val);
        cur[0] = cur[0].next;
        root.left = left;
        
        TreeNode right = helper(mid + 1, high, cur);
        root.right = right;
        
        return root;
    }
}
