public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = len;
        int right = 0;
        Stack<Integer> stack = new Stack();
        
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            
            stack.push(i);
        }
        
        return left < right ? right - left + 1 : 0;
    }
}

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = len;
        int right = 0;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        for (int i = 0; i < len; i++) {
            if (nums[i] != copy[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        
        return left < right ? right - left + 1 : 0;
    }
}

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = len;
        int right = 0;
        
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    left = Math.min(left, i);
                    right = Math.max(right, j);
                }
            }
        }
        
        return left < right ? right - left + 1 : 0;
    }
}
