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
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a,ListNode b){
                return a.val - b.val;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        
        return dummy.next;
    }
}
