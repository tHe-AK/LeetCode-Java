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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head.next;
        boolean flag = false;
        while (cur != null) {
            if (cur.val == pre.next.val) {
                flag = true;
            }
            else {
                if (flag == true) {
                    flag = false;
                    pre.next = cur;
                }
                else {
                    pre = pre.next;
                }
            }
            cur = cur.next;
        }
        
        if (flag == true) {
            pre.next = cur;
        }
        
        return dummy.next;
    }
}
