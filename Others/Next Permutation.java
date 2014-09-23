public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0 || num.length == 1) {
            return;
        }
        
        int end = num.length - 1;
        int i = end;
        while (i > 0 && num[i - 1] >= num[i]) {
            i--;
        }
        
        if (i == 0) {
            reverse(num, 0, end);
            return;
        }
        
        int j = end;
        while (num[i - 1] >= num[j]) {
            j--;
        }
        
        int temp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = temp;
        
        reverse(num, i, end);
    }
    
    private void reverse(int[] num, int start, int end) {
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
}
