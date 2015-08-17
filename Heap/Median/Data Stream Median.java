public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int len = nums.length;
        int[] result = new int[len];
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(len / 2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        
        for (int i = 0; i < len; i++) {
            if (max.isEmpty() || nums[i] <= max.peek()) {
                max.offer(nums[i]);
            }
            else {
                min.offer(nums[i]);
            }
            
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            }
            
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
            
            result[i] = max.peek();
        }
        
        return result;
    }
}
