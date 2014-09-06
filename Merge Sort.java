public class Solution {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        
        return helper(array, 0, array.length - 1);
    }

    private int[] helper(int[] array, int start, int end) {
        if (start == end) {
            return new int[] { array[start] };
        }
        
        int mid = start + (end - start) / 2;
        int[] left = helper(array, start, mid);
        int[] right = helper(array, mid + 1, end);
        
        int[] merge = new int[end - start + 1];
        int cur = 0;
        int cur_left = 0;
        int cur_right = 0;
        
        while (cur_left < left.length && cur_right < right.length) {
            if (left[cur_left] < right[cur_right]) {
                merge[cur++] = left[cur_left++];
            }
            else {
                merge[cur++] = right[cur_right++];
            }
        }
        
        while (cur_left < left.length) {
            merge[cur++] = left[cur_left++];
        }
        
        while (cur_right < right.length) {
            merge[cur++] = right[cur_right++];
        }
        
        return merge;
    }
}
