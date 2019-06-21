class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int pivot = nums[start];
        int idx = start + 1;

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx++] = temp;
            }
        }
        
        idx--;
        nums[start] = nums[idx];
        nums[idx] = pivot;

        quickSort(nums, start, idx - 1);
        quickSort(nums, idx + 1, end);
    }
}

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
