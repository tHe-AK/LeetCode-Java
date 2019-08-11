class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, 0, 0 });
        Set<String> visited = new HashSet<>();
        
        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            int cost = peek[0];
            int count = peek[1];
            int mask = peek[2];
            
            if (count == workers.length) {
                return cost;
            }
            
            int[] worker = workers[count];
            
            if (!visited.add(count + " " + mask)) {
                continue;
            }
            
            for (int i = 0; i < bikes.length; i++) {
                int[] bike = bikes[i];
                
                if ((mask & (1 << i)) == 0) {
                    int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                    pq.offer(new int[] { cost + dist, count + 1, mask | (1 << i) });
                }
            }
            
            
        }
        
        return -1;
    }
}
