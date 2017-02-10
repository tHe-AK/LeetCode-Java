public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] rec = new int[m * n];
        Arrays.fill(rec, -1);
        int count = 0;
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];
            int curr = getIdx(i, j, n);
            rec[curr] = curr;
            count++;
    
            for (int[] diff : delta) {
                int x = i + diff[0];
                int y = j + diff[1];
                        
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int neighbor = getIdx(x, y, n);
                            
                    if (rec[neighbor] != -1) {
                        int root = neighbor;
        
                        while (root != rec[root]) {
                            root = rec[root];
                        }
                                                        
                        rec[neighbor] = root;
                            
                        if (curr != root) {
                            rec[curr] = root;
                            curr = root;
                            count--;
                        }
                    }
                }
            }
            
            result.add(count);
        }
        
        return result;
    }
    
    private int getIdx(int i, int j, int col) {
        return i * col + j;
    }
}
