public class Solution {
    public void interleavingNumbers(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0 && num[i] < 0) {
                int j;
                
                for (j = i + 1; j < num.length; j++) {
                    if (num[j] > 0) {
                        break;
                    }
                }
                
                int temp = num[j];
                    
                for (int k = j; k > i; k--) {
                    num[k] = num[k - 1];
                }
                    
                num[i] = temp;
            }
            
            if (i % 2 == 1 && num[i] > 0) {
                int j;
                
                for (j = i + 1; j < num.length; j++) {
                    if (num[j] < 0) {
                        break;
                    }
                }
                
                int temp = num[j];
                    
                for (int k = j; k > i; k--) {
                    num[k] = num[k - 1];
                }
                    
                num[i] = temp;
            }
        }
    }
}
