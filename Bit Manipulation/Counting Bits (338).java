public class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[num + 1];
        rec[0] = 0;
        
        for (int i = 1; i <= num; i++) {
            rec[i] = rec[i / 2];
            
            if (i % 2 == 1) {
                rec[i]++;
            }
        }
        
        return rec;
    }
}
