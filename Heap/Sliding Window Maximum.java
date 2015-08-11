public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return new int[0];
        }
        
        Deque<Integer> queue = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }
            
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            
            queue.offer(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        
        return result;
    }
}
