/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode cur = head.next;
        ListNode pre = head;
        
        while (cur != null) {
            if (cur.val != pre.val) {
                pre.next = cur;
                pre = pre.next;
            }
            
            cur = cur.next;
        }
        
        pre.next = null;
        return head;
    }
}
