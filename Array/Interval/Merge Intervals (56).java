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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        if (intervals.size() == 0) {
            return result;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        Interval pre = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            
            if (pre.end < curr.start) {
                result.add(pre);
                pre = curr;
            }
            else {
                pre.end = Math.max(pre.end, curr.end);
            }
        }
        
        result.add(pre);
        
        return result;
    }
}
