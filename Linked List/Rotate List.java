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
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if (head == null || n == 0) {
            return head;
        }
        
        int len = 1;
        ListNode end = head;
        
        while (end.next != null) {
            len++;
            end = end.next;
        }
        
        n %= len;
        
        if (n == 0) {
            return head;
        }
        
        ListNode cur = head;

        for (int i = 1; i < len - n; i++) {
            cur = cur.next;
        }

        end.next = head;
        head = cur.next;
        cur.next = null;
        
        return head;
    }
}