public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            throw new IllegalArgumentException();
        }
        
        int left = helper(image, 0, x, true, true);
        int right = helper(image, x, image.length - 1, true, false);
        int top = helper(image, 0, y, false, true);
        int bottom = helper(image, y, image[0].length - 1, false, false);
        
        return (right - left + 1) * (bottom - top + 1);
    }
    
    private int helper(char[][] image, int x, int y, boolean row, boolean left) {
        while (x <= y) {
            int mid = x + (y - x) / 2;
            
            boolean black = false;
            
            if (row) {
                for (int j = 0; j < image[0].length; j++) {
                    if (image[mid][j] == '1') {
                        black = true;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < image.length; i++) {
                    if (image[i][mid] == '1') {
                        black = true;
                        break;
                    }
                }
            }
            
            if ((black && left) || (!black && !left)) {
                y = mid - 1;
            } else {
                x = mid + 1;
            }
        }
        
        if (left) {
            return x;
        } else {
            return y;
        }
    }
}
