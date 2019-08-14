class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        
        for (int i : arr) {
            if (i == 0) {
                count++;
            }
        }
        
        int j = arr.length + count - 1;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                helper(arr, i, j--);
                helper(arr, i, j--);
            } else {
                helper(arr, i, j--);
            }
        }
    }
    
    private void helper(int[] arr, int i, int j) {
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }
}
