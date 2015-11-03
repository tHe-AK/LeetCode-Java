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

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        if (nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] result = new int[len];
        int[] min = new int[len];
        int cur = 0;
        int max = 1;
        result[0] = 1;
        min[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] < min[0]) {
                result[i] = 1;
                min[0] = nums[i];
            }
            else if (nums[i] >= min[cur]) {
                cur++;
                result[i] = cur + 1;
                min[cur] = nums[i];
            }
            else {
                int low = 0;
                int high = cur;
                
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    
                    if (min[mid] == nums[i] || min[mid] < nums[i]) {
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }
                
                result[i] = low + 1;
                min[low] = nums[i];
            }
            
            max = Math.max(max, result[i]);
        }
        
        return max;
    }
}
