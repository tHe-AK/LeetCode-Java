class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        
		int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        dfs(image, sr, sc, image[sr][sc], newColor, delta);
        
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int oldColor, int newColor, int[][] delta) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }
        
        image[i][j] = newColor;
        
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            dfs(image, x, y, oldColor, newColor, delta);
        }
    }
}
