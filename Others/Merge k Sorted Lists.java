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
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new MyComparator());
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.offer(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (!heap.isEmpty()) {
            ListNode peek = heap.poll();
            
            if (peek.next != null) {
                heap.offer(peek.next);
            }
            
            cur.next = peek;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}
