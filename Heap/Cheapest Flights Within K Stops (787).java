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
