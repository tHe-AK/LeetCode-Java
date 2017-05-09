public class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }
}
