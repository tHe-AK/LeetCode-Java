public class Solution {
    public int partitionArray(int[] num, int target) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 0; i < num.length; i++) {
            if (num[i] < target) {
                int temp = num[i];
                num[i] = num[cur];
                num[cur] = temp;
                cur++;
            }
        }
        
        return cur;
    }
}
