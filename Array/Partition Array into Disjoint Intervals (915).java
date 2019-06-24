class Solution {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int min[] = new int[N];
        min[N - 1] = A[N - 1];
        int max = -1;
        
        for (int i = N - 2; i > 0; i--) {
            min[i] = Math.min(min[i + 1], A[i]);
        }
            
        for (int i = 0; i < N - 1; i++) {
            max = Math.max(max, A[i]);
            
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        
        return -1;
    }
}
