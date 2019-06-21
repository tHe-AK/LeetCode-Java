class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start] };
        }
        
        int mid = start + (end - start) / 2;
        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid + 1, end);
        
        int[] merged = new int[end - start + 1];
        int k = 0;
        int i = 0;
        int j = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        
        return merged;
    }
}
