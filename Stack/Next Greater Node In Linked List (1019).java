/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        int[] res = new int[nums.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nums.size(); ++i) {
            while (!stack.isEmpty() && nums.get(stack.peek()) < nums.get(i)) {
                res[stack.pop()] = nums.get(i);
            }
                
            stack.push(i);
        }
        
        return res;
    }
}
