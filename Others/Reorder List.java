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
        
        ListNode cur = slow.next;
        slow.next = null;
        
        ListNode pre = null;
        ListNode next;
        
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        cur = head;
        
        while (pre != null) {
            next = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            pre = next;
            cur = cur.next.next;
        }
    }
}
