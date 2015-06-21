class Point {
    int x;
    int height;
    boolean isStart;
    
    public Point(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}
    
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        
        ArrayList<Point> rec = new ArrayList<Point>();
        
        for (int[] building : buildings) {
            rec.add(new Point(building[0], building[2], true));
            rec.add(new Point(building[1], building[2], false));
        }
        
        Collections.sort(rec, new Comparator<Point>() {
            public int compare(Point point1, Point point2) {
                if (point1.x != point2.x) {
                    return point1.x - point2.x;
                }
                else if (point1.isStart && point2.isStart) {
                    return point2.height - point1.height;
                }
                else if (!point1.isStart && !point2.isStart) {
                    return point1.height - point2.height;
                }
                else {
                    return point1.isStart ? -1 : 1;
                }
            }
        });
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(rec.size(), Collections.reverseOrder());
        
        for (Point point : rec) {
            if (point.isStart) {
                if (queue.isEmpty() || point.height > queue.peek()) {
                    result.add(new int[] {point.x, point.height});
                }
                
                queue.offer(point.height);
            }
            else {
                queue.remove(point.height);
                
                if (queue.isEmpty()) {
                    result.add(new int[] {point.x, 0});
                }
                else if (point.height > queue.peek()) {
                    result.add(new int[] {point.x, queue.peek()});
                }
                else {
                }
            }
        }
        
        return result;
    }
}
