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
        int len = points.length;
        if (len <= 1) {
            return len;
        }
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            HashMap<Double, Integer> rec = new HashMap<Double, Integer>();
            int cur = 0;
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                Double key = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                if (key.equals(Double.NaN) == true) {
                    count++;
                    continue;
                }
                if (key.equals(-0.0) == true) {
                    key = 0.0;
                }
                if (key.equals(Double.NEGATIVE_INFINITY) == true) {
                    key = Double.POSITIVE_INFINITY;
                }
                
                int value = 1;
                if (rec.containsKey(key) == true) {
                    value += rec.get(key);
                }
                rec.put(key, value);
                
                cur = Math.max(cur, value);
            }
            max = Math.max(max, cur + count);
        }
        
        return max;
    }
}
