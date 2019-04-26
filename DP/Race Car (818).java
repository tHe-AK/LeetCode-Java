class Solution {
    public int racecar(int target) {
        int k = 31 - Integer.numberOfLeadingZeros(target + 1);
        
        if ((1 << k) - 1 == target) {
            return k;
        }
        
        int maxPos = (1 << (k + 1)) - 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 1 });
        Set<String> visited = new HashSet<>();
        visited.add("0 1");
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            
            for (int i = 0; i < size; i++) {
                int[] peek = queue.poll();
                int pos = peek[0];
                int speed = peek[1];
                int accPos = pos + speed;
                int accSpeed = speed << 1;
                
                if (accPos == target) {
                    return count;
                }
                
                helper(queue, visited, accPos, accSpeed, maxPos);
                int revSpeed = speed > 0 ? -1 : 1;
                helper(queue, visited, pos, revSpeed, maxPos);
            }
        }
        
        return -1;
    }
    
    private void helper(Queue<int[]> queue, Set<String> visited, int pos, int speed, int maxPos) {
        String str = pos + " " + speed;
        
        if (!visited.contains(str) && 0 < pos && pos <= maxPos) {
            visited.add(str);
            queue.offer(new int[] { pos, speed });
        }
    }
}

class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        
        for (int i = 1; i <= target; i++) {
            int k = 31 - Integer.numberOfLeadingZeros(i + 1);
            int low = (1 << k) - 1;
            int high = (1 << (k + 1)) - 1;
            
            if (low == i) {
                dp[i] = k;
                continue;
            }
            
            dp[i] = k + 2 + dp[high - i];
            
            for (int j = 0; j < k; j++) {
                dp[i] = Math.min(dp[i], k + j + 2 + dp[i - (low - ((1 << j) - 1))]);
            }
        }
        
        return dp[target];
    }
}
