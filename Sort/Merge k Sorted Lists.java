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
    private class MyComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        
        int size = lists.size();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(size, new MyComparator());
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        for (int i = 0; i < size; i++) {
            ListNode first = lists.get(i);
            
            if (first != null) {
                queue.offer(first);
            }
        }
        
        while (!queue.isEmpty()) {
            ListNode peek = queue.poll();
            head.next = peek;
            head = head.next;
            
            if (peek.next != null) {
                queue.offer(peek.next);
            }
        }
        
        return dummy.next;
    }
}