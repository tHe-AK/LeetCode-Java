public class Solution {
    public int[] countBits(int num) {
        int[] rec = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            rec[i] = rec[i >> 1] + (i & 1);
        }
        
        return rec;
    }
}

public class Solution {
    public int[] countBits(int num) {
        int[] rec = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            rec[i] = rec[i & (i - 1)] + 1;
        }
        
        return rec;
    }
}
