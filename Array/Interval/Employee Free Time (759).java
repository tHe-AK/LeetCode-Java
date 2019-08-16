/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (List<Interval> employee : avails) {
            for (Interval interval : employee) {
                int start = interval.start;
                int end = interval.end;
                map.putIfAbsent(start, 0);
                map.putIfAbsent(end, 0);
                map.put(start, map.get(start) + 1);
                map.put(end, map.get(end) - 1);
            }
        }

        int start = -1;
        int sum = 0;

        for (Integer key : map.keySet()) {
            if (start != -1 && sum == 0) {
                res.add(new Interval(start, key));
            }

            sum += map.get(key);

            if (sum == 0) {
                start = key;
            }
        }

        return res;
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
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        
        for (List<Interval> list : schedule) {
            intervals.addAll(list);
        }
        
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Interval interval = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            
            if (interval.end < curr.start) {
                res.add(new Interval(interval.end, curr.start));
                interval = curr;
            } else {
                interval.end = Math.max(interval.end, curr.end);
            }
        }
        
        return res;
    }
}
