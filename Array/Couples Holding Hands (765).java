class Solution {
    public int minSwapsCouples(int[] row) {
        int N = row.length;
        int[] idx = new int[N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            idx[row[i]] = i;
        }
        
        for (int i = 0; i < N; i += 2) {
            while (Math.abs(row[i] - row[i + 1]) != 1 || Math.min(row[i], row[i + 1]) % 2 != 0) {
                int neighbor = row[i] + (row[i] % 2 == 0 ? 1 : -1);
                int j = idx[neighbor] + (idx[neighbor] % 2 == 0 ? 1 : -1);
                swap(row, i, j);
                count++;
            }
        }
        
        return count;
    }
    
    private void swap(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }
}
