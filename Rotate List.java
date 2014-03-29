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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
    
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        
        n = n % len;
        if (n == 0) {
            return head;
        }
        
        cur.next = head;
        cur = head;
        for (int i = 0; i < len - n - 1; i++) {
            cur = cur.next;
        }
        
        ListNode result = cur.next;
        cur.next = null;
        return result;
    }
}
