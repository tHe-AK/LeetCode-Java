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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException();
        }
        
        TreeMap<Integer, Integer> rec = new TreeMap<Integer, Integer>();
        
        for (Interval i : intervals) {
            if (rec.containsKey(i.start)) {
                rec.put(i.start, rec.get(i.start) + 1);
            } else {
                rec.put(i.start, 1);
            }
            
            if (rec.containsKey(i.end)) {
                rec.put(i.end, rec.get(i.end) - 1);
            } else {
                rec.put(i.end, -1);
            }
        }
        
        int max = 0;
        int cur = 0;
        
        for (Integer key : rec.keySet()) {
            max = Math.max(max, cur += rec.get(key));
        }
        
        return max;
    }
}
