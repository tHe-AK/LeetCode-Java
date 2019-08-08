class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                queue.add(new int[] { dist, i, j }); 
            }
        }

        Set<Integer> visited = new HashSet<>();
        
        while (visited.size() < N) {
            int[] peek = queue.poll();
            int worker = peek[1];
            int bike = peek[2];
            
            if (res[worker] == -1 && !visited.contains(bike)) {   
                res[worker] = bike;
                visited.add(bike);
            }
        }
        
        return res;
    }
}
