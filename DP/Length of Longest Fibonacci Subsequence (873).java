class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        
        for (int i : A) {
            set.add(i);
        }
        
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int prev = A[i];
                int curr = A[j];
                int next = prev + curr;
                int count = 0;
                
                while (set.contains(next)) {
                    count++;
                    prev = curr;
                    curr = next;
                    next = prev + curr;
                }
                
                max = Math.max(max, count);
            }
        }
        
        return max > 0 ? max + 2: 0;
    }
}

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < i; j++) {
                int k = map.getOrDefault(A[i] - A[j], -1);
                
                if (k >= 0 && k < j) {
                    dp[i][j] = dp[j][k] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
            
            map.put(A[i], i);
        }
        
        return max > 0 ? max + 2: 0;
    }
}
