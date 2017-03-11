public class Solution {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[] rec = new int[n + 1];
        rec[1] = 1;
        int j = 1;
        int count = 0;
        int result = 1;
        
        for (int i = 2; i <= n; i++) {
            if (count > 0) {
                rec[i] = rec[i - 1];
            } else {
                rec[i] = rec[i - 1] ^ 3;
                count = rec[++j];
            }
            
            count--;

            if (rec[i] == 1) {
                result++;
            }
        }
        
        return result;
    }
}
