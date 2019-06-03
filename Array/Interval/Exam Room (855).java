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
