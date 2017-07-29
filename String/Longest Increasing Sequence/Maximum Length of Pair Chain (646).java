public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        
        for (int[] pair : pairs) {
            if (end < pair[0]) {
                count++;
                end = pair[1];
            }
        }
        
        return count;
    }
}

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int max = 0;
        int[] dp = new int[pairs.length];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
