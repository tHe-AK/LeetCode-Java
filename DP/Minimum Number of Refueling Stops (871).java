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
        
        for (int i = 0; i < stations.length; i++) {
            while (fuel < stations[i][0] && !queue.isEmpty()) {
                fuel += queue.poll();
                step++;
            }
            
            if (fuel < stations[i][0]) {
                return -1;
            }
            
            queue.offer(stations[i][1]);
        }
        
        while (fuel < target && !queue.isEmpty()) {
            fuel += queue.poll();
            step++;
        }
        
        return fuel < target ? -1 : step;
    }
}
