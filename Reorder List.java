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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        ListNode cur1 = head;
        ListNode cur2 = pre;
        while (cur2 != null) {
            next = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur1 = cur2.next;
            cur2 = next;
        }
    }
}
