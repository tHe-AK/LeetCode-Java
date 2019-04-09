class Solution {
    public int bestRotation(int[] A) {
        int N = A.length;
        int[] changes = new int[N];
        int k = 0;
        int max = 0;
        int curr = 0;
        
        for (int i = 0; i < N; i++) {
            changes[(i - A[i] + 1 + N) % N]--;
        }
        
        for (int i = 1; i < N; i++) {
            curr += changes[i] + 1;
            
            if (curr > max) {
                max = curr;
                k = i;
            }
        }
        
        return k;
    }
}
