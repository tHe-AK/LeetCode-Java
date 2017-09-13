/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (dfs(head) == 0){
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
        
    private int dfs(ListNode head) {
        if (head == null) {
            return 1;
        }
            
        int carry = dfs(head.next);
            
        if (carry == 0) {
            return 0;
        } else {
            int val = head.val + 1;
            head.val = val % 10;
            return val / 10;
        }
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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        ListNode first = dummy;
        
        while (last.next != null) {
            last = last.next;
            
            if (last.val != 9) {
                first = last;
            }
        }
        
        if (last.val != 9) {
            last.val++;
        } else {
            first.val++;
            first = first.next;
            
            while (first != null) {
                first.val = 0;
                first = first.next;
            }
        }
        
        if (dummy.val == 0) {
            return dummy.next;
        } else {
            return dummy;
        }
    }
}
