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
        if (head == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode cur1 = head;
        ListNode cur2 = slow.next;
        slow.next = null;
        ListNode pre = null;
        
        while (cur2 != null) {
            ListNode next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }
        
        cur2 = pre;
        
        while (cur2 != null) {
            ListNode next = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur2 = next;
            cur1 = cur1.next.next;
        }
    }
}