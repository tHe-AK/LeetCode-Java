/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            
            cur = cur.next;
        }
        
        if (left != null) {
            cur.next = left;
        }
        
        if (right != null) {
            cur.next = right;
        }
        
        return dummy.next;
    }
}
