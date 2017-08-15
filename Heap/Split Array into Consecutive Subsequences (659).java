public class Solution {
    public boolean isPossible(int[] nums) {
        int count = 0;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        for (int num : nums) {
            int len = 1;
            
            if (map.containsKey(num - 1)) {
                Queue<Integer> queue = map.get(num - 1);
                len += queue.poll();
                
                if (len == 3) {
                    count--;
                }
                
                if (queue.isEmpty()) {
                    map.remove(num - 1);
                }
            } else {
                count++;
            }
            
            map.putIfAbsent(num, new PriorityQueue<>());
            map.get(num).add(len);
        }
        
        return count == 0;
    }
}
