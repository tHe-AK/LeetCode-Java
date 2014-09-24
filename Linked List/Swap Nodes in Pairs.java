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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
            ListNode pre = head.next;
            ListNode cur = head.next.next;
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            head = pre;
        }
        
        return dummy.next;
    }
}