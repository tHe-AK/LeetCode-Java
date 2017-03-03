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
    public int[] findRightInterval(Interval[] intervals) {
        int len = intervals.length;
        int[] result = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < len; i++) {
            map.put(intervals[i].start, i);
        }
        
        for (int i = 0; i < len; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            
            if (key == null) {
                result[i] = -1;
            } else {
                result[i] = map.get(key);
            }
        }
        
        return result;
    }
}
