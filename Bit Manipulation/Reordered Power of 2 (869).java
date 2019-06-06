class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] rec = count(N);
        
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(rec, count(1 << i))) {
                return true;
            }
        }
                
        return false;
    }
                
    private int[] count(int N) {
        int[] rec = new int[10];
        
        while (N > 0) {
            rec[N % 10]++;
            N /= 10;
        }
        
        return rec;
    }
}
