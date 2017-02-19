public class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int median = findKthLargest(nums, (len + 1) / 2, 0, len - 1);
        
        int low = 0;
        int high = len - 1;
        int i = 0;
        
        while (i <= high) {
            if (nums[idx(i, len)] > median) {
                swap(nums, idx(low++, len), idx(i++, len));
            } else if (nums[idx(i, len)] < median) {
                swap(nums, idx(high--, len), idx(i, len));
            } else {
                i++;
            }
        }
    }
    
    private int findKthLargest(int[] nums, int k, int low, int high) {
        int pivot = nums[low];
        int curr = low + 1;
        
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[curr];
                nums[curr++] = temp;
            }
        }
        
        nums[low] = nums[--curr];
        nums[curr] = pivot;
        
        int count = curr - low + 1;
        
        if (count == k) {
            return nums[curr];
        } else if (count < k) {
            return findKthLargest(nums, k - count, curr + 1, high);
        } else {
            return findKthLargest(nums, k, low, curr - 1);
        }
    }
    
    private int idx(int i, int len) {
        return (1 + 2 * i) % (len | 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
