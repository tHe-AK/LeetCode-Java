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
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode cur1 = head;
        ListNode head2 = helper(slow.next);
        ListNode cur2 = head2;
        
        while (cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        head2 = helper(head2);
        slow.next = head2;
        
        return true;
    }
    
    private ListNode helper(ListNode head) {
        ListNode pre = null;
        ListNode next;
        
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}
