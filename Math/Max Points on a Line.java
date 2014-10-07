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
        if (points == null) {
            throw new IllegalArgumentException();
        }
        
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> rec = new HashMap<Double, Integer>();
            int duplicate = 1;
            int cur = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                Double k = 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
                
                if (Double.isNaN(k)) {
                    duplicate++;
                    continue;
                }
                
                if (k == -0.0) {
                    k = 0.0;
                }
                
                if (k == Double.NEGATIVE_INFINITY) {
                    k = Double.POSITIVE_INFINITY;
                }
                
                if (rec.containsKey(k)) {
                    rec.put(k, rec.get(k) + 1);
                }
                else {
                    rec.put(k, 1);
                }
                
                cur = Math.max(cur, rec.get(k));
            }
            
            max = Math.max(max, cur + duplicate);
        }
        
        return max;
    }
}