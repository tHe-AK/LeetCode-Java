public class Solution {
    public ListNode intersectionOfLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int len1 = 0;
        int len2 = 0;
        
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        
        cur1 = head1;
        cur2 = head2;
        
        while (len1 < len2) {
            cur2 = cur2.next;
            len2--;
        }
        
        while (len1 > len2) {
            cur1 = cur1.next;
            len1--;
        }
        
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        return cur1;
    }
}
