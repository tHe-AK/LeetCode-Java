class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        int[][] workers = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }
        
        Arrays.sort(workers, (a, b) -> Double.compare(1.0 * a[1] / a[0], 1.0 * b[1] / b[0]));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int sum = 0;
        double min = Integer.MAX_VALUE;

        for (int[] worker : workers) {
            queue.offer(worker[0]);
            sum += worker[0];
            
            if (queue.size() == K) {
                min = Math.min(min, 1.0 * worker[1] / worker[0] * sum);
                sum -= queue.poll();
            }
        }
        
        return min;
    }
}
