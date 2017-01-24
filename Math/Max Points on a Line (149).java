/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> rec = new HashMap<>();
            int duplicate = 1;
            int curr = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                Double k = 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
                
                if (Double.isNaN(k)) {
                    duplicate++;
                } else {
                    if (k == -0.0) {
                        k = 0.0;
                    }
                    
                    if (k == Double.NEGATIVE_INFINITY) {
                        k = Double.POSITIVE_INFINITY;
                    }
                    
                    int count = rec.containsKey(k) ? rec.get(k) + 1 : 1;
                    rec.put(k, count);
                    curr = Math.max(curr, count);
                }
            }
            
            max = Math.max(max, curr + duplicate);
        }
        
        return max;
    }
}
