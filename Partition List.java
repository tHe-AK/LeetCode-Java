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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode head2 = dummy2;
        
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                head1.next = cur;
                head1 = cur;
            }
            else {
                head2.next = cur;
                head2 = cur;
            }
            cur = cur.next;
        }
        
        head1.next = dummy2.next;
        head2.next = null;
        
        return dummy1.next;
    }
}
