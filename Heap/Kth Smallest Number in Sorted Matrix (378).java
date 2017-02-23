public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] { matrix[0][0], 0, 0 });
        
        while (k-- > 1) {
            int[] peek = queue.poll();
            int i = peek[1];
            int j = peek[2];

            if (j == 0 && i + 1 < matrix.length) {
                queue.offer(new int[] { matrix[i + 1][j], i + 1, j });
            }
            
            if (j + 1 < matrix[0].length) {
                queue.offer(new int[] { matrix[i][j + 1], i, j + 1 });
            }
        }
        
        return queue.poll()[0];
    }
}
