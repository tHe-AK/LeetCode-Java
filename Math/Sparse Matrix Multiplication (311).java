public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        int[][] C = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int k = 0; k < colA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < colB; j++) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        
        return C;   
    }
}

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        int[][] C = new int[rowA][colB];
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();

        for (int i = 0; i < rowA; i++) {
            for (int k = 0; k < colA; k++) {
                if (A[i][k] != 0) {
                    Map<Integer, Integer> val = mapA.containsKey(i) ? mapA.get(i) : new HashMap<>();
                    val.put(k, A[i][k]);
                    mapA.put(i, val);
                }
            }
        }
        
        for (int k = 0; k < colA; k++) {
            for (int j = 0; j < colB; j++) {
                if (B[k][j] != 0) {
                    Map<Integer, Integer> val = mapB.containsKey(k) ? mapB.get(k) : new HashMap<>();
                    val.put(j, B[k][j]);
                    mapB.put(k, val);
                }
            }
        }
        
        for (int i : mapA.keySet()) {
            for (int k : mapA.get(i).keySet()) {
                if (mapB.containsKey(k)) {
                    for (int j : mapB.get(k).keySet()) {
                        C[i][j] += mapA.get(i).get(k) * mapB.get(k).get(j);
                    }
                }
            }
        }
        
        return C;   
    }
}
