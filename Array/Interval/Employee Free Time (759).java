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
    private class Pair {
        public int id;
        public int idx;

        public Pair(int id, int idx) {
            this.id = id;
            this.idx = idx;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(avails.get(a.id).get(a.idx).start, avails.get(b.id).get(b.idx).start));

        for (int i = 0; i < avails.size(); i++) {
            pq.add(new Pair(i, 0));
        }

        int end = -1;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            Interval interval = avails.get(pair.id).get(pair.idx);

            if (end != -1 && end < interval.start) {
                res.add(new Interval(end, interval.start));
            }

            end = Math.max(end, interval.end);

            if (pair.idx < avails.get(pair.id).size() - 1) {
                pair.idx++;
                pq.offer(pair);
            }

        }

        return res;
    }
}
