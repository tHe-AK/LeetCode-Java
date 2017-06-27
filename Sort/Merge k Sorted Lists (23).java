/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }
        
        return dummy.next;
    }
}
