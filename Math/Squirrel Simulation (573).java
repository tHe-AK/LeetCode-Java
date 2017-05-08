public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nuts.length; i++) {
            int dist = getDist(nuts[i], tree);
            sum += dist * 2;
            min = Math.min(min, getDist(nuts[i], squirrel) - dist);
        }
        
        return sum + min;
    }
    
    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
