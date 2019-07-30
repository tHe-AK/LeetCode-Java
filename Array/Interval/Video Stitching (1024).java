class Solution {
    public int videoStitching(int[][] clips, int T) {
        int end = 0;
        int step = 0;
        int i = 0;
        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
        
        while (end < T) {
            int curr = end;
            
            while (i < clips.length && clips[i][0] <= curr) {
                end = Math.max(end, clips[i++][1]);
            }
            
            if (curr == end) {
                return -1;
            }
            
            step++;
        }
        
        return step;
    }
}

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] <= i && i <= clip[1] && dp[clip[0]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        
        return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
    }
}
