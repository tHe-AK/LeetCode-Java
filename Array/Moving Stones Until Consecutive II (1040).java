class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int N = stones.length;
        Arrays.sort(stones);
        int high = Math.max(stones[N - 1] - stones[1] - 1 - (N - 3), stones[N - 2] - stones[0] - 1 - (N - 3));
        int low = N;
        int i = 0;
        
        for (int j = 0; j < N; j++) {
            while (stones[j] - stones[i] >= N) {
                i++;
            }
            
            if (j - i + 1 == N - 1 && stones[j] - stones[i] == N - 2) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, N - (j - i + 1));
            }
        }
        
        return new int[] { low, high };
    }
}
