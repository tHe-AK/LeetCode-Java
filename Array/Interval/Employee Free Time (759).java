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
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
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
                start = -1;
            }

            sum += map.get(key);

            if (sum == 0) {
                start = key;
            }
        }

        return res;
    }
}
