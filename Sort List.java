/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode sorted2 = sortList(slow.next);
        slow.next = null;
        ListNode sorted1 = sortList(head);
        
        return merge(sorted1, sorted2);
    }
    
    private ListNode merge(ListNode sorted1, ListNode sorted2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (sorted1 != null && sorted2 != null) {
            if (sorted1.val < sorted2.val) {
                cur.next = sorted1;
                sorted1 = sorted1.next;
            }
            else {
                cur.next = sorted2;
                sorted2 = sorted2.next;
            }
            cur = cur.next;
        }
        
        if (sorted1 == null) {
            cur.next = sorted2;
        }
        else {
            cur.next = sorted1;
        }
        
        return dummy.next;
    }
}
