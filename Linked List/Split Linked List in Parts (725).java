/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode node = root;
        ListNode[] res = new ListNode[k];
        
        while (node != null) {
            count++;
            node = node.next;
        }
        
        int size = count / k;
        int remaining = count % k;
        int i = 0;
        
        while (root != null) {
            res[i++] = root;
            int step = size + (remaining-- > 0 ? 1 : 0) - 1;
            
            for (int j = 0; j < step; j++) {
                root = root.next;
            }
            
            ListNode next = root.next;
            root.next = null;
            root = next;
        }
        
        return res;
    }
}
