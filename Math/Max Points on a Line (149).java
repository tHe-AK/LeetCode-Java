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
        int res = 0;
        
        for (int i = 0; i < len; i++) {
            int same = 1;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            
            for (int j = i + 1; j < len; j++) {
                int diffX = points[j].x - points[i].x;
                int diffY = points[j].y - points[i].y;
                
                if (diffX == 0 && diffY == 0) {
                    same++;
                } else {
                    int gcd = GCD(diffX, diffY);
                    String key = diffX / gcd + " " + diffY / gcd;
                    int val = map.getOrDefault(key, 0) + 1;
                    max = Math.max(max, val);
                    map.put(key, val);
                }
            }
            
            res = Math.max(res, max + same);
        }
        
        return res;
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
