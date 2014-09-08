/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        RandomListNode cur = head;
        RandomListNode copy;
        
        while (cur != null) {
            copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        
        cur = head;
        
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode start = cur.next;

        while (cur != null) {
            copy = cur.next;
            cur.next = cur.next.next;
            
            if (cur.next != null) {
                copy.next = cur.next.next;
            }
            
            cur = cur.next;
        }
        
        return start;
    }
}
