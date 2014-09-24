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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (true) {
            ListNode cur = head.next;
            int i = 0;
            
            while (i < k && cur != null) {
                i++;
                cur = cur.next;
            }
            
            if (i != k) {
                break;
            }
            
            ListNode pre = head.next;
            cur = head.next.next;
            
            for (i = 1; i < k; i++) {
                pre.next = cur.next;
                cur.next = head.next;
                head.next = cur;
                cur = pre.next;
            }
            
            head = pre;
        }
        
        return dummy.next;
    }
}