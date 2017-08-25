public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && k - i <= nums2.length) {
                int[] candidate = merge(getMaxK(nums1, i), getMaxK(nums2, k - i));
                
                if (compare(candidate, 0, res, 0)) {
                    res = candidate;
                }
            }
        }
        
        return res;
    }
    
    private int[] getMaxK(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[k];

        for (int i = 0, j = 0; i < len; i++) {
            while (j > 0 && res[j - 1] < nums[i] && len - i + j - 1 >= k) {
                j--;
            }
            
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        
        for (int k = 0; k < res.length; k++) {
            res[k] = compare(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        
        return res;
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
