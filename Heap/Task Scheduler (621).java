public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        
        for (int ct : count) {
            if (ct > 0) {
                queue.offer(ct);
            }
        }
        
        while (!queue.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            
            for (int i = 0; i <= n; i++) {
                if (!queue.isEmpty()) {
                    int peek = queue.poll();
                
                    if (peek > 1) {
                        next.add(peek - 1);
                    }
                }
                
                res++;
                
                if (queue.isEmpty() && next.isEmpty()) {
                    break;
                }
            }
            
            queue.addAll(next);
        }
        
        return res;
    }
}
