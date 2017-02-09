public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] rec = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(rec, 0, len, num);
            
            if (index < 0) {
                index = -(index + 1);
            }
            
            rec[index] = num;
            
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] rec = new int[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            rec[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    rec[i] = Math.max(rec[i], rec[j] + 1);
                }
            }
            
            max = Math.max(max, rec[i]);
        }
        
        return max;
    }
}
