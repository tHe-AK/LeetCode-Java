public class Solution {
    public void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        helper(array, 0, array.length - 1);
    }

    private void helper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int cur = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < array[start]) {
                int temp = array[i];
                array[i] = array[cur];
                array[cur++] = temp;
            }
        }
        
        cur--;
        int temp = array[cur];
        array[cur] = array[start];
        array[start] = temp;
        
        helper(array, start, cur - 1);
        helper(array, cur + 1, end);
    }
｝
