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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        for (int i = 1; i < m; i++) {
            cur = cur.next;
        }
        
        ListNode end = cur.next;
        ListNode start;
        for (int i = 1; i <= n - m; i++) {
            start = cur.next;
            cur.next = end.next;
            end.next = cur.next.next;
            cur.next.next = start;
        }
        
        return dummy.next;
    }
}
