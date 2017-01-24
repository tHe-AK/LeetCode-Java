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
            Map<Integer, Map<Integer, Integer>> rec = new HashMap<>();
            int duplicate = 1;
            int curr = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[j].x - points[i].x;
                int diffY = points[j].y - points[i].y;
                
                if (diffX == 0 && diffY == 0) {
                    duplicate++;
                } else {
                    int gcd = GCD(diffX, diffY);
                    int x = diffX / gcd;
                    int y = diffY / gcd;
                    
                    if (rec.containsKey(x)) {
                        if (rec.get(x).containsKey(y)) {
                            rec.get(x).put(y, rec.get(x).get(y) + 1);
                        } else {
                            rec.get(x).put(y, 1);
                        }
                    } else {
                        Map<Integer, Integer> val = new HashMap<>();
                        val.put(y, 1);
                        rec.put(x, val);
                    }
                    
                    curr = Math.max(curr, rec.get(x).get(y));
                }
            }
            
            max = Math.max(max, curr + duplicate);
        }
        
        return max;
    }
    
    private int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }
}

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
