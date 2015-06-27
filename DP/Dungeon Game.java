public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            throw new IllegalArgumentException();
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] rec = new int[row][col];
        
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    rec[i][j] = Math.max(1 - dungeon[i][j], 1);
                }
                else if (i == row - 1) {
                    rec[i][j] = Math.max(rec[i][j + 1] - dungeon[i][j], 1);
                }
                else if (j == col - 1) {
                    rec[i][j] = Math.max(rec[i + 1][j] - dungeon[i][j], 1);
                }
                else {
                    rec[i][j] = Math.min(Math.max(rec[i][j + 1] - dungeon[i][j], 1), Math.max(rec[i + 1][j] - dungeon[i][j], 1));
                }
            }
        }
        
        return rec[0][0];
    }
}
