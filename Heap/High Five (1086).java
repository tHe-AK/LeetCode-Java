class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>();
        
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            map.putIfAbsent(id, new PriorityQueue<>());
            Queue<Integer> pq = map.get(id);
            pq.offer(score);
            
            if (pq.size() > 5) {
                pq.poll();
            }
        }
        
        int[][] res = new int[map.size()][2];
        int i = 0;
        
        for (Integer id : map.keySet()) {
            res[i][0] = id;
            res[i][1] = (int) map.get(id).stream().mapToInt(a -> a).average().getAsDouble();
            i++;
        }
        
        return res;
    }
}
