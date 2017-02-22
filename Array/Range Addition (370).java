public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] rec = new int[length];
        
        for (int[] update : updates) {
            int val = update[2];
            int start = update[0];
            int end = update[1];
            
            rec[start] += val;
            
            if (end + 1 < length)
                rec[end + 1] -= val;
            
        }
        
        int sum = 0;
        
        for (int i = 0; i < length; i++) {
            sum += rec[i];
            rec[i] = sum;
        }
        
        return rec;
    }
}
