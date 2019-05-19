class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int M = A.length;
        int N = A[0].length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) {
                    list1.add(i * N + j);
                }
                
                if (B[i][j] == 1) {
                    list2.add(i * N + j);
                }
            }
        }
        
        for (Integer i : list1) {
            for (Integer j : list2) {
                int diff = (j / N - i / N) * (2 * N - 1) + (j % N - i % N);
                int val = map.getOrDefault(diff, 0) + 1;
                count = Math.max(count, val);
                map.put(diff, val);
            }
        }
        
        return count;
    }
}
