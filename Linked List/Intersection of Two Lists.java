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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        
        while (lenA > lenB) {
            lenA--;
            headA = headA.next;
        }
        
        while (lenB > lenA) {
            lenB--;
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
