/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Point {
    int val;
    boolean start;
    
    Point(int val, boolean start) {
        this.val = val;
        this.start = start;
    }
}

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null) {
            throw new IllegalArgumentException();
        }
        
        int size = airplanes.size();
        ArrayList<Point> rec = new ArrayList<Point>();
        int max = 0;
        int count = 0;
        
        for (Interval i : airplanes) {
            rec.add(new Point(i.start, true));
            rec.add(new Point(i.end, false));
        }

        Collections.sort(rec, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.val != p2.val) {
                    return p1.val - p2.val;
                }
                else if (p1.start == p2.start) {
                    return 0;
                }
                else {
                    return !p1.start && p2.start ? -1 : 1;
                }
            }
        });
        
        for (Point p : rec) {
            if (p.start) {
                count++;
                max = Math.max(max, count);
            }
            else {
                count--;
            }
        }
        
        return max;
    }
}
