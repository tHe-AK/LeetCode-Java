class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int k = i; k < M; k++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                
                for (int j = 0; j < N; j++) {
                    if (k != i) {
                        matrix[i][j] += matrix[k][j];
                    }
                    
                    int val = map.getOrDefault(matrix[i][j] - target, 0);
                    count += val;
                    map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
                }
            }
        }
        
        return count;
    }
}
