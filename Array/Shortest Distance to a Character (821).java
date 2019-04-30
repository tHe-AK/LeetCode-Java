class Solution {
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] dist = new int[N];
        int idx = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == C) {
                idx = i;
            }
            
            dist[i] = idx == Integer.MAX_VALUE ? idx : i - idx;
        }
        
        idx = Integer.MAX_VALUE;
        
        for (int i = N - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                idx = i;
            }
            
            dist[i] = Math.min(dist[i], idx == Integer.MAX_VALUE ? idx : idx - i);
        }
        
        return dist;
    }
}
