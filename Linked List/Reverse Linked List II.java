/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode pre = null;
        ListNode curr = head.next;
        
        for (int i = 0; i <= n - m; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        
        head.next.next = curr;
        head.next = pre;
        
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode pre = head.next;
        ListNode curr = head.next.next;
        
        for (int i = 1; i <= n - m; i++) {
            pre.next = curr.next;
            curr.next = head.next;
            head.next = curr;
            curr = pre.next;
        }
        
        return dummy.next;
    }
}
