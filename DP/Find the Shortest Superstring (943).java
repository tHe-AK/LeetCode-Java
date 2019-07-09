class Solution {
    public String shortestSuperstring(String[] A) {
        int N = A.length;
        int[][] graph = new int[N][N];
        int[][] dp = new int[1 << N][N];
        int[][] path = new int[1 << N][N];
        int min = Integer.MAX_VALUE;
        int idx = -1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = getDist(A[i], A[j]);
            }
        }
        
        for (int i = 1; i < 1 << N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    int state = i - (1 << j);
                    
                    if (state == 0) {
                        dp[i][j] = A[j].length();
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                        
                        for (int k = 0; k < N; k++) {
                            if ((state & (1 << k)) > 0) {
                                int sum = dp[state][k] + graph[j][k];
                                
                                if (sum < dp[i][j]) {
                                    dp[i][j] = sum;
                                    path[i][j] = k;
                                }
                            }
                        }
                    }
                    
                    if (i == (1 << N) - 1 && dp[i][j] < min) {
                        min = dp[i][j];
                        idx = j;
                    }
                }
            }
        }
        
        int state = (1 << N) - 1;
        String str = "";
        
        for (int i = 0; i < N - 1; i++) {
            int next = path[state][idx];
            str += A[idx].substring(0, graph[idx][next]);
            state = state - (1 << idx);
            idx = next;
        }
        
        str += A[idx];
        return str;
    }
    
    private int getDist(String a, String b) {
        int M = a.length();
        int N = b.length();
        
        for (int i = N; i > 0; i--) {
            if (a.endsWith(b.substring(0, i))) {
                return M - i;
            }
        }
        
        return M;
    }
}
