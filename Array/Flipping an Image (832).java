class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int N = A[0].length;
        
        for (int[] row : A) {
            for (int i = 0; i < (N + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[N - i - 1] ^ 1;
                row[N - i - 1] = temp;
            }
        }
        
        return A;
    }
}
