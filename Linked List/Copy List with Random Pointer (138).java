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
            return null;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> queue = new LinkedList<>();
        map.put(head, new RandomListNode(head.label));
        queue.offer(head);
        
        while (!queue.isEmpty()) {
            RandomListNode peek = queue.poll();
            
            if (peek.next != null) {
                copyNode(map, queue, peek.next);
                map.get(peek).next = map.get(peek.next);
            }
            
            if (peek.random != null) {
                copyNode(map, queue, peek.random);
                map.get(peek).random = map.get(peek.random);
            }
        }
        
        return map.get(head);
    }
    
    private void copyNode(Map<RandomListNode, RandomListNode> map, Queue<RandomListNode> queue, RandomListNode node) {
        if (!map.containsKey(node)) {
            map.put(node, new RandomListNode(node.label));
            queue.offer(node);
        }
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
        
        RandomListNode curr = head;
        
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        
        curr = head;
        
        while (curr != null) {
            RandomListNode copy = curr.next;
            
            if (curr.random != null) {
                copy.random = curr.random.next;
            }
            
            curr = copy.next;
        }
        
        RandomListNode next = head.next;
        curr = next;
        
        while (head != null) {
            head.next = head.next.next;
            
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
            
            head = head.next;
            curr = curr.next;
        }
        
        return next;
    }
}
