public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        
        if (len < 2) {
            return len;
        }
        
        int down = 1;
        int up = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        
        return Math.max(down, up);
    }
}

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        
        if (len < 2) {
            return len;
        }
        
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        
        return count;
    }
}
