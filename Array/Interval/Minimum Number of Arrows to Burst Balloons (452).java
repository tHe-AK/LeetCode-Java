public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        
        int count = 1;
        int min = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (min >= points[i][0]) {
                min = Math.min(min, points[i][1]);
            } else {
                count++;
                min = points[i][1];
            }
        }
        
        return count;
    }
}
