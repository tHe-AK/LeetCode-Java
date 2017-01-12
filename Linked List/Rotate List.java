/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        int len = 1;
        ListNode tail = head;
        
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        
        k %= len;
        
        if (k == 0) {
            return head;
        }
        
        ListNode curr = head;

        for (int i = 1; i < len - k; i++) {
            curr = curr.next;
        }

        tail.next = head;
        head = curr.next;
        curr.next = null;
        
        return head;
    }
}
