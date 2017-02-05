/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
class Event {
    public int time;
    public int type;

    public Event(int time, int type) {
        this.time = time;
        this.type = type;
    }
}
    
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<Event> list = new ArrayList<>();
        int count = 0;
        int result = 0;
        
        for (Interval i : intervals) {
            list.add(new Event(i.start, 0));
            list.add(new Event(i.end, 1));
        }
        
        list.sort((e1, e2) -> {
            if (e1.time != e2.time) {
                return e1.time - e2.time;
            } else {
                return e2.type - e1.type;
            }
        });
        
        for (Event e : list) {
            if (e.type == 0) {
                count++;
                result = Math.max(result, count);
            } else {
                count--;
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

