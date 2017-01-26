public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] rec = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    rec[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    rec[i][j] = Math.max(1, rec[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    rec[i][j] = Math.max(1, rec[i + 1][j] - dungeon[i][j]);
                } else {
                    rec[i][j] = Math.min(Math.max(1, rec[i][j + 1] - dungeon[i][j]), Math.max(1, rec[i + 1][j] - dungeon[i][j]));
                }
            }
        }
        
        return rec[0][0];
    }
}
