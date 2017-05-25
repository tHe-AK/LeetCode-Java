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
    public List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1.x != p2.x) {
                return Integer.compare(p1.x, p2.x);
            } else {
                return Integer.compare(p1.y, p2.y);
            }
        });
        
        int len = points.length;
        Stack<Point> hull = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (hull.size() >= 2 && getCrossProduct(hull.get(hull.size() - 2), hull.peek(), points[i]) > 0) {
                hull.pop();
            }
            
            hull.push(points[i]);
        }
        
        hull.pop();
        
        for (int i = len - 1; i >= 0; i--) {
            while (hull.size() >= 2 && getCrossProduct(hull.get(hull.size() - 2), hull.peek(), points[i]) > 0) {
                hull.pop();
            }
            
            hull.push(points[i]);
        }
        
        return new ArrayList<>(new HashSet<>(hull));
    }
    
    private int getCrossProduct(Point p, Point q, Point r) {
        return (p.x - q.x) * (r.y - q.y) - (r.x - q.x) * (p.y - q.y);
    }
}
