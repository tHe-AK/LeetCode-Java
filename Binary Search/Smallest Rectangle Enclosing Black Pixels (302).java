public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = binarySearch(image, 0, y, false, true);
        int right = binarySearch(image, y, image[0].length - 1, false, false);
        int top = binarySearch(image, 0, x, true, true);
        int bottom = binarySearch(image, x, image.length - 1, true, false);
        
        return (right - left) * (bottom - top);
    }
    
    private int binarySearch(char[][] image, int low, int high, boolean searchX, boolean searchLowerBound) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean isFound = false;
            
            if (searchX) {
                for (int j = 0; j < image[0].length; j++) {
                    if (image[mid][j] == '1') {
                        isFound = true;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < image.length; i++) {
                    if (image[i][mid] == '1') {
                        isFound = true;
                        break;
                    }
                }
            }

            if (isFound == searchLowerBound) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
