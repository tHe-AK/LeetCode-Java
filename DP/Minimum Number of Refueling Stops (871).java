class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        
        for (int i = 0; i < stations.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (stations[i][0] <= dp[j]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        
        return -1;
    }
}

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int fuel = startFuel;
        int step = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i <= stations.length; i++) {
            int val = i < stations.length ? stations[i][0] : target;
            
            while (fuel < val && !queue.isEmpty()) {
                fuel += queue.poll();
                step++;
            }
            
            if (fuel < val) {
                return -1;
            }
            
            if (i < stations.length) {
                queue.offer(stations[i][1]);
            }
        }
        
        return step;
    }
}
