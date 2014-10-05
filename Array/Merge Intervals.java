/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    private class MyComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException();
        }
        
        List<Interval> result = new ArrayList<Interval>();
        
        if (intervals.size() == 0) {
            return result;
        }
        
        Collections.sort(intervals, new MyComparator());
        Interval pre = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            
            if (pre.end < cur.start) {
                result.add(pre);
                pre = cur;
            }
            else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        
        result.add(pre);
        
        return result;
    }
}