public class Solution {
    public boolean find132pattern(int[] nums) {
        int candidate = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < candidate) {
                return true;
            } else {
                while (!stack.empty() && nums[i] > stack.peek()) { 
                    candidate = stack.pop();
                }
                
                stack.push(nums[i]);
            }
        }
        
        return false;
    }
}
