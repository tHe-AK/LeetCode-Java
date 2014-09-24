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
            return head;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
            }
            else {
                cur2.next = head;
                cur2 = head;
            }
            
            head = head.next;
        }
        
        cur1.next = dummy2.next;
        cur2.next = null;
        
        return dummy1.next;
    }
}