class Building {
    int x1;
    int x2;
    int height;
    
    Building(int x1, int x2, int height) {
        this.x1 = x1;
        this.x2 = x2;
        this.height = height;
    }
    
    Building(Building building) {
        this.x1 = building.x1;
        this.x2 = building.x2;
        this.height = building.height;
    }
}

class Point {
    int x;
    int height;
    boolean flag;
    
    Point(int x, int height, boolean flag) {
        this.x = x;
        this.height = height;
        this.flag = flag;
    }
}

public class Solution {
    private class SortComparator implements Comparator<Point> {
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }
    }
    
    private class PriorityQueueComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    
    public List<Building> buildingOutline(List<Building> input) {
        if (input == null || input.size() == 0) {
            throw new IllegalArgumentException();
        }
        
        List<Point> points = new ArrayList<Point>();
        
        for (int i = 0; i < input.size(); i++) {
            Building cur = input.get(i);
            Point x1 = new Point(cur.x1, cur.height, true);
            Point x2 = new Point(cur.x2, cur.height, false);
            points.add(x1);
            points.add(x2);
        }
        
        Collections.sort(points, new SortComparator());
        
        List<Building> result = new ArrayList<Building>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(points.size(), new PriorityQueueComparator());
        Building cur = null;
        
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            
            if (point.flag) {
                queue.add(point.height);
                
                if (queue.size() == 1) {
                    cur = new Building(point.x, 0, queue.peek());
                    continue;
                }
            }
            else {
                queue.remove(point.height);
                
                if (queue.isEmpty()) {
                    cur.x2 = point.x;
                    result.add(new Building(cur));
                    cur = null;
                    continue;
                }
            }
            
            if (queue.peek() != cur.height) {
                cur.x2 = point.x;
                result.add(new Building(cur));
                cur.x1 = point.x;
                cur.height = queue.peek();
            }
        }
        
        return result;
    }
}
