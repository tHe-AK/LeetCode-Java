public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
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
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int len = nums.length;
        int[] result = new int[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            result[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            
            max = Math.max(max, result[i]);
        }
        
        return max;
    }
}
