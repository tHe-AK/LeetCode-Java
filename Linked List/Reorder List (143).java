/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
        
        ListNode curr1 = head;
        ListNode curr2 = slow.next;
        slow.next = null;
        ListNode pre = null;
        
        while (curr2 != null) {
            ListNode next = curr2.next;
            curr2.next = pre;
            pre = curr2;
            curr2 = next;
        }
        
        curr2 = pre;
        
        while (curr2 != null) {
            ListNode next = curr2.next;
            curr2.next = curr1.next;
            curr1.next = curr2;
            curr2 = next;
            curr1 = curr1.next.next;
        }
    }
}
