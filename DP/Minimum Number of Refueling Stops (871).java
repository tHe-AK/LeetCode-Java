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
        int step = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < stations.length; i++) {
            while (startFuel < stations[i][0] && !queue.isEmpty()) {
                startFuel += queue.poll();
                step++;
            }
            
            if (startFuel < stations[i][0]) {
                return -1;
            }
            
            queue.offer(stations[i][1]);
        }
        
        while (startFuel < target && !queue.isEmpty()) {
            startFuel += queue.poll();
            step++;
        }
        
        return startFuel < target ? -1 : step;
    }
}

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int step = 0;
        int i = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        while (startFuel < target) {
            while (i < stations.length && stations[i][0] <= startFuel) {
                queue.offer(stations[i][1]);
                i++;
            }
            
            if (queue.isEmpty()) {
                return -1;
            }
            
            startFuel += queue.poll();
            step++;
        }
        
        return step;
    }
}
