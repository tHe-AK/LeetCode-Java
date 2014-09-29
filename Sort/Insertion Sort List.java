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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
            ListNode cur = dummy;
            
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            
            ListNode next = head.next;
            head.next = cur.next;
            cur.next = head;
            
            head = next;
        }
        
        return dummy.next;
    }
}