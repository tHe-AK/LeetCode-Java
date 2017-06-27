/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        while (curr != null && count != k) {
            count++;
            curr = curr.next;
        }
        
        if (count == k) {
            ListNode pre = reverseKGroup(curr, k);
            
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            
            return pre;
        } else {
            return head;
        }
    }
}
