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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (carry > 0 || l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            
            ListNode temp = new ListNode(carry % 10);
            cur.next = temp;
            cur = temp;
            
            carry /= 10;
        }
        
        return dummy.next;
    }
}
