public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        reverse(nums);
        
    	return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
    
    private boolean dfs(int[] nums, int[] sums, int start, int target) {
    	if (start == nums.length) {
    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {
    		    return true;
    	    } else {
    	        return false;
    	    }
    	}
    	
    	for (int i = 0; i < 4; i++) {
    	    if (nums[start] + sums[i] <= target) {
    	        sums[i] += nums[start];
    	        
                if (dfs(nums, sums, start + 1, target)) {
                    return true;
                }
                
    	        sums[i] -= nums[start];
    	    }
    	}
    	
    	return false;
    }
}
