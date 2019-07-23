class Solution {
    public int numSquarefulPerms(int[] A) {
        int N = A.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int[] res = new int[1];
        
        for (int i = 0; i < N; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            
            for (int j = i + 1; j < N; j++) {
                int sum = A[i] + A[j];
                int sqrt = (int) Math.sqrt(sum);
                
                if (sqrt * sqrt == sum) {
                    graph.putIfAbsent(A[i], new HashSet<>());
                    graph.putIfAbsent(A[j], new HashSet<>());
                    graph.get(A[i]).add(A[j]);
                    graph.get(A[j]).add(A[i]);
                }
            }
        }
        
        for (Integer i : graph.keySet()) {
            dfs(graph, count, i, N, res);
        }
        
        return res[0];
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> count, int i, int N, int[] res) {
        if (count.get(i) == 0) {
            return;
        }
        
        count.put(i, count.get(i) - 1);
        
        if (--N == 0) {
            res[0]++;
        } else {
            for (Integer j : graph.get(i)) {
                dfs(graph, count, j, N, res);
            }
        }
        
        count.put(i, count.get(i) + 1);
    }
}
