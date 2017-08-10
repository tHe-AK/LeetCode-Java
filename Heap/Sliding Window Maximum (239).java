public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) {
            return new int[0];
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int len = nums.length;
        int[] result = new int[len - k + 1];
        
        for (int i = 0; i < len; i++) {
            queue.offer(nums[i]);
            
            if (i >= k - 1) {
                result[i - k + 1] = queue.peek();
                queue.remove(nums[i - k + 1]);
            }
        }
        
        return result;
    }
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) {
            return new int[0];
        }
        
        Deque<Integer> queue = new LinkedList<Integer>();
        int len = nums.length;
        int[] result = new int[len - k + 1];
        
        for (int i = 0; i < len; i++) {
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
