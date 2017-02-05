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
            list.add(new Event(i.start, 1));
            list.add(new Event(i.end, 0));
        }
        
        list.sort((e1, e2) -> {
            if (e1.time != e2.time) {
                return e1.time - e2.time;
            } else {
                return e1.type - e2.type;
            }
        });
        
        for (Event e : list) {
            if (e.type == 1) {
                count++;
                result = Math.max(result, count);
            } else {
                count--;
            }
        }
        
        return result;
    }
}
