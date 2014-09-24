public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) {
            throw new IllegalArgumentException();
        }
        
        int len = ratings.length;
        int total = 0;
        int[] increase = new int[len];
        int[] decrease = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (i != 0 && ratings[i - 1] < ratings[i]) {
                increase[i] = increase[i - 1] + 1;
            }
            else {
                increase[i] = 1;
            }
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (i != len - 1 && ratings[i] > ratings[i + 1]) {
                decrease[i] = decrease[i + 1] + 1;
            }
            else {
                decrease[i] = 1;
            }
        }
        
        for (int i = 0; i < len; i++) {
            total += Math.max(increase[i], decrease[i]);
        }
        
        return total;
    }
}