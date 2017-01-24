/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
        ListNode curr = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
                curr = curr.next;
            } else {
                curr.next = right;
                right = right.next;
                curr = curr.next;
            }
        }
        
        if (left != null) {
            curr.next = left;
        }
        
        if (right != null) {
            curr.next = right;
        }
        
        return dummy.next;
    }
}
