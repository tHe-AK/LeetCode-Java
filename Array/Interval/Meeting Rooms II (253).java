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
        List<int[]> list = new ArrayList<>();
        int count = 0;
        int result = 0;
        
        for (Interval i : intervals) {
            list.add(new int[] { i.start, 1 });
            list.add(new int[] { i.end, -1});
        }
        
        list.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        for (int[] pair : list) {
            count += pair[1];
            result = Math.max(result, count);
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
    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        int result = 0;

        for (Interval i : intervals) {
            updateMap(map, i.start, 1);
            updateMap(map, i.end, -1);
        }
        
        for (int key : map.keySet()) {
            count += map.get(key);
            result = Math.max(result, count);
        }
        
        return result;
    }
    
    private void updateMap(TreeMap<Integer, Integer> map, int key, int diff) {
        int val = map.containsKey(key) ? map.get(key) : 0;
        map.put(key, val + diff);
    }
}

