public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                }
                else if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                }
                else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                }
                else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
        
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}