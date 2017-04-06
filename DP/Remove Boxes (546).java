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
        
        while (l < r && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        
        dp[l][r][k] = dfs(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, dp, l, i, k + 1) + dfs(boxes, dp, i + 1, r - 1, 0));
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
        
        int result = 0;
        
        for (int i = 0; i < boxes.length; i++) {
            if (i == 0 || boxes[i] != boxes[i - 1]) {
                int j = i + 1;
                
                while (j < boxes.length && boxes[j] == boxes[i]) {
                    j++;
                }
                
                int count = j - i;
                int[] newboxes = new int[boxes.length - count];
                int idx = 0;
                
                for (int k = 0; k < boxes.length; k++) {
                    if (k < i || k >= j) {
                        newboxes[idx++] = boxes[k];
                    }
                }
                
                result = Math.max(result, remove(newboxes, map) + count * count);
            }
        }
        
        map.put(key, result);
        return result;
    }
}
