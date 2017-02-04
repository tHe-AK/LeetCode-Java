/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode head1 = slow;
        ListNode head2 = slow.next;
        
        if (fast.next == null) {
            head1 = prev;
        } else {
            slow.next = prev;
        }
        
        while (head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            
            head2 = head2.next;
            head1 = head1.next;
        }
        
        return true;
    }
}
