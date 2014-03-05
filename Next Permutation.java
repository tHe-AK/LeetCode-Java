public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0 || num.length == 1) {
            return;
        }
        
        int len = num.length;
        int i = len - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }
        
        if (i == -1) {
            Arrays.sort(num);
            return;
        }
        
        int j = len - 1;
        while (num[i] >= num[j]) {
            j--;
        }
        
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        
        int left = i + 1;
        int right = len - 1;
        while (left < right) {
            temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
}
