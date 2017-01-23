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
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        return copyRandomList(head, map);
    }
    
    private RandomListNode copyRandomList(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (head == null) {
            return null;
        }
        
        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        RandomListNode clone = new RandomListNode(head.label);
        map.put(head, clone);
        
        clone.next = copyRandomList(head.next, map);
        clone.random = copyRandomList(head.random, map);
        
        return clone;
    }
}

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
        
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        
        cur = head;
        
        while (cur != null) {
            RandomListNode copy = cur.next;
            if (cur.random != null) {
                copy.random = cur.random.next;
            }
            cur = copy.next;
        }
        
        RandomListNode start = head.next;
        cur = start;
        
        while (head != null) {
            head.next = head.next.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            head = head.next;
            cur = cur.next;
        }
        
        return start;
    }
}
