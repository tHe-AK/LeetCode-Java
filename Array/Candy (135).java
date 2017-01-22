public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int total = 0;
        int[] rec = new int[len];

        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i]) {
                rec[i] = rec[i - 1] + 1;
            } else {
                rec[i] = 1;
            }
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                rec[i] = Math.max(rec[i], rec[i + 1] + 1);
            }
            
            total += rec[i];
        }
        
        return total;
    }
}
