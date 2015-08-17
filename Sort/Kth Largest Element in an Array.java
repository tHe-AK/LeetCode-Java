public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            throw new IllegalArgumentException();
        }
        
        return helper(0, nums.length - 1, nums, k);
    }
    
    private int helper(int low, int high, int[] nums, int k) {
        int pivot = nums[low];
        int cur = low + 1;
        
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > pivot) {
                int temp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = temp;
                cur++;
            }
        }
        
        cur--;
        nums[low] = nums[cur];
        nums[cur] = pivot;
        
        int count = cur - low + 1;
        
        if (count == k) {
            return nums[cur];
        }
        else if (count < k) {
            return helper(cur + 1, high, nums, k - count);
        }
        else {
            return helper(low, cur - 1, nums, k);
        }
    }
}
