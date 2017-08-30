public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        return dfs(boxes, dp, 0, n - 1, 0);
    }

    public int dfs(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        
        if (dp[l][r][k] > 0) {
            return dp[l][r][k];
        }
        
        while (l < r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        }
        
        dp[l][r][k] = (k + 1) * (k + 1) + dfs(boxes, dp, l + 1, r, 0);
        
        for (int i = l + 1; i <= r; i++) {
            if (boxes[i] == boxes[l]) {
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, dp, l + 1, i - 1, 0) + dfs(boxes, dp, i, r, k + 1));
            }
        }
        
        return dp[l][r][k];
    }
}

public class Solution {
    public int removeBoxes(int[] boxes) {
        Map<String, Integer> map = new HashMap<>();
        return remove(boxes, map);
    }
    
    private int remove(int[] boxes, Map<String, Integer> map) {
        String key = Arrays.toString(boxes);
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        if (boxes.length == 0) {
            return 0;
        }
        
        int res = 0;
        int i = 0;
        
        for (int j = 1; j <= boxes.length; j++) {
            if (j == boxes.length || boxes[j] != boxes[j - 1]) {
                int count = j - i;
                int[] newBoxes = new int[boxes.length - count];
                int idx = 0;
                
                for (int k = 0; k < boxes.length; k++) {
                    if (k < i || k >= j) {
                        newBoxes[idx++] = boxes[k];
                    }
                }
                
                res = Math.max(res, count * count + remove(newBoxes, map));
                i = j;
            }
        }
        
        map.put(key, res);
        return res;
    }
}
