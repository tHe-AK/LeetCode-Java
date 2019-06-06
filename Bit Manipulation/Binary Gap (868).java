class Solution {
    public int binaryGap(int N) {
        int idx = -1;
        int max = 0;
        
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) == 1) {
                if (idx != -1) {
                    max = Math.max(max, i - idx);
                }
                
                idx = i;
            }
        }
        
        return max;
    }
}
