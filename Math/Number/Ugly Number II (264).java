public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        
        int[] rec = new int[n];
        rec[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        
        for (int i = 1; i < n; i++){
            rec[i] = Math.min(Math.min(rec[index2] * 2, rec[index3] * 3), rec[index5] * 5);
            
            if (rec[i] == rec[index2] * 2) {
                index2++;
            }
            
            if (rec[i] == rec[index3] * 3) {
                index3++;
            }
            
            if (rec[i] == rec[index5] * 5) {
                index5++;
            }
        }
        
        return rec[n - 1];
    }
}
