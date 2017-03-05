public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dist = getDist(points[i], points[j]);                
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                }
            }
            
            for (int val : map.values()) {
                result += val * (val - 1);
            }
        }
        
        return result;
    }
    
    private int getDist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        
        return dx * dx + dy * dy;
    }
}
