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
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> starts = new ArrayList<>();
        int len = intervals.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int start = intervals[i].start;
            map.put(start, i);
            starts.add(start);
        }
        
        Collections.sort(starts);
        
        for (int i = 0; i < len; i++) {
            int end = intervals[i].end;
            int idx = Collections.binarySearch(starts, end);
            
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == len) {
                result[i] = -1;
            } else {
                result[i] = map.get(starts.get(idx));
            }
        }
        
        return result;
    }
}
