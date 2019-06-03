class ExamRoom {
    private Set<Integer> set;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        set = new TreeSet<>();
    }
    
    public int seat() {
        int prev = -1;
        int idx = 0;
        int max = 0;
        
        if (!set.isEmpty()) {
            for (Integer i : set) {
                int dist = prev == -1 ? i - prev - 1 : (i - prev) / 2;

                if (dist > max) {
                    max = dist;
                    idx = prev == -1 ? 0 : prev + dist;
                }

                prev = i;
            }

            if (N - prev - 1 > max) {
                idx = N - 1;
            }
        }
        
        set.add(idx);
        return idx;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

class Interval {
    public int start;
    public int end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ExamRoom {
    private TreeSet<Interval> set;
    private Map<Integer, Interval[]> map;
    private int N;
    
    public ExamRoom(int N) {
        this.N = N;
        set = new TreeSet<>((a, b) -> {
            int dist1 = getDist(a);
            int dist2 = getDist(b);
        	
            if (dist1 == dist2) {
                return Integer.compare(a.start, b.start);
            }
        	
            return Integer.compare(dist2, dist1);
        });
        map = new HashMap<>();
        addInterval(-1, N);
    }
    
    public int seat() {
        Interval i = set.first();
        int idx = -1;
        
        if (i.start == -1) {
            idx = 0;
        } else if (i.end == N) {
            idx = N - 1;
        } else {
            idx = i.start + (i.end - i.start) / 2;
        }
        
        removeInterval(i);
        addInterval(i.start, idx);
        addInterval(idx, i.end);

        return idx;
    }
    
    public void leave(int p) {
        Interval[] intervals = map.get(p);
        removeInterval(intervals[0]);
        removeInterval(intervals[1]);
        addInterval(intervals[0].start, intervals[1].end);
    }
    
    private int getDist(Interval i) {
        if (i.start == -1) {
            return i.end;
        } else if (i.end == N) {
            return N - i.start - 1;
        } else {
            return (i.end - i.start) / 2;
        }
    }
    
    private void addInterval(int start, int end) {
        Interval i = new Interval(start, end);
        set.add(i);
        map.putIfAbsent(i.start, new Interval[2]);
        map.putIfAbsent(i.end, new Interval[2]);
        map.get(i.start)[1] = i;
        map.get(i.end)[0] = i;
    }
    
    private void removeInterval(Interval i) {
        set.remove(i);
        map.get(i.start)[1] = map.get(i.end)[0];
        map.get(i.end)[0] = map.get(i.start)[1];
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
