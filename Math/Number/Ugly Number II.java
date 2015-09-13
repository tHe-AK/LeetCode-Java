public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        
        int[] rec = new int[n + 1];
        rec[1] = 1;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        
        for (int i = 2; i <= n; i++){
            int min = Math.min(Math.min(factor2, factor3), factor5);
            rec[i] = min;
            
            if (min == factor2) {
                factor2 = 2 * rec[++index2];
            }
            
            if (min == factor3) {
                factor3 = 3 * rec[++index3];
            }
            
            if (min == factor5) {
                factor5 = 5 * rec[++index5];
            }
        }
        
        return rec[n];
    }
}
