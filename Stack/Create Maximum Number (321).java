public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && k - i <= nums2.length) {
                int[] candidate = merge(getMaxK(nums1, i), getMaxK(nums2, k - i), k);
                
                if (compare(candidate, 0, result, 0)) {
                    result = candidate;
                }
            }
        }
        
        return result;
    }
    
    private int[] getMaxK(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[k];

        for (int i = 0, j = 0; i < len; i++) {
            while (j > 0 && len - i + j > k && result[j - 1] < nums[i]) {
                j--;
            }
            
            if (j < k) {
                result[j++] = nums[i];
            }
        }
        
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int len) {
        int[] result = new int[len];
        int i = 0;
        int j = 0;
        
        for (int k = 0; k < len; k++) {
            result[k] = compare(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        
        return result;
    }
    
    private boolean compare(int[] nums1, int i, int[] nums2, int j) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        while (i < len1 && j < len2 && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        return j == len2 || (i < len1 && nums1[i] > nums2[j]);
    }
}
