public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        return dfs(boxes, dp, 0, n - 1, 1);
    }

    private int dfs(int[] boxes, int[][][] dp, int i, int j, int k) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return k * k;
        } else if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        } else {
            int temp = dfs(boxes, dp, i + 1, j, 1) + k * k;

            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m]) {
                    temp = Math.max(temp, dfs(boxes, dp, i + 1, m - 1, 1) + dfs(boxes, dp, m, j, k + 1));
                }
            }

            dp[i][j][k] = temp;
            return temp;
        }
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
