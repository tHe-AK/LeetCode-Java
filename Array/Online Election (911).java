class TopVotedCandidate {
    private TreeMap<Integer, Integer> map;

    public TopVotedCandidate(int[] persons, int[] times) {
        map = new TreeMap<>();
        int N = persons.length;
        int[] count = new int[N + 1];
        int max = 0;
        int candidate = -1;
        
        for (int i = 0; i < N; i++) {
            int p = persons[i];
            
            if (++count[p] >= max) {
                max = count[p];
                candidate = p;
            }
            
            map.put(times[i], candidate);
        }
    }
    
    public int q(int t) {
        return map.get(map.floorKey(t));
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
