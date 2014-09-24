public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        int i = num.length - 1;
        
        while (i > 0 && num[i - 1] >= num[i]) {
            i--;
        }
        
        if (i == 0) {
            Arrays.sort(num);
            
            return;
        }
        
        int j = num.length - 1;
        
        while (j >= i && num[i - 1] >= num[j]) {
            j--;
        }
        
        int temp = num[j];
        num[j] = num[i - 1];
        num[i - 1] = temp;
        
        j = num.length - 1;
        
        while (i < j) {
            temp = num[j];
            num[j] = num[i];
            num[i] = temp;
        
            i++;
            j--;
        } 
    }
}