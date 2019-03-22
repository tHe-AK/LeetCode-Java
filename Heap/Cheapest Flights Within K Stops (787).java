// Bellman–Ford
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] record = new int[n];
        Arrays.fill(record, -1);
        record[src] = 0;
        
        for (int i = 0; i <= K; i++) {
            int[] temp = record.clone();
            
            for (int[] flight : flights) {
                int source = flight[0];
                int target = flight[1];
                int weight = flight[2];
                                
                if (temp[source] != -1 && (record[target] == -1 || temp[source] + weight < record[target])) {
                    record[target] = temp[source] + weight;
                }
            }
        }
        
        return record[dst];
    }
}

// Dijkstra
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((tuple1, tuple2) -> Integer.compare(tuple1[0], tuple2[0]));
        pq.offer(new int[] { 0, src, K + 1 });
        
        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            int price = peek[0];
            int city = peek[1];
            int k = peek[2];
            visited[city] = true;
            
            if (city == dst) {
                return price;
            }
            
            if (k > 0 && map.containsKey(city)) {
                for (int key : map.get(city).keySet()) {
                    if (!visited[key]) {
                        pq.offer(new int[] { price + map.get(city).get(key), key, k - 1 });
                    }
                }
            }
        }
        
        return -1;
    }
}
