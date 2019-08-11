class Solution {
    public int validSubarrays(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        
        for (int num : nums) {
            while (!stack.empty() && num < stack.peek()) {
                stack.pop();
            }
            
            stack.push(num);
            res += stack.size();
        }
        
        return res;
    }
}
