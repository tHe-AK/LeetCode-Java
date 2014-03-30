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
        ListNode start = null;
        ListNode pre = null;
        
        for (int i = 1; i <= n; i++) {
            if (i == m) {
                start = cur;
                pre = cur.next;
                cur = cur.next.next;
            }
            else if (i > m) {
                pre.next = cur.next;
                cur.next = start.next;
                start.next = cur;
                cur = pre.next;
            }
            else {
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}
